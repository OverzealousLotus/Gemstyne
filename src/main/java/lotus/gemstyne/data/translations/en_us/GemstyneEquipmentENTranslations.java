package lotus.gemstyne.data.translations.en_us;

import lotus.gemstyne.item.GemstyneArmorItems;
import lotus.gemstyne.item.GemstyneToolItems;
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
        translationBuilder.add(GemstyneArmorItems.ALDUS_HELMET, "Aldus Helmet");
        translationBuilder.add(GemstyneArmorItems.ALDUS_CHESTPLATE, "Aldus Chestplate");
        translationBuilder.add(GemstyneArmorItems.ALDUS_LEGGINGS, "Aldus Leggings");
        translationBuilder.add(GemstyneArmorItems.ALDUS_BOOTS, "Aldus Boots");

        translationBuilder.add(GemstyneArmorItems.RENDFIRE_HELMET, "Rendfire Helmet");
        translationBuilder.add(GemstyneArmorItems.RENDFIRE_CHESTPLATE, "Rendfire Chestplate");
        translationBuilder.add(GemstyneArmorItems.RENDFIRE_LEGGINGS, "Rendfire Leggings");
        translationBuilder.add(GemstyneArmorItems.RENDFIRE_BOOTS, "Rendfire Boots");

        // ======
        // <===== Tools =====>
        // ======
        translationBuilder.add(GemstyneToolItems.ALDUS_PICKAXE, "Aldus Pickaxe");
        translationBuilder.add(GemstyneToolItems.ALDUS_AXE, "Aldus Axe");
        translationBuilder.add(GemstyneToolItems.ALDUS_HOE, "Aldus Hoe");
        translationBuilder.add(GemstyneToolItems.ALDUS_SWORD, "Aldus Sword");
        translationBuilder.add(GemstyneToolItems.ALDUS_SHOVEL, "Aldus Shovel");

        translationBuilder.add(GemstyneToolItems.RENDFIRE_PICKAXE, "Rendfire Pickaxe");
        translationBuilder.add(GemstyneToolItems.RENDFIRE_AXE, "Rendfire Axe");
        translationBuilder.add(GemstyneToolItems.RENDFIRE_HOE, "Rendfire Hoe");
        translationBuilder.add(GemstyneToolItems.RENDFIRE_SWORD, "Rendfire Sword");
        translationBuilder.add(GemstyneToolItems.RENDFIRE_SHOVEL, "Rendfire Shovel");
    }
}
