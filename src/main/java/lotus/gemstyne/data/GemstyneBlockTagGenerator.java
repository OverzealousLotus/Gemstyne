package lotus.gemstyne.data;

import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.util.GemstyneBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
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

                .add(BlockHandler.HALITE)
                .add(BlockHandler.PUMICE)
                .add(BlockHandler.GABBRO)

                .add(BlockHandler.COMPRESSED_ANDESITE)
                .add(BlockHandler.COMPRESSED_DIORITE)
                .add(BlockHandler.COMPRESSED_GRANITE)

                .add(BlockHandler.COMPRESSED_GRANITE_COAL_ORE)

                .add(BlockHandler.NEFARIUM_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsShovel())
                .setReplace(false)
                .add(BlockHandler.COMPACT_DIRT);

        // ======
        // <===== Tool-Level Requirements =====>
        // ======
        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsStoneTool())
                .setReplace(false)

                .add(BlockHandler.COMPRESSED_ANDESITE)
                .add(BlockHandler.COMPRESSED_DIORITE)
                .add(BlockHandler.COMPRESSED_GRANITE);

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsIronTool())
                .setReplace(false)

                .add(BlockHandler.COMPACT_DIRT);

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsDiamondTool())
                .setReplace(false)

                .add(BlockHandler.NEFARIUM_ORE);

        getOrCreateTagBuilder(GemstyneBlockTags.getNeedsToolLevel4())
                .setReplace(false);

        // ======
        // <===== Replaceables =====>
        // ======
    }
}


