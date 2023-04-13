package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.item.GemstyneOreItems;
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
        translationBuilder.add(GemstyneOreItems.RAW_MOCHITE, "Raw Mochite");
        translationBuilder.add(GemstyneOreItems.RAW_URANIUM, "Raw Uranium");
        translationBuilder.add(GemstyneOreItems.RAW_CRIMONITE, "Raw Crimonite");
        translationBuilder.add(GemstyneOreItems.IKARITE, "Ikarite");
        translationBuilder.add(GemstyneOreItems.MORKITE, "Morkite");

        // ======
        // <===== Refined Ores =====>
        // ======
        translationBuilder.add(GemstyneOreItems.MOCHITE, "Mochite");

        translationBuilder.add(GemstyneOreItems.URANIUM_CHUNK, "Uranium Chunk");
        translationBuilder.add(GemstyneOreItems.URANIUM_INGOT, "Uranium Ingot");

        translationBuilder.add(GemstyneOreItems.CRIMONITE_CHUNK, "Crimonite Chunk");
        translationBuilder.add(GemstyneOreItems.CRIMONITE_INGOT, "Crimonite Ingot");

        translationBuilder.add(GemstyneOreItems.FIRE_OPAL, "Fire Opal");

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
        translationBuilder.add(GemstyneOreBlocks.MORKITE_BLOCK, "Morkite Block");

        translationBuilder.add(GemstyneOreBlocks.NETHER_CRIMONITE_ORE, "Nether Crimonite Ore");
        translationBuilder.add(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK, "Raw Crimonite Block");

        translationBuilder.add(
                GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE, "Compressed Granite Fire Opal Ore");

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

        // ======
        // <===== Armour =====>
        // ======
        translationBuilder.add(ModItems.RENDFIRE_HELMET, "Rendfire Helmet");
        translationBuilder.add(ModItems.RENDFIRE_CHESTPLATE, "Rendfire Chestplate");
        translationBuilder.add(ModItems.RENDFIRE_LEGGINGS, "Rendfire Leggings");
        translationBuilder.add(ModItems.RENDFIRE_BOOTS, "Rendfire Boots");

        translationBuilder.add(ModItems.RENDFIRE_PICKAXE, "Rendfire Pickaxe");
        translationBuilder.add(ModItems.RENDFIRE_AXE, "Rendfire Axe");
        translationBuilder.add(ModItems.RENDFIRE_HOE, "Rendfire Hoe");
        translationBuilder.add(ModItems.RENDFIRE_SWORD, "Rendfire Sword");
        translationBuilder.add(ModItems.RENDFIRE_SHOVEL, "Rendfire Shovel");

        translationBuilder.add(GemstyneEffects.IRRADIATE, "Irradiate");
    }
}
