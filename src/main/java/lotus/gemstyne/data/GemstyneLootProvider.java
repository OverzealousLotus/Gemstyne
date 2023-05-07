package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
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

public final class GemstyneLootProvider extends FabricBlockLootTableProvider {
    public GemstyneLootProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        /* Add drops when breaking FIRST block.
        * For example, first entry drops itself.
        * Second entry drops Raw Mochite from Mochite Ore.
        * Third the same, except from Deepslate variant. */

        // ======
        // <===== Overworld Ore Loot =====>
        // ======
        addDrop(GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteFireOpalOre(),
                oreDrops(GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteFireOpalOre(),
                        GemstyneOreItems.ORE_ITEMS.fireOpal()));

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.mochiteOre(),
                oreDrops(GemstyneOreBlocks.ORE_BLOCKS.mochiteOre(),
                        GemstyneOreItems.ORE_ITEMS.rawMochite()));
        addDrop(GemstyneOreBlocks.ORE_BLOCKS.deepslateMochiteOre(),
                oreDrops(GemstyneOreBlocks.ORE_BLOCKS.deepslateMochiteOre(),
                        GemstyneOreItems.ORE_ITEMS.rawMochite()));

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.deepslateMorkiteOre(),
                oreDrops(GemstyneOreBlocks.ORE_BLOCKS.deepslateMorkiteOre(),
                        GemstyneOreItems.ORE_ITEMS.morkite()));

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.tinOre(),
                gemstyneRichOreDrops(GemstyneOreBlocks.ORE_BLOCKS.tinOre(),
                        GemstyneOreItems.ORE_ITEMS.rawTin(), 1.0f, 3.0f));
        addDrop(GemstyneOreBlocks.ORE_BLOCKS.deepslateTinOre(),
                gemstyneRichOreDrops(GemstyneOreBlocks.ORE_BLOCKS.deepslateTinOre(),
                        GemstyneOreItems.ORE_ITEMS.rawTin(), 1.0f, 3.0f));

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.deepslateUraniumOre(),
                oreDrops(GemstyneOreBlocks.ORE_BLOCKS.deepslateUraniumOre(),
                        GemstyneOreItems.ORE_ITEMS.rawUranium()));
        // ======
        // <===== Nether Ore Loot =====>
        // ======
        addDrop(GemstyneOreBlocks.ORE_BLOCKS.netherAldusOre(),
                oreDrops(GemstyneOreBlocks.ORE_BLOCKS.netherAldusOre(),
                        GemstyneOreItems.ORE_ITEMS.rawAldus()));

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.netherCrimoniteOre(),
                oreDrops(GemstyneOreBlocks.ORE_BLOCKS.netherCrimoniteOre(),
                        GemstyneOreItems.ORE_ITEMS.rawCrimonite()));
        // ======
        // <===== Ore Extension Loot =====>
        // ======
        addDrop(GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteCoalOre(),
                gemstyneRichOreDrops(GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteCoalOre(),
                        Items.COAL, 2.0f, 5.0f));

        // ======
        // <===== Compact Ore Loot =====>
        // ======
        addDrop(GemstyneOreBlocks.ORE_BLOCKS.rawAldusBlock());
        addDrop(GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock());

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.rawCrimoniteBlock());
        addDrop(GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock());

        addDrop(GemstyneDecorBlocks.DECOR_BLOCKS.fireOpalBlock());

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.rawMochiteBlock());
        addDrop(GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock());

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.morkiteBlock());

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.rawTinBlock());
        addDrop(GemstyneDecorBlocks.DECOR_BLOCKS.tinBlock());

        addDrop(GemstyneOreBlocks.ORE_BLOCKS.rawUraniumBlock());
        addDrop(GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock());

        addDrop(GemstyneOreBlocks.GEODE_BLOCKS.ikariteBlock());
        addDrop(GemstyneOreBlocks.GEODE_BLOCKS.garnetBlock());

        // ======
        // <===== Mineral Loot =====>
        // ======
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite());
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite());
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite());

        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());

        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.halite());
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.pumice());
        addDrop(GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro());

        // ======
        // <===== Geode Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.GEODE_BLOCKS.ikariteCluster(),
                oreDrops(GemstyneOreBlocks.GEODE_BLOCKS.ikariteCluster(),
                        GemstyneOreItems.ORE_ITEMS.ikarite()));

        addDrop(GemstyneOreBlocks.GEODE_BLOCKS.garnetCluster(),
                oreDrops(GemstyneOreBlocks.GEODE_BLOCKS.garnetCluster(),
                        GemstyneOreItems.ORE_ITEMS.garnet()));
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
