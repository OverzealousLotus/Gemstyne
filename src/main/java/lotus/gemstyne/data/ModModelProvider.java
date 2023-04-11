package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

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
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.MOCHITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.URANIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.IKARITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.BUDDING_IKARITE);

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
        itemModelGenerator.register(ModItems.RAW_MOCHITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_IKARITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MORKITE_SHARD, Models.GENERATED);

        // =====
        // <===== Refined Ores =====>
        // =====
        itemModelGenerator.register(ModItems.MOCHITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_OPAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.IMBUED_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.IMBUED_ROD, Models.GENERATED);


    }
}
