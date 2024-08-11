package lotus.gemstyne.block.custom;

import lotus.gemstyne.block.entity.ThermoTntEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TntBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class ThermoTntBlock extends TntBlock {
    public ThermoTntBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock()) && world.isReceivingRedstonePower(pos)) {
            prime(world, pos);
            world.removeBlock(pos, false);
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            prime(world, pos);
            world.removeBlock(pos, false);
        }
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (!world.isClient) {
            ThermoTntEntity thermoTnt = new ThermoTntEntity(world, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, explosion.getCausingEntity());
            int i = thermoTnt.getFuse();
            thermoTnt.setFuse((short)(world.random.nextInt(i / 4) + i / 8));
            world.spawnEntity(thermoTnt);
        }
    }


    public static void prime(World world, BlockPos pos) {
        prime(world, pos, null);
    }

    private static void prime(World world, BlockPos pos, @Nullable LivingEntity igniter) {
        if (!world.isClient) {
            ThermoTntEntity thermoTnt = new ThermoTntEntity(world, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, igniter);
            world.spawnEntity(thermoTnt);
            world.playSound(
                null, thermoTnt.getX(), thermoTnt.getY(), thermoTnt.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F
            );
            world.emitGameEvent(igniter, GameEvent.PRIME_FUSE, pos);
        }
    }

    @Override
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos position, PlayerEntity player, Hand hand, BlockHitResult result) {
        ItemStack itemStack = player.getStackInHand(player.preferredHand);
        if (!itemStack.isOf(Items.FLINT_AND_STEEL) && !itemStack.isOf(Items.FIRE_CHARGE)) {
            return super.onUseWithItem(stack, state, world, position, player, hand, result);
        } else {
            prime(world, position, player);
            world.setBlockState(position, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            Item item = itemStack.getItem();
            if (!player.isCreative()) {
                if (itemStack.isOf(Items.FLINT_AND_STEEL)) {
                    itemStack.damage(1, player, EquipmentSlot.MAINHAND);
                } else {
                    itemStack.decrement(1);
                }
            }

            player.incrementStat(Stats.USED.getOrCreateStat(item));
            return ItemActionResult.success(world.isClient);
        }
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient) {
            BlockPos blockPos = hit.getBlockPos();
            Entity entity = projectile.getOwner();
            if (projectile.isOnFire() && projectile.canModifyAt(world, blockPos)) {
                prime(world, blockPos, entity instanceof LivingEntity ? (LivingEntity)entity : null);
                world.removeBlock(blockPos, false);
            }
        }

    }
}
