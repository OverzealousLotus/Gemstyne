package lotus.gemstyne.data.recipes;

import lotus.gemstyne.item.GemstyneArmorItems;
import lotus.gemstyne.item.GemstyneOreItems;
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
        // <===== Rendfire Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.RENDFIRE_HELMET,
                GemstyneOreItems.CRIMONITE_INGOT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GemstyneArmorItems.RENDFIRE_CHESTPLATE)
                .pattern("C C")
                .pattern("CFC")
                .pattern("CCC")
                .input('C', GemstyneOreItems.CRIMONITE_INGOT)
                .input('F', GemstyneOreItems.FIRE_OPAL)
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.FIRE_OPAL),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.FIRE_OPAL))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(GemstyneArmorItems.RENDFIRE_CHESTPLATE)));

        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.RENDFIRE_LEGGINGS,
                GemstyneOreItems.CRIMONITE_INGOT);
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.RENDFIRE_BOOTS,
                GemstyneOreItems.CRIMONITE_INGOT);

        // =====
        // <===== Aldus Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ALDUS_HELMET,
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicChestplateRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ALDUS_CHESTPLATE,
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ALDUS_LEGGINGS,
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ALDUS_BOOTS,
                GemstyneOreItems.ALDUS_INGOT);
    }


    // =====
    // <===== Assistive Methods =====>
    // =====
    private static void offerBasicHelmetRecipe(
            Consumer<RecipeJsonProvider> exporter,
             RecipeCategory category, Item output,
             Item input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("III")
                .pattern("I I")
                .input('I', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }


    private static void offerBasicChestplateRecipe(
            Consumer<RecipeJsonProvider> exporter,
            RecipeCategory category, Item output,
            Item input) {
        ShapedRecipeJsonBuilder.create(category, output)
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
             RecipeCategory category, Item output,
             Item input) {
        ShapedRecipeJsonBuilder.create(category, output)
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
             RecipeCategory category, Item output,
             Item input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("I I")
                .pattern("I I")
                .input('I', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }
}
