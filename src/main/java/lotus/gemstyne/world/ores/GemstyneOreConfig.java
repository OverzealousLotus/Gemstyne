package lotus.gemstyne.world.ores;

import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.world.GemstyneConfiguredFeatures;
import lotus.gemstyne.world.GemstyneWorldHandler;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class GemstyneOreConfig {
    private GemstyneOreConfig() {}

    // =====
    // <===== Overworld Keys =====>
    // =====
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_MOCHITE_RAW_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_mochite_raw");

    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_TIN_RAW_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_tin_raw");

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
    // <===== Extension Keys =====>
    // =====
    private static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_COAL_ORE_KEY =
            GemstyneConfiguredFeatures.registerKey("compressed_coal_ore");


    /** <h3>Function used to register all Ore Configuration Features.</h3>
     */
    public static void registerOreConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context) {
        // =====
        // <=====| The Overworld |=====>
        // =====
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreFireOpalKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldFireOpalOres(), 3, 0.0f));

        GemstyneWorldHandler.MOCHITE.overworldConfigFeatures(context, GemstyneConstants.SMALL, 8, 0.0f);
        GemstyneWorldHandler.MOCHITE.overworldConfigFeatures(context, GemstyneConstants.LARGE, 17, 0.05f);
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMochiteRawKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getRawMochiteBlobs(), 5, 0.05f));

        GemstyneWorldHandler.TIN.overworldConfigFeatures(context, "small", 7, 0.0f);
        GemstyneWorldHandler.TIN.overworldConfigFeatures(context, "large", 12, 0.0f);
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreTinRawKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getRawTinBlobs(), 5, 0.05f));

        GemstyneWorldHandler.TORRIUM.overworldConfigFeatures(context, "small", 5, 0.2f);
        GemstyneWorldHandler.TORRIUM.overworldConfigFeatures(context, "large", 9, 0.5f);
        GemstyneWorldHandler.TORRIUM.netherConfigFeatures(context, GemstyneConstants.NETHER, 12, 0.0f);

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMorkiteExposedKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldMorkiteOres(), 7, 0.0f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMorkiteBuriedKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getOverworldMorkiteOres(), 10, 0.7f));
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreMorkiteRawKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getRawMorkiteBlobs(), 4, 0.05f));


        GemstyneWorldHandler.URANIUM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 4, 0.5f);
        GemstyneWorldHandler.URANIUM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 10, 0.7f);
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreUraniumRawKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getRawUraniumBlobs(), 2, 0.05f));

        // =====
        // <=====| The Nether |=====>
        // =====
        GemstyneWorldHandler.ALDUS.netherConfigFeatures(context, GemstyneConstants.SMALL, 4, 0);
        GemstyneWorldHandler.ALDUS.netherConfigFeatures(context, GemstyneConstants.LARGE, 12, 0);

        GemstyneWorldHandler.CRIMONITE.netherConfigFeatures(context, GemstyneConstants.LARGE, 7, 0);
        GemstyneWorldHandler.CRIMONITE.netherConfigFeatures(context, GemstyneConstants.SMALL, 3, 0);

        // =====
        // <=====| The End |=====>
        // =====

        // =====
        // <=====| Multi-Dimensional |=====>
        // =====
        GemstyneWorldHandler.MUTALIUM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 5, 0.2f);
        GemstyneWorldHandler.MUTALIUM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 7, 0.5f);
        GemstyneWorldHandler.MUTALIUM.netherConfigFeatures(context, GemstyneConstants.NETHER, 8, 0.1f);
        GemstyneWorldHandler.MUTALIUM.endConfigFeatures(context, GemstyneConstants.END, 16, 0.05f);

        // =====
        // <===== Extension config features. =====>
        // =====
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getCompressedCoalOreKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.getCompressedCoalOres(), 10));
    }

    // =====
    // <===== Getters =====>
    // =====
    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreMochiteRawKey() {
        return ORE_MOCHITE_RAW_KEY;
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

    protected static RegistryKey<ConfiguredFeature<?, ?>> getCompressedCoalOreKey() {
        return COMPRESSED_COAL_ORE_KEY;
    }

    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreTinRawKey() {
        return ORE_TIN_RAW_KEY;
    }
}
