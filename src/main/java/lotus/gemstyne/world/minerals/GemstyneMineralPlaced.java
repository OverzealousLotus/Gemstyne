package lotus.gemstyne.world.minerals;

import lotus.gemstyne.world.GemstynePlacedFeatures;
import lotus.gemstyne.world.util.GemstyneOrePlacement;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public final class GemstyneMineralPlaced {
    private GemstyneMineralPlaced() {}

    // =====
    // <===== Minerals =====>
    // =====
    public static final RegistryKey<PlacedFeature> HALITE_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("halite");

    public static final RegistryKey<PlacedFeature> ORE_PUMICE_UPPER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_pumice_upper");
    public static final RegistryKey<PlacedFeature> ORE_PUMICE_LOWER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_lower_upper");

    public static final RegistryKey<PlacedFeature> ORE_GABBRO_UPPER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_gabbro_upper");
    public static final RegistryKey<PlacedFeature> ORE_GABBRO_LOWER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_gabbro_lower");

    public static final RegistryKey<PlacedFeature> COMPACT_DIRT_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("compact_dirt");

    public static final RegistryKey<PlacedFeature> COMPRESSED_GRANITE_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("compressed_granite");
    public static final RegistryKey<PlacedFeature> COMPRESSED_DIORITE_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("compressed_diorite");
    public static final RegistryKey<PlacedFeature> COMPRESSED_ANDESITE_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("compressed_andesite");


    public static void registerMineralPlacedFeatures(Registerable<PlacedFeature> context) {
        // =====
        // <===== Mineral Settings =====>
        // =====
        GemstynePlacedFeatures.register(context, HALITE_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneMineralConfig.HALITE_KEY),
                GemstyneOrePlacement.modifiersWithRarity(3,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(128))));

        GemstynePlacedFeatures.register(context, ORE_PUMICE_UPPER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneMineralConfig.PUMICE_KEY),
                GemstyneOrePlacement.modifiersWithRarity(6,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(128))));
        GemstynePlacedFeatures.register(context, ORE_PUMICE_LOWER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneMineralConfig.PUMICE_KEY),
                GemstyneOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(60))));

        GemstynePlacedFeatures.register(context, ORE_GABBRO_UPPER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneMineralConfig.GABBRO_KEY),
                GemstyneOrePlacement.modifiersWithRarity(6,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(128))));
        GemstynePlacedFeatures.register(context, ORE_GABBRO_LOWER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneMineralConfig.GABBRO_KEY),
                GemstyneOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(60))));

        GemstynePlacedFeatures.register(context, COMPACT_DIRT_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneMineralConfig.COMPACT_DIRT_KEY),
                GemstyneOrePlacement.modifiersWithCount(6,
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))));

        GemstynePlacedFeatures.register(context, COMPRESSED_GRANITE_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneMineralConfig.COMPRESSED_GRANITE_KEY),
                GemstyneOrePlacement.modifiersWithRarity(5,
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-64))));
        GemstynePlacedFeatures.register(context, COMPRESSED_DIORITE_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneMineralConfig.COMPRESSED_DIORITE_KEY),
                GemstyneOrePlacement.modifiersWithRarity(5,
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-64))));
        GemstynePlacedFeatures.register(context, COMPRESSED_ANDESITE_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneMineralConfig.COMPRESSED_ANDESITE_KEY),
                GemstyneOrePlacement.modifiersWithRarity(5,
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-64))));
    }
}
