package lotus.gemstyne.block.custom;

import lotus.gemstyne.block.GemstyneOreBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BuddingCrystallineBlock extends CrystallineBlock {
    public static final int GROW_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();
    public BuddingCrystallineBlock(AbstractBlock.Settings settings) {
        super(settings);
    }


    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) != 0) {
            return;
        }
        Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
        BlockPos position = pos.offset(direction);
        BlockState blockState = world.getBlockState(position);
        Block block = null;
        if (BuddingCrystallineBlock.canGrowIn(blockState)) {
            block = GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud();
        } else if (blockState.isOf(GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud()) && blockState.get(CrystallineBlockBud.FACING) == direction) {
            block = GemstyneOreBlocks.GEODE_BLOCKS.mediumIkariteBud();
        } else if (blockState.isOf(GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud()) && blockState.get(CrystallineBlockBud.FACING) == direction) {
            block = GemstyneOreBlocks.GEODE_BLOCKS.largeIkariteBud();
        } else if (blockState.isOf(GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud()) && blockState.get(CrystallineBlockBud.FACING) == direction) {
            block = GemstyneOreBlocks.GEODE_BLOCKS.ikariteCluster();
        }
        if (block != null) {
            BlockState blockState2 = (BlockState)((BlockState)block.getDefaultState().with(CrystallineBlockBud.FACING, direction)).with(CrystallineBlockBud.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
            world.setBlockState(position, blockState2);
        }
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }
}
