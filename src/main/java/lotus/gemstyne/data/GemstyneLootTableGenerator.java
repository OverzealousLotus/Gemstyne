package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.GemstyneOreItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class GemstyneLootTableGenerator extends FabricBlockLootTableProvider {
    public GemstyneLootTableGenerator(FabricDataOutput dataOutput) {
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
        addDrop(GemstyneOreBlocks.MOCHITE_ORE, oreDrops(GemstyneOreBlocks.MOCHITE_ORE, GemstyneOreItems.getRawMochite()));
        addDrop(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE, oreDrops(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE, GemstyneOreItems.getRawMochite()));

        addDrop(GemstyneOreBlocks.TIN_ORE, oreDrops(GemstyneOreBlocks.TIN_ORE, GemstyneOreItems.getRawTin()));
        addDrop(GemstyneOreBlocks.DEEPSLATE_TIN_ORE,
                oreDrops(GemstyneOreBlocks.DEEPSLATE_TIN_ORE, GemstyneOreItems.getRawTin()));

        addDrop(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE,
                oreDrops(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE, GemstyneOreItems.getRawUranium()));
        addDrop(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE,
                oreDrops(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE, GemstyneOreItems.getMorkite()));
        addDrop(GemstyneOreBlocks.NETHER_CRIMONITE_ORE,
                oreDrops(GemstyneOreBlocks.NETHER_CRIMONITE_ORE, GemstyneOreItems.getRawCrimonite()));
        addDrop(GemstyneOreBlocks.NETHER_ALDUS_ORE,
                oreDrops(GemstyneOreBlocks.NETHER_ALDUS_ORE, GemstyneOreItems.getRawAldus()));
        addDrop(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE,
                oreDrops(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE, GemstyneOreItems.getFireOpal()));

        // ======
        // <===== Ore Extension Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE, gemstyneRichOreDrops(
                GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE, Items.COAL, 2.0f, 5.0f));

        // ======
        // <===== Block Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.RAW_MOCHITE_BLOCK);
        addDrop(GemstyneDecorBlocks.MOCHITE_BLOCK);

        addDrop(GemstyneOreBlocks.RAW_TIN_BLOCK);
        addDrop(GemstyneDecorBlocks.TIN_BLOCK);

        addDrop(GemstyneOreBlocks.RAW_URANIUM_BLOCK);
        addDrop(GemstyneDecorBlocks.URANIUM_BLOCK);

        addDrop(GemstyneOreBlocks.IKARITE_BLOCK);
        addDrop(GemstyneOreBlocks.GARNET_BLOCK);

        addDrop(GemstyneOreBlocks.MORKITE_BLOCK);

        addDrop(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK);
        addDrop(GemstyneDecorBlocks.CRIMONITE_BLOCK);

        addDrop(GemstyneOreBlocks.RAW_ALDUS_BLOCK);
        addDrop(GemstyneDecorBlocks.ALDUS_BLOCK);

        addDrop(GemstyneMineralBlocks.COMPRESSED_GRANITE);
        addDrop(GemstyneMineralBlocks.COMPRESSED_DIORITE);
        addDrop(GemstyneMineralBlocks.COMPRESSED_ANDESITE);

        addDrop(GemstyneMineralBlocks.COMPACT_DIRT);

        // ======
        // <===== Geode Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.IKARITE_CLUSTER,
                oreDrops(GemstyneOreBlocks.IKARITE_CLUSTER, GemstyneOreItems.getIkarite()));

        addDrop(GemstyneOreBlocks.GARNET_CLUSTER,
                oreDrops(GemstyneOreBlocks.GARNET_CLUSTER, GemstyneOreItems.getGarnet()));


        addDrop(GemstyneMineralBlocks.HALITE);
    }


    // ======
    // <===== Assistive Methods =====>
    // ======
    public LootTable.Builder gemstyneRichOreDrops(Block block, Item drop, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(block,
                this.applyExplosionDecay(block, ((LeafEntry.Builder<?>) ItemEntry.builder(drop).apply(
                        SetCountLootFunction
                                .builder(UniformLootNumberProvider.create(min, max))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
