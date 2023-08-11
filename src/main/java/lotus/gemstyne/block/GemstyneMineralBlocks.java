package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.carriers.GemstyneMineralBlockCarrier;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

import static lotus.gemstyne.block.GemstyneBlocks.registerBlock;

public final class GemstyneMineralBlocks {
    private static final FabricBlockSettings COMPRESSED_FEATURES = FabricBlockSettings.create()
            .requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)
            .instrument(Instrument.BASS);

    public static final GemstyneMineralBlockCarrier MINERAL_BLOCKS = new GemstyneMineralBlockCarrier(
            // =====
            // <===== Mineral Blocks =====>
            // =====
            registerBlock("compressed_andesite",
                    new Block(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.STONE_GRAY))),
            registerBlock("compressed_diorite",
                    new Block(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.LIGHT_GRAY))),
            registerBlock("compressed_granite",
                    new Block(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.BROWN))),

            registerBlock("compact_dirt",
                    new Block(FabricBlockSettings.copyOf(COMPRESSED_FEATURES).mapColor(MapColor.BROWN)
                            .strength(1.5f, 3.0f).sounds(BlockSoundGroup.ROOTED_DIRT))),

            registerBlock("gabbro",
                    new Block(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASS)
                            .requiresTool().strength(1.5f, 3.0f).sounds(BlockSoundGroup.TUFF))),
            registerBlock("halite",
                    new Block(FabricBlockSettings.create().mapColor(MapColor.PINK).instrument(Instrument.BELL)
                            .requiresTool().strength(0.75f, 1.5f).sounds(BlockSoundGroup.CALCITE))),
            registerBlock("pumice",
                    new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASS)
                            .requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.BASALT)))
    );


    public static void registerMineralBlocks() {Gemstyne.LOGGER.info("Registering Minerals...");}
}
