package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.carriers.GemstyneGeodeBlockCarrier;
import lotus.gemstyne.block.carriers.GemstyneOreBlockCarrier;
import lotus.gemstyne.block.custom.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static lotus.gemstyne.block.GemstyneBlocks.registerBlock;

public final class GemstyneOreBlocks {
    private static final FabricBlockSettings CRYSTALLINE_FEATURES = FabricBlockSettings.create()
            .requiresTool().ticksRandomly().nonOpaque()
            .strength(1.5f, 1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)
            .luminance(state -> 5);
    private static final FabricBlockSettings COMPRESSED_FEATURES = FabricBlockSettings.create()
            .requiresTool().sounds(BlockSoundGroup.DEEPSLATE).instrument(Instrument.BASEDRUM);


    public static final GemstyneOreBlockCarrier ORE_BLOCKS = new GemstyneOreBlockCarrier(
            // =====
            // <===== Overworld Ores =====>
            // =====
            registerBlock("compressed_granite_fire_opal_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.BROWN)
                            .strength(4.5f, 3.0f), UniformIntProvider.create(10, 15))),

            registerBlock("mochite_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE)
                            .strength(3.0f, 3.0f), UniformIntProvider.create(2, 7))),
            registerBlock("deepslate_mochite_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                            .strength(4.5f, 3.0f), UniformIntProvider.create(2, 7))),

            registerBlock("deepslate_morkite_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                            .strength(4.5f, 3.0f), UniformIntProvider.create(3, 10))),

            registerBlock("tin_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE)
                            .strength(3.0f, 3.0f), UniformIntProvider.create(2, 5))),
            registerBlock("deepslate_tin_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                            .strength(4.5f, 3.0f), UniformIntProvider.create(2, 5))),

            registerBlock("deepslate_uranium_ore",
                    new AfflictiveOre(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                            .strength(6.0f, 5.0f), UniformIntProvider.create(5, 15))),

            // =====
            // <===== Nether Ores =====>
            // =====
            registerBlock("nether_aldus_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK)
                            .strength(4.0f, 3.0f).sounds(BlockSoundGroup.NETHER_ORE),
                            UniformIntProvider.create(2, 5))),

            registerBlock("nether_crimonite_ore",
                    new CrimoniteOre(FabricBlockSettings.copyOf(Blocks.NETHERRACK)
                            .strength(5.0f, 3.0f).sounds(BlockSoundGroup.NETHER_ORE),
                            UniformIntProvider.create(2, 5))),

            // =====
            // <===== Ore Extensions =====>
            // =====
            registerBlock("compressed_granite_coal_ore",
                    new ExperienceDroppingBlock(FabricBlockSettings.create().mapColor(MapColor.BROWN).instrument(Instrument.BASEDRUM)
                            .requiresTool().strength(4.5f, 3.0f)
                            .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(0, 2))),

            // =====
            // <===== Concentrated Ores =====>
            // =====
            registerBlock("raw_aldus_block",
                    new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)
                            .strength(6.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS))),

            registerBlock("raw_crimonite_block",
                    new CrimoniteBlock(FabricBlockSettings.copyOf(Blocks.LODESTONE)
                            .strength(8.0f, 8.0f))),

            registerBlock("raw_mochite_block",
                    new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                            .strength(4.0f, 3.0f))),

            registerBlock("morkite_block",
                    new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                            .strength(5.0f, 3.0f))),

            registerBlock("raw_tin_block",
                    new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)
                            .strength(4.0f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE))),

            registerBlock("raw_uranium_block",
                    new AfflictiveBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)
                            .strength(7.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)))
    );


    public static final GemstyneGeodeBlockCarrier GEODE_BLOCKS = new GemstyneGeodeBlockCarrier(
            // =====
            // <===== Crystalline Blocks =====>
            // =====
            registerBlock("ikarite_block",
                    new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                            .strength(3.0f, 3.0f))),
            registerBlock("budding_ikarite",
                    new BuddingCrystallineBlock(FabricBlockSettings.copyOf(Blocks.BUDDING_AMETHYST).ticksRandomly()
                            .strength(3.0f, 2.0f))),

            registerBlock("ikarite_cluster",
                    new CrystallineBlockBud(7, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES))),
            registerBlock("large_ikarite_bud",
                    new CrystallineBlockBud(5, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4))),
            registerBlock("medium_ikarite_bud",
                    new CrystallineBlockBud(4, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2))),
            registerBlock("small_ikarite_bud",
                    new CrystallineBlockBud(3, 4, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1))),


            registerBlock("garnet_block",
                    new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                            .strength(1.5f, 1.0f))),
            registerBlock("budding_garnet",
                    new Block(FabricBlockSettings.copyOf(Blocks.BUDDING_AMETHYST).ticksRandomly()
                            .strength(1.5f, 1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK))),

            registerBlock("garnet_cluster",
                    new AmethystClusterBlock(7, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES))),

            registerBlock("large_garnet_bud",
                    new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4))),
            registerBlock("medium_garnet_bud",
                    new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2))),
            registerBlock("small_garnet_bud",
                    new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1)))
    );


    public static void registerOreBlocks() {Gemstyne.LOGGER.info("Registering Ores...");}
}
