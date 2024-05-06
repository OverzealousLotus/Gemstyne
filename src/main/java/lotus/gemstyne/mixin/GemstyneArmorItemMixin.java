package lotus.gemstyne.mixin;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import de.dafuqs.additionalentityattributes.AdditionalEntityAttributes;
import lotus.gemstyne.armor.ArmorHandler;
import lotus.gemstyne.armor.GemstyneArmorMaterials;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.EnumMap;
import java.util.UUID;

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

    @Shadow
    @Final
    private static EnumMap<ArmorItem.Type, UUID> MODIFIERS;

    @Shadow
    @Final
    @Mutable
    private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void constructor(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings, CallbackInfo ci) {
        UUID uuid = MODIFIERS.get(type);

        if(material == GemstyneArmorMaterials.ALDUS) {
            gemstyne$attributeBuilder(uuid, EntityAttributes.GENERIC_MAX_HEALTH, "Aldus Health Bonus", 1.0f, EntityAttributeModifier.Operation.ADDITION);
        } else if (material == GemstyneArmorMaterials.RENDFIRE) {
            gemstyne$attributeBuilder(uuid, AdditionalEntityAttributes.LAVA_SPEED, "Rendfire Lava Speed Bonus", 0.5f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        } else if (material == GemstyneArmorMaterials.BRONZEMAIL) {
            gemstyne$attributeBuilder(uuid, EntityAttributes.GENERIC_MOVEMENT_SPEED, "Lightweight Bonus", 0.03f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        }

    }

    /**
     * Unique method to handle applying bonuses to {@link ArmorHandler}
     * @param uuid Unique Identifier
     * @param attributes The attribute itself. See {@link EntityAttributes}
     * @param name Name of attribute
     * @param value Value of modifier.
     * @param operation Type of Attribute Modifier Operation. For example, addition.
     */
    @Unique
    private void gemstyne$attributeBuilder(UUID uuid, EntityAttribute attributes, String name, float value, EntityAttributeModifier.Operation operation) {
        var map = HashMultimap.create(this.attributeModifiers);
        map.put(attributes, new EntityAttributeModifier(uuid, name, value, operation));
        this.attributeModifiers = map;
    }
}
