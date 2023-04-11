package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        /* Add drops when breaking FIRST block.
        * For example, first entry drops itself.
        * Second entry drops Raw Mochite from Mochite Ore.
        * Third the same, except from Deepslate variant. */

        // ======
        // <===== Ore Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.MOCHITE_ORE, oreDrops(GemstyneOreBlocks.MOCHITE_ORE, ModItems.RAW_MOCHITE));
        addDrop(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE, oreDrops(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE, ModItems.RAW_MOCHITE));
        addDrop(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE, oreDrops(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE, ModItems.RAW_URANIUM));
        addDrop(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, oreDrops(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, ModItems.MORKITE_SHARD));

        // ======
        // <===== Ore Extension Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE, oreDrops(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE, Items.COAL));

        // ======
        // <===== Block Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.RAW_MOCHITE_BLOCK);
        addDrop(GemstyneOreBlocks.MOCHITE_BLOCK);
        addDrop(GemstyneOreBlocks.RAW_URANIUM_BLOCK);
        addDrop(GemstyneOreBlocks.URANIUM_BLOCK);
        addDrop(GemstyneOreBlocks.IKARITE_BLOCK);
        addDrop(GemstyneMineralBlocks.COMPRESSED_GRANITE);
        addDrop(GemstyneMineralBlocks.COMPRESSED_DIORITE);
        addDrop(GemstyneMineralBlocks.COMPRESSED_ANDESITE);
        addDrop(GemstyneMineralBlocks.COMPACT_DIRT);

        // ======
        // <===== Geode Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.IKARITE_CLUSTER, oreDrops(GemstyneOreBlocks.IKARITE_CLUSTER, ModItems.RAW_IKARITE));


        addDrop(GemstyneMineralBlocks.HALITE);
    }
}
