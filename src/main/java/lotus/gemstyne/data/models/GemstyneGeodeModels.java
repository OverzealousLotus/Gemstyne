package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneOreBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public final class GemstyneGeodeModels {


    public static void generateGeodeBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.GEODE_BLOCKS.garnetBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.GEODE_BLOCKS.buddingGarnet());

        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.GEODE_BLOCKS.garnetCluster());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.GEODE_BLOCKS.largeGarnetBud());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.GEODE_BLOCKS.mediumGarnetBud());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.GEODE_BLOCKS.smallGarnetBud());

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.GEODE_BLOCKS.ikariteBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.GEODE_BLOCKS.buddingIkarite());

        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.GEODE_BLOCKS.ikariteCluster());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.GEODE_BLOCKS.largeIkariteBud());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.GEODE_BLOCKS.mediumIkariteBud());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud());
    }


    public static void generateGeodeItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(GemstyneOreBlocks.GEODE_BLOCKS.ikariteCluster().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.GEODE_BLOCKS.largeIkariteBud().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.GEODE_BLOCKS.mediumIkariteBud().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud().asItem(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreBlocks.GEODE_BLOCKS.garnetCluster().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.GEODE_BLOCKS.largeGarnetBud().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.GEODE_BLOCKS.mediumGarnetBud().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.GEODE_BLOCKS.smallGarnetBud().asItem(), Models.GENERATED);
    }
}
