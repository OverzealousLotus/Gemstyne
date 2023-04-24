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
        addDrop(GemstyneOreBlocks.getMochiteOre(), oreDrops(GemstyneOreBlocks.getMochiteOre(), GemstyneOreItems.getRawMochite()));
        addDrop(GemstyneOreBlocks.getDeepslateMochiteOre(), oreDrops(GemstyneOreBlocks.getDeepslateMochiteOre(), GemstyneOreItems.getRawMochite()));

        addDrop(GemstyneOreBlocks.getTinOre(), oreDrops(GemstyneOreBlocks.getTinOre(), GemstyneOreItems.getRawTin()));
        addDrop(GemstyneOreBlocks.getDeepslateTinOre(),
                oreDrops(GemstyneOreBlocks.getDeepslateTinOre(), GemstyneOreItems.getRawTin()));

        addDrop(GemstyneOreBlocks.getDeepslateUraniumOre(),
                oreDrops(GemstyneOreBlocks.getDeepslateUraniumOre(), GemstyneOreItems.getRawUranium()));
        addDrop(GemstyneOreBlocks.getDeepslateMorkiteOre(),
                oreDrops(GemstyneOreBlocks.getDeepslateMorkiteOre(), GemstyneOreItems.getMorkite()));
        addDrop(GemstyneOreBlocks.getNetherCrimoniteOre(),
                oreDrops(GemstyneOreBlocks.getNetherCrimoniteOre(), GemstyneOreItems.getRawCrimonite()));
        addDrop(GemstyneOreBlocks.getNetherAldusOre(),
                oreDrops(GemstyneOreBlocks.getNetherAldusOre(), GemstyneOreItems.getRawAldus()));
        addDrop(GemstyneOreBlocks.getCompressedGraniteFireOpalOre(),
                oreDrops(GemstyneOreBlocks.getCompressedGraniteFireOpalOre(), GemstyneOreItems.getFireOpal()));

        // ======
        // <===== Ore Extension Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.getCompressedGraniteCoalOre(), gemstyneRichOreDrops(
                GemstyneOreBlocks.getCompressedGraniteCoalOre(), Items.COAL, 2.0f, 5.0f));

        // ======
        // <===== Block Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.getRawMochiteBlock());
        addDrop(GemstyneDecorBlocks.getMochiteBlock());

        addDrop(GemstyneOreBlocks.getRawTinBlock());
        addDrop(GemstyneDecorBlocks.getTinBlock());

        addDrop(GemstyneOreBlocks.getRawUraniumBlock());
        addDrop(GemstyneDecorBlocks.getUraniumBlock());

        addDrop(GemstyneOreBlocks.getIkariteBlock());
        addDrop(GemstyneOreBlocks.getGarnetBlock());

        addDrop(GemstyneOreBlocks.getMorkiteBlock());

        addDrop(GemstyneOreBlocks.getRawCrimoniteBlock());
        addDrop(GemstyneDecorBlocks.getCrimoniteBlock());

        addDrop(GemstyneOreBlocks.getRawAldusBlock());
        addDrop(GemstyneDecorBlocks.getAldusBlock());

        addDrop(GemstyneMineralBlocks.getCompressedGranite());
        addDrop(GemstyneMineralBlocks.getCompressedDiorite());
        addDrop(GemstyneMineralBlocks.getCompressedAndesite());

        addDrop(GemstyneMineralBlocks.getCompactDirt());

        // ======
        // <===== Geode Drops =====>
        // ======
        addDrop(GemstyneOreBlocks.getIkariteCluster(),
                oreDrops(GemstyneOreBlocks.getIkariteCluster(), GemstyneOreItems.getIkarite()));

        addDrop(GemstyneOreBlocks.getGarnetCluster(),
                oreDrops(GemstyneOreBlocks.getGarnetCluster(), GemstyneOreItems.getGarnet()));


        addDrop(GemstyneMineralBlocks.getHALITE());
        addDrop(GemstyneMineralBlocks.getPUMICE());
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
