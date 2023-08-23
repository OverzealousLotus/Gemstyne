package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.data.translations.en_us.GemstyneEnglishLangProvider;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import lotus.gemstyne.util.GemstyneCreativeGroup;
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

        translationBuilder.add(GemstyneCreativeGroup.GEMSTYNE.toString(), "Gemstyne");
        translationBuilder.add(GemstyneFluids.LIQUID_MORKITE_BUCKET, "Liquid Morkite Bucket");

        // ======
        // <===== Decorations =====>
        // ======
        translationBuilder.add(GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock(), "Uranium Block");
        translationBuilder.add(GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock(), "Mochite Block");
        translationBuilder.add(GemstyneDecorBlocks.DECOR_BLOCKS.tinBlock(), "Tin Block");
        translationBuilder.add(GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock(), "Crimonite Block");
        translationBuilder.add(GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock(), "Aldus Block");
        translationBuilder.add(GemstyneDecorBlocks.DECOR_BLOCKS.fireOpalBlock(), "Fire Opal Block");


        translationBuilder.add(GemstyneEffects.IRRADIATE, "Irradiate");
        translationBuilder.add(GemstyneOreBlocks.NEFARIUM_ORE, "Nefarium Ore");
    }
}
