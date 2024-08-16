package lotus.gemstyne.world.minerals;

import lotus.gemstyne.world.GemstyneConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public final class GemstyneMineralConfig {
    private GemstyneMineralConfig() {}

    public static final RegistryKey<ConfiguredFeature<?, ?>> HALITE_KEY =
            GemstyneConfiguredFeatures.registerKey("halite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PUMICE_KEY =
            GemstyneConfiguredFeatures.registerKey("pumice");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GABBRO_KEY =
            GemstyneConfiguredFeatures.registerKey("gabbro");

    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPACT_DIRT_KEY =
            GemstyneConfiguredFeatures.registerKey("compact_dirt");

    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_GRANITE_KEY =
            GemstyneConfiguredFeatures.registerKey("compressed_granite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_DIORITE_KEY =
            GemstyneConfiguredFeatures.registerKey("compressed_diorite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_ANDESITE_KEY =
            GemstyneConfiguredFeatures.registerKey("compressed_andesite");


    public static void registerMineralConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context) {
        // =====
        // <===== Minerals =====>
        // =====
        GemstyneConfiguredFeatures.register(context, HALITE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneMineralLists.haliteBlobs, 33));
        GemstyneConfiguredFeatures.register(context, PUMICE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneMineralLists.pumiceBlobs, 33));
        GemstyneConfiguredFeatures.register(context, GABBRO_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneMineralLists.gabbroBlobs, 33));

        GemstyneConfiguredFeatures.register(context, COMPACT_DIRT_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneMineralLists.compactDirt, 33));

        GemstyneConfiguredFeatures.register(context, COMPRESSED_GRANITE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneMineralLists.compressedGranite, 64));
        GemstyneConfiguredFeatures.register(context, COMPRESSED_DIORITE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneMineralLists.compressedDiorite, 64));
        GemstyneConfiguredFeatures.register(context, COMPRESSED_ANDESITE_KEY, Feature.ORE,
                new OreFeatureConfig(GemstyneMineralLists.compressedAndesite, 64));
    }
}
