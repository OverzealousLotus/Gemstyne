package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneOreBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public final class GemstyneGeodeModels {


    public static void generateGeodeBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.GARNET_CLUSTER);
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.LARGE_GARNET_BUD);
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.MEDIUM_GARNET_BUD);
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.SMALL_GARNET_BUD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.GARNET_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.BUDDING_GARNET);

        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.IKARITE_CLUSTER);
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.LARGE_IKARITE_BUD);
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.MEDIUM_IKARITE_BUD);
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.SMALL_IKARITE_BUD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.IKARITE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.BUDDING_IKARITE);
    }


    public static void generateGeodeItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(GemstyneOreBlocks.GARNET_CLUSTER.asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.LARGE_GARNET_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.MEDIUM_GARNET_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.SMALL_GARNET_BUD.asItem(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreBlocks.IKARITE_CLUSTER.asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.LARGE_IKARITE_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.MEDIUM_IKARITE_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.SMALL_IKARITE_BUD.asItem(), Models.GENERATED);
    }
}
