package lotus.gemstyne.block.custom;

import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.util.GemstynePairs;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.chunk.ChunkStatus;

import java.util.Map;
import java.util.Optional;

public class BuddingCrystallineBlock extends CrystallineBlock {
    private static final Direction[] DIRECTIONS = Direction.values();
    private final Map<String, GemstynePairs.CrystallinePair> buds;

    public BuddingCrystallineBlock(AbstractBlock.Settings settings, Map<String, GemstynePairs.CrystallinePair> buds) {
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
            newBud = Optional.of(this.buds.get(GemstyneConstants.SMALL).block());
        } else if (oldBud.isOf(this.buds.get(GemstyneConstants.SMALL).block()) && oldBud.get(CrystallineBlockBud.FACING) == direction) {
            newBud = Optional.of(this.buds.get(GemstyneConstants.MEDIUM).block());
        } else if (oldBud.isOf(this.buds.get(GemstyneConstants.MEDIUM).block()) && oldBud.get(CrystallineBlockBud.FACING) == direction) {
            newBud = Optional.of(this.buds.get(GemstyneConstants.LARGE).block());
        } else if (oldBud.isOf(this.buds.get(GemstyneConstants.LARGE).block()) && oldBud.get(CrystallineBlockBud.FACING) == direction) {
            newBud = Optional.of(this.buds.get(GemstyneConstants.CLUSTER).block());
        }

        if (newBud.isPresent() && world.getChunk(pos).getStatus().isLaterThan(ChunkStatus.EMPTY)) {
            BlockState newBudState = newBud.get().getDefaultState()
                .with(CrystallineBlockBud.FACING, direction)
                .with(CrystallineBlockBud.WATERLOGGED, oldBud.getFluidState().getFluid() == Fluids.WATER);
            world.setBlockState(oldBudPos, newBudState);
        }
    }
}
