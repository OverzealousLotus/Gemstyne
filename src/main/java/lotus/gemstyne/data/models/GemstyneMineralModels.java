package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;

public final class GemstyneMineralModels {


    public static void generateMineralBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        // =====
        // <===== Quadrilateral Minerals =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.HALITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.PUMICE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.GABBRO);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.COMPACT_DIRT);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.COMPRESSED_GRANITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.COMPRESSED_DIORITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneMineralBlocks.COMPRESSED_ANDESITE);
    }
}
