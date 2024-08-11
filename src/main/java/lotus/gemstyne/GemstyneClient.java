package lotus.gemstyne;

import lotus.gemstyne.block.entity.GemstyneBlockEntities;
import lotus.gemstyne.client.GeodeCutouts;
import lotus.gemstyne.client.rendering.ThermoTntEntityRenderer;
import lotus.gemstyne.client.rendering.UraniumArrowEntityRenderer;
import lotus.gemstyne.entity.EntityHandler;
import lotus.gemstyne.entity.client.AetherZombieRenderer;
import lotus.gemstyne.fluid.FluidHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class GemstyneClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GeodeCutouts.registerGeodeCutouts();
        // Registers renderer to be used for rendering the TNT Entity.
        EntityRendererRegistry.register(GemstyneBlockEntities.THERMO_TNT_ENTITY, ThermoTntEntityRenderer::new);

        FluidRenderHandlerRegistry.INSTANCE.register(FluidHandler.STILL_LIQUID_MORKITE, FluidHandler.FLOWING_LIQUID_MORKITE,
                new SimpleFluidRenderHandler(
                        Identifier.of("minecraft:block/lava_still"),
                        Identifier.of("minecraft:block/lava_flow"),
                        0xA1002626
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                FluidHandler.STILL_LIQUID_MORKITE, FluidHandler.FLOWING_LIQUID_MORKITE);

        EntityRendererRegistry.register(EntityHandler.AETHER_ZOMBIE, AetherZombieRenderer::new);
        EntityRendererRegistry.register(EntityHandler.URANIUM_ARROW, UraniumArrowEntityRenderer::new);
        // EntityModelLayerRegistry.registerModelLayer(GemstyneModelLayers.AETHER_ZOMBIE);
    }
}
