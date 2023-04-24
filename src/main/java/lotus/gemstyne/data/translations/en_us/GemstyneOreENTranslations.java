package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.GemstyneOreItems;
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
        translationBuilder.add(GemstyneOreItems.getRawMochite(), "Raw Mochite");
        translationBuilder.add(GemstyneOreItems.getRawTin(), "Raw Tin");
        translationBuilder.add(GemstyneOreItems.getRawUranium(), "Raw Uranium");
        translationBuilder.add(GemstyneOreItems.getRawCrimonite(), "Raw Crimonite");
        translationBuilder.add(GemstyneOreItems.getRawAldus(), "Raw Aldus");
        translationBuilder.add(GemstyneOreItems.getIkarite(), "Ikarite");
        translationBuilder.add(GemstyneOreItems.getGarnet(), "Garnet");
        translationBuilder.add(GemstyneOreItems.getMorkite(), "Morkite");

        // ======
        // <===== Refined Ores =====>
        // ======
        translationBuilder.add(GemstyneOreItems.getMochite(), "Mochite");

        translationBuilder.add(GemstyneOreItems.getTinIngot(), "Tin Ingot");

        translationBuilder.add(GemstyneOreItems.getUraniumChunk(), "Uranium Chunk");
        translationBuilder.add(GemstyneOreItems.getUraniumIngot(), "Uranium Ingot");

        translationBuilder.add(GemstyneOreItems.getCrimoniteChunk(), "Crimonite Chunk");
        translationBuilder.add(GemstyneOreItems.getCrimoniteIngot(), "Crimonite Ingot");

        translationBuilder.add(GemstyneOreItems.getAldusIngot(), "Aldus Ingot");

        translationBuilder.add(GemstyneOreItems.getFireOpal(), "Fire Opal");

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
                GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE, "Compressed Granite Fire Opal Ore");

        // ======
        // <===== Ore Extensions =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE, "Compressed Granite Coal Ore");

        // ======
        // <===== Geodes =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.IKARITE_BLOCK, "Ikarite Block");
        translationBuilder.add(GemstyneOreBlocks.BUDDING_IKARITE, "Budding Ikarite");
        translationBuilder.add(GemstyneOreBlocks.IKARITE_CLUSTER, "Ikarite Cluster");
        translationBuilder.add(GemstyneOreBlocks.LARGE_IKARITE_BUD, "Large Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.MEDIUM_IKARITE_BUD, "Medium Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.SMALL_IKARITE_BUD, "Small Ikarite Bud");

        translationBuilder.add(GemstyneOreBlocks.GARNET_BLOCK, "Garnet Block");
        translationBuilder.add(GemstyneOreBlocks.BUDDING_GARNET, "Budding Garnet");
        translationBuilder.add(GemstyneOreBlocks.GARNET_CLUSTER, "Garnet Cluster");
        translationBuilder.add(GemstyneOreBlocks.LARGE_GARNET_BUD, "Large Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.MEDIUM_GARNET_BUD, "Medium Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.SMALL_GARNET_BUD, "Small Garnet Bud");

        // ======
        // <===== Minerals =====>
        // ======
        translationBuilder.add(GemstyneMineralBlocks.HALITE, "Halite");

        translationBuilder.add(GemstyneMineralBlocks.COMPACT_DIRT, "Compact Dirt");

        translationBuilder.add(GemstyneMineralBlocks.COMPRESSED_ANDESITE, "Compressed Andesite");
        translationBuilder.add(GemstyneMineralBlocks.COMPRESSED_DIORITE, "Compressed Diorite");
        translationBuilder.add(GemstyneMineralBlocks.COMPRESSED_GRANITE, "Compressed Granite");
    }
}
