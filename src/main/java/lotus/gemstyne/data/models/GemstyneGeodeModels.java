package lotus.gemstyne.data.models;

import lotus.gemstyne.block.BlockHandler;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public final class GemstyneGeodeModels {


    public static void generateGeodeBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockHandler.LAPIS.generateBlockModels(blockStateModelGenerator, true);
        BlockHandler.GARNET.generateBlockModels(blockStateModelGenerator, false);
        BlockHandler.IKARITE.generateBlockModels(blockStateModelGenerator, false);
    }


    public static void generateGeodeItemModels(ItemModelGenerator itemModelGenerator) {
        BlockHandler.LAPIS.generateItemModels(itemModelGenerator);
        BlockHandler.GARNET.generateItemModels(itemModelGenerator);
        BlockHandler.IKARITE.generateItemModels(itemModelGenerator);
    }
}
