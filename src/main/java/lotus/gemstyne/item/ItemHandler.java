package lotus.gemstyne.item;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Overwatch;
import lotus.gemstyne.item.custom.ImbuedFeatherItem;
import lotus.gemstyne.item.custom.UraniumArrow;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * <h3>ItemHandler</h3>
 * <code>ItemHandler</code> is used to wrap all of Gemstyne's items together.
 */
public final class ItemHandler {
    private ItemHandler() {}

    public static final UraniumArrow URANIUM_ARROW = new UraniumArrow(new Item.Settings());
    // =====
    // <===== Item Features =====>
    // =====
    private static final FoodComponent MOCHITE_FOOD =
        new FoodComponent.Builder().nutrition(1).saturationModifier(0.7f).snack().build();
    private static final FoodComponent IKARITE_FOOD =
        new FoodComponent.Builder().nutrition(1).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 80), 100).build();

    /////
    ////////// Crafting //////////
    /////
    public static final Item IMBUED_ROD = GemstyneRegistry.designateItem("imbued_rod", new OwoItemSettings());

    // =====
    // <=====| Ore Sets |=====>
    // =====
    public static final ItemSet ALDUS = ItemSet.Builder.start("aldus").createDefaultItemSet(false);
    public static final ItemSet AETHERIUM = ItemSet.Builder.start("aetherium").createRaw().createCrystal().end();
    public static final ItemSet BRONZE = ItemSet.Builder.start("bronze")
        .createItemVariant("chain").createDefaultItemSet(true);
    public static final ItemSet CRIMONITE = ItemSet.Builder.start("crimonite")
        .createItemVariant("chunk").createDefaultItemSet(false);
    public static final ItemSet MUTALIUM = ItemSet.Builder.start("mutalium").createDefaultItemSet(false);
    public static final ItemSet Pyrite = ItemSet.Builder.start("pyrite").createRaw().end();
    public static final ItemSet TORRIUM = ItemSet.Builder.start("torrium").createDefaultItemSet(false);
    public static final ItemSet TIN = ItemSet.Builder.start("tin").createDefaultItemSet(false);
    public static final ItemSet URANIUM = ItemSet.Builder.start("uranium")
        .createItemVariant("chunk").createDefaultItemSet(false);

    // =====
    // <=====| Singleton Ores |=====>
    // =====
    public static final ItemSet MOCHITE = ItemSet.Builder.start("mochite").createRaw()
        .addFood(MOCHITE_FOOD).createCrystal().createItemVariant("nugget").end();

    public static final Item BUBBLEGEM = GemstyneRegistry.designateItem("bubblegem",
        (OwoItemSettings) new OwoItemSettings().food(new FoodComponent.Builder().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80), 1.0f).build()));

    // ======
    // <===== Crystals =====>
    // ======
    public static final Item FIRE_OPAL = GemstyneRegistry.designateItem("fire_opal", new OwoItemSettings());
    public static final Item GARNET = GemstyneRegistry.designateItem("garnet", new OwoItemSettings());
    public static final Item IKARITE = GemstyneRegistry.designateItem("ikarite", (OwoItemSettings) new OwoItemSettings().food(IKARITE_FOOD));
    public static final Item MORKITE = GemstyneRegistry.designateItem("morkite", new OwoItemSettings());

    /////
    ///// Paraphernalia /////
    /////
    public static final Item IMBUED_FEATHER = GemstyneRegistry.designateItem("imbued_feather",
        new ImbuedFeatherItem(new OwoItemSettings().maxCount(1).maxDamage(20)
            .group(GemstyneCreativeGroup.GEMSTYNE))
    );

    public static void registerGeneralItems() {
        Overwatch.info("Registering Items...");
        Registry.register(Registries.ITEM, GemstyneRegistry.id("uranium_arrow"), URANIUM_ARROW);
        Overwatch.info("Successfully registered Items!");
    }
}
