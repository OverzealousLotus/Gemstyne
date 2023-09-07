package lotus.gemstyne.data.translations.en_us;

import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

abstract class GemstyneConfigENTranslations extends FabricLanguageProvider {
    protected GemstyneConfigENTranslations(FabricDataOutput dataOutput) { super(dataOutput); }


    private static final String CONFIG_PATH = "text.config.gemstyne_config.option.";
    private static final String TOOLTIP = ".tooltip";

    protected static void generateEnglishConfigTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("text.config.gemstyne_config.title", "Gemstyne Configuration Options");
        translationBuilder.add("text.config.gemstyne_config.section.ore_configuration", "Ore Configuration");
        translationBuilder.add("text.config.gemstyne_config.section.geode_configuration", "Geode Configuration");

        addConfigTranslation(translationBuilder, "mochiteEnabled", "Mochite Generation", "Whether Mochite generates.");
        addConfigTranslation(translationBuilder, "tinEnabled", "Tin Generation", "Whether Tin generates.");
        addConfigTranslation(translationBuilder, "uraniumEnabled", "Uranium Generation", "Whether Uranium generates.");
        addConfigTranslation(translationBuilder, "morkiteEnabled", "Morkite Generation", "Whether Morkite generates.");
        addConfigTranslation(translationBuilder, "mineralsEnabled", "Mineral Generation", "Whether Gemstyne Minerals generate.");

        addConfigTranslation(translationBuilder, "ikariteEnabled", "Ikarite Geode Generation", "Whether Ikarite Geodes generate.");
        addConfigTranslation(translationBuilder, "garnetEnabled", "Garnet Geode Generation", "Whether Garnet Geodes generate.");
        addConfigTranslation(translationBuilder, "lapisEnabled", "Lapis Geode Generation", "Whether Lapis Geodes generate.");
    }

    /**
     * Method to simplify generating tooltips for configuration options.
     * @param builder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param option Name of the configuration option.
     * @param title Title of the configuration option.
     * @param tooltip Description of the configuration option when hovered over.
     */
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
