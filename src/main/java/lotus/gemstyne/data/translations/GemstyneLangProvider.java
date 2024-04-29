package lotus.gemstyne.data.translations;

import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.data.translations.en_us.GemstyneENProvider;
import lotus.gemstyne.effect.EffectHandler;
import lotus.gemstyne.entity.EntityHandler;
import lotus.gemstyne.item.ItemHandler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class GemstyneLangProvider extends FabricLanguageProvider {
    public GemstyneLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        GemstyneENProvider.buildEnglishLanguage(translationBuilder);

        translationBuilder.add(EffectHandler.WEAK_RADIATION, "Minor Radiation");
        translationBuilder.add(EffectHandler.STRONG_RADIATION, "Potent Radiation");
        translationBuilder.add(EffectHandler.AETHERIUM_RADIATION, "Aetherium Radiation");
        translationBuilder.add(BlockHandler.NEFARIUM_ORE, "Nefarium Ore");
        translationBuilder.add(ItemHandler.BUBBLEGEM, "Bubblegem");
        translationBuilder.add(EntityHandler.AETHER_ZOMBIE, "Aetherium Zombie");
    }
}
