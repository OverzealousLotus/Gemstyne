package lotus.gemstyne.item.spelunking;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneItemHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public final class GemstyneMineralItems {
    public static final Item SALT = GemstyneItemHandler.assignAndRegisterItem(
            new Item(new FabricItemSettings()), "salt");


    public static void registerMineralItems() {
        Gemstyne.LOGGER.info("Registering Mineral Items...");
    }
}
