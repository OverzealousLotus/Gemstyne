package lotus.gemstyne.world;

import com.google.common.collect.*;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.util.BlockSet;
import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.util.GemstynePairs.GenKeyPair;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Pair;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class GemstyneOreModification {
    private static final RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private static final RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
    private static final RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

    private final Map<String, GenKeyPair> oreKeys = new LinkedHashMap<>();
    private final BlockSet oreSet;
    private final Multimap<String, OreFeatureConfig.Target> oreMap = LinkedHashMultimap.create();
    private final Set<Block> ores = new LinkedHashSet<>();
    private final List<OreFeatureConfig.Target> targets = new LinkedList<>();

    public GemstyneOreModification(BlockSet oreSet) {
        this.oreSet = oreSet;
    }

    /**
     * Adds {@link BlockTags#STONE_ORE_REPLACEABLES} to ore generation.
     * @return Returns instance of self.
     */
    protected GemstyneOreModification addStoneOre() {
        this.oreMap.put(GemstyneConstants.OVERWORLD, OreFeatureConfig.createTarget(stoneReplaceables, oreSet.stoneOre().getDefaultState()));
        this.ores.add(oreSet.stoneOre());
        return this;
    }

    protected GemstyneOreModification addRichStoneOre() {
        this.oreMap.put("rich_overworld", OreFeatureConfig.createTarget(stoneReplaceables, oreSet.richStoneOre().getDefaultState()));
        this.ores.add(oreSet.richStoneOre());
        return this;
    }

    /**
     * Adds {@link BlockTags#DEEPSLATE_ORE_REPLACEABLES} to ore Generation.
     * @return Returns instance of self.
     */
    protected GemstyneOreModification addDeepslateOre() {
        this.oreMap.put(GemstyneConstants.OVERWORLD, OreFeatureConfig.createTarget(deepslateReplaceables, oreSet.deepslateOre().getDefaultState()));
        this.ores.add(oreSet.deepslateOre());
        return this;
    }

    protected GemstyneOreModification addRichDeepslateOre() {
        this.oreMap.put("rich_overworld", OreFeatureConfig.createTarget(deepslateReplaceables, oreSet.richDeepslateOre().getDefaultState()));
        this.ores.add(oreSet.richDeepslateOre());
        return this;
    }

    /**
     * Adds {@link BlockTags#BASE_STONE_NETHER} to ore Generation.
     * @return Returns instance of self.
     */
    protected GemstyneOreModification addNetherOre() {
        this.oreMap.put(GemstyneConstants.NETHER, OreFeatureConfig.createTarget(netherReplaceables, oreSet.netherOre().getDefaultState()));
        this.ores.add(oreSet.netherOre());
        return this;
    }

    /**
     * Adds end stone to ore Generation.
     * @return Returns instance of self.
     */
    protected GemstyneOreModification addEndOre() {
        this.oreMap.put(GemstyneConstants.END, OreFeatureConfig.createTarget(endReplaceables, oreSet.endOre().getDefaultState()));
        this.ores.add(oreSet.endOre());
        return this;
    }

    protected GemstyneOreModification addRawOre() {
        this.ores.forEach(ore -> this.targets.add(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ore), oreSet.rawBlock().getDefaultState())));
        return this;
    }

    /**
     * Creates a key {@link Pair}
     * @param configKeyName {@link ConfiguredFeature} key.
     * @param placedKeyName {@link PlacedFeature} key.
     * @return Returns instance of self.
     */
    protected GemstyneOreModification createKeyPair(String configKeyName, String placedKeyName) {
        this.oreKeys.put(configKeyName, new GenKeyPair(
            GemstyneConfiguredFeatures.registerKey("ore_" + oreSet.getSetName() + "_" + configKeyName),
            GemstynePlacedFeatures.registerKey("ore_" + oreSet.getSetName() + "_" + placedKeyName))
        );

        return this;
    }

    /**
     * Creates a key {@link Pair} with very similar names.
     * @param keyNames Name of keys to be created.
     * @return Returns instance of self.
     */
    protected GemstyneOreModification createKeyPair(String keyNames) {
        this.oreKeys.put(keyNames, new GenKeyPair(
            GemstyneConfiguredFeatures.registerKey("ore_" + oreSet.getSetName() + "_" + keyNames),
            GemstynePlacedFeatures.registerKey("ore_" + oreSet.getSetName() + "_" + keyNames))
        );

        return this;
    }

    /**
     * Registers a {@link PlacedFeature} using {@link GemstyneOrePlacement#modifiersWithCount}
     * @param context Context... Don't ask me.
     * @param keyName Name of key Pair. Configured Key name.
     * @param veinsPerChunk Amount of veins per chunk.
     * @param modifier Height Range and shape of ore spawns. See {@link HeightRangePlacementModifier}
     */
    public void placedFeatureCount(Registerable<PlacedFeature> context, String keyName, int veinsPerChunk, HeightRangePlacementModifier modifier) {
        GemstynePlacedFeatures.register(context, fetchPlacedKey(keyName), GemstynePlacedFeatures.fetchConfig(context,
            fetchConfiguredKey(keyName)), GemstyneOrePlacement.modifiersWithCount(veinsPerChunk, modifier));
    }

    /**
     * Registers a {@link PlacedFeature} using {@link GemstyneOrePlacement#modifiersWithRarity}
     * @param context Context... Don't ask me.
     * @param keyName Name of key Pair. Configured Key name.
     * @param rarity Rarity of the ores. Higher is rarer.
     * @param modifier Height Range and shape of ore spawns. See {@link HeightRangePlacementModifier}
     */
    public void placedFeatureRarity(Registerable<PlacedFeature> context, String keyName, int rarity, HeightRangePlacementModifier modifier) {
        GemstynePlacedFeatures.register(context, fetchPlacedKey(keyName), GemstynePlacedFeatures.fetchConfig(context,
            fetchConfiguredKey(keyName)), GemstyneOrePlacement.modifiersWithRarity(rarity, modifier));
    }

    /**
     * Registers {@link ConfiguredFeature}
     * @param context Context... Don't ask me.
     * @param keyName Target key for features. For example, small, or large.
     * @param veinsSize Size of ore veins.
     * @param discardOnAirChance Chance of veins being discarded when exposed to air.
     */
    public void overworldConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context, String keyName, int veinsSize, float discardOnAirChance, boolean isRaw) {
        if (isRaw) {
            GemstyneConfiguredFeatures.register(context, fetchConfiguredKey(keyName), Feature.ORE, new OreFeatureConfig(
                this.targets, veinsSize, discardOnAirChance));
        } else {
            GemstyneConfiguredFeatures.register(context, fetchConfiguredKey(keyName), Feature.ORE, new OreFeatureConfig(
                this.oreMap.get(GemstyneConstants.OVERWORLD).stream().toList(), veinsSize, discardOnAirChance));
        }
    }

    /**
     * Registers {@link ConfiguredFeature}
     * @param context Context... Don't ask me.
     * @param keyName Target key for features. For example, small, or large.
     * @param veinsSize Size of ore veins.
     * @param discardOnAirChance Chance of veins being discarded when exposed to air.
     */
    public void overworldConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context, String keyName, int veinsSize, float discardOnAirChance, boolean isRaw, String targets) {
        if (isRaw) {
            GemstyneConfiguredFeatures.register(context, fetchConfiguredKey(keyName), Feature.ORE, new OreFeatureConfig(
                this.targets, veinsSize, discardOnAirChance));
        } else {
            GemstyneConfiguredFeatures.register(context, fetchConfiguredKey(keyName), Feature.ORE, new OreFeatureConfig(
                this.oreMap.get(targets).stream().toList(), veinsSize, discardOnAirChance));
        }
    }

    /**
     * Registers {@link ConfiguredFeature}
     * @param context Context... Don't ask me.
     * @param keyName Target key for features. For example, small, or large.
     * @param veinsSize Size of ore veins.
     * @param discardOnAirChance Chance of veins being discarded when exposed to air.
     */
    public void netherConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context, String keyName, int veinsSize, float discardOnAirChance) {
        GemstyneConfiguredFeatures.register(context, fetchConfiguredKey(keyName), Feature.ORE, new OreFeatureConfig(
            this.oreMap.get(GemstyneConstants.NETHER).stream().toList(), veinsSize, discardOnAirChance));
    }

    /**
     * Registers {@link ConfiguredFeature}
     * @param context Context... Don't ask me.
     * @param keyName Target key for features. For example, small, or large.
     * @param veinsSize Size of ore veins.
     * @param discardOnAirChance Chance of veins being discarded when exposed to air.
     */
    public void endConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context, String keyName, int veinsSize, float discardOnAirChance) {
        GemstyneConfiguredFeatures.register(context, fetchConfiguredKey(keyName), Feature.ORE, new OreFeatureConfig(
            this.oreMap.get(GemstyneConstants.END).stream().toList(), veinsSize, discardOnAirChance));
    }

    /**
     * Tries to fetch a {@link ConfiguredFeature} key. Throws {@link NullPointerException} if it is not found.
     * @param keyName Name of key to fetch.
     * @return Returns key.
     */
    public RegistryKey<ConfiguredFeature<?, ?>> fetchConfiguredKey(String keyName) {
        Optional<RegistryKey<ConfiguredFeature<?, ?>>> key = Optional.ofNullable(this.oreKeys.get(keyName).configKey());
        if(key.isPresent()) {
            return key.get();
        } else {
            Gemstyne.LOGGER.error(
                String.format("[[ ERROR: %s  for configured feature %s is null! %s %n %s %n %s", keyName, this.oreSet.getSetName(),
                    "Maybe the key is improperly initialized?",
                    "OR a duplicate key was created!",
                    "OTHERWISE check the spelling of your key entries!"));
        }
        throw new NullPointerException();
    }

    /**
     * Tries to fetch a {@link PlacedFeature} key. Throws {@link NullPointerException} if it is not found.
     * @param keyName Name of key to fetch.
     * @return Returns Placed Key.
     */
    public  RegistryKey<PlacedFeature> fetchPlacedKey(String keyName) {
        Optional<RegistryKey<PlacedFeature>> key = Optional.ofNullable(this.oreKeys.get(keyName).placedKey());
        if(key.isPresent()) {
            return key.get();
        } else {
            Gemstyne.LOGGER.error(
                String.format("[[ ERROR: %s key for placed feature %s is null! %s %n %s %n %s", keyName, this.oreSet.getSetName(),
                    "Maybe the Key is improperly initialized?",
                    "OR a duplicate key was created!",
                    "OTHERWISE check the spelling of your key entry!"));
        }
        throw new NullPointerException();
    }

    protected static class OreFlags {
        @Nullable public Boolean isRaw;
        @Nullable public Boolean isRich;

        private OreFlags() { }

        public OreFlags empty() {
            return this;
        }

        public OreFlags of(Boolean isRaw, Boolean isRich) {
            this.isRaw = isRaw;
            this.isRich = isRich;
            return this;
        }
    }
}
