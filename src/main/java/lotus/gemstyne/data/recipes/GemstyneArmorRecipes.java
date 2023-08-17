package lotus.gemstyne.data.recipes;

import lotus.gemstyne.item.equipment.GemstyneArmorItems;
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
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.aldusHelmet(),
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicChestplateRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.aldusChestplate(),
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.aldusLeggings(),
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.aldusBoots(),
                GemstyneOreItems.ALDUS_INGOT);

        // =====
        // <===== Bronzemail Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailHelmet(),
                GemstyneOreItems.BRONZE_RING);
        offerBasicChestplateRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailChestplate(),
                GemstyneOreItems.BRONZE_RING);
        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailLeggings(),
                GemstyneOreItems.BRONZE_RING);
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailBoots(),
                GemstyneOreItems.BRONZE_RING);

        // =====
        // <===== Bronzeplate Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateHelmet(),
                GemstyneOreItems.BRONZE_INGOT);
        offerBasicChestplateRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateChestplate(),
                GemstyneOreItems.BRONZE_INGOT);
        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateLeggings(),
                GemstyneOreItems.BRONZE_INGOT);
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateBoots(),
                GemstyneOreItems.BRONZE_INGOT);

        // =====
        // <===== Rendfire Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.rendfireHelmet(),
                GemstyneOreItems.CRIMONITE_INGOT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.rendfireChestplate())
                .pattern("C C")
                .pattern("CFC")
                .pattern("CCC")
                .input('C', GemstyneOreItems.CRIMONITE_INGOT)
                .input('F', GemstyneOreItems.FIRE_OPAL)
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.FIRE_OPAL),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.FIRE_OPAL))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider
                        .getRecipeName(GemstyneArmorItems.ARMOR_ITEMS.rendfireChestplate())));

        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.rendfireLeggings(),
                GemstyneOreItems.CRIMONITE_INGOT);
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.rendfireBoots(),
                GemstyneOreItems.CRIMONITE_INGOT);
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
