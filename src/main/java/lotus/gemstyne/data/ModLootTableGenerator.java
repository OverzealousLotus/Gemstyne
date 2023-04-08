package lotus.gemstyne.data;

import lotus.gemstyne.block.ModBlocks;
import lotus.gemstyne.item.ModItems;
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
        addDrop(ModBlocks.RAW_MOCHITE_BLOCK);
        addDrop(ModBlocks.MOCHITE_BLOCK);
        addDrop(ModBlocks.RAW_URANIUM_BLOCK);
        addDrop(ModBlocks.URANIUM_BLOCK);
        addDrop(ModBlocks.IKARITE_BLOCK);
        addDrop(ModBlocks.COMPRESSED_GRANITE);
        addDrop(ModBlocks.COMPRESSED_DIORITE);
        addDrop(ModBlocks.COMPRESSED_ANDESITE);
        addDrop(ModBlocks.COMPACT_DIRT);
        addDrop(ModBlocks.IKARITE_CLUSTER, oreDrops(ModBlocks.IKARITE_CLUSTER, ModItems.RAW_IKARITE));
        addDrop(ModBlocks.MOCHITE_ORE, oreDrops(ModBlocks.MOCHITE_ORE, ModItems.RAW_MOCHITE));
        addDrop(ModBlocks.DEEPSLATE_MOCHITE_ORE, oreDrops(ModBlocks.DEEPSLATE_MOCHITE_ORE, ModItems.RAW_MOCHITE));
        addDrop(ModBlocks.DEEPSLATE_URANIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_URANIUM_ORE, ModItems.RAW_URANIUM));

        addDrop(ModBlocks.HALITE);

        // Wood-Related
        addDrop(ModBlocks.RED_MAPLE_LOG);
        addDrop(ModBlocks.RED_MAPLE_WOOD);
        addDrop(ModBlocks.STRIPPED_RED_MAPLE_LOG);
        addDrop(ModBlocks.STRIPPED_RED_MAPLE_WOOD);
        addDrop(ModBlocks.RED_MAPLE_SAPLING);
    }
}
