package lotus.gemstyne.world.gen;

import lotus.gemstyne.world.GemstynePlacedFeatures;
import lotus.gemstyne.world.geodes.GemstyneGeodePlaced;
import lotus.gemstyne.world.minerals.GemstyneMineralPlaced;
import lotus.gemstyne.world.ores.GemstyneOrePlaced;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    // What ores to generate and to execute ore generation.
    public static void generateOres() {
        // =====
        // <===== Ores =====>
        // =====
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.MOCHITE_ORE_UPPER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.MOCHITE_ORE_LOWER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.MOCHITE_ORE_RAW_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.URANIUM_ORE_SMALL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.URANIUM_ORE_LARGE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.URANIUM_ORE_RAW_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.MORKITE_ORE_BURIED_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.MORKITE_ORE_EXPOSED_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.MORKITE_ORE_RAW_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.CRIMONITE_ORE_UPPER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.CRIMONITE_ORE_LOWER_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.ALDUS_ORE_UPPER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.ALDUS_ORE_LOWER_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.COMPRESSED_COAL_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.FIRE_OPAL_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstynePlacedFeatures.LIQUID_MORKITE_PLACED_KEY);

        // =====
        // <===== Minerals =====>
        // =====
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.HALITE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.COMPACT_DIRT_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.COMPRESSED_GRANITE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.COMPRESSED_DIORITE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.COMPRESSED_ANDESITE_PLACED_KEY);
        // =====
        // <===== Geodes =====>
        // =====
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneGeodePlaced.IKARITE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneGeodePlaced.GARNET_PLACED_KEY);
    }
}
