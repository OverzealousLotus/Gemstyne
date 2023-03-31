package lotus.tutorialmod.event;

import lotus.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class UraniumBreakHandler implements AttackBlockCallback {
    // <===== Used to cause damage when any player starts breaking anything Uranium related. =====>

    public void irradiatePlayer(PlayerEntity player, BlockState state) {
        // Handle irradiation logic.
        if (state.isOf(ModBlocks.DEEPSLATE_URANIUM_ORE)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 30, 1));
            player.sendMessage(Text.literal("You have been slightly irradiated..."));
        } else if (state.isOf(ModBlocks.RAW_URANIUM_BLOCK)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 1));
            player.sendMessage(Text.literal("You have been moderately irradiated..."));
        } else if (state.isOf(ModBlocks.URANIUM_BLOCK)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1));
            player.sendMessage(Text.literal("You have been heavily irradiated..."));
        }
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

        if (state.isToolRequired() && !player.isSpectator() && !world.isClient()) {
            irradiatePlayer(player, state);
        }
        return ActionResult.PASS;
    }
}
