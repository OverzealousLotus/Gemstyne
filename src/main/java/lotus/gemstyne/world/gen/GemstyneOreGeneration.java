package lotus.gemstyne.world.gen;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.world.GemstynePlacedFeatures;
import lotus.gemstyne.world.GemstyneWorldHandler;
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
        if (Gemstyne.CONFIG.oreConfiguration.mochiteEnabled()) {
            addOverworldOre(GemstyneWorldHandler.MOCHITE.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(GemstyneWorldHandler.MOCHITE.fetchPlacedKey(GemstyneConstants.LARGE));
            addOverworldOre(GemstyneOrePlaced.getMochiteOreRawPlacedKey());
        }

        if (Gemstyne.CONFIG.oreConfiguration.tinEnabled()) {
            addOverworldOre(GemstyneWorldHandler.TIN.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(GemstyneWorldHandler.TIN.fetchPlacedKey(GemstyneConstants.LARGE));
            addOverworldOre(GemstyneOrePlaced.getTinOreRawPlacedKey());
        }

        if(Gemstyne.CONFIG.oreConfiguration.uraniumEnabled()) {
            addOverworldOre(GemstyneWorldHandler.URANIUM.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(GemstyneWorldHandler.URANIUM.fetchPlacedKey(GemstyneConstants.LARGE));
            addOverworldOre(GemstyneOrePlaced.getUraniumOreRawPlacedKey());
        }

        if(Gemstyne.CONFIG.oreConfiguration.morkiteEnabled()) {
            addOverworldOre(GemstyneOrePlaced.getMorkiteOreBuriedPlacedKey());
            addOverworldOre(GemstyneOrePlaced.getMorkiteOreExposedPlacedKey());
            addOverworldOre(GemstyneOrePlaced.getMorkiteOreRawPlacedKey());
        }

        addOverworldOre(GemstyneOrePlaced.getCompressedCoalOrePlacedKey());
        addOverworldOre(GemstyneOrePlaced.getFireOpalOrePlacedKey());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, GemstynePlacedFeatures.LIQUID_MORKITE_PLACED_KEY);
        // =====
        // <=====| The Nether |=====>
        // =====
        if(Gemstyne.CONFIG.oreConfiguration.aldusEnabled()) {
            addNetherOre(GemstyneWorldHandler.ALDUS.fetchPlacedKey(GemstyneConstants.SMALL));
            addNetherOre(GemstyneWorldHandler.ALDUS.fetchPlacedKey(GemstyneConstants.LARGE));
        }

        if(Gemstyne.CONFIG.oreConfiguration.crimoniteEnabled()) {
            addNetherOre(GemstyneWorldHandler.CRIMONITE.fetchPlacedKey(GemstyneConstants.SMALL));
            addNetherOre(GemstyneWorldHandler.CRIMONITE.fetchPlacedKey(GemstyneConstants.LARGE));
        }

        // =====
        // <=====| The End |=====>
        // =====


        // =====
        // <=====| Multi-Dimensional  |=====>
        // =====
        if(Gemstyne.CONFIG.oreConfiguration.torriumEnabled()) {
            addOverworldOre(GemstyneWorldHandler.TORRIUM.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(GemstyneWorldHandler.TORRIUM.fetchPlacedKey(GemstyneConstants.LARGE));
            addNetherOre(GemstyneWorldHandler.TORRIUM.fetchPlacedKey(GemstyneConstants.NETHER));
        }

        if(Gemstyne.CONFIG.oreConfiguration.mutaliumEnabled()) {
            addOverworldOre(GemstyneWorldHandler.MUTALIUM.fetchPlacedKey(GemstyneConstants.SMALL));
            addOverworldOre(GemstyneWorldHandler.MUTALIUM.fetchPlacedKey(GemstyneConstants.LARGE));
            addNetherOre(GemstyneWorldHandler.MUTALIUM.fetchPlacedKey(GemstyneConstants.NETHER));
            addEndOre(GemstyneWorldHandler.MUTALIUM.fetchPlacedKey(GemstyneConstants.END));
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
