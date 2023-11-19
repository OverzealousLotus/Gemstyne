package lotus.gemstyne.world.ores;

import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.world.GemstynePlacedFeatures;
import lotus.gemstyne.world.GemstyneOrePlacement;
import lotus.gemstyne.world.WorldHandler;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public final class GemstyneOrePlaced {
    private GemstyneOrePlaced() {
    }

    // =====
    // <===== Overworld Placed Keys =====>
    // =====
    private static final RegistryKey<PlacedFeature> FIRE_OPAL_ORE_PLACED_KEY =
        GemstynePlacedFeatures.registerKey("ore_fire_opal");

    // =====
    // <===== Extension Placed Keys =====>
    // =====
    private static final RegistryKey<PlacedFeature> COMPRESSED_COAL_ORE_PLACED_KEY =
        GemstynePlacedFeatures.registerKey("ore_compressed_coal");

    /**
     * <h3>Function used to register all Ore Placement Features.</h3>
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

        WorldHandler.BUBBLEGEM.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 7,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(112)));
        WorldHandler.BUBBLEGEM.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(20)));

        WorldHandler.MOCHITE.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 12,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(112)));
        WorldHandler.MOCHITE.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(20)));
        WorldHandler.MOCHITE.registerPlacedFeatures(context, GemstyneConstants.RAW, false, 90,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(112)));
        WorldHandler.MOCHITE.registerPlacedFeatures(context, GemstyneConstants.RICH, true, 10,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(112)));


        WorldHandler.MORKITE.registerPlacedFeatures(context, GemstyneConstants.BURIED, false, 2,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0)));
        WorldHandler.MORKITE.registerPlacedFeatures(context, GemstyneConstants.EXPOSED, false, 4,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0)));
        WorldHandler.MORKITE.registerPlacedFeatures(context, GemstyneConstants.RAW, false, 150,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0)));


        WorldHandler.TIN.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(112)));
        WorldHandler.TIN.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 3,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(112)));
        WorldHandler.TIN.registerPlacedFeatures(context, GemstyneConstants.RAW, false, 90,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(112)));


        WorldHandler.URANIUM.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 4,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0)));
        WorldHandler.URANIUM.registerPlacedFeatures(context, GemstyneConstants.LARGE, true, 7,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0)));
        WorldHandler.URANIUM.registerPlacedFeatures(context, GemstyneConstants.RAW, false, 150,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0)));

        // =====
        // <=====| The Nether |=====>
        // =====
        WorldHandler.ALDUS.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(20), YOffset.fixed(50)));
        WorldHandler.ALDUS.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 7,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(25)));

        WorldHandler.BLAZITE.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 3,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(20), YOffset.fixed(50)));
        WorldHandler.BLAZITE.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(25)));

        WorldHandler.CRIMONITE.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 4,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(50), YOffset.fixed(80)));
        WorldHandler.CRIMONITE.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 5,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(75), YOffset.fixed(100)));

        // =====
        // <=====| The End |=====>
        // =====


        // =====
        // <=====| Multi-Dimensional |=====>
        // =====
        WorldHandler.ENDER_PEARL.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 3,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(75)));
        WorldHandler.ENDER_PEARL.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 1,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(15)));
        WorldHandler.ENDER_PEARL.registerPlacedFeatures(context, GemstyneConstants.NETHER, false, 3,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(10), YOffset.fixed(100)));
        WorldHandler.ENDER_PEARL.registerPlacedFeatures(context, GemstyneConstants.END, false, 6,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-60), YOffset.fixed(100)));

        WorldHandler.TORRIUM.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 3,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(100)));
        WorldHandler.TORRIUM.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 3,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(20)));
        WorldHandler.TORRIUM.registerPlacedFeatures(context, GemstyneConstants.NETHER, false, 4,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(10), YOffset.fixed(100)));

        WorldHandler.MUTALIUM.registerPlacedFeatures(context, GemstyneConstants.SMALL, false, 2,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(75)));
        WorldHandler.MUTALIUM.registerPlacedFeatures(context, GemstyneConstants.LARGE, false, 1,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(15)));
        WorldHandler.MUTALIUM.registerPlacedFeatures(context, GemstyneConstants.NETHER, false, 4,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(10), YOffset.fixed(100)));
        WorldHandler.MUTALIUM.registerPlacedFeatures(context, GemstyneConstants.END, false, 6,
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

    public static RegistryKey<PlacedFeature> getCompressedCoalOrePlacedKey() {
        return COMPRESSED_COAL_ORE_PLACED_KEY;
    }
}
