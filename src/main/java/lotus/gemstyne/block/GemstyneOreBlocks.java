package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.AfflictiveOre;
import lotus.gemstyne.block.custom.CrimoniteBlock;
import lotus.gemstyne.block.custom.CrimoniteOre;
import lotus.gemstyne.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static lotus.gemstyne.block.GemstyneBlocks.registerBlock;

public final class GemstyneOreBlocks {
    // =====
    // <===== Ores =====>
    // =====
    public static final Block MOCHITE_ORE = registerBlock("mochite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(3.0f, 3.0f).sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(2, 7)),
            ModItemGroup.GEMSTYNE);
    public static final Block DEEPSLATE_MOCHITE_ORE = registerBlock("deepslate_mochite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(2, 7)),
            ModItemGroup.GEMSTYNE);

    public static final Block TIN_ORE = registerBlock("tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(3.0f, 3.0f).sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(2, 5)),
            ModItemGroup.GEMSTYNE);
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(2, 5)),
            ModItemGroup.GEMSTYNE);

    public static final Block DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore",
            new AfflictiveOre(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(6.0f, 5.0f).sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(5, 15)),
            ModItemGroup.GEMSTYNE);

    public static final Block DEEPSLATE_MORKITE_ORE = registerBlock("deepslate_morkite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 10)),
            ModItemGroup.GEMSTYNE);

    public static final Block NETHER_CRIMONITE_ORE = registerBlock("nether_crimonite_ore",
            new CrimoniteOre(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(5.0f, 3.0f).sounds(BlockSoundGroup.NETHER_ORE),
                    UniformIntProvider.create(2, 5)),
            ModItemGroup.GEMSTYNE);

    public static final Block NETHER_ALDUS_ORE = registerBlock("nether_aldus_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(4.0f, 3.0f).sounds(BlockSoundGroup.NETHER_ORE),
                    UniformIntProvider.create(2, 5)),
            ModItemGroup.GEMSTYNE);

    public static final Block COMPRESSED_GRANITE_FIRE_OPAL_ORE = registerBlock(
            "compressed_granite_fire_opal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(10, 15)),
            ModItemGroup.GEMSTYNE);


    // =====
    // <===== Ore Extensions =====>
    // =====
    public static final Block COMPRESSED_GRANITE_COAL_ORE = registerBlock("compressed_granite_coal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(0, 2)),
            ModItemGroup.GEMSTYNE);

    // =====
    // <==== Compact Ores =====>
    // =====
    public static final Block RAW_MOCHITE_BLOCK = registerBlock("raw_mochite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                    .strength(4.0f, 3.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            ModItemGroup.GEMSTYNE);

    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(4.0f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)),
            ModItemGroup.GEMSTYNE);

    public static final Block RAW_URANIUM_BLOCK = registerBlock("raw_uranium_block",
            new AfflictiveBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(7.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)),
            ModItemGroup.GEMSTYNE);

    public static final Block MORKITE_BLOCK = registerBlock("morkite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                    .strength(5.0f, 3.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            ModItemGroup.GEMSTYNE);

    public static final Block RAW_CRIMONITE_BLOCK = registerBlock("raw_crimonite_block",
            new CrimoniteBlock(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(8.0f, 8.0f).sounds(BlockSoundGroup.LODESTONE)),
            ModItemGroup.GEMSTYNE);

    public static final Block RAW_ALDUS_BLOCK = registerBlock("raw_aldus_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(6.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS)),
            ModItemGroup.GEMSTYNE);


    // =====
    // <==== Crystalline =====>
    // =====
    public static final Block IKARITE_BLOCK = registerBlock("ikarite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                    .strength(3.0f, 3.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            ModItemGroup.GEMSTYNE);
    public static final Block BUDDING_IKARITE = registerBlock("budding_ikarite",
            new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool().ticksRandomly()
                    .strength(3.0f, 2.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            ModItemGroup.GEMSTYNE);

    public static final Block IKARITE_CLUSTER = registerBlock("ikarite_cluster",
            new AmethystClusterBlock(7, 3, FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5f, 1.0f)
                    .luminance(state -> 5).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block LARGE_IKARITE_BUD = registerBlock("large_ikarite_bud",
            new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(IKARITE_CLUSTER)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block MEDIUM_IKARITE_BUD = registerBlock("medium_ikarite_bud",
            new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(IKARITE_CLUSTER)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block SMALL_IKARITE_BUD = registerBlock("small_ikarite_bud",
            new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(IKARITE_CLUSTER)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1).requiresTool()),
            ModItemGroup.GEMSTYNE);

    public static final Block GARNET_BLOCK = registerBlock("garnet_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                    .strength(1.5f, 1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            ModItemGroup.GEMSTYNE);
    public static final Block BUDDING_GARNET = registerBlock("budding_garnet",
            new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool().ticksRandomly()
                    .strength(1.5f, 1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            ModItemGroup.GEMSTYNE);

    public static final Block GARNET_CLUSTER = registerBlock("garnet_cluster",
            new AmethystClusterBlock(7, 3, FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5f, 1.0f)
                    .luminance(state -> 5).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block LARGE_GARNET_BUD = registerBlock("large_garnet_bud",
            new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(GARNET_CLUSTER)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block MEDIUM_GARNET_BUD = registerBlock("medium_garnet_bud",
            new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(GARNET_CLUSTER)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block SMALL_GARNET_BUD = registerBlock("small_garnet_bud",
            new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(GARNET_CLUSTER)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1).requiresTool()),
            ModItemGroup.GEMSTYNE);

    protected static void registerOreBlocks() {Gemstyne.LOGGER.info("Registering Ores...");}
}
