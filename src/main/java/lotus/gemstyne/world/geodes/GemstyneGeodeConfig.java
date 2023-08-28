package lotus.gemstyne.world.geodes;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.world.GemstyneConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public final class GemstyneGeodeConfig {
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
        GemstyneConfiguredFeatures.register(context, IKARITE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(
                        BlockStateProvider.of(Blocks.AIR), // Central Layer
                        BlockStateProvider.of(GemstyneOreBlocks.IKARITE.pureBlock()), // Inner Layer
                        BlockStateProvider.of(GemstyneOreBlocks.IKARITE.buddingBlock()), // Budding Base
                        BlockStateProvider.of(Blocks.BASALT), // Middle Layer
                        BlockStateProvider.of(Blocks.OBSIDIAN), // External Layer
                        ImmutableList.of( // List of Buds
                                GemstyneOreBlocks.IKARITE.clusterBud().getDefaultState(),
                                GemstyneOreBlocks.IKARITE.largeBud().getDefaultState(),
                                GemstyneOreBlocks.IKARITE.mediumBud().getDefaultState(),
                                GemstyneOreBlocks.IKARITE.smallBud().getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS
                ),
                        new GeodeLayerThicknessConfig(
                                1.5D, // Central Layer
                                1.2D, // Inner Layer
                                2.5D, // Middle Layer
                                3.5D), // External Layer
                        new GeodeCrackConfig(
                                0.10D, // Chance of Crack in Geode
                                0.5D, // Size of Crack
                                1 // Offset of Crack Spawn.
                        ),
                        0.5D,   // No idea.
                        0.1D,   // Chance of Budding Blocks to replace Inner Layer Blocks.
                        true, UniformIntProvider.create(3, 8),
                        UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
                        -18, 18, 0.075D, 1));

        GemstyneConfiguredFeatures.register(context, LAPIS_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(
                        BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(Blocks.LAPIS_BLOCK),
                        BlockStateProvider.of(GemstyneOreBlocks.LAPIS.buddingBlock()),
                        BlockStateProvider.of(Blocks.DEEPSLATE_LAPIS_ORE),
                        BlockStateProvider.of(Blocks.COBBLED_DEEPSLATE),
                        ImmutableList.of(
                                GemstyneOreBlocks.LAPIS.clusterBud().getDefaultState(),
                                GemstyneOreBlocks.LAPIS.largeBud().getDefaultState(),
                                GemstyneOreBlocks.LAPIS.mediumBud().getDefaultState(),
                                GemstyneOreBlocks.LAPIS.smallBud().getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS
                ),
                        new GeodeLayerThicknessConfig(1.5D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackConfig(0.10D, 0.5D, 1),
                        0.5D, 0.1D,
                        true, UniformIntProvider.create(3, 8),
                        UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
                        -18, 18, 0.075D, 1));

        GemstyneConfiguredFeatures.register(context, GARNET_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(GemstyneOreBlocks.GARNET.pureBlock()),
                        BlockStateProvider.of(GemstyneOreBlocks.GARNET.buddingBlock()),
                        BlockStateProvider.of(Blocks.BASALT),
                        BlockStateProvider.of(Blocks.OBSIDIAN),
                        ImmutableList.of(
                                GemstyneOreBlocks.GARNET.clusterBud().getDefaultState(),
                                GemstyneOreBlocks.GARNET.largeBud().getDefaultState(),
                                GemstyneOreBlocks.GARNET.mediumBud().getDefaultState(),
                                GemstyneOreBlocks.GARNET.smallBud().getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(1.5D, 1.2D, 2.0D, 3.0D),
                        new GeodeCrackConfig(0.10D, 0.5D, 1),
                        0.5D, 0.1D,
                        true, UniformIntProvider.create(3, 7),
                        UniformIntProvider.create(2, 5), UniformIntProvider.create(1, 2),
                        -15, 15, 0.070D, 1));
    }
}
