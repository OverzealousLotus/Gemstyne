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
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getCompressedGraniteFireOpalOre());

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getMochiteOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getDeepslateMochiteOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getRawMochiteBlock());

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getTinOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getDeepslateTinOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getRawTinBlock());

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getDeepslateUraniumOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getRawUraniumBlock());

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getDeepslateMorkiteOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getMorkiteBlock());

        // =====
        // <===== Nether =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getNetherCrimoniteOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getRawCrimoniteBlock());

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getNetherAldusOre());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getRawAldusBlock());

        // =====
        // <===== Ore Extensions =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getCompressedGraniteCoalOre());
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
