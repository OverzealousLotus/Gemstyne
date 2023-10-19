package lotus.gemstyne.item.spelunking;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneItemSet;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public final class GemstyneOreItems {
    private GemstyneOreItems() {}
    
    // =====
    // <===== Nutrients =====>
    // =====
    private static final FoodComponent MOCHITE_FOOD =
        new FoodComponent.Builder().hunger(1).saturationModifier(0.7f).snack().build();
    private static final FoodComponent IKARITE_FOOD =
        new FoodComponent.Builder().hunger(1).saturationModifier(1.0f).meat()
                .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 80), 100).build();

    // =====
    // <=====| Ore Sets |=====>
    // =====
    public static final GemstyneItemSet ALDUS = GemstyneItemSet.Builder.start("aldus").tab(2).createDefaultItemSet(false);
    public static final GemstyneItemSet BRONZE = GemstyneItemSet.Builder.start("bronze")
        .tab(2).createItemVariant("chain").createDefaultItemSet(true);
    public static final GemstyneItemSet CRIMONITE = GemstyneItemSet.Builder.start("crimonite")
        .tab(2).createItemVariant("chunk").createDefaultItemSet(false);
    public static final GemstyneItemSet MUTALIUM = GemstyneItemSet.Builder.start("mutalium").tab(2).createDefaultItemSet(false);
    public static final GemstyneItemSet Pyrite = GemstyneItemSet.Builder.start("pyrite").tab(2).createRaw().end();
    public static final GemstyneItemSet TORRIUM = GemstyneItemSet.Builder.start("torrium").createDefaultItemSet(false);
    public static final GemstyneItemSet TIN = GemstyneItemSet.Builder.start("tin").createDefaultItemSet(false);
    public static final GemstyneItemSet URANIUM = GemstyneItemSet.Builder.start("uranium")
        .createItemVariant("chunk").createDefaultItemSet(false);

    // =====
    // <=====| Singleton Ores |=====>
    // =====
    public static final GemstyneItemSet MOCHITE = GemstyneItemSet.Builder.start("mochite").tab(3).createRaw()
        .addFood(MOCHITE_FOOD).createCrystal().createItemVariant("nugget").end();

    public static final Item BUBBLEGEM = GemstyneRegistry.designateItem("bubblegem",
        new OwoItemSettings().tab(3).food(new FoodComponent.Builder().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80), 1.0f).build()));

    // ======
    // <===== Crystals =====>
    // ======
    public static final Item FIRE_OPAL = GemstyneRegistry.designateItem("fire_opal",
            new OwoItemSettings());
    public static final Item GARNET = GemstyneRegistry.designateItem("garnet",
            new OwoItemSettings());
    public static final Item IKARITE = GemstyneRegistry.designateItem("ikarite",
            new OwoItemSettings().food(IKARITE_FOOD));
    public static final Item MORKITE = GemstyneRegistry.designateItem("morkite",
            new OwoItemSettings());

    public static void registerOreItems() {
        Gemstyne.LOGGER.info("Registering Ore Items...");
    }
}