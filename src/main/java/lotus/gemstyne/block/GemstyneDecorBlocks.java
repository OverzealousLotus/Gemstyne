package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.CrimoniteBlock;
import lotus.gemstyne.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

import static lotus.gemstyne.block.ModBlocks.registerBlock;

public class GemstyneDecorBlocks {
    public static final Block MOCHITE_BLOCK = registerBlock("mochite_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(4.0f, 3.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            ModItemGroup.GEMSTYNE);

    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new AfflictiveBlock(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(7.0f, 6.0f).sounds(BlockSoundGroup.METAL)),
            ModItemGroup.GEMSTYNE);

    public static final Block CRIMONITE_BLOCK = registerBlock("crimonite_block",
            new CrimoniteBlock(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(7.0f, 6.0f).sounds(BlockSoundGroup.LODESTONE)),
            ModItemGroup.GEMSTYNE);

    public static final Block ALDUS_BLOCK = registerBlock("aldus_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE)),
            ModItemGroup.GEMSTYNE);

    public static final Block FIRE_OPAL_BLOCK = registerBlock("fire_opal_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                    .strength(7.0f, 3.0f).sounds(BlockSoundGroup.METAL)),
            ModItemGroup.GEMSTYNE);

    protected static void registerDecorBlocks() {
        Gemstyne.LOGGER.info("Registering Decoration Blocks...");
    }
}
