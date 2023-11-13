package lotus.gemstyne.world.ores;

import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.world.GemstyneConfiguredFeatures;
import lotus.gemstyne.world.GemstyneWorldHandler;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class GemstyneOreConfig {
    private GemstyneOreConfig() {}

    // =====
    // <===== Overworld Keys =====>
    // =====
    private static final RegistryKey<ConfiguredFeature<?, ?>> ORE_FIRE_OPAL_KEY =
            GemstyneConfiguredFeatures.registerKey("ore_fire_opal");

    // =====
    // <===== Extension Keys =====>
    // =====
    private static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_COAL_ORE_KEY =
            GemstyneConfiguredFeatures.registerKey("compressed_coal_ore");


    /** <h3>Function used to register all Ore Configuration Features.</h3>
     */
    public static void registerOreConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context) {
        // =====
        // <=====| The Overworld |=====>
        // =====
        GemstyneWorldHandler.BUBBLEGEM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 5, 0.05f, false);
        GemstyneWorldHandler.BUBBLEGEM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 10, 0.10f, false);

        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getOreFireOpalKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.overworldFireOpalOres, 3, 0.0f));

        GemstyneWorldHandler.MOCHITE.overworldConfigFeatures(context, GemstyneConstants.SMALL, 8, 0.0f, false);
        GemstyneWorldHandler.MOCHITE.overworldConfigFeatures(context, GemstyneConstants.LARGE, 15, 0.05f, false);
        GemstyneWorldHandler.MOCHITE.overworldConfigFeatures(context, GemstyneConstants.RAW, 3, 0.00f, true);

        GemstyneWorldHandler.TIN.overworldConfigFeatures(context, GemstyneConstants.SMALL, 7, 0.0f, false);
        GemstyneWorldHandler.TIN.overworldConfigFeatures(context, GemstyneConstants.LARGE, 12, 0.0f, false);
        GemstyneWorldHandler.TIN.overworldConfigFeatures(context, GemstyneConstants.RAW, 3, 0.0f, true);

        GemstyneWorldHandler.MORKITE.overworldConfigFeatures(context, GemstyneConstants.BURIED, 8, 0.7f, false);
        GemstyneWorldHandler.MORKITE.overworldConfigFeatures(context, GemstyneConstants.EXPOSED, 5, 0.0f, false);
        GemstyneWorldHandler.MORKITE.overworldConfigFeatures(context, GemstyneConstants.RAW, 2, 0.0f, true);


        GemstyneWorldHandler.URANIUM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 4, 0.5f, false);
        GemstyneWorldHandler.URANIUM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 10, 0.7f, false);
        GemstyneWorldHandler.URANIUM.overworldConfigFeatures(context, GemstyneConstants.RAW, 1, 0.0f, true);

        // =====
        // <=====| The Nether |=====>
        // =====
        GemstyneWorldHandler.ALDUS.netherConfigFeatures(context, GemstyneConstants.SMALL, 4, 0);
        GemstyneWorldHandler.ALDUS.netherConfigFeatures(context, GemstyneConstants.LARGE, 12, 0);

        GemstyneWorldHandler.BLAZITE.netherConfigFeatures(context, GemstyneConstants.SMALL, 5, 0);
        GemstyneWorldHandler.BLAZITE.netherConfigFeatures(context, GemstyneConstants.LARGE, 8, 0);

        GemstyneWorldHandler.CRIMONITE.netherConfigFeatures(context, GemstyneConstants.LARGE, 7, 0);
        GemstyneWorldHandler.CRIMONITE.netherConfigFeatures(context, GemstyneConstants.SMALL, 3, 0);

        // =====
        // <=====| The End |=====>
        // =====

        // =====
        // <=====| Multi-Dimensional |=====>
        // =====
        GemstyneWorldHandler.ENDER_PEARL.overworldConfigFeatures(context, GemstyneConstants.SMALL, 3, 0.2f, false);
        GemstyneWorldHandler.ENDER_PEARL.overworldConfigFeatures(context, GemstyneConstants.LARGE, 5, 0.5f, false);
        GemstyneWorldHandler.ENDER_PEARL.netherConfigFeatures(context, GemstyneConstants.NETHER, 7, 0.1f);
        GemstyneWorldHandler.ENDER_PEARL.endConfigFeatures(context, GemstyneConstants.END, 16, 0.05f);

        GemstyneWorldHandler.MUTALIUM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 5, 0.2f, false);
        GemstyneWorldHandler.MUTALIUM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 7, 0.5f, false);
        GemstyneWorldHandler.MUTALIUM.netherConfigFeatures(context, GemstyneConstants.NETHER, 8, 0.1f);
        GemstyneWorldHandler.MUTALIUM.endConfigFeatures(context, GemstyneConstants.END, 16, 0.05f);

        GemstyneWorldHandler.TORRIUM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 5, 0.2f, false);
        GemstyneWorldHandler.TORRIUM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 9, 0.5f, false);
        GemstyneWorldHandler.TORRIUM.netherConfigFeatures(context, GemstyneConstants.NETHER, 12, 0.0f);

        // =====
        // <===== Extension config features. =====>
        // =====
        GemstyneConfiguredFeatures.register(context, GemstyneOreConfig.getCompressedCoalOreKey(), Feature.ORE,
                new OreFeatureConfig(GemstyneOreLists.compressedCoalOres, 10));
    }

    // =====
    // <===== Getters =====>
    // =====

    protected static RegistryKey<ConfiguredFeature<?, ?>> getOreFireOpalKey() {
        return ORE_FIRE_OPAL_KEY;
    }

    protected static RegistryKey<ConfiguredFeature<?, ?>> getCompressedCoalOreKey() {
        return COMPRESSED_COAL_ORE_KEY;
    }

}
