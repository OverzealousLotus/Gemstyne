package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.equipment.GemstyneArmorItems;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import lotus.gemstyne.item.equipment.GemstyneToolItems;
import lotus.gemstyne.item.spelunking.GemstyneMineralItems;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class GemstyneItemHandler {
    /** Registered mod items. Block items are registered differently. Check block/GemstyneBlocks
    * to configure things, check data */

    // =====
    // <===== Assistive Methods =====>
    // =====
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name), item);
    }

    public static ArmorItem registerArmor(String name, ArmorItem item) {
        return Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Gemstyne.LOGGER.info("Registering items for " + Gemstyne.MOD_ID + "!");
        GemstyneGearItems.registerGearItems();
        GemstyneOreItems.registerOreItems();
        GemstyneMineralItems.registerMineralItems();
        GemstyneCraftingItems.registerCraftingItems();
        GemstyneArmorItems.registerArmorItems();
        GemstyneToolItems.registerToolItems();
        Gemstyne.LOGGER.info("Registration of " + Gemstyne.MOD_ID + " complete!");
    }
}
