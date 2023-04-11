package lotus.gemstyne.world;

import lotus.gemstyne.Gemstyne;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    // When creating a newly generated Ore, make sure to also:
    // - Register the keys in ModConfiguredFeatures and ModOreGeneration!
    // - Lastly, run Datagen to actually generate the keys being used!



    // =====
    // ==========
    // <========== Placement Keys ==========>
    // ==========
    // =====
    // =====


    // =====
    // <===== Ore =====>
    // =====
    public static final RegistryKey<PlacedFeature> MOCHITE_ORE_PLACED_KEY = registerKey("mochite_ore");
    public static final RegistryKey<PlacedFeature> URANIUM_ORE_PLACED_KEY = registerKey("uranium_ore");
    public static final RegistryKey<PlacedFeature> MORKITE_ORE_PLACED_KEY = registerKey("morkite_ore");
    // public static final RegistryKey<PlacedFeature> COMPRESSED_COAL_ORE_PLACED_KEY = registerKey("compressed_coal_ore");

    // =====
    // <===== Minerals =====>
    // =====
    public static final RegistryKey<PlacedFeature> HALITE_PLACED_KEY = registerKey("halite");

    public static final RegistryKey<PlacedFeature> COMPACT_DIRT_PLACED_KEY = registerKey("compact_dirt");

    public static final RegistryKey<PlacedFeature> COMPRESSED_GRANITE_PLACED_KEY = registerKey("compressed_granite");
    public static final RegistryKey<PlacedFeature> COMPRESSED_DIORITE_PLACED_KEY = registerKey("compressed_diorite");
    public static final RegistryKey<PlacedFeature> COMPRESSED_ANDESITE_PLACED_KEY = registerKey("compressed_andesite");

    // =====
    // <===== Geodes =====>
    // =====
    public static final RegistryKey<PlacedFeature> IKARITE_PLACED_KEY = registerKey("ikarite_geode");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // =====
        // <===== Ore Settings =====>
        // =====
        // Trapezoid ranges generate in a Trapezoid region
        // Uniform ranges generate in the entire chunk.
        register(context, MOCHITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOCHITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10, // Veins per chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80)))); // Ore-gen range

        register(context, URANIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.URANIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));

        register(context, MORKITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MORKITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(6,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));

        /* register(context, COMPRESSED_COAL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COMPRESSED_COAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(15,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0)))); */

        // =====
        // <===== Mineral Settings =====>
        // =====
        register(context, HALITE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HALITE_KEY),
                ModOrePlacement.modifiersWithRarity(3,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(80))));

        register(context, COMPACT_DIRT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COMPACT_DIRT_KEY),
                ModOrePlacement.modifiersWithCount(7,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(0))));

        register(context, COMPRESSED_GRANITE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COMPRESSED_GRANITE_KEY),
                ModOrePlacement.modifiersWithRarity(5,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(0))));
        register(context, COMPRESSED_DIORITE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COMPRESSED_DIORITE_KEY),
                ModOrePlacement.modifiersWithRarity(5,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(0))));
        register(context, COMPRESSED_ANDESITE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COMPRESSED_ANDESITE_KEY),
                ModOrePlacement.modifiersWithRarity(5,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(0))));

        // =====
        // <===== Geode Settings =====>
        // =====
        register(context, IKARITE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.IKARITE_KEY),
                RarityFilterPlacementModifier.of(42),
                SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)),
                BiomePlacementModifier.of());
    }
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Gemstyne.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
