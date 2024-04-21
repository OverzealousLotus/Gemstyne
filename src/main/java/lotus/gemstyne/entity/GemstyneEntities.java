package lotus.gemstyne.entity;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.entity.custom.AetherZombie;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GemstyneEntities {
    private GemstyneEntities() {}

    public static final EntityType<AetherZombie> AETHER_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
        new Identifier(Gemstyne.MOD_ID, "aether_zombie"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AetherZombie::new).dimensions(EntityDimensions.fixed(1f, 2f)).build());
}
