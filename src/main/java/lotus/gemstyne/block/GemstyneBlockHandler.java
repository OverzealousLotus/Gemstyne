package lotus.gemstyne.block;

import io.wispforest.owo.util.TagInjector;
import lotus.gemstyne.Gemstyne;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

/**
 * Handler of Gemstyne's {@link net.minecraft.block.Block} assignment and registration.
 */
public final class GemstyneBlockHandler {
    private GemstyneBlockHandler() {
    }

    public static void registerGemstyneBlocks() {
        Gemstyne.LOGGER.info("Registering blocks for " + Gemstyne.MOD_ID + "!");
        GemstyneOreBlocks.registerOreBlocks();
        TagInjector.inject(Registries.BLOCK, new Identifier("mineable/pickaxe"), GemstyneOreBlocks.BUBBLEGEM_ORE);
        TagInjector.inject(Registries.BLOCK, new Identifier("minecraft:needs_iron_tool"), GemstyneOreBlocks.BUBBLEGEM_ORE);
        GemstyneMineralBlocks.registerMineralBlocks();
        Gemstyne.LOGGER.info("Successfully registered blocks for " + Gemstyne.MOD_ID + "!");
    }
}
