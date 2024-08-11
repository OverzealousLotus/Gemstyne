package lotus.gemstyne.client.rendering;

import lotus.gemstyne.entity.custom.UraniumArrowEntity;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class UraniumArrowEntityRenderer extends ProjectileEntityRenderer<UraniumArrowEntity> {
    public static final Identifier TEXTURE = GemstyneRegistry.id("textures/entity/projectiles/uranium_arrow.png");

    public UraniumArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(UraniumArrowEntity entity) {
        return TEXTURE;
    }
}
