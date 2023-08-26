package lotus.gemstyne.armor;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;

public class GemstyneArmorItems {
    public static final GemstyneArmorSet ALDUS = new GemstyneArmorSet(new OwoItemSettings(),
            "aldus", GemstyneArmorMaterials.ALDUS, GemstyneOreItems.ALDUS.INGOT);
    public static final GemstyneArmorSet BRONZEMAIL = new GemstyneArmorSet(new OwoItemSettings(),
            "bronzemail", GemstyneArmorMaterials.BRONZEMAIL, GemstyneOreItems.BRONZE.CHAIN);
    public static final GemstyneArmorSet BRONZEPLATE = new GemstyneArmorSet(new OwoItemSettings(),
            "bronzeplate", GemstyneArmorMaterials.BRONZEPLATE, GemstyneOreItems.BRONZE.INGOT);
    public static final GemstyneArmorSet RENDFIRE = new GemstyneArmorSet(new OwoItemSettings(),
            "rendfire", GemstyneArmorMaterials.RENDFIRE, GemstyneOreItems.FIRE_OPAL);


    public static void registerArmorItems() {
        Gemstyne.LOGGER.info("Registering Armor Items...");
    }
}
