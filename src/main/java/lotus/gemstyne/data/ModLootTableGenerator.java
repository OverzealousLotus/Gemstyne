package lotus.gemstyne.data;

import lotus.gemstyne.block.GemStyneDecorBlocks;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.GemstyneOreItems;
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
        addDrop(GemstyneOreBlocks.MOCHITE_ORE, oreDrops(GemstyneOreBlocks.MOCHITE_ORE, GemstyneOreItems.RAW_MOCHITE));
        addDrop(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE, oreDrops(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE, GemstyneOreItems.RAW_MOCHITE));
        addDrop(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE, oreDrops(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE, GemstyneOreItems.RAW_URANIUM));
        addDrop(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, oreDrops(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, GemstyneOreItems.MORKITE));
        addDrop(GemstyneOreBlocks.NETHER_CRIMONITE_ORE, oreDrops(GemstyneOreBlocks.NETHER_CRIMONITE_ORE, GemstyneOreItems.RAW_CRIMONITE));
        addDrop(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE,
                oreDrops(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE, GemstyneOreItems.FIRE_OPAL));

        // ======
        // <===== Ore Extension Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE, oreDrops(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE, Items.COAL));

        // ======
        // <===== Block Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.RAW_MOCHITE_BLOCK);
        addDrop(GemStyneDecorBlocks.MOCHITE_BLOCK);
        addDrop(GemstyneOreBlocks.RAW_URANIUM_BLOCK);
        addDrop(GemStyneDecorBlocks.URANIUM_BLOCK);
        addDrop(GemstyneOreBlocks.IKARITE_BLOCK);
        addDrop(GemstyneOreBlocks.MORKITE_BLOCK);
        addDrop(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK);
        addDrop(GemstyneMineralBlocks.COMPRESSED_GRANITE);
        addDrop(GemstyneMineralBlocks.COMPRESSED_DIORITE);
        addDrop(GemstyneMineralBlocks.COMPRESSED_ANDESITE);
        addDrop(GemstyneMineralBlocks.COMPACT_DIRT);

        // ======
        // <===== Geode Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.IKARITE_CLUSTER, oreDrops(GemstyneOreBlocks.IKARITE_CLUSTER, GemstyneOreItems.IKARITE));


        addDrop(GemstyneMineralBlocks.HALITE);
    }
}
