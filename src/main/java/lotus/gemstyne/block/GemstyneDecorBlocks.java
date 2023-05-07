package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.carriers.GemstyneDecorBlockCarrier;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.CrimoniteBlock;
import lotus.gemstyne.item.GemstyneItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

import static lotus.gemstyne.block.GemstyneBlocks.registerBlock;

public final class GemstyneDecorBlocks {
    public static final GemstyneDecorBlockCarrier DECOR_BLOCKS = new GemstyneDecorBlockCarrier(
            registerBlock("aldus_block",
                    new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                            .strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("crimonite_block",
                    new CrimoniteBlock(FabricBlockSettings.of(Material.METAL).requiresTool()
                            .strength(7.0f, 6.0f).sounds(BlockSoundGroup.LODESTONE)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("fire_opal_block",
                    new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                            .strength(7.0f, 3.0f).sounds(BlockSoundGroup.METAL)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("mochite_block",
                    new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                            .strength(4.0f, 3.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("tin_block",
                    new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                            .strength(4.0f, 3.0f).sounds(BlockSoundGroup.METAL)),
                    GemstyneItemGroup.GEMSTYNE),
            registerBlock("uranium_block",
                    new AfflictiveBlock(FabricBlockSettings.of(Material.METAL).requiresTool()
                            .strength(7.0f, 6.0f).sounds(BlockSoundGroup.METAL)),
                    GemstyneItemGroup.GEMSTYNE)
    );


    public static void registerDecorBlocks() {
        Gemstyne.LOGGER.info("Registering Decoration Blocks...");
    }
}
