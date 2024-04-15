package lotus.gemstyne.data.translations.en_us;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

abstract class ConfigENTranslations extends FabricLanguageProvider {
    protected ConfigENTranslations(FabricDataOutput dataOutput) { super(dataOutput); }


    private static final String ORE_CONFIG_PATH = "text.config.gemstyne_config.option.oreConfig.";
    private static final String CONFIG_PATH = "text.config.gemstyne_config.option.";
    private static final String ORE_CONFIG = "oreConfig";
    private static final String TOOLTIP = ".tooltip";

    protected static void generateEnglishConfigTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.gemstyne.main", "Gemstyne");
        translationBuilder.add("itemGroup.gemstyne.main.tab.items", "Items");
        translationBuilder.add("itemGroup.gemstyne.main.tab.blocks", "Blocks");
        translationBuilder.add("itemGroup.gemstyne.main.tab.equipment", "Equipment");

        translationBuilder.add("text.config.gemstyne_config.title", "Gemstyne Configuration Options");
        translationBuilder.add("text.config.gemstyne_config.category.oreConfig", "Ore Configuration");
        translationBuilder.add("text.config.gemstyne_config.section.overworld", "The Overworld");
        translationBuilder.add("text.config.gemstyne_config.section.nether", "The Nether");
        translationBuilder.add("text.config.gemstyne_config.section.multi_dimensional", "Multi-Dimensional");
        translationBuilder.add("text.config.gemstyne_config.section.geodeConfig", "Geode Configuration");

        configTranslation(translationBuilder, "aldus", new String[] {});
        configTranslation(translationBuilder, "blazite", new String[] {});
        configTranslation(translationBuilder, "bubblegem", new String[] {});
        configTranslation(translationBuilder, "crimonite", new String[] {});
        configTranslation(translationBuilder, "enderPearl", new String[] {});
        configTranslation(translationBuilder, "mutalium", new String[] {});
        configTranslation(translationBuilder, "mochite", new String[] {"richness", "rich"} );
        addConfigTranslation(translationBuilder, ORE_CONFIG, "morkiteEnabled", "Morkite Generation", "Whether Morkite generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIG, "tinEnabled", "Tin Generation", "Whether Tin generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIG, "torriumEnabled", "Torrium Generation", "Whether Torrium generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIG, "uraniumEnabled", "Uranium Generation", "Whether Uranium generates.");
        addConfigTranslation(translationBuilder, ORE_CONFIG, "mineralsEnabled", "Mineral Generation", "Whether Gemstyne Minerals generate.");

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

    private static void configTranslation(TranslationBuilder builder, String option, String[] flags) {
        String cappedOption = StringUtils.capitalize(option);
        if (flags.length > 0) Arrays.stream(flags).iterator().forEachRemaining(flag -> {
            if (flag.contains("richness")) {
                String translationPath = ORE_CONFIG_PATH + option + "Richness";
                builder.add(translationPath, cappedOption + " Richness");
                builder.add(translationPath + TOOLTIP, "Whether rich variants generate.");
            } else if (flag.contains("rich")) {
                String translationPath = ORE_CONFIG_PATH + flag + cappedOption + "Enabled";
                String richTitle = StringUtils.capitalize(flag) + " " + cappedOption + " Generation";
                builder.add(translationPath, richTitle);
                builder.add(translationPath + TOOLTIP, "Amount dropped from rich veins.");
            }
        });

        builder.add(ORE_CONFIG_PATH + option + "Enabled", cappedOption + " Generation");
        builder.add(ORE_CONFIG_PATH + option + "Enabled" + TOOLTIP, "Whether ore generates.");
    }

    private static void addConfigTranslation(TranslationBuilder builder, String superOption, String subOption, String title, String tooltip) {
        builder.add(CONFIG_PATH + superOption + "." + subOption, title);
        builder.add(CONFIG_PATH + superOption + "." + subOption + TOOLTIP, tooltip);
    }
}
