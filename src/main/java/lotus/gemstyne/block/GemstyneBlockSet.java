package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.AfflictiveOre;
import lotus.gemstyne.util.BlockPair;
import lotus.gemstyne.util.GemstyneBlockTypes;
import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * {@link GemstyneBlockSet} contains a group of blocks in one container. {@link Builder} must be used
 * to create an instance of a {@link GemstyneBlockSet}.
 *
 * <p>All members are encapsulated. {@link GemstyneBlockSet#safelyFetch} handles errors during
 * initialization, and provides possible clues where things went wrong. Each getter method uses this function internally.</p>
 *
 * @see Builder
 * @author OverzealousLotus
 */
public class GemstyneBlockSet {
    private final Map<String, BlockPair> blockVariants;
    private static final String BLOCK = "_block";
    @NotNull private final String setName;

    private GemstyneBlockSet(@NotNull String setName, Map<String, BlockPair> blockVariants) {
        this.setName = setName;
        this.blockVariants = blockVariants;
    }

    public void generateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.blockVariants.values().forEach(blockIdPair -> blockStateModelGenerator.registerCubeAllModelTexturePool(blockIdPair.getBlock()));
    }

    /**
     * Safely fetches an {@link Block} from {@link GemstyneBlockSet}. If the Block is not present, then
     * an error message with hints is printed, then a {@link NullPointerException} is thrown.
     * @param blockName Name of target {@link Block}
     * @return Returns {@link Block} safely, or throws a {@link NullPointerException} instead of returning null.
     */
    private Block safelyFetch(String blockName) {
        Optional<Block> block = Optional.ofNullable(this.blockVariants.get(blockName).getBlock());
        if(block.isPresent()) {
            return this.blockVariants.get(blockName).getBlock();
        } else if(Gemstyne.LOGGER.isErrorEnabled()) {
            Gemstyne.LOGGER.error(
                String.format("[[ ERROR: %s for set %s is null! %s %n %s %n %s", blockName, this.setName,
                    "Maybe the Block is improperly initialized?",
                    "OR the BlockSet was called in an incompatible Method!",
                    "OTHERWISE the wrong getter was called!"));
        }
        throw new NullPointerException();
    }

    public Block stoneOre() { return safelyFetch(GemstyneConstants.STONE); }
    public Block deepslateOre() { return safelyFetch(GemstyneConstants.DEEPSLATE); }
    public Block netherOre() { return safelyFetch(GemstyneConstants.NETHER); }
    public Block endOre() { return safelyFetch("end"); }
    public Block rawBlock() { return safelyFetch("raw"); }
    public Block pureBlock() { return safelyFetch("pure"); }
    public @NotNull String getSetName() { return this.setName; }
    public Set<Block> getBlockSet() { return this.blockVariants.values().stream().map(BlockPair::getBlock).collect(Collectors.toSet()); }

    /**
     * This Builder is used to create a {@link GemstyneBlockSet}.
     * @see GemstyneBlockSet
     * @see Builder#start
     * @see GemstyneRegistry
     */
    public static class Builder {
        @NotNull
        private final Map<String, BlockPair> blockVariants = new LinkedHashMap<>();

        private StatusEffect effect;
        private BlockSoundGroup currentSounds = BlockSoundGroup.STONE;
        private float currentHardness = 3.0f;
        private float currentResistance = 3.0f;
        private UniformIntProvider experience = UniformIntProvider.create(2, 5);
        private FabricBlockSettings currentSettings = FabricBlockSettings.copyOf(Blocks.STONE);
        @NotNull private final String setName;

        /**
         * Direct construction of {@link GemstyneBlockSet.Builder} is not allowed. Use {@link #start}.
         *
         * @param setName Name of {@link GemstyneBlockSet}
         */
        private Builder(@NotNull String setName) {
            this.setName = setName;
        }

        /**
         * Constructor used to create an instance of {@link Builder}.
         *
         * @param setName Name of {@link GemstyneBlockSet}
         * @return Returns a new instance of {@link Builder}.
         */
        public static Builder start(String setName) {
            return new Builder(setName);
        }

        /**
         * Method to modify strength of {@link GemstyneBlockSet}.
         *
         * @param hardness   Hardness of BlockSet
         * @param resistance Blast Resistance of BlockSet.
         * @return Returns current instance of {@link GemstyneBlockSet}
         */
        public Builder setStrength(float hardness, float resistance) {
            this.currentHardness = hardness;
            this.currentResistance = resistance;
            this.currentSettings = this.currentSettings.strength(this.currentHardness, this.currentResistance);
            return this;
        }

        /**
         * Simplified version of {@link Builder#setStrength}
         *
         * @param hardness Hardness of BlockSet
         * @return Returns current instance of {@link GemstyneBlockSet}
         */
        protected Builder setStrength(float hardness) {
            this.currentHardness = hardness;
            this.currentSettings = this.currentSettings.strength(this.currentHardness);
            return this;
        }

        /**
         * Modifies sounds of {@link GemstyneBlockSet}
         *
         * @param sounds {@link BlockSoundGroup} to be assigned.
         * @return Returns an instance of itself.
         */
        protected Builder setSounds(BlockSoundGroup sounds) {
            this.currentSounds = sounds;
            return this;
        }

        /**
         * Sets experience of {@link GemstyneBlockSet}.
         *
         * @param experience Experience dropped by all ores in set.
         * @return Returns an instance of itself.
         */
        protected Builder setExperience(UniformIntProvider experience) {
            this.experience = experience;
            return this;
        }

        /**
         * Sets {@link StatusEffect} of {@link GemstyneBlockSet}
         *
         * @param effect {@link StatusEffect}
         * @return Instance of self.
         */
        public Builder setEffect(StatusEffect effect) {
            this.effect = effect;
            return this;
        }

        /**
         * Creates a Stone variant for {@link GemstyneBlockSet}.
         *
         * @return Returns instance of self.
         */
        public Builder createOre() {
            this.blockVariants.put(GemstyneConstants.STONE, new BlockPair(this.setName + "_ore", new ExperienceDroppingBlock(this.currentSettings, this.experience)));
            return this;
        }

        /**
         * Variant of original method to create generic block.
         *
         * @param block Any which implements {@link ExperienceDroppingBlock}
         * @return Returns instance of self.
         */
        public Builder createOre(ExperienceDroppingBlock block) {
            this.blockVariants.put(GemstyneConstants.STONE, new BlockPair(this.setName + "_ore", block));
            return this;
        }

        /**
         * Creates an unknown ore variant for {@link GemstyneBlockSet}
         *
         * @param type   Variant
         * @param sounds {@link BlockSoundGroup}
         * @return Returns instance of self.
         */
        public Builder createOreType(String type, BlockSoundGroup sounds) {
            this.currentSettings.sounds(sounds).strength(this.currentHardness);
            this.blockVariants.put(type, new BlockPair(type + "_" + this.setName + "_ore", new ExperienceDroppingBlock(this.currentSettings, this.experience)));
            return this;
        }

        /**
         * Variation of original method, but instead creates an {@link AfflictiveOre}
         *
         * @param type     Variant
         * @param duration Duration of {@link StatusEffect}
         * @param sounds   {@link BlockSoundGroup}
         * @return Returns instance of self.
         */
        public Builder createOreType(String type, int duration, BlockSoundGroup sounds) {
            this.currentSettings.sounds(sounds).strength(this.currentHardness);
            this.blockVariants.put(type, new BlockPair(type + "_" + this.setName + "_ore",
                new AfflictiveOre(this.currentSettings, this.effect, duration, GemstyneBlockTypes.ORE, this.experience)));
            return this;
        }

        /**
         * Variation of original method, but instead creates a generic ore with no special parameters.
         *
         * @param type   Variant
         * @param block  Any which extends {@link ExperienceDroppingBlock}
         * @param sounds {@link BlockSoundGroup}
         * @return Returns instance of self.
         */
        public Builder createOreType(String type, ExperienceDroppingBlock block, BlockSoundGroup sounds) {
            this.currentSettings.sounds(sounds).strength(this.currentHardness);
            this.blockVariants.put(type, new BlockPair(type + "_" + this.setName + "_ore", block));
            return this;
        }

        public Builder createRawBlock() {
            this.currentSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
            this.blockVariants.put("raw", new BlockPair("raw_" + this.setName + BLOCK, new Block(this.currentSettings)));
            return this;
        }

        public Builder createRawBlock(int duration) {
            this.currentSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
            this.blockVariants.put("raw", new BlockPair("raw_" + this.setName + BLOCK, new AfflictiveBlock(this.currentSettings, this.effect, duration, GemstyneBlockTypes.RAW)));
            return this;
        }

        public Builder createPureBlock() {
            this.blockVariants.put("pure", new BlockPair(this.setName + BLOCK, new Block(this.currentSettings.sounds(this.currentSounds))));
            return this;
        }

        public Builder createPureBlock(int duration) {
            this.currentSettings.sounds(this.currentSounds);
            this.blockVariants.put("pure", new BlockPair(this.setName + BLOCK, new AfflictiveBlock(this.currentSettings, this.effect, duration, GemstyneBlockTypes.PURE)));
            return this;
        }

        public GemstyneBlockSet createDefaultBlockSet(float strength) {
            return this.setStrength(strength).createOre()
                .setStrength(strength + 1.5f)
                .createOreType(GemstyneConstants.DEEPSLATE, BlockSoundGroup.DEEPSLATE)
                .createRawBlock()
                .setStrength(strength + 2.5f)
                .createPureBlock()
                .end();
        }

        public GemstyneBlockSet createDefaultNetherBlockSet(float strength) {
            return this.setStrength(strength).createOreType("nether", BlockSoundGroup.NETHER_ORE)
                .setStrength(strength + 1.5f)
                .createRawBlock()
                .setStrength(strength + 2.5f)
                .createPureBlock()
                .end();
        }

        /**
         * Used to finalize creation of {@link GemstyneBlockSet}. Responsible for registering blocks
         * into Minecraft, using a {@link Map} storing a {@link BlockPair} containing a String on the left:
         * The ID of the block; On the right: The block itself.
         *
         * @return Returns an instance of {@link GemstyneBlockSet}.
         */
        public GemstyneBlockSet end() {
            this.blockVariants.values().forEach(blockIdPair -> GemstyneRegistry.registerBlock(blockIdPair.getBlockID(), blockIdPair.getBlock()));
            return new GemstyneBlockSet(this.setName, this.blockVariants);
        }
    }
}
