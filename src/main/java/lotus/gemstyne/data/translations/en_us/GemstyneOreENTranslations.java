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
        translationBuilder.add(GemstyneOreItems.MOCHITE.raw(), "Raw Mochite");
        translationBuilder.add(GemstyneOreItems.TIN.raw(), "Raw Tin");
        translationBuilder.add(GemstyneOreItems.URANIUM.raw(), "Raw Uranium");
        translationBuilder.add(GemstyneOreItems.CRIMONITE.raw(), "Raw Crimonite");
        translationBuilder.add(GemstyneOreItems.ALDUS.raw(), "Raw Aldus");
        translationBuilder.add(GemstyneOreItems.IKARITE, "Ikarite");
        translationBuilder.add(GemstyneOreItems.GARNET, "Garnet");
        translationBuilder.add(GemstyneOreItems.MORKITE, "Morkite");

        // ======
        // <===== Refined Ores =====>
        // ======
        translationBuilder.add(GemstyneOreItems.MOCHITE.crystal(), "Mochite");

        translationBuilder.add(GemstyneOreItems.TIN.ingot(), "Tin Ingot");

        translationBuilder.add(GemstyneOreItems.BRONZE.ingot(), "Bronze Ingot");
        translationBuilder.add(GemstyneOreItems.BRONZE.chain(), "Bronze Ring");
        translationBuilder.add(GemstyneOreItems.BRONZE.nugget(), "Bronze Nugget");

        translationBuilder.add(GemstyneOreItems.URANIUM.nugget(), "Uranium Nugget");
        translationBuilder.add(GemstyneOreItems.URANIUM.chunk(), "Uranium Chunk");
        translationBuilder.add(GemstyneOreItems.URANIUM.ingot(), "Uranium Ingot");

        translationBuilder.add(GemstyneOreItems.CRIMONITE.nugget(), "Crimonite Nugget");
        translationBuilder.add(GemstyneOreItems.CRIMONITE.chunk(), "Crimonite Chunk");
        translationBuilder.add(GemstyneOreItems.CRIMONITE.ingot(), "Crimonite Ingot");

        translationBuilder.add(GemstyneOreItems.ALDUS.nugget(), "Aldus Nugget");
        translationBuilder.add(GemstyneOreItems.ALDUS.ingot(), "Aldus Ingot");

        translationBuilder.add(GemstyneOreItems.FIRE_OPAL, "Fire Opal");

        // ======
        // <===== Ores =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.TORRIUM.stoneOre(), "Torrium Ore");
        translationBuilder.add(GemstyneOreBlocks.TORRIUM.deepslateOre(), "Deepslate Torrium Ore");
        translationBuilder.add(GemstyneOreBlocks.TORRIUM.netherOre(), "Nether Torrium Ore");

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
        translationBuilder.add(GemstyneOreBlocks.GARNET.clusterBud(), "Garnet Cluster");
        translationBuilder.add(GemstyneOreBlocks.GARNET.largeBud(), "Large Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.GARNET.mediumBud(), "Medium Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.GARNET.smallBud(), "Small Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.GARNET.pureBlock(), "Garnet Block");
        translationBuilder.add(GemstyneOreBlocks.GARNET.buddingBlock(), "Budding Garnet");

        translationBuilder.add(GemstyneOreBlocks.LAPIS.clusterBud(), "Lapis Cluster");
        translationBuilder.add(GemstyneOreBlocks.LAPIS.largeBud(), "Large Lapis Bud");
        translationBuilder.add(GemstyneOreBlocks.LAPIS.mediumBud(), "Medium Lapis Bud");
        translationBuilder.add(GemstyneOreBlocks.LAPIS.smallBud(), "Small Lapis Bud");
        translationBuilder.add(GemstyneOreBlocks.LAPIS.buddingBlock(), "Budding Lapis");

        translationBuilder.add(GemstyneOreBlocks.IKARITE.clusterBud(), "Ikarite Cluster");
        translationBuilder.add(GemstyneOreBlocks.IKARITE.largeBud(), "Large Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.IKARITE.mediumBud(), "Medium Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.IKARITE.smallBud(), "Small Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.IKARITE.pureBlock(), "Ikarite Block");
        translationBuilder.add(GemstyneOreBlocks.IKARITE.buddingBlock(), "Budding Ikarite");

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
