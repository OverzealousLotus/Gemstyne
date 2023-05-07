package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.carriers.GemstyneGeodeBlockCarrier;
import lotus.gemstyne.block.carriers.GemstyneOreBlockCarrier;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.AfflictiveOre;
import lotus.gemstyne.block.custom.CrimoniteBlock;
import lotus.gemstyne.block.custom.CrimoniteOre;
import lotus.gemstyne.item.GemstyneItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static lotus.gemstyne.block.GemstyneBlocks.registerBlock;

public final class GemstyneOreBlocks {
    private static final FabricBlockSettings ikariteSettings = FabricBlockSettings.of(Material.AMETHYST)
            .requiresTool().ticksRandomly().nonOpaque()
            .strength(1.5f, 1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)
            .luminance(state -> 5);
    private static final FabricBlockSettings garnetSettings = FabricBlockSettings.of(Material.AMETHYST)
            .requiresTool().ticksRandomly().nonOpaque()
            .strength(1.5f, 1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)
            .luminance(state -> 5);


    public static final GemstyneOreBlockCarrier ORE_BLOCKS = new GemstyneOreBlockCarrier(
            // =====
            // <===== Overworld Ores =====>
            // =====
            registerBlock("compressed_granite_fire_opal_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(4.5f, 3.0f)
                            .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(10, 15)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("mochite_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(3.0f, 3.0f)
                            .sounds(BlockSoundGroup.STONE), UniformIntProvider.create(2, 7)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("deepslate_mochite_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(4.5f, 3.0f)
                            .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(2, 7)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("deepslate_morkite_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(4.5f, 3.0f)
                            .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(3, 10)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("tin_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(3.0f, 3.0f)
                            .sounds(BlockSoundGroup.STONE), UniformIntProvider.create(2, 5)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("deepslate_tin_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(4.5f, 3.0f)
                            .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(2, 5)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("deepslate_uranium_ore",
                    new AfflictiveOre(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(6.0f, 5.0f)
                            .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(5, 15)),
                    GemstyneItemGroup.GEMSTYNE),

            // =====
            // <===== Nether Ores =====>
            // =====
            registerBlock("nether_aldus_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(4.0f, 3.0f)
                            .sounds(BlockSoundGroup.NETHER_ORE), UniformIntProvider.create(2, 5)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("nether_crimonite_ore",
                    new CrimoniteOre(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(5.0f, 3.0f)
                            .sounds(BlockSoundGroup.NETHER_ORE), UniformIntProvider.create(2, 5)),
                    GemstyneItemGroup.GEMSTYNE),

            // =====
            // <===== Ore Extensions =====>
            // =====
            registerBlock("compressed_granite_coal_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(4.5f, 3.0f)
                            .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(0, 2)),
                    GemstyneItemGroup.GEMSTYNE),

            // =====
            // <===== Concentrated Ores =====>
            // =====
            registerBlock("raw_aldus_block",
                    new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                            .strength(6.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("raw_crimonite_block",
                    new CrimoniteBlock(FabricBlockSettings.of(Material.METAL).requiresTool()
                            .strength(8.0f, 8.0f).sounds(BlockSoundGroup.LODESTONE)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("raw_mochite_block",
                    new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                            .strength(4.0f, 3.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("morkite_block",
                    new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                            .strength(5.0f, 3.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("raw_tin_block",
                    new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(4.0f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("raw_uranium_block",
                    new AfflictiveBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(7.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)),
                    GemstyneItemGroup.GEMSTYNE)
    );


    public static final GemstyneGeodeBlockCarrier GEODE_BLOCKS = new GemstyneGeodeBlockCarrier(
            // =====
            // <===== Crystalline Blocks =====>
            // =====
            registerBlock("ikarite_block",
                    new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                            .strength(3.0f, 3.0f)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("budding_ikarite",
                    new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool().ticksRandomly()
                            .strength(3.0f, 2.0f)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("ikarite_cluster",
                    new AmethystClusterBlock(7, 3, FabricBlockSettings.copyOf(ikariteSettings)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("large_ikarite_bud",
                    new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(ikariteSettings)
                            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4).requiresTool()),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("medium_ikarite_bud",
                    new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(ikariteSettings)
                            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2).requiresTool()),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("small_ikarite_bud",
                    new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(ikariteSettings)
                            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1).requiresTool()),
                    GemstyneItemGroup.GEMSTYNE),


            registerBlock("garnet_block",
                    new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                            .strength(1.5f, 1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("budding_garnet",
                    new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool().ticksRandomly()
                            .strength(1.5f, 1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("garnet_cluster",
                    new AmethystClusterBlock(7, 3, FabricBlockSettings.copyOf(garnetSettings)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("large_garnet_bud",
                    new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(garnetSettings)
                            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4).requiresTool()),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("medium_garnet_bud",
                    new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(garnetSettings)
                            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2).requiresTool()),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("small_garnet_bud",
                    new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(garnetSettings)
                            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1).requiresTool()),
                    GemstyneItemGroup.GEMSTYNE)
    );


    public static void registerOreBlocks() {Gemstyne.LOGGER.info("Registering Ores...");}
}
