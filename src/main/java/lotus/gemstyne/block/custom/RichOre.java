package lotus.gemstyne.block.custom;

import lotus.gemstyne.block.entity.RichOreBlockEntity;
import lotus.gemstyne.block.entity.GemstyneBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * RichOre is a type of {@link Block}, wrapped in a {@link BlockEntity} with a set amount of times
 * it can be mined, before being destroyed. This increases the harvest, but the time to collect
 * is the same. However, it removes the need to search for other veins, until they are broken.
 */
public class RichOre extends BlockWithEntity implements BlockEntityProvider {
    private final int breakStates;
    private final UniformIntProvider experience;
    private final Item richDrop;

    /**
     *
     * @param settings {@link net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings}
     * @param breakStates The amount of times this can be mined before being destroyed.
     */
    public RichOre(Settings settings, int breakStates, UniformIntProvider experience, Item richDrop) {
        super(settings);
        this.breakStates = breakStates;
        this.experience = experience;
        this.richDrop = richDrop;
    }

    /**
     * {@code getBlockEntity} Can return a null value.
     * To handle this, it has been wrapped in an {@link Optional}.
     * While a simple assertion expression would suffice, {@link Optional} provides
     * greater readability.
     */
    private RichOreBlockEntity getDeepOreEntity(World world, BlockPos pos) {
        Optional<RichOreBlockEntity> entity = Optional.ofNullable((RichOreBlockEntity) world.getBlockEntity(pos));
        assert entity.isPresent();

        return entity.get();
    }

    /**
     * <p>In this context, <code>onBlockAdded</code> is used to set <code>breakStates</code>.</p>
     *
     * Without checking if <code>entity.isNew()</code>, <code>breakStates</code> is set each time
     * its {@link BlockState} changes, leaving us with an unbreakable block in the world.
     */
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (world.isClient()) return; // If event fired on Client, return early.

        final RichOreBlockEntity entity = getDeepOreEntity(world, pos);

        if (entity.isNew()) {
            entity.setCurrentStates(breakStates - 1, world, pos, state);
            entity.aged();
        }
    }

    /**
     * <code>onStateReplaced</code> is used to prevent a {@link RichOre} deposit from being broken,
     * before its criteria is met. The values it modifies are stored in its wrapper {@link RichOreBlockEntity}.
     * If they were stored inside itself, then all {@link RichOre} instances would share the same values
     * globally. However, each instance of a {@link BlockEntity} has its own separate variables from
     * one another.
     */
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (world.isClient()) return; // If event fired on Client, return early.`   `

        final RichOreBlockEntity entity = getDeepOreEntity(world, pos);

        if (entity.getCurrentStates() <= 0) {  // Check to see if currentStates is less than or equal to 0.
            world.setBlockState(pos, newState);  // If so, destroy block.
        } else {
            entity.setCurrentStates(entity.getCurrentStates() - 1, world, pos, state);  // Otherwise, decrease and reset.
            dropStack(world, pos, this.richDrop.getDefaultStack());
            // dropStacks(state, world, pos);
            world.setBlockState(pos, state);
        }
    }

    /**
     * Used to drop experience when broken.
     * @param state Current {@link BlockState}
     * @param world {@link World} where stacks drop.
     * @param pos Current {@link BlockPos}
     * @param tool Tool used to cause the drop.
     * @param dropExperience Whether experience should be dropped.
     */
    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        dropExperienceWhenMined(world, pos, tool, this.experience);
    }

    /**
     * Used to check if Player is in creative. If so, states are set to zero.
     * No Client check is provided, as this would break particle generation when the block
     * is broken. Particles are generated mostly on the Client's side.
     * @param world {@link World} where the break occurs.
     * @param pos Current {@link BlockPos}
     * @param state Current {@link BlockState}
     * @param player {@link PlayerEntity} who broke the block.
     */
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (player.isCreative()) getDeepOreEntity(world, pos).setCurrentStates(0, world, pos, state);

        super.onBreak(world, pos, state, player);
    }

    /* Block Entity Stuff! */
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RichOreBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, GemstyneBlockEntities.DEEP_ORE_BLOCK, RichOreBlockEntity::tick);
    }
}
