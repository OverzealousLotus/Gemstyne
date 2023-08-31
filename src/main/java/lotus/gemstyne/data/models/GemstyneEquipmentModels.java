package lotus.gemstyne.data.models;

import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.tool.GemstyneToolItems;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class GemstyneEquipmentModels {
    private GemstyneEquipmentModels() {}

    public static void generateEquipmentItemModels(ItemModelGenerator itemModelGenerator) {
        // ======
        // <===== Armor =====>
        // ======
        itemModelGenerator.registerArmor(GemstyneArmorItems.ALDUS.helmet);
        itemModelGenerator.registerArmor(GemstyneArmorItems.ALDUS.chestplate);
        itemModelGenerator.registerArmor(GemstyneArmorItems.ALDUS.leggings);
        itemModelGenerator.registerArmor(GemstyneArmorItems.ALDUS.boots);

        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEMAIL.helmet);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEMAIL.chestplate);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEMAIL.leggings);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEMAIL.boots);

        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEPLATE.helmet);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEPLATE.chestplate);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEPLATE.leggings);
        itemModelGenerator.registerArmor(GemstyneArmorItems.BRONZEPLATE.boots);

        itemModelGenerator.registerArmor(GemstyneArmorItems.RENDFIRE.helmet);
        itemModelGenerator.registerArmor(GemstyneArmorItems.RENDFIRE.chestplate);
        itemModelGenerator.registerArmor(GemstyneArmorItems.RENDFIRE.leggings);
        itemModelGenerator.registerArmor(GemstyneArmorItems.RENDFIRE.boots);



        // ======
        // <===== Tools =====>
        // ======
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.axe, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.hoe, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.pickaxe, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.shovel, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE.sword, Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.BRONZE.axe, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.BRONZE.hoe, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.BRONZE.pickaxe, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.BRONZE.shovel, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.BRONZE.sword, Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.ALDUS.axe, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS.hoe, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS.pickaxe, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS.shovel, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS.sword, Models.HANDHELD);
    }
}
