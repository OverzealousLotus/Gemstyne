package lotus.gemstyne.world.ores;

import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.world.WorldHandler;
import net.minecraft.registry.Registerable;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class GemstyneOreConfig {
    private GemstyneOreConfig() {}

    /** <h3>Function used to register all Ore Configuration Features.</h3>
     */
    public static void registerOreConfigFeatures(Registerable<ConfiguredFeature<?, ?>> context) {
        // =====
        // <=====| The Overworld |=====>
        // =====
        WorldHandler.BUBBLEGEM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 5, 0.05f, false);
        WorldHandler.BUBBLEGEM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 10, 0.10f, false);

        WorldHandler.MOCHITE.overworldConfigFeatures(context, GemstyneConstants.SMALL, 8, 0.0f, false);
        WorldHandler.MOCHITE.overworldConfigFeatures(context, GemstyneConstants.LARGE, 15, 0.05f, false);
        WorldHandler.MOCHITE.overworldConfigFeatures(context, GemstyneConstants.RAW, 3, 0.00f, true);
        WorldHandler.MOCHITE.overworldConfigFeatures(context, GemstyneConstants.RICH, 5, 0.05f, false, "rich_overworld");

        WorldHandler.TIN.overworldConfigFeatures(context, GemstyneConstants.SMALL, 7, 0.0f, false);
        WorldHandler.TIN.overworldConfigFeatures(context, GemstyneConstants.LARGE, 12, 0.0f, false);
        WorldHandler.TIN.overworldConfigFeatures(context, GemstyneConstants.RAW, 3, 0.0f, true);

        WorldHandler.MORKITE.overworldConfigFeatures(context, GemstyneConstants.BURIED, 8, 0.7f, false);
        WorldHandler.MORKITE.overworldConfigFeatures(context, GemstyneConstants.EXPOSED, 5, 0.0f, false);
        WorldHandler.MORKITE.overworldConfigFeatures(context, GemstyneConstants.RAW, 2, 0.0f, true);


        WorldHandler.URANIUM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 4, 0.5f, false);
        WorldHandler.URANIUM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 10, 0.7f, false);
        WorldHandler.URANIUM.overworldConfigFeatures(context, GemstyneConstants.RAW, 1, 0.0f, true);

        // =====
        // <=====| The Nether |=====>
        // =====
        WorldHandler.ALDUS.netherConfigFeatures(context, GemstyneConstants.SMALL, 4, 0);
        WorldHandler.ALDUS.netherConfigFeatures(context, GemstyneConstants.LARGE, 12, 0);

        WorldHandler.BLAZITE.netherConfigFeatures(context, GemstyneConstants.SMALL, 5, 0);
        WorldHandler.BLAZITE.netherConfigFeatures(context, GemstyneConstants.LARGE, 8, 0);

        WorldHandler.CRIMONITE.netherConfigFeatures(context, GemstyneConstants.LARGE, 7, 0);
        WorldHandler.CRIMONITE.netherConfigFeatures(context, GemstyneConstants.SMALL, 3, 0);

        // =====
        // <=====| The End |=====>
        // =====

        // =====
        // <=====| Multi-Dimensional |=====>
        // =====
        WorldHandler.ENDER_PEARL.overworldConfigFeatures(context, GemstyneConstants.SMALL, 3, 0.2f, false);
        WorldHandler.ENDER_PEARL.overworldConfigFeatures(context, GemstyneConstants.LARGE, 5, 0.5f, false);
        WorldHandler.ENDER_PEARL.netherConfigFeatures(context, GemstyneConstants.NETHER, 7, 0.1f);
        WorldHandler.ENDER_PEARL.endConfigFeatures(context, GemstyneConstants.END, 16, 0.05f);

        WorldHandler.MUTALIUM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 5, 0.2f, false);
        WorldHandler.MUTALIUM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 7, 0.5f, false);
        WorldHandler.MUTALIUM.netherConfigFeatures(context, GemstyneConstants.NETHER, 8, 0.1f);
        WorldHandler.MUTALIUM.endConfigFeatures(context, GemstyneConstants.END, 16, 0.05f);

        WorldHandler.TORRIUM.overworldConfigFeatures(context, GemstyneConstants.SMALL, 5, 0.2f, false);
        WorldHandler.TORRIUM.overworldConfigFeatures(context, GemstyneConstants.LARGE, 9, 0.5f, false);
        WorldHandler.TORRIUM.netherConfigFeatures(context, GemstyneConstants.NETHER, 12, 0.0f);

    }

}
