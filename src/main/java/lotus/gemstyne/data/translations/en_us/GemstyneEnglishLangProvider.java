package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.util.GemstyneToolTips;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public abstract class GemstyneEnglishLangProvider extends FabricLanguageProvider {
    protected GemstyneEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public static void coupleAndGenerateEnglishLang(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.gemstyne.main", "Gemstyne");
        translationBuilder.add("itemGroup.gemstyne.main.tab.items", "Items");
        translationBuilder.add("itemGroup.gemstyne.main.tab.blocks", "Blocks");
        translationBuilder.add("itemGroup.gemstyne.main.tab.equipment", "Equipment");
        translationBuilder.add(GemstyneToolTips.OMINOUS.getTooltipKey(), "Heat Affinity");
        translationBuilder.add(GemstyneToolTips.ALDUS.getTooltipKey(), "Resilience");
        translationBuilder.add("tooltip.gemstyne.imbued_feather", "Do not fly too low, nor too high.");
        GemstyneOreENTranslations.generateEnglishOreTranslations(translationBuilder);
        GemstyneEquipmentENTranslations.generateEnglishEquipmentTranslations(translationBuilder);
        GemstyneConfigENTranslations.generateEnglishConfigTranslations(translationBuilder);
    }
}
