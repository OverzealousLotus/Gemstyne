package lotus.gemstyne.data.translations.en_us;

import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

abstract class GemstyneConfigENTranslations extends FabricLanguageProvider {
    protected GemstyneConfigENTranslations(FabricDataOutput dataOutput) { super(dataOutput); }


    private static final String CONFIG_PATH = "text.config.gemstyne_config.option.";
    private static final String ORE_CONFIGURATION = "oreConfiguration";
    private static final String TOOLTIP = ".tooltip";

    protected static void generateEnglishConfigTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("text.config.gemstyne_config.title", "Gemstyne Configuration Options");
        translationBuilder.add("text.config.gemstyne_config.category.oreConfiguration", "Ore Configuration");
        translationBuilder.add("text.config.gemstyne_config.section.overworld", "The Overworld");
        translationBuilder.add("text.config.gemstyne_config.section.nether", "The Nether");
        translationBuilder.add("text.config.gemstyne_config.section.multi_dimensional", "Multi-Dimensional");
        translationBuilder.add("text.config.gemstyne_config.section.geode_configuration", "Geode Configuration");

        addConfigTranslation(translationBuilder, ORE_CONFIGURATION, "aldusEnabled", "Aldus Generation", "Whether Aldus generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIGURATION, "crimoniteEnabled", "Crimonite Generation", "Whether Crimonite generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIGURATION, "mutaliumEnabled", "Mutalium Generation", "Whether Mutalium generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIGURATION, "mochiteEnabled", "Mochite Generation", "Whether Mochite generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIGURATION, "morkiteEnabled", "Morkite Generation", "Whether Morkite generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIGURATION, "tinEnabled", "Tin Generation", "Whether Tin generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIGURATION, "torriumEnabled", "Torrium Generation", "Whether Torrium generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIGURATION, "uraniumEnabled", "Uranium Generation", "Whether Uranium generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIGURATION, "mineralsEnabled", "Mineral Generation", "Whether Gemstyne Minerals generate.");

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
