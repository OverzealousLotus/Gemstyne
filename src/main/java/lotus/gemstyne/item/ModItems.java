package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.custom.ImbuedFeatherItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    /** Registered mod items. Block items are registered differently. Check block/ModBlocks
    * to configure things, check data */

    // =====
    // <===== Nutrients =====>
    // =====
    public static final FoodComponent mochite_nutrients =
            new FoodComponent.Builder().hunger(1).saturationModifier(0.7f).snack().build();
    public static final FoodComponent ikarite_nutrients =
            new FoodComponent.Builder().hunger(1).saturationModifier(1.0f).meat()
                    .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 80), 100).build();

    // ======
    // <===== Raw Ores =====>
    // ======
    public static final Item RAW_MOCHITE = registerItem("raw_mochite",
            new Item(new FabricItemSettings()));

    public static final Item RAW_URANIUM = registerItem("raw_uranium",
            new Item(new FabricItemSettings()));

    public static final Item RAW_IKARITE = registerItem("raw_ikarite",
            new Item(new FabricItemSettings().food(ikarite_nutrients)));

    public static final Item MORKITE_SHARD = registerItem("morkite_shard",
            new Item(new FabricItemSettings()));

    // =====
    // <===== Refined Ores =====>
    // =====
    public static final Item MOCHITE = registerItem("mochite",
            new Item(new FabricItemSettings().food(mochite_nutrients)));

    public static final Item URANIUM_CHUNK = registerItem("uranium_chunk",
            new Item(new FabricItemSettings()));
    public static final Item URANIUM_INGOT = registerItem("uranium_ingot",
            new Item(new FabricItemSettings()));

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
        addToItemGroup(ModItemGroup.GEMSTYNE, IMBUED_FEATHER);
        addToItemGroup(ModItemGroup.GEMSTYNE, IMBUED_ROD);
        addToItemGroup(ModItemGroup.GEMSTYNE, MORKITE_SHARD);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Gemstyne.LOGGER.info("Registering ore for " + Gemstyne.MOD_ID);
        addItemsToItemGroup();
    }
}
