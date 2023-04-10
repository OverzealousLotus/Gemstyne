package lotus.gemstyne.data;

import lotus.gemstyne.block.ModBlocks;
import lotus.gemstyne.item.ModItemGroup;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        // ======
        // <===== Items =====>
        // ======
        translationBuilder.add(ModItems.IMBUED_ROD, "Imbued Rod");
        translationBuilder.add(ModItems.IMBUED_FEATHER, "Imbued Feather");

        // ======
        // <===== Raw Ores =====>
        // ======
        translationBuilder.add(ModItems.RAW_MOCHITE, "Raw Mochite");
        translationBuilder.add(ModItems.RAW_URANIUM, "Raw Uranium");
        translationBuilder.add(ModItems.RAW_IKARITE, "Ikarite Shard");
        translationBuilder.add(ModItems.MORKITE_SHARD, "Morkite Shard");

        // ======
        // <===== Refined Ores =====>
        // ======
        translationBuilder.add(ModItems.MOCHITE, "Mochite");
        translationBuilder.add(ModItems.URANIUM_CHUNK, "Uranium Chunk");
        translationBuilder.add(ModItems.URANIUM_INGOT, "Uranium Ingot");

        // ======
        // <===== Blocks =====>
        // ======
        translationBuilder.add(ModBlocks.URANIUM_BLOCK, "Uranium Block");
        translationBuilder.add(ModBlocks.MOCHITE_BLOCK, "Mochite Block");

        // ======
        // <===== Ores =====>
        // ======
        translationBuilder.add(ModBlocks.MOCHITE_ORE, "Mochite Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_MOCHITE_ORE, "Deepslate Mochite Ore");
        translationBuilder.add(ModBlocks.RAW_MOCHITE_BLOCK, "Raw Mochite Block");

        translationBuilder.add(ModBlocks.DEEPSLATE_URANIUM_ORE, "Deepslate Uranium Ore");
        translationBuilder.add(ModBlocks.RAW_URANIUM_BLOCK, "Raw Uranium Block");

        translationBuilder.add(ModBlocks.DEEPSLATE_MORKITE_ORE, "Deepslate Morkite Ore");

        // ======
        // <===== Geodes =====>
        // ======
        translationBuilder.add(ModBlocks.IKARITE_BLOCK, "Ikarite Block");
        translationBuilder.add(ModBlocks.BUDDING_IKARITE, "Budding Ikarite");
        translationBuilder.add(ModBlocks.IKARITE_CLUSTER, "Ikarite Cluster");

        // ======
        // <===== Minerals =====>
        // ======
        translationBuilder.add(ModBlocks.HALITE, "Halite");

        translationBuilder.add(ModBlocks.COMPACT_DIRT, "Compact Dirt");

        translationBuilder.add(ModBlocks.COMPRESSED_ANDESITE, "Compressed Andesite");
        translationBuilder.add(ModBlocks.COMPRESSED_DIORITE, "Compressed Diorite");
        translationBuilder.add(ModBlocks.COMPRESSED_GRANITE, "Compressed Granite");

        // ======
        // <===== Wood =====>
        // ======
        translationBuilder.add(ModBlocks.RED_MAPLE_LOG, "Red Maple Log");
        translationBuilder.add(ModBlocks.STRIPPED_RED_MAPLE_LOG, "Stripped Red Maple Log");
        translationBuilder.add(ModBlocks.RED_MAPLE_PLANKS, "Red Maple Plank");
        translationBuilder.add(ModBlocks.RED_MAPLE_WOOD, "Red Maple Wood");
        translationBuilder.add(ModBlocks.STRIPPED_RED_MAPLE_WOOD, "Stripped Red Maple Wood");
        translationBuilder.add(ModBlocks.RED_MAPLE_LEAVES, "Red Maple Leaves");
        translationBuilder.add(ModBlocks.RED_MAPLE_SAPLING, "Red Maple Sapling");

        translationBuilder.add(ModItemGroup.GEMSTYNE, "Gemstyne");
    }
}
