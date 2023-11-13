package lotus.gemstyne.armor;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.ItemHandler;

public class GemstyneArmorItems {
    private GemstyneArmorItems() {}
    
    public static final GemstyneArmorSet ALDUS = new GemstyneArmorSet(new OwoItemSettings(),
            "aldus", GemstyneArmorMaterials.ALDUS, ItemHandler.ALDUS.ingot());
    public static final GemstyneArmorSet BRONZEMAIL = new GemstyneArmorSet(new OwoItemSettings(),
            "bronzemail", GemstyneArmorMaterials.BRONZEMAIL, ItemHandler.BRONZE.chain());
    public static final GemstyneArmorSet BRONZEPLATE = new GemstyneArmorSet(new OwoItemSettings(),
            "bronzeplate", GemstyneArmorMaterials.BRONZEPLATE, ItemHandler.BRONZE.ingot());
    public static final GemstyneArmorSet RENDFIRE = new GemstyneArmorSet(new OwoItemSettings().fireproof(),
            "rendfire", GemstyneArmorMaterials.RENDFIRE, ItemHandler.FIRE_OPAL);


    public static void registerArmorItems() {
        Gemstyne.LOGGER.info("Registering Armor Items...");
    }
}
