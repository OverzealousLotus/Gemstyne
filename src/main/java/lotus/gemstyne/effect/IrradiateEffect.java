package lotus.gemstyne.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class IrradiateEffect extends StatusEffect {
    protected IrradiateEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                player.damage(entity.getDamageSources().magic(), 1.0f);
                player.addExhaustion(0.005f * (float) (amplifier + 1));
                player.setMovementSpeed(0.1f);
            } else {
                entity.damage(entity.getDamageSources().magic(), 1.0f);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
