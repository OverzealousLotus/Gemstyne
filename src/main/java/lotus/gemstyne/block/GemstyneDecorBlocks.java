package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.carriers.GemstyneDecorBlockCarrier;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.util.GemstyneBlockTypes;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;

import static lotus.gemstyne.block.GemstyneBlockHandler.registerBlock;

public final class GemstyneDecorBlocks {
    public static final GemstyneDecorBlockCarrier DECOR_BLOCKS = new GemstyneDecorBlockCarrier(
            registerBlock("aldus_block",
                    new Block(FabricBlockSettings.create().mapColor(MapColor.BLACK).instrument(Instrument.IRON_XYLOPHONE)
                            .requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE))),
            registerBlock("crimonite_block",
                    new AfflictiveBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_CRIMSON).instrument(Instrument.CHIME)
                            .requiresTool().strength(7.0f, 6.0f).sounds(BlockSoundGroup.LODESTONE),
                            StatusEffects.WITHER, 60, 100, 120, GemstyneBlockTypes.PURE)),
            registerBlock("fire_opal_block",
                    new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.BELL)
                            .requiresTool().strength(7.0f, 3.0f).sounds(BlockSoundGroup.METAL))),
            registerBlock("mochite_block",
                    new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_PURPLE).instrument(Instrument.CHIME)
                            .requiresTool().strength(4.0f, 3.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK))),
            registerBlock("tin_block",
                    new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.IRON_XYLOPHONE)
                            .requiresTool().strength(4.0f, 3.0f).sounds(BlockSoundGroup.METAL))),
            registerBlock("uranium_block",
                    new AfflictiveBlock(FabricBlockSettings.create().mapColor(MapColor.EMERALD_GREEN).instrument(Instrument.BIT)
                            .requiresTool().strength(7.0f, 6.0f).sounds(BlockSoundGroup.METAL),
                            GemstyneEffects.IRRADIATE, 30, 60, 100, GemstyneBlockTypes.PURE))
    );


    public static void registerDecorBlocks() {
        Gemstyne.LOGGER.info("Registering Decoration Blocks...");
    }
}
