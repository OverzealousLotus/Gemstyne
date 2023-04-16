package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.GemstyneArmorItems;
import lotus.gemstyne.item.GemstyneOreItems;
import lotus.gemstyne.item.GemstyneToolItems;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // =====
        // <===== Quadrilateral Ores =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.MOCHITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.RAW_MOCHITE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.RAW_URANIUM_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.MORKITE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.NETHER_CRIMONITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.NETHER_ALDUS_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.RAW_ALDUS_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.IKARITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.BUDDING_IKARITE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE);

        // =====
        // <===== Quadrilateral Ore Extensions =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE);

        // =====
        // <===== Quadrilateral Minerals =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.HALITE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.COMPACT_DIRT);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.COMPRESSED_GRANITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.COMPRESSED_ANDESITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.COMPRESSED_DIORITE);

        // =====
        // <===== Quadrilateral Decor-Blocks =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.MOCHITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.URANIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.CRIMONITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.ALDUS_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.FIRE_OPAL_BLOCK);


        // =====
        // <===== Crosses =====>
        // =====
        // When Crosses are registered, they must be "cutout" in "GemstyneClient"
        // This is to tell Minecraft to render them using their transparent pixels.

        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.IKARITE_CLUSTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // =====
        // <===== Raw Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.RAW_MOCHITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.IKARITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.RAW_CRIMONITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.RAW_ALDUS, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.MORKITE, Models.GENERATED);

        // =====
        // <===== Refined Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.MOCHITE, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.URANIUM_CHUNK, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.URANIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.CRIMONITE_CHUNK, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.CRIMONITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.ALDUS_INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.FIRE_OPAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.IMBUED_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.IMBUED_ROD, Models.GENERATED);

        itemModelGenerator.register(GemstyneArmorItems.RENDFIRE_HELMET, Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.RENDFIRE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.RENDFIRE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.RENDFIRE_BOOTS, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ALDUS_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ALDUS_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ALDUS_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.ALDUS_BOOTS);

        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_HOE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.RENDFIRE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.ALDUS_AXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS_HOE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.ALDUS_SWORD, Models.HANDHELD);
    }
}
