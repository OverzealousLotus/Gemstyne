package lotus.gemstyne.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class DeepOre extends Block {
    private int currentStates;

    public DeepOre(Settings settings, int breakStates) {
        super(settings);
        this.currentStates = breakStates;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!world.isClient()) {  // Check to see if this event fired on the Client.
            if (this.currentStates <= 0) {  // Check to see if currentStates is less than or equal to 0.
                world.setBlockState(pos, newState);  // If so, destroy block.
            } else {
                currentStates -= 1;  // Otherwise, decrease and reset.
                dropStacks(state, world, pos);
                world.setBlockState(pos, state);
            }
        }
    }
}
