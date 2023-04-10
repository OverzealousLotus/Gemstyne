package lotus.gemstyne.util;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuff() {
        registerFuels();
    }


    private static void registerFuels() {
        Gemstyne.LOGGER.info("Registering fuel for... " + Gemstyne.MOD_ID);

        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ModItems.MORKITE_SHARD, 2000);
    }
}
