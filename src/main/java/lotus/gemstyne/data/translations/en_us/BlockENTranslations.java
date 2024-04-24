package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.block.BlockHandler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

abstract class BlockENTranslations extends FabricLanguageProvider {
    protected BlockENTranslations(FabricDataOutput dataOutput) { super(dataOutput); }


    protected static void translateBlocks(TranslationBuilder translationBuilder) {
        // //////////
        // ///// Blocks /////
        // //////////
        translationBuilder.add(BlockHandler.THERMO_TNT_BLOCK, "Thermonuclear TNT");
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.AETHERIUM);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.ALDUS);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.BUBBLEGEM);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.BLAZITE);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.CRIMONITE);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.ENDER_PEARL);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.FIRE_OPAL);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.MOCHITE);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.MUTALIUM);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.MORKITE);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.TIN);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.TORRIUM);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.URANIUM);

        translationBuilder.add(BlockHandler.COMPRESSED_GRANITE_COAL_ORE, "Compressed Granite Coal Ore");

        // //////////
        // ///// Geodes /////
        // //////////
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.GARNET);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.LAPIS);
        GemstyneENProvider.translateSet(translationBuilder, BlockHandler.IKARITE);

        // //////////
        // ///// Minerals /////
        // //////////
        translationBuilder.add(BlockHandler.HALITE, "Halite");
        translationBuilder.add(BlockHandler.PUMICE, "Pumice");
        translationBuilder.add(BlockHandler.GABBRO, "Gabbro");

        translationBuilder.add(BlockHandler.COMPACT_DIRT, "Compact Dirt");

        translationBuilder.add(BlockHandler.COMPRESSED_ANDESITE, "Compressed Andesite");
        translationBuilder.add(BlockHandler.COMPRESSED_DIORITE, "Compressed Diorite");
        translationBuilder.add(BlockHandler.COMPRESSED_GRANITE, "Compressed Granite");
    }
}
