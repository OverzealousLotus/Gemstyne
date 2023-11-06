package lotus.gemstyne.data.models;

import lotus.gemstyne.block.GemstyneBlockHandler;
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
        GemstyneOreBlocks.BUBBLEGEM.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.ENDER_PEARL.generateModels(blockStateModelGenerator);
        blockStateModelGenerator.registerSimpleCubeAll(GemstyneOreBlocks.COMPRESSED_GRANITE_FIRE_OPAL_ORE);
        GemstyneOreBlocks.MOCHITE.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.MUTALIUM.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.TORRIUM.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.TIN.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.URANIUM.generateModels(blockStateModelGenerator);

        blockStateModelGenerator.registerSimpleCubeAll(
                GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(
                GemstyneOreBlocks.MORKITE_BLOCK);

        /*BlockStateModelGenerator.BlockTexturePool mochiteOrePool = blockStateModelGenerator.registerCubeAllModelTexturePool(GemstyneOreBlocks.MOCHITE.stoneOre());
        mochiteOrePool.same(GemstyneOreBlocks.RICH_MOCHITE_ORE)*/
        blockStateModelGenerator.registerSimpleCubeAll(GemstyneBlockHandler.PYRITE);

        blockStateModelGenerator.registerSimpleCubeAll(GemstyneOreBlocks.FIRE_OPAL_BLOCK);

        // =====
        // <===== Nether =====>
        // =====
        GemstyneOreBlocks.CRIMONITE.generateModels(blockStateModelGenerator);
        GemstyneOreBlocks.ALDUS.generateModels(blockStateModelGenerator);

        // =====
        // <===== Ore Extensions =====>
        // =====
        blockStateModelGenerator.registerSimpleCubeAll(
                GemstyneOreBlocks.COMPRESSED_GRANITE_COAL_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(GemstyneOreBlocks.NEFARIUM_ORE);
    }


    public static void generateOreItemModels(ItemModelGenerator itemModelGenerator) {
        // =====
        // <===== Raw Ores =====>
        // =====
        GemstyneOreItems.MUTALIUM.generateModels(itemModelGenerator);
        GemstyneOreItems.MOCHITE.generateModels(itemModelGenerator);
        GemstyneOreItems.Pyrite.generateModels(itemModelGenerator);
        GemstyneOreItems.TORRIUM.generateModels(itemModelGenerator);
        GemstyneOreItems.TIN.generateModels(itemModelGenerator);
        GemstyneOreItems.URANIUM.generateModels(itemModelGenerator);
        GemstyneOreItems.CRIMONITE.generateModels(itemModelGenerator);
        GemstyneOreItems.ALDUS.generateModels(itemModelGenerator);
        GemstyneOreItems.BRONZE.generateModels(itemModelGenerator);

        itemModelGenerator.register(GemstyneOreItems.IKARITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.GARNET, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.MORKITE, Models.GENERATED);
        itemModelGenerator.register(GemstyneOreItems.FIRE_OPAL, Models.GENERATED);

        itemModelGenerator.register(GemstyneOreItems.BUBBLEGEM, Models.GENERATED);
    }
}
