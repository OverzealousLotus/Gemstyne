package lotus.gemstyne.world.dimension;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class GemstyneDimensions {
    private GemstyneDimensions() {}

    private static final Identifier HOXXES_V = GemstyneRegistry.id("hoxxes_v");
    public static final RegistryKey<DimensionOptions> HOXXES_V_KEY = RegistryKey.of(RegistryKeys.DIMENSION, HOXXES_V);
    public static final RegistryKey<World> HOXXES_V_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD, HOXXES_V);
    public static final RegistryKey<DimensionType> HOXXES_V_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, HOXXES_V);

    public static void bootstrap(Registerable<DimensionType> types) {
        types.register(HOXXES_V_TYPE, new DimensionType(
            OptionalLong.of(12000), // fixedTime
            false, // hasSkyLight
            false, // hasCeiling
            false, // ultraWarm
            true, // natural
            1.0, //coordinateScale (wth is this)
            false, // bedWorks
            true, // respawnAnchorWorks
            -112, // Minimum Y
            256, // height
            256, // logicalHeight
            BlockTags.INFINIBURN_OVERWORLD, // infiniteBurn
            DimensionTypes.OVERWORLD_ID, // effectsLocation
            1.0f, // ambientLight
            new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0) // Monster Spawn
        ));
    }
    public static void register() {
        Gemstyne.LOGGER.info("Registering Gemstyne Dimensions!");
    }
}
