package lotus.gemstyne.data.models;

import lotus.gemstyne.item.GemstyneArmorItems;
import lotus.gemstyne.item.GemstyneToolItems;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class GemstyneEquipmentModels {


    public static void generateEquipmentItemModels(ItemModelGenerator itemModelGenerator) {
        // ======
        // <===== Armor =====>
        // ======
        itemModelGenerator.register(GemstyneArmorItems.getRendfireHelmet(), Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.getRendfireChestplate(), Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.getRendfireLeggings(), Models.GENERATED);
        itemModelGenerator.register(GemstyneArmorItems.getRendfireBoots(), Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.getAldusHelmet());
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.getAldusChestplate());
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.getAldusLeggings());
        itemModelGenerator.registerArmor((ArmorItem) GemstyneArmorItems.getAldusBoots());

        // ======
        // <===== Tools =====>
        // ======
        itemModelGenerator.register(GemstyneToolItems.getRendfireAxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.getRendfireHoe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.getRendfirePickaxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.getRendfireShovel(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.getRendfireSword(), Models.HANDHELD);

        itemModelGenerator.register(GemstyneToolItems.getAldusAxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.getAldusHoe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.getAldusPickaxe(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.getAldusShovel(), Models.HANDHELD);
        itemModelGenerator.register(GemstyneToolItems.getAldusSword(), Models.HANDHELD);
    }
}
