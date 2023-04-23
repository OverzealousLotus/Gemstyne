package lotus.gemstyne.world.geodes;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.world.GemstynePlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public final class GemstyneGeodePlaced {
    // =====
    // <===== Geodes =====>
    // =====

    public static final RegistryKey<PlacedFeature> IKARITE_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("ikarite_geode");
    public static final RegistryKey<PlacedFeature> GARNET_PLACED_KEY =
            GemstynePlacedFeatures.registerKey("garnet_geode");


    public static void registerGeodePlacedFeatures(Registerable<PlacedFeature> context) {
        // =====
        // <===== Geode Settings =====>
        // =====
        GemstynePlacedFeatures.register(context, IKARITE_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneGeodeConfig.IKARITE_KEY),
                ImmutableList.of(RarityFilterPlacementModifier.of(65),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(25)),
                        BiomePlacementModifier.of()));

        GemstynePlacedFeatures.register(context, GARNET_PLACED_KEY,
                GemstynePlacedFeatures.fetchConfig(context, GemstyneGeodeConfig.GARNET_KEY),
                ImmutableList.of(RarityFilterPlacementModifier.of(45),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(60)),
                        BiomePlacementModifier.of()));
    }
}
