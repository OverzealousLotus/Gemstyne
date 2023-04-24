package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

import static lotus.gemstyne.item.ModItems.registerItem;

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

    private static final Item RAW_MOCHITE = registerItem("raw_mochite",
            new Item(new FabricItemSettings()));

    private static final Item RAW_TIN = registerItem("raw_tin",
            new Item(new FabricItemSettings()));

    private static final Item RAW_URANIUM = registerItem("raw_uranium",
            new Item(new FabricItemSettings()));

    private static final Item IKARITE = registerItem("ikarite",
            new Item(new FabricItemSettings().food(ikarite_nutrients)));

    private static final Item GARNET = registerItem("garnet",
            new Item(new FabricItemSettings()));

    private static final Item MORKITE = registerItem("morkite",
            new Item(new FabricItemSettings()));

    private static final Item RAW_CRIMONITE = registerItem("raw_crimonite",
            new Item(new FabricItemSettings()));

    private static final Item RAW_ALDUS = registerItem("raw_aldus",
            new Item(new FabricItemSettings()));

    private static final Item FIRE_OPAL = registerItem("fire_opal",
            new Item(new FabricItemSettings()));

    // =====
    // <===== Refined Ores =====>
    // =====
    private static final Item MOCHITE = registerItem("mochite",
            new Item(new FabricItemSettings().food(mochite_nutrients)));

    private static final Item TIN_INGOT = registerItem("tin_ingot",
            new Item(new FabricItemSettings()));

    private static final Item URANIUM_CHUNK = registerItem("uranium_chunk",
            new Item(new FabricItemSettings()));
    private static final Item URANIUM_INGOT = registerItem("uranium_ingot",
            new Item(new FabricItemSettings()));

    private static final Item CRIMONITE_CHUNK = registerItem("crimonite_chunk",
            new Item(new FabricItemSettings()));
    private static final Item CRIMONITE_INGOT = registerItem("crimonite_ingot",
            new Item(new FabricItemSettings()));

    private static final Item ALDUS_INGOT = registerItem("aldus_ingot",
            new Item(new FabricItemSettings()));


    public static Item getRawMochite() {
        return RAW_MOCHITE;
    }
    public static Item getMochite() {
        return MOCHITE;
    }

    public static Item getRawTin() {
        return RAW_TIN;
    }
    public static Item getTinIngot() {
        return TIN_INGOT;
    }

    public static Item getRawUranium() {
        return RAW_URANIUM;
    }
    public static Item getUraniumChunk() {
        return URANIUM_CHUNK;
    }
    public static Item getUraniumIngot() {
        return URANIUM_INGOT;
    }

    public static Item getRawCrimonite() {
        return RAW_CRIMONITE;
    }
    public static Item getCrimoniteChunk() {
        return CRIMONITE_CHUNK;
    }
    public static Item getCrimoniteIngot() {
        return CRIMONITE_INGOT;
    }

    public static Item getRawAldus() {
        return RAW_ALDUS;
    }
    public static Item getAldusIngot() {
        return ALDUS_INGOT;
    }

    public static Item getGarnet() {
        return GARNET;
    }
    public static Item getIkarite() {
        return IKARITE;
    }
    public static Item getFireOpal() {
        return FIRE_OPAL;
    }
    public static Item getMorkite() {
        return MORKITE;
    }

    protected static void registerOreItems() {
        Gemstyne.LOGGER.info("Registering Ore Items...");
    }
}
