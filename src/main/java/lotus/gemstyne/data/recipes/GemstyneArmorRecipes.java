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
                GemstyneOreItems.getCrimoniteIngot());

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GemstyneArmorItems.RENDFIRE_CHESTPLATE)
                .pattern("C C")
                .pattern("CFC")
                .pattern("CCC")
                .input('C', GemstyneOreItems.getCrimoniteIngot())
                .input('F', GemstyneOreItems.getFireOpal())
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.getFireOpal()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.getFireOpal()))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.getCrimoniteIngot()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.getCrimoniteIngot()))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(GemstyneArmorItems.RENDFIRE_CHESTPLATE)));

        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.RENDFIRE_LEGGINGS,
                GemstyneOreItems.getCrimoniteIngot());
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.RENDFIRE_BOOTS,
                GemstyneOreItems.getCrimoniteIngot());

        // =====
        // <===== Aldus Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ALDUS_HELMET,
                GemstyneOreItems.getAldusIngot());
        offerBasicChestplateRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ALDUS_CHESTPLATE,
                GemstyneOreItems.getAldusIngot());
        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ALDUS_LEGGINGS,
                GemstyneOreItems.getAldusIngot());
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ALDUS_BOOTS,
                GemstyneOreItems.getAldusIngot());
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
