package lotus.gemstyne.data.translations.en_us;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public abstract class GemstyneEnglishLangProvider extends FabricLanguageProvider {
    protected GemstyneEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public static void coupleAndGenerateEnglishLang(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.gemstyne.main", "Gemstyne");
        GemstyneOreENTranslations.generateEnglishOreTranslations(translationBuilder);
        GemstyneEquipmentENTranslations.generateEnglishEquipmentTranslations(translationBuilder);
    }
}
