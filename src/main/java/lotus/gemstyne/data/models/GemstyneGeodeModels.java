package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneOreBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public final class GemstyneGeodeModels {


    public static void generateGeodeBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getGarnetBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getBuddingGarnet());

        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.getGarnetCluster());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.getLargeGarnetBud());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.getMediumGarnetBud());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.getSmallGarnetBud());

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getIkariteBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.getBuddingIkarite());

        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.getIkariteCluster());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.getLargeIkariteBud());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.getMediumIkariteBud());
        blockStateModelGenerator.registerAmethyst(GemstyneOreBlocks.getSmallIkariteBud());
    }


    public static void generateGeodeItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(GemstyneOreBlocks.getIkariteCluster().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.getLargeIkariteBud().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.getMediumIkariteBud().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.getSmallIkariteBud().asItem(), Models.GENERATED);

        itemModelGenerator.register(GemstyneOreBlocks.getGarnetCluster().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.getLargeGarnetBud().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.getMediumGarnetBud().asItem(), Models.GENERATED);
        itemModelGenerator.register(GemstyneOreBlocks.getSmallGarnetBud().asItem(), Models.GENERATED);
    }
}
