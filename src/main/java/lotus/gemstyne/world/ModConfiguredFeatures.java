package lotus.gemstyne.world;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
public class ModConfiguredFeatures {
    /** Configuration of Features for world generation. Keys must be registered first,
     * then using the bootstrap method, create a list of target blocks to be replaced.
     * Finally, we move to the actual configuration at the end, where settings may vary. */



    // =====
    // ==========
    // <========== Key Registration ==========>
    // ==========
    // =====



    // =====
    // <===== Ores =====>
    // =====
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOCHITE_ORE_KEY = registerKey("mochite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> URANIUM_ORE_KEY = registerKey("deepslate_uranium_ore");

    // =====
    // <===== Minerals =====>
    // =====
    public static final RegistryKey<ConfiguredFeature<?, ?>> HALITE_KEY = registerKey("halite");

    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPACT_DIRT_KEY = registerKey("compact_dirt");

    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_GRANITE_KEY = registerKey("compressed_granite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_DIORITE_KEY = registerKey("compressed_diorite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_ANDESITE_KEY = registerKey("compressed_andesite");

    // =====
    // <===== Geodes =====>
    // =====
    public static final RegistryKey<ConfiguredFeature<?, ?>> IKARITE_KEY = registerKey("ikarite_geode");

    // =====
    // <===== Trees =====>
    // =====
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MAPLE_KEY = registerKey("red_maple");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // =====
        // ==========
        // <========== Configuration Lists ==========>
        // ==========
        // =====


        // =====
        // <===== Ores =====>
        // =====
        List<OreFeatureConfig.Target> overworldMochiteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.MOCHITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_MOCHITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldUraniumOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_URANIUM_ORE.getDefaultState()));

        // =====
        // <===== Minerals =====>
        // =====
        List<OreFeatureConfig.Target> haliteGeneration =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.HALITE.getDefaultState()));

        List<OreFeatureConfig.Target> compactDirt =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.COMPACT_DIRT.getDefaultState()));

        List<OreFeatureConfig.Target> compressedGranite =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.COMPRESSED_GRANITE.getDefaultState()));
        List<OreFeatureConfig.Target> compressedDiorite =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.COMPRESSED_DIORITE.getDefaultState()));
        List<OreFeatureConfig.Target> compressedAndesite =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.COMPRESSED_ANDESITE.getDefaultState()));



        // =====
        // ==========
        // <========== Configuration & Registration ==========>
        // ==========
        // =====



        // <===== Trees =====>
        // =====
        register(context, RED_MAPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.RED_MAPLE_LOG),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.RED_MAPLE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        // =====
        // <===== Ores =====>
        // =====
        register(context, MOCHITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldMochiteOres, 12)); // Vein size.
        register(context, URANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldUraniumOres, 6));

        // =====
        // <===== Minerals =====>
        // =====
        register(context, HALITE_KEY, Feature.ORE, new OreFeatureConfig(haliteGeneration, 33));

        register(context, COMPACT_DIRT_KEY, Feature.ORE, new OreFeatureConfig(compactDirt, 33));

        register(context, COMPRESSED_GRANITE_KEY, Feature.ORE, new OreFeatureConfig(compressedGranite, 64));
        register(context, COMPRESSED_DIORITE_KEY, Feature.ORE, new OreFeatureConfig(compressedDiorite, 64));
        register(context, COMPRESSED_ANDESITE_KEY, Feature.ORE, new OreFeatureConfig(compressedAndesite, 64));

        // =====
        // <===== Geodes =====>
        // =====
        register(context, IKARITE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(ModBlocks.IKARITE_BLOCK), // Most-Inner filling.
                        BlockStateProvider.of(ModBlocks.BUDDING_IKARITE), // Budding Base
                        BlockStateProvider.of(Blocks.BASALT), // Inner Layer
                        BlockStateProvider.of(Blocks.OBSIDIAN), // External Layer
                        List.of(ModBlocks.IKARITE_CLUSTER.getDefaultState()), // Actual buds.
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackConfig(0.25D, 1.5D, 1),
                        0.5D, 0.1D,
                        true, UniformIntProvider.create(3, 8),
                        UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
                        -18, 18, 0.075D, 1));
    }



    // =====
    // ==========
    // <========== Assistive Functions ==========>
    // ==========
    // =====
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Gemstyne.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
