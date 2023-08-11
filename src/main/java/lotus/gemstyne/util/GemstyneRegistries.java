package lotus.gemstyne.util;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public final class GemstyneRegistries {
    public static void registerModStuff() {
        registerFuels();
    }


    private static void registerFuels() {
        Gemstyne.LOGGER.info("Registering fuel for... " + Gemstyne.MOD_ID);

        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(GemstyneOreItems.ORE_ITEMS.morkite(), 2000);
        registry.add(GemstyneOreBlocks.ORE_BLOCKS.morkiteBlock(), 20000);
        registry.add(GemstyneGearItems.getLiquidMorkiteBucket(), 24000);
    }
}
