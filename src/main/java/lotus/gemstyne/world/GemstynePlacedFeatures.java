package lotus.gemstyne.world;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.world.geodes.GemstyneGeodePlaced;
import lotus.gemstyne.world.minerals.GemstyneMineralPlaced;
import lotus.gemstyne.world.ores.GemstyneOrePlaced;
import lotus.gemstyne.world.util.GemstyneOrePlacement;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

/** When creating a newly generated Ore, make sure to also:
 * - Register the keys in GemstyneConfiguredFeatures and GemstyneOreGeneration!
 * - Lastly, run Datagen to actually generate the keys being used! */
public final class GemstynePlacedFeatures {
    private GemstynePlacedFeatures() {}

    public static final RegistryKey<PlacedFeature> LIQUID_MORKITE_PLACED_KEY =
            registerKey("liquid_morkite_reservoirs");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        GemstyneMineralPlaced.registerMineralPlacedFeatures(context);

        GemstyneOrePlaced.registerOrePlacedFeatures(context);

        GemstyneGeodePlaced.registerGeodePlacedFeatures(context);

        register(context, LIQUID_MORKITE_PLACED_KEY,
                fetchConfig(context, GemstyneConfiguredFeatures.LIQUID_MORKITE_KEY),
                GemstyneOrePlacement.modifiersWithRarity(100,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(-20))));
    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Gemstyne.MOD_ID, name));
    }


    public static RegistryEntry.Reference<ConfiguredFeature<?, ?>> fetchConfig(
            Registerable<PlacedFeature> context, RegistryKey<ConfiguredFeature<?, ?>> key) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        return configuredFeatureRegistryEntryLookup.getOrThrow(key);
    }


    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> configuration,
            PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
