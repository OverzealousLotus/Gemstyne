package lotus.gemstyne.world;

import com.google.common.collect.*;
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
    private Map<String, Pair<RegistryKey<ConfiguredFeature<?, ?>>, RegistryKey<PlacedFeature>>> oreKeys = new LinkedHashMap<>();
    private final GemstyneBlockSet oreSet;
    private Multimap<String, OreFeatureConfig.Target> oreMap = LinkedHashMultimap.create();

    private final String name;
    public GemstyneOreModification(String name, GemstyneBlockSet oreSet) {
        this.name = name;
        this.oreSet = oreSet;
    }

    protected GemstyneOreModification addStoneOre() {
        this.oreMap.put("overworld", OreFeatureConfig.createTarget(stoneReplaceables, oreSet.stoneOre().getDefaultState()));
        return this;
    }

    protected GemstyneOreModification addDeepslateOre() {
        this.oreMap.put("overworld", OreFeatureConfig.createTarget(deepslateReplaceables, oreSet.deepslateOre().getDefaultState()));
        return this;
    }

    protected GemstyneOreModification addNetherOre() {
        this.oreMap.put(GemstyneConstants.NETHER, OreFeatureConfig.createTarget(netherReplaceables, oreSet.netherOre().getDefaultState()));
        return this;
    }

    protected GemstyneOreModification createKeyPair(String configKeyName, String placedKeyName) {
        this.oreKeys.put(configKeyName, new Pair<>(
            GemstyneConfiguredFeatures.registerKey("ore_" + oreSet.getSetName() + "_" + configKeyName),
            GemstynePlacedFeatures.registerKey("ore_" + oreSet.getSetName() + "_" + placedKeyName))
        );

        return this;
    }

    public void registerPlacedFeatures(Registerable<PlacedFeature> context, String which, int veinsPerChunk, HeightRangePlacementModifier modifier) {
        Pair<RegistryKey<ConfiguredFeature<?, ?>>, RegistryKey<PlacedFeature>> keyPair = this.oreKeys.get(which);

        GemstynePlacedFeatures.register(context, keyPair.getRight(), GemstynePlacedFeatures.fetchConfig(context,
            keyPair.getLeft()), GemstyneOrePlacement.modifiersWithCount(veinsPerChunk, modifier));
    }

    public void registerConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context, String which, int veinsSize, float discardOnAirChance) {
        Pair<RegistryKey<ConfiguredFeature<?, ?>>, RegistryKey<PlacedFeature>> keyPair = this.oreKeys.get(which);

        GemstyneConfiguredFeatures.register(context, keyPair.getLeft(), Feature.ORE, new OreFeatureConfig(
            this.oreMap.get("overworld").stream().toList(), veinsSize, discardOnAirChance));
    }

    public  RegistryKey<PlacedFeature> getPlacedKey(String which) {
        return this.oreKeys.get(which).getRight();
    }

    private static final RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private static final RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
}
