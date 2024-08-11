package lotus.gemstyne.util;

import net.minecraft.util.Identifier;

public final class GemstyneMiningLevels {
    /**
     * Currently, only Rendfire holds this title.
     */
    public static final int RENDFIRE = 5;

    public static final Identifier NEEDS_STONE_TOOL = Identifier.of("minecraft:needs_stone_tool");
    public static final Identifier NEEDS_IRON_TOOL = Identifier.of("minecraft:needs_iron_tool");
    public static final Identifier NEEDS_DIAMOND_TOOL = Identifier.of("minecraft:needs_diamond_tool");
    public static final Identifier NEEDS_NETHERITE_TOOL = Identifier.of("fabric:needs_tool_level_4");
    public static final Identifier NEEDS_RENDFIRE_TOOL = Identifier.of("fabric:needs_tool_level_5");

    public static final Identifier NEEDS_PICKAXE = Identifier.of("mineable/pickaxe");


    private GemstyneMiningLevels() {

    }
}
