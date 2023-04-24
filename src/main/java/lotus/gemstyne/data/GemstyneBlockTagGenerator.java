package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.util.ModBlockTags;
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
        getOrCreateTagBuilder(ModBlockTags.NEEDS_PICKAXE)
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

        getOrCreateTagBuilder(ModBlockTags.NEEDS_SHOVEL)
                .setReplace(false)
                .add(GemstyneMineralBlocks.getCompactDirt());

        // ======
        // <===== Tool-Level Requirements =====>
        // ======
        getOrCreateTagBuilder(ModBlockTags.NEEDS_STONE_TOOL)
                .setReplace(false)
                .add(GemstyneOreBlocks.getMochiteOre())

                .add(GemstyneOreBlocks.getTinOre())
                .add(GemstyneOreBlocks.getDeepslateTinOre())
                .add(GemstyneOreBlocks.getRawTinBlock())
                .add(GemstyneDecorBlocks.getTinBlock());

        getOrCreateTagBuilder(ModBlockTags.NEEDS_IRON_TOOL)
                .setReplace(false)
                .add(GemstyneOreBlocks.getDeepslateMochiteOre())
                .add(GemstyneOreBlocks.getRawMochiteBlock())

                .add(GemstyneOreBlocks.getNetherAldusOre())
                .add(GemstyneOreBlocks.getRawAldusBlock())
                .add(GemstyneDecorBlocks.getAldusBlock());

        getOrCreateTagBuilder(ModBlockTags.NEEDS_DIAMOND_TOOL)
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

        getOrCreateTagBuilder(ModBlockTags.NEEDS_TOOL_LEVEL_4)
                .setReplace(false)
                .add(GemstyneDecorBlocks.getUraniumBlock());

        // ======
        // <===== Replaceables =====>
        // ======
        getOrCreateTagBuilder(ModBlockTags.COMPRESSED_ANDESITE_ORE_REPLACEABLES)
                .setReplace(false)
                .add(GemstyneMineralBlocks.getCompressedAndesite());
        getOrCreateTagBuilder(ModBlockTags.COMPRESSED_GRANITE_ORE_REPLACEABLES)
                .setReplace(false)
                .add(GemstyneMineralBlocks.getCompressedGranite());

        getOrCreateTagBuilder(ModBlockTags.MOCHITE_ORE_REPLACEABLES)
                .setReplace(false)
                .add(GemstyneOreBlocks.getMochiteOre())
                .add(GemstyneOreBlocks.getDeepslateMochiteOre());

        getOrCreateTagBuilder(ModBlockTags.MORKITE_ORE_REPLACEABLES)
                .setReplace(false)
                .add(GemstyneOreBlocks.getDeepslateMorkiteOre());

        getOrCreateTagBuilder(ModBlockTags.URANIUM_ORE_REPLACEABLES)
                .setReplace(false)
                .add(GemstyneOreBlocks.getDeepslateUraniumOre());
    }

}


