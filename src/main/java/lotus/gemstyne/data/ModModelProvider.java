package lotus.gemstyne.data;

import lotus.gemstyne.block.ModBlocks;
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
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOCHITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_MOCHITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAW_MOCHITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAW_URANIUM_BLOCK);

        // =====
        // <===== Quadrilateral Ores =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.HALITE);

        // =====
        // <===== Quadrilateral Decor-Blocks =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOCHITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.URANIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.IKARITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BUDDING_IKARITE);

        // =====
        // <===== Quadrilateral Wood =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_MAPLE_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_MAPLE_LEAVES);

        // =====
        // <===== Unilateral Wood =====>
        // =====
        blockStateModelGenerator.registerLog(ModBlocks.RED_MAPLE_LOG)
                .log(ModBlocks.RED_MAPLE_LOG)
                .wood(ModBlocks.RED_MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_RED_MAPLE_LOG)
                .log(ModBlocks.STRIPPED_RED_MAPLE_LOG)
                .wood(ModBlocks.STRIPPED_RED_MAPLE_WOOD);

        // =====
        // <===== Crosses =====>
        // =====
        // When Crosses are registered, they must be "cutout" in "GemstyneClient"
        // This is to tell Minecraft to render them using their transparent pixels.
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.RED_MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerAmethyst(ModBlocks.IKARITE_CLUSTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // =====
        // <===== Raw Ores =====>
        // =====
        itemModelGenerator.register(ModItems.RAW_MOCHITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_IKARITE, Models.GENERATED);

        // =====
        // <===== Refined Ores =====>
        // =====
        itemModelGenerator.register(ModItems.MOCHITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);


    }
}
