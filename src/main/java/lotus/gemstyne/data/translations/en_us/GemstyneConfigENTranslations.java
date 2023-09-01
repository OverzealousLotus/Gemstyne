package lotus.gemstyne.data.translations.en_us;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

abstract class GemstyneConfigENTranslations extends FabricLanguageProvider {
    protected GemstyneConfigENTranslations(FabricDataOutput dataOutput) { super(dataOutput); }


    private static final String CONFIG_PATH = "text.config.gemstyne_config.option.";
    private static final String TOOLTIP = ".tooltip";

    protected static void generateEnglishConfigTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("text.config.gemstyne_config.title", "Gemstyne Configuration Options");
        translationBuilder.add("text.config.gemstyne_config.section.oreConfiguration", "Ore Configuration");
        addConfigTranslation(translationBuilder, "mochiteEnabled", "Mochite Generation", "Whether Mochite generates.");
        addConfigTranslation(translationBuilder, "tinEnabled", "Tin Generation", "Whether Tin generates.");
        addConfigTranslation(translationBuilder, "uraniumEnabled", "Uranium Generation", "Whether Uranium generates.");
        addConfigTranslation(translationBuilder, "morkiteEnabled", "Morkite Generation", "Whether Morkite generates.");
        addConfigTranslation(translationBuilder, "mineralsEnabled", "Mineral Generation", "Whether Gemstyne Minerals generate.");
    }

    private static void addConfigTranslation(TranslationBuilder builder, String option, String title, String tooltip) {
        builder.add(CONFIG_PATH + option, title);
        builder.add(CONFIG_PATH + option + TOOLTIP, tooltip);
    }

    private static void addConfigTranslation(TranslationBuilder builder, String superOption, String subOption, String title, String tooltip) {
        builder.add(CONFIG_PATH + superOption + "." + subOption, title);
        builder.add(CONFIG_PATH + superOption + "." + subOption + TOOLTIP, tooltip);
    }

    private static void addConfigTranslation(TranslationBuilder builder, String option, String title, String tooltip, Multimap<String, String> enumTooltips) {
        builder.add(CONFIG_PATH + option, title);
        builder.add(CONFIG_PATH + option + TOOLTIP, tooltip);
        enumTooltips.forEach((enumVariant, enumTooltip) -> builder.add(CONFIG_PATH + option + ".value." + enumVariant, enumTooltip));
    }
}
