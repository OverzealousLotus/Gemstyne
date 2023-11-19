package lotus.gemstyne.world.gen;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.world.GemstynePlacedFeatures;
import lotus.gemstyne.world.WorldHandler;
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
        // <=====| The Overworld |=====>
        // =====
        if (Gemstyne.CONFIG.oreConfiguration.bubblegemEnabled()) {
            addOverworldOre(WorldHandler.BUBBLEGEM.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(WorldHandler.BUBBLEGEM.fetchPlacedKey(GemstyneConstants.LARGE));
        }

        if (Gemstyne.CONFIG.oreConfiguration.mochiteEnabled()) {
            addOverworldOre(WorldHandler.MOCHITE.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(WorldHandler.MOCHITE.fetchPlacedKey(GemstyneConstants.LARGE));
            addOverworldOre(WorldHandler.MOCHITE.fetchPlacedKey(GemstyneConstants.RAW));
            addOverworldOre(WorldHandler.MOCHITE.fetchPlacedKey(GemstyneConstants.RICH));
        }

        if (Gemstyne.CONFIG.oreConfiguration.tinEnabled()) {
            addOverworldOre(WorldHandler.TIN.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(WorldHandler.TIN.fetchPlacedKey(GemstyneConstants.LARGE));
            addOverworldOre(WorldHandler.TIN.fetchPlacedKey(GemstyneConstants.RAW));
        }

        if(Gemstyne.CONFIG.oreConfiguration.uraniumEnabled()) {
            addOverworldOre(WorldHandler.URANIUM.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(WorldHandler.URANIUM.fetchPlacedKey(GemstyneConstants.LARGE));
            addOverworldOre(WorldHandler.URANIUM.fetchPlacedKey(GemstyneConstants.RAW));
        }

        if(Gemstyne.CONFIG.oreConfiguration.morkiteEnabled()) {
            addOverworldOre(WorldHandler.MORKITE.fetchPlacedKey(GemstyneConstants.BURIED));
            addOverworldOre(WorldHandler.MORKITE.fetchPlacedKey(GemstyneConstants.EXPOSED));
            addOverworldOre(WorldHandler.MORKITE.fetchPlacedKey(GemstyneConstants.RAW));
        }

        addOverworldOre(GemstyneOrePlaced.getCompressedCoalOrePlacedKey());
        addOverworldOre(GemstyneOrePlaced.getFireOpalOrePlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstynePlacedFeatures.LIQUID_MORKITE_PLACED_KEY);
        // =====
        // <=====| The Nether |=====>
        // =====
        if(Gemstyne.CONFIG.oreConfiguration.aldusEnabled()) {
            addNetherOre(WorldHandler.ALDUS.fetchPlacedKey(GemstyneConstants.SMALL));
            addNetherOre(WorldHandler.ALDUS.fetchPlacedKey(GemstyneConstants.LARGE));
        }

        if(Gemstyne.CONFIG.oreConfiguration.blaziteEnabled()) {
            addNetherOre(WorldHandler.BLAZITE.fetchPlacedKey(GemstyneConstants.SMALL));
            addNetherOre(WorldHandler.BLAZITE.fetchPlacedKey(GemstyneConstants.LARGE));
        }

        if(Gemstyne.CONFIG.oreConfiguration.crimoniteEnabled()) {
            addNetherOre(WorldHandler.CRIMONITE.fetchPlacedKey(GemstyneConstants.SMALL));
            addNetherOre(WorldHandler.CRIMONITE.fetchPlacedKey(GemstyneConstants.LARGE));
        }

        // =====
        // <=====| The End |=====>
        // =====


        // =====
        // <=====| Multi-Dimensional  |=====>
        // =====
        if(Gemstyne.CONFIG.oreConfiguration.enderPearlEnabled()) {
            addOverworldOre(WorldHandler.ENDER_PEARL.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(WorldHandler.ENDER_PEARL.fetchPlacedKey(GemstyneConstants.LARGE));
            addNetherOre(WorldHandler.ENDER_PEARL.fetchPlacedKey(GemstyneConstants.NETHER));
            addEndOre(WorldHandler.ENDER_PEARL.fetchPlacedKey(GemstyneConstants.END));
        }

        if(Gemstyne.CONFIG.oreConfiguration.torriumEnabled()) {
            addOverworldOre(WorldHandler.TORRIUM.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(WorldHandler.TORRIUM.fetchPlacedKey(GemstyneConstants.LARGE));
            addNetherOre(WorldHandler.TORRIUM.fetchPlacedKey(GemstyneConstants.NETHER));
        }

        if(Gemstyne.CONFIG.oreConfiguration.mutaliumEnabled()) {
            addOverworldOre(WorldHandler.MUTALIUM.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(WorldHandler.MUTALIUM.fetchPlacedKey(GemstyneConstants.LARGE));
            addNetherOre(WorldHandler.MUTALIUM.fetchPlacedKey(GemstyneConstants.NETHER));
            addEndOre(WorldHandler.MUTALIUM.fetchPlacedKey(GemstyneConstants.END));
        }

        // =====
        // <===== Minerals =====>
        // =====
        if(Gemstyne.CONFIG.oreConfiguration.mineralsEnabled()) {
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

    private static void addNetherOre(RegistryKey<PlacedFeature> ore) {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
            GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    private static void addEndOre(RegistryKey<PlacedFeature> ore) {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
            GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }
}
