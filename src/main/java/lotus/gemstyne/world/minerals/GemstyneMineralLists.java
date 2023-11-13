package lotus.gemstyne.world.minerals;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.block.BlockHandler;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.OreFeatureConfig;

@SuppressWarnings("java:S4738")
public class GemstyneMineralLists {
    private GemstyneMineralLists() {}

    protected static final RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    protected static final RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    // =====
    // <===== Minerals =====>
    // =====
    protected static final ImmutableList<OreFeatureConfig.Target> haliteBlobs = ImmutableList.of(
        OreFeatureConfig.createTarget(stoneReplaceables, BlockHandler.HALITE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> pumiceBlobs = ImmutableList.of(
        OreFeatureConfig.createTarget(stoneReplaceables, BlockHandler.PUMICE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> gabbroBlobs = ImmutableList.of(
        OreFeatureConfig.createTarget(stoneReplaceables, BlockHandler.GABBRO.getDefaultState()),
        OreFeatureConfig.createTarget(deepslateReplaceables, BlockHandler.GABBRO.getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> compactDirt = ImmutableList.of(
        OreFeatureConfig.createTarget(deepslateReplaceables, BlockHandler.COMPACT_DIRT.getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> compressedGranite = ImmutableList.of(
        OreFeatureConfig.createTarget(deepslateReplaceables, BlockHandler.COMPRESSED_GRANITE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> compressedDiorite = ImmutableList.of(
        OreFeatureConfig.createTarget(deepslateReplaceables, BlockHandler.COMPRESSED_DIORITE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> compressedAndesite = ImmutableList.of(
        OreFeatureConfig.createTarget(deepslateReplaceables, BlockHandler.COMPRESSED_ANDESITE.getDefaultState()));
}
