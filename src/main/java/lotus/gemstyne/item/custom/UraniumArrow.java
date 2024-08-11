package lotus.gemstyne.item.custom;

import lotus.gemstyne.entity.custom.UraniumArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class UraniumArrow extends ArrowItem {
    public UraniumArrow(Item.Settings settings) { super(settings); }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new UraniumArrowEntity(world, shooter, stack, shotFrom);
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        var entity = new UraniumArrowEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1), null);
        entity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return entity;
    }

    @Override
    public ProjectileItem.Settings getProjectileSettings() {
        return new ProjectileItem.Settings.Builder()
            .power(1.4f)
            .uncertainty(5.0f)
            .build();
    }
}
