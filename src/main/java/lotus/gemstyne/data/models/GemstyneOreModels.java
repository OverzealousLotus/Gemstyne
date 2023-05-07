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
                GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteFireOpalOre());

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.mochiteOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.deepslateMochiteOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.rawMochiteBlock());

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.tinOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.deepslateTinOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.rawTinBlock());

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.deepslateUraniumOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.rawUraniumBlock());

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.deepslateMorkiteOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.morkiteBlock());

        // =====
        // <===== Nether =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.netherCrimoniteOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.rawCrimoniteBlock());

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.netherAldusOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.rawAldusBlock());

        // =====
        // <===== Ore Extensions =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteCoalOre());
    }


    public static void generateOreItemModels(ItemModelGenerator itemModelGenerator) {
        // =====
        // <===== Raw Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.rawMochite(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.rawTin(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.rawUranium(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.ikarite(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.garnet(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.rawCrimonite(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.rawAldus(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.morkite(), Models.GENERATED);

        // =====
        // <===== Refined Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.mochite(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.tinIngot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.uraniumChunk(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.uraniumIngot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.crimoniteChunk(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.crimoniteIngot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.aldusIngot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.ORE_ITEMS.fireOpal(), Models.GENERATED);
    }
}
