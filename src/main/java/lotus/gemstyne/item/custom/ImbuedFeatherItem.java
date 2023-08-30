package lotus.gemstyne.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ImbuedFeatherItem extends Item {
    // Used to inherit settings from the Item class.
    public ImbuedFeatherItem(Settings settings) {
        super(settings);
    }

    // Overriding the "use" function from the Item class.
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // Bring our item into scope.
        if (!world.isClient() && !user.isCreative()) {
            itemStack.damage(2, user, p -> p.sendToolBreakStatus(hand)); // Decreases durability.
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 130));
            user.getItemCooldownManager().set(this, 100); // Set cooldown for item usage.
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        tooltip.add(Text.translatable("tooltip.gemstyne.imbued_feather"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
