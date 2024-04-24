package lotus.gemstyne.data.recipes;

import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.block.util.BlockSet;
import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.item.GemstyneItemSet;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class GemstyneRecipeProvider extends FabricRecipeProvider {

    public GemstyneRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // =====
        // <===== Smelting/Blasting =====>
        // =====

        offerCompleteSmelting(exporter, List.of(ItemHandler.ALDUS.raw()),
            ItemHandler.ALDUS.ingot(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, List.of(ItemHandler.MOCHITE.raw()),
            ItemHandler.MOCHITE.crystal(), 200, 100, 0.5f);
        offerCompleteSmelting(exporter, List.of(ItemHandler.MUTALIUM.raw()),
            ItemHandler.MUTALIUM.ingot(), 350, 175, 2.0f);
        offerCompleteSmelting(exporter, List.of(ItemHandler.TIN.raw()),
            ItemHandler.TIN.ingot(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, List.of(ItemHandler.TORRIUM.raw()),
            ItemHandler.TORRIUM.ingot(), 300, 150, 1.25f);
        offerCompleteSmelting(exporter, List.of(ItemHandler.URANIUM.raw()),
            ItemHandler.URANIUM.chunk(), 300, 150, 1.5f);
        offerCompleteSmelting(exporter, List.of(ItemHandler.CRIMONITE.raw()),
            ItemHandler.CRIMONITE.chunk(), 350, 175, 2.0f);

        offerCompleteSmelting(exporter, GemstyneArmorItems.ALDUS.getArmorList(),
            ItemHandler.ALDUS.ingot(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, GemstyneArmorItems.BRONZEPLATE.getArmorList(),
            ItemHandler.BRONZE.ingot(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, GemstyneArmorItems.BRONZEMAIL.getArmorList(),
            ItemHandler.BRONZE.nugget(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, GemstyneArmorItems.RENDFIRE.getArmorList(),
            ItemHandler.CRIMONITE.ingot(), 350, 175, 2.0f);


        // =====
        // <===== Reversible =====>
        // =====
        offerBilateralCompactingRecipes(exporter, BlockHandler.ALDUS, ItemHandler.ALDUS);
        offerBilateralCompactingRecipes(exporter, BlockHandler.CRIMONITE, ItemHandler.CRIMONITE);
        offerBilateralCompactingRecipes(exporter, BlockHandler.TIN, ItemHandler.TIN);
        offerBilateralCompactingRecipes(exporter, BlockHandler.URANIUM, ItemHandler.URANIUM);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ItemHandler.FIRE_OPAL, RecipeCategory.DECORATIONS,
                BlockHandler.FIRE_OPAL.pureBlock());

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ItemHandler.MOCHITE.crystal(), RecipeCategory.DECORATIONS,
                BlockHandler.MOCHITE.pureBlock());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                ItemHandler.MOCHITE.raw(), RecipeCategory.DECORATIONS,
                BlockHandler.MOCHITE.rawBlock());
        
        // =====
        // <===== Ingots =====>
        // =====
        offerReversibleNuggetRecipe(exporter, ItemHandler.ALDUS);
        offerReversibleNuggetRecipe(exporter, ItemHandler.BRONZE);
        offerReversibleNuggetRecipe(exporter, ItemHandler.CRIMONITE);
        offerReversibleNuggetRecipe(exporter, ItemHandler.MOCHITE.crystal(),
            ItemHandler.MOCHITE.nugget(), ItemHandler.MOCHITE.getSetName());
        offerReversibleNuggetRecipe(exporter, ItemHandler.MUTALIUM);
        offerReversibleNuggetRecipe(exporter, ItemHandler.TIN);
        offerReversibleNuggetRecipe(exporter, ItemHandler.TORRIUM);
        offerReversibleNuggetRecipe(exporter, ItemHandler.URANIUM);

        offerBasicIngotRecipe(exporter, ItemHandler.URANIUM.chunk(),
           ItemHandler.URANIUM.ingot(), "uranium_chunk_to_ingot");
        offerBasicIngotRecipe(exporter, ItemHandler.CRIMONITE.chunk(),
                ItemHandler.CRIMONITE.ingot(), "crimonite_chunk_to_ingot");

        offerAlloyIngotRecipe(exporter, Items.COPPER_INGOT, ItemHandler.TIN.ingot(),
                ItemHandler.BRONZE.ingot(), "bronze_ingot");

        /////
        ////////// Stone cutter //////////
        /////
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, Blocks.GRANITE, BlockHandler.COMPRESSED_GRANITE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, Blocks.ANDESITE, BlockHandler.COMPRESSED_ANDESITE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, Blocks.DIORITE, BlockHandler.COMPRESSED_DIORITE, 9);

        // =====
        // <===== Shapeless =====>
        // =====

        // =====
        // <===== Shaped =====>
        // =====
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemHandler.BRONZE.chain())
                .pattern(" N ")
                .pattern("N N")
                .pattern(" N ")
                .input('N', ItemHandler.BRONZE.nugget())
                .criterion(RecipeProvider.hasItem(ItemHandler.BRONZE.nugget()),
                        RecipeProvider.conditionsFromItem(ItemHandler.BRONZE.nugget()))
                .offerTo(exporter, GemstyneRegistry.id(RecipeProvider.getRecipeName(ItemHandler.BRONZE.chain())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemHandler.IMBUED_ROD)
                .pattern(" Q ")
                .pattern("QBQ")
                .pattern(" Q ")
                .input('Q', Items.QUARTZ)
                .input('B', Items.BLAZE_ROD)
                .criterion(RecipeProvider.hasItem(Items.QUARTZ),
                        RecipeProvider.conditionsFromItem(Items.QUARTZ))
                .criterion(RecipeProvider.hasItem(Items.BLAZE_ROD),
                        RecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemHandler.IMBUED_ROD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemHandler.IMBUED_FEATHER)
                .pattern(" O ")
                .pattern("OIO")
                .pattern("IO ")
                .input('O', ItemHandler.IKARITE)
                .input('I', ItemHandler.IMBUED_ROD)
                .criterion(RecipeProvider.hasItem(ItemHandler.IMBUED_ROD),
                        RecipeProvider.conditionsFromItem(ItemHandler.IMBUED_ROD))
                .criterion(RecipeProvider.hasItem(ItemHandler.IKARITE),
                        RecipeProvider.conditionsFromItem(ItemHandler.IKARITE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemHandler.IMBUED_FEATHER)));

        GemstyneArmorRecipes.generateArmorRecipes(exporter);
        GemstyneToolRecipes.generateToolRecipes(exporter);
    }

    /**
     * Internally calls {@link RecipeProvider#offerReversibleCompactingRecipes}, creating
     * both raw and pure reversible compacting recipes. Thus, inputted sets are required to contain
     * raw and pure variations of both their blocks, and items.
     * @param blockSet {@link BlockSet}
     * @param itemSet {@link GemstyneItemSet}
     */
    private static void offerBilateralCompactingRecipes(
            RecipeExporter exporter,
            BlockSet blockSet,
            GemstyneItemSet itemSet
    ) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                itemSet.ingot(), RecipeCategory.DECORATIONS,
                blockSet.pureBlock());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                itemSet.raw(), RecipeCategory.DECORATIONS,
                blockSet.rawBlock());
    }

    /**
     * Internally calls {@link RecipeProvider#offerBlasting} and {@link RecipeProvider#offerSmelting} to create both
     * recipes in one function call.
     * @param exporter {@link RecipeExporter}
     * @param inputs Target items for smelting/blasting.
     * @param output Output of smelting/blasting.
     * @param smeltingTime Time until smelting completes in Ticks.
     * @param blastingTime Time until blasting completes in Ticks.
     * @param experience Amount of experience gained for each successful smelt/blast.
     */
    private static void offerCompleteSmelting(
            RecipeExporter exporter,
            List<ItemConvertible> inputs,
            Item output,
            int smeltingTime,
            int blastingTime,
            float experience
    ) {
        offerSmelting(exporter, inputs, RecipeCategory.MISC, output, experience, smeltingTime, "gemstyne");
        offerBlasting(exporter, inputs, RecipeCategory.MISC, output, experience, blastingTime, "gemstyne");
    }

    private static void offerBasicIngotRecipe(
            RecipeExporter exporter, Item input, Item output, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("CC")
                .pattern("CC")
                .input('C', input)
                .criterion(RecipeProvider.hasItem(input),
                        RecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(name));
    }

    private static void offerAlloyIngotRecipe(
            RecipeExporter exporter, Item ingotOne, Item ingotTwo, Item output, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("AB")
                .input('A', ingotOne)
                .input('B', ingotTwo)
                .criterion(RecipeProvider.hasItem(ingotOne),
                        RecipeProvider.conditionsFromItem(ingotOne))
                .criterion(RecipeProvider.hasItem(ingotTwo),
                        RecipeProvider.conditionsFromItem(ingotTwo))
                .offerTo(exporter, new Identifier(name));
    }

    /**
     * Method providing an easy way to create an Ingot-To-Nugget reversible recipes.
     * @param set {@link GemstyneItemSet}
     */
    private static void offerReversibleNuggetRecipe(RecipeExporter exporter, GemstyneItemSet set) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, set.nugget(), 9)
                .input(set.ingot())
                .criterion(RecipeProvider.hasItem(set.ingot()),
                        RecipeProvider.conditionsFromItem(set.ingot()))
                .offerTo(exporter, new Identifier(set.getSetName() + "_" + "ingot_to_nugget"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, set.ingot())
                .input(set.nugget(), 9)
                .criterion(RecipeProvider.hasItem(set.nugget()),
                        RecipeProvider.conditionsFromItem(set.nugget()))
                .offerTo(exporter, new Identifier(set.getSetName() + "_" + "nugget_to_ingot"));
    }

    private static void offerReversibleNuggetRecipe(RecipeExporter exporter, Item purity, Item nugget, String name) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, nugget, 9)
            .input(purity)
            .criterion(RecipeProvider.hasItem(purity),
                RecipeProvider.conditionsFromItem(purity))
            .offerTo(exporter, new Identifier(name + "_" + "purity_to_nugget"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, purity)
            .input(nugget, 9)
            .criterion(RecipeProvider.hasItem(nugget),
                RecipeProvider.conditionsFromItem(nugget))
            .offerTo(exporter, new Identifier(name + "_" + "nugget_to_ingot"));
    }
}
