package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;

public final class GemstyneMineralModels {


    public static void generateMineralBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        // =====
        // <===== Quadrilateral Minerals =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.MINERAL_BLOCKS.halite());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.MINERAL_BLOCKS.pumice());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro());

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite());
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite());
    }
}
