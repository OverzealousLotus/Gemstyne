package lotus.gemstyne.data.models;

import lotus.gemstyne.block.BlockHandler;
import net.minecraft.data.client.BlockStateModelGenerator;

public final class GemstyneMineralModels {
    private GemstyneMineralModels() {}

    public static void generateMineralBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        // =====
        // <===== Quadrilateral Minerals =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
            BlockHandler.HALITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
            BlockHandler.PUMICE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
            BlockHandler.GABBRO);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
            BlockHandler.COMPACT_DIRT);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
            BlockHandler.COMPRESSED_GRANITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
            BlockHandler.COMPRESSED_DIORITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
            BlockHandler.COMPRESSED_ANDESITE);
    }
}
