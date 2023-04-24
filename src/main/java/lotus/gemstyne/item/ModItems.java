package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.custom.ImbuedFeatherItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    /** Registered mod items. Block items are registered differently. Check block/GemstyneBlocks
    * to configure things, check data */

    // =====
    // <===== Crafting Items =====>
    // =====
    public static final Item IMBUED_ROD = registerItem("imbued_rod",
            new Item(new FabricItemSettings()));

    // =====
    // <===== Paraphernalia =====>
    // =====
    public static final Item IMBUED_FEATHER = registerItem("imbued_feather",
            new ImbuedFeatherItem(new FabricItemSettings().maxCount(1).maxDamage(20)));


    public static final Item LIQUID_MORKITE_BUCKET = registerItem("liquid_morkite_bucket",
            new BucketItem(GemstyneFluids.STILL_LIQUID_MORKITE,
                    new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    protected static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name), item);
    }

    // Add items to group(s).
    public static void addItemsToItemGroup() {
        // ======
        // <===== Raw Ores =====>
        // ======
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getRawMochite());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getRawUranium());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getIkarite());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getGarnet());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getMorkite());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getRawCrimonite());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getRawAldus());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getFireOpal());

        // =====
        // <===== Refined Ores =====>
        // =====
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getMochite());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getUraniumChunk());
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getUraniumIngot());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getCrimoniteChunk());
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getCrimoniteIngot());

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneOreItems.getAldusIngot());

        // =====
        // <===== Armours =====>
        // =====
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneArmorItems.RENDFIRE_HELMET);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneArmorItems.RENDFIRE_CHESTPLATE);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneArmorItems.RENDFIRE_LEGGINGS);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneArmorItems.RENDFIRE_BOOTS);

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneArmorItems.ALDUS_HELMET);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneArmorItems.ALDUS_CHESTPLATE);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneArmorItems.ALDUS_LEGGINGS);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneArmorItems.ALDUS_BOOTS);

        // =====
        // <===== Tools =====>
        // =====
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.RENDFIRE_PICKAXE);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.RENDFIRE_AXE);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.RENDFIRE_SWORD);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.RENDFIRE_HOE);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.RENDFIRE_SHOVEL);

        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.ALDUS_PICKAXE);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.ALDUS_AXE);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.ALDUS_SWORD);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.ALDUS_HOE);
        addToItemGroup(ModItemGroup.GEMSTYNE, GemstyneToolItems.ALDUS_SHOVEL);

        // =====
        // <===== Paraphernalia =====>
        // =====
        addToItemGroup(ModItemGroup.GEMSTYNE, IMBUED_FEATHER);
        addToItemGroup(ModItemGroup.GEMSTYNE, IMBUED_ROD);

        addToItemGroup(ModItemGroup.GEMSTYNE, LIQUID_MORKITE_BUCKET);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Gemstyne.LOGGER.info("Registering items for " + Gemstyne.MOD_ID + "!");
        GemstyneOreItems.registerOreItems();
        GemstyneArmorItems.registerArmorItems();
        GemstyneToolItems.registerToolItems();
        addItemsToItemGroup();
    }
}
