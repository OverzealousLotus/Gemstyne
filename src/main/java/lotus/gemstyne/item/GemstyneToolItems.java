package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

import static lotus.gemstyne.item.ModItems.registerItem;

public class GemstyneToolItems {
    // =====
    // <===== Rendfire =====>
    // =====
    public static final Item RENDFIRE_AXE = registerItem("rendfire_axe",
            new AxeItem(ModToolMaterials.RENDFIRE, 5, -3.0f,
                    new FabricItemSettings()));
    public static final Item RENDFIRE_HOE = registerItem("rendfire_hoe",
            new HoeItem(ModToolMaterials.RENDFIRE, -4, 0.0f,
                    new FabricItemSettings()));
    public static final Item RENDFIRE_PICKAXE = registerItem("rendfire_pickaxe",
            new PickaxeItem(ModToolMaterials.RENDFIRE, 1, -2.8f,
                    new FabricItemSettings()));
    public static final Item RENDFIRE_SHOVEL = registerItem("rendfire_shovel",
            new ShovelItem(ModToolMaterials.RENDFIRE, 1.5f, -3.0f,
                    new FabricItemSettings()));
    public static final Item RENDFIRE_SWORD = registerItem("rendfire_sword",
            new SwordItem(ModToolMaterials.RENDFIRE, 4, -2.4f,
                    new FabricItemSettings()));

    public static final Item ALDUS_AXE = registerItem("aldus_axe",
            new AxeItem(ModToolMaterials.ALDUS, 6, -3.0f,
                    new FabricItemSettings()));
    public static final Item ALDUS_HOE = registerItem("aldus_hoe",
            new HoeItem(ModToolMaterials.ALDUS, -2, -0.5f,
                    new FabricItemSettings()));
    public static final Item ALDUS_PICKAXE = registerItem("aldus_pickaxe",
            new PickaxeItem(ModToolMaterials.ALDUS, 1, -2.7f,
                    new FabricItemSettings()));
    public static final Item ALDUS_SHOVEL = registerItem("aldus_shovel",
            new ShovelItem(ModToolMaterials.ALDUS, 1.5f, -3.0f,
                    new FabricItemSettings()));
    public static final Item ALDUS_SWORD = registerItem("aldus_sword",
            new SwordItem(ModToolMaterials.ALDUS, 4, -2.4f,
                    new FabricItemSettings()));
    // =====
    // <===== Rendfire =====>
    // =====


    protected static void registerToolItems() {
        Gemstyne.LOGGER.info("Registering Tool Items...");}
}
