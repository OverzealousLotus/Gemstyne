package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

import static lotus.gemstyne.item.ModItems.registerItem;

public class GemstyneOreItems {
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

    public static final Item IKARITE = registerItem("ikarite",
            new Item(new FabricItemSettings().food(ikarite_nutrients)));

    public static final Item MORKITE = registerItem("morkite",
            new Item(new FabricItemSettings()));

    public static final Item RAW_CRIMONITE = registerItem("raw_crimonite",
            new Item(new FabricItemSettings()));

    public static final Item FIRE_OPAL = registerItem("fire_opal",
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

    public static final Item CRIMONITE_CHUNK = registerItem("crimonite_chunk",
            new Item(new FabricItemSettings()));
    public static final Item CRIMONITE_INGOT = registerItem("crimonite_ingot",
            new Item(new FabricItemSettings()));

    protected static void registerOreItems() {
        Gemstyne.LOGGER.info("Registering Ore Items...");
    }
}
