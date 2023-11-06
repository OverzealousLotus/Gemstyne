package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.block.GemstyneBlockHandler;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.block.util.GemstyneBlockSet;
import lotus.gemstyne.block.util.GemstyneGeodeSet;
import lotus.gemstyne.item.GemstyneItemSet;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import lotus.gemstyne.util.GemstyneConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.jetbrains.annotations.NotNull;

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

        // //////////
        // ///// Blocks /////
        // //////////
        addTranslationSet(translationBuilder, GemstyneOreBlocks.ALDUS);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.BUBBLEGEM);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.CRIMONITE);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.ENDER_PEARL);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.MOCHITE);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.MUTALIUM);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.TIN);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.TORRIUM);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.URANIUM);

        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, "Deepslate Morkite Ore");
        translationBuilder.add(GemstyneOreBlocks.MORKITE_BLOCK, "Morkite Block");

        translationBuilder.add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE, "Compressed Granite Fire Opal Ore");

        translationBuilder.add(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE, "Compressed Granite Coal Ore");

        // //////////
        // ///// Geodes /////
        // //////////
        addTranslationSet(translationBuilder, GemstyneOreBlocks.GARNET);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.LAPIS);
        addTranslationSet(translationBuilder, GemstyneOreBlocks.IKARITE);

        // //////////
        // ///// Minerals /////
        // //////////
        translationBuilder.add(GemstyneBlockHandler.HALITE, "Halite");
        translationBuilder.add(GemstyneBlockHandler.PUMICE, "Pumice");
        translationBuilder.add(GemstyneBlockHandler.GABBRO, "Gabbro");

        translationBuilder.add(GemstyneBlockHandler.COMPACT_DIRT, "Compact Dirt");

        translationBuilder.add(GemstyneBlockHandler.COMPRESSED_ANDESITE, "Compressed Andesite");
        translationBuilder.add(GemstyneBlockHandler.COMPRESSED_DIORITE, "Compressed Diorite");
        translationBuilder.add(GemstyneBlockHandler.COMPRESSED_GRANITE, "Compressed Granite");
    }

    /**
     * Generates English translations for a {@link GemstyneBlockSet}
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param blockSet {@link GemstyneBlockSet}
     */
    private static void addTranslationSet(TranslationBuilder translationBuilder, @NotNull GemstyneBlockSet blockSet) {
        String setName = StringUtils.replace(blockSet.getSetName(), "_", " ");
        blockSet.getBlockMap().forEach((blockType, blockPair) -> {
            switch (blockType) {
                case GemstyneConstants.STONE -> translationBuilder.add(blockPair.block(), WordUtils.capitalizeFully(setName) + " Ore");
                case "raw" -> translationBuilder.add(blockPair.block(), "Raw " + WordUtils.capitalizeFully(setName) + " Block");
                case "pure" -> translationBuilder.add(blockPair.block(), WordUtils.capitalizeFully(setName) + " Block");
                default -> translationBuilder.add(blockPair.block(), WordUtils.capitalizeFully(blockType) + " " + WordUtils.capitalizeFully(setName) + " Ore");
            }
        });
    }

    /**
     * Generates English translations for a {@link GemstyneItemSet}
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param itemSet {@link GemstyneItemSet}
     */
    private static void addTranslationSet(TranslationBuilder translationBuilder, @NotNull GemstyneItemSet itemSet) {
        itemSet.getItemMap().forEach((itemType, itemPair) -> {
            switch (itemType) {
                case "raw" -> translationBuilder.add(itemPair.item(), "Raw " + WordUtils.capitalizeFully(itemSet.getSetName()));
                case "singleton" -> translationBuilder.add(itemPair.item(), WordUtils.capitalizeFully(itemSet.getSetName()));
                default -> translationBuilder.add(itemPair.item(), WordUtils.capitalizeFully(itemSet.getSetName()) + " " + WordUtils.capitalizeFully(itemType));
            }
        });
    }

    /**
     * Generates English translations for a {@link GemstyneGeodeSet}
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param geodeSet {@link GemstyneGeodeSet}
     */
    private static void addTranslationSet(TranslationBuilder translationBuilder, @NotNull GemstyneGeodeSet geodeSet) {
        geodeSet.getGeodeMap().forEach((geodeType, geodePair) -> {
            switch (geodeType) {
                case GemstyneConstants.BLOCK -> translationBuilder.add(geodePair.block(), WordUtils.capitalizeFully(geodeSet.getSetName()) + " " + WordUtils.capitalizeFully(GemstyneConstants.BLOCK));
                case "budding" -> translationBuilder.add(geodePair.block(), WordUtils.capitalizeFully(geodeType) + " " + WordUtils.capitalizeFully(geodeSet.getSetName()));
                case "cluster" -> translationBuilder.add(geodePair.block(), WordUtils.capitalizeFully(geodeSet.getSetName()) + " " + WordUtils.capitalizeFully(geodeType));
                default -> translationBuilder.add(geodePair.block(), WordUtils.capitalizeFully(geodeType) + " " + WordUtils.capitalizeFully(geodeSet.getSetName()) + " Bud");
            }
        });
    }
}
