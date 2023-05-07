package lotus.gemstyne.item.spelunking;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneItemHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public final class GemstyneMineralItems {
    private static final Item SALT = GemstyneItemHandler.registerItem("salt",
            new Item(new FabricItemSettings()));


    public static Item getSalt() { return SALT; }


    public static void registerMineralItems() {
        Gemstyne.LOGGER.info("Registering Mineral Items...");
    }
}
