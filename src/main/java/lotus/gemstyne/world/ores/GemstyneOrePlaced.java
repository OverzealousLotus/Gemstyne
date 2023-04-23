package lotus.gemstyne.world.ores;

import lotus.gemstyne.world.GemstynePlacedFeatures;
import lotus.gemstyne.world.GemstyneOrePlacement;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public final class GemstyneOrePlaced {
    // =====
    // <===== Overworld Placed Keys =====>
    // =====
    public static final RegistryKey<PlacedFeature> FIRE_OPAL_ORE_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_fire_opal");

    public static final RegistryKey<PlacedFeature> MOCHITE_ORE_UPPER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_mochite_upper");
    public static final RegistryKey<PlacedFeature> MOCHITE_ORE_LOWER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_mochite_lower");
    public static final RegistryKey<PlacedFeature> MOCHITE_ORE_RAW_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_mochite_raw");

    public static final RegistryKey<PlacedFeature> MORKITE_ORE_BURIED_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_morkite_buried");
    public static final RegistryKey<PlacedFeature> MORKITE_ORE_EXPOSED_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_morkite_exposed");
    public static final RegistryKey<PlacedFeature> MORKITE_ORE_RAW_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_morkite_raw");

    public static final RegistryKey<PlacedFeature> URANIUM_ORE_SMALL_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_uranium_small");
    public static final RegistryKey<PlacedFeature> URANIUM_ORE_LARGE_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_uranium_large");
    public static final RegistryKey<PlacedFeature> URANIUM_ORE_RAW_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_uranium_raw");

    // =====
    // <===== Nether Placed Keys =====>
    // =====
    public static final RegistryKey<PlacedFeature> ALDUS_ORE_UPPER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_aldus_upper");
    public static final RegistryKey<PlacedFeature> ALDUS_ORE_LOWER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_aldus_lower");

    public static final RegistryKey<PlacedFeature> CRIMONITE_ORE_UPPER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_crimonite_upper");
    public static final RegistryKey<PlacedFeature> CRIMONITE_ORE_LOWER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_crimonite_lower");

    // =====
    // <===== Extension Placed Keys =====>
    // =====
    public static final RegistryKey<PlacedFeature> COMPRESSED_COAL_ORE_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_compressed_coal");

    /** <h3>Function used to register all Ore Placement Features.</h3>
     * <ul>Glossary:
     * <li>Count: Hardcoded count of blobs per chunk.</li>
     * <li>Chance: Chance per x amount of blocks? ( Higher means rarer )</li>
     * <li>Trapezoid: Generation occurs in a Trapezoid shape.</li>
     * <li>Uniform: Evenly distributed across chunk.</li>
     * </ul>
     */
    public static void registerOrePlacedFeatures(Registerable<PlacedFeature> context) {
        // =====
        // <===== Overworld Placement Settings =====>
        // =====
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.FIRE_OPAL_ORE_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_FIRE_OPAL_KEY),
                GemstyneOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));


        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.MOCHITE_ORE_UPPER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_MOCHITE_SMALL_KEY),
                GemstyneOrePlacement.modifiersWithCount(12, // Veins per chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(112)))); // Ore-gen range
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.MOCHITE_ORE_LOWER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_MOCHITE_LARGE_KEY),
                GemstyneOrePlacement.modifiersWithCount(5,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(20))));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.MOCHITE_ORE_RAW_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_MOCHITE_RAW_KEY),
                GemstyneOrePlacement.modifiersWithRarity(12, // 12
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));


        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.MORKITE_ORE_BURIED_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_MORKITE_BURIED_KEY),
                GemstyneOrePlacement.modifiersWithCount(3,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.MORKITE_ORE_EXPOSED_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_MORKITE_EXPOSED_KEY),
                GemstyneOrePlacement.modifiersWithCount(5,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.MORKITE_ORE_RAW_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_MORKITE_RAW_KEY),
                GemstyneOrePlacement.modifiersWithRarity(9,  // 9
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));


        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.URANIUM_ORE_SMALL_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_URANIUM_SMALL_KEY),
                GemstyneOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.URANIUM_ORE_LARGE_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_URANIUM_LARGE_KEY),
                GemstyneOrePlacement.modifiersWithRarity(7,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.URANIUM_ORE_RAW_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_URANIUM_RAW_KEY),
                GemstyneOrePlacement.modifiersWithRarity(6,  // 6
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));

        // =====
        // <===== Nether Placement Settings =====>
        // =====
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.ALDUS_ORE_UPPER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_ALDUS_SMALL_KEY),
                GemstyneOrePlacement.modifiersWithCount(5,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(20), YOffset.fixed(50))));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.ALDUS_ORE_LOWER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_ALDUS_LARGE_KEY),
                GemstyneOrePlacement.modifiersWithCount(7,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(25))));


        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.CRIMONITE_ORE_UPPER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_CRIMONITE_LARGE_KEY),
                GemstyneOrePlacement.modifiersWithCount(5,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(75), YOffset.fixed(100))));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.CRIMONITE_ORE_LOWER_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.ORE_CRIMONITE_SMALL_KEY),
                GemstyneOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(50), YOffset.fixed(80))));

        // =====
        // <===== Extension Placement Settings =====>
        // =====
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.COMPRESSED_COAL_ORE_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.COMPRESSED_COAL_ORE_KEY),
                GemstyneOrePlacement.modifiersWithCount(15,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));
    }
}
