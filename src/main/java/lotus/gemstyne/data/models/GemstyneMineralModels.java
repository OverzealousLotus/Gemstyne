package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;

public final class GemstyneMineralModels {


    public static void generateMineralBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        // =====
        // <===== Quadrilateral Minerals =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.getHALITE());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.getPUMICE());

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.getCompactDirt());

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.getCompressedGranite());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.getCompressedAndesite());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneMineralBlocks.getCompressedDiorite());
    }
}
