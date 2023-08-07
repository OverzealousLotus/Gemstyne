package lotus.gemstyne.item.spelunking;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneItemHandler;
import lotus.gemstyne.item.carriers.GemstyneOreItemCarrier;
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

    public static final GemstyneOreItemCarrier ORE_ITEMS = new GemstyneOreItemCarrier(
            // ======
            // <===== Raw Ores =====>
            // ======
            GemstyneItemHandler.registerItem("raw_aldus", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("raw_crimonite", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("raw_mochite", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("raw_tin", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("raw_uranium", new Item(new FabricItemSettings())),

            // ======
            // <===== Refined Ores =====>
            // ======
            GemstyneItemHandler.registerItem("aldus_ingot", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("bronze_ingot", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("bronze_ring", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("bronze_nugget", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("crimonite_chunk", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("crimonite_ingot", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("mochite",
                    new Item(new FabricItemSettings().food(mochite_nutrients))),
            GemstyneItemHandler.registerItem("tin_ingot", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("uranium_chunk", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("uranium_ingot", new Item(new FabricItemSettings())),

            // ======
            // <===== Uncut Ores =====>
            // ======
            GemstyneItemHandler.registerItem("fire_opal", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("garnet", new Item(new FabricItemSettings())),
            GemstyneItemHandler.registerItem("ikarite",
                    new Item(new FabricItemSettings().food(ikarite_nutrients))),
            GemstyneItemHandler.registerItem("morkite", new Item(new FabricItemSettings()))
    );

    public static void registerOreItems() {
        Gemstyne.LOGGER.info("Registering Ore Items...");
    }
}