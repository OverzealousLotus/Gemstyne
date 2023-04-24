package lotus.gemstyne.block.custom;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class CrimoniteBlock extends AfflictiveBlock {
    public CrimoniteBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void afflictPlayer(PlayerEntity player, BlockState state) {
        super.afflictPlayer(player, state);

        if (state.isOf(GemstyneOreBlocks.getNetherCrimoniteOre())) { // Check to see what block is broken.
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 60, 1));
            // player.sendMessage(Text.literal("You have been slightly irradiated..."));
        } else if (state.isOf(GemstyneOreBlocks.getRawCrimoniteBlock())) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 1));
            // player.sendMessage(Text.literal("You have been moderately irradiated..."));
        } else if (state.isOf(GemstyneDecorBlocks.getCrimoniteBlock())) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 120, 1));
            // player.sendMessage(Text.literal("You have been heavily irradiated..."));
        }
    }

    @Override
    protected void afflictEntity(LivingEntity entity, BlockState state) {

        if (state.isOf(GemstyneOreBlocks.getNetherCrimoniteOre())) { // Check to see what block is broken.
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 60, 1));
        } else if (state.isOf(GemstyneOreBlocks.getRawCrimoniteBlock())) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 1));
        } else if (state.isOf(GemstyneDecorBlocks.getCrimoniteBlock())) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 120, 1));
        }
    }
}
