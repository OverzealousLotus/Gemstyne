package lotus.gemstyne.util;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.util.BlockSet;
import lotus.gemstyne.damage.GemstyneDamageTypes;
import lotus.gemstyne.item.ItemSet;
import net.minecraft.block.Block;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

/**
 * <ul>Gemstyne's Registry Handler.
 *  <li>See {@link GemstyneCreativeGroup} for more information on how groups are handled.</li>
 *  <li>See {@link BlockSet} & {@link ItemSet} to see how these are used to register items.</li>
 * </ul>
 */
public class GemstyneRegistry {
    private GemstyneRegistry() {}

    /**
     * Creates an {@link Identifier} containing Gemstyne's Mod ID, and the ID of a block/item.
     * @param path Name of Identifier.
     * @return Returns an {@link Identifier}
     */
    public static Identifier id(String path) {
        return Identifier.of(Gemstyne.MOD_ID, path);
    }

    public static void registerItem(String path, Item item) {
        Registry.register(Registries.ITEM, id(path), item);
    }

    /**
     * Registers a {@link Block} and an associated {@link BlockItem}.
     * @param path Name of the {@link Block}
     * @param block The {@link Block} itself.
     */
    public static void registerBlock(String path, Block block) {
        Registry.register(Registries.BLOCK, id(path), block);
        Registry.register(Registries.ITEM, id(path), new BlockItem(block, new OwoItemSettings().group(GemstyneCreativeGroup.GEMSTYNE).tab(1)));
    }

    /**
     * Registers and assigns an {@link Item}.
     * @param path Name of the {@link Item}.
     * @param settings {@link OwoItemSettings}
     * @return Returns an {@link Item}.
     */
    public static Item designateItem(String path, OwoItemSettings settings) {
        return Registry.register(Registries.ITEM, id(path), new Item(settings.group(GemstyneCreativeGroup.GEMSTYNE)));
    }

    /**
     * Registers and assigns a custom {@link Item}.
     * @param path Name of the {@link Item}.
     * @param item The {@link Item} itself.
     * @return Returns an {@link Item}.
     */
    public static Item designateItem(String path, Item item) {
        return Registry.register(Registries.ITEM, id(path), item);
    }

    /**
     * Registers and assigns a {@link Block}.
     * @param path Name of the {@link Block}.
     * @param block The {@link Block} itself.
     * @return Returns a {@link Block}.
     */
    public static Block designateBlock(String path, Block block) {
        Registry.register(Registries.ITEM, id(path), new BlockItem(block, new OwoItemSettings().group(GemstyneCreativeGroup.GEMSTYNE).tab(1)));
        return Registry.register(Registries.BLOCK, id(path), block);
    }

    /**
     * Fetches {@link DamageSource} for you.
     */
    public static DamageSource getDamageSource(World world, RegistryKey<DamageType> type) {
        return new DamageSource(world.getRegistryManager()
            .get(RegistryKeys.DAMAGE_TYPE)
            .entryOf(type));
    }
}
