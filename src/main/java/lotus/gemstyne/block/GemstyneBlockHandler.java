package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import net.minecraft.block.*;

/**
 * Handler of Gemstyne's {@link Block} assignment and registration.
 */
public final class GemstyneBlockHandler {

    public static void registerGemstyneBlocks() {
        Gemstyne.LOGGER.info("Registering blocks for " + Gemstyne.MOD_ID + "!");
        GemstyneOreBlocks.registerOreBlocks();
        GemstyneMineralBlocks.registerMineralBlocks();
        Gemstyne.LOGGER.info("Successfully registered blocks for " + Gemstyne.MOD_ID + "!");
    }
}
