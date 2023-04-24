package lotus.gemstyne.data.models;

import lotus.gemstyne.item.GemstyneArmorItems;
import lotus.gemstyne.item.GemstyneToolItems;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class GemstyneEquipmentModels {


    public static void generateEquipmentItemModels(ItemModelGenerator itemModelGenerator) {
        // ======
        // <===== Armor =====>
        // ======
        itemModelGenerator.register(GemstyneArmorItems.RENDFIRE_HELMET, Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.RENDFIRE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.RENDFIRE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.RENDFIRE_BOOTS, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ALDUS_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ALDUS_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ALDUS_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ALDUS_BOOTS);

        // ======
        // <===== Tools =====>
        // ======
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_HOE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.ALDUS_AXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS_HOE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS_SWORD, Models.HANDHELD);
    }
}
