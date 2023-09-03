package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
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

        GemstyneOreBlocks.TORRIUM.generateModels(blockStateModelGenerator);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE);

        GemstyneOreBlocks.MOCHITE.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.MUTALIUM.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.TIN.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.URANIUM.generateModels(blockStateModelGenerator);

        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.MORKITE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.FIRE_OPAL_BLOCK);

        // =====
        // <===== Nether =====>
        // =====
        GemstyneOreBlocks.CRIMONITE.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.ALDUS.generateModels(blockStateModelGenerator);

        // =====
        // <===== Ore Extensions =====>
        // =====
        blockStateModelGenerator.registerCubeAllModelTexturePool(
                GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.NEFARIUM_ORE);
    }


    public static void generateOreItemModels(ItemModelGenerator itemModelGenerator) {
        // =====
        // <===== Raw Ores =====>
        // =====
        GemstyneOreItems.MOCHITE.generateModels(itemModelGenerator);
        GemstyneOreItems.TIN.generateModels(itemModelGenerator);
        GemstyneOreItems.URANIUM.generateModels(itemModelGenerator);
        GemstyneOreItems.CRIMONITE.generateModels(itemModelGenerator);
        GemstyneOreItems.ALDUS.generateModels(itemModelGenerator);
        GemstyneOreItems.BRONZE.generateModels(itemModelGenerator);

        itemModelGenerator.register(GemstyneOreItems.IKARITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.GARNET, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.MORKITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.FIRE_OPAL, Models.GENERATED);
    }
}
