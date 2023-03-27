package lotus.tutorialmod.item;

import lotus.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
// import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MOCHITE = registerItem("mochite",
            new Item(new FabricItemSettings()));

    public static final Item RAW_MOCHITE = registerItem("raw_mochite",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        /*addToItemGroup(ItemGroups.INGREDIENTS, MOCHITE);
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_MOCHITE);*/

        addToItemGroup(ModItemGroup.GEMSTYNE, MOCHITE);
        addToItemGroup(ModItemGroup.GEMSTYNE, RAW_MOCHITE);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering ore for " + TutorialMod.MOD_ID);
        addItemsToItemGroup();
    }
}
