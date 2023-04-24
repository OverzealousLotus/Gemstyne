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
        translationBuilder.add(GemstyneArmorItems.getAldusHelmet(), "Aldus Helmet");
        translationBuilder.add(GemstyneArmorItems.getAldusChestplate(), "Aldus Chestplate");
        translationBuilder.add(GemstyneArmorItems.getAldusLeggings(), "Aldus Leggings");
        translationBuilder.add(GemstyneArmorItems.getAldusBoots(), "Aldus Boots");

        translationBuilder.add(GemstyneArmorItems.getRendfireHelmet(), "Rendfire Helmet");
        translationBuilder.add(GemstyneArmorItems.getRendfireChestplate(), "Rendfire Chestplate");
        translationBuilder.add(GemstyneArmorItems.getRendfireLeggings(), "Rendfire Leggings");
        translationBuilder.add(GemstyneArmorItems.getRendfireBoots(), "Rendfire Boots");

        // ======
        // <===== Tools =====>
        // ======
        translationBuilder.add(GemstyneToolItems.getAldusAxe(), "Aldus Axe");
        translationBuilder.add(GemstyneToolItems.getAldusHoe(), "Aldus Hoe");
        translationBuilder.add(GemstyneToolItems.getAldusPickaxe(), "Aldus Pickaxe");
        translationBuilder.add(GemstyneToolItems.getAldusShovel(), "Aldus Shovel");
        translationBuilder.add(GemstyneToolItems.getAldusSword(), "Aldus Sword");

        translationBuilder.add(GemstyneToolItems.getRendfireAxe(), "Rendfire Axe");
        translationBuilder.add(GemstyneToolItems.getRendfireHoe(), "Rendfire Hoe");
        translationBuilder.add(GemstyneToolItems.getRendfirePickaxe(), "Rendfire Pickaxe");
        translationBuilder.add(GemstyneToolItems.getRendfireShovel(), "Rendfire Shovel");
        translationBuilder.add(GemstyneToolItems.getRendfireSword(), "Rendfire Sword");
    }
}
