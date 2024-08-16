package lotus.gemstyne;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.armor.ArmorHandler;
import lotus.gemstyne.armor.GemstyneArmorMaterials;
import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.block.entity.GemstyneBlockEntities;
import lotus.gemstyne.effect.EffectHandler;
import lotus.gemstyne.fluid.FluidHandler;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.tool.ToolHandler;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.loader.api.FabricLoader;

import java.util.Random;

/**
 * <h2>Overwatch</h2>
 * Class used to log events, primarily registration and possibly other things in the future.
 */
public final class Overwatch {
    private Overwatch() {}

    private static final Random random = new Random();
    private static final ImmutableList<String> DIALOGUE = ImmutableList.of(
        "Rock and Stone!",
        "We're rich!",
        "Worthless, but it's fun to destroy!",
        "Don't be a Leaf Lover! No Strip Mining!",
        "Wait!... What's the different between rock and stone?"
    );

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
        ItemHandler.registerGeneralItems();
        GemstyneArmorMaterials.registerMats();
        ArmorHandler.registerArmorItems();
        ToolHandler.registerToolItems();
        BlockHandler.registerGemstyneBlocks();
        GemstyneBlockEntities.registerGemstyneEntities();
        GemstyneRegistry.registerMisc();
    }

    public static void modObserver() {
        if (Gemstyne.LOGGER.isInfoEnabled()) {
            Gemstyne.LOGGER.info("[Gemstyne] {}", DIALOGUE.get(random.nextInt(0, 4)));
            if (FabricLoader.getInstance().isModLoaded("mythicmetals")) {
                Gemstyne.LOGGER.info("[Gemstyne] Mythic Metals? Amazing project! Gemstyne takes much inspiration from it!");
            }
        }
    }
}
