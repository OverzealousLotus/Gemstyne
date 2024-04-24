package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.*;
import lotus.gemstyne.block.util.BlockSet;
import lotus.gemstyne.block.util.GeodeSet;
import lotus.gemstyne.effect.EffectHandler;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.util.GemstyneMiningLevels;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public final class BlockHandler {
    private BlockHandler() {
    }

    // =====
    // <===== Features of Blocks =====>
    // =====
    /* Not to be confused with Placed/Configured Features, Features in this context refer to
    -their similar characteristics between each other. For example, most Compressed blocks should
    -sound like deepslate, or play Base Drum when used as an instrument.
     */
    private static final FabricBlockSettings COMPRESSED_FEATURES = FabricBlockSettings.create()
        .requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)
        .instrument(Instrument.BASS);

    // =====
    // <===== Overworld Ores =====>
    // =====

    public static final BlockSet AETHERIUM = BlockSet.Builder.start("aetherium")
        .setExperience(12, 20).setStrength(5.0f, 5.0f)
        .setLevel(GemstyneMiningLevels.NEEDS_DIAMOND_TOOL)
        .createOreType(GemstyneConstants.DEEPSLATE)
        .end();

    public static final BlockSet BUBBLEGEM = BlockSet.Builder.start("bubblegem")
        .setExperience(8, 20).setStrength(4.5f, 3.0f)
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL)
        .createOre()
        .createOreType(GemstyneConstants.DEEPSLATE)
        .createPureBlock()
        .end();

    public static final BlockSet ENDER_PEARL = BlockSet.Builder.start("ender_pearl")
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL).createOre()
        .createOreType(GemstyneConstants.DEEPSLATE)
        .createOreType(GemstyneConstants.NETHER)
        .createOreType(GemstyneConstants.END)
        .end();

    public static final BlockSet FIRE_OPAL = BlockSet.Builder.start("fire_opal")
        .setLevel(GemstyneMiningLevels.NEEDS_DIAMOND_TOOL).setExperience(10, 15)
        .setStrength(4.5f, 4.5f).createOre().createPureBlock().end();

    public static final BlockSet MOCHITE = BlockSet.Builder.start("mochite")
        .setExperience(2, 7)
        .createOre(Gemstyne.CONFIG.oreConfig.mochiteRichness(), ItemHandler.MOCHITE.crystal())
        .createOreType(GemstyneConstants.NETHER)
        .createOreType(GemstyneConstants.RICH_DEEPSLATE, Gemstyne.CONFIG.oreConfig.mochiteRichness(), ItemHandler.MOCHITE.crystal())
        .createDefaultBlockSet(3.0f);

    public static final BlockSet MUTALIUM = BlockSet.Builder.start("mutalium")
        .setExperience(10, 20)
        .setLevel(GemstyneMiningLevels.NEEDS_DIAMOND_TOOL)
        .createOre(new MutaliumOre(UniformIntProvider.create(8, 15), FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)))
        .createOreType(GemstyneConstants.DEEPSLATE, new MutaliumOre(UniformIntProvider.create(8, 15),
            FabricBlockSettings.copyOf(Blocks.DEEPSLATE)))
        .createOreType(GemstyneConstants.NETHER, new MutaliumOre(UniformIntProvider.create(8, 15),
            FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE)))
        .createOreType(GemstyneConstants.END, new MutaliumOre(UniformIntProvider.create(8, 15),
            FabricBlockSettings.copyOf(Blocks.END_STONE)))
        .end();

    public static final Block NEFARIUM_ORE = GemstyneRegistry.designateBlock("nefarium_ore",
        new RichOre(FabricBlockSettings.copyOf(Blocks.LODESTONE)).init(Gemstyne.CONFIG.oreConfig.mochiteRichness(),
            UniformIntProvider.create(2, 5), Items.DIAMOND)
    );

    public static final BlockSet TORRIUM = BlockSet.Builder.start("torrium")
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL)
        .createOre(new TorriumOre(UniformIntProvider.create(5, 10),
            FabricBlockSettings.copyOf(Blocks.LAPIS_ORE).luminance(5)))
        .createOreType(GemstyneConstants.DEEPSLATE, new TorriumOre(UniformIntProvider.create(5, 10),
            FabricBlockSettings.copyOf(Blocks.DEEPSLATE).luminance(5)))
        .createOreType(GemstyneConstants.NETHER, new TorriumOre(UniformIntProvider.create(5, 10),
            FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).luminance(5)))
        .end();

    public static final BlockSet TIN = BlockSet.Builder.start("tin")
        .setExperience(2, 5)
        .createDefaultBlockSet(3.0f);

    public static final BlockSet URANIUM = BlockSet.Builder.start("uranium")
        .setLevel(GemstyneMiningLevels.NEEDS_DIAMOND_TOOL).setExperience(5, 15)
        .setEffect(EffectHandler.WEAK_RADIATION).setStrength(6.0f, 5.0f)
        .createOreType(GemstyneConstants.DEEPSLATE, 60)
        .setLevel(GemstyneMiningLevels.NEEDS_NETHERITE_TOOL)
        .createRawBlock(60).createPureBlock(60)
        .end();

    public static final BlockSet MORKITE = BlockSet.Builder.start("morkite")
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL).setExperience(3, 10)
        .setStrength(4.5f, 3.0f).createOreType(GemstyneConstants.DEEPSLATE).createRawBlock()
        .end();

    // =====
    // <===== Nether Ores =====>
    // =====
    public static final BlockSet ALDUS = BlockSet.Builder.start("aldus")
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL).setExperience(2, 5)
        .createDefaultNetherBlockSet(4.0f);

    public static final BlockSet BLAZITE = BlockSet.Builder.start("blazite")
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL).setExperience(2, 8)
        .createOreType(GemstyneConstants.NETHER)
        .end();

    public static final BlockSet CRIMONITE = BlockSet.Builder.start("crimonite")
        .setExperience(2, 5).setEffect(StatusEffects.WITHER)
        .setLevel(GemstyneMiningLevels.NEEDS_DIAMOND_TOOL).setStrength(5.0f, 3.0f)
        .createOreType(GemstyneConstants.NETHER, 60)
        .createRawBlock(60).createPureBlock(60)
        .end();

    // =====
    // <===== Ore Extensions =====>
    // =====
    public static final Block COMPRESSED_GRANITE_COAL_ORE = GemstyneRegistry.designateBlock("compressed_granite_coal_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE)
            .mapColor(MapColor.BROWN).strength(4.5f, 3.0f))
    );

    // =====
    // <===== Crystalline Blocks =====>
    // =====
    public static final GeodeSet IKARITE = GeodeSet.Builder.start("ikarite")
        .level(GemstyneMiningLevels.NEEDS_DIAMOND_TOOL).createDefaultSet(false);
    public static final GeodeSet GARNET = GeodeSet.Builder.start("garnet").createDefaultSet(false);
    public static final GeodeSet LAPIS = GeodeSet.Builder.start("lapis").createDefaultSet(true);

    // Singletons
    public static final Block COMPRESSED_ANDESITE = GemstyneRegistry.designateBlock("compressed_andesite",
        new Block(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.STONE_GRAY))
    );
    public static final Block COMPRESSED_DIORITE = GemstyneRegistry.designateBlock("compressed_diorite",
        new Block(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.LIGHT_GRAY))
    );
    public static final Block COMPRESSED_GRANITE = GemstyneRegistry.designateBlock("compressed_granite",
        new Block(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.BROWN))
    );
    public static final Block COMPACT_DIRT = GemstyneRegistry.designateBlock("compact_dirt",
        new Block(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.BROWN)
            .strength(1.5f, 3.0f).sounds(BlockSoundGroup.ROOTED_DIRT))
    );
    public static final Block GABBRO = GemstyneRegistry.designateBlock("gabbro",
        new Block(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASS)
            .strength(1.5f, 3.0f).sounds(BlockSoundGroup.TUFF))
    );
    public static final Block HALITE = GemstyneRegistry.designateBlock("halite",
        new Block(FabricBlockSettings.create().mapColor(MapColor.PINK).instrument(Instrument.BELL)
            .strength(0.75f, 1.5f).sounds(BlockSoundGroup.CALCITE))
    );
    public static final Block PUMICE = GemstyneRegistry.designateBlock("pumice",
        new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASS)
            .strength(1.0f, 1.0f).sounds(BlockSoundGroup.BASALT))
    );

    public static final Block PYRITE = GemstyneRegistry.designateBlock("pyrite",
        new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_LAPIS_ORE)));

    public static final Block THERMO_TNT_BLOCK = GemstyneRegistry.designateBlock("thermo_tnt",
        new ThermoTntBlock(FabricBlockSettings.copyOf(Blocks.TNT)));

    public static void registerGemstyneBlocks() {
        Gemstyne.LOGGER.info("Registering blocks for " + Gemstyne.MOD_ID + "!");
        Gemstyne.LOGGER.info("Successfully registered blocks for " + Gemstyne.MOD_ID + "!");
    }
}