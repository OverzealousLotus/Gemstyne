package lotus.gemstyne.item.spelunking;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.item.Item;

public final class GemstyneMineralItems {
    public static final Item SALT = GemstyneRegistry.designateItem("salt",
            new OwoItemSettings());


    public static void registerMineralItems() {
        Gemstyne.LOGGER.info("Registering Mineral Items...");
    }
}
