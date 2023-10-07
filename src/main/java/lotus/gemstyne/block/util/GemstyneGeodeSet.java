package lotus.gemstyne.block.util;

import com.google.common.collect.ImmutableSet;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.BuddingCrystallineBlock;
import lotus.gemstyne.block.custom.CrystallineBlockBud;
import lotus.gemstyne.util.GemstynePairs.CrystallinePair;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.sound.BlockSoundGroup;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

public final class GemstyneGeodeSet {
    @NotNull private final Map<String, CrystallinePair> geodeVariants = new LinkedHashMap<>();
    private ImmutableSet<Block> budSet;

    private static final String CLUSTER = "cluster";
    private static final String LARGE = "large";
    private static final String MEDIUM = "medium";
    private static final String SMALL = "small";
    private static final String BUDDING = "budding";
    private static final String BLOCK = "block";

    private final String setName;
    private final FabricBlockSettings currentSettings = FabricBlockSettings.create().requiresTool()
            .ticksRandomly().nonOpaque().strength(1.5f, 1.0f)
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(state -> 5);

    public GemstyneGeodeSet(String setName) {
        this.setName = setName;
    }

    public GemstyneGeodeSet modifyLuminance(int luminance) {
        this.currentSettings.luminance(state -> luminance);
        return this;
    }

    public GemstyneGeodeSet modifySounds(BlockSoundGroup sounds) {
        this.currentSettings.sounds(sounds);
        return this;
    }

    public GemstyneGeodeSet modifyStrength(float strength) {
        this.currentSettings.strength(strength);
        return this;
    }

    public GemstyneGeodeSet createGeodeType(String size, int height, int offset) {
        this.geodeVariants.put(size, new CrystallinePair(size + "_" + this.setName + "_bud", new CrystallineBlockBud(height, offset, this.currentSettings)));
        return this;
    }

    public GemstyneGeodeSet createCluster(int height, int offset) {
        this.geodeVariants.put(CLUSTER, new CrystallinePair(this.setName + "_cluster", new CrystallineBlockBud(height, offset, this.currentSettings)));
        return this;
    }

    public GemstyneGeodeSet createBudding() {
        this.geodeVariants.put(BUDDING, new CrystallinePair("budding_"+ this.setName, new BuddingCrystallineBlock(this.currentSettings, this)));
        return this;
    }

    public void createBlock() {
        this.geodeVariants.put(BLOCK, new CrystallinePair(this.setName + "_block", new AmethystBlock(this.currentSettings)));
    }

    /**
     * Uses a <code>forEach</code> loop to dynamically generate models of buds. Pure and Budding Block
     * are also generated, but only Pure Block can possibly be null. A simple check is made to prevent
     * a null registration. This should be called within {@link lotus.gemstyne.data.models.GemstyneGeodeModels}
     * @param blockStateModelGenerator {@link BlockStateModelGenerator}
     */
    public void generateBlockModels(BlockStateModelGenerator blockStateModelGenerator, boolean isVanilla) {
        this.budSet().forEach(blockStateModelGenerator::registerAmethyst);
        if(!isVanilla) blockStateModelGenerator.registerCubeAllModelTexturePool(this.safelyFetch(BLOCK));
        blockStateModelGenerator.registerCubeAllModelTexturePool(this.safelyFetch(BUDDING));
    }

    /**
     * Similar to <code>generateBlockModels</code>, but instead for bud item.s If the same method is used,
     * then bud items look very strange when held.
     * @param itemModelGenerator {@link ItemModelGenerator}
     */
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        this.budSet().forEach(item -> itemModelGenerator.register(item.asItem(), Models.GENERATED));
    }

    public GemstyneGeodeSet createDefaultGeodeSet(boolean isVanilla) {
        if(!isVanilla) this.createBlock();
        return this.createCluster(7, 3)
                .modifySounds(BlockSoundGroup.LARGE_AMETHYST_BUD).modifyLuminance(4)
                .createGeodeType(LARGE, 5, 3)
                .modifySounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).modifyLuminance(2)
                .createGeodeType(MEDIUM, 4, 3)
                .modifySounds(BlockSoundGroup.SMALL_AMETHYST_BUD).modifyLuminance(1)
                .createGeodeType(SMALL, 3, 4)
                .modifySounds(BlockSoundGroup.AMETHYST_BLOCK).modifyStrength(3.0f)
                .createBudding().create();
    }

    /**
     * Finalization of a {@link GemstyneGeodeSet}. Creates an {@link ImmutableSet} of buds.
     * @return Returns an instance of self.
     */
    public GemstyneGeodeSet create() {
        this.geodeVariants.values().forEach(geodePair -> GemstyneRegistry.registerBlock(geodePair.blockID(), geodePair.block()));
        this.budSet = ImmutableSet.of(
                safelyFetch(SMALL),
                safelyFetch(MEDIUM),
                safelyFetch(LARGE),
                safelyFetch(CLUSTER)
        );
        return this;
    }

    private Block safelyFetch(String geodeName) {
        Optional<Block> geode = Optional.ofNullable(this.geodeVariants.get(geodeName).block());
        if(geode.isPresent()) {
            return this.geodeVariants.get(geodeName).block();
        } else if(Gemstyne.LOGGER.isErrorEnabled()) {
            Gemstyne.LOGGER.error(String.format("[[ ERROR: %s for set %s is null! %s %n %s %n %s", geodeName, this.setName,
                    "Maybe the Geode Block is improperly initialized?",
                    "OR the GeodeSet was called in an incompatible Method!",
                    "OTHERWISE the wrong getter was called!"));
        }
        throw new NullPointerException();
    }

    public Block clusterBud() { return safelyFetch(CLUSTER); }
    public Block largeBud() { return safelyFetch(LARGE); }
    public Block mediumBud() { return safelyFetch(MEDIUM); }
    public Block smallBud() { return safelyFetch(SMALL); }
    public Block pureBlock() { return safelyFetch(BLOCK); }
    public Block buddingBlock() { return safelyFetch(BUDDING); }
    /**
     * @return Returns an {@link ImmutableSet} of geode buds from {@link GemstyneGeodeSet}
     */
    public ImmutableSet<Block> budSet() { return this.budSet; }
    /**
     * @return Returns an {@link ImmutableSet} of all geode blocks from {@link GemstyneGeodeSet}
     */
    public ImmutableSet<Block> geodeSet() { return ImmutableSet.copyOf(this.geodeVariants.values().stream().map(CrystallinePair::block).collect(Collectors.toSet())); }
}
