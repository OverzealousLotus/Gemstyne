package lotus.gemstyne.world.geodes;

import com.google.common.collect.ImmutableSet;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.world.GemstyneConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Pair;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public final class GemstyneGeodeConfig {
    private GemstyneGeodeConfig() {}

    // =====
    // <===== Geode Keys =====>
    // =====
    public static final RegistryKey<ConfiguredFeature<?, ?>> IKARITE_KEY =
            GemstyneConfiguredFeatures.registerKey("ikarite_geode");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GARNET_KEY =
            GemstyneConfiguredFeatures.registerKey("garnet_geode");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LAPIS_KEY =
            GemstyneConfiguredFeatures.registerKey("lapis_geode");


    public static void registerGeodeConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context) {
        // =====
        // <===== Geodes =====>
        // =====
        createGeodeConfig(context, IKARITE_KEY, Blocks.AIR, GemstyneOreBlocks.IKARITE.pureBlock(),
            GemstyneOreBlocks.IKARITE.buddingBlock(), Blocks.BASALT, Blocks.OBSIDIAN, GemstyneOreBlocks.IKARITE.getBudSet(),
            new GeodeLayerThicknessConfig(1.4D, 1.0D, 2.2D, 3.0D),
            new GeodeCrackConfig(0.05D, 0.5D, 1), 0.5D,
            new Pair<>(0.08D, true), UniformIntProvider.create(3, 8), UniformIntProvider.create(2, 6),
            UniformIntProvider.create(1, 2), -15, 18, 0.070D, 1);
        createGeodeConfig(context, LAPIS_KEY, Blocks.AIR, Blocks.CALCITE, GemstyneOreBlocks.LAPIS.buddingBlock(),
            Blocks.CALCITE, Blocks.COBBLED_DEEPSLATE, GemstyneOreBlocks.LAPIS.getBudSet(),
            new GeodeLayerThicknessConfig(1.5D, 1.2D, 2.5D, 3.5D),
            new GeodeCrackConfig(0.10D, 0.5D, 1), 0.5D,
            new Pair<>(0.1D, true), UniformIntProvider.create(3, 8), UniformIntProvider.create(2, 6),
            UniformIntProvider.create(1, 2), -18, 18, 0.075D, 1);
        createGeodeConfig(context, GARNET_KEY, Blocks.AIR, GemstyneOreBlocks.GARNET.pureBlock(),
            GemstyneOreBlocks.GARNET.buddingBlock(), Blocks.BASALT, Blocks.OBSIDIAN, GemstyneOreBlocks.GARNET.getBudSet(),
            new GeodeLayerThicknessConfig(1.5D, 1.2D, 2.0D, 3.0D),
            new GeodeCrackConfig(0.10D, 0.5D, 1), 0.5D,
            new Pair<>(0.1D, true), UniformIntProvider.create(3, 7), UniformIntProvider.create(2, 5),
            UniformIntProvider.create(1, 2), -18, 15, 0.070D, 1);
    }

    public static void createGeodeConfig(
        Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, Block centerLayer, Block innerLayer, Block buddingBlock,
        Block middleLayer, Block outerLayer, ImmutableSet<Block> buds, GeodeLayerThicknessConfig thicknessConfig,
        GeodeCrackConfig crackConfig, double placementChance, Pair<Double, Boolean> buddingChance,
        UniformIntProvider outerLayerDistance, UniformIntProvider distributionPoints, UniformIntProvider pointOffset,
        int maxDistributionPoints, int minPointOffset, double noiseMultiplier, int maxGenOffset) {
        GemstyneConfiguredFeatures.register(context, key, Feature.GEODE,
            new GeodeFeatureConfig(new GeodeLayerConfig(
                BlockStateProvider.of(centerLayer),
                BlockStateProvider.of(innerLayer),
                BlockStateProvider.of(buddingBlock),
                BlockStateProvider.of(middleLayer),
                BlockStateProvider.of(outerLayer),
                buds.stream().map(Block::getDefaultState).toList(),
                BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                thicknessConfig, crackConfig, placementChance,
                buddingChance.getLeft(), buddingChance.getRight(),
                outerLayerDistance, distributionPoints, pointOffset,
                maxDistributionPoints, minPointOffset, noiseMultiplier, maxGenOffset));
    }
}
