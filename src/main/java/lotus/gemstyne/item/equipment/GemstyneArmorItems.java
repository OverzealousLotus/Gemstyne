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
            GemstyneItemHandler.registerItem("aldus_helmet",
                    new ArmorItem(GemstyneArmorMaterials.ALDUS, ArmorItem.Type.HELMET,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("aldus_chestplate",
                    new ArmorItem(GemstyneArmorMaterials.ALDUS, ArmorItem.Type.CHESTPLATE,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("aldus_leggings",
                    new ArmorItem(GemstyneArmorMaterials.ALDUS, ArmorItem.Type.LEGGINGS,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("aldus_boots",
                    new ArmorItem(GemstyneArmorMaterials.ALDUS, ArmorItem.Type.BOOTS,
                            new FabricItemSettings())),

            // =====
            // <===== Rendfire =====>
            // =====
            GemstyneItemHandler.registerItem("rendfire_helmet",
                    new ArmorItem(GemstyneArmorMaterials.RENDFIRE, ArmorItem.Type.HELMET,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("rendfire_chestplate",
                    new ArmorItem(GemstyneArmorMaterials.RENDFIRE, ArmorItem.Type.CHESTPLATE,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("rendfire_leggings",
                    new ArmorItem(GemstyneArmorMaterials.RENDFIRE, ArmorItem.Type.LEGGINGS,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("rendfire_boots",
                    new ArmorItem(GemstyneArmorMaterials.RENDFIRE, ArmorItem.Type.BOOTS,
                            new FabricItemSettings()))
    );


    public static void registerArmorItems() {
        Gemstyne.LOGGER.info("Registering Armor Items...");
    }
}
