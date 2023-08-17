package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

abstract class GemstyneOreENTranslations extends FabricLanguageProvider {
    protected GemstyneOreENTranslations(FabricDataOutput dataOutput) {
        super(dataOutput);
    }


    protected static void generateEnglishOreTranslations(TranslationBuilder translationBuilder) {
        // ======
        // <===== Raw Ores =====>
        // ======
        translationBuilder.add(GemstyneOreItems.RAW_MOCHITE, "Raw Mochite");
        translationBuilder.add(GemstyneOreItems.RAW_TIN, "Raw Tin");
        translationBuilder.add(GemstyneOreItems.RAW_URANIUM, "Raw Uranium");
        translationBuilder.add(GemstyneOreItems.RAW_CRIMONITE, "Raw Crimonite");
        translationBuilder.add(GemstyneOreItems.RAW_ALDUS, "Raw Aldus");
        translationBuilder.add(GemstyneOreItems.IKARITE, "Ikarite");
        translationBuilder.add(GemstyneOreItems.GARNET, "Garnet");
        translationBuilder.add(GemstyneOreItems.MORKITE, "Morkite");

        // ======
        // <===== Refined Ores =====>
        // ======
        translationBuilder.add(GemstyneOreItems.MOCHITE, "Mochite");

        translationBuilder.add(GemstyneOreItems.TIN_INGOT, "Tin Ingot");

        translationBuilder.add(GemstyneOreItems.BRONZE_INGOT, "Bronze Ingot");
        translationBuilder.add(GemstyneOreItems.BRONZE_RING, "Bronze Ring");
        translationBuilder.add(GemstyneOreItems.BRONZE_NUGGET, "Bronze Nugget");

        translationBuilder.add(GemstyneOreItems.URANIUM_CHUNK, "Uranium Chunk");
        translationBuilder.add(GemstyneOreItems.URANIUM_INGOT, "Uranium Ingot");

        translationBuilder.add(GemstyneOreItems.CRIMONITE_CHUNK, "Crimonite Chunk");
        translationBuilder.add(GemstyneOreItems.CRIMONITE_INGOT, "Crimonite Ingot");

        translationBuilder.add(GemstyneOreItems.ALDUS_INGOT, "Aldus Ingot");

        translationBuilder.add(GemstyneOreItems.FIRE_OPAL, "Fire Opal");

        // ======
        // <===== Ores =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.MOCHITE_ORE, "Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE, "Deepslate Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.RAW_MOCHITE_BLOCK, "Raw Mochite Block");

        translationBuilder.add(GemstyneOreBlocks.TIN_ORE, "Tin Ore");
        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");
        translationBuilder.add(GemstyneOreBlocks.RAW_TIN_BLOCK, "Raw Tin Block");

        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE, "Deepslate Uranium Ore");
        translationBuilder.add(GemstyneOreBlocks.RAW_URANIUM_BLOCK, "Raw Uranium Block");

        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, "Deepslate Morkite Ore");
        translationBuilder.add(GemstyneOreBlocks.MORKITE_BLOCK, "Morkite Block");

        translationBuilder.add(GemstyneOreBlocks.NETHER_CRIMONITE_ORE, "Nether Crimonite Ore");
        translationBuilder.add(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK, "Raw Crimonite Block");

        translationBuilder.add(GemstyneOreBlocks.NETHER_ALDUS_ORE, "Nether Aldus Ore");
        translationBuilder.add(GemstyneOreBlocks.RAW_ALDUS_BLOCK, "Raw Aldus Block");

        translationBuilder.add(
                GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE,
                "Compressed Granite Fire Opal Ore");

        // ======
        // <===== Ore Extensions =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE,
                "Compressed Granite Coal Ore");

        // ======
        // <===== Geodes =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.GARNET_CLUSTER, "Garnet Cluster");
        translationBuilder.add(GemstyneOreBlocks.LARGE_GARNET_BUD, "Large Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.MEDIUM_GARNET_BUD, "Medium Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.SMALL_GARNET_BUD, "Small Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.GARNET_BLOCK, "Garnet Block");
        translationBuilder.add(GemstyneOreBlocks.BUDDING_GARNET, "Budding Garnet");

        translationBuilder.add(GemstyneOreBlocks.IKARITE_CLUSTER, "Ikarite Cluster");
        translationBuilder.add(GemstyneOreBlocks.LARGE_IKARITE_BUD, "Large Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.MEDIUM_IKARITE_BUD, "Medium Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.SMALL_IKARITE_BUD, "Small Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.IKARITE_BLOCK, "Ikarite Block");
        translationBuilder.add(GemstyneOreBlocks.BUDDING_IKARITE, "Budding Ikarite");

        // ======
        // <===== Minerals =====>
        // ======
        translationBuilder.add(GemstyneMineralBlocks.MINERAL_BLOCKS.halite(), "Halite");
        translationBuilder.add(GemstyneMineralBlocks.MINERAL_BLOCKS.pumice(), "Pumice");
        translationBuilder.add(GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro(), "Gabbro");

        translationBuilder.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt(), "Compact Dirt");

        translationBuilder.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite(), "Compressed Andesite");
        translationBuilder.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite(), "Compressed Diorite");
        translationBuilder.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite(), "Compressed Granite");
    }
}
