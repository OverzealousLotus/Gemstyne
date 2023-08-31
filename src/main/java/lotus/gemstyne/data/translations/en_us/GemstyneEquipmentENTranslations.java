package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.tool.GemstyneToolItems;
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
        translationBuilder.add(GemstyneArmorItems.ALDUS.helmet, "Aldus Helmet");
        translationBuilder.add(GemstyneArmorItems.ALDUS.chestplate, "Aldus Chestplate");
        translationBuilder.add(GemstyneArmorItems.ALDUS.leggings, "Aldus Leggings");
        translationBuilder.add(GemstyneArmorItems.ALDUS.boots, "Aldus Boots");

        translationBuilder.add(GemstyneArmorItems.BRONZEMAIL.helmet, "Bronzemail Helmet");
        translationBuilder.add(GemstyneArmorItems.BRONZEMAIL.chestplate, "Bronzemail Chestplate");
        translationBuilder.add(GemstyneArmorItems.BRONZEMAIL.leggings, "Bronzemail Leggings");
        translationBuilder.add(GemstyneArmorItems.BRONZEMAIL.boots, "Bronzemail Boots");

        translationBuilder.add(GemstyneArmorItems.BRONZEPLATE.helmet, "Bronzeplate Helmet");
        translationBuilder.add(GemstyneArmorItems.BRONZEPLATE.chestplate, "Bronzeplate Chestplate");
        translationBuilder.add(GemstyneArmorItems.BRONZEPLATE.leggings, "Bronzeplate Leggings");
        translationBuilder.add(GemstyneArmorItems.BRONZEPLATE.boots, "Bronzeplate Boots");

        translationBuilder.add(GemstyneArmorItems.RENDFIRE.helmet, "Rendfire Helmet");
        translationBuilder.add(GemstyneArmorItems.RENDFIRE.chestplate, "Rendfire Chestplate");
        translationBuilder.add(GemstyneArmorItems.RENDFIRE.leggings, "Rendfire Leggings");
        translationBuilder.add(GemstyneArmorItems.RENDFIRE.boots, "Rendfire Boots");

        // ======
        // <===== Tools =====>
        // ======
        translationBuilder.add(GemstyneToolItems.ALDUS.axe, "Aldus Axe");
        translationBuilder.add(GemstyneToolItems.ALDUS.hoe, "Aldus Hoe");
        translationBuilder.add(GemstyneToolItems.ALDUS.pickaxe, "Aldus Pickaxe");
        translationBuilder.add(GemstyneToolItems.ALDUS.shovel, "Aldus Shovel");
        translationBuilder.add(GemstyneToolItems.ALDUS.sword, "Aldus Sword");

        translationBuilder.add(GemstyneToolItems.BRONZE.axe, "Bronze Axe");
        translationBuilder.add(GemstyneToolItems.BRONZE.hoe, "Bronze Hoe");
        translationBuilder.add(GemstyneToolItems.BRONZE.pickaxe, "Bronze Pickaxe");
        translationBuilder.add(GemstyneToolItems.BRONZE.shovel, "Bronze Shovel");
        translationBuilder.add(GemstyneToolItems.BRONZE.sword, "Bronze Sword");

        translationBuilder.add(GemstyneToolItems.RENDFIRE.axe, "Rendfire Axe");
        translationBuilder.add(GemstyneToolItems.RENDFIRE.hoe, "Rendfire Hoe");
        translationBuilder.add(GemstyneToolItems.RENDFIRE.pickaxe, "Rendfire Pickaxe");
        translationBuilder.add(GemstyneToolItems.RENDFIRE.shovel, "Rendfire Shovel");
        translationBuilder.add(GemstyneToolItems.RENDFIRE.sword, "Rendfire Sword");
    }
}
