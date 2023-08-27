package lotus.gemstyne.util;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;

public class GemstyneCreativeGroup {

    public static final OwoItemGroup GEMSTYNE = OwoItemGroup.builder(GemstyneRegistry.id("main"),
            () -> Icon.of(GemstyneOreItems.MOCHITE.crystal())).build();

    public static void registerGroups() {
        Gemstyne.LOGGER.info("Registering Gemstyne Group(s)...");
        GEMSTYNE.initialize();
        Gemstyne.LOGGER.info("Successfully registered Gemstyne Group(s)!");
    }


}
