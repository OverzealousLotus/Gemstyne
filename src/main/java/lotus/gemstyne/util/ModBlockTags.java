package lotus.gemstyne.util;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    // ======
    // <===== Replaceables =====>
    // ======
    public static final TagKey<Block> COMPRESSED_GRANITE_ORE_REPLACEABLES =
            ModBlockTags.of("compressed_granite_ore_replaceables");
    public static final TagKey<Block> COMPRESSED_ANDESITE_ORE_REPLACEABLES =
            ModBlockTags.of("compressed_andesite_ore_replaceables");

    // ======
    // <===== Tool-Type Requirements =====>
    // ======
    public static final TagKey<Block> NEEDS_AXE =
            ModBlockTags.of("mineable/axe");
    public static final TagKey<Block> NEEDS_HOE =
            ModBlockTags.of("mineable/hoe");
    public static final TagKey<Block> NEEDS_PICKAXE =
            ModBlockTags.of("mineable/pickaxe");
    public static final TagKey<Block> NEEDS_SHOVEL =
            ModBlockTags.of("mineable/shovel");

    // ======
    // <===== Tool-Level Requirements =====>
    // ======
    public static final TagKey<Block> NEEDS_STONE_TOOL =
            ModBlockTags.of("needs_stone_tool");
    public static final TagKey<Block> NEEDS_IRON_TOOL =
            ModBlockTags.of("needs_iron_tool");
    public static final TagKey<Block> NEEDS_DIAMOND_TOOL =
            ModBlockTags.of("needs_diamond_tool");

    public static final TagKey<Block> NEEDS_TOOL_LEVEL_4 =
            ModBlockTags.of("fabric:needs_tool_level_4");


    private ModBlockTags() {

    }

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id));
    }
}
