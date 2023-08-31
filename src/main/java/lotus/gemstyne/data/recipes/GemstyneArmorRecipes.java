package lotus.gemstyne.data.recipes;

import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.armor.GemstyneArmorSet;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

abstract class GemstyneArmorRecipes extends FabricRecipeProvider {

    protected GemstyneArmorRecipes(FabricDataOutput output) {
        super(output);
    }


    protected static void generateArmorRecipes(Consumer<RecipeJsonProvider> exporter) {
        // =====
        // <===== Aldus Armour =====>
        // =====
        offerArmorSetRecipes(exporter, GemstyneArmorItems.ALDUS);

        // =====
        // <===== Bronzemail Armour =====>
        // =====
        offerArmorSetRecipes(exporter, GemstyneArmorItems.BRONZEMAIL);

        // =====
        // <===== Bronzeplate Armour =====>
        // =====
        offerArmorSetRecipes(exporter, GemstyneArmorItems.BRONZEPLATE);

        // =====
        // <===== Rendfire Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, GemstyneArmorItems.RENDFIRE.helmet,
                GemstyneOreItems.CRIMONITE.ingot());

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GemstyneArmorItems.RENDFIRE.chestplate)
                .pattern("C C")
                .pattern("CFC")
                .pattern("CCC")
                .input('C', GemstyneOreItems.CRIMONITE.ingot())
                .input('F', GemstyneOreItems.FIRE_OPAL)
                .criterion(RecipeProvider.hasItem(GemstyneOreItems.FIRE_OPAL),
                        RecipeProvider.conditionsFromItem(GemstyneOreItems.FIRE_OPAL))
                .criterion(RecipeProvider.hasItem(GemstyneOreItems.CRIMONITE.ingot()),
                        RecipeProvider.conditionsFromItem(GemstyneOreItems.CRIMONITE.ingot()))
                .offerTo(exporter, new Identifier(RecipeProvider
                        .getRecipeName(GemstyneArmorItems.RENDFIRE.chestplate)));

        offerBasicLeggingsRecipe(exporter, GemstyneArmorItems.RENDFIRE.leggings,
                GemstyneOreItems.CRIMONITE.ingot());
        offerBasicBootsRecipe(exporter, GemstyneArmorItems.RENDFIRE.boots,
                GemstyneOreItems.CRIMONITE.ingot());
    }


    // =====
    // <===== Assistive Methods =====>
    // =====

    /**
     * <code>offerArmorSetRecipes</code> is a method to generate a full set of basic
     * armor recipes.
     * @param exporter RecipeJsonProvider
     * @param armorSet Target ArmorSet for recipe generation.
     */
    private static void offerArmorSetRecipes(
            Consumer<RecipeJsonProvider> exporter,
            GemstyneArmorSet armorSet
    ) {
        offerBasicHelmetRecipe(exporter, armorSet.helmet, armorSet.source);
        offerBasicChestplateRecipe(exporter, armorSet.chestplate, armorSet.source);
        offerBasicLeggingsRecipe(exporter, armorSet.leggings, armorSet.source);
        offerBasicBootsRecipe(exporter, armorSet.boots, armorSet.source);
    }

    private static void offerBasicHelmetRecipe(
            Consumer<RecipeJsonProvider> exporter,
            Item output,
            Item input
    ) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("III")
                .pattern("I I")
                .input('I', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }


    private static void offerBasicChestplateRecipe(
            Consumer<RecipeJsonProvider> exporter,
            Item output,
            Item input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .input('I', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }


    private static void offerBasicLeggingsRecipe(
            Consumer<RecipeJsonProvider> exporter,
            Item output,
            Item input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .input('I', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }


    private static void offerBasicBootsRecipe(
            Consumer<RecipeJsonProvider> exporter,
            Item output,
            Item input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("I I")
                .pattern("I I")
                .input('I', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }
}
