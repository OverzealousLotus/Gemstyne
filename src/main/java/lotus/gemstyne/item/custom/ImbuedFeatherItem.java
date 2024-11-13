package lotus.gemstyne.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class ImbuedFeatherItem extends Item {
    // Used to inherit settings from the Item class.
    public ImbuedFeatherItem(Settings settings) {
        super(settings);
    }

    // Overriding the "use" function from the Item class.
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && !user.isCreative()) {
            ItemStack itemStack = user.getStackInHand(hand); // Bring our item into scope.
            itemStack.damage(2, user, EquipmentSlot.MAINHAND); // Decreases durability.
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 130));
            user.getItemCooldownManager().set(this, 100); // Set cooldown for item usage.
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltips.gemstyne.imbued_feather"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
