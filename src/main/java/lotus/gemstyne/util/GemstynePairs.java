package lotus.gemstyne.util;

import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

public final class GemstynePairs {
    private GemstynePairs() {}

    /**
     * Record to hold a {@link Block} linked to its BlockID.
     * If you don't know what a Java Record is, then think of it as a class, which defines methods automatically.
     * In this case, we only care about fetching a {@link Block} and its ID; Java Records define getter methods
     * for its fields. See <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Record.html">Java Documentation</a>
     */
    public record BlockPair(String blockID, Block block) {}
    public record ItemPair(String itemID, Item item) {}
    public record CrystallinePair(String blockID, AmethystBlock block) {}
    public record ToolPair(String toolID, ToolItem tool) {}
    public record GenKeyPair(RegistryKey<ConfiguredFeature<?, ?>> configKey, RegistryKey<PlacedFeature> placedKey) {}
}
