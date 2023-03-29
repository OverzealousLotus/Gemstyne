package lotus.tutorialmod.data;

import lotus.tutorialmod.block.ModBlocks;
import lotus.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // Add drops when breaking FIRST block.
        // For example, first entry drops itself.
        // Second entry drops Raw Mochite from Mochite Ore.
        // Third the same, except from Deepslate variant.
        addDrop(ModBlocks.MOCHITE_BLOCK);
        addDrop(ModBlocks.MOCHITE_ORE, oreDrops(ModBlocks.MOCHITE_ORE, ModItems.RAW_MOCHITE));
        addDrop(ModBlocks.DEEPSLATE_MOCHITE_ORE, oreDrops(ModBlocks.DEEPSLATE_MOCHITE_ORE, ModItems.RAW_MOCHITE));
    }
}
