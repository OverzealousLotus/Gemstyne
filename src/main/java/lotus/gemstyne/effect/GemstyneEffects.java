package lotus.gemstyne.effect;

import lotus.gemstyne.Gemstyne;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class GemstyneEffects {
    private GemstyneEffects() {}
    
    public static final StatusEffect IRRADIATE = registerStatusEffect("irradiate");

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Gemstyne.MOD_ID, name),
                new IrradiateEffect(StatusEffectCategory.HARMFUL, 4425031));
    }

    public static void registerEffects() {
        Gemstyne.LOGGER.info("Registering Status Effects...");
    }
}
