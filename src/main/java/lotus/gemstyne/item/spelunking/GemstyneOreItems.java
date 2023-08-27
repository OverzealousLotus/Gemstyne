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
    public static final GemstyneItemSet ALDUS = new GemstyneItemSet("aldus").createDefaultItemSet(false);
    public static final GemstyneItemSet BRONZE = new GemstyneItemSet("bronze")
            .createDefaultItemSet(true).createItemVariant("chain");
    public static final GemstyneItemSet CRIMONITE = new GemstyneItemSet("crimonite")
            .createDefaultItemSet(false).createItemVariant("chunk");
    public static final GemstyneItemSet TIN = new GemstyneItemSet("tin").createDefaultItemSet(false);
    public static final GemstyneItemSet URANIUM = new GemstyneItemSet("uranium")
            .createDefaultItemSet(false).createItemVariant("chunk");

    // =====
    // <=====| Singleton Ores |=====>
    // =====
    public static final GemstyneItemSet MOCHITE = new GemstyneItemSet("mochite")
            .createRaw()
            .addFood(MOCHITE_FOOD)
            .createCrystal();

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