package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public final class GemstyneMineralBlocks {
    private static final FabricBlockSettings COMPRESSED_FEATURES = FabricBlockSettings.create()
            .requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE)
            .instrument(Instrument.BASS);

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

    public static void registerMineralBlocks() {Gemstyne.LOGGER.info("Registering Minerals...");}
}
