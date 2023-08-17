package lotus.gemstyne.util;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public final class GemstyneRegistries {
    public static void registerModStuff() {
        registerFuels();
    }


    private static void registerFuels() {
        Gemstyne.LOGGER.info("Registering fuel for... " + Gemstyne.MOD_ID);

        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(GemstyneOreItems.MORKITE, 2000);
        registry.add(GemstyneOreBlocks.MORKITE_BLOCK, 20000);
        registry.add(GemstyneFluids.LIQUID_MORKITE_BUCKET, 24000);
    }
}
