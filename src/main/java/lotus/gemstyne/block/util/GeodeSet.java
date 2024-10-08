package lotus.gemstyne.block.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import io.wispforest.owo.util.TagInjector;
import lotus.gemstyne.Overwatch;
import lotus.gemstyne.block.custom.BuddingCrystallineBlock;
import lotus.gemstyne.block.custom.CrystallineBlockBud;
import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.util.GemstyneMiningLevels;
import lotus.gemstyne.util.GemstynePairs.CrystallinePair;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;

import java.util.*;
import java.util.stream.Collectors;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public final class GeodeSet {
    private final Map<String, CrystallinePair> geodeVariants;

    private final String setName;

    private GeodeSet(String setName, Map<String, CrystallinePair> variants) {
        this.setName = setName;
        this.geodeVariants = variants;
    }

    /**
     * Uses a <code>forEach</code> loop to dynamically generate models of buds. Pure and Budding Block
     * are also generated, but only Pure Block can possibly be null. A simple check is made to prevent
     * a null registration. This should be called within {@link lotus.gemstyne.data.models.GemstyneGeodeModels}
     * @param blockStateModelGenerator {@link BlockStateModelGenerator}
     */
    public void generateBlockModels(BlockStateModelGenerator blockStateModelGenerator, boolean isVanilla) {
        this.getBudSet().forEach(blockStateModelGenerator::registerAmethyst);
        if(!isVanilla) blockStateModelGenerator.registerCubeAllModelTexturePool(this.fetch(GemstyneConstants.BLOCK));
        blockStateModelGenerator.registerCubeAllModelTexturePool(this.fetch(GemstyneConstants.BUDDING));
    }

    /**
     * Similar to <code>generateBlockModels</code>, but instead for bud item.s If the same method is used,
     * then bud items look very strange when held.
     * @param itemModelGenerator {@link ItemModelGenerator}
     */
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        this.getBudSet().forEach(item -> itemModelGenerator.register(item.asItem(), Models.GENERATED));
    }

    public Block clusterBud() { return fetch(GemstyneConstants.CLUSTER); }
    public Block largeBud() { return fetch(GemstyneConstants.LARGE); }
    public Block mediumBud() { return fetch(GemstyneConstants.MEDIUM); }
    public Block smallBud() { return fetch(GemstyneConstants.SMALL); }
    public Block pureBlock() { return fetch(GemstyneConstants.BLOCK); }
    public Block buddingBlock() { return fetch(GemstyneConstants.BUDDING); }
    public String getSetName() { return this.setName; }
    /**
     * @return Returns an {@link ImmutableSet} of geode buds from {@link GeodeSet}
     */
    public ImmutableSet<Block> getBudSet() {
        /*return ImmutableSet.copyOf(this.geodeVariants.entrySet().stream().filter(map -> switch(map.getKey()) {
            case GemstyneConstants.BLOCK, GemstyneConstants.BUDDING -> false;
            default -> true;
        }).map(entry -> entry.getValue().block()).collect(Collectors.toSet()));*/
        return ImmutableSet.of(smallBud(), mediumBud(), largeBud(), clusterBud());
    }

    /**
     * @return Returns an {@link ImmutableSet} of all geode blocks from {@link GeodeSet}
     */
    public ImmutableSet<Block> geodeSet() { return ImmutableSet.copyOf(this.geodeVariants.values().stream().map(CrystallinePair::block).collect(Collectors.toSet())); }
    public Map<String, CrystallinePair> getGeodeMap() { return this.geodeVariants; }

    private Block fetch(String geodeName) {
        Optional<Block> geode = Optional.ofNullable(this.geodeVariants.get(geodeName).block());
        if(geode.isPresent()) {
            return this.geodeVariants.get(geodeName).block();
        } else {
            Overwatch.error(String.format("[[ ERROR: %s for set %s is null! %s %n %s %n %s", geodeName, this.setName,
                "Maybe the Geode Block is improperly initialized?",
                "OR the GeodeSet was called in an incompatible Method!",
                "OTHERWISE the wrong getter was called!"));
        }
        throw new NullPointerException();
    }

    public static class Builder {
        @NotNull private final Map<String, CrystallinePair> variants = new LinkedHashMap<>();
        private final Multimap<Block, Identifier> blockTags = ArrayListMultimap.create();

        private final String setName;
        private Identifier miningLevel = GemstyneMiningLevels.NEEDS_STONE_TOOL;
        private final AbstractBlock.Settings currentSettings = AbstractBlock.Settings.create().requiresTool()
            .ticksRandomly().nonOpaque().strength(1.5f, 1.0f)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1);

        private Builder(String setName) { this.setName = setName; }

        public static Builder start(String setName) {
            return new Builder(setName);
        }

        public Builder level(Identifier miningLevel) {
            this.miningLevel = miningLevel;
            return this;
        }

        public Builder luminance(int luminance) {
            this.currentSettings.luminance(state -> luminance);
            return this;
        }

        public Builder sounds(BlockSoundGroup sounds) {
            this.currentSettings.sounds(sounds);
            return this;
        }

        public Builder strength(float strength) {
            this.currentSettings.strength(strength);
            return this;
        }

        public Builder newBud(String size, int height, int offset) {
            this.variants.put(size, new CrystallinePair(size + "_" + this.setName + "_bud", new CrystallineBlockBud(height, offset, this.currentSettings)));
            appendTags(size, this.miningLevel);
            return this;
        }

        /**
         * Creates a new Bud Cluster.
         * @param height Height of the Bud Cluster.
         * @param offset Base offset of the Cluster on a block.
         * @return Returns new instance of self.
         */
        public Builder newCluster(int height, int offset) {
            this.variants.put(GemstyneConstants.CLUSTER, new CrystallinePair(this.setName + "_cluster", new CrystallineBlockBud(height, offset, this.currentSettings)));
            appendTags(GemstyneConstants.CLUSTER, this.miningLevel);
            return this;
        }

        public void createBlock() {
            this.variants.put(GemstyneConstants.BLOCK, new CrystallinePair(this.setName + "_block", new AmethystBlock(this.currentSettings)));
            appendTags(GemstyneConstants.BLOCK, this.miningLevel);
        }

        private void appendTags(String blockType, Identifier miningLevel) {
            this.blockTags.put(this.variants.get(blockType).block(), miningLevel);
            this.blockTags.put(this.variants.get(blockType).block(), GemstyneMiningLevels.NEEDS_PICKAXE);
        }

        public GeodeSet createDefaultSet(boolean isVanilla) {
            if(!isVanilla) this.createBlock();
            return this.newBud(GemstyneConstants.SMALL, 3, 4)
                .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(4)
                .newBud(GemstyneConstants.LARGE, 5, 3)
                .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(2)
                .newBud(GemstyneConstants.MEDIUM, 4, 3)
                .sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5)
                .newCluster(7, 3)
                .sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(3.0f)
                .end();
        }

        /**
         * Finalization of a {@link GeodeSet}. Creates an {@link ImmutableSet} of buds.
         * @return Returns an instance of self.
         */
        public GeodeSet end() {
            this.variants.put(GemstyneConstants.BUDDING, new CrystallinePair("budding_" + this.setName,
                new BuddingCrystallineBlock(this.currentSettings, this.variants)));
            appendTags(GemstyneConstants.BUDDING, this.miningLevel);

            this.variants.values().forEach(geodePair -> GemstyneRegistry.registerBlock(geodePair.blockID(), geodePair.block()));
            this.blockTags.forEach((block, tag) -> TagInjector.inject(Registries.BLOCK, tag, block));
            return new GeodeSet(this.setName, this.variants);
        }
    }
}
