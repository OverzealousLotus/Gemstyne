package lotus.gemstyne.item.equipment;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneItemHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class GemstyneCraftingItems {
    private static final Item IMBUED_ROD = GemstyneItemHandler.assignAndRegisterItem(
            new Item(new FabricItemSettings()),"imbued_rod");


    public static Item getImbuedRod() { return IMBUED_ROD; }


    public static void registerCraftingItems() {
        Gemstyne.LOGGER.info("Registering Crafting Items...");
    }
}
