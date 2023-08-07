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
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.rawMochite(), "Raw Mochite");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.rawTin(), "Raw Tin");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.rawUranium(), "Raw Uranium");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.rawCrimonite(), "Raw Crimonite");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.rawAldus(), "Raw Aldus");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.ikarite(), "Ikarite");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.garnet(), "Garnet");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.morkite(), "Morkite");

        // ======
        // <===== Refined Ores =====>
        // ======
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.mochite(), "Mochite");

        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.tinIngot(), "Tin Ingot");

        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.bronzeIngot(), "Bronze Ingot");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.bronzeRing(), "Bronze Ring");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.bronzeNugget(), "Bronze Nugget");

        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.uraniumChunk(), "Uranium Chunk");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.uraniumIngot(), "Uranium Ingot");

        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.crimoniteChunk(), "Crimonite Chunk");
        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.crimoniteIngot(), "Crimonite Ingot");

        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.aldusIngot(), "Aldus Ingot");

        translationBuilder.add(GemstyneOreItems.ORE_ITEMS.fireOpal(), "Fire Opal");

        // ======
        // <===== Ores =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.mochiteOre(), "Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMochiteOre(), "Deepslate Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.rawMochiteBlock(), "Raw Mochite Block");

        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.tinOre(), "Tin Ore");
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.deepslateTinOre(), "Deepslate Tin Ore");
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.rawTinBlock(), "Raw Tin Block");

        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.deepslateUraniumOre(), "Deepslate Uranium Ore");
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.rawUraniumBlock(), "Raw Uranium Block");

        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMorkiteOre(), "Deepslate Morkite Ore");
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.morkiteBlock(), "Morkite Block");

        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.netherCrimoniteOre(), "Nether Crimonite Ore");
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.rawCrimoniteBlock(), "Raw Crimonite Block");

        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.netherAldusOre(), "Nether Aldus Ore");
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.rawAldusBlock(), "Raw Aldus Block");

        translationBuilder.add(
                GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteFireOpalOre(),
                "Compressed Granite Fire Opal Ore");

        // ======
        // <===== Ore Extensions =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteCoalOre(),
                "Compressed Granite Coal Ore");

        // ======
        // <===== Geodes =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.ikariteBlock(), "Ikarite Block");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.buddingIkarite(), "Budding Ikarite");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.ikariteCluster(), "Ikarite Cluster");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.largeIkariteBud(), "Large Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.mediumIkariteBud(), "Medium Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud(), "Small Ikarite Bud");

        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.garnetBlock(), "Garnet Block");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.buddingGarnet(), "Budding Garnet");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.garnetCluster(), "Garnet Cluster");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.largeGarnetBud(), "Large Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.mediumGarnetBud(), "Medium Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.GEODE_BLOCKS.smallGarnetBud(), "Small Garnet Bud");

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
