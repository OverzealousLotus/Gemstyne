package lotus.gemstyne.armor;

import io.wispforest.owo.registration.reflect.AutoRegistryContainer;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;

import java.util.List;
import java.util.Map;

public class GemstyneArmorMaterials implements AutoRegistryContainer<ArmorMaterial> {
    GemstyneArmorMaterials() {}

    public static final ArmorMaterial ALDUS = new ArmorMaterial(Map.of(
        ArmorItem.Type.HELMET, 3,
        ArmorItem.Type.CHESTPLATE, 7,
        ArmorItem.Type.LEGGINGS, 5,
        ArmorItem.Type.BOOTS, 3),12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ItemHandler.ALDUS.ingot()),
        List.of(layer("aldus")), 0.0f, 0.0f);

    public static final ArmorMaterial RENDFIRE = new ArmorMaterial(Map.of(
        ArmorItem.Type.HELMET, 4,
        ArmorItem.Type.CHESTPLATE, 10,
        ArmorItem.Type.LEGGINGS, 6,
        ArmorItem.Type.BOOTS, 4), 1,
        SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ItemHandler.FIRE_OPAL),
        List.of(layer("rendfire")), 3.0f, 0.2f);
    public static final ArmorMaterial BRONZEMAIL = new ArmorMaterial(Map.of(
        ArmorItem.Type.HELMET, 2,
        ArmorItem.Type.CHESTPLATE, 6,
        ArmorItem.Type.LEGGINGS, 4,
        ArmorItem.Type.BOOTS, 2), 6,
        SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, () -> Ingredient.ofItems(ItemHandler.BRONZE.chain()),
        List.of(layer("bronzemail")), 0.0f, 0.0f);
    public static final ArmorMaterial BRONZEPLATE = new ArmorMaterial(Map.of(
        ArmorItem.Type.HELMET, 3,
        ArmorItem.Type.CHESTPLATE, 7,
        ArmorItem.Type.LEGGINGS, 5,
        ArmorItem.Type.BOOTS, 2), 8,
        SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ItemHandler.BRONZE.ingot()),
        List.of(layer("aldus")), 0.0f, 0.0f);

    @Override
    public Registry<ArmorMaterial> getRegistry() {
        return Registries.ARMOR_MATERIAL;
    }

    @Override
    public Class<ArmorMaterial> getTargetFieldType() {
        return ArmorMaterial.class;
    }

    private static ArmorMaterial.Layer layer(String name) {
        return new ArmorMaterial.Layer(GemstyneRegistry.id(name));
    }

    public static void registerMats() {
        Registry.register(Registries.ARMOR_MATERIAL, "aldus_mat", ALDUS);
        Registry.register(Registries.ARMOR_MATERIAL, "bronzeplate_mat", BRONZEPLATE);
        Registry.register(Registries.ARMOR_MATERIAL, "bronzemail_mat", BRONZEMAIL);
        Registry.register(Registries.ARMOR_MATERIAL, "rendfire_mat", RENDFIRE);
    }
}
