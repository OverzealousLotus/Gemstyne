package lotus.gemstyne.world.ores;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.block.BlockHandler;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.world.gen.feature.OreFeatureConfig;

@SuppressWarnings("java:S4738")
public final class GemstyneOreLists {
    private GemstyneOreLists() {}

    // =====
    // <===== Block rules for generation =====>
    // =====
    public static final RuleTest compressedGraniteReplaceables =
        new BlockMatchRuleTest(BlockHandler.COMPRESSED_GRANITE);


    // =====
    // <===== Overworld Ore Replaceables =====>
    // =====
    public static final ImmutableList<OreFeatureConfig.Target> overworldFireOpalOres = ImmutableList.of(
            OreFeatureConfig.createTarget(compressedGraniteReplaceables,
                    BlockHandler.COMPRESSED_GRANITE_FIRE_OPAL_ORE.getDefaultState()));

    // =====
    // <===== Ore Extension Replaceables =====>
    // =====
    public static final ImmutableList<OreFeatureConfig.Target> compressedCoalOres = ImmutableList.of(
            OreFeatureConfig.createTarget(compressedGraniteReplaceables,
                    BlockHandler.COMPRESSED_GRANITE_COAL_ORE.getDefaultState()));


    // =====
    // <===== Getters =====>
    // =====
}
