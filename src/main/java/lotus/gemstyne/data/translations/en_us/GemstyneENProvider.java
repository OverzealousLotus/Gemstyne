package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.armor.ArmorSet;
import lotus.gemstyne.block.util.BlockSet;
import lotus.gemstyne.block.util.GeodeSet;
import lotus.gemstyne.item.GemstyneItemSet;
import lotus.gemstyne.tool.GemstyneToolSet;
import lotus.gemstyne.util.GemstyneConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public abstract class GemstyneENProvider extends FabricLanguageProvider {
    protected GemstyneENProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public static void buildEnglishLanguage(TranslationBuilder translationBuilder) {
        translationBuilder.add("death.attack.gemstyne.radiation", "%1$s sustained too many Grays."); // "%1$s" is a placeholder for a player name.
        BlockENTranslations.translateBlocks(translationBuilder);
        ItemENTranslations.translateItems(translationBuilder);
        EquipmentENTranslations.generateEnglishEquipmentTranslations(translationBuilder);
        ConfigENTranslations.generateENConfigTranslations(translationBuilder);
    }

    /**
     * Generates English translations for a {@link BlockSet}
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param blockSet {@link BlockSet}
     */
    protected static void translateSet(TranslationBuilder translationBuilder, @NotNull BlockSet blockSet) {
        String setName = WordUtils.capitalizeFully(StringUtils.replace(blockSet.getSetName(), "_", " "));
        blockSet.getBlockMap().forEach((blockType, blockPair) -> {
            switch (blockType) {
                case GemstyneConstants.STONE -> translationBuilder.add(blockPair.block(), setName + " Ore");
                case GemstyneConstants.RICH_STONE -> translationBuilder.add(blockPair.block(), WordUtils.capitalizeFully(StringUtils.replace(blockType, "_stone", " ")) + setName + " Ore");
                case GemstyneConstants.RAW -> translationBuilder.add(blockPair.block(), "Raw " + setName + " Block");
                case "pure" -> translationBuilder.add(blockPair.block(), setName + " Block");
                default -> {
                    String type = WordUtils.capitalizeFully(StringUtils.replace(blockType, "_", " "));
                    translationBuilder.add(blockPair.block(), type + " " + setName + " Ore");
                }
            }
        });
    }

    /**
     * Generates English translations for a {@link GemstyneItemSet}
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param itemSet {@link GemstyneItemSet}
     */
    protected static void translateSet(TranslationBuilder translationBuilder, @NotNull GemstyneItemSet itemSet) {
        itemSet.getItemMap().forEach((itemType, itemPair) -> {
            switch (itemType) {
                case "raw" -> translationBuilder.add(itemPair.item(), "Raw " + WordUtils.capitalizeFully(itemSet.getSetName()));
                case "singleton" -> translationBuilder.add(itemPair.item(), WordUtils.capitalizeFully(itemSet.getSetName()));
                default -> translationBuilder.add(itemPair.item(), WordUtils.capitalizeFully(itemSet.getSetName()) + " " + WordUtils.capitalizeFully(itemType));
            }
        });
    }

    /**
     * Generates English translations for a {@link GeodeSet}
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param geodeSet {@link GeodeSet}
     */
    protected static void translateSet(TranslationBuilder translationBuilder, @NotNull GeodeSet geodeSet) {
        geodeSet.getGeodeMap().forEach((geodeType, geodePair) -> {
            switch (geodeType) {
                case GemstyneConstants.BLOCK -> translationBuilder.add(geodePair.block(), WordUtils.capitalizeFully(geodeSet.getSetName()) + " " + WordUtils.capitalizeFully(GemstyneConstants.BLOCK));
                case "budding" -> translationBuilder.add(geodePair.block(), WordUtils.capitalizeFully(geodeType) + " " + WordUtils.capitalizeFully(geodeSet.getSetName()));
                case "cluster" -> translationBuilder.add(geodePair.block(), WordUtils.capitalizeFully(geodeSet.getSetName()) + " " + WordUtils.capitalizeFully(geodeType));
                default -> translationBuilder.add(geodePair.block(), WordUtils.capitalizeFully(geodeType) + " " + WordUtils.capitalizeFully(geodeSet.getSetName()) + " Bud");
            }
        });
    }

    /**
     * Generates English translations for a {@link ArmorSet}
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param armorSet {@link ArmorSet}
     */
    protected static void translateSet(TranslationBuilder translationBuilder, @NotNull ArmorSet armorSet) {
        armorSet.getArmorMap().forEach((armorType, piece) -> translationBuilder.add(piece, WordUtils.capitalizeFully(armorSet.getSetName()) + " " + WordUtils.capitalizeFully(armorType)));
    }

    /**
     * Generates English translations for a {@link GemstyneToolSet}
     * @param translationBuilder {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder}
     * @param toolSet {@link GemstyneToolSet}
     */
    protected static void translateSet(TranslationBuilder translationBuilder, @NotNull GemstyneToolSet toolSet) {
        toolSet.getToolMap().forEach((toolType, toolPair) -> translationBuilder.add(toolPair.tool(), WordUtils.capitalizeFully(toolSet.getSetName()) + " " + WordUtils.capitalizeFully(toolType)));
    }
}
