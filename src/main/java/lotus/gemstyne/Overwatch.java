package lotus.gemstyne;

import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.GemstyneItemGroup;

/**
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
        GemstyneItemGroup.registerItemGroups();
    }

    /**
     * <code>registerEssentials</code> registers the meat of Gemstyne, such as Items or Blocks. Without
     * them, we wouldn't have a mod, would we?
     */
    public static void registerEssentials() {

    }
}
