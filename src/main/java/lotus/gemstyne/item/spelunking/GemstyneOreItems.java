package lotus.gemstyne.item.spelunking;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneItemHandler;
import lotus.gemstyne.item.GemstyneItemSet;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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
    public static final GemstyneItemSet ALDUS = new GemstyneItemSet("aldus").createDefaultItemSet();
    public static final GemstyneItemSet BRONZE = new GemstyneItemSet("bronze")
            .createDefaultItemSet().createChain();
    public static final GemstyneItemSet CRIMONITE = new GemstyneItemSet("crimonite")
            .createDefaultItemSet().createLump();
    public static final GemstyneItemSet TIN = new GemstyneItemSet("tin").createDefaultItemSet();
    public static final GemstyneItemSet URANIUM = new GemstyneItemSet("uranium")
            .createDefaultItemSet().createLump();

    // =====
    // <=====| Singleton Ores |=====>
    // =====
    public static final Item RAW_MOCHITE = GemstyneItemHandler.assignAndRegisterItem(
            new Item(new FabricItemSettings()), "raw_mochite");
    public static final Item MOCHITE = GemstyneRegistry.designate("mochite",
            new OwoItemSettings().group(GemstyneCreativeGroup.GEMSTYNE_GROUP).food(MOCHITE_FOOD));

    // ======
    // <===== Crystals =====>
    // ======
    public static final Item FIRE_OPAL = GemstyneItemHandler.assignAndRegisterItem(
            new Item(new FabricItemSettings()), "fire_opal");
    public static final Item GARNET = GemstyneItemHandler.assignAndRegisterItem(
            new Item(new FabricItemSettings()), "garnet");
    public static final Item IKARITE = GemstyneItemHandler.assignAndRegisterItem(
            new Item(new FabricItemSettings().food(IKARITE_FOOD)), "ikarite");
    public static final Item MORKITE = GemstyneItemHandler.assignAndRegisterItem(
            new Item(new FabricItemSettings()), "morkite");

    public static void registerOreItems() {
        Gemstyne.LOGGER.info("Registering Ore Items...");
    }
}