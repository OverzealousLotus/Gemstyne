package lotus.gemstyne.data.models;

import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.tool.GemstyneToolItems;
import lotus.gemstyne.tool.GemstyneToolSet;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

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
        GemstyneToolItems.ALDUS.registerToolModels(itemModelGenerator);
        GemstyneToolItems.BRONZE.registerToolModels(itemModelGenerator);
        GemstyneToolItems.MUTALIUM.registerToolModels(itemModelGenerator);
        GemstyneToolItems.RENDFIRE.registerToolModels(itemModelGenerator);
    }
}
