package lotus.gemstyne.block.custom;

import lotus.gemstyne.util.GemstyneUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;

public class AfflictiveOre extends ExperienceDroppingBlock {
    private final IntProvider experiencedDropped;

    public AfflictiveOre(IntProvider experience, Settings settings, StatusEffect effect, int duration, GemstyneUtil.BlockTypes type) {
        super(experience, settings);
        this.experiencedDropped = experience;
    }

    /** 
     * @deprecated Minecraft unnecessarily marks methods as deprecated. If you ever encounter a warning against overriding,
     * then know it actually means: "Override this method, don't call."
     */
    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        super.onStacksDropped(state, world, pos, tool, dropExperience);
        if (dropExperience) {
            this.dropExperienceWhenMined(world, pos, tool, this.experiencedDropped);
        }
    }
}
