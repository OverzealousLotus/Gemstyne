package lotus.gemstyne.effect;

import lotus.gemstyne.Gemstyne;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GemstyneEffects {
    public static StatusEffect IRRADIATE;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Gemstyne.MOD_ID, name),
                new IrradiateEffect(StatusEffectCategory.HARMFUL, 4425031));
    }

    public static void RegisterEffects() {
        IRRADIATE = registerStatusEffect("irradiate");
    }
}
