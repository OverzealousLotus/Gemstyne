package lotus.gemstyne.world.minerals;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class GemstyneMineralLists {
    protected static final RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    protected static final RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    // protected static final RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

    // =====
    // <===== Minerals =====>
    // =====
    protected static final ImmutableList<OreFeatureConfig.Target> haliteBlobs =
            ImmutableList.of(OreFeatureConfig.createTarget(
                    stoneReplaceables, GemstyneMineralBlocks.MINERAL_BLOCKS.halite().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> pumiceBlobs =
            ImmutableList.of(OreFeatureConfig.createTarget(
                    stoneReplaceables, GemstyneMineralBlocks.MINERAL_BLOCKS.pumice().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> gabbroBlobs =
            ImmutableList.of(
                    OreFeatureConfig.createTarget(stoneReplaceables,
                            GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro().getDefaultState()),
                    OreFeatureConfig.createTarget(deepslateReplaceables,
                            GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro().getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> compactDirt =
            ImmutableList.of(OreFeatureConfig.createTarget(
                    deepslateReplaceables, GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt().getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> compressedGranite =
            ImmutableList.of(OreFeatureConfig.createTarget(
                    deepslateReplaceables, GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> compressedDiorite =
            ImmutableList.of(OreFeatureConfig.createTarget(
                    deepslateReplaceables, GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite().getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> compressedAndesite =
            ImmutableList.of(OreFeatureConfig.createTarget(
                    deepslateReplaceables, GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite().getDefaultState()));
}
