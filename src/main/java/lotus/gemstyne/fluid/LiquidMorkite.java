package lotus.gemstyne.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class LiquidMorkite extends FlowableFluid {
    @Override
    public Fluid getFlowing() {
        return FluidHandler.FLOWING_LIQUID_MORKITE;
    }

    @Override
    public Fluid getStill() {
        return FluidHandler.STILL_LIQUID_MORKITE;
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    /*@Override
    protected int getFlowSpeed(WorldView world) {
        return world.getDimension().ultrawarm() ? 4 : 2;
    }*/

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return world.getDimension().ultrawarm() ? 1 : 2;
    }

    @Override
    public Item getBucketItem() {
        return FluidHandler.LIQUID_MORKITE_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public int getTickRate(WorldView world) {
        return world.getDimension().ultrawarm() ? 10 : 30;
    }

    @Override
    protected float getBlastResistance() {
        return 100f;
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return FluidHandler.LIQUID_MORKITE_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return 0;
    }

    public static class Flowing extends LiquidMorkite {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 4;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends LiquidMorkite {
        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 4;
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
