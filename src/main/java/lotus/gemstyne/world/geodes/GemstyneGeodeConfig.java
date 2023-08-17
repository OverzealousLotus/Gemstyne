package lotus.gemstyne.world.geodes;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.world.GemstyneConfiguredFeatures;
import net.minecraft.block.Blocks;
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


    public static void registerGeodeConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context) {
        // =====
        // <===== Geodes =====>
        // =====
        GemstyneConfiguredFeatures.register(context, IKARITE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR), // Centre
                        BlockStateProvider.of(GemstyneOreBlocks.IKARITE_BLOCK), // Most-Inner filling.
                        BlockStateProvider.of(GemstyneOreBlocks.BUDDING_IKARITE), // Budding Base
                        BlockStateProvider.of(Blocks.BASALT), // Inner Layer
                        BlockStateProvider.of(Blocks.OBSIDIAN), // External Layer
                        ImmutableList.of( // List of Buds
                                GemstyneOreBlocks.IKARITE_CLUSTER.getDefaultState(),
                                GemstyneOreBlocks.LARGE_IKARITE_BUD.getDefaultState(),
                                GemstyneOreBlocks.MEDIUM_IKARITE_BUD.getDefaultState(),
                                GemstyneOreBlocks.SMALL_IKARITE_BUD.getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(1.5D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackConfig(0.10D, 0.5D, 1),
                        0.5D, 0.1D,
                        true, UniformIntProvider.create(3, 8),
                        UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
                        -18, 18, 0.075D, 1));


        GemstyneConfiguredFeatures.register(context, GARNET_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(GemstyneOreBlocks.GARNET_BLOCK),
                        BlockStateProvider.of(GemstyneOreBlocks.BUDDING_GARNET),
                        BlockStateProvider.of(Blocks.BASALT),
                        BlockStateProvider.of(Blocks.OBSIDIAN),
                        ImmutableList.of(
                                GemstyneOreBlocks.GARNET_CLUSTER.getDefaultState(),
                                GemstyneOreBlocks.LARGE_GARNET_BUD.getDefaultState(),
                                GemstyneOreBlocks.MEDIUM_GARNET_BUD.getDefaultState(),
                                GemstyneOreBlocks.SMALL_GARNET_BUD.getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(1.5D, 1.2D, 2.0D, 3.0D),
                        new GeodeCrackConfig(0.10D, 0.5D, 1),
                        0.5D, 0.1D,
                        true, UniformIntProvider.create(3, 7),
                        UniformIntProvider.create(2, 5), UniformIntProvider.create(1, 2),
                        -15, 15, 0.070D, 1));
    }
}
