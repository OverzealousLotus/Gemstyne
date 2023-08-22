package lotus.gemstyne.block;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.*;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.util.GemstyneBlockTypes;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
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
    public static final Block NEFARIUM_ORE = GemstyneBlockHandler.registerBlock("nefarium_ore",
            new RichOre(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE), 5));

    public static final Block COMPRESSED_GRANITE_FIRE_OPAL_ORE = GemstyneBlockHandler.registerBlock(
            "compressed_granite_fire_opal_ore",
                new ExperienceDroppingBlock(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.BROWN)
                        .strength(4.5f, 3.0f), UniformIntProvider.create(10, 15))
    );

    public static final Block MOCHITE_ORE = GemstyneBlockHandler.registerBlock("mochite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE)
                    .strength(3.0f, 3.0f), UniformIntProvider.create(2, 7))
    );
    public static final Block DEEPSLATE_MOCHITE_ORE = GemstyneBlockHandler.registerBlock("deepslate_mochite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(2, 7))
    );

    public static final Block DEEPSLATE_MORKITE_ORE = GemstyneBlockHandler.registerBlock("deepslate_morkite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(3, 10))
    );

    public static final Block TIN_ORE = GemstyneBlockHandler.registerBlock("tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE)
                    .strength(3.0f, 3.0f), UniformIntProvider.create(2, 5))
    );
    public static final Block DEEPSLATE_TIN_ORE = GemstyneBlockHandler.registerBlock("deepslate_tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(2, 5))
    );

    public static final Block DEEPSLATE_URANIUM_ORE = GemstyneBlockHandler.registerBlock("deepslate_uranium_ore",
            new AfflictiveOre(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                    .strength(6.0f, 5.0f), GemstyneEffects.IRRADIATE,
                    30, 60, 100, GemstyneBlockTypes.ORE, UniformIntProvider.create(5, 15))
    );

    // =====
    // <===== Nether Ores =====>
    // =====
    public static final Block NETHER_ALDUS_ORE = GemstyneBlockHandler.registerBlock("nether_aldus_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK)
                    .strength(4.0f, 3.0f).sounds(BlockSoundGroup.NETHER_ORE),
                    UniformIntProvider.create(2, 5))
    );

    public static final Block NETHER_CRIMONITE_ORE = GemstyneBlockHandler.registerBlock("nether_crimonite_ore",
            new AfflictiveOre(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE)
                    .strength(5.0f, 3.0f), StatusEffects.WITHER,
                    60, 100, 120, GemstyneBlockTypes.ORE, UniformIntProvider.create(2, 5))
    );

    // =====
    // <===== Ore Extensions =====>
    // =====
    public static final Block COMPRESSED_GRANITE_COAL_ORE = GemstyneBlockHandler.registerBlock("compressed_granite_coal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE).mapColor(MapColor.BROWN)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(0, 2))
    );

    // =====
    // <===== Concentrated Ores =====>
    // =====
    public static final Block RAW_ALDUS_BLOCK = GemstyneBlockHandler.registerBlock("raw_aldus_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)
                    .strength(6.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS))
    );

    public static final Block RAW_CRIMONITE_BLOCK = GemstyneBlockHandler.registerBlock("raw_crimonite_block",
            new AfflictiveBlock(FabricBlockSettings.copyOf(Blocks.LODESTONE).strength(8.0f, 8.0f),
                    StatusEffects.WITHER, 60, 100, 120, GemstyneBlockTypes.RAW)
    );

    public static final Block RAW_MOCHITE_BLOCK = GemstyneBlockHandler.registerBlock("raw_mochite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(4.0f, 3.0f))
    );

    public static final Block MORKITE_BLOCK = GemstyneBlockHandler.registerBlock("morkite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(5.0f, 3.0f))
    );

    public static final Block RAW_TIN_BLOCK = GemstyneBlockHandler.registerBlock("raw_tin_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)
                    .strength(4.0f, 3.0f))
    );

    public static final Block RAW_URANIUM_BLOCK = GemstyneBlockHandler.registerBlock("raw_uranium_block",
            new AfflictiveBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)
                    .strength(7.0f, 6.0f), GemstyneEffects.IRRADIATE,
                    30, 60, 100, GemstyneBlockTypes.RAW)
    );

    // =====
    // <===== Crystalline Blocks =====>
    // =====
    public static final Block IKARITE_CLUSTER = GemstyneBlockHandler.registerBlock("ikarite_cluster",
            new CrystallineBlockBud(7, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES))
    );
    public static final Block LARGE_IKARITE_BUD = GemstyneBlockHandler.registerBlock("large_ikarite_bud",
            new CrystallineBlockBud(5, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4))
    );
    public static final Block MEDIUM_IKARITE_BUD = GemstyneBlockHandler.registerBlock("medium_ikarite_bud",
            new CrystallineBlockBud(4, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2))
    );
    public static final Block SMALL_IKARITE_BUD = GemstyneBlockHandler.registerBlock("small_ikarite_bud",
            new CrystallineBlockBud(3, 4, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1))
    );

    public static final Block IKARITE_BLOCK = GemstyneBlockHandler.registerBlock("ikarite_block",
            new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(3.0f, 3.0f))
    );
    public static final Block BUDDING_IKARITE = GemstyneBlockHandler.registerBlock("budding_ikarite",
            new BuddingCrystallineBlock(FabricBlockSettings.copyOf(Blocks.BUDDING_AMETHYST)
                    .strength(3.0f, 2.0f), ImmutableList.of(
                            SMALL_IKARITE_BUD,
                            MEDIUM_IKARITE_BUD,
                            LARGE_IKARITE_BUD,
                            IKARITE_CLUSTER
            ))
    );

    public static final Block GARNET_CLUSTER = GemstyneBlockHandler.registerBlock("garnet_cluster",
            new CrystallineBlockBud(7, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES))
    );
    public static final Block LARGE_GARNET_BUD = GemstyneBlockHandler.registerBlock("large_garnet_bud",
            new CrystallineBlockBud(5, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4))
    );
    public static final Block MEDIUM_GARNET_BUD = GemstyneBlockHandler.registerBlock("medium_garnet_bud",
            new CrystallineBlockBud(4, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2))
    );
    public static final Block SMALL_GARNET_BUD = GemstyneBlockHandler.registerBlock("small_garnet_bud",
            new CrystallineBlockBud(3, 4, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1))
    );

    public static final Block GARNET_BLOCK = GemstyneBlockHandler.registerBlock("garnet_block",
            new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(1.5f, 1.0f))
    );
    public static final Block BUDDING_GARNET = GemstyneBlockHandler.registerBlock("budding_garnet",
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
