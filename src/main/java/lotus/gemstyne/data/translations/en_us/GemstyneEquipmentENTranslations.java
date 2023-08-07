package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.item.equipment.GemstyneArmorItems;
import lotus.gemstyne.item.equipment.GemstyneToolItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

abstract class GemstyneEquipmentENTranslations extends FabricLanguageProvider {
    protected GemstyneEquipmentENTranslations(FabricDataOutput dataOutput) {
        super(dataOutput);
    }


    protected static void generateEnglishEquipmentTranslations(TranslationBuilder translationBuilder) {
        // ======
        // <===== Armor =====>
        // ======
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.aldusHelmet(), "Aldus Helmet");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.aldusChestplate(), "Aldus Chestplate");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.aldusLeggings(), "Aldus Leggings");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.aldusBoots(), "Aldus Boots");

        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailHelmet(), "Bronzemail Helmet");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailChestplate(), "Bronzemail Chestplate");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailLeggings(), "Bronzemail Leggings");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailBoots(), "Bronzemail Boots");

        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateHelmet(), "Bronzeplate Helmet");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateChestplate(), "Bronzeplate Chestplate");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateLeggings(), "Bronzeplate Leggings");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateBoots(), "Bronzeplate Boots");

        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.rendfireHelmet(), "Rendfire Helmet");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.rendfireChestplate(), "Rendfire Chestplate");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.rendfireLeggings(), "Rendfire Leggings");
        translationBuilder.add(GemstyneArmorItems.ARMOR_ITEMS.rendfireBoots(), "Rendfire Boots");

        // ======
        // <===== Tools =====>
        // ======
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.aldusAxe(), "Aldus Axe");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.aldusHoe(), "Aldus Hoe");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.aldusPickaxe(), "Aldus Pickaxe");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.aldusShovel(), "Aldus Shovel");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.aldusSword(), "Aldus Sword");

        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.bronzeAxe(), "Bronze Axe");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.bronzeHoe(), "Bronze Hoe");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.bronzePickaxe(), "Bronze Pickaxe");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.bronzeShovel(), "Bronze Shovel");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.bronzeSword(), "Bronze Sword");

        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.rendfireAxe(), "Rendfire Axe");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.rendfireHoe(), "Rendfire Hoe");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.rendfirePickaxe(), "Rendfire Pickaxe");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.rendfireShovel(), "Rendfire Shovel");
        translationBuilder.add(GemstyneToolItems.TOOL_ITEMS.rendfireSword(), "Rendfire Sword");
    }
}
