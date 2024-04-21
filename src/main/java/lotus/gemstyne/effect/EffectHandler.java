package lotus.gemstyne.effect;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class EffectHandler {
    private EffectHandler() {}
    
    public static final StatusEffect WEAK_RADIATION = registerStatusEffect("weak_radiation",
        new WeakRadiation(StatusEffectCategory.HARMFUL,0x00FF00));
    public static final StatusEffect STRONG_RADIATION = registerStatusEffect("strong_radiation",
        new StrongRadiation(StatusEffectCategory.HARMFUL, 0x0000FF));
    public static final StatusEffect AETHERIUM_RADIATION = registerStatusEffect("aetherium_radiation",
        new AetheriumRadiation(StatusEffectCategory.HARMFUL, 0x9900FF));

    public static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, GemstyneRegistry.id(name), effect);
    }

    public static void registerEffects() {
        Gemstyne.LOGGER.info("Registering Status Effects...");
    }
}
