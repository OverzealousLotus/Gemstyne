package lotus.gemstyne.world;

import com.google.common.collect.*;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneBlockSet;
import lotus.gemstyne.util.GemstyneConstants;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Pair;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import java.util.*;

public class GemstyneOreModification {
    private final Map<String, Pair<RegistryKey<ConfiguredFeature<?, ?>>, RegistryKey<PlacedFeature>>> oreKeys = new LinkedHashMap<>();
    private final GemstyneBlockSet oreSet;
    private final Multimap<String, OreFeatureConfig.Target> oreMap = LinkedHashMultimap.create();

    private final String name;
    public GemstyneOreModification(String name, GemstyneBlockSet oreSet) {
        this.name = name;
        this.oreSet = oreSet;
    }

    /**
     * Adds {@link BlockTags#STONE_ORE_REPLACEABLES} to ore generation.
     * @return Returns instance of self.
     */
    protected GemstyneOreModification addStoneOre() {
        this.oreMap.put(GemstyneConstants.OVERWORLD, OreFeatureConfig.createTarget(stoneReplaceables, oreSet.stoneOre().getDefaultState()));
        return this;
    }

    /**
     * Adds {@link BlockTags#DEEPSLATE_ORE_REPLACEABLES} to ore Generation.
     * @return Returns instance of self.
     */
    protected GemstyneOreModification addDeepslateOre() {
        this.oreMap.put(GemstyneConstants.OVERWORLD, OreFeatureConfig.createTarget(deepslateReplaceables, oreSet.deepslateOre().getDefaultState()));
        return this;
    }

    /**
     * Adds {@link BlockTags#BASE_STONE_NETHER} to ore Generation.
     * @return
     */
    protected GemstyneOreModification addNetherOre() {
        this.oreMap.put(GemstyneConstants.NETHER, OreFeatureConfig.createTarget(netherReplaceables, oreSet.netherOre().getDefaultState()));
        return this;
    }

    /**
     * Creates a key {@link Pair}
     * @param configKeyName {@link ConfiguredFeature} key.
     * @param placedKeyName {@link PlacedFeature} key.
     * @return Returns instance of self.
     */
    protected GemstyneOreModification createKeyPair(String configKeyName, String placedKeyName) {
        this.oreKeys.put(configKeyName, new Pair<>(
            GemstyneConfiguredFeatures.registerKey("ore_" + oreSet.getSetName() + "_" + configKeyName),
            GemstynePlacedFeatures.registerKey("ore_" + oreSet.getSetName() + "_" + placedKeyName))
        );

        return this;
    }

    /**
     * Registers {@link PlacedFeature}
     * @param context Context... Don't ask me.
     * @param which Target Key for features. For example, small, or upper.
     * @param veinsPerChunk Amount of veins per chunk.
     * @param modifier Height Range and shape of ore spawns. See {@link HeightRangePlacementModifier}
     */
    public void registerPlacedFeatures(Registerable<PlacedFeature> context, String which, int veinsPerChunk, HeightRangePlacementModifier modifier) {
        GemstynePlacedFeatures.register(context, fetchPlacedKey(which), GemstynePlacedFeatures.fetchConfig(context,
            fetchConfiguredKey(which)), GemstyneOrePlacement.modifiersWithCount(veinsPerChunk, modifier));
    }

    /**
     * Registers {@link ConfiguredFeature}
     * @param context Context... Don't ask me.
     * @param which Target key for features. For example, small, or large.
     * @param veinsSize Size of ore veins.
     * @param discardOnAirChance Chance of veins being discarded when exposed to air.
     */
    public void registerConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context, String which, int veinsSize, float discardOnAirChance) {
        GemstyneConfiguredFeatures.register(context, fetchConfiguredKey(which), Feature.ORE, new OreFeatureConfig(
            this.oreMap.get(GemstyneConstants.OVERWORLD).stream().toList(), veinsSize, discardOnAirChance));
    }

    /**
     * Tries to fetch a {@link ConfiguredFeature} key. Throws {@link NullPointerException} if it is not found.
     * @param keyName Name of key to fetch.
     * @return Returns key.
     */
    public RegistryKey<ConfiguredFeature<?, ?>> fetchConfiguredKey(String keyName) {
        Optional<RegistryKey<ConfiguredFeature<?, ?>>> key = Optional.ofNullable(this.oreKeys.get(keyName).getLeft());
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
        Optional<RegistryKey<PlacedFeature>> key = Optional.ofNullable(this.oreKeys.get(keyName).getRight());
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

    private static final RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private static final RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
}
