package lotus.gemstyne.util;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.util.GemstyneBlockSet;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.GemstyneItemSet;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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
    private GemstyneRegistry() {}

    /**
     * Creates an {@link Identifier} containing Gemstyne's Mod ID, and the ID of a block/item.
     * @param path Name of Identifier.
     * @return Returns an {@link Identifier}
     */
    public static Identifier id(String path) {
        return new Identifier(Gemstyne.MOD_ID, path);
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
        Registry.register(Registries.ITEM, id(path), new BlockItem(block, new OwoItemSettings().group(GemstyneCreativeGroup.GEMSTYNE)));
        return Registry.register(Registries.BLOCK, id(path), block);
    }

    private static void registerFuels() {
        Gemstyne.LOGGER.info("Registering Fuel Items for " + Gemstyne.MOD_ID + "...");

        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(GemstyneOreItems.MORKITE, 2000);
        registry.add(GemstyneOreBlocks.MORKITE_BLOCK, 20000);
        registry.add(GemstyneFluids.LIQUID_MORKITE_BUCKET, 24000);
    }

    public static void registerGemstyneMisc() {
        registerFuels();
    }
}
