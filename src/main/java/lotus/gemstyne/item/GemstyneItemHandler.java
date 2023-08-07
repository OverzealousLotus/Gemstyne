package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.equipment.GemstyneArmorItems;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import lotus.gemstyne.item.equipment.GemstyneToolItems;
import lotus.gemstyne.item.spelunking.GemstyneMineralItems;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public final class GemstyneItemHandler {
    /** Registered mod items. Block items are registered differently. Check block/GemstyneBlocks
    * to configure things, check data */

    // =====
    // <===== Paraphernalia =====>
    // =====
    public static final Item LIQUID_MORKITE_BUCKET = registerItem("liquid_morkite_bucket",
            new BucketItem(GemstyneFluids.STILL_LIQUID_MORKITE,
                    new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));


    // Add items to group(s).
    public static void addItemsToItemGroup() {
        // ======
        // <===== Raw Ores =====>
        // ======
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.rawAldus());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.rawCrimonite());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.rawMochite());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.rawTin());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.rawUranium());

        // =====
        // <===== Refined Ores =====>
        // =====
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.aldusIngot());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.crimoniteChunk());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.crimoniteIngot());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.mochite());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.tinIngot());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.bronzeIngot());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.bronzeRing());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.bronzeNugget());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.uraniumChunk());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.uraniumIngot());

        // ======
        // <===== Uncut Ores =====>
        // ======
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.fireOpal());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.garnet());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.ikarite());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneOreItems.ORE_ITEMS.morkite());

        // =====
        // <===== Armours =====>
        // =====
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.aldusHelmet());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.aldusChestplate());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.aldusLeggings());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.aldusBoots());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailHelmet());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailChestplate());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailLeggings());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailBoots());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateHelmet());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateChestplate());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateLeggings());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateBoots());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.rendfireHelmet());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.rendfireChestplate());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.rendfireLeggings());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneArmorItems.ARMOR_ITEMS.rendfireBoots());

        // =====
        // <===== Tools =====>
        // =====
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.aldusAxe());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.aldusHoe());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.aldusPickaxe());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.aldusShovel());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.aldusSword());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.bronzeAxe());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.bronzeHoe());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.bronzePickaxe());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.bronzeShovel());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.bronzeSword());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.rendfireAxe());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.rendfireHoe());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.rendfirePickaxe());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.rendfireShovel());
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneToolItems.TOOL_ITEMS.rendfireSword());

        // =====
        // <===== Paraphernalia =====>
        // =====
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneGearItems.IMBUED_FEATHER);
        addToItemGroup(GemstyneItemGroup.GEMSTYNE, GemstyneCraftingItems.getImbuedRod());

        addToItemGroup(GemstyneItemGroup.GEMSTYNE, LIQUID_MORKITE_BUCKET);
    }


    // =====
    // <===== Assistive Methods =====>
    // =====
    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name), item);
    }


    public static ArmorItem registerArmor(String name, ArmorItem item) {
        return Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name), item);
    }


    public static void registerModItems() {
        Gemstyne.LOGGER.info("Registering items for " + Gemstyne.MOD_ID + "!");
        GemstyneOreItems.registerOreItems();
        GemstyneMineralItems.registerMineralItems();
        GemstyneCraftingItems.registerCraftingItems();
        GemstyneArmorItems.registerArmorItems();
        GemstyneToolItems.registerToolItems();
        addItemsToItemGroup();
        Gemstyne.LOGGER.info("Registration of " + Gemstyne.MOD_ID + " complete!");
    }
}
