package lotus.gemstyne.data.models;

import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.item.ItemHandler;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public final class GemstyneOreModels {
    private GemstyneOreModels() {}

    public static void generateOreBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        // =====
        // ==========
        // <========== Quadrilateral Ores ==========>
        // ==========
        // =====



        // =====
        // <===== Overworld =====>
        // =====
        BlockHandler.EXPERIENCE.generateModels(blockStateModelGenerator);
        BlockHandler.AETHERIUM.generateModels(blockStateModelGenerator);
        BlockHandler.BUBBLEGEM.generateModels(blockStateModelGenerator);
        BlockHandler.ENDER_PEARL.generateModels(blockStateModelGenerator);
        BlockHandler.FIRE_OPAL.generateModels(blockStateModelGenerator);
        BlockHandler.MOCHITE.generateModels(blockStateModelGenerator);
        BlockHandler.MUTALIUM.generateModels(blockStateModelGenerator);

        BlockHandler.MORKITE.generateModels(blockStateModelGenerator);
        BlockHandler.TORRIUM.generateModels(blockStateModelGenerator);
        BlockHandler.TIN.generateModels(blockStateModelGenerator);
        BlockHandler.URANIUM.generateModels(blockStateModelGenerator);
        blockStateModelGenerator.registerSimpleCubeAll(BlockHandler.PYRITE);

        // =====
        // <===== Nether =====>
        // =====
        BlockHandler.ALDUS.generateModels(blockStateModelGenerator);
        BlockHandler.BLAZITE.generateModels(blockStateModelGenerator);
        BlockHandler.CRIMONITE.generateModels(blockStateModelGenerator);

        // =====
        // <===== Ore Extensions =====>
        // =====
        blockStateModelGenerator.registerSimpleCubeAll(
                BlockHandler.COMPRESSED_GRANITE_COAL_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(BlockHandler.NEFARIUM_ORE);
    }


    public static void generateOreItemModels(ItemModelGenerator itemModelGenerator) {
        // =====
        // <===== Raw Ores =====>
        // =====
        ItemHandler.AETHERIUM.generateModels(itemModelGenerator);
        ItemHandler.MUTALIUM.generateModels(itemModelGenerator);
        ItemHandler.MOCHITE.generateModels(itemModelGenerator);
        ItemHandler.Pyrite.generateModels(itemModelGenerator);
        ItemHandler.TORRIUM.generateModels(itemModelGenerator);
        ItemHandler.TIN.generateModels(itemModelGenerator);
        ItemHandler.URANIUM.generateModels(itemModelGenerator);
        ItemHandler.CRIMONITE.generateModels(itemModelGenerator);
        ItemHandler.ALDUS.generateModels(itemModelGenerator);
        ItemHandler.BRONZE.generateModels(itemModelGenerator);

        itemModelGenerator.register(ItemHandler.IKARITE, Models.GENERATED);
        itemModelGenerator.register(ItemHandler.GARNET, Models.GENERATED);
        itemModelGenerator.register(ItemHandler.MORKITE, Models.GENERATED);
        itemModelGenerator.register(ItemHandler.FIRE_OPAL, Models.GENERATED);

        itemModelGenerator.register(ItemHandler.BUBBLEGEM, Models.GENERATED);
    }
}
