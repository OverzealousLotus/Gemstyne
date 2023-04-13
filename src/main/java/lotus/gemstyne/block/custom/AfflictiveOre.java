package lotus.gemstyne.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;

public class AfflictiveOre extends AfflictiveBlock {
    private final IntProvider experiencedDropped;

    public AfflictiveOre(Settings settings, IntProvider experience) {
        super(settings);
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
