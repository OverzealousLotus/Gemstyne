package lotus.gemstyne.block.custom;

import lotus.gemstyne.util.GemstyneBlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;

public class AfflictiveOre extends AfflictiveBlock {
    private final IntProvider experiencedDropped;

    public AfflictiveOre(Settings settings, StatusEffect effect, int base_duration, int raw_duration, int pure_duration, GemstyneBlockTypes type, IntProvider experience) {
        super(settings, effect, base_duration, raw_duration, pure_duration, type);
        this.experiencedDropped = experience;
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        super.onStacksDropped(state, world, pos, tool, dropExperience);
        if (dropExperience) {
            this.dropExperienceWhenMined(world, pos, tool, this.experiencedDropped);
        }
    }
}
