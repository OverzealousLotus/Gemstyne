package lotus.gemstyne;

import lotus.gemstyne.block.GemstyneOreBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class GemstyneClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(GemstyneOreBlocks.IKARITE_CLUSTER, RenderLayer.getCutout());
    }
}
