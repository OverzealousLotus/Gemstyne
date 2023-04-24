package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;

public final class GemstyneDecorModels {


    public static void generateDecorBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.getMochiteBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.getTinBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.getUraniumBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.getCrimoniteBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.getAldusBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneDecorBlocks.getFireOpalBlock());
    }
}
