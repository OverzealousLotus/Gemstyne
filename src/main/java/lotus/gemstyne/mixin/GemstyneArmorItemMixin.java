package lotus.gemstyne.mixin;

import de.dafuqs.additionalentityattributes.AdditionalEntityAttributes;
import lotus.gemstyne.armor.GemstyneArmorMaterials;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

/**
 * Mixin to handle various tasks related to {@link ArmorItem}.
 * <ul><=== Reference ===>
 * <li> <code>@Shadow</code> refers to anything, which is "shadowed" from the original class.</li>
 * <li> <code>@Final</code> Declares a shadowed field as "final", raising an error if it is written to.</li>
 * <li> <code>@Mutable</code> Declares a final field as "mutable", where modification is made to be intentional.</li>
 * <li> <code>@Inject</code> Injects a method into the target class.</li>
 * <li> <code>@Unique</code> Declares a unique method, where it cannot override a method with a similar name.</li>
 * </ul>
 */
@Mixin(ArmorItem.class)
public abstract class GemstyneArmorItemMixin {
    private GemstyneArmorItemMixin() {}

    @Inject(method = "method_56689", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Identifier;ofVanilla(Ljava/lang/String;)Lnet/minecraft/util/Identifier;"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void constructor(RegistryEntry<?> registryEntry, ArmorItem.Type type, CallbackInfoReturnable<AttributeModifiersComponent> cir, int i, float f, AttributeModifiersComponent.Builder builder, AttributeModifierSlot attributeModifierSlot) {
        var material = registryEntry.value();
        AttributeModifierSlot slot = AttributeModifierSlot.forEquipmentSlot(type.getEquipmentSlot());

        if(material.equals(GemstyneArmorMaterials.ALDUS)) {
            addBuilderAttribute(builder, GemstyneRegistry.id("aldus_health_bonus"), EntityAttributes.GENERIC_MAX_HEALTH, 1.0f,
                EntityAttributeModifier.Operation.ADD_VALUE, slot);
        } else if (material.equals(GemstyneArmorMaterials.RENDFIRE)) {
            addBuilderAttribute(builder, GemstyneRegistry.id("rendfire_lava_speed_bonus"), AdditionalEntityAttributes.LAVA_SPEED, 0.5f,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, slot);
            // gemstyne$attributeBuilder(uuid, AdditionalEntityAttributes.LAVA_SPEED, "Rendfire Lava Speed Bonus", 0.5f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        } else if (material.equals(GemstyneArmorMaterials.BRONZEMAIL)) {
            addBuilderAttribute(builder, GemstyneRegistry.id("lightweight_bonus"), EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.03f,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, slot);
            // gemstyne$attributeBuilder(uuid, EntityAttributes.GENERIC_MOVEMENT_SPEED, "Lightweight Bonus", 0.03f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        }

    }

    @Unique
    private static void addBuilderAttribute(AttributeModifiersComponent.Builder builder, Identifier identifier, RegistryEntry<EntityAttribute> attributeEntry, float value, EntityAttributeModifier.Operation operation, AttributeModifierSlot slot) {
        builder.add(attributeEntry, new EntityAttributeModifier(identifier, value, operation), slot);
    }
}
