package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;

public final class GemstyneDecorModels {


    public static void generateDecorBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.DECOR_BLOCKS.tinBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.DECOR_BLOCKS.fireOpalBlock());
    }
}
