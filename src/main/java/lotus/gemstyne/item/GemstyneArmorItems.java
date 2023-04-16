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
    public static final Item ALDUS_HELMET = registerItem("aldus_helmet",
            new ArmorItem(ModArmorMaterials.ALDUS, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ALDUS_CHESTPLATE = registerItem("aldus_chestplate",
            new ArmorItem(ModArmorMaterials.ALDUS, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ALDUS_LEGGINGS = registerItem("aldus_leggings",
            new ArmorItem(ModArmorMaterials.ALDUS, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ALDUS_BOOTS = registerItem("aldus_boots",
            new ArmorItem(ModArmorMaterials.ALDUS, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    // =====
    // <===== Rendfire =====>
    // =====
    public static final Item RENDFIRE_HELMET = registerItem("rendfire_helmet",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RENDFIRE_CHESTPLATE = registerItem("rendfire_chestplate",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RENDFIRE_LEGGINGS = registerItem("rendfire_leggings",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RENDFIRE_BOOTS = registerItem("rendfire_boots",
            new ArmorItem(ModArmorMaterials.RENDFIRE, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    protected static void registerArmorItems() {
        Gemstyne.LOGGER.info("Registering Armor Items...");
    }
}
