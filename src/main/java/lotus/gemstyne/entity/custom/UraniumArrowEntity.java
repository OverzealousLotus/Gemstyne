package lotus.gemstyne.entity.custom;

import lotus.gemstyne.effect.EffectHandler;
import lotus.gemstyne.entity.EntityHandler;
import lotus.gemstyne.item.ItemHandler;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class UraniumArrowEntity extends PersistentProjectileEntity {
    private static final TrackedData<Integer> COLOR = DataTracker.registerData(UraniumArrowEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public static final ItemStack URANIUM_ARROW_STACK = new ItemStack(ItemHandler.URANIUM_ARROW);

    public UraniumArrowEntity(EntityType<UraniumArrowEntity> type, World world) {
        super(type, world);
        this.initColor();
    }

    public UraniumArrowEntity(LivingEntity shooter, World world, @Nullable ItemStack shotFrom) {
        super(EntityHandler.URANIUM_ARROW, shooter, world, URANIUM_ARROW_STACK, shotFrom);
        this.initColor();
    }

    public UraniumArrowEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(EntityHandler.URANIUM_ARROW, x, y, z, world, stack, shotFrom);
    }

    public UraniumArrowEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(EntityHandler.URANIUM_ARROW, owner, world, stack, shotFrom);
        this.initColor();
    }

    private PotionContentsComponent getPotionContents() {
        return this.getItemStack().getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
    }

    protected void initColor() {
        PotionContentsComponent potionContentsComponent = this.getPotionContents();
        this.dataTracker.set(COLOR, potionContentsComponent.equals(PotionContentsComponent.DEFAULT) ? -1 : potionContentsComponent.getColor());
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return URANIUM_ARROW_STACK;
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        Entity entity = this.getEffectCause();
        target.addStatusEffect(new StatusEffectInstance(EffectHandler.WEAK_RADIATION, 400, 1));
        PotionContentsComponent potionContentsComponent = this.getPotionContents();
      
        if (potionContentsComponent.potion().isPresent()) {
            for (var statusEffectInstance : potionContentsComponent.potion().get().value().getEffects()) {
                target.addStatusEffect(
                    new StatusEffectInstance(
                        statusEffectInstance.getEffectType(),
                        Math.max(statusEffectInstance.mapDuration(i -> i / 8), 1),
                        statusEffectInstance.getAmplifier(),
                        statusEffectInstance.isAmbient(),
                        statusEffectInstance.shouldShowParticles()
                    ),
                    entity
                );
            }
        }

        for (StatusEffectInstance statusEffectInstance : potionContentsComponent.customEffects()) {
            target.addStatusEffect(statusEffectInstance, entity);
        }
    }

    public int getColor() {
        return this.dataTracker.get(COLOR);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(COLOR, -1);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            if (this.inGround) {
                if (this.inGroundTime % 5 == 0) {
                    this.spawnParticles(1);
                }
            } else {
                this.spawnParticles(2);
            }
        } else if (this.inGround && this.inGroundTime != 0 && !this.getPotionContents().equals(PotionContentsComponent.DEFAULT) && this.inGroundTime >= 600) {
            this.getWorld().sendEntityStatus(this, (byte) 0);
            this.setStack(URANIUM_ARROW_STACK);
        }
    }

    private void spawnParticles(int amount) {
        int i = this.getColor();
        if (i != -1 && amount > 0) {
            for (int j = 0; j < amount; ++j) {
                this.getWorld()
                    .addParticle(
                        EntityEffectParticleEffect.create(ParticleTypes.ENTITY_EFFECT, i), this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5), 0.0, 0.0, 0.0
                    );
            }
        }
    }
}
