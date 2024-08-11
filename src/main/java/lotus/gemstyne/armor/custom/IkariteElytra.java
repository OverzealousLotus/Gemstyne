package lotus.gemstyne.armor.custom;

import lotus.gemstyne.armor.ArmorHandler;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public class IkariteElytra extends ElytraItem implements FabricElytraItem {
    public IkariteElytra(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ItemHandler.IKARITE);
    }

    public static boolean isWearing(LivingEntity entity) {
        var stack = entity.getEquippedStack(EquipmentSlot.CHEST);
        return stack.isOf(ArmorHandler.IKARITE_ELYTRA) && isUsable(stack);
    }

    @Override
    public void doVanillaElytraTick(LivingEntity entity, ItemStack chestStack) {
        int nextRoll = entity.getFallFlyingTicks() + 1;

        if (!entity.getWorld().isClient && nextRoll % 10 == 0) {
            if ((nextRoll / 10) % 4 == 0) {
                chestStack.damage(1, entity, EquipmentSlot.CHEST);
            }

            entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
        }
    }

    public static AttributeModifiersComponent createDefaultAttributes() {
        var builder = AttributeModifiersComponent.builder();
        var armor = new EntityAttributeModifier(GemstyneRegistry.id("ikarite_elytra_armor_protection"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE);
        var toughness = new EntityAttributeModifier(GemstyneRegistry.id("ikarite_elytra_armor_toughness"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE);
        var speed = new EntityAttributeModifier(GemstyneRegistry.id("ikarite_elytra_speed_bonus"), 0.08F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        builder.add(EntityAttributes.GENERIC_ARMOR, armor, AttributeModifierSlot.CHEST);
        builder.add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, toughness, AttributeModifierSlot.CHEST);
        builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, speed, AttributeModifierSlot.CHEST);
        return builder.build();
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltips.gemstyne.ikarite_elytra"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}