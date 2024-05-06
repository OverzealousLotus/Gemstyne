package lotus.gemstyne.world;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.fluid.FluidHandler;
import lotus.gemstyne.world.geodes.GemstyneGeodeConfig;
import lotus.gemstyne.world.minerals.GemstyneMineralConfig;
import lotus.gemstyne.world.ores.GemstyneOreConfig;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

/** Configuration of Features for world generation. Keys must be registered first,
 * then using the bootstrap method, create a list of target blocks to be replaced.
 * Finally, we move to the actual configuration at the end, where settings may vary. */
public final class GemstyneConfiguredFeatures {
    private GemstyneConfiguredFeatures() {}

    // =====
    // <===== Misc =====>
    // =====
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIQUID_MORKITE_KEY = registerKey("liquid_morkite_reservoir");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // =====
        // ==========
        // <========== Configuration Lists ==========>
        // ==========
        // =====
        ImmutableList<OreFeatureConfig.Target> liquidMorkiteReservoirs =
                ImmutableList.of(OreFeatureConfig.createTarget(
                        deepslateReplaceables, FluidHandler.STILL_LIQUID_MORKITE.getDefaultState().getBlockState()));


        // =====
        // ==========
        // <========== Configuration & Registration ==========>
        // ==========
        // =====
        GemstyneMineralConfig.registerMineralConfigFeatures(context);

        GemstyneOreConfig.registerOreConfigFeatures(context);

        GemstyneGeodeConfig.registerGeodeConfigFeatures(context);

        register(context, LIQUID_MORKITE_KEY, Feature.ORE,
                new OreFeatureConfig(liquidMorkiteReservoirs, 5, 0.9f));
    }



    // =====
    // ==========
    // <========== Assistive Functions ==========>
    // ==========
    // =====
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Gemstyne.MOD_ID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
