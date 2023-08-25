package lotus.gemstyne.block.custom;

import io.wispforest.owo.particles.ClientParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class VolatileOre extends ExperienceDroppingBlock {
    public VolatileOre(Settings settings, IntProvider experience) {
        super(settings, experience);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int chance = world.getDimension().ultrawarm() ? 18 : 5;

        if (random.nextInt(100) <= chance) {
            ClientParticles.setParticleCount(10);
            ClientParticles.spawnCenteredOnBlock(ParticleTypes.SMOKE, world, pos, 3.5D);

        }

        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (world.isClient()) return; // Checks whether this is client-side. If so, return early.

        int chance = world.getDimension().ultrawarm() ? 35 : 7; // Generate base chance based on current dimension.
        Random random = Random.create(); // Create Random Number generator.
        ItemStack tool = player.getMainHandStack(); // Bring Player's current main hand item into scope.

        // Check whether their tool has Silk Touch. If so, decrease explosion chance.
        if (tool.hasEnchantments()) {
            chance -= (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool) * 12);
        }

        // Limit explosion chance to 80%
        chance = MathHelper.clamp(chance, 0, 80);

        // Determine if block should explode.
        if (random.nextInt(100) <= chance && !player.isCreative()) {
            world.removeBlock(pos, false);
            goCritical(world, pos);
        }

        super.onBreak(world, pos, state, player);
    }

    /**
     * Method used to simplify explosion of block.
     * <ul>
     *     <li>Entity represents the "TNT Block" this explosion occurs on. We don't need this here.</li>
     *     <li>X, Y, and Z represent the coordinates of the explosion.</li>
     *     <li>Power is the power of the explosion, or how large it is.</li>
     *     <li>Last parameter is the source of the explosion. In this case, it's a block.</li>
     * </ul>
     * @param world The {@link World} this explosion takes place in.
     * @param pos Current Block's {@link BlockPos}
     */
    private static void goCritical(World world, BlockPos pos) {
        if (world.getDimension().ultrawarm()) {
            world.createExplosion(null, pos.getX(), pos.getY() + 0.6, pos.getZ(), 3.0f, World.ExplosionSourceType.BLOCK);
        } else {
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 0.3f, World.ExplosionSourceType.BLOCK);
        }
    }
}
