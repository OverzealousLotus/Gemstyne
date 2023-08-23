package lotus.gemstyne.data.recipes;

import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.armor.GemstyneArmorSet;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

abstract class GemstyneArmorRecipes extends FabricRecipeProvider {

    public GemstyneArmorRecipes(FabricDataOutput output) {
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
        offerBasicHelmetRecipe(exporter, GemstyneArmorItems.RENDFIRE.HELMET,
                GemstyneOreItems.CRIMONITE.INGOT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GemstyneArmorItems.RENDFIRE.CHESTPLATE)
                .pattern("C C")
                .pattern("CFC")
                .pattern("CCC")
                .input('C', GemstyneOreItems.CRIMONITE.INGOT)
                .input('F', GemstyneOreItems.FIRE_OPAL)
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.FIRE_OPAL),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.FIRE_OPAL))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.CRIMONITE.INGOT),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.CRIMONITE.INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider
                        .getRecipeName(GemstyneArmorItems.RENDFIRE.CHESTPLATE)));

        offerBasicLeggingsRecipe(exporter, GemstyneArmorItems.RENDFIRE.LEGGINGS,
                GemstyneOreItems.CRIMONITE.INGOT);
        offerBasicBootsRecipe(exporter, GemstyneArmorItems.RENDFIRE.BOOTS,
                GemstyneOreItems.CRIMONITE.INGOT);
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
        offerBasicHelmetRecipe(exporter, armorSet.HELMET, armorSet.SOURCE);
        offerBasicChestplateRecipe(exporter, armorSet.CHESTPLATE, armorSet.SOURCE);
        offerBasicLeggingsRecipe(exporter, armorSet.LEGGINGS, armorSet.SOURCE);
        offerBasicBootsRecipe(exporter, armorSet.BOOTS, armorSet.SOURCE);
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
