package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ConfigENTranslations extends FabricLanguageProvider {

    private static final String ORE_CONFIG_PATH = "text.config.gemstyne_config.option.oreConfig.";
    private static final String CONFIG_PATH = "text.config.gemstyne_config.option.";
    private static final String TOOLTIP = ".tooltip";

    protected ConfigENTranslations(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    protected static void generateENConfigTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.gemstyne.main", "Gemstyne");
        translationBuilder.add("itemGroup.gemstyne.main.tab.items", "Items");
        translationBuilder.add("itemGroup.gemstyne.main.tab.blocks", "Blocks");
        translationBuilder.add("itemGroup.gemstyne.main.tab.equipment", "Equipment");

        translationBuilder.add("text.config.gemstyne_config.title", "Gemstyne Configuration Options");
        translationBuilder.add("text.config.gemstyne_config.category.oreConfig", "Ore Configuration");
        translationBuilder.add("text.config.gemstyne_config.section.overworld", "The Overworld");
        translationBuilder.add("text.config.gemstyne_config.section.nether", "The Nether");
        translationBuilder.add("text.config.gemstyne_config.section.multi_dimensional", "Multi-Dimensional");
        translationBuilder.add("text.config.gemstyne_config.category.geodeConfig", "Geode Configuration");

        configTranslation(translationBuilder, "aldus", new String[] {});
        configTranslation(translationBuilder, "blazite", new String[] {});
        configTranslation(translationBuilder, "bubblegem", new String[] {});
        configTranslation(translationBuilder, "crimonite", new String[] {});
        configTranslation(translationBuilder, "enderPearl", new String[] {});
        configTranslation(translationBuilder, "mutalium", new String[] {});
        configTranslation(translationBuilder, "mochite", new String[] {"richness", "rich"} );
        configTranslation(translationBuilder, "morkite", new String[] {});
        configTranslation(translationBuilder, "tin", new String[] {});
        configTranslation(translationBuilder, "torrium", new String[] {});
        configTranslation(translationBuilder, "uranium", new String[] {});
        configTranslation(translationBuilder, "minerals", new String[] {});

        configTranslation(translationBuilder, "ikarite", new String[] {"geode"});
        configTranslation(translationBuilder, "garnet", new String[] {"geode"});
        configTranslation(translationBuilder, "lapis", new String[] {"geode"});
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
        AtomicBoolean isGeode = new AtomicBoolean(false);
        if (flags.length > 0) Arrays.stream(flags).iterator().forEachRemaining(flag -> {
            switch (flag.toLowerCase()) {
                case "richness" -> {
                    String path = ORE_CONFIG_PATH + option + "Richness";
                    builder.add(path, cappedOption + " Richness");
                    builder.add(path + TOOLTIP, "Whether rich variants generate.");
                }
                case "rich" -> {
                    String path = ORE_CONFIG_PATH + flag + cappedOption + "Enabled";
                    String richTitle = StringUtils.capitalize(flag) + " " + cappedOption + " Generation";
                    builder.add(path, richTitle);
                    builder.add(path + TOOLTIP, "Amount dropped from rich veins.");
                }
                case "geode" -> {
                    isGeode.set(true);
                    String path = CONFIG_PATH + "geodeConfig." + option + "Enabled";
                    builder.add(path, cappedOption + " " + StringUtils.capitalize(flag) + " Generation");
                    builder.add(path + TOOLTIP, "Whether " + cappedOption + " Geodes generate.");
                }
                default -> Gemstyne.LOGGER.error("[Gemstyne]: An error occurred while trying to process flags for: {}", option);
            }
        });

        if (!isGeode.get()) {
            builder.add(ORE_CONFIG_PATH + option + "Enabled", cappedOption + " Generation");
            builder.add(ORE_CONFIG_PATH + option + "Enabled" + TOOLTIP, "Whether " + cappedOption + " generates.");
        }
    }
}
