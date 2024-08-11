package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.fluid.FluidHandler;
import lotus.gemstyne.item.ItemHandler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

abstract class ItemENTranslations extends FabricLanguageProvider {
    protected ItemENTranslations(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    protected static void translateItems(TranslationBuilder translationBuilder) {
        // //////////
        // ///// Items /////
        // //////////
        translationBuilder.add(ItemHandler.IKARITE, "Ikarite");
        translationBuilder.add(ItemHandler.GARNET, "Garnet");
        translationBuilder.add(ItemHandler.MORKITE, "Morkite");

        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.ALDUS);
        GemstyneENProvider.translateSet(translationBuilder, ItemHandler.AETHERIUM);
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
        translationBuilder.add("tooltips.gemstyne.imbued_feather", "Do not fly too low, nor too high.");

        translationBuilder.add(FluidHandler.LIQUID_MORKITE_BUCKET, "Liquid Morkite Bucket");
    }
}
