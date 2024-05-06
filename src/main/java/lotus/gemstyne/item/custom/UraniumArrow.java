package lotus.gemstyne.item.custom;

import lotus.gemstyne.entity.custom.UraniumArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UraniumArrow extends ArrowItem {
    public UraniumArrow(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        UraniumArrowEntity arrowEntity = new UraniumArrowEntity(world, shooter, stack.copyWithCount(1));
        arrowEntity.initFromStack(stack);
        return arrowEntity;
    }
}
