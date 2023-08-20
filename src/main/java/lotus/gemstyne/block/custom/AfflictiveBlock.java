package lotus.gemstyne.block.custom;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.util.GemstyneBlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class AfflictiveBlock extends ExperienceDroppingBlock {
    // Instantiate parameters of Block.
    private final StatusEffect effect;
    private final int base_duration;
    private final int raw_duration;
    private final int pure_duration;
    private final GemstyneBlockTypes type;

    public AfflictiveBlock(Settings settings, StatusEffect effect, int base_duration, int raw_duration, int pure_duration, GemstyneBlockTypes type) {
        super(settings);
        this.effect = effect;
        this.base_duration = base_duration;
        this.raw_duration = raw_duration;
        this.pure_duration = pure_duration;
        this.type = type;
    }
    // <===== Used to cause damage when any player starts breaking anything Uranium related. =====>
    protected void afflictPlayer(PlayerEntity player, BlockState state) {

        if (Objects.equals(getBlockType(), GemstyneBlockTypes.RAW)) {
            player.addStatusEffect(new StatusEffectInstance(this.effect, this.raw_duration, 1));
        } else if (Objects.equals(getBlockType(), GemstyneBlockTypes.PURE)) {
            player.addStatusEffect(new StatusEffectInstance(this.effect, this.pure_duration, 1));
        } else {
            player.addStatusEffect(new StatusEffectInstance(this.effect, this.base_duration, 1));
        }
    }

    protected GemstyneBlockTypes getBlockType() {
        return type;
    }

    // <===== If anything other than the player steps on a AfflictiveBlock, then same logic. =====>
    protected void afflictEntity(LivingEntity entity, BlockState state) {

        if (state.isOf(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE)) { // Check to see what block is broken.
            entity.addStatusEffect(new StatusEffectInstance(GemstyneEffects.IRRADIATE, 30, 1));
        } else if (state.isOf(GemstyneOreBlocks.RAW_URANIUM_BLOCK)) {
            entity.addStatusEffect(new StatusEffectInstance(GemstyneEffects.IRRADIATE, 60, 1));
        } else if (state.isOf(GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock())) {
            entity.addStatusEffect(new StatusEffectInstance(GemstyneEffects.IRRADIATE, 100, 1));
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

        if (!world.isClient() && !player.isSpectator() && !player.isCreative()) {
            afflictPlayer(player, state);
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        if (!world.isClient()) {
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isSpectator()) {afflictEntity(livingEntity, state);}
            }
        }

    }
}
