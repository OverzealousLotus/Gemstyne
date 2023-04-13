package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.custom.ImbuedFeatherItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static lotus.gemstyne.item.GemstyneOreItems.registerOreItems;

public class ModItems {
    /** Registered mod items. Block items are registered differently. Check block/ModBlocks
    * to configure things, check data */

    // =====
    // <===== Crafting Items =====>
    // =====
    public static final Item IMBUED_ROD = registerItem("imbued_rod",
            new Item(new FabricItemSettings()));

    // =====
    // <===== Armours =====>
    // =====
    public static final Item RENDFIRE_HELMET = registerItem("rendfire_helmet",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RENDFIRE_CHESTPLATE = registerItem("rendfire_chestplate",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RENDFIRE_LEGGINGS = registerItem("rendfire_leggings",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RENDFIRE_BOOTS = registerItem("rendfire_boots",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    // =====
    // <===== Tools =====>
    // =====
    public static final Item RENDFIRE_PICKAXE = registerItem("rendfire_pickaxe",
            new PickaxeItem(ModToolMaterials.RENDFIRE, 2, 2.0f,
                    new FabricItemSettings()));
    public static final Item RENDFIRE_AXE = registerItem("rendfire_axe",
            new AxeItem(ModToolMaterials.RENDFIRE, 6, 2.0f,
                    new FabricItemSettings()));
    public static final Item RENDFIRE_HOE = registerItem("rendfire_hoe",
            new HoeItem(ModToolMaterials.RENDFIRE, 0, 1.0f,
                    new FabricItemSettings()));
    public static final Item RENDFIRE_SWORD = registerItem("rendfire_sword",
            new SwordItem(ModToolMaterials.RENDFIRE, 4, 2.0f,
                    new FabricItemSettings()));
    public static final Item RENDFIRE_SHOVEL = registerItem("rendfire_shovel",
            new ShovelItem(ModToolMaterials.RENDFIRE, 2, 1.0f,
                    new FabricItemSettings()));

    // =====
    // <===== Paraphernalia =====>
    // =====
    public static final Item IMBUED_FEATHER = registerItem("imbued_feather",
            new ImbuedFeatherItem(new FabricItemSettings().maxCount(1).maxDamage(20)));


    protected static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name), item);
    }

    // Add items to group(s).
    public static void addItemsToItemGroup() {
        // ======
        // <===== Raw Ores =====>
        // ======
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.RAW_MOCHITE);

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.RAW_URANIUM);

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.IKARITE);

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.MORKITE);

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.RAW_CRIMONITE);

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.FIRE_OPAL);

        // =====
        // <===== Refined Ores =====>
        // =====
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.MOCHITE);

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.URANIUM_CHUNK);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.URANIUM_INGOT);

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.CRIMONITE_CHUNK);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.CRIMONITE_INGOT);

        // =====
        // <===== Armours =====>
        // =====
        addToItemGroup(ModItemGroup.GEMSTYNE, RENDFIRE_HELMET);
        addToItemGroup(ModItemGroup.GEMSTYNE, RENDFIRE_CHESTPLATE);
        addToItemGroup(ModItemGroup.GEMSTYNE, RENDFIRE_LEGGINGS);
        addToItemGroup(ModItemGroup.GEMSTYNE, RENDFIRE_BOOTS);

        // =====
        // <===== Tools =====>
        // =====
        addToItemGroup(ModItemGroup.GEMSTYNE, RENDFIRE_PICKAXE);
        addToItemGroup(ModItemGroup.GEMSTYNE, RENDFIRE_AXE);
        addToItemGroup(ModItemGroup.GEMSTYNE, RENDFIRE_SWORD);
        addToItemGroup(ModItemGroup.GEMSTYNE, RENDFIRE_HOE);
        addToItemGroup(ModItemGroup.GEMSTYNE, RENDFIRE_SHOVEL);

        // =====
        // <===== Paraphernalia =====>
        // =====
        addToItemGroup(ModItemGroup.GEMSTYNE, IMBUED_FEATHER);
        addToItemGroup(ModItemGroup.GEMSTYNE, IMBUED_ROD);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Gemstyne.LOGGER.info("Registering items for " + Gemstyne.MOD_ID + "!");
        registerOreItems();
        addItemsToItemGroup();
    }
}
