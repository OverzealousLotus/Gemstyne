package lotus.gemstyne.data;

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
                .add(GemstyneOreBlocks.MOCHITE.stoneOre)
                .add(GemstyneOreBlocks.MOCHITE.deepslateOre)
                .add(GemstyneOreBlocks.MOCHITE.rawBlock)
                .add(GemstyneOreBlocks.MOCHITE.pureBlock)

                .add(GemstyneOreBlocks.TIN.stoneOre)
                .add(GemstyneOreBlocks.TIN.deepslateOre)
                .add(GemstyneOreBlocks.TIN.rawBlock)
                .add(GemstyneOreBlocks.TIN.pureBlock)

                .add(GemstyneOreBlocks.URANIUM.deepslateOre)
                .add(GemstyneOreBlocks.URANIUM.rawBlock)
                .add(GemstyneOreBlocks.URANIUM.pureBlock)

                .add(GemstyneOreBlocks.IKARITE_CLUSTER)
                .add(GemstyneOreBlocks.LARGE_IKARITE_BUD)
                .add(GemstyneOreBlocks.MEDIUM_IKARITE_BUD)
                .add(GemstyneOreBlocks.SMALL_IKARITE_BUD)
                .add(GemstyneOreBlocks.BUDDING_IKARITE)
                .add(GemstyneOreBlocks.IKARITE_BLOCK)

                .add(GemstyneOreBlocks.GARNET_CLUSTER)
                .add(GemstyneOreBlocks.LARGE_GARNET_BUD)
                .add(GemstyneOreBlocks.MEDIUM_GARNET_BUD)
                .add(GemstyneOreBlocks.SMALL_GARNET_BUD)
                .add(GemstyneOreBlocks.BUDDING_GARNET)
                .add(GemstyneOreBlocks.GARNET_BLOCK)

                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE)
                .add(GemstyneOreBlocks.MORKITE_BLOCK)

                .add(GemstyneOreBlocks.CRIMONITE.netherOre)
                .add(GemstyneOreBlocks.CRIMONITE.rawBlock)
                .add(GemstyneOreBlocks.CRIMONITE.pureBlock)

                .add(GemstyneOreBlocks.ALDUS.netherOre)
                .add(GemstyneOreBlocks.ALDUS.rawBlock)
                .add(GemstyneOreBlocks.ALDUS.pureBlock)

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.halite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.pumice())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro())

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite())

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE)

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE)
                .add(GemstyneOreBlocks.FIRE_OPAL_BLOCK)
                .add(GemstyneOreBlocks.NEFARIUM_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsShovel())
                .setReplace(false)
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());

        // ======
        // <===== Tool-Level Requirements =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsStoneTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.MOCHITE.stoneOre)
                .add(GemstyneOreBlocks.MOCHITE.deepslateOre)
                .add(GemstyneOreBlocks.MOCHITE.rawBlock)

                .add(GemstyneOreBlocks.TIN.stoneOre)
                .add(GemstyneOreBlocks.TIN.deepslateOre)
                .add(GemstyneOreBlocks.TIN.rawBlock)
                .add(GemstyneOreBlocks.TIN.pureBlock)

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsIronTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.ALDUS.netherOre)
                .add(GemstyneOreBlocks.ALDUS.rawBlock)
                .add(GemstyneOreBlocks.ALDUS.pureBlock)

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsDiamondTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.MOCHITE.pureBlock)

                .add(GemstyneOreBlocks.URANIUM.deepslateOre)
                .add(GemstyneOreBlocks.URANIUM.rawBlock)

                .add(GemstyneOreBlocks.IKARITE_CLUSTER)
                .add(GemstyneOreBlocks.LARGE_IKARITE_BUD)
                .add(GemstyneOreBlocks.MEDIUM_IKARITE_BUD)
                .add(GemstyneOreBlocks.SMALL_IKARITE_BUD)
                .add(GemstyneOreBlocks.BUDDING_IKARITE)
                .add(GemstyneOreBlocks.IKARITE_BLOCK)

                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE)
                .add(GemstyneOreBlocks.MORKITE_BLOCK)

                .add(GemstyneOreBlocks.CRIMONITE.netherOre)
                .add(GemstyneOreBlocks.CRIMONITE.rawBlock)
                .add(GemstyneOreBlocks.CRIMONITE.pureBlock)

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE)
                .add(GemstyneOreBlocks.FIRE_OPAL_BLOCK)

                .add(GemstyneOreBlocks.NEFARIUM_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsToolLevel4())
                .setReplace(false)
                .add(GemstyneOreBlocks.URANIUM.pureBlock);

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
                .add(GemstyneOreBlocks.MOCHITE.stoneOre)
                .add(GemstyneOreBlocks.MOCHITE.deepslateOre);

        getOrCreateTagBuilder(GemstyneBlockTags.getTinOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.TIN.stoneOre)
                .add(GemstyneOreBlocks.TIN.deepslateOre);

        getOrCreateTagBuilder(GemstyneBlockTags.getMorkiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getUraniumOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.URANIUM.deepslateOre);
    }

}


