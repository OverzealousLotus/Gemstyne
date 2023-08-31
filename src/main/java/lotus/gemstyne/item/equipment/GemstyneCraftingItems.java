package lotus.gemstyne.item.equipment;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.item.Item;

public class GemstyneCraftingItems {
    private GemstyneCraftingItems() {}
    
    private static final Item IMBUED_ROD = GemstyneRegistry.designateItem("imbued_rod",
            new OwoItemSettings());


    public static Item getImbuedRod() { return IMBUED_ROD; }


    public static void registerCraftingItems() {
        Gemstyne.LOGGER.info("Registering Crafting Items...");
    }
}
