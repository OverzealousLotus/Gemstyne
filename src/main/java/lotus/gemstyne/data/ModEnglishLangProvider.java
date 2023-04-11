package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
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
        translationBuilder.add(ModItems.FIRE_OPAL, "Fire Opal");

        // ======
        // <===== Blocks =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.URANIUM_BLOCK, "Uranium Block");
        translationBuilder.add(GemstyneOreBlocks.MOCHITE_BLOCK, "Mochite Block");

        // ======
        // <===== Ores =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.MOCHITE_ORE, "Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE, "Deepslate Mochite Ore");
        translationBuilder.add(GemstyneOreBlocks.RAW_MOCHITE_BLOCK, "Raw Mochite Block");

        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE, "Deepslate Uranium Ore");
        translationBuilder.add(GemstyneOreBlocks.RAW_URANIUM_BLOCK, "Raw Uranium Block");

        translationBuilder.add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, "Deepslate Morkite Ore");

        // ======
        // <===== Ore Extensions =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE, "Compressed Granite Coal Ore");

        // ======
        // <===== Geodes =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.IKARITE_BLOCK, "Ikarite Block");
        translationBuilder.add(GemstyneOreBlocks.BUDDING_IKARITE, "Budding Ikarite");
        translationBuilder.add(GemstyneOreBlocks.IKARITE_CLUSTER, "Ikarite Cluster");

        // ======
        // <===== Minerals =====>
        // ======
        translationBuilder.add(GemstyneMineralBlocks.HALITE, "Halite");

        translationBuilder.add(GemstyneMineralBlocks.COMPACT_DIRT, "Compact Dirt");

        translationBuilder.add(GemstyneMineralBlocks.COMPRESSED_ANDESITE, "Compressed Andesite");
        translationBuilder.add(GemstyneMineralBlocks.COMPRESSED_DIORITE, "Compressed Diorite");
        translationBuilder.add(GemstyneMineralBlocks.COMPRESSED_GRANITE, "Compressed Granite");

        translationBuilder.add(ModItemGroup.GEMSTYNE, "Gemstyne");
    }
}
