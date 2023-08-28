package lotus.gemstyne;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.fluid.GemstyneFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class GemstyneClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.IKARITE.clusterBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.IKARITE.largeBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.IKARITE.mediumBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.IKARITE.smallBud(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.GARNET.clusterBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.GARNET.largeBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.GARNET.mediumBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.GARNET.smallBud(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.LAPIS.clusterBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.LAPIS.largeBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.LAPIS.mediumBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.LAPIS.smallBud(), RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(GemstyneFluids.STILL_LIQUID_MORKITE, GemstyneFluids.FLOWING_LIQUID_MORKITE,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/lava_still"),
                        new Identifier("minecraft:block/lava_flow"),
                        0xA1002626
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                GemstyneFluids.STILL_LIQUID_MORKITE, GemstyneFluids.FLOWING_LIQUID_MORKITE);
    }
}
