package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.GemstyneOreItems;
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
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.MOCHITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.RAW_MOCHITE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.TIN_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.RAW_TIN_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.RAW_URANIUM_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.MORKITE_BLOCK);

        // =====
        // <===== Nether =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.NETHER_CRIMONITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.NETHER_ALDUS_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.RAW_ALDUS_BLOCK);

        // =====
        // <===== Ore Extensions =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE);
    }


    public static void generateOreItemModels(ItemModelGenerator itemModelGenerator) {
        // =====
        // <===== Raw Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.getRawMochite(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.getRawTin(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.getRawUranium(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.getIkarite(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.getGarnet(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.getRawCrimonite(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.getRawAldus(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.getMorkite(), Models.GENERATED);

        // =====
        // <===== Refined Ores =====>
        // =====
        itemModelGenerator.register(GemstyneOreItems.getMochite(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.getTinIngot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.getUraniumChunk(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.getUraniumIngot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.getCrimoniteChunk(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.getCrimoniteIngot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.getAldusIngot(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.getFireOpal(), Models.GENERATED);
    }
}
