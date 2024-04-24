package lotus.gemstyne.block.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import io.wispforest.owo.util.TagInjector;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.AfflictiveOre;
import lotus.gemstyne.block.custom.RichOre;
import lotus.gemstyne.util.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * {@link BlockSet} contains a group of blocks in one container. {@link Builder} must be used
 * to create an instance of a {@link BlockSet}.
 *
 * <p>All members are encapsulated. {@link BlockSet#fetch} handles errors during
 * initialization, and provides possible clues where things went wrong. Each getter method uses this function internally.</p>
 *
 * @see Builder
 * @see <a href="https://github.com/Noaaan/MythicMetals">...</a>
 */
public final class BlockSet {
    @NotNull private final Map<String, GemstynePairs.BlockPair> blockVariants;
    private static final String BLOCK = "_block";
    @NotNull private final String setName;

    private BlockSet(@NotNull String setName, @NotNull Map<String, GemstynePairs.BlockPair> blockVariants) {
        this.setName = setName;
        this.blockVariants = blockVariants;
    }

    public void generateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.blockVariants.values().forEach(blockIdPair -> blockStateModelGenerator.registerSimpleCubeAll(blockIdPair.block()));
    }

    /**
     * Safely fetches an {@link Block} from {@link BlockSet}. If the Block is not present, then
     * an error message with hints is printed, then a {@link NullPointerException} is thrown.
     * @param blockName Name of target {@link Block}
     * @return Returns {@link Block} safely, or throws a {@link NullPointerException} instead of returning null.
     */
    @NotNull
    private Block fetch(String blockName) {
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
    public @NotNull Block richStoneOre() { return fetch(GemstyneConstants.RICH_STONE); }
    public @NotNull Block deepslateOre() { return fetch(GemstyneConstants.DEEPSLATE); }
    public @NotNull Block richDeepslateOre() { return fetch(GemstyneConstants.RICH_DEEPSLATE); }
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
     * This Builder is used to create a {@link BlockSet}.
     * @see BlockSet
     * @see Builder#start
     * @see GemstyneRegistry
     */
    public static class Builder {
        @NotNull
        private final Map<String, GemstynePairs.BlockPair> variants = new LinkedHashMap<>();
        private final Multimap<Block, Identifier> blockTags = ArrayListMultimap.create();

        private StatusEffect effect;
        private BlockSoundGroup currentSounds = BlockSoundGroup.STONE;
        private float currentHardness = 3.0f;
        private float currentResistance = 3.0f;
        private UniformIntProvider experience = UniformIntProvider.create(2, 5);
        private Identifier miningLevel = GemstyneMiningLevels.NEEDS_STONE_TOOL;
        private FabricBlockSettings blockSettings = FabricBlockSettings.copyOf(Blocks.STONE);
        @NotNull private final String setName;

        /**
         * Direct construction of {@link BlockSet.Builder} is not allowed. Use {@link #start}.
         *
         * @param setName Name of {@link BlockSet}
         */
        private Builder(@NotNull String setName) { this.setName = setName; }

        /**
         * Constructor used to create an instance of {@link Builder}.
         *
         * @param setName Name of {@link BlockSet}
         * @return Returns a new instance of {@link Builder}.
         */
        public static Builder start(String setName) { return new Builder(setName); }

        /**
         * Method to modify strength of {@link BlockSet}.
         *
         * @param hardness   Hardness of BlockSet
         * @param resistance Blast Resistance of BlockSet.
         * @return Returns current instance of {@link BlockSet}
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
         * @return Returns current instance of {@link BlockSet}
         */
        protected Builder setStrength(float hardness) {
            this.currentHardness = hardness;
            this.blockSettings = this.blockSettings.strength(this.currentHardness);
            return this;
        }

        /**
         * Modifies sounds of {@link BlockSet}
         *
         * @param sounds {@link BlockSoundGroup} to be assigned.
         * @return Returns an instance of itself.
         */
        protected Builder setSounds(BlockSoundGroup sounds) {
            this.currentSounds = sounds;
            return this;
        }

        /**
         * Sets experience of {@link BlockSet}.
         *
         * @param min Minimum amount of xp dropped.
         * @param max Maximum amount of xp dropped.
         * @return Returns an instance of itself.
         */
        public Builder setExperience(int min, int max) {
            this.experience = UniformIntProvider.create(min, max);
            return this;
        }

        /**
         * Sets {@link StatusEffect} of {@link BlockSet}
         *
         * @param effect {@link StatusEffect}
         * @return Instance of self.
         */
        public Builder setEffect(StatusEffect effect) {
            this.effect = effect;
            return this;
        }

        public Builder setLevel(Identifier miningLevel) {
            this.miningLevel = miningLevel;
            return this;
        }

        /**
         * Creates a Stone variant for {@link BlockSet}.
         *
         * @return Returns instance of self.
         */
        public Builder createOre() {
            this.variants.put(GemstyneConstants.STONE, new GemstynePairs.BlockPair(this.setName + "_ore", new ExperienceDroppingBlock(this.experience, this.blockSettings)));
            appendTags(GemstyneConstants.STONE, this.miningLevel);
            return this;
        }

        /**
         * Variant of original method to create generic block.
         *
         * @param block Any which implements {@link ExperienceDroppingBlock}
         * @return Returns instance of self.
         */
        public Builder createOre(ExperienceDroppingBlock block) {
            this.variants.put(GemstyneConstants.STONE, new GemstynePairs.BlockPair(this.setName + "_ore", block));
            appendTags(GemstyneConstants.STONE, this.miningLevel);
            return this;
        }

        public Builder createOre(int richAmount, Item richDrops) {
            this.variants.put(GemstyneConstants.RICH_STONE, new GemstynePairs.BlockPair("rich_" + this.setName + "_ore",
                new RichOre(this.blockSettings).init(richAmount, this.experience, richDrops)));
            appendTags(GemstyneConstants.RICH_STONE, this.miningLevel);
            return this;
        }

        /**
         * Creates an unknown ore variant for {@link BlockSet}
         *
         * @param type   Variant
         * @return Returns instance of self.
         */
        public Builder createOreType(String type) {
            this.blockSettings.sounds(getSounds(type)).strength(this.currentHardness);
            this.variants.put(type, new GemstynePairs.BlockPair(type + "_" + this.setName + "_ore", new ExperienceDroppingBlock(this.experience, this.blockSettings)));
            appendTags(type, this.miningLevel);
            return this;
        }

        /**
         * Variation of original method, but instead creates an {@link AfflictiveOre}
         *
         * @param type     Variant
         * @param duration Duration of {@link StatusEffect}
         * @return Returns instance of self.
         */
        public Builder createOreType(String type, int duration) {
            this.blockSettings.sounds(getSounds(type)).strength(this.currentHardness);
            this.variants.put(type, new GemstynePairs.BlockPair(type + "_" + this.setName + "_ore",
                new AfflictiveOre(this.experience, this.blockSettings, this.effect, duration, GemstyneUtil.BlockTypes.ORE)));
            appendTags(type, this.miningLevel);
            return this;
        }

        /**
         * Variation of original method, but instead creates a generic ore with no special parameters.
         *
         * @param type   Variant
         * @param block  Any which extends {@link ExperienceDroppingBlock}
         * @return Returns instance of self.
         */
        public Builder createOreType(String type, ExperienceDroppingBlock block) {
            this.blockSettings.sounds(getSounds(type)).strength(this.currentHardness);
            this.variants.put(type, new GemstynePairs.BlockPair(type + "_" + this.setName + "_ore", block));
            appendTags(type, this.miningLevel);
            return this;
        }

        /**
         * Variation of original method, but instead creates a generic ore with no special parameters.
         *
         * @param type   Variant
         * @return Returns instance of self.
         */
        public Builder createOreType(String type, int richAmount, Item richDrops) {
            this.blockSettings.sounds(getSounds(type)).strength(this.currentHardness);
            this.variants.put(type, new GemstynePairs.BlockPair(type + "_" + this.setName + "_ore",
                new RichOre(this.blockSettings).init(richAmount, this.experience, richDrops)));
            appendTags(type, this.miningLevel);
            return this;
        }

        public Builder createRawBlock() {
            this.blockSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
            this.variants.put("raw", new GemstynePairs.BlockPair("raw_" + this.setName + BLOCK, new Block(this.blockSettings)));
            appendTags(GemstyneConstants.RAW, this.miningLevel);
            return this;
        }

        public Builder createRawBlock(int duration) {
            this.blockSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
            this.variants.put("raw", new GemstynePairs.BlockPair("raw_" + this.setName + BLOCK,
                new AfflictiveBlock(this.blockSettings, this.effect, duration, GemstyneUtil.BlockTypes.RAW)));
            appendTags(GemstyneConstants.RAW, this.miningLevel);
            return this;
        }

        public Builder createPureBlock() {
            this.variants.put("pure", new GemstynePairs.BlockPair(this.setName + BLOCK, new Block(this.blockSettings.sounds(this.currentSounds))));
            appendTags("pure", this.miningLevel);
            return this;
        }

        public Builder createPureBlock(int duration) {
            this.blockSettings.sounds(this.currentSounds);
            this.variants.put("pure", new GemstynePairs.BlockPair(this.setName + BLOCK,
                new AfflictiveBlock(this.blockSettings, this.effect, duration, GemstyneUtil.BlockTypes.PURE)));
            appendTags("pure", this.miningLevel);
            return this;
        }

        public BlockSet createDefaultBlockSet(float strength) {
            return this.setStrength(strength).createOre()
                .setStrength(strength + 1.5f)
                .createOreType(GemstyneConstants.DEEPSLATE)
                .createRawBlock()
                .setStrength(strength + 2.5f)
                .createPureBlock()
                .end();
        }

        public BlockSet createDefaultNetherBlockSet(float strength) {
            return this.setStrength(strength).createOreType("nether")
                .setStrength(strength + 1.5f)
                .createRawBlock()
                .setStrength(strength + 2.5f)
                .createPureBlock()
                .end();
        }

        private void appendTags(String blockType, Identifier miningLevel) {
            this.blockTags.put(this.variants.get(blockType).block(), miningLevel);
            this.blockTags.put(this.variants.get(blockType).block(), GemstyneMiningLevels.NEEDS_PICKAXE);
        }

        private BlockSoundGroup getSounds(String blockType) {
            return switch (blockType) {
                case GemstyneConstants.DEEPSLATE, GemstyneConstants.RICH_DEEPSLATE -> BlockSoundGroup.DEEPSLATE;
                case GemstyneConstants.NETHER -> BlockSoundGroup.NETHER_ORE;
                default -> BlockSoundGroup.STONE;
            };
        }

        /**
         * Used to finalize creation of {@link BlockSet}. Responsible for registering blocks
         * into Minecraft, using a {@link Map} storing a {@link GemstynePairs.BlockPair} containing a String on the left:
         * The ID of the block; On the right: The block itself.
         *
         * @return Returns an instance of {@link BlockSet}.
         */
        public BlockSet end() {
            this.variants.values().forEach(blockPair -> GemstyneRegistry.registerBlock(blockPair.blockID(), blockPair.block()));
            this.blockTags.forEach((block, tag) -> TagInjector.inject(Registries.BLOCK, tag, block));
            return new BlockSet(this.setName, this.variants);
        }
    }
}
