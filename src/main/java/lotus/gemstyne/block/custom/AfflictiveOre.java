package lotus.gemstyne.block.custom;

import lotus.gemstyne.util.GemstyneUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.World;

public class AfflictiveOre extends ExperienceDroppingBlock {
    private final IntProvider experiencedDropped;
    private final RegistryEntry<StatusEffect> effect;
    private final int duration;
    private final GemstyneUtil.BlockTypes type;

    public AfflictiveOre(IntProvider experience, Settings settings, RegistryEntry<StatusEffect> effect, int duration, GemstyneUtil.BlockTypes type) {
        super(experience, settings);
        this.experiencedDropped = experience;
        this.effect = effect;
        this.duration = duration;
        this.type = type;
    }

    /** 
     * @deprecated Minecraft unnecessarily marks methods as deprecated. If you ever encounter a warning against overriding,
     * then know it actually means: "Override this method, don't call."
     */
    @Override
    @Deprecated
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        super.onStacksDropped(state, world, pos, tool, dropExperience);
        if (dropExperience) {
            this.dropExperienceWhenMined(world, pos, tool, this.experiencedDropped);
        }
    }

    /**
     * <code>afflictPlayer</code> is used to handle adding a status effect to a player.
     * <ul>There are only three possible cases:
     *  <li>Pure Blocks</li>
     *  <li>Raw Blocks</li>
     *  <li>Any type of ores.</li>
     * </ul>
     * Duration is calculated using simple multiplication.
     * @param player The Player Entity in the world.
     */
    protected void afflictPlayer(PlayerEntity player) {
        switch(this.type) {
            case PURE -> player.addStatusEffect(new StatusEffectInstance(this.effect, this.duration  * 3, 1));
            case RAW -> player.addStatusEffect(new StatusEffectInstance(this.effect, this.duration * 2, 1));
            default -> player.addStatusEffect(new StatusEffectInstance(this.effect, this.duration, 1));
        }
    }

    /**
     * <code>afflictEntity</code> is called when any Entity, including a Player steps on this block.
     * Similar to <code>afflictPlayer</code>, there are only three possible cases.
     * @param entity The Entity in the world.
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
            afflictPlayer(player);
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
