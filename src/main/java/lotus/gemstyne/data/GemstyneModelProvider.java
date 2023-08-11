package lotus.gemstyne.data;

import lotus.gemstyne.data.models.*;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
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
        GemstyneDecorModels.generateDecorBlockModels(blockStateModelGenerator);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        GemstyneOreModels.generateOreItemModels(itemModelGenerator);
        GemstyneGeodeModels.generateGeodeItemModels(itemModelGenerator);
        GemstyneEquipmentModels.generateEquipmentItemModels(itemModelGenerator);


        itemModelGenerator.register(GemstyneGearItems.getImbuedFeather(), Models.GENERATED);
        itemModelGenerator.register(GemstyneCraftingItems.getImbuedRod(), Models.GENERATED);

        itemModelGenerator.register(GemstyneGearItems.getLiquidMorkiteBucket(), Models.GENERATED);
    }
}
