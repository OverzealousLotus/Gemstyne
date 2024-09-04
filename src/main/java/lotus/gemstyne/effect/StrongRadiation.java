package lotus.gemstyne.effect;

import lotus.gemstyne.damage.GemstyneDamageTypes;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class StrongRadiation extends StatusEffect {
    protected StrongRadiation(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        DamageSource damage = GemstyneRegistry.getDamageSource(entity.getWorld(), GemstyneDamageTypes.RADIATION);
        if (entity instanceof PlayerEntity player) {
            player.damage(damage, 1.0f);
            player.addExhaustion(0.010f * (amplifier + 1));
            player.addExperience(-1);
            player.setMovementSpeed(0.15f);
        } else {
            entity.damage(damage, 1.0f);
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int delay = 30 >> amplifier; // Bitwise shift to the right.
        if (delay > 0) { // Checks to see if delay is greater than zero.
            return duration % delay == 0; // If so, check to see if duration divided by delay results in no remainder.
        }
        return true; // Otherwise return true.
    }
}
