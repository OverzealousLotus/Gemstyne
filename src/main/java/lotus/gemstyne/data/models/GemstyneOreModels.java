package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public final class GemstyneOreModels {


    public static void generateOreBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        // =====
        // ==========
        // <========== Quadrilateral Ores ==========>
        // ==========
        // =====



        // =====
        // <===== Overworld =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.MOCHITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.RAW_MOCHITE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.TIN_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.RAW_TIN_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.RAW_URANIUM_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.MORKITE_BLOCK);

        // =====
        // <===== Nether =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.NETHER_CRIMONITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.RAW_CRIMONITE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.NETHER_ALDUS_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.RAW_ALDUS_BLOCK);

        // =====
        // <===== Ore Extensions =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.NEFARIUM_ORE);
    }


    public static void generateOreItemModels(ItemModelGenerator itemModelGenerator) {
        // =====
        // <===== Raw Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.RAW_MOCHITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.IKARITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.GARNET, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.RAW_CRIMONITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.RAW_ALDUS, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.MORKITE, Models.GENERATED);

        // =====
        // <===== Refined Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.MOCHITE, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.TIN_INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.URANIUM_CHUNK, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.URANIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.CRIMONITE_CHUNK, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.CRIMONITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.ALDUS_INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.BRONZE_RING, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.BRONZE_NUGGET, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.FIRE_OPAL, Models.GENERATED);
    }
}
