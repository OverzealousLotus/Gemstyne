package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.tool.GemstyneToolItems;
import lotus.gemstyne.tool.GemstyneToolSet;
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
        GemstyneENProvider.translateSet(translationBuilder, GemstyneArmorItems.ALDUS);
        GemstyneENProvider.translateSet(translationBuilder, GemstyneArmorItems.BRONZEMAIL);
        GemstyneENProvider.translateSet(translationBuilder, GemstyneArmorItems.BRONZEPLATE);
        GemstyneENProvider.translateSet(translationBuilder, GemstyneArmorItems.RENDFIRE);

        // ======
        // <===== Tools =====>
        // ======
        GemstyneENProvider.translateSet(translationBuilder, GemstyneToolItems.ALDUS);
        GemstyneENProvider.translateSet(translationBuilder, GemstyneToolItems.BRONZE);
        GemstyneENProvider.translateSet(translationBuilder, GemstyneToolItems.MUTALIUM);
        GemstyneENProvider.translateSet(translationBuilder, GemstyneToolItems.RENDFIRE);
    }
}
