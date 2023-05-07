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
                .add(GemstyneOreBlocks.ORE_BLOCKS.mochiteOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMochiteOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawMochiteBlock())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock())

                .add(GemstyneOreBlocks.ORE_BLOCKS.tinOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateTinOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawTinBlock())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.tinBlock())

                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateUraniumOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawUraniumBlock())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock())

                .add(GemstyneOreBlocks.GEODE_BLOCKS.ikariteCluster())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.ikariteBlock())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.buddingIkarite())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.largeIkariteBud())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.mediumIkariteBud())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud())

                .add(GemstyneOreBlocks.GEODE_BLOCKS.garnetBlock())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.garnetCluster())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.buddingGarnet())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.largeGarnetBud())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.mediumGarnetBud())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.smallGarnetBud())

                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMorkiteOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.morkiteBlock())

                .add(GemstyneOreBlocks.ORE_BLOCKS.netherCrimoniteOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawCrimoniteBlock())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock())

                .add(GemstyneOreBlocks.ORE_BLOCKS.netherAldusOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawAldusBlock())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock())

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.halite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.pumice())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro())

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite())

                .add(GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteCoalOre())

                .add(GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteFireOpalOre())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.fireOpalBlock());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsShovel())
                .setReplace(false)
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());

        // ======
        // <===== Tool-Level Requirements =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsStoneTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.ORE_BLOCKS.mochiteOre())

                .add(GemstyneOreBlocks.ORE_BLOCKS.tinOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateTinOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawTinBlock())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.tinBlock())

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsIronTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMochiteOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawMochiteBlock())

                .add(GemstyneOreBlocks.ORE_BLOCKS.netherAldusOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawAldusBlock())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock())

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsDiamondTool())
                .setReplace(false)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock())

                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateUraniumOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawUraniumBlock())

                .add(GemstyneOreBlocks.GEODE_BLOCKS.ikariteCluster())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.ikariteBlock())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.buddingIkarite())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.largeIkariteBud())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.mediumIkariteBud())
                .add(GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud())

                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMorkiteOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.morkiteBlock())

                .add(GemstyneOreBlocks.ORE_BLOCKS.netherCrimoniteOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.rawCrimoniteBlock())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock())

                .add(GemstyneOreBlocks.ORE_BLOCKS.compressedGraniteFireOpalOre())
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.fireOpalBlock());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsToolLevel4())
                .setReplace(false)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock());

        // ======
        // <===== Replaceables =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getCompressedAndesiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite());
        getOrCreateTagBuilder(GemstyneBlockTags.getCompressedGraniteOreReplaceables())
                .setReplace(false)
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite());

        getOrCreateTagBuilder(GemstyneBlockTags.getMochiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.ORE_BLOCKS.mochiteOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMochiteOre());

        getOrCreateTagBuilder(GemstyneBlockTags.getTinOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.ORE_BLOCKS.tinOre())
                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateTinOre());

        getOrCreateTagBuilder(GemstyneBlockTags.getMorkiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMorkiteOre());

        getOrCreateTagBuilder(GemstyneBlockTags.getUraniumOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.ORE_BLOCKS.deepslateUraniumOre());
    }

}


