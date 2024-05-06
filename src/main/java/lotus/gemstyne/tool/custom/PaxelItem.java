package lotus.gemstyne.tool.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lotus.gemstyne.util.GemstyneBlockTags;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class PaxelItem extends MiningToolItem {
    protected static final Map<Block, Block> STRIPPED_BLOCKS = new ImmutableMap.Builder<Block, Block>().put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD).put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD).put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG).put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK).build();
    protected static final Map<Block, BlockState> PATH_STATES = Maps.newHashMap(new ImmutableMap.Builder<Block, BlockState>().put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.DIRT, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.PODZOL, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.MYCELIUM, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.getDefaultState()).build());

    public PaxelItem(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings) {
        super(attackDamage, attackSpeed, material, GemstyneBlockTags.getNeedsPaxel(), settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity playerEntity = context.getPlayer();
        BlockPos blockPos = context.getBlockPos();

        Optional<ActionResult> stripResult = getStripResult(context, world, blockPos, playerEntity);
        Optional<ActionResult> shovelResult = getShovelResult(context, world, blockPos, playerEntity);

        return stripResult.orElseGet(() -> shovelResult.orElse(ActionResult.PASS));
    }

    /**
     * Checks whether stripping has succeeded or not.
     * @param context {@link ItemUsageContext}
     * @param world {@link World}
     * @param blockPos {@link BlockPos}
     * @param player {@link PlayerEntity}
     * @return Returns either an empty, or {@link Optional} containing a successful {@link ActionResult}
     */
    private Optional<ActionResult> getStripResult(ItemUsageContext context, World world, BlockPos blockPos, @Nullable PlayerEntity player) {
        Optional<BlockState> tryStripResult = this.tryStrip(world, blockPos, player, world.getBlockState(blockPos));
        ItemStack itemStack = context.getStack();

        if (tryStripResult.isEmpty()) {
            return Optional.empty();
        }

        if (player instanceof ServerPlayerEntity serverPlayer) {
            Criteria.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, itemStack);
        }
        mutateWorld(context, world, blockPos, player, tryStripResult.get());
        return Optional.of(ActionResult.success(world.isClient));
    }

    private Optional<ActionResult> getShovelResult(ItemUsageContext context, World world, BlockPos blockPos, @Nullable PlayerEntity playerEntity) {
        if (context.getSide() != Direction.DOWN) {
            BlockState blockState = world.getBlockState(blockPos);
            BlockState blockState2 = PATH_STATES.get(blockState.getBlock());
            BlockState blockState3 = null;
            if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0f, 1.0f);
                blockState3 = blockState2;
            } else if (blockState.getBlock() instanceof CampfireBlock && Boolean.TRUE.equals(blockState.get(CampfireBlock.LIT))) {
                syncWorld(world, null, WorldEvents.FIRE_EXTINGUISHED, blockPos);
                CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
                blockState3 = blockState.with(CampfireBlock.LIT, false);
            }
            if (blockState3 != null) {
                mutateWorld(context, world, blockPos, playerEntity, blockState3);
                return Optional.of(ActionResult.success(world.isClient));
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    /**
     * Sets {@link BlockState}, then emits a {@link GameEvent}, and tries to cause damage to the player's tool.
     * @param context {@link ItemUsageContext}
     * @param world {@link World}
     * @param blockPos {@link BlockPos}
     * @param playerEntity {@link PlayerEntity}
     * @param state {@link BlockState}
     */
    private void mutateWorld(ItemUsageContext context, World world, BlockPos blockPos, PlayerEntity playerEntity, BlockState state) {
        if (!world.isClient()) {
            world.setBlockState(blockPos, state, Block.NOTIFY_ALL_AND_REDRAW);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, state));
            if (playerEntity != null)
                context.getStack().damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
        }
    }

    private void syncWorld(World world, @Nullable PlayerEntity player, int event, BlockPos blockPos) {
        if (!world.isClient()) world.syncWorldEvent(player, event, blockPos, 0);
    }

    /**
     * Tries to strip the targeted block.
     * @param world {@link World}
     * @param pos {@link BlockPos}
     * @param player {@link PlayerEntity}
     * @param state {@link BlockState}
     * @return Returns either an empty, or an {@link Optional} containing the stripped block.
     */
    private Optional<BlockState> tryStrip(World world, BlockPos pos, @Nullable PlayerEntity player, BlockState state) {
        Optional<BlockState> optional = this.getStrippedState(state);
        if (optional.isPresent()) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return optional;
        }
        Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(state);
        if (optional2.isPresent()) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            syncWorld(world, player, WorldEvents.BLOCK_SCRAPED, pos);
            return optional2;
        }
        Optional<BlockState> optional3 = Optional.ofNullable(HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().get(state.getBlock())).map(block -> block.getStateWithProperties(state));
        if (optional3.isPresent()) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
            syncWorld(world, player, WorldEvents.WAX_REMOVED, pos);
            return optional3;
        }
        return Optional.empty();
    }

    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable(STRIPPED_BLOCKS.get(state.getBlock())).map(block -> block.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
    }
}
