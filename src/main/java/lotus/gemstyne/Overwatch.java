package lotus.gemstyne;

import lotus.gemstyne.block.GemstyneBlockHandler;
import lotus.gemstyne.block.entity.GemstyneBlockEntities;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.GemstyneItemHandler;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistries;

/**
 * <h2>Overwatch</h2>
 * Class used to log events, primarily registration and possibly other things in the future.
 */
public final class Overwatch {
    /**
     * <code>registerDependencies</code> registers required resources for Gemstyne to function.
     * Dependencies in this context, refer to anything that needs to be registered before anything else.
     */
    public static void registerDependencies() {
        GemstyneEffects.RegisterEffects();
        GemstyneFluids.registerFluids();
        GemstyneCreativeGroup.registerGroups();
    }

    /**
     * <code>registerEssentials</code> registers the meat of Gemstyne, such as Items or Blocks. Without
     * them, we wouldn't have a mod, would we?
     */
    public static void registerEssentials() {
        GemstyneItemHandler.registerGemstyneItems();
        GemstyneBlockHandler.registerGemstyneBlocks();
        GemstyneBlockEntities.registerBlockEntities();
        GemstyneRegistries.registerGemstyneMisc();
    }
}
