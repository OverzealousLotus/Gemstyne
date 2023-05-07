package lotus.gemstyne.item.equipment;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.GemstyneItemHandler;
import lotus.gemstyne.item.GemstyneToolMaterials;
import lotus.gemstyne.item.carriers.GemstyneToolItemCarrier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

public final class GemstyneToolItems {
    public static final GemstyneToolItemCarrier TOOL_ITEMS = new GemstyneToolItemCarrier(
            // =====
            // <===== Aldus =====>
            // =====
            GemstyneItemHandler.registerItem("aldus_axe",
                    new AxeItem(GemstyneToolMaterials.ALDUS, 6, -3.0f,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("aldus_hoe",
                    new HoeItem(GemstyneToolMaterials.ALDUS, -2, -0.5f,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("aldus_pickaxe",
                    new PickaxeItem(GemstyneToolMaterials.ALDUS, 1, -2.7f,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("aldus_shovel",
                    new ShovelItem(GemstyneToolMaterials.ALDUS, 1.5f, -3.0f,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("aldus_sword",
                    new SwordItem(GemstyneToolMaterials.ALDUS, 4, -2.4f,
                            new FabricItemSettings())),

            // =====
            // <===== Rendfire =====>
            // =====
            GemstyneItemHandler.registerItem("rendfire_axe",
                    new AxeItem(GemstyneToolMaterials.RENDFIRE, 5, -3.0f,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("rendfire_hoe",
                    new HoeItem(GemstyneToolMaterials.RENDFIRE, -4, 0.0f,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("rendfire_pickaxe",
                    new PickaxeItem(GemstyneToolMaterials.RENDFIRE, 1, -2.8f,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("rendfire_shovel",
                    new ShovelItem(GemstyneToolMaterials.RENDFIRE, 1.5f, -3.0f,
                            new FabricItemSettings())),
            GemstyneItemHandler.registerItem("rendfire_sword",
                    new SwordItem(GemstyneToolMaterials.RENDFIRE, 4, -2.4f,
                            new FabricItemSettings()))
    );


    public static void registerToolItems() { Gemstyne.LOGGER.info("Registering Tool Items..."); }
}
