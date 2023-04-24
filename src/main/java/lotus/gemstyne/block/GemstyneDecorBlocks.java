package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.CrimoniteBlock;
import lotus.gemstyne.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

import static lotus.gemstyne.block.GemstyneBlocks.registerBlock;

public final class GemstyneDecorBlocks {
    private static final Block MOCHITE_BLOCK = registerBlock("mochite_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(4.0f, 3.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            ModItemGroup.GEMSTYNE);

    private static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(4.0f, 3.0f).sounds(BlockSoundGroup.METAL)),
            ModItemGroup.GEMSTYNE);

    private static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new AfflictiveBlock(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(7.0f, 6.0f).sounds(BlockSoundGroup.METAL)),
            ModItemGroup.GEMSTYNE);

    private static final Block CRIMONITE_BLOCK = registerBlock("crimonite_block",
            new CrimoniteBlock(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(7.0f, 6.0f).sounds(BlockSoundGroup.LODESTONE)),
            ModItemGroup.GEMSTYNE);

    private static final Block ALDUS_BLOCK = registerBlock("aldus_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE)),
            ModItemGroup.GEMSTYNE);

    private static final Block FIRE_OPAL_BLOCK = registerBlock("fire_opal_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).requiresTool()
                    .strength(7.0f, 3.0f).sounds(BlockSoundGroup.METAL)),
            ModItemGroup.GEMSTYNE);


    public static Block getMochiteBlock() {
        return MOCHITE_BLOCK;
    }

    public static Block getTinBlock() {
        return TIN_BLOCK;
    }

    public static Block getUraniumBlock() {
        return URANIUM_BLOCK;
    }

    public static Block getCrimoniteBlock() {
        return CRIMONITE_BLOCK;
    }

    public static Block getAldusBlock() {
        return ALDUS_BLOCK;
    }

    public static Block getFireOpalBlock() {
        return FIRE_OPAL_BLOCK;
    }


    protected static void registerDecorBlocks() {
        Gemstyne.LOGGER.info("Registering Decoration Blocks...");
    }
}
