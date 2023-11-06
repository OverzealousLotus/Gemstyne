package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.*;
import lotus.gemstyne.block.util.GemstyneBlockSet;
import lotus.gemstyne.block.util.GemstyneGeodeSet;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.util.GemstyneMiningLevels;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public final class GemstyneOreBlocks {
    private GemstyneOreBlocks() {
    }

    // =====
    // <===== Features of Blocks =====>
    // =====
    /* Not to be confused with Placed/Configured Features, Features in this context refer to
    -their similar characteristics between each other. For example, most Compressed blocks should
    -sound like deepslate, or play Base Drum when used as an instrument.
     */
    private static final FabricBlockSettings COMPRESSED_FEATURES = FabricBlockSettings.create()
        .requiresTool().sounds(BlockSoundGroup.DEEPSLATE).instrument(Instrument.BASEDRUM);

    // =====
    // <===== Overworld Ores =====>
    // =====
    public static final GemstyneBlockSet BUBBLEGEM = GemstyneBlockSet.Builder.start("bubblegem")
        .setExperience(UniformIntProvider.create(8, 20)).setStrength(4.5f, 3.0f)
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL)
        .createOre()
        .createOreType(GemstyneConstants.DEEPSLATE)
        .createPureBlock()
        .end();

    public static final GemstyneBlockSet ENDER_PEARL = GemstyneBlockSet.Builder.start("ender_pearl")
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL).createOre()
        .createOreType(GemstyneConstants.DEEPSLATE)
        .createOreType(GemstyneConstants.NETHER)
        .createOreType(GemstyneConstants.END)
        .end();

    public static final GemstyneBlockSet MOCHITE = GemstyneBlockSet.Builder.start("mochite")
        .setExperience(UniformIntProvider.create(2, 7))
        .createOreType(GemstyneConstants.NETHER)
        .createDefaultBlockSet(3.0f);

    public static final GemstyneBlockSet MUTALIUM = GemstyneBlockSet.Builder.start("mutalium")
        .setExperience(UniformIntProvider.create(10, 20))
        .setLevel(GemstyneMiningLevels.NEEDS_DIAMOND_TOOL)
        .createOre(new MutaliumOre(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE),
            UniformIntProvider.create(8, 15)))
        .createOreType(GemstyneConstants.DEEPSLATE, new MutaliumOre(FabricBlockSettings.copyOf(Blocks.DEEPSLATE),
            UniformIntProvider.create(8, 15)))
        .createOreType(GemstyneConstants.NETHER, new MutaliumOre(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE),
            UniformIntProvider.create(8, 15)))
        .createOreType(GemstyneConstants.END, new MutaliumOre(FabricBlockSettings.copyOf(Blocks.END_STONE),
            UniformIntProvider.create(8, 15)))
        .end();

    public static final Block NEFARIUM_ORE = GemstyneRegistry.designateBlock("nefarium_ore",
        new RichOre(FabricBlockSettings.copyOf(Blocks.LODESTONE), Gemstyne.CONFIG.mochiteRichness(), UniformIntProvider.create(2, 5))
    );

    /*public static final Block NEFARIUM_ORE = GemstyneRegistry.designateBlock("nefarium_ore",
        new MutaliumOre(FabricBlockSettings.copyOf(Blocks.LODESTONE), UniformIntProvider.create(2, 5)));*/

    public static final GemstyneBlockSet TORRIUM = GemstyneBlockSet.Builder.start("torrium")
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL)
        .createOre(new TorriumOre(FabricBlockSettings.copyOf(Blocks.LAPIS_ORE).luminance(5),
            UniformIntProvider.create(5, 10)))
        .createOreType(GemstyneConstants.DEEPSLATE, new TorriumOre(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).luminance(5),
            UniformIntProvider.create(5, 10)))
        .createOreType(GemstyneConstants.NETHER, new TorriumOre(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).luminance(5),
            UniformIntProvider.create(5, 10)))
        .end();

    public static final GemstyneBlockSet TIN = GemstyneBlockSet.Builder.start("tin")
        .setExperience(UniformIntProvider.create(2, 5))
        .createDefaultBlockSet(3.0f);

    public static final GemstyneBlockSet URANIUM = GemstyneBlockSet.Builder.start("uranium")
        .setLevel(GemstyneMiningLevels.NEEDS_DIAMOND_TOOL).setExperience(UniformIntProvider.create(5, 15))
        .setEffect(GemstyneEffects.WEAK_RADIATION).setStrength(6.0f, 5.0f)
        .createOreType(GemstyneConstants.DEEPSLATE, 60)
        .setLevel(GemstyneMiningLevels.NEEDS_NETHERITE_TOOL)
        .createRawBlock(60).createPureBlock(60)
        .end();

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
    public static final GemstyneBlockSet ALDUS = GemstyneBlockSet.Builder.start("aldus")
        .setLevel(GemstyneMiningLevels.NEEDS_IRON_TOOL).setExperience(UniformIntProvider.create(2, 5))
        .createDefaultNetherBlockSet(4.0f);

    // Diamond
    public static final GemstyneBlockSet CRIMONITE = GemstyneBlockSet.Builder.start("crimonite")
        .setExperience(UniformIntProvider.create(2, 5)).setEffect(StatusEffects.WITHER)
        .setLevel(GemstyneMiningLevels.NEEDS_DIAMOND_TOOL).setStrength(5.0f, 3.0f)
        .createOreType(GemstyneConstants.NETHER, 60)
        .createRawBlock(60).createPureBlock(60)
        .end();

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
    public static final GemstyneGeodeSet IKARITE = GemstyneGeodeSet.Builder.start("ikarite").createDefaultSet(false);
    public static final GemstyneGeodeSet GARNET = GemstyneGeodeSet.Builder.start("garnet").createDefaultSet(false);
    public static final GemstyneGeodeSet LAPIS = GemstyneGeodeSet.Builder.start("lapis").createDefaultSet(true);

    public static void registerOreBlocks() {Gemstyne.LOGGER.info("Registering Ores...");}
}
