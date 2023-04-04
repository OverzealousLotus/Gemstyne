package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.ModItemGroup;
import lotus.gemstyne.world.tree.RedMapleSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    // =====
    // <===== Ores =====>
    // =====
    public static final Block MOCHITE_ORE = registerBlock("mochite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE).strength(3.0f).requiresTool(),
                    UniformIntProvider.create(3, 10)),
                ModItemGroup.GEMSTYNE);
    public static final Block DEEPSLATE_MOCHITE_ORE = registerBlock("deepslate_mochite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.DEEPSLATE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 10)),
                ModItemGroup.GEMSTYNE);

    public static final Block DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.DEEPSLATE).strength(6.0f).requiresTool(),
                    UniformIntProvider.create(5, 15)),
                ModItemGroup.GEMSTYNE);

    // =====
    // <==== Compact Ores =====>
    // =====
    public static final Block RAW_MOCHITE_BLOCK = registerBlock("raw_mochite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(4.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block MOCHITE_BLOCK = registerBlock("mochite_block",
            new Block(FabricBlockSettings.of(Material.METAL)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(4.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);

    public static final Block RAW_URANIUM_BLOCK = registerBlock("raw_uranium_block",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.DEEPSLATE).strength(7.0f).requiresTool(),
                    UniformIntProvider.create(8, 18)),
                ModItemGroup.GEMSTYNE);
    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new Block(FabricBlockSettings.of(Material.METAL)
                    .sounds(BlockSoundGroup.METAL).strength(7.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);

    // =====
    // <===== Minerals =====>
    // =====
    public static final Block HALITE = registerBlock("halite",
            new Block(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.CALCITE).strength(0.75f).requiresTool()),
            ModItemGroup.GEMSTYNE);

    // =====
    // <==== Crystalline =====>
    // =====
    public static final Block IKARITE_BLOCK = registerBlock("ikarite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(3.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);

    public static final Block BUDDING_IKARITE = registerBlock("budding_ikarite",
            new Block(FabricBlockSettings.of(Material.AMETHYST)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(3.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);

    public static final Block IKARITE_CLUSTER = registerBlock("ikarite_cluster",
            new AmethystClusterBlock(7, 3, FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5f)
                    .luminance(state -> 5).requiresTool()),
            ModItemGroup.GEMSTYNE);

    // =====
    // <===== Trees =====>
    // =====
    public static final Block RED_MAPLE_LOG = registerBlock("red_maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block RED_MAPLE_WOOD = registerBlock("red_maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block STRIPPED_RED_MAPLE_LOG = registerBlock("stripped_red_maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block STRIPPED_RED_MAPLE_WOOD = registerBlock("stripped_red_maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);

    public static final Block RED_MAPLE_PLANKS = registerBlock("red_maple_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);
    public static final Block RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);

    public static final Block RED_MAPLE_SAPLING = registerBlock("red_maple_sapling",
            new SaplingBlock(new RedMapleSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(4.0f).requiresTool()),
            ModItemGroup.GEMSTYNE);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Gemstyne.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        Gemstyne.LOGGER.info("Registering blocks for... " + Gemstyne.MOD_ID);
    }
}
