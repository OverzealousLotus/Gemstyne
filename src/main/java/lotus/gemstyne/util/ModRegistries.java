package lotus.gemstyne.util;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneOreItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuff() {
        registerFuels();
    }


    private static void registerFuels() {
        Gemstyne.LOGGER.info("Registering fuel for... " + Gemstyne.MOD_ID);

        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(GemstyneOreItems.MORKITE, 2000);
    }
}
