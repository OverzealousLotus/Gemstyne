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
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.BRONZE.nugget()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.BRONZE.nugget()))
                .offerTo(exporter, GemstyneRegistry.id(FabricRecipeProvider.getRecipeName(GemstyneOreItems.BRONZE.chain())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GemstyneCraftingItems.getImbuedRod())
                .pattern(" Q ")
                .pattern("QBQ")
                .pattern(" Q ")
                .input('Q', Items.QUARTZ)
                .input('B', Items.BLAZE_ROD)
                .criterion(FabricRecipeProvider.hasItem(Items.QUARTZ),
                        FabricRecipeProvider.conditionsFromItem(Items.QUARTZ))
                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_ROD),
                        FabricRecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(GemstyneCraftingItems.getImbuedRod())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GemstyneGearItems.getImbuedFeather())
                .pattern(" O ")
                .pattern("OIO")
                .pattern("IO ")
                .input('O', GemstyneOreItems.IKARITE)
                .input('I', GemstyneCraftingItems.getImbuedRod())
                .criterion(FabricRecipeProvider.hasItem(GemstyneCraftingItems.getImbuedRod()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneCraftingItems.getImbuedRod()))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.IKARITE),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.IKARITE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(GemstyneGearItems.getImbuedFeather())));

        GemstyneArmorRecipes.generateArmorRecipes(exporter);
        GemstyneToolRecipes.generateToolRecipes(exporter);
    }

    /**
     * Method internally calling <code>offerReversibleCompactingRecipes</code>, creating
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
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(name));
    }

    private static void offerAlloyIngotRecipe(
            Consumer<RecipeJsonProvider> exporter, Item ingot_one, Item ingot_two, Item output, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("AB")
                .input('A', ingot_one)
                .input('B', ingot_two)
                .criterion(FabricRecipeProvider.hasItem(ingot_one),
                        FabricRecipeProvider.conditionsFromItem(ingot_one))
                .criterion(FabricRecipeProvider.hasItem(ingot_two),
                        FabricRecipeProvider.conditionsFromItem(ingot_two))
                .offerTo(exporter, new Identifier(name));
    }

    /**
     * Method providing an easy way to create an Ingot-To-Nugget reversible recipes.
     * @param set {@link GemstyneItemSet}
     */
    private static void offerReversibleNuggetRecipe(Consumer<RecipeJsonProvider> exporter, GemstyneItemSet set) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, set.nugget(), 9)
                .input(set.ingot())
                .criterion(FabricRecipeProvider.hasItem(set.ingot()),
                        FabricRecipeProvider.conditionsFromItem(set.ingot()))
                .offerTo(exporter, new Identifier(set.setName() + "ingot_to_nugget"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, set.ingot())
                .input(set.nugget(), 9)
                .criterion(FabricRecipeProvider.hasItem(set.nugget()),
                        FabricRecipeProvider.conditionsFromItem(set.nugget()))
                .offerTo(exporter, new Identifier(set.setName() + "nugget_to_ingot"));
    }
}
