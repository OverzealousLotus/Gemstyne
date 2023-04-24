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
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.getIkariteCluster(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.getLargeIkariteBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.getMediumIkariteBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.getSmallIkariteBud(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.getGarnetCluster(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.getLargeGarnetBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.getMediumGarnetBud(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.getSmallGarnetBud(), RenderLayer.getCutout());

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
