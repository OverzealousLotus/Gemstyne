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
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * <h2>Overwatch</h2>
 * Class used to log events, primarily registration and possibly other things in the future.
 */
public final class Overwatch {
    private Overwatch() {}

    private static final Logger LOGGER = LoggerFactory.getLogger(Gemstyne.MOD_ID);
    private static final Random random = new Random();
    private static final ImmutableList<String> DIALOGUE = ImmutableList.of(
        "Rock and Stone!",
        "We're rich!",
        "Worthless, but fun to destroy!",
        "Don't be a Leaf Lover! No Strip Mining!",
        "Wait!... What's the different between rock and stone?",
        "See you later, Detonator!"
    );

    public static void info(String text) {
        if(LOGGER.isInfoEnabled()) LOGGER.info(String.format("[Gemstyne] %s", text));
    }

    public static void error(String text) {
        if(LOGGER.isErrorEnabled()) LOGGER.error(String.format("[Gemstyne] %s", text));
    }

    public static void noop() { /* Performs no operation. */ }

    private static void registerFuels() {
        info("Registering Fuel Items...");

        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ItemHandler.MORKITE, 2000);
        registry.add(BlockHandler.MORKITE.rawBlock(), 20000);
        registry.add(FluidHandler.LIQUID_MORKITE_BUCKET, 24000);

        info("Successfully registered Fuel Items!");
    }

    /**
     * Registers required resources for Gemstyne to function.
     * Dependencies in this context, refer to anything that needs to be registered before anything else.
     */
    public static void registerDependencies() {
        info("~> Registering Dependencies...");
        EffectHandler.registerEffects();
        FluidHandler.registerFluids();
        GemstyneCreativeGroup.registerGroups();
        info("~> Successfully registered all Dependencies!");
    }

    /**
     * Registers the meat of Gemstyne, such as Items or Blocks. Without
     * them, we wouldn't have a mod, would we?
     */
    public static void registerEssentials() {
        info("~> Registering Essentials...");
        ItemHandler.registerGeneralItems();
        GemstyneArmorMaterials.registerMats();
        ArmorHandler.registerArmorItems();
        ToolHandler.registerToolItems();
        BlockHandler.registerGemstyneBlocks();
        GemstyneBlockEntities.registerGemstyneEntities();
        registerFuels();
        info("~> Successfully registered all Essentials!");
    }

    public static void modObserver() {
        Overwatch.info(DIALOGUE.get(random.nextInt(0, 5)));
        FabricLoader.getInstance().getAllMods().forEach(mod -> {
            switch(mod.toString()) {
                case "mythicmetals" -> info("MythicMetals? Great choice! Gemstyne takes much inspiration from it!");
                case "geodes" -> info("MoreGeodes?~ <3");
                default -> noop();
            }
        });
    }
}
