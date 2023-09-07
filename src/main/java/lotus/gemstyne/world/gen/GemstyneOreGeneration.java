package lotus.gemstyne.world.gen;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.world.GemstynePlacedFeatures;
import lotus.gemstyne.world.geodes.GemstyneGeodePlaced;
import lotus.gemstyne.world.minerals.GemstyneMineralPlaced;
import lotus.gemstyne.world.ores.GemstyneOrePlaced;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class GemstyneOreGeneration {
    private GemstyneOreGeneration() {}

    /**
     * Ores to Generate and Execute.
     * <strong>Notice:</strong> If any repeat keys are fed into this method, then the game will crash
     * upon attempting to generate the world.
     */
    public static void generateOres() {
        // =====
        // <===== Overworld Ores =====>
        // =====
        if (Gemstyne.CONFIG.mochiteEnabled()) {
            addOverworldOre(GemstyneOrePlaced.getMochiteOreLowerPlacedKey());
            addOverworldOre(GemstyneOrePlaced.getMochiteOreUpperPlacedKey());
            addOverworldOre(GemstyneOrePlaced.getMochiteOreRawPlacedKey());
        }

        if (Gemstyne.CONFIG.tinEnabled()) {
            addOverworldOre(GemstyneOrePlaced.getTinOreSmallPlacedKey());
            addOverworldOre(GemstyneOrePlaced.getTinOreLargePlacedKey());
            addOverworldOre(GemstyneOrePlaced.getTinOreRawPlacedKey());
        }

        if(Gemstyne.CONFIG.uraniumEnabled()) {
            addOverworldOre(GemstyneOrePlaced.getUraniumOreSmallPlacedKey());
            addOverworldOre(GemstyneOrePlaced.getUraniumOreLargePlacedKey());
            addOverworldOre(GemstyneOrePlaced.getUraniumOreRawPlacedKey());
        }

        if(Gemstyne.CONFIG.morkiteEnabled()) {
            addOverworldOre(GemstyneOrePlaced.getMorkiteOreBuriedPlacedKey());
            addOverworldOre(GemstyneOrePlaced.getMorkiteOreExposedPlacedKey());
            addOverworldOre(GemstyneOrePlaced.getMorkiteOreRawPlacedKey());
        }

        addOverworldOre(GemstyneOrePlaced.getCompressedCoalOrePlacedKey());
        addOverworldOre(GemstyneOrePlaced.getFireOpalOrePlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstynePlacedFeatures.LIQUID_MORKITE_PLACED_KEY);
        // =====
        // <===== Nether Ores =====>
        // =====
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getCrimoniteOreUpperPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getCrimoniteOreLowerPlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getAldusOreUpperPlacedKey());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneOrePlaced.getAldusOreLowerPlacedKey());

        // =====
        // <===== Minerals =====>
        // =====
        if(Gemstyne.CONFIG.mineralsEnabled()) {
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.HALITE_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.ORE_PUMICE_UPPER_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.ORE_PUMICE_LOWER_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.ORE_GABBRO_UPPER_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneMineralPlaced.ORE_GABBRO_LOWER_PLACED_KEY);
        }

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
        if(Gemstyne.CONFIG.ikariteEnabled()) {
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneGeodePlaced.IKARITE_PLACED_KEY);
        }
        if(Gemstyne.CONFIG.garnetEnabled()) {
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneGeodePlaced.GARNET_PLACED_KEY);
        }
        if(Gemstyne.CONFIG.lapisEnabled()) {
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstyneGeodePlaced.LAPIS_PLACED_KEY);
        }
    }

    private static void addOverworldOre(RegistryKey<PlacedFeature> ore) {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }
}
