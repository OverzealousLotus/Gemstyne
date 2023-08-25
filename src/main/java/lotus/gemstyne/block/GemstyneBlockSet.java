package lotus.gemstyne.block;

import lotus.gemstyne.util.GemstyneBlockTypes;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class GemstyneBlockSet {
    public ExperienceDroppingBlock stoneOre;
    public ExperienceDroppingBlock deepslateOre;
    public ExperienceDroppingBlock netherOre;
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

    public GemstyneBlockSet createOre() {
        this.stoneOre = GemstyneBlockHandler.assignOreBlock(this.currentSettings, this.experience);
        GemstyneBlockHandler.registerBlock(this.SET_NAME + "_ore", this.stoneOre);
        return this;
    }

    public GemstyneBlockSet createOreType(GemstyneBlockTypes type) {
        switch(type) {
            case DEEPSLATE_ORE -> {
                this.currentSettings.sounds(BlockSoundGroup.DEEPSLATE).strength(this.currentHardness);
                this.deepslateOre = GemstyneBlockHandler.assignOreBlock(this.currentSettings, this.experience);
                GemstyneBlockHandler.registerBlock("deepslate_" + this.SET_NAME + "_ore", this.deepslateOre);
            }
            case NETHER_ORE -> {
                this.currentSettings.sounds(BlockSoundGroup.NETHER_ORE).strength(this.currentHardness);
                this.netherOre = GemstyneBlockHandler.assignOreBlock(this.currentSettings, this.experience);
                GemstyneBlockHandler.registerBlock("nether_" + this.SET_NAME + "_ore", this.netherOre);
            }
        }

        return this;
    }

    public GemstyneBlockSet createOreType(GemstyneBlockTypes type, int duration) {
        switch(type) {
            case STONE_ORE -> {
                this.stoneOre = GemstyneBlockHandler.assignOreBlock(this.currentSettings, this.effect,
                        duration, GemstyneBlockTypes.ORE, this.experience);
                GemstyneBlockHandler.registerBlock(this.SET_NAME + "_ore", this.stoneOre);
            }
            case DEEPSLATE_ORE -> {
                this.currentSettings.sounds(BlockSoundGroup.DEEPSLATE).strength(this.currentHardness);
                this.deepslateOre = GemstyneBlockHandler.assignOreBlock(this.currentSettings, this.effect,
                        duration, type, this.experience);
                GemstyneBlockHandler.registerBlock("deepslate_" + this.SET_NAME + "_ore", this.deepslateOre);
            }
            case NETHER_ORE -> {
                this.currentSettings.sounds(BlockSoundGroup.NETHER_ORE).strength(this.currentHardness);
                this.netherOre = GemstyneBlockHandler.assignOreBlock(this.currentSettings, this.effect,
                        duration, type, this.experience);
                GemstyneBlockHandler.registerBlock("nether_" + this.SET_NAME + "_ore", this.netherOre);
            }
        }

        return this;
    }

    public GemstyneBlockSet createRawBlock() {
        this.currentSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
        this.rawBlock = GemstyneBlockHandler.assignBlock(this.currentSettings);
        GemstyneBlockHandler.registerBlock("raw_" + this.SET_NAME + "_block", this.rawBlock);
        return this;
    }

    public GemstyneBlockSet createRawBlock(int duration) {
        this.currentSettings.sounds(this.currentSounds).strength(this.currentHardness, this.currentResistance);
        this.rawBlock = GemstyneBlockHandler.assignBlock(this.currentSettings, this.effect,
                duration, GemstyneBlockTypes.RAW);
        GemstyneBlockHandler.registerBlock("raw_" + this.SET_NAME + "_block", this.rawBlock);
        return this;
    }

    public GemstyneBlockSet createPureBlock() {
        this.pureBlock = GemstyneBlockHandler.assignBlock(this.currentSettings.sounds(this.currentSounds));
        GemstyneBlockHandler.registerBlock(this.SET_NAME + "_block", this.pureBlock);
        return this;
    }

    public GemstyneBlockSet createPureBlock(int duration) {
        this.currentSettings.sounds(this.currentSounds);
        this.pureBlock = GemstyneBlockHandler.assignBlock(this.currentSettings, this.effect,
                duration, GemstyneBlockTypes.PURE);
        GemstyneBlockHandler.registerBlock(this.SET_NAME + "_block", this.pureBlock);
        return this;
    }

    public GemstyneBlockSet createDefaultBlockSet(float strength) {
        this.modifyStrength(strength).createOre()
                .modifyStrength(strength + 1.5f)
                .createOreType(GemstyneBlockTypes.DEEPSLATE_ORE)
                .createRawBlock()
                .modifyStrength(strength + 2.5f)
                .createPureBlock();
        return this;
    }

    public GemstyneBlockSet createDefaultNetherBlockSet(float strength) {
        this.modifyStrength(strength).createOreType(GemstyneBlockTypes.NETHER_ORE)
                .modifyStrength(strength + 1.5f)
                .createRawBlock()
                .modifyStrength(strength + 2.5f)
                .createPureBlock();
        return this;
    }

    public GemstyneBlockSet create() {
        return this;
    }
}
