package lotus.gemstyne.world.ores;

import lotus.gemstyne.world.GemstyneConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class GemstyneOreConfig {
    // =====
    // <===== Overworld Keys =====>
    // =====
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MOCHITE_SMALL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_mochite_small");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MOCHITE_LARGE_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_mochite_large");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MOCHITE_RAW_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_mochite_raw");

    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_TIN_SMALL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_tin_small");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_TIN_LARGE_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_tin_large");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_TIN_RAW_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_tin_raw");

    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_SMALL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_uranium_small");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_LARGE_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_uranium_large");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_RAW_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_uranium_raw");

    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MORKITE_EXPOSED_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_morkite_exposed");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MORKITE_BURIED_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_morkite_buried");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MORKITE_RAW_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_morkite_raw");

    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_FIRE_OPAL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_fire_opal");

    // =====
    // <===== Nether Keys =====>
    // =====
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_CRIMONITE_SMALL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_crimonite_small");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_CRIMONITE_LARGE_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_crimonite_large");

    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ALDUS_SMALL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_aldus_small");
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ALDUS_LARGE_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_aldus_large");

    // =====
    // <===== Extension Keys =====>
    // =====
    private static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_COAL_ORE_KEY =
            GemstyneConfiguredFeatures.registerKey("compressed_coal_ore");


    /** <h3>Function used to register all Ore Configuration Features.</h3>
     */
    public static void registerOreConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context) {
        // =====
        // <===== Overworld config features. =====>
        // =====
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreFireOpalKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldFireOpalOres(), 3, 0.0f));

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMochiteSmallKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldMochiteOres(), 8, 0.0f)); // Vein size.
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMochiteLargeKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldMochiteOres(), 17, 0.0f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMochiteRawKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getRawMochiteBlobs(), 5, 0.05f));

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreTinSmallKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldTinOres(), 10, 0.0f)); // Vein size.
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreTinLargeKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldTinOres(), 20, 0.0f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreTinRawKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getRawTinBlobs(), 5, 0.05f));

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMorkiteExposedKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldMorkiteOres(), 7, 0.0f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMorkiteBuriedKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldMorkiteOres(), 10, 0.7f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMorkiteRawKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getRawMorkiteBlobs(), 4, 0.05f));


        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreUraniumSmallKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldUraniumOres(), 4, 0.5f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreUraniumLargeKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldUraniumOres(), 10, 0.7f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreUraniumRawKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getRawUraniumBlobs(), 2, 0.05f));

        // =====
        // <===== Nether config features. =====>
        // =====
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreCrimoniteSmallKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getNetherCrimoniteOres(), 3));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreCrimoniteLargeKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getNetherCrimoniteOres(), 7));

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreAldusSmallKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getNetherAldusOres(), 4));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreAldusLargeKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getNetherAldusOres(), 12));

        // =====
        // <===== Extension config features. =====>
        // =====
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getCompressedCoalOreKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getCompressedCoalOres(), 10));
    }


    // =====
    // <===== Getters =====>
    // =====
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreMochiteSmallKey() {
        return ORE_MOCHITE_SMALL_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreMochiteLargeKey() {
        return ORE_MOCHITE_LARGE_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreMochiteRawKey() {
        return ORE_MOCHITE_RAW_KEY;
    }

    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreUraniumSmallKey() {
        return ORE_URANIUM_SMALL_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreUraniumLargeKey() {
        return ORE_URANIUM_LARGE_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreUraniumRawKey() {
        return ORE_URANIUM_RAW_KEY;
    }

    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreMorkiteExposedKey() {
        return ORE_MORKITE_EXPOSED_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreMorkiteBuriedKey() {
        return ORE_MORKITE_BURIED_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreMorkiteRawKey() {
        return ORE_MORKITE_RAW_KEY;
    }

    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreFireOpalKey() {
        return ORE_FIRE_OPAL_KEY;
    }

    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreCrimoniteSmallKey() {
        return ORE_CRIMONITE_SMALL_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreCrimoniteLargeKey() {
        return ORE_CRIMONITE_LARGE_KEY;
    }

    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreAldusSmallKey() {
        return ORE_ALDUS_SMALL_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreAldusLargeKey() {
        return ORE_ALDUS_LARGE_KEY;
    }

    protected static RegistryKey<ConfiguredFeature<?, ?>> getCompressedCoalOreKey() {
        return COMPRESSED_COAL_ORE_KEY;
    }

    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreTinSmallKey() {
        return ORE_TIN_SMALL_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreTinLargeKey() {
        return ORE_TIN_LARGE_KEY;
    }
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreTinRawKey() {
        return ORE_TIN_RAW_KEY;
    }
}
