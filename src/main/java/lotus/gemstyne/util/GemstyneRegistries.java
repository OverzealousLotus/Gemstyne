package lotus.gemstyne.util;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public final class
GemstyneRegistries {
    private static void registerFuels() {
        Gemstyne.LOGGER.info("Registering Fuel Items for " + Gemstyne.MOD_ID + "...");

        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(GemstyneOreItems.MORKITE, 2000);
        registry.add(GemstyneOreBlocks.MORKITE_BLOCK, 20000);
        registry.add(GemstyneFluids.LIQUID_MORKITE_BUCKET, 24000);
    }

    public static void registerGemstyneMisc() {
        registerFuels();
    }
}
