package lotus.gemstyne.event;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class UraniumBreakHandler implements AttackBlockCallback {
    // <===== Used to cause damage when any player starts breaking anything Uranium related. =====>

    public void irradiatePlayer(PlayerEntity player, BlockState state) {
        // Handle irradiation logic.
    }


    @Override
    public ActionResult interact
            (PlayerEntity player,
                                 World world,
                                 Hand hand,
                                 BlockPos pos,
                                 Direction direction
            ) {
        BlockState state = world.getBlockState(pos);

        if (state.isToolRequired() && !player.isSpectator() && !player.isCreative() && !world.isClient()) {
            irradiatePlayer(player, state);
        }
        return ActionResult.PASS;
    }
}
