package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneBlockSet;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.util.GemstyneBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class
GemstyneBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
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

                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE)
                .add(GemstyneOreBlocks.MORKITE_BLOCK)

                .add(GemstyneMineralBlocks.HALITE)
                .add(GemstyneMineralBlocks.PUMICE)
                .add(GemstyneMineralBlocks.GABBRO)

                .add(GemstyneMineralBlocks.COMPRESSED_ANDESITE)
                .add(GemstyneMineralBlocks.COMPRESSED_DIORITE)
                .add(GemstyneMineralBlocks.COMPRESSED_GRANITE)

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE)

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE)
                .add(GemstyneOreBlocks.FIRE_OPAL_BLOCK)
                .add(GemstyneOreBlocks.NEFARIUM_ORE);

        addPickAxeTagToBlock(GemstyneOreBlocks.ALDUS.getBlockSet());
        addPickAxeTagToBlock(GemstyneOreBlocks.CRIMONITE.getBlockSet());
        addPickAxeTagToBlock(GemstyneOreBlocks.MUTALIUM.getBlockSet());
        addPickAxeTagToBlock(GemstyneOreBlocks.MOCHITE.getBlockSet());
        addPickAxeTagToBlock(GemstyneOreBlocks.TORRIUM.getBlockSet());
        addPickAxeTagToBlock(GemstyneOreBlocks.TIN.getBlockSet());
        addPickAxeTagToBlock(GemstyneOreBlocks.URANIUM.getBlockSet());
        addPickAxeTagToBlock(GemstyneOreBlocks.IKARITE.geodeSet());
        addPickAxeTagToBlock(GemstyneOreBlocks.GARNET.geodeSet());
        addPickAxeTagToBlock(GemstyneOreBlocks.LAPIS.geodeSet());

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsShovel())
                .setReplace(false)
                .add(GemstyneMineralBlocks.COMPACT_DIRT);

        // ======
        // <===== Tool-Level Requirements =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsStoneTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.MOCHITE.stoneOre())
                .add(GemstyneOreBlocks.MOCHITE.deepslateOre())
                .add(GemstyneOreBlocks.MOCHITE.rawBlock())

                .add(GemstyneOreBlocks.TIN.stoneOre())
                .add(GemstyneOreBlocks.TIN.deepslateOre())
                .add(GemstyneOreBlocks.TIN.rawBlock())
                .add(GemstyneOreBlocks.TIN.pureBlock())

                .add(GemstyneMineralBlocks.COMPRESSED_ANDESITE)
                .add(GemstyneMineralBlocks.COMPRESSED_DIORITE)
                .add(GemstyneMineralBlocks.COMPRESSED_GRANITE);

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsIronTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.ALDUS.netherOre())
                .add(GemstyneOreBlocks.ALDUS.rawBlock())
                .add(GemstyneOreBlocks.ALDUS.pureBlock())

                .add(GemstyneMineralBlocks.COMPACT_DIRT);

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsDiamondTool())
                .setReplace(false)
                .add(GemstyneOreBlocks.MOCHITE.pureBlock())

                .add(GemstyneOreBlocks.URANIUM.deepslateOre())
                .add(GemstyneOreBlocks.URANIUM.rawBlock())

                .add(GemstyneOreBlocks.IKARITE.clusterBud())
                .add(GemstyneOreBlocks.IKARITE.largeBud())
                .add(GemstyneOreBlocks.IKARITE.mediumBud())
                .add(GemstyneOreBlocks.IKARITE.smallBud())
                .add(GemstyneOreBlocks.IKARITE.buddingBlock())
                .add(GemstyneOreBlocks.IKARITE.pureBlock())

                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE)
                .add(GemstyneOreBlocks.MORKITE_BLOCK)

                .add(GemstyneOreBlocks.CRIMONITE.netherOre())
                .add(GemstyneOreBlocks.CRIMONITE.rawBlock())
                .add(GemstyneOreBlocks.CRIMONITE.pureBlock())

                .add(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE)
                .add(GemstyneOreBlocks.FIRE_OPAL_BLOCK)

                .add(GemstyneOreBlocks.NEFARIUM_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsToolLevel4())
                .setReplace(false)
                .add(GemstyneOreBlocks.URANIUM.pureBlock());

        // ======
        // <===== Replaceables =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getCompressedAndesiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneMineralBlocks.COMPRESSED_ANDESITE);
        getOrCreateTagBuilder(GemstyneBlockTags.getCompressedGraniteOreReplaceables())
                .setReplace(false)
                .add(GemstyneMineralBlocks.COMPRESSED_GRANITE);

        getOrCreateTagBuilder(GemstyneBlockTags.END_BASE_REPLACEABLES)
            .setReplace(false)
                .add(Blocks.END_STONE);

        getOrCreateTagBuilder(GemstyneBlockTags.getMochiteOreReplaceables())
            .setReplace(false)
            .add(GemstyneOreBlocks.MOCHITE.stoneOre())
            .add(GemstyneOreBlocks.MOCHITE.deepslateOre());

        getOrCreateTagBuilder(GemstyneBlockTags.getTinOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.TIN.stoneOre())
                .add(GemstyneOreBlocks.TIN.deepslateOre());

        getOrCreateTagBuilder(GemstyneBlockTags.getMorkiteOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getUraniumOreReplaceables())
                .setReplace(false)
                .add(GemstyneOreBlocks.URANIUM.deepslateOre());
    }

    /**
     * Method which iterates through a {@link GemstyneBlockSet#getBlockSet}
     * @param blockSet Any type of {@link GemstyneBlockSet}
     */
    private void addPickAxeTagToBlock(Set<Block> blockSet) {
        blockSet.forEach(block -> getOrCreateTagBuilder(GemstyneBlockTags.getNeedsPickaxe()).setReplace(false).add(block));
    }
}


