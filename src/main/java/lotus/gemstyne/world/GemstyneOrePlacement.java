package lotus.gemstyne.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.placementmodifier.*;

public final class GemstyneOrePlacement {
    private GemstyneOrePlacement() {}

    // Methods to help with ore generation. Don't change.
    public static ImmutableList<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return ImmutableList.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static ImmutableList<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static ImmutableList<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
