package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.block.GemstyneBlockHandler;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.block.util.GemstyneBlockSet;
import lotus.gemstyne.item.GemstyneItemSet;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import lotus.gemstyne.util.GemstyneConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.apache.commons.lang3.StringUtils;

abstract class GemstyneOreENTranslations extends FabricLanguageProvider {
    protected GemstyneOreENTranslations(FabricDataOutput dataOutput) { super(dataOutput); }


    protected static void generateEnglishOreTranslations(TranslationBuilder translationBuilder) {
        // //////////
        // ///// Items /////
        // //////////
        translationBuilder.add(GemstyneOreItems.IKARITE, "Ikarite");
        translationBuilder.add(GemstyneOreItems.GARNET, "Garnet");
        translationBuilder.add(GemstyneOreItems.MORKITE, "Morkite");

        addTranslationSet(translationBuilder, GemstyneOreItems.ALDUS);
        addTranslationSet(translationBuilder, GemstyneOreItems.BRONZE);
        addTranslationSet(translationBuilder, GemstyneOreItems.CRIMONITE);
        addTranslationSet(translationBuilder, GemstyneOreItems.MOCHITE);
        addTranslationSet(translationBuilder, GemstyneOreItems.MUTALIUM);
        addTranslationSet(translationBuilder, GemstyneOreItems.TIN);
        addTranslationSet(translationBuilder, GemstyneOreItems.TORRIUM);
        addTranslationSet(translationBuilder, GemstyneOreItems.URANIUM);

        translationBuilder.add(GemstyneOreItems.FIRE_OPAL, "Fire Opal");

        // ======
        // <===== Blocks =====>
        // ======
        addTranslationSet(translationBuilder, GemstyneOreBlocks.ALDUS);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.BUBBLEGEM);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.CRIMONITE);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.MOCHITE);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.MUTALIUM);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.TIN);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.TORRIUM);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.URANIUM);

        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, "Deepslate Morkite Ore");
        translationBuilder.add(GemstyneOreBlocks.MORKITE_BLOCK, "Morkite Block");

        translationBuilder.add(
                GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE,
                "Compressed Granite Fire Opal Ore");

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
        translationBuilder.add(GemstyneBlockHandler.HALITE, "Halite");
        translationBuilder.add(GemstyneBlockHandler.PUMICE, "Pumice");
        translationBuilder.add(GemstyneBlockHandler.GABBRO, "Gabbro");

        translationBuilder.add(GemstyneBlockHandler.COMPACT_DIRT, "Compact Dirt");

        translationBuilder.add(GemstyneBlockHandler.COMPRESSED_ANDESITE, "Compressed Andesite");
        translationBuilder.add(GemstyneBlockHandler.COMPRESSED_DIORITE, "Compressed Diorite");
        translationBuilder.add(GemstyneBlockHandler.COMPRESSED_GRANITE, "Compressed Granite");
    }

    /**
     * Automatically generates English translations.
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param blockSet {@link GemstyneBlockSet}
     */
    private static void addTranslationSet(TranslationBuilder translationBuilder, GemstyneBlockSet blockSet) {
        blockSet.getBlockMap().forEach((blockType, blockPair) -> {
            switch (blockType) {
                case GemstyneConstants.STONE -> translationBuilder.add(blockPair.block(), StringUtils.capitalize(blockSet.getSetName()) + " Ore");
                case "raw" -> translationBuilder.add(blockPair.block(), "Raw " + StringUtils.capitalize(blockSet.getSetName()) + " Block");
                case "pure" -> translationBuilder.add(blockPair.block(), StringUtils.capitalize(blockSet.getSetName()) + " Block");
                default -> translationBuilder.add(blockPair.block(), StringUtils.capitalize(blockType) + " " + StringUtils.capitalize(blockSet.getSetName()) + " Ore");
            }
        });
    }

    /**
     * Automatically generates English translations.
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param itemSet {@link GemstyneItemSet}
     */
    private static void addTranslationSet(TranslationBuilder translationBuilder, GemstyneItemSet itemSet) {
        itemSet.getItemMap().forEach((itemType, itemPair) -> {
            if (itemType.equals("raw")) {
                translationBuilder.add(itemPair.item(), "Raw " + StringUtils.capitalize(itemSet.getSetName()));
            } else {
                translationBuilder.add(itemPair.item(), StringUtils.capitalize(itemSet.getSetName()) + " " + StringUtils.capitalize(itemType));
            }
        });
    }
}
