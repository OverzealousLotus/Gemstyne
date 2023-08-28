package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneOreBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public final class GemstyneGeodeModels {


    public static void generateGeodeBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        GemstyneOreBlocks.LAPIS.generateBlockModels(blockStateModelGenerator, true);
        GemstyneOreBlocks.GARNET.generateBlockModels(blockStateModelGenerator, false);
        GemstyneOreBlocks.IKARITE.generateBlockModels(blockStateModelGenerator, false);
    }


    public static void generateGeodeItemModels(ItemModelGenerator itemModelGenerator) {
        GemstyneOreBlocks.LAPIS.generateItemModels(itemModelGenerator);
        GemstyneOreBlocks.GARNET.generateItemModels(itemModelGenerator);
        GemstyneOreBlocks.IKARITE.generateItemModels(itemModelGenerator);
    }
}
