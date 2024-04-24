package lotus.gemstyne.data.models;

import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.ItemHandler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public final class GemstyneModelProvider extends FabricModelProvider {
    public GemstyneModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        GemstyneOreModels.generateOreBlockModels(blockStateModelGenerator);
        GemstyneMineralModels.generateMineralBlockModels(blockStateModelGenerator);
        GemstyneGeodeModels.generateGeodeBlockModels(blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        GemstyneOreModels.generateOreItemModels(itemModelGenerator);
        GemstyneGeodeModels.generateGeodeItemModels(itemModelGenerator);
        GemstyneEquipmentModels.generateEquipmentItemModels(itemModelGenerator);


        itemModelGenerator.register(ItemHandler.IMBUED_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ItemHandler.IMBUED_ROD, Models.GENERATED);

        itemModelGenerator.register(GemstyneFluids.LIQUID_MORKITE_BUCKET, Models.GENERATED);
    }
}
