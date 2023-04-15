package lotus.gemstyne.data;

import lotus.gemstyne.block.GemStyneDecorBlocks;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.util.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup arg) {
        // ======
        // <===== Tool-Type Requirements =====>
        // ======
        getOrCreateTagBuilder(ModBlockTags.NEEDS_PICKAXE)
                .setReplace(false)
                .add(GemstyneOreBlocks.MOCHITE_ORE)
                .add(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE)
                .add(GemstyneOreBlocks.RAW_MOCHITE_BLOCK)
                .add(GemStyneDecorBlocks.MOCHITE_BLOCK)

                .add(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE)
                .add(GemstyneOreBlocks.RAW_URANIUM_BLOCK)
                .add(GemStyneDecorBlocks.URANIUM_BLOCK)

                .add(GemstyneOreBlocks.IKARITE_CLUSTER)
                .add(GemstyneOreBlocks.IKARITE_BLOCK)
                .add(GemstyneOreBlocks.BUDDING_IKARITE)

                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE)
                .add(GemstyneOreBlocks.MORKITE_BLOCK)

                .add(GemstyneOreBlocks.NETHER_CRIMONITE_ORE)
                .add(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK)
                .add(GemStyneDecorBlocks.CRIMONITE_BLOCK)

                .add(GemstyneOreBlocks.NETHER_ALDUS_ORE)
                .add(GemstyneOreBlocks.RAW_ALDUS_BLOCK)
                .add(GemStyneDecorBlocks.ALDUS_BLOCK)

                .add(GemstyneMineralBlocks.COMPRESSED_ANDESITE)
                .add(GemstyneMineralBlocks.COMPRESSED_DIORITE)
                .add(GemstyneMineralBlocks.COMPRESSED_GRANITE)

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE)

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE)
                .add(GemStyneDecorBlocks.FIRE_OPAL_BLOCK);

        getOrCreateTagBuilder(ModBlockTags.NEEDS_SHOVEL)
                .setReplace(false)
                .add(GemstyneMineralBlocks.COMPACT_DIRT);

        // ======
        // <===== Tool-Level Requirements =====>
        // ======
        getOrCreateTagBuilder(ModBlockTags.NEEDS_STONE_TOOL)
                .setReplace(false)
                .add(GemstyneOreBlocks.MOCHITE_ORE);

        getOrCreateTagBuilder(ModBlockTags.NEEDS_IRON_TOOL)
                .setReplace(false)
                .add(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE)
                .add(GemstyneOreBlocks.RAW_MOCHITE_BLOCK)

                .add(GemstyneOreBlocks.NETHER_ALDUS_ORE)
                .add(GemstyneOreBlocks.RAW_ALDUS_BLOCK)
                .add(GemStyneDecorBlocks.ALDUS_BLOCK);

        getOrCreateTagBuilder(ModBlockTags.NEEDS_DIAMOND_TOOL)
                .setReplace(false)
                .add(GemStyneDecorBlocks.MOCHITE_BLOCK)

                .add(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE)
                .add(GemstyneOreBlocks.RAW_URANIUM_BLOCK)

                .add(GemstyneOreBlocks.IKARITE_CLUSTER)
                .add(GemstyneOreBlocks.IKARITE_BLOCK)
                .add(GemstyneOreBlocks.BUDDING_IKARITE)

                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE)
                .add(GemstyneOreBlocks.MORKITE_BLOCK)

                .add(GemstyneOreBlocks.NETHER_CRIMONITE_ORE)
                .add(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK)
                .add(GemStyneDecorBlocks.CRIMONITE_BLOCK)

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE)
                .add(GemStyneDecorBlocks.FIRE_OPAL_BLOCK);

        getOrCreateTagBuilder(ModBlockTags.NEEDS_TOOL_LEVEL_4)
                .setReplace(false)
                .add(GemStyneDecorBlocks.URANIUM_BLOCK);

        // ======
        // <===== Replaceables =====>
        // ======
        getOrCreateTagBuilder(ModBlockTags.COMPRESSED_ANDESITE_ORE_REPLACEABLES)
                .setReplace(false)
                .add(GemstyneMineralBlocks.COMPRESSED_ANDESITE);
    }

}


