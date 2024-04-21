package lotus.gemstyne.entity.client;

import lotus.gemstyne.Gemstyne;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

public class AetherZombieRenderer extends ZombieEntityRenderer {
    private static final Identifier TEXTURE = new Identifier(Gemstyne.MOD_ID, "textures/entity/aether_zombie.png");
    public AetherZombieRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(ZombieEntity zombieEntity) {
        return TEXTURE;
    }
}
