package lotus.gemstyne.entity.client;

import lotus.gemstyne.Gemstyne;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class GemstyneModelLayers {
    private GemstyneModelLayers() {}

    public static final EntityModelLayer AETHER_ZOMBIE =
        new EntityModelLayer(new Identifier(Gemstyne.MOD_ID, "aether_zombie"), "main");
}
