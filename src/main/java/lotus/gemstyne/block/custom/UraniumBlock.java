package lotus.gemstyne.block.custom;

import lotus.gemstyne.block.GemstyneOreBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UraniumBlock extends ExperienceDroppingBlock {
    public UraniumBlock(Settings settings) {
        super(settings);
    }
    // <===== Used to cause damage when any player starts breaking anything Uranium related. =====>
    public void irradiatePlayer(PlayerEntity player, BlockState state) {
        if (state.isOf(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE)) { // Check to see what block is broken.
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 30, 1));
            // player.sendMessage(Text.literal("You have been slightly irradiated..."));
        } else if (state.isOf(GemstyneOreBlocks.RAW_URANIUM_BLOCK)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 1));
            // player.sendMessage(Text.literal("You have been moderately irradiated..."));
        } else if (state.isOf(GemstyneOreBlocks.URANIUM_BLOCK)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1));
            // player.sendMessage(Text.literal("You have been heavily irradiated..."));
        }
    }

    // <===== If anything other than the player steps on a UraniumBlock, then same logic. =====>
    public void irradiateEntity(LivingEntity entity, BlockState state) {

        if (state.isOf(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE)) { // Check to see what block is broken.
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 30, 1));
        } else if (state.isOf(GemstyneOreBlocks.RAW_URANIUM_BLOCK)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 1));
        } else if (state.isOf(GemstyneOreBlocks.URANIUM_BLOCK)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1));
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

        if (!world.isClient() && !player.isSpectator() && !player.isCreative()) {
            irradiatePlayer(player, state);
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        if (!world.isClient()) {
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isSpectator()) {irradiateEntity(livingEntity, state);}
            }
        }

    }
}
