package lotus.gemstyne.world.ores;

import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.world.GemstynePlacedFeatures;
import lotus.gemstyne.world.GemstyneOrePlacement;
import lotus.gemstyne.world.GemstyneWorldHandler;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public final class GemstyneOrePlaced {
    private GemstyneOrePlaced() {}

    // =====
    // <===== Overworld Placed Keys =====>
    // =====
    private static final RegistryKey<PlacedFeature> FIRE_OPAL_ORE_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_fire_opal");

    private static final RegistryKey<PlacedFeature> MOCHITE_ORE_RAW_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_mochite_raw");

    private static final RegistryKey<PlacedFeature> MORKITE_ORE_BURIED_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_morkite_buried");
    private static final RegistryKey<PlacedFeature> MORKITE_ORE_EXPOSED_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_morkite_exposed");
    private static final RegistryKey<PlacedFeature> MORKITE_ORE_RAW_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_morkite_raw");

    private static final RegistryKey<PlacedFeature> TIN_ORE_RAW_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_tin_raw");

    private static final RegistryKey<PlacedFeature> URANIUM_ORE_RAW_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_uranium_raw");

    // =====
    // <===== Nether Placed Keys =====>
    // =====
    private static final RegistryKey<PlacedFeature> ALDUS_ORE_UPPER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_aldus_upper");
    private static final RegistryKey<PlacedFeature> ALDUS_ORE_LOWER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_aldus_lower");

    private static final RegistryKey<PlacedFeature> CRIMONITE_ORE_UPPER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_crimonite_upper");
    private static final RegistryKey<PlacedFeature> CRIMONITE_ORE_LOWER_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ore_crimonite_lower");

    // =====
    // <===== Extension Placed Keys =====>
    // =====
    private static final RegistryKey<PlacedFeature> COMPRESSED_COAL_ORE_PLACED_KEY =
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
        // <=====| The Overworld |=====>
        // =====
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.getFireOpalOrePlacedKey(),
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.getOreFireOpalKey()),
                GemstyneOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));

        GemstyneWorldHandler.MOCHITE.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 12,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(112)));
        GemstyneWorldHandler.MOCHITE.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(20)));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.getMochiteOreRawPlacedKey(),
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.getOreMochiteRawKey()),
                GemstyneOrePlacement.modifiersWithRarity(12, // 12
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));


        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.getMorkiteOreBuriedPlacedKey(),
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.getOreMorkiteBuriedKey()),
                GemstyneOrePlacement.modifiersWithCount(3,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.getMorkiteOreExposedPlacedKey(),
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.getOreMorkiteExposedKey()),
                GemstyneOrePlacement.modifiersWithCount(5,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.getMorkiteOreRawPlacedKey(),
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.getOreMorkiteRawKey()),
                GemstyneOrePlacement.modifiersWithRarity(9,  // 9
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));


        GemstyneWorldHandler.TIN.registerPlacedFeatures(context, "small", false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(112)));
        GemstyneWorldHandler.TIN.registerPlacedFeatures(context, "large", false, 3,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(112)));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.getTinOreRawPlacedKey(),
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.getOreTinRawKey()),
                GemstyneOrePlacement.modifiersWithRarity(5,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(112))));


        GemstyneWorldHandler.URANIUM.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 4,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0)));
        GemstyneWorldHandler.URANIUM.registerPlacedFeatures(context, GemstyneConstants.LARGE, true, 7,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0)));
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.getUraniumOreRawPlacedKey(),
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.getOreUraniumRawKey()),
                GemstyneOrePlacement.modifiersWithRarity(6,  // 6
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));

        // =====
        // <=====| The Nether |=====>
        // =====
        GemstyneWorldHandler.ALDUS.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(20), YOffset.fixed(50)));
        GemstyneWorldHandler.ALDUS.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 7,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(25)));


        GemstyneWorldHandler.CRIMONITE.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 4,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(50), YOffset.fixed(80)));
        GemstyneWorldHandler.CRIMONITE.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(75), YOffset.fixed(100)));

        // =====
        // <=====| The End |=====>
        // =====


        // =====
        // <=====| Multi-Dimensional |=====>
        // =====
        GemstyneWorldHandler.TORRIUM.registerPlacedFeatures(context, "small", false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(100)));
        GemstyneWorldHandler.TORRIUM.registerPlacedFeatures(context, "large", false,  3,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(20)));
        GemstyneWorldHandler.TORRIUM.registerPlacedFeatures(context, GemstyneConstants.NETHER, false, 7,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(10), YOffset.fixed(100)));

        GemstyneWorldHandler.MUTALIUM.registerPlacedFeatures(context, "small", false, 2,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(75)));
        GemstyneWorldHandler.MUTALIUM.registerPlacedFeatures(context, "large", false,  1,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(15)));
        GemstyneWorldHandler.MUTALIUM.registerPlacedFeatures(context, GemstyneConstants.NETHER, false, 4,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(10), YOffset.fixed(100)));
        GemstyneWorldHandler.MUTALIUM.registerPlacedFeatures(context, GemstyneConstants.END, false, 6,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-60), YOffset.fixed(100)));

        // =====
        // <===== Extension Placement Settings =====>
        // =====
        GemstynePlacedFeatures.register(context, GemstyneOrePlaced.getCompressedCoalOrePlacedKey(),
                GemstynePlacedFeatures.fetchConfig(context, GemstyneOreConfig.getCompressedCoalOreKey()),
                GemstyneOrePlacement.modifiersWithCount(15,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));
    }

    public static RegistryKey<PlacedFeature> getFireOpalOrePlacedKey() {
        return FIRE_OPAL_ORE_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getMochiteOreRawPlacedKey() {
        return MOCHITE_ORE_RAW_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getMorkiteOreBuriedPlacedKey() {
        return MORKITE_ORE_BURIED_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getMorkiteOreExposedPlacedKey() {
        return MORKITE_ORE_EXPOSED_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getMorkiteOreRawPlacedKey() {
        return MORKITE_ORE_RAW_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getUraniumOreRawPlacedKey() {
        return URANIUM_ORE_RAW_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getAldusOreUpperPlacedKey() {
        return ALDUS_ORE_UPPER_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getAldusOreLowerPlacedKey() {
        return ALDUS_ORE_LOWER_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getCrimoniteOreUpperPlacedKey() {
        return CRIMONITE_ORE_UPPER_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getCrimoniteOreLowerPlacedKey() {
        return CRIMONITE_ORE_LOWER_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getCompressedCoalOrePlacedKey() {
        return COMPRESSED_COAL_ORE_PLACED_KEY;
    }

    public static RegistryKey<PlacedFeature> getTinOreRawPlacedKey() {
        return TIN_ORE_RAW_PLACED_KEY;
    }
}
