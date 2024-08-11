package lotus.gemstyne.block.custom;

import io.wispforest.owo.particles.ClientParticles;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.Objects;

/**
 * {@link VolatileOre} Provides an explosive surprise for players when broken.
 * <ul>Extensibility
 *  <li>Override {@link VolatileOre#goCritical(World, BlockPos)} to modify explosions.</li>
 *  <li>Override {@link VolatileOre#explosionChance(World, PlayerEntity)} to modify explosion chances.</li>
 * </ul>
 */
public class VolatileOre extends ExperienceDroppingBlock {
    public VolatileOre(IntProvider experience, Settings settings) {
        super(experience, settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int chance = world.getDimension().ultrawarm() ? 18 : 5;

        if (random.nextInt(100) <= chance) {
            ClientParticles.setParticleCount(10);
            ClientParticles.spawnCenteredOnBlock(ParticleTypes.SMOKE, world, pos, 2.0D);
        }

        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        // Guard statement to prevent this from running client side, peaceful mode, or when Player is in Creative.
        if (!world.isClient() && !player.isCreative() && !Objects.equals(world.getDifficulty().getName(), "peaceful")) {
            Random random = Random.create(); // Create Random Number generator.

            // Determine if block should explode.
            if (random.nextInt(100) <= explosionChance(world, player)) {
                world.removeBlock(pos, false);
                goCritical(world, pos);
            }
        }

        return super.onBreak(world, pos, state, player);
    }

    /**
     * Provides an extensible way to determine the chances of an explosion by overriding
     * this method in any class which extends {@link VolatileOre}.
     * @param world {@link World}
     * @param player {@link PlayerEntity}
     * @return Returns the chance of an explosion.
     */
    public static int explosionChance(World world, PlayerEntity player) {
        int chance = world.getDimension().ultrawarm() ? 35 : 7; // Generate base chance based on current dimension.
        // ItemStack tool = player.getMainHandStack(); // Bring Player's current main hand item into scope.

        // Check whether their tool has Silk Touch. If so, decrease explosion chance.
        // if(tool.hasEnchantments()) chance -= (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool) * 12);

        // Limit explosion chance to 80%
        chance = MathHelper.clamp(chance, 0, 80);

        return chance;
    }

    /**
     * Determines logic of block explosion.
     * <ul>
     *     <li>Entity represents the "TNT Block" this explosion occurs on. We don't need this here.</li>
     *     <li>X, Y, and Z represent the coordinates of the explosion.</li>
     *     <li>Power is the power of the explosion, or how large it is.</li>
     *     <li>Last parameter is the source of the explosion. In this case, it's a block.</li>
     * </ul>
     * @param world The {@link World} this explosion takes place in.
     * @param pos Current Block's {@link BlockPos}
     */
    protected void goCritical(World world, BlockPos pos) {
        if (world.getDimension().ultrawarm()) {
            world.createExplosion(null, pos.getX(), pos.getY() + 0.6, pos.getZ(), 3.2f, World.ExplosionSourceType.BLOCK);
        } else {
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 0.3f, World.ExplosionSourceType.BLOCK);
        }
    }
}
