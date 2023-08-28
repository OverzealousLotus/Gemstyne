package lotus.gemstyne.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.BuddingCrystallineBlock;
import lotus.gemstyne.block.custom.CrystallineBlockBud;
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

public final class GemstyneGeodeSet {
    public Map<String, AmethystBlock> geodeVariants = new LinkedHashMap<>();
    private ImmutableSet<AmethystBlock> budSet;

    private final String SET_NAME;
    private final FabricBlockSettings currentSettings = FabricBlockSettings.create().requiresTool()
            .ticksRandomly().nonOpaque().strength(1.5f, 1.0f)
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(state -> 5);

    public GemstyneGeodeSet(String setName) {
        this.SET_NAME = setName;
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
        this.geodeVariants.put(size, new CrystallineBlockBud(height, offset, this.currentSettings));
        GemstyneRegistry.registerBlock(size + "_" + this.SET_NAME + "_bud", safelyFetch(size));
        return this;
    }

    public GemstyneGeodeSet createCluster(int height, int offset) {
        this.geodeVariants.put("cluster", new CrystallineBlockBud(height, offset, this.currentSettings));
        GemstyneRegistry.registerBlock(this.SET_NAME + "_cluster", safelyFetch("cluster"));
        return this;
    }

    public GemstyneGeodeSet createBudding() {
        this.geodeVariants.put("budding", new BuddingCrystallineBlock(this.currentSettings, ImmutableList.of(
                safelyFetch("small"),
                safelyFetch("medium"),
                safelyFetch("large"),
                safelyFetch("cluster")
        )));
        GemstyneRegistry.registerBlock("budding_" + this.SET_NAME, safelyFetch("budding"));
        return this;
    }

    public void createBlock() {
        this.geodeVariants.put("block", new AmethystBlock(this.currentSettings));
        GemstyneRegistry.registerBlock(this.SET_NAME + "_block", safelyFetch("block"));
    }

    /**
     * Uses a <code>forEach</code> loop to dynamically generate models of buds. Pure and Budding Block
     * are also generated, but only Pure Block can possibly be null. A simple check is made to prevent
     * a null registration. This should be called within {@link lotus.gemstyne.data.models.GemstyneGeodeModels}
     * @param blockStateModelGenerator {@link BlockStateModelGenerator}
     */
    public void generateBlockModels(BlockStateModelGenerator blockStateModelGenerator, boolean isVanilla) {
        this.budSet().forEach(blockStateModelGenerator::registerAmethyst);
        if(!isVanilla) blockStateModelGenerator.registerCubeAllModelTexturePool(this.safelyFetch("block"));
        blockStateModelGenerator.registerCubeAllModelTexturePool(this.safelyFetch("budding"));
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
                .createGeodeType("large", 5, 3)
                .modifySounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).modifyLuminance(2)
                .createGeodeType("medium", 4, 3)
                .modifySounds(BlockSoundGroup.SMALL_AMETHYST_BUD).modifyLuminance(1)
                .createGeodeType("small", 3, 4)
                .modifySounds(BlockSoundGroup.AMETHYST_BLOCK).modifyStrength(3.0f)
                .createBudding().create();
    }

    /**
     * Finalization of a {@link GemstyneGeodeSet}. Creates an {@link ImmutableSet} of buds.
     * @return Returns an instance of self.
     */
    public GemstyneGeodeSet create() {
        this.budSet = ImmutableSet.of(
                this.geodeVariants.get("small"),
                this.geodeVariants.get("medium"),
                this.geodeVariants.get("large"),
                this.geodeVariants.get("cluster")
        );
        return this;
    }

    private Block safelyFetch(String geodeName) {
        Optional<Block> geode = Optional.ofNullable(this.geodeVariants.get(geodeName));
        if(geode.isPresent()) {
            return this.geodeVariants.get(geodeName);
        } else {
            Gemstyne.LOGGER.error("[[ ERROR: " + geodeName + " for set " + this.SET_NAME + " is null!" +
                    " Maybe the Geode Block is improperly initialized?" +
                    " OR the GeodeSet was called in an incompatible Method!" +
                    " OTHERWISE the wrong getter was called!");
        }
        throw new NullPointerException();
    }

    public Block clusterBud() { return safelyFetch("cluster"); }
    public Block largeBud() { return safelyFetch("large"); }
    public Block mediumBud() { return safelyFetch("medium"); }
    public Block smallBud() { return safelyFetch("small"); }
    public Block pureBlock() { return safelyFetch("block"); }
    public Block buddingBlock() { return safelyFetch("budding"); }
    public ImmutableSet<AmethystBlock> budSet() { return this.budSet; }
}
