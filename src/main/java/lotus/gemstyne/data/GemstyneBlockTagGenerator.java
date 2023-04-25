package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.util.GemstyneBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class GemstyneBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public GemstyneBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup arg) {
        // ======
        // <===== Tool-Type Requirements =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsPickaxe())
                .setReplace(false)
                .add(GemstyneOreBlocks.getMochiteOre())
                .add(GemstyneOreBlocks.getDeepslateMochiteOre())
                .add(GemstyneOreBlocks.getRawMochiteBlock())
                .add(GemstyneDecorBlocks.getMochiteBlock())

                .add(GemstyneOreBlocks.getTinOre())
                .add(GemstyneOreBlocks.getDeepslateTinOre())
                .add(GemstyneOreBlocks.getRawTinBlock())
                .add(GemstyneDecorBlocks.getTinBlock())

                .add(GemstyneOreBlocks.getDeepslateUraniumOre())
                .add(GemstyneOreBlocks.getRawUraniumBlock())
                .add(GemstyneDecorBlocks.getUraniumBlock())

                .add(GemstyneOreBlocks.getIkariteCluster())
                .add(GemstyneOreBlocks.getIkariteBlock())
                .add(GemstyneOreBlocks.getBuddingIkarite())
                .add(GemstyneOreBlocks.getLargeIkariteBud())
                .add(GemstyneOreBlocks.getMediumIkariteBud())
                .add(GemstyneOreBlocks.getSmallIkariteBud())

                .add(GemstyneOreBlocks.getGarnetBlock())
                .add(GemstyneOreBlocks.getGarnetCluster())
                .add(GemstyneOreBlocks.getBuddingGarnet())
                .add(GemstyneOreBlocks.getLargeGarnetBud())
                .add(GemstyneOreBlocks.getMediumGarnetBud())
                .add(GemstyneOreBlocks.getSmallGarnetBud())

                .add(GemstyneOreBlocks.getDeepslateMorkiteOre())
                .add(GemstyneOreBlocks.getMorkiteBlock())

                .add(GemstyneOreBlocks.getNetherCrimoniteOre())
                .add(GemstyneOreBlocks.getRawCrimoniteBlock())
                .add(GemstyneDecorBlocks.getCrimoniteBlock())

                .add(GemstyneOreBlocks.getNetherAldusOre())
                .add(GemstyneOreBlocks.getRawAldusBlock())
                .add(GemstyneDecorBlocks.getAldusBlock())

                .add(GemstyneMineralBlocks.getHALITE())
                .add(GemstyneMineralBlocks.getPUMICE())

                .add(GemstyneMineralBlocks.getCompressedAndesite())
                .add(GemstyneMineralBlocks.getCompressedDiorite())
                .add(GemstyneMineralBlocks.getCompressedGranite())

                .add(GemstyneOreBlocks.getCompressedGraniteCoalOre())

                .add(GemstyneOreBlocks.getCompressedGraniteFireOpalOre())
                .add(GemstyneDecorBlocks.getFireOpalBlock());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsShovel())
                .setReplace(false)
                .add(GemstyneMineralBlocks.getCompactDirt());

        // ======
        // <===== Tool-Level Requirements =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsStoneTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.getMochiteOre())

                .add(GemstyneOreBlocks.getTinOre())
                .add(GemstyneOreBlocks.getDeepslateTinOre())
                .add(GemstyneOreBlocks.getRawTinBlock())
                .add(GemstyneDecorBlocks.getTinBlock());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsIronTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.getDeepslateMochiteOre())
                .add(GemstyneOreBlocks.getRawMochiteBlock())

                .add(GemstyneOreBlocks.getNetherAldusOre())
                .add(GemstyneOreBlocks.getRawAldusBlock())
                .add(GemstyneDecorBlocks.getAldusBlock());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsDiamondTool())
                .setReplace(false)
                .add(GemstyneDecorBlocks.getMochiteBlock())

                .add(GemstyneOreBlocks.getDeepslateUraniumOre())
                .add(GemstyneOreBlocks.getRawUraniumBlock())

                .add(GemstyneOreBlocks.getIkariteCluster())
                .add(GemstyneOreBlocks.getIkariteBlock())
                .add(GemstyneOreBlocks.getBuddingIkarite())
                .add(GemstyneOreBlocks.getLargeIkariteBud())
                .add(GemstyneOreBlocks.getMediumIkariteBud())
                .add(GemstyneOreBlocks.getSmallIkariteBud())

                .add(GemstyneOreBlocks.getDeepslateMorkiteOre())
                .add(GemstyneOreBlocks.getMorkiteBlock())

                .add(GemstyneOreBlocks.getNetherCrimoniteOre())
                .add(GemstyneOreBlocks.getRawCrimoniteBlock())
                .add(GemstyneDecorBlocks.getCrimoniteBlock())

                .add(GemstyneOreBlocks.getCompressedGraniteFireOpalOre())
                .add(GemstyneDecorBlocks.getFireOpalBlock());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsToolLevel4())
                .setReplace(false)
                .add(GemstyneDecorBlocks.getUraniumBlock());

        // ======
        // <===== Replaceables =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getCompressedAndesiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneMineralBlocks.getCompressedAndesite());
        getOrCreateTagBuilder(GemstyneBlockTags.getCompressedGraniteOreReplaceables())
                .setReplace(false)
                .add(GemstyneMineralBlocks.getCompressedGranite());

        getOrCreateTagBuilder(GemstyneBlockTags.getMochiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.getMochiteOre())
                .add(GemstyneOreBlocks.getDeepslateMochiteOre());

        getOrCreateTagBuilder(GemstyneBlockTags.getTinOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.getTinOre())
                .add(GemstyneOreBlocks.getDeepslateTinOre());

        getOrCreateTagBuilder(GemstyneBlockTags.getMorkiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.getDeepslateMorkiteOre());

        getOrCreateTagBuilder(GemstyneBlockTags.getUraniumOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.getDeepslateUraniumOre());
    }

}


