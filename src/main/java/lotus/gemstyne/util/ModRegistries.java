package lotus.gemstyne.util;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.GemstyneOreItems;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public final class ModRegistries {
    public static void registerModStuff() {
        registerFuels();
    }


    private static void registerFuels() {
        Gemstyne.LOGGER.info("Registering fuel for... " + Gemstyne.MOD_ID);

        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(GemstyneOreItems.getMorkite(), 2000);
        registry.add(GemstyneOreBlocks.MORKITE_BLOCK, 20000);
        registry.add(ModItems.LIQUID_MORKITE_BUCKET, 24000);
    }
}
