package lotus.gemstyne.item.custom;

import lotus.gemstyne.entity.custom.UraniumArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class UraniumArrow extends ArrowItem {
    public UraniumArrow(Item.Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new UraniumArrowEntity(world, shooter, stack, shotFrom);
    }
}
