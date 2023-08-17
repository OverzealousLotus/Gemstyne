package lotus.gemstyne.block.custom;

import com.google.common.collect.ImmutableList;
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

    /* Buds refers to the four possible states a crystalline bud can have.
    This is: Small, Medium, Large, and Cluster. Computers start counting from zero, so:
    buds.get(0) = small,
    buds.get(1) = medium,
    etc
     */
    private final ImmutableList<Block> buds;

    public BuddingCrystallineBlock(AbstractBlock.Settings settings, ImmutableList<Block> buds) {
        super(settings);
        this.buds = buds;
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
            block = buds.get(0);
        } else if (blockState.isOf(buds.get(0)) && blockState.get(CrystallineBlockBud.FACING) == direction) {
            block = buds.get(1);
        } else if (blockState.isOf(buds.get(1)) && blockState.get(CrystallineBlockBud.FACING) == direction) {
            block = buds.get(2);
        } else if (blockState.isOf(buds.get(2)) && blockState.get(CrystallineBlockBud.FACING) == direction) {
            block = buds.get(3);
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
