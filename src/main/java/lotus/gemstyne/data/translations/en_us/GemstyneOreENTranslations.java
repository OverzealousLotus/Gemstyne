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
        translationBuilder.add(GemstyneOreItems.TIN.RAW, "Raw Tin");
        translationBuilder.add(GemstyneOreItems.URANIUM.RAW, "Raw Uranium");
        translationBuilder.add(GemstyneOreItems.CRIMONITE.RAW, "Raw Crimonite");
        translationBuilder.add(GemstyneOreItems.ALDUS.RAW, "Raw Aldus");
        translationBuilder.add(GemstyneOreItems.IKARITE, "Ikarite");
        translationBuilder.add(GemstyneOreItems.GARNET, "Garnet");
        translationBuilder.add(GemstyneOreItems.MORKITE, "Morkite");

        // ======
        // <===== Refined Ores =====>
        // ======
        translationBuilder.add(GemstyneOreItems.MOCHITE, "Mochite");

        translationBuilder.add(GemstyneOreItems.TIN.INGOT, "Tin Ingot");

        translationBuilder.add(GemstyneOreItems.BRONZE.INGOT, "Bronze Ingot");
        translationBuilder.add(GemstyneOreItems.BRONZE.CHAIN, "Bronze Ring");
        translationBuilder.add(GemstyneOreItems.BRONZE.NUGGET, "Bronze Nugget");

        translationBuilder.add(GemstyneOreItems.URANIUM.LUMP, "Uranium Chunk");
        translationBuilder.add(GemstyneOreItems.URANIUM.INGOT, "Uranium Ingot");

        translationBuilder.add(GemstyneOreItems.CRIMONITE.LUMP, "Crimonite Chunk");
        translationBuilder.add(GemstyneOreItems.CRIMONITE.INGOT, "Crimonite Ingot");

        translationBuilder.add(GemstyneOreItems.ALDUS.INGOT, "Aldus Ingot");

        translationBuilder.add(GemstyneOreItems.FIRE_OPAL, "Fire Opal");

        // ======
        // <===== Ores =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_TORRIUM, "Deepslate Torrium Ore");

        translationBuilder.add(GemstyneOreBlocks.MOCHITE.stoneOre(), "Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.MOCHITE.deepslateOre(), "Deepslate Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.MOCHITE.rawBlock, "Raw Mochite Block");

        translationBuilder.add(GemstyneOreBlocks.TIN.stoneOre(), "Tin Ore");
        translationBuilder.add(GemstyneOreBlocks.TIN.deepslateOre(), "Deepslate Tin Ore");
        translationBuilder.add(GemstyneOreBlocks.TIN.rawBlock, "Raw Tin Block");

        translationBuilder.add(GemstyneOreBlocks.URANIUM.deepslateOre(), "Deepslate Uranium Ore");
        translationBuilder.add(GemstyneOreBlocks.URANIUM.rawBlock, "Raw Uranium Block");

        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, "Deepslate Morkite Ore");
        translationBuilder.add(GemstyneOreBlocks.MORKITE_BLOCK, "Morkite Block");

        translationBuilder.add(GemstyneOreBlocks.CRIMONITE.netherOre(), "Nether Crimonite Ore");
        translationBuilder.add(GemstyneOreBlocks.CRIMONITE.rawBlock, "Raw Crimonite Block");

        translationBuilder.add(GemstyneOreBlocks.ALDUS.netherOre(), "Nether Aldus Ore");
        translationBuilder.add(GemstyneOreBlocks.ALDUS.rawBlock, "Raw Aldus Block");

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
        translationBuilder.add(GemstyneMineralBlocks.HALITE, "Halite");
        translationBuilder.add(GemstyneMineralBlocks.PUMICE, "Pumice");
        translationBuilder.add(GemstyneMineralBlocks.GABBRO, "Gabbro");

        translationBuilder.add(GemstyneMineralBlocks.COMPACT_DIRT, "Compact Dirt");

        translationBuilder.add(GemstyneMineralBlocks.COMPRESSED_ANDESITE, "Compressed Andesite");
        translationBuilder.add(GemstyneMineralBlocks.COMPRESSED_DIORITE, "Compressed Diorite");
        translationBuilder.add(GemstyneMineralBlocks.COMPRESSED_GRANITE, "Compressed Granite");
    }
}
