package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
// import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // Registered mod items. Block items are registered differently. Check block/ModBlocks
    // To configure things, check data/*

    // ======
    // <===== Raw Ores =====>
    // ======
    public static final Item RAW_MOCHITE = registerItem("raw_mochite",
            new Item(new FabricItemSettings()));

    public static final Item RAW_URANIUM = registerItem("raw_uranium",
            new Item(new FabricItemSettings()));

    // =====
    // <===== Refined Ores =====>
    // =====
    public static final FoodComponent foodie = new FoodComponent.Builder().hunger(1).saturationModifier(0.7f).snack().build();
    public static final Item MOCHITE = registerItem("mochite",
            new Item(new FabricItemSettings().food(foodie)));

    public static final Item URANIUM_CHUNK = registerItem("uranium_chunk",
            new Item(new FabricItemSettings()));

    public static final Item URANIUM_INGOT = registerItem("uranium_ingot",
            new Item(new FabricItemSettings()));

    public static final Item RAW_IKARITE = registerItem("raw_ikarite",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name), item);
    }

    // Add items to group(s).
    public static void addItemsToItemGroup() {

        addToItemGroup(ModItemGroup.GEMSTYNE, MOCHITE);
        addToItemGroup(ModItemGroup.GEMSTYNE, RAW_MOCHITE);
        addToItemGroup(ModItemGroup.GEMSTYNE, RAW_URANIUM);
        addToItemGroup(ModItemGroup.GEMSTYNE, URANIUM_CHUNK);
        addToItemGroup(ModItemGroup.GEMSTYNE, URANIUM_INGOT);
        addToItemGroup(ModItemGroup.GEMSTYNE, RAW_IKARITE);
        // addToItemGroup(ModItemGroup.GEMSTYNE, IKARITE_CHUNK);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Gemstyne.LOGGER.info("Registering ore for " + Gemstyne.MOD_ID);
        addItemsToItemGroup();
    }
}
