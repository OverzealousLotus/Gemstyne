package lotus.gemstyne.util;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> COMPRESSED_GRANITE_ORE_REPLACEABLES =
            ModBlockTags.of("compressed_granite_ore_replaceables");
    public static final TagKey<Block> COMPRESSED_ANDESITE_ORE_REPLACEABLES =
            ModBlockTags.of("compressed_andesite_ore_replaceables");


    private ModBlockTags() {

    }

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id));
    }
}
