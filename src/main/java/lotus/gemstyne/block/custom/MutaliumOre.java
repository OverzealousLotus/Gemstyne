package lotus.gemstyne.block.custom;

import com.google.common.collect.ImmutableList;
import io.wispforest.owo.particles.ClientParticles;
import lotus.gemstyne.util.GemstyneColorUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class MutaliumOre extends VolatileOre {
    private static final ImmutableList<StatusEffect> effectList = ImmutableList.of(
        StatusEffects.RESISTANCE, StatusEffects.REGENERATION, StatusEffects.SATURATION,
        StatusEffects.MINING_FATIGUE, StatusEffects.POISON, StatusEffects.HUNGER
    );

    public MutaliumOre(Settings settings, IntProvider experience) {
        super(settings, experience);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int chance = random.nextInt(12);

        // f = Size of particles
        // deviation = Deviation from spawn point.
        if (chance >= random.nextInt(100)) {
            ClientParticles.setParticleCount(random.nextBetweenExclusive(1, 5));
            ClientParticles.spawnCenteredOnBlock(new DustParticleEffect(GemstyneColorUtil.Colors.MUTALIUM_PALLETE.get(random.nextInt(3)), 0.8F), world, pos, 1.3D);
        }

        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!world.isClient() && !player.isCreative()) {
            Random random = Random.create();

            player.addStatusEffect(new StatusEffectInstance(effectList.get(random.nextInt(3)), random.nextBetweenExclusive(30, 120)));
        }

        super.onBreak(world, pos, state, player);
    }
}
