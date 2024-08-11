package lotus.gemstyne.entity;

import lotus.gemstyne.entity.custom.AetherZombie;
import lotus.gemstyne.entity.custom.UraniumArrowEntity;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EntityHandler {
    private EntityHandler() {}

    public static final EntityType<AetherZombie> AETHER_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
        GemstyneRegistry.id("aether_zombie"),
        EntityType.Builder.create(AetherZombie::new, SpawnGroup.MONSTER).dimensions(1f, 2f).build());

    public static final EntityType<UraniumArrowEntity> URANIUM_ARROW = Registry.register(Registries.ENTITY_TYPE,
        GemstyneRegistry.id("uranium_arrow"),
        EntityType.Builder.<UraniumArrowEntity>create(UraniumArrowEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build());


}
