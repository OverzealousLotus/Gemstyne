package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;

public final class GemstyneDecorModels {


    public static void generateDecorBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.MOCHITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.URANIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.CRIMONITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.ALDUS_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.FIRE_OPAL_BLOCK);
    }
}
