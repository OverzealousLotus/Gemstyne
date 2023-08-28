package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.AfflictiveOre;
import lotus.gemstyne.util.GemstyneBlockTypes;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.*;

public class GemstyneBlockSet {
    private Map<String, ExperienceDroppingBlock> oreVariants = new LinkedHashMap<>();
    private Set<Block> blockSet = new HashSet<>();
    public Block rawBlock;
    public Block pureBlock;

    private StatusEffect effect;
    private BlockSoundGroup currentSounds = BlockSoundGroup.STONE;
    private float currentHardness = 3.0f;
    private float currentResistance = 3.0f;
    private UniformIntProvider experience = UniformIntProvider.create(2, 5);
    private FabricBlockSettings currentSettings = FabricBlockSettings.copyOf(Blocks.STONE);
    private final String SET_NAME;

    public GemstyneBlockSet(String setName) {
        this.SET_NAME = setName;
    }

    /**
     * Method to modify strength of {@link GemstyneBlockSet}
     * @param hardness Hardness of BlockSet
     * @param resistance Blast Resistance of BlockSet.
     * @return Returns current instance of {@link GemstyneBlockSet}
     */
    public GemstyneBlockSet modifyStrength(float hardness, float resistance) {
        this.currentHardness = hardness;
        this.currentResistance = resistance;
        this.currentSettings = this.currentSettings.strength(this.currentHardness, this.currentResistance);
        return this;
    }

    /**
     * Simplified version of <code>modifyStrength</code>
     * @param hardness Hardness of BlockSet
     * @return Returns current instance of {@link GemstyneBlockSet}
     */
    public GemstyneBlockSet modifyStrength(float hardness) {
        this.currentHardness = hardness;
        this.currentSettings = this.currentSettings.strength(this.currentHardness);
        return this;
    }

    /**
     * Modifies sounds of {@link GemstyneBlockSet}
     * @param sounds {@link BlockSoundGroup} to be assigned.
     * @return Returns an instance of itself.
     */
    public GemstyneBlockSet modifySounds(BlockSoundGroup sounds) {
        this.currentSounds = sounds;
        return this;
    }

    /**
     * Sets experience of {@link GemstyneBlockSet}.
     * @param experience Experience dropped by all ores in set.
     * @return Returns an instance of itself.
     */
    public GemstyneBlockSet setExperience(UniformIntProvider experience) {
        this.experience = experience;
        return this;
    }

    /**
     * Sets {@link StatusEffect} of {@link GemstyneBlockSet}
     * @param effect {@link StatusEffect}
     * @return Instance of self.
     */
    public GemstyneBlockSet setEffect(StatusEffect effect) {
        this.effect = effect;
        return this;
    }

    /**
     * Creates a Stone variant for {@link GemstyneBlockSet}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOre() {
        this.oreVariants.put("stone", new ExperienceDroppingBlock(this.currentSettings));
        this.blockSet.add(safelyFetch("stone"));
        GemstyneRegistry.registerBlock(this.SET_NAME + "_ore", this.safelyFetch("stone"));
        return this;
    }

    /**
     * Variant of original method to create generic block
     * @param block Any which implements {@link ExperienceDroppingBlock}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOre(ExperienceDroppingBlock block) {
        this.oreVariants.put("stone", block);
        this.blockSet.add(safelyFetch("stone"));
        GemstyneRegistry.registerBlock(this.SET_NAME + "_ore", this.oreVariants.get("stone"));
        return this;
    }

    /**
     * Creates an unknown ore variant for {@link GemstyneBlockSet}
     * @param type Variant
     * @param sounds {@link BlockSoundGroup}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOreType(String type, BlockSoundGroup sounds) {
        this.currentSettings.sounds(sounds).strength(this.currentHardness);
        this.oreVariants.put(type, new ExperienceDroppingBlock(this.currentSettings, this.experience));
        this.blockSet.add(safelyFetch(type));
        GemstyneRegistry.registerBlock(type + "_" + this.SET_NAME + "_ore", this.oreVariants.get(type));
        return this;
    }

    /**
     * Variation of original method, but instead creates an {@link AfflictiveOre}
     * @param type Variant
     * @param duration Duration of {@link StatusEffect}
     * @param sounds {@link BlockSoundGroup}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOreType(String type, int duration, BlockSoundGroup sounds) {
        this.currentSettings.sounds(sounds).strength(this.currentHardness);
        this.oreVariants.put(type, new AfflictiveOre(this.currentSettings, this.effect,
                duration, GemstyneBlockTypes.ORE, this.experience));
        this.blockSet.add(safelyFetch(type));
        GemstyneRegistry.registerBlock(type + "_" + this.SET_NAME + "_ore", this.oreVariants.get(type));
        return this;
    }

    /**
     * Variation of original method, but instead creates a generic ore with no special parameters.
     * @param type Variant
     * @param block Any which extends {@link ExperienceDroppingBlock}
     * @param sounds {@link BlockSoundGroup}
     * @return Returns instance of self.
     */
    public GemstyneBlockSet createOreType(String type, ExperienceDroppingBlock block, BlockSoundGroup sounds) {
        this.currentSettings.sounds(sounds).strength(this.currentHardness);
        this.oreVariants.put(type, block);
        this.blockSet.add(safelyFetch(type));
        GemstyneRegistry.registerBlock(type + "_" + this.SET_NAME + "_ore", this.oreVariants.get(type));
        return this;
    }

    public GemstyneBlockSet createRawBlock() {
        this.currentSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
        this.rawBlock = new Block(this.currentSettings);
        GemstyneRegistry.registerBlock("raw_" + this.SET_NAME + "_block", this.rawBlock);
        return this;
    }

    public GemstyneBlockSet createRawBlock(int duration) {
        this.currentSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
        this.rawBlock = new AfflictiveBlock(this.currentSettings, this.effect, duration, GemstyneBlockTypes.RAW);
        GemstyneRegistry.registerBlock("raw_" + this.SET_NAME + "_block", this.rawBlock);
        return this;
    }

    public GemstyneBlockSet createPureBlock() {
        this.pureBlock = new Block(this.currentSettings.sounds(this.currentSounds));
        GemstyneRegistry.registerBlock(this.SET_NAME + "_block", this.pureBlock);
        return this;
    }

    public GemstyneBlockSet createPureBlock(int duration) {
        this.currentSettings.sounds(this.currentSounds);
        this.pureBlock = new AfflictiveBlock(this.currentSettings, this.effect, duration, GemstyneBlockTypes.PURE);
        GemstyneRegistry.registerBlock(this.SET_NAME + "_block", this.pureBlock);
        return this;
    }

    public GemstyneBlockSet createDefaultBlockSet(float strength) {
        this.modifyStrength(strength).createOre()
                .modifyStrength(strength + 1.5f)
                .createOreType("deepslate", BlockSoundGroup.DEEPSLATE)
                .createRawBlock()
                .modifyStrength(strength + 2.5f)
                .createPureBlock();
        return this;
    }
    public GemstyneBlockSet createDefaultNetherBlockSet(float strength) {
        return this.modifyStrength(strength).createOreType("nether", BlockSoundGroup.NETHER_ORE)
                .modifyStrength(strength + 1.5f)
                .createRawBlock()
                .modifyStrength(strength + 2.5f)
                .createPureBlock();
    }

    public void generateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.blockSet.forEach(blockStateModelGenerator::registerCubeAllModelTexturePool);
    }

    public GemstyneBlockSet create() {
        return this;
    }

    /**
     * Safely fetches an {@link Block} from {@link GemstyneBlockSet}. If the Block is not present, then
     * an error message with hints is printed, then a {@link NullPointerException} is thrown.
     * @param blockName Name of target {@link Block}
     * @return Returns {@link Block} safely, or throws a {@link NullPointerException} instead of returning null.
     */
    private Block safelyFetch(String blockName) {
        Optional<Block> block = Optional.ofNullable(this.oreVariants.get(blockName));
        if(block.isPresent()) {
            return this.oreVariants.get(blockName);
        } else {
            Gemstyne.LOGGER.error("[[ ERROR: " + blockName + " for set " + this.SET_NAME + " is null!" +
                    " Maybe the Block is improperly initialized?" +
                    " OR the BlockSet was called in an incompatible Method!" +
                    " OTHERWISE the wrong getter was called!");
        }
        throw new NullPointerException();
    }

    public Block stoneOre() {
        return safelyFetch("stone");
    }
    public Block deepslateOre() {
        return safelyFetch("deepslate");
    }
    public Block netherOre() {
        return safelyFetch("nether");
    }
}
