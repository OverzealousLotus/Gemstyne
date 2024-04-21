package lotus.gemstyne.entity.client;

import lotus.gemstyne.entity.custom.AetherZombie;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.ZombieEntityModel;

@Environment(EnvType.CLIENT)
public class AetherZombieModel<T extends AetherZombie> extends ZombieEntityModel<T> {
    protected AetherZombieModel(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public boolean isAttacking(T entity) {
        return false;
    }
}
