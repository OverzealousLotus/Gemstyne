package lotus.gemstyne.world.ores;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.util.ModBlockTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class GemstyneOreLists {
    // =====
    // <===== Block rules for generation =====>
    // =====
    protected static final RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    protected static final RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    protected static final RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
    protected static final RuleTest compressedGraniteReplaceables =
            new TagMatchRuleTest(ModBlockTags.COMPRESSED_GRANITE_ORE_REPLACEABLES);

    protected static final RuleTest mochiteReplaceables =
            new TagMatchRuleTest(ModBlockTags.MOCHITE_ORE_REPLACEABLES);
    protected static final RuleTest morkiteReplaceables =
            new TagMatchRuleTest(ModBlockTags.MORKITE_ORE_REPLACEABLES);
    protected static final RuleTest uraniumReplaceables =
            new TagMatchRuleTest(ModBlockTags.URANIUM_ORE_REPLACEABLES);


    // =====
    // <===== Ores =====>
    // =====

    protected static final ImmutableList<OreFeatureConfig.Target> overworldMochiteOres =
            ImmutableList.of(OreFeatureConfig.createTarget(stoneReplaceables, GemstyneOreBlocks.getMochiteOre().getDefaultState()),
                    OreFeatureConfig.createTarget(deepslateReplaceables, GemstyneOreBlocks.getDeepslateMochiteOre().getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> overworldUraniumOres =
            ImmutableList.of(OreFeatureConfig.createTarget(deepslateReplaceables, GemstyneOreBlocks.getDeepslateUraniumOre().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> overworldMorkiteOres =
            ImmutableList.of(OreFeatureConfig.createTarget(deepslateReplaceables, GemstyneOreBlocks.getDeepslateMorkiteOre().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> overworldFireOpalOres =
            ImmutableList.of(OreFeatureConfig.createTarget(compressedGraniteReplaceables, GemstyneOreBlocks.getCompressedGraniteFireOpalOre().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> netherCrimoniteOres =
            ImmutableList.of(OreFeatureConfig.createTarget(netherReplaceables, GemstyneOreBlocks.getNetherCrimoniteOre().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> netherAldusOres =
            ImmutableList.of(OreFeatureConfig.createTarget(netherReplaceables, GemstyneOreBlocks.getNetherAldusOre().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> compressedCoalOres =
            ImmutableList.of(OreFeatureConfig.createTarget(
                    compressedGraniteReplaceables,
                    GemstyneOreBlocks.getCompressedGraniteCoalOre().getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> rawMochiteBlobs =
            ImmutableList.of(OreFeatureConfig.createTarget(mochiteReplaceables, GemstyneOreBlocks.getRawMochiteBlock().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> rawMorkiteBlobs =
            ImmutableList.of(OreFeatureConfig.createTarget(morkiteReplaceables, GemstyneOreBlocks.getMorkiteBlock().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> rawUraniumBlobs =
            ImmutableList.of(OreFeatureConfig.createTarget(uraniumReplaceables, GemstyneOreBlocks.getRawUraniumBlock().getDefaultState()));
}
