package lotus.gemstyne.item.spelunking;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneItemSet;
import lotus.gemstyne.util.GemstyneCreativeGroup;
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
            .createDefaultItemSet(true).createChain();
    public static final GemstyneItemSet CRIMONITE = new GemstyneItemSet("crimonite")
            .createDefaultItemSet(false).createLump();
    public static final GemstyneItemSet TIN = new GemstyneItemSet("tin").createDefaultItemSet(false);
    public static final GemstyneItemSet URANIUM = new GemstyneItemSet("uranium")
            .createDefaultItemSet(false).createLump();

    // =====
    // <=====| Singleton Ores |=====>
    // =====
    public static final Item RAW_MOCHITE = GemstyneRegistry.designateItem("raw_mochite",
            new OwoItemSettings());
    public static final Item MOCHITE = GemstyneRegistry.designateItem("mochite",
            new OwoItemSettings().group(GemstyneCreativeGroup.GEMSTYNE_GROUP).food(MOCHITE_FOOD));

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