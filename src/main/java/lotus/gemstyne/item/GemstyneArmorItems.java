package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import static lotus.gemstyne.item.ModItems.registerItem;

public class GemstyneArmorItems {
    // =====
    // <===== Aldus =====>
    // =====
    private static final Item ALDUS_HELMET = registerItem("aldus_helmet",
            new ArmorItem(ModArmorMaterials.ALDUS, ArmorItem.Type.HELMET, new FabricItemSettings()));
    private static final Item ALDUS_CHESTPLATE = registerItem("aldus_chestplate",
            new ArmorItem(ModArmorMaterials.ALDUS, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    private static final Item ALDUS_LEGGINGS = registerItem("aldus_leggings",
            new ArmorItem(ModArmorMaterials.ALDUS, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    private static final Item ALDUS_BOOTS = registerItem("aldus_boots",
            new ArmorItem(ModArmorMaterials.ALDUS, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    // =====
    // <===== Rendfire =====>
    // =====
    private static final Item RENDFIRE_HELMET = registerItem("rendfire_helmet",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    private static final Item RENDFIRE_CHESTPLATE = registerItem("rendfire_chestplate",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    private static final Item RENDFIRE_LEGGINGS = registerItem("rendfire_leggings",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    private static final Item RENDFIRE_BOOTS = registerItem("rendfire_boots",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    public static Item getAldusHelmet() {
        return ALDUS_HELMET;
    }
    public static Item getAldusChestplate() {
        return ALDUS_CHESTPLATE;
    }
    public static Item getAldusLeggings() {
        return ALDUS_LEGGINGS;
    }
    public static Item getAldusBoots() {
        return ALDUS_BOOTS;
    }

    public static Item getRendfireHelmet() {
        return RENDFIRE_HELMET;
    }
    public static Item getRendfireChestplate() {
        return RENDFIRE_CHESTPLATE;
    }
    public static Item getRendfireLeggings() {
        return RENDFIRE_LEGGINGS;
    }
    public static Item getRendfireBoots() {
        return RENDFIRE_BOOTS;
    }


    protected static void registerArmorItems() {
        Gemstyne.LOGGER.info("Registering Armor Items...");
    }
}
