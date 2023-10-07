package lotus.gemstyne.world.minerals;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.block.GemstyneBlockHandler;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.OreFeatureConfig;

@SuppressWarnings("java:S4738")
public class GemstyneMineralLists {
    private GemstyneMineralLists() {}

    protected static final RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    protected static final RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    // protected static final RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

    // =====
    // <===== Minerals =====>
    // =====
    protected static final ImmutableList<OreFeatureConfig.Target> haliteBlobs = ImmutableList.of(
        OreFeatureConfig.createTarget(
            stoneReplaceables, GemstyneBlockHandler.HALITE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> pumiceBlobs = ImmutableList.of(
        OreFeatureConfig.createTarget(
            stoneReplaceables, GemstyneBlockHandler.PUMICE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> gabbroBlobs = ImmutableList.of(
        OreFeatureConfig.createTarget(stoneReplaceables,
            GemstyneBlockHandler.GABBRO.getDefaultState()),
        OreFeatureConfig.createTarget(deepslateReplaceables,
            GemstyneBlockHandler.GABBRO.getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> compactDirt = ImmutableList.of(
        OreFeatureConfig.createTarget(
            deepslateReplaceables, GemstyneBlockHandler.COMPACT_DIRT.getDefaultState()));

    protected static final ImmutableList<OreFeatureConfig.Target> compressedGranite = ImmutableList.of(
        OreFeatureConfig.createTarget(
            deepslateReplaceables, GemstyneBlockHandler.COMPRESSED_GRANITE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> compressedDiorite = ImmutableList.of(
        OreFeatureConfig.createTarget(
            deepslateReplaceables, GemstyneBlockHandler.COMPRESSED_DIORITE.getDefaultState()));
    protected static final ImmutableList<OreFeatureConfig.Target> compressedAndesite = ImmutableList.of(
        OreFeatureConfig.createTarget(
            deepslateReplaceables, GemstyneBlockHandler.COMPRESSED_ANDESITE.getDefaultState()));
}
