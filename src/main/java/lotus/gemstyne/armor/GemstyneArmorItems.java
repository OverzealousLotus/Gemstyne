package lotus.gemstyne.armor;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class GemstyneArmorItems {
    public static final GemstyneArmorSet ALDUS = new GemstyneArmorSet(new FabricItemSettings(),
            "aldus", GemstyneArmorMaterials.ALDUS, GemstyneOreItems.ALDUS.INGOT);
    public static final GemstyneArmorSet BRONZEMAIL = new GemstyneArmorSet(new FabricItemSettings(),
            "bronzemail", GemstyneArmorMaterials.BRONZEMAIL, GemstyneOreItems.BRONZE.CHAIN);
    public static final GemstyneArmorSet BRONZEPLATE = new GemstyneArmorSet(new FabricItemSettings(),
            "bronzeplate", GemstyneArmorMaterials.BRONZEPLATE, GemstyneOreItems.BRONZE.INGOT);
    public static final GemstyneArmorSet RENDFIRE = new GemstyneArmorSet(new FabricItemSettings(),
            "rendfire", GemstyneArmorMaterials.RENDFIRE, GemstyneOreItems.FIRE_OPAL);


    public static void registerArmorItems() {
        Gemstyne.LOGGER.info("Registering Armor Items...");
    }
}
