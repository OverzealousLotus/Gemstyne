package lotus.gemstyne.data;

import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.item.ItemHandler;
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
        gemstyneOreDrops(BlockHandler.BUBBLEGEM.stoneOre(), ItemHandler.BUBBLEGEM);
        gemstyneOreDrops(BlockHandler.BUBBLEGEM.deepslateOre(), ItemHandler.BUBBLEGEM);

        gemstyneOreDrops(BlockHandler.COMPRESSED_GRANITE_FIRE_OPAL_ORE, ItemHandler.FIRE_OPAL);

        gemstyneOreDrops(BlockHandler.ENDER_PEARL.stoneOre(), Items.ENDER_PEARL);
        gemstyneOreDrops(BlockHandler.ENDER_PEARL.deepslateOre(), Items.ENDER_PEARL);
        gemstyneOreDrops(BlockHandler.ENDER_PEARL.netherOre(), Items.ENDER_PEARL);
        gemstyneOreDrops(BlockHandler.ENDER_PEARL.endOre(), Items.ENDER_PEARL);

        gemstyneOreDrops(BlockHandler.MOCHITE.stoneOre(), ItemHandler.MOCHITE.raw());
        gemstyneOreDrops(BlockHandler.MOCHITE.deepslateOre(), ItemHandler.MOCHITE.raw());
        gemstyneOreDrops(BlockHandler.MOCHITE.netherOre(), ItemHandler.MOCHITE.nugget());

        gemstyneOreDrops(BlockHandler.MUTALIUM.stoneOre(), ItemHandler.MUTALIUM.raw());
        gemstyneOreDrops(BlockHandler.MUTALIUM.deepslateOre(), ItemHandler.MUTALIUM.raw());
        gemstyneOreDrops(BlockHandler.MUTALIUM.netherOre(), ItemHandler.MUTALIUM.raw());
        gemstyneOreDrops(BlockHandler.MUTALIUM.endOre(), ItemHandler.MUTALIUM.raw());

        gemstyneOreDrops(BlockHandler.PYRITE, ItemHandler.Pyrite.raw());

        gemstyneOreDrops(BlockHandler.TORRIUM.stoneOre(), ItemHandler.TORRIUM.raw());
        gemstyneOreDrops(BlockHandler.TORRIUM.deepslateOre(), ItemHandler.TORRIUM.raw());
        gemstyneOreDrops(BlockHandler.TORRIUM.netherOre(), ItemHandler.TORRIUM.raw());

        gemstyneOreDrops(BlockHandler.MORKITE.deepslateOre(), ItemHandler.MORKITE);

        gemstyneRichOreDrops(BlockHandler.TIN.stoneOre(), ItemHandler.TIN.raw(), 1.0f, 3.0f);
        gemstyneRichOreDrops(BlockHandler.TIN.deepslateOre(), ItemHandler.TIN.raw(), 1.0f, 3.0f);

        gemstyneOreDrops(BlockHandler.URANIUM.deepslateOre(), ItemHandler.URANIUM.raw());
        // ======
        // <===== Nether Ore Loot =====>
        // ======
        gemstyneOreDrops(BlockHandler.ALDUS.netherOre(), ItemHandler.ALDUS.raw());

        gemstyneRichOreDrops(BlockHandler.BLAZITE.netherOre(), Items.BLAZE_POWDER, 1.0f, 3.0f);

        gemstyneOreDrops(BlockHandler.CRIMONITE.netherOre(), ItemHandler.CRIMONITE.raw());

        // ======
        // <===== Ore Extension Loot =====>
        // ======
        gemstyneRichOreDrops(BlockHandler.COMPRESSED_GRANITE_COAL_ORE, Items.COAL, 2.0f, 5.0f);

        // ======
        // <===== Compact Ore Loot =====>
        // ======
        addDrop(BlockHandler.ALDUS.rawBlock());
        addDrop(BlockHandler.ALDUS.pureBlock());

        addDrop(BlockHandler.BUBBLEGEM.pureBlock());

        addDrop(BlockHandler.CRIMONITE.rawBlock());
        addDrop(BlockHandler.CRIMONITE.pureBlock());

        addDrop(BlockHandler.FIRE_OPAL_BLOCK);

        addDrop(BlockHandler.MOCHITE.rawBlock());
        addDrop(BlockHandler.MOCHITE.pureBlock());

        addDrop(BlockHandler.MORKITE.rawBlock());

        addDrop(BlockHandler.TIN.rawBlock());
        addDrop(BlockHandler.TIN.pureBlock());

        addDrop(BlockHandler.URANIUM.rawBlock());
        addDrop(BlockHandler.URANIUM.pureBlock());

        addDrop(BlockHandler.IKARITE.pureBlock());
        addDrop(BlockHandler.GARNET.pureBlock());

        // ======
        // <===== Mineral Loot =====>
        // ======
        addDrop(BlockHandler.COMPRESSED_GRANITE);
        addDrop(BlockHandler.COMPRESSED_DIORITE);
        addDrop(BlockHandler.COMPRESSED_ANDESITE);

        addDrop(BlockHandler.COMPACT_DIRT);

        addDrop(BlockHandler.HALITE);
        addDrop(BlockHandler.PUMICE);
        addDrop(BlockHandler.GABBRO);

        // ======
        // <===== Geode Drops =====>
        // ======
        gemstyneOreDrops(BlockHandler.IKARITE.clusterBud(), ItemHandler.IKARITE);
        gemstyneOreDrops(BlockHandler.GARNET.clusterBud(), ItemHandler.GARNET);
        gemstyneRichOreDrops(BlockHandler.LAPIS.clusterBud(), Items.LAPIS_LAZULI, 1, 3);

        gemstyneOreDrops(BlockHandler.NEFARIUM_ORE, Items.DIAMOND);
    }


    // ======
    // <===== Assistive Methods =====>
    // ======
    public void gemstyneRichOreDrops(Block ore, Item drop, float min, float max) {
        LootTable.Builder table = BlockLootTableGenerator.dropsWithSilkTouch(ore,
                this.applyExplosionDecay(ore, ((LeafEntry.Builder<?>) ItemEntry.builder(drop).apply(
                        SetCountLootFunction
                                .builder(UniformLootNumberProvider.create(min, max))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));

        addDrop(ore, table);
    }

    private void gemstyneOreDrops(Block ore, Item drop) {
        addDrop(ore, oreDrops(ore, drop));
    }
}
