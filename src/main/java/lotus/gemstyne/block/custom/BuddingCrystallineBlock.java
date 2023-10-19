package lotus.gemstyne.block.custom;

import lotus.gemstyne.block.util.GemstyneGeodeSet;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

import java.util.Optional;

public class BuddingCrystallineBlock extends CrystallineBlock {
    private static final Direction[] DIRECTIONS = Direction.values();
    private final GemstyneGeodeSet buds;

    public BuddingCrystallineBlock(AbstractBlock.Settings settings, GemstyneGeodeSet buds) {
        super(settings);
        this.buds = buds;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) != 0) {
            return;
        }

        Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
        BlockPos oldBudPos = pos.offset(direction);
        BlockState oldBud = world.getBlockState(oldBudPos);
        Optional<Block> newBud = Optional.empty();

        if (BuddingAmethystBlock.canGrowIn(oldBud)) {
            newBud = Optional.of(this.buds.smallBud());
        } else if (oldBud.isOf(this.buds.smallBud()) && oldBud.get(CrystallineBlockBud.FACING) == direction) {
            newBud = Optional.of(this.buds.mediumBud());
        } else if (oldBud.isOf(this.buds.mediumBud()) && oldBud.get(CrystallineBlockBud.FACING) == direction) {
            newBud = Optional.of(this.buds.largeBud());
        } else if (oldBud.isOf(this.buds.largeBud()) && oldBud.get(CrystallineBlockBud.FACING) == direction) {
            newBud = Optional.of(this.buds.clusterBud());
        }

        if (newBud.isPresent()) {
            BlockState newBudState = newBud.get().getDefaultState()
                .with(CrystallineBlockBud.FACING, direction)
                .with(CrystallineBlockBud.WATERLOGGED, oldBud.getFluidState().getFluid() == Fluids.WATER);
            world.setBlockState(oldBudPos, newBudState);
        }
    }
}
