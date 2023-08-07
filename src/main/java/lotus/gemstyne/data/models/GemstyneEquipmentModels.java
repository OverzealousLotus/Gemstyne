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
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.aldusHelmet());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.aldusChestplate());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.aldusLeggings());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.aldusBoots());

        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailHelmet());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailChestplate());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailLeggings());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailBoots());

        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateHelmet());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateChestplate());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateLeggings());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateBoots());

        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.rendfireHelmet());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.rendfireChestplate());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.rendfireLeggings());
        itemModelGenerator.registerArmor(GemstyneArmorItems.ARMOR_ITEMS.rendfireBoots());



        // ======
        // <===== Tools =====>
        // ======
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfireAxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfireHoe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfirePickaxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfireShovel(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.rendfireSword(), Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.bronzeAxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.bronzeHoe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.bronzePickaxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.bronzeShovel(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.bronzeSword(), Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusAxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusHoe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusPickaxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusShovel(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.TOOL_ITEMS.aldusSword(), Models.HANDHELD);
    }
}
