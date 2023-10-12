package lotus.gemstyne.block.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import io.wispforest.owo.util.TagInjector;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.AfflictiveOre;
import lotus.gemstyne.util.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * {@link GemstyneBlockSet} contains a group of blocks in one container. {@link Builder} must be used
 * to create an instance of a {@link GemstyneBlockSet}.
 *
 * <p>All members are encapsulated. {@link GemstyneBlockSet#fetch} handles errors during
 * initialization, and provides possible clues where things went wrong. Each getter method uses this function internally.</p>
 *
 * @see Builder
 * @author OverzealousLotus
 */
public class GemstyneBlockSet {
    @NotNull private final Map<String, GemstynePairs.BlockPair> blockVariants;
    private static final String BLOCK = "_block";
    @NotNull private final String setName;

    private GemstyneBlockSet(@NotNull String setName, @NotNull Map<String, GemstynePairs.BlockPair> blockVariants /*ImmutableMultimap<Block, Identifier> blockTags*/) {
        this.setName = setName;
        this.blockVariants = blockVariants;
    }

    public void generateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.blockVariants.values().forEach(blockIdPair -> blockStateModelGenerator.registerSimpleCubeAll(blockIdPair.block()));
    }

    /**
     * Safely fetches an {@link Block} from {@link GemstyneBlockSet}. If the Block is not present, then
     * an error message with hints is printed, then a {@link NullPointerException} is thrown.
     * @param blockName Name of target {@link Block}
     * @return Returns {@link Block} safely, or throws a {@link NullPointerException} instead of returning null.
     */
    @NotNull
    protected Block fetch(String blockName) {
        Optional<Block> block = Optional.ofNullable(this.blockVariants.get(blockName).block());
        if(block.isPresent()) {
            return this.blockVariants.get(blockName).block();
        } else if(Gemstyne.LOGGER.isErrorEnabled()) {
            Gemstyne.LOGGER.error(
                String.format("[[ ERROR: %s for set %s is null! %s %n %s %n %s", blockName, this.setName,
                    "Maybe the Block is improperly initialized?",
                    "OR the BlockSet was called in an incompatible Method!",
                    "OTHERWISE the wrong getter was called!"));
        }
        throw new NullPointerException();
    }

    public @NotNull Block stoneOre() { return fetch(GemstyneConstants.STONE); }
    public @NotNull Block deepslateOre() { return fetch(GemstyneConstants.DEEPSLATE); }
    public @NotNull Block netherOre() { return fetch(GemstyneConstants.NETHER); }
    public @NotNull Block endOre() { return fetch("end"); }
    public @NotNull Block rawBlock() { return fetch("raw"); }
    public @NotNull Block pureBlock() { return fetch("pure"); }
    public @NotNull String getSetName() { return this.setName; }
    public @NotNull Set<Block> getBlockSet() { return this.blockVariants.values().stream().map(GemstynePairs.BlockPair::block).collect(Collectors.toSet()); }
    public @NotNull Map<String, GemstynePairs.BlockPair> getBlockMap() {
        return this.blockVariants;
    }

    /**
     * This Builder is used to create a {@link GemstyneBlockSet}.
     * @see GemstyneBlockSet
     * @see Builder#start
     * @see GemstyneRegistry
     */
    public static class Builder {
        @NotNull
        private final Map<String, GemstynePairs.BlockPair> blockVariants = new LinkedHashMap<>();
        private final Multimap<Block, Identifier> blockTags = ArrayListMultimap.create();

        private StatusEffect effect;
        private BlockSoundGroup currentSounds = BlockSoundGroup.STONE;
        private float currentHardness = 3.0f;
        private float currentResistance = 3.0f;
        private UniformIntProvider experience = UniformIntProvider.create(2, 5);
        private FabricBlockSettings blockSettings = FabricBlockSettings.copyOf(Blocks.STONE);
        @NotNull private final String setName;

        /**
         * Direct construction of {@link GemstyneBlockSet.Builder} is not allowed. Use {@link #start}.
         *
         * @param setName Name of {@link GemstyneBlockSet}
         */
        private Builder(@NotNull String setName) { this.setName = setName; }

        /**
         * Constructor used to create an instance of {@link Builder}.
         *
         * @param setName Name of {@link GemstyneBlockSet}
         * @return Returns a new instance of {@link Builder}.
         */
        public static Builder start(String setName) { return new Builder(setName); }

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
            this.blockSettings = this.blockSettings.strength(this.currentHardness, this.currentResistance);
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
            this.blockSettings = this.blockSettings.strength(this.currentHardness);
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
        public Builder setExperience(UniformIntProvider experience) {
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
        public Builder createOre(Identifier miningLevel) {
            this.blockVariants.put(GemstyneConstants.STONE, new GemstynePairs.BlockPair(this.setName + "_ore", new ExperienceDroppingBlock(this.blockSettings, this.experience)));
            appendTags(GemstyneConstants.STONE, miningLevel);
            return this;
        }

        /**
         * Variant of original method to create generic block.
         *
         * @param block Any which implements {@link ExperienceDroppingBlock}
         * @return Returns instance of self.
         */
        public Builder createOre(ExperienceDroppingBlock block, Identifier miningLevel) {
            this.blockVariants.put(GemstyneConstants.STONE, new GemstynePairs.BlockPair(this.setName + "_ore", block));
            appendTags(GemstyneConstants.STONE, miningLevel);
            return this;
        }

        /**
         * Creates an unknown ore variant for {@link GemstyneBlockSet}
         *
         * @param type   Variant
         * @param sounds {@link BlockSoundGroup}
         * @return Returns instance of self.
         */
        public Builder createOreType(String type, BlockSoundGroup sounds, Identifier miningLevel) {
            this.blockSettings.sounds(sounds).strength(this.currentHardness);
            this.blockVariants.put(type, new GemstynePairs.BlockPair(type + "_" + this.setName + "_ore", new ExperienceDroppingBlock(this.blockSettings, this.experience)));
            appendTags(type, miningLevel);
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
        public Builder createOreType(String type, int duration, BlockSoundGroup sounds, Identifier miningLevel) {
            this.blockSettings.sounds(sounds).strength(this.currentHardness);
            this.blockVariants.put(type, new GemstynePairs.BlockPair(type + "_" + this.setName + "_ore",
                new AfflictiveOre(this.blockSettings, this.effect, duration, GemstyneBlockTypes.ORE, this.experience)));
            appendTags(type, miningLevel);
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
        public Builder createOreType(String type, ExperienceDroppingBlock block, BlockSoundGroup sounds, Identifier miningLevel) {
            this.blockSettings.sounds(sounds).strength(this.currentHardness);
            this.blockVariants.put(type, new GemstynePairs.BlockPair(type + "_" + this.setName + "_ore", block));
            appendTags(type, miningLevel);
            return this;
        }

        public Builder createRawBlock(Identifier miningLevel) {
            this.blockSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
            this.blockVariants.put("raw", new GemstynePairs.BlockPair("raw_" + this.setName + BLOCK, new Block(this.blockSettings)));
            appendTags("raw", miningLevel);
            return this;
        }

        public Builder createRawBlock(int duration, Identifier miningLevel) {
            this.blockSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
            this.blockVariants.put("raw", new GemstynePairs.BlockPair("raw_" + this.setName + BLOCK, new AfflictiveBlock(this.blockSettings, this.effect, duration, GemstyneBlockTypes.RAW)));
            appendTags("raw", miningLevel);
            return this;
        }

        public Builder createPureBlock(Identifier miningLevel) {
            this.blockVariants.put("pure", new GemstynePairs.BlockPair(this.setName + BLOCK, new Block(this.blockSettings.sounds(this.currentSounds))));
            appendTags("pure", miningLevel);
            return this;
        }

        public Builder createPureBlock(int duration, Identifier miningLevel) {
            this.blockSettings.sounds(this.currentSounds);
            this.blockVariants.put("pure", new GemstynePairs.BlockPair(this.setName + BLOCK, new AfflictiveBlock(this.blockSettings, this.effect, duration, GemstyneBlockTypes.PURE)));
            appendTags("pure", miningLevel);
            return this;
        }

        public GemstyneBlockSet createDefaultBlockSet(float strength, Identifier stoneLevel, Identifier deepslateLevel) {
            return this.setStrength(strength).createOre(stoneLevel)
                .setStrength(strength + 1.5f)
                .createOreType(GemstyneConstants.DEEPSLATE, BlockSoundGroup.DEEPSLATE, deepslateLevel)
                .createRawBlock(stoneLevel)
                .setStrength(strength + 2.5f)
                .createPureBlock(deepslateLevel)
                .end();
        }

        public GemstyneBlockSet createDefaultNetherBlockSet(float strength, Identifier miningLevel) {
            return this.setStrength(strength).createOreType("nether", BlockSoundGroup.NETHER_ORE, miningLevel)
                .setStrength(strength + 1.5f)
                .createRawBlock(miningLevel)
                .setStrength(strength + 2.5f)
                .createPureBlock(miningLevel)
                .end();
        }

        private void appendTags(String blockType, Identifier miningLevel) {
            this.blockTags.put(this.blockVariants.get(blockType).block(), miningLevel);
            this.blockTags.put(this.blockVariants.get(blockType).block(), GemstyneMiningLevels.NEEDS_PICKAXE);
        }

        /**
         * Used to finalize creation of {@link GemstyneBlockSet}. Responsible for registering blocks
         * into Minecraft, using a {@link Map} storing a {@link GemstynePairs.BlockPair} containing a String on the left:
         * The ID of the block; On the right: The block itself.
         *
         * @return Returns an instance of {@link GemstyneBlockSet}.
         */
        public GemstyneBlockSet end() {
            this.blockVariants.values().forEach(blockIdPair -> GemstyneRegistry.registerBlock(blockIdPair.blockID(), blockIdPair.block()));
            this.blockTags.forEach((block, level) -> TagInjector.inject(Registries.BLOCK, level, block));
            return new GemstyneBlockSet(this.setName, this.blockVariants);
        }
    }
}