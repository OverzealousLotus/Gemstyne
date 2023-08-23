package lotus.gemstyne.data.models;

import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.tool.GemstyneToolItems;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class GemstyneEquipmentModels {


    public static void generateEquipmentItemModels(ItemModelGenerator itemModelGenerator) {
        // ======
        // <===== Armor =====>
        // ======
        itemModelGenerator.registerArmor(GemstyneArmorItems.ALDUS.HELMET);
        itemModelGenerator.registerArmor(GemstyneArmorItems.ALDUS.CHESTPLATE);
        itemModelGenerator.registerArmor(GemstyneArmorItems.ALDUS.LEGGINGS);
        itemModelGenerator.registerArmor(GemstyneArmorItems.ALDUS.BOOTS);

        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEMAIL.HELMET);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEMAIL.CHESTPLATE);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEMAIL.LEGGINGS);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEMAIL.BOOTS);

        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEPLATE.HELMET);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEPLATE.CHESTPLATE);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEPLATE.LEGGINGS);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEPLATE.BOOTS);

        itemModelGenerator.registerArmor(GemstyneArmorItems.RENDFIRE.HELMET);
        itemModelGenerator.registerArmor(GemstyneArmorItems.RENDFIRE.CHESTPLATE);
        itemModelGenerator.registerArmor(GemstyneArmorItems.RENDFIRE.LEGGINGS);
        itemModelGenerator.registerArmor(GemstyneArmorItems.RENDFIRE.BOOTS);



        // ======
        // <===== Tools =====>
        // ======
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.AXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.HOE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.SWORD, Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.BRONZE.AXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.BRONZE.HOE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.BRONZE.PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.BRONZE.SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.BRONZE.SWORD, Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.ALDUS.AXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS.HOE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS.PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS.SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS.SWORD, Models.HANDHELD);
    }
}
