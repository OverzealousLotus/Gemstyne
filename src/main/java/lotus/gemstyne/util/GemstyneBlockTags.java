package lotus.gemstyne.util;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class GemstyneBlockTags {
    private GemstyneBlockTags() {}

    // ======
    // <===== Replaceables =====>
    // ======
    private static final TagKey<Block> COMPRESSED_GRANITE_ORE_REPLACEABLES =
            GemstyneBlockTags.of("compressed_granite_ore_replaceables");
    private static final TagKey<Block> COMPRESSED_ANDESITE_ORE_REPLACEABLES =
            GemstyneBlockTags.of("compressed_andesite_ore_replaceables");

    // ======
    // <===== Raw Ore Veins =====>
    // ======
    private static final TagKey<Block> MOCHITE_ORE_REPLACEABLES =
            GemstyneBlockTags.of("mochite_ore_replaceables");
    private static final TagKey<Block> MORKITE_ORE_REPLACEABLES =
            GemstyneBlockTags.of("morkite_ore_replaceables");
    private static final TagKey<Block> URANIUM_ORE_REPLACEABLES =
            GemstyneBlockTags.of("uranium_ore_replaceables");
    private static final TagKey<Block> TIN_ORE_REPLACEABLES =
            GemstyneBlockTags.of("tin_ore_replaceables");
    // ======
    // <===== Tool-Type Requirements =====>
    // ======
    private static final TagKey<Block> NEEDS_AXE =
            GemstyneBlockTags.of("mineable/axe");
    private static final TagKey<Block> NEEDS_HOE =
            GemstyneBlockTags.of("mineable/hoe");
    private static final TagKey<Block> NEEDS_PICKAXE =
            GemstyneBlockTags.of("mineable/pickaxe");
    private static final TagKey<Block> NEEDS_SHOVEL =
            GemstyneBlockTags.of("mineable/shovel");

    // ======
    // <===== Tool-Level Requirements =====>
    // ======
    private static final TagKey<Block> NEEDS_STONE_TOOL =
            GemstyneBlockTags.of("needs_stone_tool");
    private static final TagKey<Block> NEEDS_IRON_TOOL =
            GemstyneBlockTags.of("needs_iron_tool");
    private static final TagKey<Block> NEEDS_DIAMOND_TOOL =
            GemstyneBlockTags.of("needs_diamond_tool");

    private static final TagKey<Block> NEEDS_TOOL_LEVEL_4 =
            GemstyneBlockTags.of("fabric:needs_tool_level_4");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id));
    }

    public static TagKey<Block> getCompressedGraniteOreReplaceables() {
        return COMPRESSED_GRANITE_ORE_REPLACEABLES;
    }

    public static TagKey<Block> getCompressedAndesiteOreReplaceables() {
        return COMPRESSED_ANDESITE_ORE_REPLACEABLES;
    }

    public static TagKey<Block> getMochiteOreReplaceables() {
        return MOCHITE_ORE_REPLACEABLES;
    }

    public static TagKey<Block> getMorkiteOreReplaceables() {
        return MORKITE_ORE_REPLACEABLES;
    }

    public static TagKey<Block> getUraniumOreReplaceables() {
        return URANIUM_ORE_REPLACEABLES;
    }

    public static TagKey<Block> getTinOreReplaceables() {
        return TIN_ORE_REPLACEABLES;
    }

    public static TagKey<Block> getNeedsAxe() {
        return NEEDS_AXE;
    }

    public static TagKey<Block> getNeedsHoe() {
        return NEEDS_HOE;
    }

    public static TagKey<Block> getNeedsPickaxe() {
        return NEEDS_PICKAXE;
    }

    public static TagKey<Block> getNeedsShovel() {
        return NEEDS_SHOVEL;
    }

    public static TagKey<Block> getNeedsStoneTool() {
        return NEEDS_STONE_TOOL;
    }

    public static TagKey<Block> getNeedsIronTool() {
        return NEEDS_IRON_TOOL;
    }

    public static TagKey<Block> getNeedsDiamondTool() {
        return NEEDS_DIAMOND_TOOL;
    }

    public static TagKey<Block> getNeedsToolLevel4() {
        return NEEDS_TOOL_LEVEL_4;
    }
}
