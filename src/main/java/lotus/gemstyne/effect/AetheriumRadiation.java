package lotus.gemstyne.effect;

import lotus.gemstyne.entity.custom.AetherZombie;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class AetheriumRadiation extends StatusEffect {
    protected AetheriumRadiation(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            player.damage(entity.getDamageSources().magic(), 2.0f);
            player.addExhaustion(0.020f * (amplifier + 1));
            player.addExperience(-2);
            player.setMovementSpeed(0.15f);
        } else if (!(entity instanceof AetherZombie)){
            entity.damage(entity.getDamageSources().magic(), 4.0f);
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int delay = 120 >> amplifier; // Bitwise shift to the right.
        if (delay > 0) { // Checks to see if delay is greater than zero.
            return duration % delay == 0; // If so, check to see if duration divided by delay results in no remainder.
        }
        return true; // Otherwise return true.
    }
}
