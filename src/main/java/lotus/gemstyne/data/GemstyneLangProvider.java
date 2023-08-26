package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.data.translations.en_us.GemstyneEnglishLangProvider;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class GemstyneLangProvider extends FabricLanguageProvider {
    public GemstyneLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        GemstyneEnglishLangProvider.coupleAndGenerateEnglishLang(translationBuilder);
        // ======
        // <===== Items =====>
        // ======
        translationBuilder.add(GemstyneCraftingItems.getImbuedRod(), "Imbued Rod");
        translationBuilder.add(GemstyneGearItems.getImbuedFeather(), "Imbued Feather");

        translationBuilder.add(GemstyneFluids.LIQUID_MORKITE_BUCKET, "Liquid Morkite Bucket");

        // ======
        // <===== Decorations =====>
        // ======
        translationBuilder.add(GemstyneOreBlocks.URANIUM.pureBlock, "Uranium Block");
        translationBuilder.add(GemstyneOreBlocks.MOCHITE.pureBlock, "Mochite Block");
        translationBuilder.add(GemstyneOreBlocks.TIN.pureBlock, "Tin Block");
        translationBuilder.add(GemstyneOreBlocks.CRIMONITE.pureBlock, "Crimonite Block");
        translationBuilder.add(GemstyneOreBlocks.ALDUS.pureBlock, "Aldus Block");
        translationBuilder.add(GemstyneOreBlocks.FIRE_OPAL_BLOCK, "Fire Opal Block");


        translationBuilder.add(GemstyneEffects.IRRADIATE, "Irradiate");
        translationBuilder.add(GemstyneOreBlocks.NEFARIUM_ORE, "Nefarium Ore");
    }
}
