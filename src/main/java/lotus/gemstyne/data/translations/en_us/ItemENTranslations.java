package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.ItemHandler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

abstract class ItemENTranslations extends FabricLanguageProvider {
    protected ItemENTranslations(FabricDataOutput dataOutput) { super(dataOutput); }

    protected static void translateItems(TranslationBuilder translationBuilder) {
        // //////////
        // ///// Items /////
        // //////////
        translationBuilder.add(ItemHandler.IKARITE, "Ikarite");
        translationBuilder.add(ItemHandler.GARNET, "Garnet");
        translationBuilder.add(ItemHandler.MORKITE, "Morkite");

        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.ALDUS);
        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.BRONZE);
        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.CRIMONITE);
        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.MOCHITE);
        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.MUTALIUM);
        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.TIN);
        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.TORRIUM);
        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.URANIUM);

        translationBuilder.add(ItemHandler.FIRE_OPAL, "Fire Opal");

        translationBuilder.add(ItemHandler.Pyrite.raw(), "Raw Pyrite");

        translationBuilder.add(ItemHandler.IMBUED_ROD, "Imbued Rod");
        translationBuilder.add(ItemHandler.IMBUED_FEATHER, "Imbued Feather");

        translationBuilder.add(GemstyneFluids.LIQUID_MORKITE_BUCKET, "Liquid Morkite Bucket");
    }
}
