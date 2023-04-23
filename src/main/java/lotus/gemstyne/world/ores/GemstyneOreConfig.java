package lotus.gemstyne.world.ores;

import lotus.gemstyne.world.GemstyneConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public final class GemstyneOreConfig {
    // =====
    // <===== Overworld Keys =====>
    // =====
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MOCHITE_SMALL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_mochite_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MOCHITE_LARGE_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_mochite_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MOCHITE_RAW_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_mochite_raw");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_SMALL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_uranium_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_LARGE_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_uranium_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_RAW_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_uranium_raw");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MORKITE_EXPOSED_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_morkite_exposed");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MORKITE_BURIED_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_morkite_buried");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MORKITE_RAW_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_morkite_raw");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_FIRE_OPAL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_fire_opal");

    // =====
    // <===== Nether Keys =====>
    // =====
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_CRIMONITE_SMALL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_crimonite_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_CRIMONITE_LARGE_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_crimonite_large");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ALDUS_SMALL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_aldus_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ALDUS_LARGE_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_aldus_large");

    // =====
    // <===== Extension Keys =====>
    // =====
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_COAL_ORE_KEY =
            GemstyneConfiguredFeatures.registerKey("compressed_coal_ore");


    /** <h3>Function used to register all Ore Configuration Features.</h3>
     */
    public static void registerOreConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context) {
        // =====
        // <===== Overworld config features. =====>
        // =====
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_MOCHITE_SMALL_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.overworldMochiteOres, 8, 0.0f)); // Vein size.
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_MOCHITE_LARGE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.overworldMochiteOres, 17, 0.0f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_MOCHITE_RAW_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.rawMochiteBlobs, 5, 0.05f));

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_URANIUM_SMALL_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.overworldUraniumOres, 4, 0.5f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_URANIUM_LARGE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.overworldUraniumOres, 10, 0.7f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_URANIUM_RAW_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.rawUraniumBlobs, 2, 0.05f));

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_MORKITE_EXPOSED_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.overworldMorkiteOres, 7, 0.0f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_MORKITE_BURIED_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.overworldMorkiteOres, 10, 0.7f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_MORKITE_RAW_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.rawMorkiteBlobs, 4, 0.05f));

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_FIRE_OPAL_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.overworldFireOpalOres, 3, 0.0f));

        // =====
        // <===== Nether config features. =====>
        // =====
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_CRIMONITE_SMALL_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.netherCrimoniteOres, 3));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_CRIMONITE_LARGE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.netherCrimoniteOres, 7));

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_ALDUS_SMALL_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.netherAldusOres, 4));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.ORE_ALDUS_LARGE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.netherAldusOres, 12));

        // =====
        // <===== Extension config features. =====>
        // =====
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.COMPRESSED_COAL_ORE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.compressedCoalOres, 10));
    }
}
