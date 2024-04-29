package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.armor.ArmorHandler;
import lotus.gemstyne.tool.ToolHandler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

abstract class EquipmentENTranslations extends FabricLanguageProvider {
    protected EquipmentENTranslations(FabricDataOutput dataOutput) {
        super(dataOutput);
    }


    protected static void generateEnglishEquipmentTranslations(TranslationBuilder translationBuilder) {
        // ======
        // <===== Armor =====>
        // ======
        translationBuilder.add(ArmorHandler.IKARITE_ELYTRA, "Ikarite Elytra");
        GemstyneENProvider.translateSet(translationBuilder, ArmorHandler.ALDUS);
        GemstyneENProvider.translateSet(translationBuilder, ArmorHandler.BRONZEMAIL);
        GemstyneENProvider.translateSet(translationBuilder, ArmorHandler.BRONZEPLATE);
        GemstyneENProvider.translateSet(translationBuilder, ArmorHandler.RENDFIRE);

        // ======
        // <===== Tools =====>
        // ======
        GemstyneENProvider.translateSet(translationBuilder, ToolHandler.ALDUS);
        GemstyneENProvider.translateSet(translationBuilder, ToolHandler.BRONZE);
        GemstyneENProvider.translateSet(translationBuilder, ToolHandler.MUTALIUM);
        GemstyneENProvider.translateSet(translationBuilder, ToolHandler.RENDFIRE);
    }
}
