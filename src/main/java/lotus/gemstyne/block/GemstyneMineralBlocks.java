package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.carriers.GemstyneMineralBlockCarrier;
import lotus.gemstyne.item.GemstyneItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

import static lotus.gemstyne.block.GemstyneBlocks.registerBlock;

public final class GemstyneMineralBlocks {
    public static final GemstyneMineralBlockCarrier MINERAL_BLOCKS = new GemstyneMineralBlockCarrier(
            // =====
            // <===== Mineral Blocks =====>
            // =====
            registerBlock("compressed_andesite",
                    new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(3.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("compressed_diorite",
                    new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(3.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("compressed_granite",
                    new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(3.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("compact_dirt",
                    new Block(FabricBlockSettings.of(Material.SOIL).requiresTool()
                            .strength(1.5f, 3.0f).sounds(BlockSoundGroup.ROOTED_DIRT)),
                    GemstyneItemGroup.GEMSTYNE),

            registerBlock("gabbro",
                    new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(1.5f, 3.0f).sounds(BlockSoundGroup.TUFF)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("halite",
                    new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(0.75f, 1.5f).sounds(BlockSoundGroup.CALCITE)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("pumice",
                    new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                            .strength(1.0f, 1.0f).sounds(BlockSoundGroup.BASALT)),
                    GemstyneItemGroup.GEMSTYNE)
    );


    public static void registerMineralBlocks() {Gemstyne.LOGGER.info("Registering Minerals...");}
}
