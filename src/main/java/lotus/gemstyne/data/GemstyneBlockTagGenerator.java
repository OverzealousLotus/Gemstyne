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
                .add(GemstyneOreBlocks.MOCHITE_ORE)
                .add(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE)
                .add(GemstyneOreBlocks.RAW_MOCHITE_BLOCK)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock())

                .add(GemstyneOreBlocks.TIN_ORE)
                .add(GemstyneOreBlocks.DEEPSLATE_TIN_ORE)
                .add(GemstyneOreBlocks.RAW_TIN_BLOCK)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.tinBlock())

                .add(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE)
                .add(GemstyneOreBlocks.RAW_URANIUM_BLOCK)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock())

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

                .add(GemstyneOreBlocks.NETHER_CRIMONITE_ORE)
                .add(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock())

                .add(GemstyneOreBlocks.NETHER_ALDUS_ORE)
                .add(GemstyneOreBlocks.RAW_ALDUS_BLOCK)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock())

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.halite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.pumice())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro())

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite())

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE)

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.fireOpalBlock());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsShovel())
                .setReplace(false)
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());

        // ======
        // <===== Tool-Level Requirements =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsStoneTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.MOCHITE_ORE)
                .add(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE)
                .add(GemstyneOreBlocks.RAW_MOCHITE_BLOCK)

                .add(GemstyneOreBlocks.TIN_ORE)
                .add(GemstyneOreBlocks.DEEPSLATE_TIN_ORE)
                .add(GemstyneOreBlocks.RAW_TIN_BLOCK)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.tinBlock())

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite())
                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsIronTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.NETHER_ALDUS_ORE)
                .add(GemstyneOreBlocks.RAW_ALDUS_BLOCK)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock())

                .add(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsDiamondTool())
                .setReplace(false)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock())

                .add(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE)
                .add(GemstyneOreBlocks.RAW_URANIUM_BLOCK)

                .add(GemstyneOreBlocks.IKARITE_CLUSTER)
                .add(GemstyneOreBlocks.LARGE_IKARITE_BUD)
                .add(GemstyneOreBlocks.MEDIUM_IKARITE_BUD)
                .add(GemstyneOreBlocks.SMALL_IKARITE_BUD)
                .add(GemstyneOreBlocks.BUDDING_IKARITE)
                .add(GemstyneOreBlocks.IKARITE_BLOCK)

                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE)
                .add(GemstyneOreBlocks.MORKITE_BLOCK)

                .add(GemstyneOreBlocks.NETHER_CRIMONITE_ORE)
                .add(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK)
                .add(GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock())

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE)
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
                .add(GemstyneOreBlocks.MOCHITE_ORE)
                .add(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getTinOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.TIN_ORE)
                .add(GemstyneOreBlocks.DEEPSLATE_TIN_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getMorkiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getUraniumOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE);
    }

}


