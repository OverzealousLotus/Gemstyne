package lotus.gemstyne.block.custom;

import lotus.gemstyne.block.util.GemstyneGeodeSet;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BuddingCrystallineBlock extends CrystallineBlock {
    public static final int GROW_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();
    private final GemstyneGeodeSet budList;

    public BuddingCrystallineBlock(AbstractBlock.Settings settings, GemstyneGeodeSet budList) {
        super(settings);
        this.budList = budList;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(GROW_CHANCE) != 0) {
            return;
        }
        Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        Block block = null;

        if (BuddingAmethystBlock.canGrowIn(blockState)) {
            block = this.budList.smallBud();
        } else if (blockState.isOf(this.budList.smallBud()) && blockState.get(CrystallineBlockBud.FACING) == direction) {
            block = this.budList.mediumBud();
        } else if (blockState.isOf(this.budList.mediumBud()) && blockState.get(CrystallineBlockBud.FACING) == direction) {
            block = this.budList.largeBud();
        } else if (blockState.isOf(this.budList.largeBud()) && blockState.get(CrystallineBlockBud.FACING) == direction) {
            block = this.budList.clusterBud();
        }

        // I no longer understand why logger is being ATTACCED
        if (block != null) {
            BlockState blockState2 = block.getDefaultState().with(CrystallineBlockBud.FACING, direction).with(CrystallineBlockBud.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
            world.setBlockState(blockPos, blockState2);
        }
    }
}
