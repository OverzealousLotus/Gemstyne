package lotus.gemstyne.block;

import com.google.common.collect.ImmutableList;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.*;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.util.GemstyneRegistry;
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
    public static final GemstyneBlockSet MOCHITE = new GemstyneBlockSet("mochite")
            .setExperience(UniformIntProvider.create(2, 7))
            .createDefaultBlockSet(3.0f);

    /*public static final Block NEFARIUM_ORE = GemstyneBlockHandler.assignAndRegisterBlock("nefarium_ore",
            new VolatileOre(FabricBlockSettings.copyOf(Blocks.LODESTONE), UniformIntProvider.create(5, 10))
    );*/

    public static final Block DEEPSLATE_TORRIUM = GemstyneRegistry.designateBlock("deepslate_torrium_ore",
            new TorriumOre(FabricBlockSettings.copyOf(Blocks.LODESTONE), UniformIntProvider.create(2, 5)));

    public static final Block NEFARIUM_ORE = GemstyneRegistry.designateBlock("nefarium_ore",
            new RichOre(FabricBlockSettings.copyOf(Blocks.LODESTONE), 5, UniformIntProvider.create(2, 5))
    );

    public static final GemstyneBlockSet TIN = new GemstyneBlockSet("tin")
            .setExperience(UniformIntProvider.create(2, 5))
            .createDefaultBlockSet(3.0f);

    public static final GemstyneBlockSet URANIUM = new GemstyneBlockSet("uranium")
            .setExperience(UniformIntProvider.create(5, 15)).setEffect(GemstyneEffects.IRRADIATE)
            .modifyStrength(6.0f, 5.0f)
            .createOreType("deepslate", 30, BlockSoundGroup.DEEPSLATE)
            .createRawBlock(30)
            .createPureBlock(30);

    public static final Block COMPRESSED_GRANITE_FIRE_OPAL_ORE = GemstyneRegistry.designateBlock(
            "compressed_granite_fire_opal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.BROWN)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(10, 15))
    );

    public static final Block DEEPSLATE_MORKITE_ORE = GemstyneRegistry.designateBlock("deepslate_morkite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(3, 10))
    );

    // =====
    // <===== Nether Ores =====>
    // =====
    public static final GemstyneBlockSet ALDUS = new GemstyneBlockSet("aldus")
            .setExperience(UniformIntProvider.create(2, 5))
            .createDefaultNetherBlockSet(4.0f);

    public static final GemstyneBlockSet CRIMONITE = new GemstyneBlockSet("crimonite")
            .setExperience(UniformIntProvider.create(2, 5)).setEffect(StatusEffects.WITHER)
            .modifyStrength(5.0f, 3.0f)
            .createOreType("nether", 60, BlockSoundGroup.NETHER_ORE)
            .createRawBlock(60)
            .createPureBlock(60);

    // =====
    // <===== Ore Extensions =====>
    // =====
    public static final Block COMPRESSED_GRANITE_COAL_ORE = GemstyneRegistry.designateBlock("compressed_granite_coal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE).mapColor(MapColor.BROWN)
                    .strength(4.5f, 3.0f), UniformIntProvider.create(0, 2))
    );

    // =====
    // <===== Concentrated Ores =====>
    // =====

    public static final Block MORKITE_BLOCK = GemstyneRegistry.designateBlock("morkite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(5.0f, 3.0f))
    );

    public static final Block FIRE_OPAL_BLOCK = GemstyneRegistry.designateBlock("fire_opal_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.BELL)
                    .requiresTool().strength(7.0f, 3.0f).sounds(BlockSoundGroup.METAL))
    );

    // =====
    // <===== Crystalline Blocks =====>
    // =====
    public static final Block IKARITE_CLUSTER = GemstyneRegistry.designateBlock("ikarite_cluster",
            new CrystallineBlockBud(7, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES))
    );
    public static final Block LARGE_IKARITE_BUD = GemstyneRegistry.designateBlock("large_ikarite_bud",
            new CrystallineBlockBud(5, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4))
    );
    public static final Block MEDIUM_IKARITE_BUD = GemstyneRegistry.designateBlock("medium_ikarite_bud",
            new CrystallineBlockBud(4, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2))
    );
    public static final Block SMALL_IKARITE_BUD = GemstyneRegistry.designateBlock("small_ikarite_bud",
            new CrystallineBlockBud(3, 4, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1))
    );

    public static final Block IKARITE_BLOCK = GemstyneRegistry.designateBlock("ikarite_block",
            new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(3.0f, 3.0f))
    );
    public static final Block BUDDING_IKARITE = GemstyneRegistry.designateBlock("budding_ikarite",
            new BuddingCrystallineBlock(FabricBlockSettings.copyOf(Blocks.BUDDING_AMETHYST)
                    .strength(3.0f, 2.0f), ImmutableList.of(
                            SMALL_IKARITE_BUD,
                            MEDIUM_IKARITE_BUD,
                            LARGE_IKARITE_BUD,
                            IKARITE_CLUSTER
            ))
    );

    public static final Block GARNET_CLUSTER = GemstyneRegistry.designateBlock("garnet_cluster",
            new CrystallineBlockBud(7, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES))
    );
    public static final Block LARGE_GARNET_BUD = GemstyneRegistry.designateBlock("large_garnet_bud",
            new CrystallineBlockBud(5, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 4))
    );
    public static final Block MEDIUM_GARNET_BUD = GemstyneRegistry.designateBlock("medium_garnet_bud",
            new CrystallineBlockBud(4, 3, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 2))
    );
    public static final Block SMALL_GARNET_BUD = GemstyneRegistry.designateBlock("small_garnet_bud",
            new CrystallineBlockBud(3, 4, FabricBlockSettings.copyOf(CRYSTALLINE_FEATURES)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1))
    );

    public static final Block GARNET_BLOCK = GemstyneRegistry.designateBlock("garnet_block",
            new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(1.5f, 1.0f))
    );
    public static final Block BUDDING_GARNET = GemstyneRegistry.designateBlock("budding_garnet",
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
