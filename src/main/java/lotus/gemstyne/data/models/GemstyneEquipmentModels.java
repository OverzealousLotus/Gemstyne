package lotus.gemstyne.data.models;

import lotus.gemstyne.item.equipment.GemstyneArmorItems;
import lotus.gemstyne.item.equipment.GemstyneToolItems;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class GemstyneEquipmentModels {


    public static void generateEquipmentItemModels(ItemModelGenerator itemModelGenerator) {
        // ======
        // <===== Armor =====>
        // ======
        itemModelGenerator.register(GemstyneArmorItems.ARMOR_ITEMS.rendfireHelmet(), Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.ARMOR_ITEMS.rendfireChestplate(), Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.ARMOR_ITEMS.rendfireLeggings(), Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.ARMOR_ITEMS.rendfireBoots(), Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ARMOR_ITEMS.aldusHelmet());
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ARMOR_ITEMS.aldusChestplate());
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ARMOR_ITEMS.aldusLeggings());
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ARMOR_ITEMS.aldusBoots());

        // ======
        // <===== Tools =====>
        // ======
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfireAxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfireHoe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfirePickaxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfireShovel(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfireSword(), Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusAxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusHoe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusPickaxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusShovel(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusSword(), Models.HANDHELD);
    }
}
