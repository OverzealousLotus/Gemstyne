package lotus.gemstyne.block.entity;

import lotus.gemstyne.effect.EffectHandler;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ThermoTntEntity extends Entity {
    private static final TrackedData<Integer> FUSE = DataTracker.registerData(ThermoTntEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final int DEFAULT_FUSE = 100;

    @Nullable
    protected LivingEntity causingEntity;

    public ThermoTntEntity(EntityType<? extends ThermoTntEntity> entityType, World world) {
        super(entityType, world);
        this.intersectionChecked = true;
    }

    public ThermoTntEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        this(GemstyneBlockEntities.THERMO_TNT_ENTITY, world);
        this.setPosition(x, y, z);
        double d = world.random.nextDouble() * (float) (Math.PI * 2);
        this.setVelocity(-Math.sin(d) * 0.01, 0.2F, -Math.cos(d) * 0.01);
        this.setFuse(DEFAULT_FUSE);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        this.causingEntity = igniter;
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(FUSE, DEFAULT_FUSE);
    }

    @Override
    public void tick() {
        if (!this.hasNoGravity()) {
            this.setVelocity(this.getVelocity().add(0.0, -0.04, 0.0));
        }

        this.move(MovementType.SELF, this.getVelocity());
        this.setVelocity(this.getVelocity().multiply(0.98));
        if (this.isOnGround()) {
            this.setVelocity(this.getVelocity().multiply(0.7, -0.5, 0.7));
        }

        int i = this.getFuse() - 1;
        this.setFuse(i);
        if (i <= 0) {
            this.discard();
            if (!this.getWorld().isClient) {

                if (this.causingEntity != null && (this.getPos().distanceTo(this.causingEntity.getPos()) < 10)) {
                        this.causingEntity.addStatusEffect(new StatusEffectInstance(EffectHandler.WEAK_RADIATION, 200, 1));
                    }
                this.explode();
            }
        } else {
            this.updateWaterState();
            if (this.getWorld().isClient) {
                this.getWorld().addParticle(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY() + getSmokeParticleHeight(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }

    }

    public double getSmokeParticleHeight() {
        return 0.5;
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.setFuse(nbt.getShort("Fuse"));
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putShort("Fuse", (short)this.getFuse());
    }

    protected void explode() {
        this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 8.0F, World.ExplosionSourceType.TNT);
    }

    @Override
    protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.15F;
    }

    public int getFuse() {
        return this.dataTracker.get(FUSE);
    }

    public void setFuse(int fuse) {
        this.dataTracker.set(FUSE, fuse);
    }

    @Nullable
    public LivingEntity getCausingEntity() {
        return this.causingEntity;
    }
}
