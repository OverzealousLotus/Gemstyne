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
                GemstyneOreItems.ORE_ITEMS.aldusIngot());
        offerBasicChestplateRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.aldusChestplate(),
                GemstyneOreItems.ORE_ITEMS.aldusIngot());
        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.aldusLeggings(),
                GemstyneOreItems.ORE_ITEMS.aldusIngot());
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.aldusBoots(),
                GemstyneOreItems.ORE_ITEMS.aldusIngot());

        // =====
        // <===== Bronzemail Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailHelmet(),
                GemstyneOreItems.ORE_ITEMS.bronzeRing());
        offerBasicChestplateRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailChestplate(),
                GemstyneOreItems.ORE_ITEMS.bronzeRing());
        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailLeggings(),
                GemstyneOreItems.ORE_ITEMS.bronzeRing());
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzeMailBoots(),
                GemstyneOreItems.ORE_ITEMS.bronzeRing());

        // =====
        // <===== Bronzeplate Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateHelmet(),
                GemstyneOreItems.ORE_ITEMS.bronzeIngot());
        offerBasicChestplateRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateChestplate(),
                GemstyneOreItems.ORE_ITEMS.bronzeIngot());
        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateLeggings(),
                GemstyneOreItems.ORE_ITEMS.bronzeIngot());
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.bronzePlateBoots(),
                GemstyneOreItems.ORE_ITEMS.bronzeIngot());

        // =====
        // <===== Rendfire Armour =====>
        // =====
        offerBasicHelmetRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.rendfireHelmet(),
                GemstyneOreItems.ORE_ITEMS.crimoniteIngot());

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.rendfireChestplate())
                .pattern("C C")
                .pattern("CFC")
                .pattern("CCC")
                .input('C', GemstyneOreItems.ORE_ITEMS.crimoniteIngot())
                .input('F', GemstyneOreItems.ORE_ITEMS.fireOpal())
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.ORE_ITEMS.fireOpal()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.ORE_ITEMS.fireOpal()))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.ORE_ITEMS.crimoniteIngot()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.ORE_ITEMS.crimoniteIngot()))
                .offerTo(exporter, new Identifier(FabricRecipeProvider
                        .getRecipeName(GemstyneArmorItems.ARMOR_ITEMS.rendfireChestplate())));

        offerBasicLeggingsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.rendfireLeggings(),
                GemstyneOreItems.ORE_ITEMS.crimoniteIngot());
        offerBasicBootsRecipe(exporter, RecipeCategory.COMBAT, GemstyneArmorItems.ARMOR_ITEMS.rendfireBoots(),
                GemstyneOreItems.ORE_ITEMS.crimoniteIngot());
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
