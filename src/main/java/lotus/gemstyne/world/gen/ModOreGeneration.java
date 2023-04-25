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
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getMochiteOreUpperPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getMochiteOreLowerPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getMochiteOreRawPlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getTinOreSmallPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getTinOreLargePlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getTinOreRawPlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getUraniumOreSmallPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getUraniumOreLargePlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getUraniumOreRawPlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getMorkiteOreBuriedPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getMorkiteOreExposedPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getMorkiteOreRawPlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getCrimoniteOreUpperPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getCrimoniteOreLowerPlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getAldusOreUpperPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getAldusOreLowerPlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getCompressedCoalOrePlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getFireOpalOrePlacedKey());

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
