package lotus.gemstyne.item.spelunking;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneItemHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public final class GemstyneOreItems {
    // =====
    // <===== Nutrients =====>
    // =====
    private static final FoodComponent mochite_nutrients =
            new FoodComponent.Builder().hunger(1).saturationModifier(0.7f).snack().build();
    private static final FoodComponent ikarite_nutrients =
            new FoodComponent.Builder().hunger(1).saturationModifier(1.0f).meat()
                    .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 80), 100).build();

    // ======
    // <===== Raw Ores =====>
    // ======
    public static final Item RAW_ALDUS = GemstyneItemHandler.registerItem("raw_aldus",
            new Item(new FabricItemSettings()));
    public static final Item RAW_CRIMONITE = GemstyneItemHandler.registerItem("raw_crimonite",
            new Item(new FabricItemSettings()));
    public static final Item RAW_MOCHITE = GemstyneItemHandler.registerItem("raw_mochite",
            new Item(new FabricItemSettings()));
    public static final Item RAW_TIN = GemstyneItemHandler.registerItem("raw_tin",
            new Item(new FabricItemSettings()));
    public static final Item RAW_URANIUM = GemstyneItemHandler.registerItem("raw_uranium",
            new Item(new FabricItemSettings()));

    // ======
    // <===== Refined Ores =====>
    // ======
    public static final Item ALDUS_INGOT = GemstyneItemHandler.registerItem("aldus_ingot",
            new Item(new FabricItemSettings()));

    public static final Item BRONZE_INGOT = GemstyneItemHandler.registerItem("bronze_ingot",
            new Item(new FabricItemSettings()));
    public static final Item BRONZE_RING = GemstyneItemHandler.registerItem("bronze_ring",
            new Item(new FabricItemSettings()));
    public static final Item BRONZE_NUGGET = GemstyneItemHandler.registerItem("bronze_nugget",
            new Item(new FabricItemSettings()));

    public static final Item CRIMONITE_CHUNK = GemstyneItemHandler.registerItem("crimonite_chunk",
            new Item(new FabricItemSettings()));
    public static final Item CRIMONITE_INGOT = GemstyneItemHandler.registerItem("crimonite_ingot",
            new Item(new FabricItemSettings()));

    public static final Item MOCHITE = GemstyneItemHandler.registerItem("mochite",
            new Item(new FabricItemSettings().food(mochite_nutrients)));

    public static final Item TIN_INGOT = GemstyneItemHandler.registerItem("tin_ingot",
            new Item(new FabricItemSettings()));

    public static final Item URANIUM_CHUNK = GemstyneItemHandler.registerItem("uranium_chunk",
            new Item(new FabricItemSettings()));
    public static final Item URANIUM_INGOT = GemstyneItemHandler.registerItem("uranium_ingot",
            new Item(new FabricItemSettings()));

    public static final Item FIRE_OPAL = GemstyneItemHandler.registerItem("fire_opal",
            new Item(new FabricItemSettings()));
    public static final Item GARNET = GemstyneItemHandler.registerItem("garnet",
            new Item(new FabricItemSettings()));
    public static final Item IKARITE = GemstyneItemHandler.registerItem("ikarite",
            new Item(new FabricItemSettings().food(ikarite_nutrients)));
    public static final Item MORKITE = GemstyneItemHandler.registerItem("morkite",
            new Item(new FabricItemSettings()));

    public static void registerOreItems() {
        Gemstyne.LOGGER.info("Registering Ore Items...");
    }
}