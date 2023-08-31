package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import lotus.gemstyne.tool.GemstyneToolItems;
import lotus.gemstyne.item.spelunking.GemstyneMineralItems;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;

/**
 * <h3>GemstyneItemHandler</h3>
 * <code>GemstyneItemHandler</code> is used to wrap all of Gemstyne's items together.
 */
public final class GemstyneItemHandler {
    private GemstyneItemHandler() {}
    
    public static void registerGemstyneItems() {
        Gemstyne.LOGGER.info("Registering Items for " + Gemstyne.MOD_ID + "!");
        GemstyneGearItems.registerGearItems();
        GemstyneOreItems.registerOreItems();
        GemstyneMineralItems.registerMineralItems();
        GemstyneCraftingItems.registerCraftingItems();
        GemstyneArmorItems.registerArmorItems();
        GemstyneToolItems.registerToolItems();
        Gemstyne.LOGGER.info("Successfully registered Items for " + Gemstyne.MOD_ID + "!");
    }
}
