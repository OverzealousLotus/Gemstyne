package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

import static lotus.gemstyne.block.GemstyneBlocks.registerBlock;

public class GemstyneMineralBlocks {
    // =====
    // <===== Minerals =====>
    // =====
    public static final Block HALITE = registerBlock("halite",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(0.75f, 1.5f).sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.GEMSTYNE);

    public static final Block COMPACT_DIRT = registerBlock("compact_dirt",
            new Block(FabricBlockSettings.of(Material.SOIL).requiresTool()
                    .strength(1.5f, 3.0f).sounds(BlockSoundGroup.ROOTED_DIRT)),
            ModItemGroup.GEMSTYNE);

    public static final Block COMPRESSED_GRANITE = registerBlock("compressed_granite",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(3.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)),
            ModItemGroup.GEMSTYNE);

    public static final Block COMPRESSED_ANDESITE = registerBlock("compressed_andesite",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(3.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)),
            ModItemGroup.GEMSTYNE);

    public static final Block COMPRESSED_DIORITE = registerBlock("compressed_diorite",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(3.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)),
            ModItemGroup.GEMSTYNE);

    protected static void registerMineralBlocks() {Gemstyne.LOGGER.info("Registering Minerals...");}
}