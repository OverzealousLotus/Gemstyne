package lotus.gemstyne.block.custom;

import lotus.gemstyne.util.GemstyneUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AfflictiveBlock extends Block {
    // Instantiate parameters of Block.
    private final RegistryEntry<StatusEffect> effect;
    private final int duration;
    private final GemstyneUtil.BlockTypes type;

    public AfflictiveBlock(Settings settings, RegistryEntry<StatusEffect> effect, int duration, GemstyneUtil.BlockTypes type) {
        super(settings);
        this.effect = effect;
        this.duration = duration;
        this.type = type;
    }

    /**
     * Adds a {@link StatusEffect} to a given entity. The strength is dependent on the type of block
     * interacted with.
     * @param entity Target entity
     */
    protected void afflictEntity(LivingEntity entity) {
        switch(this.type) {
            case PURE -> entity.addStatusEffect(new StatusEffectInstance(this.effect, this.duration * 3, 1));
            case RAW -> entity.addStatusEffect(new StatusEffectInstance(this.effect, this.duration * 2, 1));
            default -> entity.addStatusEffect(new StatusEffectInstance(this.effect, this.duration, 1));
        }
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && !player.isSpectator() && !player.isCreative()) {
            afflictEntity(player);
        }

        return super.onBreak(world, pos, state, player);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        if (!world.isClient() &&  (entity instanceof LivingEntity livingEntity &&  (!livingEntity.isSpectator()))) {
            afflictEntity(livingEntity);
        }
    }
}
