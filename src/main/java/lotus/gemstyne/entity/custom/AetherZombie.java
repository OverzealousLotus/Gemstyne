package lotus.gemstyne.entity.custom;

import lotus.gemstyne.effect.GemstyneEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class AetherZombie extends ZombieEntity {
    public AetherZombie(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    /*@Override
    protected void initGoals() {
        // Goal Priority is in ascending order. 0 goes first, then 1.
        super.initGoals();
    }*/

    public static DefaultAttributeContainer.Builder createAetherZombieAttributes() {
        // Zombie expects Zombie Attributes, not Mob.
        return ZombieEntity.createZombieAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 40) // Zombie: 20
            .add(EntityAttributes.GENERIC_ARMOR, 4) // Zombie: 2
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.26f) // Zombie: 0.23
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4); // Zombie: 3

    }

    @Override
    public boolean tryAttack(Entity target) {
        float f = this.getWorld().getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
        if (this.getMainHandStack().isEmpty() && this.random.nextFloat() < f * 0.3f && target instanceof LivingEntity entity) {
            entity.addStatusEffect(new StatusEffectInstance(GemstyneEffects.AETHERIUM_RADIATION, 200, 1));
        }
        return super.tryAttack(target);
    }

    @Override
    protected boolean burnsInDaylight() { return false; }
}
