package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.data.translations.en_us.GemstyneEnglishLangProvider;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.item.*;
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
        translationBuilder.add(ModItems.IMBUED_ROD, "Imbued Rod");
        translationBuilder.add(ModItems.IMBUED_FEATHER, "Imbued Feather");

        translationBuilder.add(ModItemGroup.GEMSTYNE, "Gemstyne");
        translationBuilder.add(ModItems.LIQUID_MORKITE_BUCKET, "Liquid Morkite Bucket");

        // ======
        // <===== Decorations =====>
        // ======
        translationBuilder.add(GemstyneDecorBlocks.getUraniumBlock(), "Uranium Block");
        translationBuilder.add(GemstyneDecorBlocks.getMochiteBlock(), "Mochite Block");
        translationBuilder.add(GemstyneDecorBlocks.getTinBlock(), "Tin Block");
        translationBuilder.add(GemstyneDecorBlocks.getCrimoniteBlock(), "Crimonite Block");
        translationBuilder.add(GemstyneDecorBlocks.getAldusBlock(), "Aldus Block");
        translationBuilder.add(GemstyneDecorBlocks.getFireOpalBlock(), "Fire Opal Block");


        translationBuilder.add(GemstyneEffects.IRRADIATE, "Irradiate");
    }
}
