package lotus.gemstyne.block;

import io.wispforest.owo.util.TagInjector;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.*;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
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
    public static final GemstyneBlockSet MOCHITE = GemstyneBlockSet.Builder.start("mochite")
        .setExperience(UniformIntProvider.create(2, 7))
        .createOreType(GemstyneConstants.NETHER, BlockSoundGroup.NETHER_ORE)
        .createDefaultBlockSet(3.0f);

    public static final GemstyneBlockSet MUTALIUM = GemstyneBlockSet.Builder.start("mutalium")
        .setExperience(UniformIntProvider.create(10, 20))
        .createOre()
        .createOreType(GemstyneConstants.DEEPSLATE, BlockSoundGroup.DEEPSLATE)
        .createOreType(GemstyneConstants.NETHER, BlockSoundGroup.NETHER_ORE)
        .createOreType("end", BlockSoundGroup.ANCIENT_DEBRIS)
        .end();

    /*public static final Block NEFARIUM_ORE = GemstyneBlockHandler.assignAndRegisterBlock("nefarium_ore",
            new VolatileOre(FabricBlockSettings.copyOf(Blocks.LODESTONE), UniformIntProvider.create(5, 10))
    );*/

    /*public static final Block NEFARIUM_ORE = GemstyneRegistry.designateBlock("nefarium_ore",
        new RichOre(FabricBlockSettings.copyOf(Blocks.LODESTONE), 5, UniformIntProvider.create(2, 5))
    );*/

    public static final Block NEFARIUM_ORE = GemstyneRegistry.designateBlock("nefarium_ore",
        new MutaliumOre(FabricBlockSettings.copyOf(Blocks.LODESTONE), UniformIntProvider.create(2, 5)));

    public static final Block BUBBLEGEM_ORE = GemstyneRegistry.designateBlock("bubblegem_ore",
        Ore.Builder.start(UniformIntProvider.create(8, 20)).settings(Blocks.EMERALD_ORE).end());

    public static final GemstyneBlockSet TORRIUM = GemstyneBlockSet.Builder.start("torrium")
        .createOre(new TorriumOre(FabricBlockSettings.copyOf(Blocks.LAPIS_ORE).luminance(5), UniformIntProvider.create(5, 10)))
        .createOreType(GemstyneConstants.DEEPSLATE, new TorriumOre(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).luminance(5),
            UniformIntProvider.create(5, 10)), BlockSoundGroup.DEEPSLATE)
        .createOreType(GemstyneConstants.NETHER, new TorriumOre(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).luminance(5),
            UniformIntProvider.create(5, 10)), BlockSoundGroup.NETHER_ORE)
        .end();

    public static final GemstyneBlockSet TIN = GemstyneBlockSet.Builder.start("tin")
        .setExperience(UniformIntProvider.create(2, 5))
        .createDefaultBlockSet(3.0f);

    public static final GemstyneBlockSet URANIUM = GemstyneBlockSet.Builder.start("uranium")
        .setExperience(UniformIntProvider.create(5, 15)).setEffect(GemstyneEffects.IRRADIATE)
        .setStrength(6.0f, 5.0f)
        .createOreType("deepslate", 30, BlockSoundGroup.DEEPSLATE)
        .createRawBlock(30)
        .createPureBlock(30)
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
        .setExperience(UniformIntProvider.create(2, 5))
        .createDefaultNetherBlockSet(4.0f);

    public static final GemstyneBlockSet CRIMONITE = GemstyneBlockSet.Builder.start("crimonite")
        .setExperience(UniformIntProvider.create(2, 5)).setEffect(StatusEffects.WITHER)
        .setStrength(5.0f, 3.0f)
        .createOreType(GemstyneConstants.NETHER, 60, BlockSoundGroup.NETHER_ORE)
        .createRawBlock(60)
        .createPureBlock(60)
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
    public static final GemstyneGeodeSet IKARITE = new GemstyneGeodeSet("ikarite")
        .createDefaultGeodeSet(false);
    public static final GemstyneGeodeSet GARNET = new GemstyneGeodeSet("garnet")
        .createDefaultGeodeSet(false);
    public static final GemstyneGeodeSet LAPIS = new GemstyneGeodeSet("lapis")
        .createDefaultGeodeSet(true);

    public static void registerOreBlocks() {Gemstyne.LOGGER.info("Registering Ores...");}
}
