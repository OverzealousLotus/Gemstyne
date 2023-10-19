package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneBlockHandler;
import net.minecraft.data.client.BlockStateModelGenerator;

public final class GemstyneMineralModels {
    private GemstyneMineralModels() {}

    public static void generateMineralBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        // =====
        // <===== Quadrilateral Minerals =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneBlockHandler.HALITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneBlockHandler.PUMICE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneBlockHandler.GABBRO);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneBlockHandler.COMPACT_DIRT);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneBlockHandler.COMPRESSED_GRANITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneBlockHandler.COMPRESSED_DIORITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
            GemstyneBlockHandler.COMPRESSED_ANDESITE);
    }
}
