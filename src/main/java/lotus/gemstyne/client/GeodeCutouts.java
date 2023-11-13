package lotus.gemstyne.client;

import com.google.common.collect.ImmutableSet;
import lotus.gemstyne.block.BlockHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public final class GeodeCutouts {
    private GeodeCutouts() {}

    public static void registerGeodeCutouts() {
        addGeodeCutouts(BlockHandler.IKARITE.getBudSet());
        addGeodeCutouts(BlockHandler.GARNET.getBudSet());
        addGeodeCutouts(BlockHandler.LAPIS.getBudSet());
    }

    private static void addGeodeCutouts(ImmutableSet<Block> buds) {
        buds.forEach(bud -> BlockRenderLayerMap.INSTANCE.putBlock(bud, RenderLayer.getCutout()));
    }
}
