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
        translationBuilder.add(GemstyneArmorItems.ALDUS.HELMET, "Aldus Helmet");
        translationBuilder.add(GemstyneArmorItems.ALDUS.CHESTPLATE, "Aldus Chestplate");
        translationBuilder.add(GemstyneArmorItems.ALDUS.LEGGINGS, "Aldus Leggings");
        translationBuilder.add(GemstyneArmorItems.ALDUS.BOOTS, "Aldus Boots");

        translationBuilder.add(GemstyneArmorItems.BRONZEMAIL.HELMET, "Bronzemail Helmet");
        translationBuilder.add(GemstyneArmorItems.BRONZEMAIL.CHESTPLATE, "Bronzemail Chestplate");
        translationBuilder.add(GemstyneArmorItems.BRONZEMAIL.LEGGINGS, "Bronzemail Leggings");
        translationBuilder.add(GemstyneArmorItems.BRONZEMAIL.BOOTS, "Bronzemail Boots");

        translationBuilder.add(GemstyneArmorItems.BRONZEPLATE.HELMET, "Bronzeplate Helmet");
        translationBuilder.add(GemstyneArmorItems.BRONZEPLATE.CHESTPLATE, "Bronzeplate Chestplate");
        translationBuilder.add(GemstyneArmorItems.BRONZEPLATE.LEGGINGS, "Bronzeplate Leggings");
        translationBuilder.add(GemstyneArmorItems.BRONZEPLATE.BOOTS, "Bronzeplate Boots");

        translationBuilder.add(GemstyneArmorItems.RENDFIRE.HELMET, "Rendfire Helmet");
        translationBuilder.add(GemstyneArmorItems.RENDFIRE.CHESTPLATE, "Rendfire Chestplate");
        translationBuilder.add(GemstyneArmorItems.RENDFIRE.LEGGINGS, "Rendfire Leggings");
        translationBuilder.add(GemstyneArmorItems.RENDFIRE.BOOTS, "Rendfire Boots");

        // ======
        // <===== Tools =====>
        // ======
        translationBuilder.add(GemstyneToolItems.ALDUS.AXE, "Aldus Axe");
        translationBuilder.add(GemstyneToolItems.ALDUS.HOE, "Aldus Hoe");
        translationBuilder.add(GemstyneToolItems.ALDUS.PICKAXE, "Aldus Pickaxe");
        translationBuilder.add(GemstyneToolItems.ALDUS.SHOVEL, "Aldus Shovel");
        translationBuilder.add(GemstyneToolItems.ALDUS.SWORD, "Aldus Sword");

        translationBuilder.add(GemstyneToolItems.BRONZE.AXE, "Bronze Axe");
        translationBuilder.add(GemstyneToolItems.BRONZE.HOE, "Bronze Hoe");
        translationBuilder.add(GemstyneToolItems.BRONZE.PICKAXE, "Bronze Pickaxe");
        translationBuilder.add(GemstyneToolItems.BRONZE.SHOVEL, "Bronze Shovel");
        translationBuilder.add(GemstyneToolItems.BRONZE.SWORD, "Bronze Sword");

        translationBuilder.add(GemstyneToolItems.RENDFIRE.AXE, "Rendfire Axe");
        translationBuilder.add(GemstyneToolItems.RENDFIRE.HOE, "Rendfire Hoe");
        translationBuilder.add(GemstyneToolItems.RENDFIRE.PICKAXE, "Rendfire Pickaxe");
        translationBuilder.add(GemstyneToolItems.RENDFIRE.SHOVEL, "Rendfire Shovel");
        translationBuilder.add(GemstyneToolItems.RENDFIRE.SWORD, "Rendfire Sword");
    }
}
