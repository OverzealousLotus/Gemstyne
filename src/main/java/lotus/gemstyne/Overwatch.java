package lotus.gemstyne;

import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.block.entity.GemstyneBlockEntities;
import lotus.gemstyne.effect.EffectHandler;
import lotus.gemstyne.fluid.FluidHandler;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.loader.api.FabricLoader;

/**
 * <h2>Overwatch</h2>
 * Class used to log events, primarily registration and possibly other things in the future.
 */
public final class Overwatch {
    private Overwatch() {}

    /**
     * <code>registerDependencies</code> registers required resources for Gemstyne to function.
     * Dependencies in this context, refer to anything that needs to be registered before anything else.
     */
    public static void registerDependencies() {
        EffectHandler.registerEffects();
        FluidHandler.registerFluids();
        GemstyneCreativeGroup.registerGroups();
    }

    /**
     * <code>registerEssentials</code> registers the meat of Gemstyne, such as Items or Blocks. Without
     * them, we wouldn't have a mod, would we?
     */
    public static void registerEssentials() {
        ItemHandler.registerGemstyneItems();
        BlockHandler.registerGemstyneBlocks();
        GemstyneBlockEntities.registerGemstyneEntities();
        GemstyneRegistry.registerMisc();
    }

    public static void modObserver() {
        if (FabricLoader.getInstance().isModLoaded("mythicmetals")) {
            Gemstyne.LOGGER.info("Mythic Metals? Amazing project! Gemstyne takes much inspiration from it!");
        }
    }
}
