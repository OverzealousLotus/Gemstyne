package lotus.gemstyne.block.custom;

import lotus.gemstyne.block.entity.RichOreBlockEntity;
import lotus.gemstyne.block.entity.GemstyneBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * RichOre is a type of {@link Block}, wrapped in a {@link BlockEntity} with a set amount of times
 * it can be mined, before being destroyed. This increases the harvest, but the time to collect
 * is the same. However, it removes the need to search for other veins, until they are broken.
 */
public class RichOre extends BlockWithEntity implements BlockEntityProvider {
    private final int breakStates;

    /**
     *
     * @param settings {@link net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings}
     * @param breakStates The amount of times this can be mined before being destroyed.
     */
    public RichOre(Settings settings, int breakStates) {
        super(settings);
        this.breakStates = breakStates;
    }

    /**
     * <code>getBlockEntity</code> Can return a null value.
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
        if (!world.isClient()) {
            final RichOreBlockEntity entity = getDeepOreEntity(world, pos);

            if (entity.isNew()) {
                entity.setCurrentStates(breakStates - 1);
                entity.setNewness(false);
            }
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
        if (!world.isClient()) {  // Check to see if this event fired on the Client.
            final RichOreBlockEntity entity = getDeepOreEntity(world, pos);

            if (entity.getCurrentStates() <= 0) {  // Check to see if currentStates is less than or equal to 0.
                world.setBlockState(pos, newState);  // If so, destroy block.
            } else {
                entity.setCurrentStates(entity.getCurrentStates() - 1);  // Otherwise, decrease and reset.
                dropStacks(state, world, pos);
                world.setBlockState(pos, state);
            }
        }
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
