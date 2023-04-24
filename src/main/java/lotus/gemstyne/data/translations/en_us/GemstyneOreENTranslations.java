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
        translationBuilder.add(GemstyneOreBlocks.getMochiteOre(), "Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.getDeepslateMochiteOre(), "Deepslate Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.getRawMochiteBlock(), "Raw Mochite Block");

        translationBuilder.add(GemstyneOreBlocks.getTinOre(), "Tin Ore");
        translationBuilder.add(GemstyneOreBlocks.getDeepslateTinOre(), "Deepslate Tin Ore");
        translationBuilder.add(GemstyneOreBlocks.getRawTinBlock(), "Raw Tin Block");

        translationBuilder.add(GemstyneOreBlocks.getDeepslateUraniumOre(), "Deepslate Uranium Ore");
        translationBuilder.add(GemstyneOreBlocks.getRawUraniumBlock(), "Raw Uranium Block");

        translationBuilder.add(GemstyneOreBlocks.getDeepslateMorkiteOre(), "Deepslate Morkite Ore");
        translationBuilder.add(GemstyneOreBlocks.getMorkiteBlock(), "Morkite Block");

        translationBuilder.add(GemstyneOreBlocks.getNetherCrimoniteOre(), "Nether Crimonite Ore");
        translationBuilder.add(GemstyneOreBlocks.getRawCrimoniteBlock(), "Raw Crimonite Block");

        translationBuilder.add(GemstyneOreBlocks.getNetherAldusOre(), "Nether Aldus Ore");
        translationBuilder.add(GemstyneOreBlocks.getRawAldusBlock(), "Raw Aldus Block");

        translationBuilder.add(
                GemstyneOreBlocks.getCompressedGraniteFireOpalOre(), "Compressed Granite Fire Opal Ore");

        // ======
        // <===== Ore Extensions =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.getCompressedGraniteCoalOre(), "Compressed Granite Coal Ore");

        // ======
        // <===== Geodes =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.getIkariteBlock(), "Ikarite Block");
        translationBuilder.add(GemstyneOreBlocks.getBuddingIkarite(), "Budding Ikarite");
        translationBuilder.add(GemstyneOreBlocks.getIkariteCluster(), "Ikarite Cluster");
        translationBuilder.add(GemstyneOreBlocks.getLargeIkariteBud(), "Large Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.getMediumIkariteBud(), "Medium Ikarite Bud");
        translationBuilder.add(GemstyneOreBlocks.getSmallIkariteBud(), "Small Ikarite Bud");

        translationBuilder.add(GemstyneOreBlocks.getGarnetBlock(), "Garnet Block");
        translationBuilder.add(GemstyneOreBlocks.getBuddingGarnet(), "Budding Garnet");
        translationBuilder.add(GemstyneOreBlocks.getGarnetCluster(), "Garnet Cluster");
        translationBuilder.add(GemstyneOreBlocks.getLargeGarnetBud(), "Large Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.getMediumGarnetBud(), "Medium Garnet Bud");
        translationBuilder.add(GemstyneOreBlocks.getSmallGarnetBud(), "Small Garnet Bud");

        // ======
        // <===== Minerals =====>
        // ======
        translationBuilder.add(GemstyneMineralBlocks.getHALITE(), "Halite");
        translationBuilder.add(GemstyneMineralBlocks.getPUMICE(), "Pumice");

        translationBuilder.add(GemstyneMineralBlocks.getCompactDirt(), "Compact Dirt");

        translationBuilder.add(GemstyneMineralBlocks.getCompressedAndesite(), "Compressed Andesite");
        translationBuilder.add(GemstyneMineralBlocks.getCompressedDiorite(), "Compressed Diorite");
        translationBuilder.add(GemstyneMineralBlocks.getCompressedGranite(), "Compressed Granite");
    }
}
