package lotus.gemstyne.item;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.item.custom.ImbuedFeatherItem;
import lotus.gemstyne.tool.GemstyneToolItems;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

/**
 * <h3>ItemHandler</h3>
 * <code>ItemHandler</code> is used to wrap all of Gemstyne's items together.
 */
public final class ItemHandler {
    private ItemHandler() {}

    // =====
    // <===== Item Features =====>
    // =====
    private static final FoodComponent MOCHITE_FOOD =
        new FoodComponent.Builder().hunger(1).saturationModifier(0.7f).snack().build();
    private static final FoodComponent IKARITE_FOOD =
        new FoodComponent.Builder().hunger(1).saturationModifier(1.0f).meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 80), 100).build();

    /////
    ////////// Crafting //////////
    /////
    public static final Item IMBUED_ROD = GemstyneRegistry.designateItem("imbued_rod", new OwoItemSettings());

    // =====
    // <=====| Ore Sets |=====>
    // =====
    public static final GemstyneItemSet ALDUS = GemstyneItemSet.Builder.start("aldus").createDefaultItemSet(false);
    public static final GemstyneItemSet BRONZE = GemstyneItemSet.Builder.start("bronze")
        .createItemVariant("chain").createDefaultItemSet(true);
    public static final GemstyneItemSet CRIMONITE = GemstyneItemSet.Builder.start("crimonite")
        .createItemVariant("chunk").createDefaultItemSet(false);
    public static final GemstyneItemSet MUTALIUM = GemstyneItemSet.Builder.start("mutalium").createDefaultItemSet(false);
    public static final GemstyneItemSet Pyrite = GemstyneItemSet.Builder.start("pyrite").createRaw().end();
    public static final GemstyneItemSet TORRIUM = GemstyneItemSet.Builder.start("torrium").createDefaultItemSet(false);
    public static final GemstyneItemSet TIN = GemstyneItemSet.Builder.start("tin").createDefaultItemSet(false);
    public static final GemstyneItemSet URANIUM = GemstyneItemSet.Builder.start("uranium")
        .createItemVariant("chunk").createDefaultItemSet(false);

    // =====
    // <=====| Singleton Ores |=====>
    // =====
    public static final GemstyneItemSet MOCHITE = GemstyneItemSet.Builder.start("mochite").createRaw()
        .addFood(MOCHITE_FOOD).createCrystal().createItemVariant("nugget").end();

    public static final Item BUBBLEGEM = GemstyneRegistry.designateItem("bubblegem",
        new OwoItemSettings().food(new FoodComponent.Builder().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80), 1.0f).build()));

    // ======
    // <===== Crystals =====>
    // ======
    public static final Item FIRE_OPAL = GemstyneRegistry.designateItem("fire_opal", new OwoItemSettings());
    public static final Item GARNET = GemstyneRegistry.designateItem("garnet", new OwoItemSettings());
    public static final Item IKARITE = GemstyneRegistry.designateItem("ikarite", new OwoItemSettings().food(IKARITE_FOOD));
    public static final Item MORKITE = GemstyneRegistry.designateItem("morkite", new OwoItemSettings());

    /////
    ///// Paraphernalia /////
    /////
    public static final Item IMBUED_FEATHER = GemstyneRegistry.designateItem("imbued_feather",
        new ImbuedFeatherItem(new OwoItemSettings().maxCount(1).maxDamage(20)
            .group(GemstyneCreativeGroup.GEMSTYNE))
    );

    public static void registerGemstyneItems() {
        Gemstyne.LOGGER.info("Registering Items for " + Gemstyne.MOD_ID + "!");
        GemstyneArmorItems.registerArmorItems();
        GemstyneToolItems.registerToolItems();
        Gemstyne.LOGGER.info("Successfully registered Items for " + Gemstyne.MOD_ID + "!");
    }
}
