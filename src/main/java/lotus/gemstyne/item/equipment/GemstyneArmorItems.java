package lotus.gemstyne.item.equipment;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneArmorMaterials;
import lotus.gemstyne.item.GemstyneItemHandler;
import lotus.gemstyne.item.carriers.GemstyneArmorItemCarrier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;

public class GemstyneArmorItems {
    public static final GemstyneArmorItemCarrier ARMOR_ITEMS = new GemstyneArmorItemCarrier(
            // =====
            // <===== Aldus =====>
            // =====
            GemstyneItemHandler.registerArmor("aldus_helmet",
                    new ArmorItem(GemstyneArmorMaterials.ALDUS, ArmorItem.Type.HELMET,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("aldus_chestplate",
                    new ArmorItem(GemstyneArmorMaterials.ALDUS, ArmorItem.Type.CHESTPLATE,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("aldus_leggings",
                    new ArmorItem(GemstyneArmorMaterials.ALDUS, ArmorItem.Type.LEGGINGS,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("aldus_boots",
                    new ArmorItem(GemstyneArmorMaterials.ALDUS, ArmorItem.Type.BOOTS,
                            new FabricItemSettings())),

            // =====
            // <===== Bronzemail =====>
            // =====
            GemstyneItemHandler.registerArmor("bronzemail_helmet",
                    new ArmorItem(GemstyneArmorMaterials.BRONZEMAIL, ArmorItem.Type.HELMET,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("bronzemail_chestplate",
                    new ArmorItem(GemstyneArmorMaterials.BRONZEMAIL, ArmorItem.Type.CHESTPLATE,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("bronzemail_leggings",
                    new ArmorItem(GemstyneArmorMaterials.BRONZEMAIL, ArmorItem.Type.LEGGINGS,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("bronzemail_boots",
                    new ArmorItem(GemstyneArmorMaterials.BRONZEMAIL, ArmorItem.Type.BOOTS,
                            new FabricItemSettings())),

            // =====
            // <===== Bronzemail =====>
            // =====
            GemstyneItemHandler.registerArmor("bronzeplate_helmet",
                    new ArmorItem(GemstyneArmorMaterials.BRONZEPLATE, ArmorItem.Type.HELMET,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("bronzeplate_chestplate",
                    new ArmorItem(GemstyneArmorMaterials.BRONZEPLATE, ArmorItem.Type.CHESTPLATE,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("bronzeplate_leggings",
                    new ArmorItem(GemstyneArmorMaterials.BRONZEPLATE, ArmorItem.Type.LEGGINGS,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("bronzeplate_boots",
                    new ArmorItem(GemstyneArmorMaterials.BRONZEPLATE, ArmorItem.Type.BOOTS,
                            new FabricItemSettings())),

            // =====
            // <===== Rendfire =====>
            // =====
            GemstyneItemHandler.registerArmor("rendfire_helmet",
                    new ArmorItem(GemstyneArmorMaterials.RENDFIRE, ArmorItem.Type.HELMET,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("rendfire_chestplate",
                    new ArmorItem(GemstyneArmorMaterials.RENDFIRE, ArmorItem.Type.CHESTPLATE,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("rendfire_leggings",
                    new ArmorItem(GemstyneArmorMaterials.RENDFIRE, ArmorItem.Type.LEGGINGS,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerArmor("rendfire_boots",
                    new ArmorItem(GemstyneArmorMaterials.RENDFIRE, ArmorItem.Type.BOOTS,
                            new FabricItemSettings()))
    );


    public static void registerArmorItems() {
        Gemstyne.LOGGER.info("Registering Armor Items...");
    }
}
