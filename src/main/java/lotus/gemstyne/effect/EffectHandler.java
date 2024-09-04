package lotus.gemstyne.effect;

import lotus.gemstyne.Overwatch;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public final class EffectHandler {
    private EffectHandler() {}
    
    public static final RegistryEntry.Reference<StatusEffect> WEAK_RADIATION = registerStatusEffect("weak_radiation",
        new WeakRadiation(StatusEffectCategory.HARMFUL,0x00FF00)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.ofVanilla("effect.speed"),
                -0.1F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry.Reference<StatusEffect> STRONG_RADIATION = registerStatusEffect("strong_radiation",
        new StrongRadiation(StatusEffectCategory.HARMFUL, 0x0000FF)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.ofVanilla("effect.speed"),
                -0.15F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry.Reference<StatusEffect> AETHERIUM_RADIATION = registerStatusEffect("aetherium_radiation",
        new AetheriumRadiation(StatusEffectCategory.HARMFUL, 0x9900FF)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.ofVanilla("effect.speed"),
                -0.2F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static RegistryEntry.Reference<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, GemstyneRegistry.id(name), effect);
    }

    public static void registerEffects() {
        Overwatch.info("Registering Status Effects...");
        Overwatch.info("Successfully registered Status Effects!");
    }
}
