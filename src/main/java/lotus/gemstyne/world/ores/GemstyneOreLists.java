package lotus.gemstyne.world.ores;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.util.GemstyneBlockTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class GemstyneOreLists {
    // =====
    // <===== Block rules for generation =====>
    // =====
    private static final RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private static final RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
    private static final RuleTest compressedGraniteReplaceables =
            new TagMatchRuleTest(GemstyneBlockTags.getCompressedGraniteOreReplaceables());

    private static final RuleTest mochiteReplaceables =
            new TagMatchRuleTest(GemstyneBlockTags.getMochiteOreReplaceables());
    private static final RuleTest morkiteReplaceables =
            new TagMatchRuleTest(GemstyneBlockTags.getMorkiteOreReplaceables());
    private static final RuleTest uraniumReplaceables =
            new TagMatchRuleTest(GemstyneBlockTags.getUraniumOreReplaceables());
    private static final RuleTest tinReplaceables =
            new TagMatchRuleTest(GemstyneBlockTags.getTinOreReplaceables());


    // =====
    // <===== Overworld Ore Replaceables =====>
    // =====
    private static final ImmutableList<OreFeatureConfig.Target> overworldFireOpalOres = ImmutableList.of(
            OreFeatureConfig.createTarget(getCompressedGraniteReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteFireOpalOre().getDefaultState()));

    private static final ImmutableList<OreFeatureConfig.Target> overworldMochiteOres = ImmutableList.of(
            OreFeatureConfig.createTarget(getStoneReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.mochiteOre().getDefaultState()),
            OreFeatureConfig.createTarget(getDeepslateReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.deepslateMochiteOre().getDefaultState()));

    private static final ImmutableList<OreFeatureConfig.Target> overworldMorkiteOres = ImmutableList.of(
            OreFeatureConfig.createTarget(getDeepslateReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.deepslateMorkiteOre().getDefaultState()));

    private static final ImmutableList<OreFeatureConfig.Target> overworldTinOres = ImmutableList.of(
            OreFeatureConfig.createTarget(getStoneReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.tinOre().getDefaultState()),
            OreFeatureConfig.createTarget(getDeepslateReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.deepslateTinOre().getDefaultState()));

    private static final ImmutableList<OreFeatureConfig.Target> overworldUraniumOres = ImmutableList.of(
            OreFeatureConfig.createTarget(getDeepslateReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.deepslateUraniumOre().getDefaultState()));

    // =====
    // <===== Nether Ore Replaceables =====>
    // =====
    private static final ImmutableList<OreFeatureConfig.Target> netherAldusOres = ImmutableList.of(
            OreFeatureConfig.createTarget(getNetherReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.netherAldusOre().getDefaultState()));

    private static final ImmutableList<OreFeatureConfig.Target> netherCrimoniteOres = ImmutableList.of(
            OreFeatureConfig.createTarget(getNetherReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.netherCrimoniteOre().getDefaultState()));

    // =====
    // <===== Ore Extension Replaceables =====>
    // =====
    private static final ImmutableList<OreFeatureConfig.Target> compressedCoalOres = ImmutableList.of(
            OreFeatureConfig.createTarget(getCompressedGraniteReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteCoalOre().getDefaultState()));

    // =====
    // <===== Concentrated Ore Replaceables =====>
    // =====
    private static final ImmutableList<OreFeatureConfig.Target> rawMochiteBlobs = ImmutableList.of(
            OreFeatureConfig.createTarget(getMochiteReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.rawMochiteBlock().getDefaultState()));
    private static final ImmutableList<OreFeatureConfig.Target> rawMorkiteBlobs = ImmutableList.of(
            OreFeatureConfig.createTarget(getMorkiteReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.morkiteBlock().getDefaultState()));
    private static final ImmutableList<OreFeatureConfig.Target> rawUraniumBlobs = ImmutableList.of(
            OreFeatureConfig.createTarget(getUraniumReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.rawUraniumBlock().getDefaultState()));
    private static final ImmutableList<OreFeatureConfig.Target> rawTinBlobs = ImmutableList.of(
            OreFeatureConfig.createTarget(getTinReplaceables(),
                    GemstyneOreBlocks.ORE_BLOCKS.rawTinBlock().getDefaultState()));


    // =====
    // <===== Getters =====>
    // =====
    protected static RuleTest getStoneReplaceables() {
        return stoneReplaceables;
    }

    protected static RuleTest getDeepslateReplaceables() {
        return deepslateReplaceables;
    }

    protected static RuleTest getNetherReplaceables() {
        return netherReplaceables;
    }

    protected static RuleTest getCompressedGraniteReplaceables() {
        return compressedGraniteReplaceables;
    }

    protected static RuleTest getMochiteReplaceables() {
        return mochiteReplaceables;
    }

    protected static RuleTest getMorkiteReplaceables() {
        return morkiteReplaceables;
    }

    protected static RuleTest getUraniumReplaceables() {
        return uraniumReplaceables;
    }

    protected static RuleTest getTinReplaceables() { return tinReplaceables; }

    protected static ImmutableList<OreFeatureConfig.Target> getOverworldMochiteOres() {
        return overworldMochiteOres;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getOverworldTinOres() { return overworldTinOres;}

    protected static ImmutableList<OreFeatureConfig.Target> getOverworldUraniumOres() {
        return overworldUraniumOres;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getOverworldMorkiteOres() {
        return overworldMorkiteOres;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getOverworldFireOpalOres() {
        return overworldFireOpalOres;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getNetherCrimoniteOres() {
        return netherCrimoniteOres;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getNetherAldusOres() {
        return netherAldusOres;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getCompressedCoalOres() {
        return compressedCoalOres;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getRawMochiteBlobs() {
        return rawMochiteBlobs;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getRawMorkiteBlobs() {
        return rawMorkiteBlobs;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getRawUraniumBlobs() {
        return rawUraniumBlobs;
    }

    protected static ImmutableList<OreFeatureConfig.Target> getRawTinBlobs() { return rawTinBlobs; }
}
