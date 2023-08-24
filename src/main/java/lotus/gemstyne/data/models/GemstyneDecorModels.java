package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneOreBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;

public final class GemstyneDecorModels {


    public static void generateDecorBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.MOCHITE.pureBlock);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.TIN.pureBlock);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.URANIUM.pureBlock);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.CRIMONITE.pureBlock);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.ALDUS.pureBlock);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.FIRE_OPAL_BLOCK);
    }
}
