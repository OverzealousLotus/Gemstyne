package lotus.gemstyne.block.custom;

import io.wispforest.owo.particles.ClientParticles;
import lotus.gemstyne.util.GemstyneUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class TorriumOre extends VolatileOre {
    public TorriumOre(IntProvider experience, Settings settings) {
        super(experience, settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int chance = random.nextInt(15);

        // f = Size of particles
        // deviation = Deviation from spawn point.
        if (chance >= random.nextInt(100)) {
            ClientParticles.setParticleCount(3);
            ClientParticles.spawnCenteredOnBlock(new DustParticleEffect(GemstyneUtil.Colors.TORRIUM, 0.8F), world, pos, 1.3D);
        }
    }
}
