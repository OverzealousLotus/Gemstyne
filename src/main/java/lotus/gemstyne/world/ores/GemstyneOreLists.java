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
            ImmutableList.of(OreFeatureConfig.createTarget(stoneReplaceables, GemstyneOreBlocks.MOCHITE_ORE.getDefaultState()),
                    OreFeatureConfig.createTarget(deepslateReplaceables, GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE.getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> overworldUraniumOres =
            ImmutableList.of(OreFeatureConfig.createTarget(deepslateReplaceables, GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> overworldMorkiteOres =
            ImmutableList.of(OreFeatureConfig.createTarget(deepslateReplaceables, GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> overworldFireOpalOres =
            ImmutableList.of(OreFeatureConfig.createTarget(compressedGraniteReplaceables, GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> netherCrimoniteOres =
            ImmutableList.of(OreFeatureConfig.createTarget(netherReplaceables, GemstyneOreBlocks.NETHER_CRIMONITE_ORE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> netherAldusOres =
            ImmutableList.of(OreFeatureConfig.createTarget(netherReplaceables, GemstyneOreBlocks.NETHER_ALDUS_ORE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> compressedCoalOres =
            ImmutableList.of(OreFeatureConfig.createTarget(
                    compressedGraniteReplaceables,
                    GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE.getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> rawMochiteBlobs =
            ImmutableList.of(OreFeatureConfig.createTarget(mochiteReplaceables, GemstyneOreBlocks.RAW_MOCHITE_BLOCK.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> rawMorkiteBlobs =
            ImmutableList.of(OreFeatureConfig.createTarget(morkiteReplaceables, GemstyneOreBlocks.MORKITE_BLOCK.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> rawUraniumBlobs =
            ImmutableList.of(OreFeatureConfig.createTarget(uraniumReplaceables, GemstyneOreBlocks.RAW_URANIUM_BLOCK.getDefaultState()));
}
