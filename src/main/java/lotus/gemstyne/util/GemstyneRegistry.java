package lotus.gemstyne.util;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneBlockSet;
import lotus.gemstyne.item.GemstyneItemSet;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * <ul>Gemstyne's Registry Handler.
 *  <li>See {@link GemstyneCreativeGroup} for more information on how groups are handled.</li>
 *  <li>See {@link GemstyneBlockSet} & {@link GemstyneItemSet} to see how these are used to register items.</li>
 * </ul>
 */
public class GemstyneRegistry {
    /**
     * Simple Method to create a new {@link Identifier}.
     * @param path Name of Identifier.
     * @return Returns a new {@link Identifier}
     */
    public static Identifier id(String path) {
        return new Identifier(Gemstyne.MOD_ID, path);
    }

    public static void registerItem(String path, Item item) {
        Registry.register(Registries.ITEM, id(path), item);
    }

    /**
     * Method used to register and assign an {@link Item}.
     * @param path Name of item.
     * @param settings {@link OwoItemSettings}
     * @return Returns a new {@link Item}
     */
    public static Item designate(String path, OwoItemSettings settings) {
        return Registry.register(Registries.ITEM, id(path), new Item(settings));
    }

    public static void registerBlock(String path, Block block) {
        Registry.register(Registries.BLOCK, id(path), block);
        Registry.register(Registries.ITEM, id(path), new BlockItem(block, new OwoItemSettings().group(GemstyneCreativeGroup.GEMSTYNE_GROUP)));
    }
}
