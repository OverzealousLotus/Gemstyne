package lotus.gemstyne.data.recipes;

import lotus.gemstyne.block.GemstyneBlockSet;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.item.GemstyneItemSet;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class GemstyneRecipeProvider extends FabricRecipeProvider {

    public GemstyneRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // =====
        // <===== Smelting/Blasting =====>
        // =====

        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.ALDUS.raw()),
            GemstyneOreItems.ALDUS.ingot(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.MOCHITE.raw()),
            GemstyneOreItems.MOCHITE.crystal(), 200, 100, 0.5f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.MUTALIUM.raw()),
            GemstyneOreItems.MUTALIUM.ingot(), 350, 175, 2.0f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.TIN.raw()),
            GemstyneOreItems.TIN.ingot(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.TORRIUM.raw()),
            GemstyneOreItems.TORRIUM.ingot(), 300, 150, 1.25f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.URANIUM.raw()),
            GemstyneOreItems.URANIUM.chunk(), 300, 150, 1.5f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.CRIMONITE.raw()),
            GemstyneOreItems.CRIMONITE.chunk(), 350, 175, 2.0f);

        offerCompleteSmelting(exporter, GemstyneArmorItems.ALDUS.getArmorList(),
            GemstyneOreItems.ALDUS.ingot(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, GemstyneArmorItems.BRONZEPLATE.getArmorList(),
            GemstyneOreItems.BRONZE.ingot(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, GemstyneArmorItems.BRONZEMAIL.getArmorList(),
            GemstyneOreItems.BRONZE.nugget(), 200, 100, 1.0f);
        offerCompleteSmelting(exporter, GemstyneArmorItems.RENDFIRE.getArmorList(),
            GemstyneOreItems.CRIMONITE.ingot(), 350, 175, 2.0f);


        // =====
        // <===== Reversible =====>
        // =====
        offerBilateralCompactingRecipes(exporter, GemstyneOreBlocks.ALDUS, GemstyneOreItems.ALDUS);
        offerBilateralCompactingRecipes(exporter, GemstyneOreBlocks.CRIMONITE, GemstyneOreItems.CRIMONITE);
        offerBilateralCompactingRecipes(exporter, GemstyneOreBlocks.TIN, GemstyneOreItems.TIN);
        offerBilateralCompactingRecipes(exporter, GemstyneOreBlocks.URANIUM, GemstyneOreItems.URANIUM);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.FIRE_OPAL, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.FIRE_OPAL_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.MOCHITE.crystal(), RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.MOCHITE.pureBlock());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                GemstyneOreItems.MOCHITE.raw(), RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.MOCHITE.rawBlock());
        
        // =====
        // <===== Ingots =====>
        // =====
        offerReversibleNuggetRecipe(exporter, GemstyneOreItems.ALDUS);
        offerReversibleNuggetRecipe(exporter, GemstyneOreItems.BRONZE);
        offerReversibleNuggetRecipe(exporter, GemstyneOreItems.CRIMONITE);
        offerReversibleNuggetRecipe(exporter, GemstyneOreItems.MOCHITE.crystal(),
            GemstyneOreItems.MOCHITE.nugget(), GemstyneOreItems.MOCHITE.setName());
        offerReversibleNuggetRecipe(exporter, GemstyneOreItems.MUTALIUM);
        offerReversibleNuggetRecipe(exporter, GemstyneOreItems.TIN);
        offerReversibleNuggetRecipe(exporter, GemstyneOreItems.TORRIUM);
        offerReversibleNuggetRecipe(exporter, GemstyneOreItems.URANIUM);

        offerBasicIngotRecipe(exporter, GemstyneOreItems.URANIUM.chunk(),
           GemstyneOreItems.URANIUM.ingot(), "uranium_chunk_to_ingot");
        offerBasicIngotRecipe(exporter, GemstyneOreItems.CRIMONITE.chunk(),
                GemstyneOreItems.CRIMONITE.ingot(), "crimonite_chunk_to_ingot");

        offerAlloyIngotRecipe(exporter, Items.COPPER_INGOT, GemstyneOreItems.TIN.ingot(),
                GemstyneOreItems.BRONZE.ingot(), "bronze_ingot");

        // =====
        // <===== Shapeless =====>
        // =====

        // =====
        // <===== Shaped =====>
        // =====
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GemstyneOreItems.BRONZE.chain())
                .pattern(" N ")
                .pattern("N N")
                .pattern(" N ")
                .input('N', GemstyneOreItems.BRONZE.nugget())
                .criterion(RecipeProvider.hasItem(GemstyneOreItems.BRONZE.nugget()),
                        RecipeProvider.conditionsFromItem(GemstyneOreItems.BRONZE.nugget()))
                .offerTo(exporter, GemstyneRegistry.id(RecipeProvider.getRecipeName(GemstyneOreItems.BRONZE.chain())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GemstyneCraftingItems.getImbuedRod())
                .pattern(" Q ")
                .pattern("QBQ")
                .pattern(" Q ")
                .input('Q', Items.QUARTZ)
                .input('B', Items.BLAZE_ROD)
                .criterion(RecipeProvider.hasItem(Items.QUARTZ),
                        RecipeProvider.conditionsFromItem(Items.QUARTZ))
                .criterion(RecipeProvider.hasItem(Items.BLAZE_ROD),
                        RecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(GemstyneCraftingItems.getImbuedRod())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GemstyneGearItems.getImbuedFeather())
                .pattern(" O ")
                .pattern("OIO")
                .pattern("IO ")
                .input('O', GemstyneOreItems.IKARITE)
                .input('I', GemstyneCraftingItems.getImbuedRod())
                .criterion(RecipeProvider.hasItem(GemstyneCraftingItems.getImbuedRod()),
                        RecipeProvider.conditionsFromItem(GemstyneCraftingItems.getImbuedRod()))
                .criterion(RecipeProvider.hasItem(GemstyneOreItems.IKARITE),
                        RecipeProvider.conditionsFromItem(GemstyneOreItems.IKARITE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(GemstyneGearItems.getImbuedFeather())));

        GemstyneArmorRecipes.generateArmorRecipes(exporter);
        GemstyneToolRecipes.generateToolRecipes(exporter);
    }

    /**
     * Internally calls {@link RecipeProvider#offerReversibleCompactingRecipes}, creating
     * both raw and pure reversible compacting recipes. Thus, inputted sets are required to contain
     * raw and pure variations of both their blocks, and items.
     * @param blockSet {@link GemstyneBlockSet}
     * @param itemSet {@link GemstyneItemSet}
     */
    private static void offerBilateralCompactingRecipes(
            Consumer<RecipeJsonProvider> exporter,
            GemstyneBlockSet blockSet,
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
     * @param exporter
     * @param inputs Target items for smelting/blasting.
     * @param output Output of smelting/blasting.
     * @param smeltingTime Time until smelting completes in Ticks.
     * @param blastingTime Time until blasting completes in Ticks.
     * @param experience Amount of experience gained for each successful smelt/blast.
     */
    private static void offerCompleteSmelting(
            Consumer<RecipeJsonProvider> exporter,
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
            Consumer<RecipeJsonProvider> exporter, Item input, Item output, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("CC")
                .pattern("CC")
                .input('C', input)
                .criterion(RecipeProvider.hasItem(input),
                        RecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(name));
    }

    private static void offerAlloyIngotRecipe(
            Consumer<RecipeJsonProvider> exporter, Item ingotOne, Item ingotTwo, Item output, String name) {
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
    private static void offerReversibleNuggetRecipe(Consumer<RecipeJsonProvider> exporter, GemstyneItemSet set) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, set.nugget(), 9)
                .input(set.ingot())
                .criterion(RecipeProvider.hasItem(set.ingot()),
                        RecipeProvider.conditionsFromItem(set.ingot()))
                .offerTo(exporter, new Identifier(set.setName() + "_" + "ingot_to_nugget"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, set.ingot())
                .input(set.nugget(), 9)
                .criterion(RecipeProvider.hasItem(set.nugget()),
                        RecipeProvider.conditionsFromItem(set.nugget()))
                .offerTo(exporter, new Identifier(set.setName() + "_" + "nugget_to_ingot"));
    }

    private static void offerReversibleNuggetRecipe(Consumer<RecipeJsonProvider> exporter, Item purity, Item nugget, String name) {
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
