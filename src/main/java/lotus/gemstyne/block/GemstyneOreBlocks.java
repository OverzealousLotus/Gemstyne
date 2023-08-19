package lotus.gemstyne.block;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public final class GemstyneOreBlocks {
    // =====
    // <===== Features of Blocks =====>
    // =====
    /* Not to be confused with Placed/Configured Features, Features in this context refer to
    -their similar characteristics between each other. For example, most Compressed blocks should
    -sound like deepslate, or play Base Drum when used as an instrument.
     */
    private static final FabricBlockSettings CRYSTALLINE_FEATURES = FabricBlockSettings.create()
            .requiresTool().ticksRandomly().nonOpaque()
            .strength(1.5f, 1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)
            .luminance(state -> 5);
    private static final FabricBlockSettings COMPRESSED_FEATURES = FabricBlockSettings.create()
            .requiresTool().sounds(BlockSoundGroup.DEEPSLATE).instrument(Instrument.BASEDRUM);

    // =====
    // <===== Overworld Ores =====>
    // =====
    public static final Block NEFARIUM_ORE = GemstyneBlocks.registerBlock("nefarium_ore",
            new DeepOre(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE), 5));

    public static final Block COMPRESSED_GRANITE_FIRE_OPAL_ORE = GemstyneBlocks.registerBlock(
            "compressed_granite_fire_opal_ore",
                new ExperienceDroppingBlock(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.BROWN)
                        .strength(4.5f, 3.0f), UniformIntProvider.create(10, 15))
    );

    public static final Block MOCHITE_ORE = GemstyneBlocks.registerBlock("mochite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE)
                    .strength(3.0f, 3.0f), UniformIntProvider.create(2, 7))
    );
    public static final Block DEEPSLATE_MOCHITE_ORE = GemstyneBlocks.registerBlock("deepslate_mochite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(2, 7))
    );

    public static final Block DEEPSLATE_MORKITE_ORE = GemstyneBlocks.registerBlock("deepslate_morkite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(3, 10))
    );

    public static final Block TIN_ORE = GemstyneBlocks.registerBlock("tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE)
                    .strength(3.0f, 3.0f), UniformIntProvider.create(2, 5))
    );
    public static final Block DEEPSLATE_TIN_ORE = GemstyneBlocks.registerBlock("deepslate_tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(2, 5))
    );

    public static final Block DEEPSLATE_URANIUM_ORE = GemstyneBlocks.registerBlock("deepslate_uranium_ore",
            new AfflictiveOre(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                    .strength(6.0f, 5.0f), UniformIntProvider.create(5, 15))
    );

    // =====
    // <===== Nether Ores =====>
    // =====
    public static final Block NETHER_ALDUS_ORE = GemstyneBlocks.registerBlock("nether_aldus_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK)
                    .strength(4.0f, 3.0f).sounds(BlockSoundGroup.NETHER_ORE),
                    UniformIntProvider.create(2, 5))
    );

    public static final Block NETHER_CRIMONITE_ORE = GemstyneBlocks.registerBlock("nether_crimonite_ore",
            new CrimoniteOre(FabricBlockSettings.copyOf(Blocks.NETHERRACK)
                    .strength(5.0f, 3.0f).sounds(BlockSoundGroup.NETHER_ORE),
                    UniformIntProvider.create(2, 5))
    );

    // =====
    // <===== Ore Extensions =====>
    // =====
    public static final Block COMPRESSED_GRANITE_COAL_ORE = GemstyneBlocks.registerBlock("compressed_granite_coal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE).mapColor(MapColor.BROWN)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(0, 2))
    );

    // =====
    // <===== Concentrated Ores =====>
    // =====
    public static final Block RAW_ALDUS_BLOCK = GemstyneBlocks.registerBlock("raw_aldus_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)
                    .strength(6.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS))
    );

    public static final Block RAW_CRIMONITE_BLOCK = GemstyneBlocks.registerBlock("raw_crimonite_block",
            new CrimoniteBlock(FabricBlockSettings.copyOf(Blocks.LODESTONE)
                    .strength(8.0f, 8.0f))
    );

    public static final Block RAW_MOCHITE_BLOCK = GemstyneBlocks.registerBlock("raw_mochite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(4.0f, 3.0f))
    );

    public static final Block MORKITE_BLOCK = GemstyneBlocks.registerBlock("morkite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(5.0f, 3.0f))
    );

    public static final Block RAW_TIN_BLOCK = GemstyneBlocks.registerBlock("raw_tin_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)
                    .strength(4.0f, 3.0f))
    );

    public static final Block RAW_URANIUM_BLOCK = GemstyneBlocks.registerBlock("raw_uranium_block",
            new AfflictiveBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)
                    .strength(7.0f, 6.0f))
    );

    // =====
    // <===== Crystalline Blocks =====>
    // =====
    public static final Block IKARITE_CLUSTER = GemstyneBlocks.registerBlock("ikarite_cluster",
            new CrystallineBlockBud(7, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES))
    );
    public static final Block LARGE_IKARITE_BUD = GemstyneBlocks.registerBlock("large_ikarite_bud",
            new CrystallineBlockBud(5, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4))
    );
    public static final Block MEDIUM_IKARITE_BUD = GemstyneBlocks.registerBlock("medium_ikarite_bud",
            new CrystallineBlockBud(4, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2))
    );
    public static final Block SMALL_IKARITE_BUD = GemstyneBlocks.registerBlock("small_ikarite_bud",
            new CrystallineBlockBud(3, 4, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1))
    );

    public static final Block IKARITE_BLOCK = GemstyneBlocks.registerBlock("ikarite_block",
            new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(3.0f, 3.0f))
    );
    public static final Block BUDDING_IKARITE = GemstyneBlocks.registerBlock("budding_ikarite",
            new BuddingCrystallineBlock(FabricBlockSettings.copyOf(Blocks.BUDDING_AMETHYST)
                    .strength(3.0f, 2.0f), ImmutableList.of(
                            SMALL_IKARITE_BUD,
                            MEDIUM_IKARITE_BUD,
                            LARGE_IKARITE_BUD,
                            IKARITE_CLUSTER
            ))
    );

    public static final Block GARNET_CLUSTER = GemstyneBlocks.registerBlock("garnet_cluster",
            new CrystallineBlockBud(7, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES))
    );
    public static final Block LARGE_GARNET_BUD = GemstyneBlocks.registerBlock("large_garnet_bud",
            new CrystallineBlockBud(5, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4))
    );
    public static final Block MEDIUM_GARNET_BUD = GemstyneBlocks.registerBlock("medium_garnet_bud",
            new CrystallineBlockBud(4, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2))
    );
    public static final Block SMALL_GARNET_BUD = GemstyneBlocks.registerBlock("small_garnet_bud",
            new CrystallineBlockBud(3, 4, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1))
    );

    public static final Block GARNET_BLOCK = GemstyneBlocks.registerBlock("garnet_block",
            new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(1.5f, 1.0f))
    );
    public static final Block BUDDING_GARNET = GemstyneBlocks.registerBlock("budding_garnet",
            new BuddingCrystallineBlock(FabricBlockSettings.copyOf(Blocks.BUDDING_AMETHYST)
                    .strength(1.5f, 1.0f), ImmutableList.of(
                    SMALL_GARNET_BUD,
                    MEDIUM_GARNET_BUD,
                    LARGE_GARNET_BUD,
                    GARNET_CLUSTER
            ))
    );


    public static void registerOreBlocks() {Gemstyne.LOGGER.info("Registering Ores...");}
}
