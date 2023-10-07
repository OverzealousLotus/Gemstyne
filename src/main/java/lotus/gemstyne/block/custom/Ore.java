package lotus.gemstyne.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.util.math.intprovider.IntProvider;

public class Ore extends ExperienceDroppingBlock {
    public Ore(Settings settings, IntProvider experience) {
        super(settings, experience);
    }

    /**
     * Builder method for {@link Ore}. This class is subject to change, and primarily exists to prevent methods
     * from being accessed once it is finished constructing an instance of {@link Ore}.
     */
    public static class Builder {
        private Settings settings = FabricBlockSettings.copyOf(Blocks.IRON_ORE);
        private final IntProvider experience;

        private Builder(IntProvider experience) {
            this.experience = experience;
        }

        public static Builder start(IntProvider experience) {
            return new Builder(experience);
        }
        public Builder settings(AbstractBlock settings) {
            this.settings = FabricBlockSettings.copyOf(settings);
            return this;
        }
        public Ore end() {
            return new Ore(this.settings, this.experience);
        }
    }
}
