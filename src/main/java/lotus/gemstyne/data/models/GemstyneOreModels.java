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
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.DEEPSLATE_TORRIUM);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.MOCHITE.stoneOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.MOCHITE.deepslateOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.MOCHITE.rawBlock);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.TIN.stoneOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.TIN.deepslateOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.TIN.rawBlock);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.URANIUM.deepslateOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.URANIUM.rawBlock);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.MORKITE_BLOCK);

        // =====
        // <===== Nether =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.CRIMONITE.netherOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.CRIMONITE.rawBlock);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ALDUS.netherOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ALDUS.rawBlock);

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
        itemModelGenerator.register(GemstyneOreItems.TIN.RAW, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.URANIUM.RAW, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.IKARITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.GARNET, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.CRIMONITE.RAW, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ALDUS.RAW, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.MORKITE, Models.GENERATED);

        // =====
        // <===== Refined Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.MOCHITE, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.TIN.INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.URANIUM.LUMP, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.URANIUM.INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.CRIMONITE.LUMP, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.CRIMONITE.INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.ALDUS.INGOT, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.BRONZE.INGOT, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.BRONZE.CHAIN, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.BRONZE.NUGGET, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.FIRE_OPAL, Models.GENERATED);
    }
}
