package lotus.gemstyne.data.recipes;

import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.tool.GemstyneToolItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

abstract class GemstyneToolRecipes extends FabricRecipeProvider {
    protected GemstyneToolRecipes(FabricDataOutput output) {
        super(output);
    }

    protected static void generateToolRecipes(RecipeExporter exporter) {
        GemstyneToolItems.ALDUS.getToolMap().values().forEach(toolPair -> offerBasicToolRecipe(exporter, toolPair.tool(), GemstyneToolItems.ALDUS.source));
        GemstyneToolItems.BRONZE.getToolMap().values().forEach(toolPair -> offerBasicToolRecipe(exporter, toolPair.tool(), GemstyneToolItems.BRONZE.source));
        GemstyneToolItems.MUTALIUM.getToolMap().values().forEach(toolPair -> offerBasicToolRecipe(exporter, toolPair.tool(), GemstyneToolItems.MUTALIUM.source));

        // =====
        // <===== Rendfire =====>
        // =====
        offerCoreToolRecipe(exporter, ItemHandler.CRIMONITE.ingot(),
                ItemHandler.FIRE_OPAL, GemstyneToolItems.RENDFIRE.getAxe());
        offerCoreToolRecipe(exporter, ItemHandler.CRIMONITE.ingot(),
                ItemHandler.FIRE_OPAL, GemstyneToolItems.RENDFIRE.getHoe());
        offerCoreToolRecipe(exporter, ItemHandler.CRIMONITE.ingot(),
                ItemHandler.FIRE_OPAL, GemstyneToolItems.RENDFIRE.getPickaxe());
        offerCoreToolRecipe(exporter, ItemHandler.CRIMONITE.ingot(),
                ItemHandler.FIRE_OPAL, GemstyneToolItems.RENDFIRE.getShovel());
        offerCoreToolRecipe(exporter, ItemHandler.CRIMONITE.ingot(),
            ItemHandler.FIRE_OPAL, GemstyneToolItems.RENDFIRE.getSword());
    }

    private static void offerBasicToolRecipe(
            RecipeExporter exporter,
            Item output,
            Item input) {
        String patternOne;
        String patternTwo;
        String patternThree;

        if (output instanceof AxeItem) {
            patternOne = "II";
            patternTwo = "SI";
            patternThree = "S ";
        } else if (output instanceof HoeItem) {
            patternOne = "II";
            patternTwo = "S ";
            patternThree = "S ";
        } else if (output instanceof PickaxeItem) {
            patternOne = "III";
            patternTwo = " S ";
            patternThree = " S ";
        } else if (output instanceof ShovelItem) {
            patternOne = "I";
            patternTwo = "S";
            patternThree = "S";
        } else {
            patternOne = "I";
            patternTwo = "I";
            patternThree = "S";
        }

        if(output instanceof SwordItem) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern(patternOne)
                .pattern(patternTwo)
                .pattern(patternThree)
                .input('I', input)
                .input('S', Items.STICK)
                .criterion(RecipeProvider.hasItem(input),
                    RecipeProvider.conditionsFromItem(input))
                .criterion(RecipeProvider.hasItem(Items.STICK),
                    RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(output)));
        } else {
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern(patternOne)
                .pattern(patternTwo)
                .pattern(patternThree)
                .input('I', input)
                .input('S', Items.STICK)
                .criterion(RecipeProvider.hasItem(input),
                    RecipeProvider.conditionsFromItem(input))
                .criterion(RecipeProvider.hasItem(Items.STICK),
                    RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(output)));
        }
    }


    private static void offerCoreToolRecipe(
            RecipeExporter exporter,
            Item input,
            Item core,
            Item output) {
        String patternOne;
        String patternTwo;
        String patternThree;

        if (output instanceof AxeItem) {
            patternOne = "OI";
            patternTwo = "SI";
            patternThree = "S ";
        } else if (output instanceof HoeItem) {
            patternOne = "OI";
            patternTwo = "S ";
            patternThree = "S ";
        } else if (output instanceof PickaxeItem) {
            patternOne = "IOI";
            patternTwo = " S ";
            patternThree = " S ";
        } else if (output instanceof ShovelItem) {
            patternOne = "IO";
            patternTwo = "S ";
            patternThree = "S ";
        } else {
            patternOne = "I ";
            patternTwo = "IO";
            patternThree = "S ";
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern(patternOne)
                .pattern(patternTwo)
                .pattern(patternThree)
                .input('I', input)
                .input('O', core)
                .input('S', Items.STICK)
                .criterion(RecipeProvider.hasItem(input),
                        RecipeProvider.conditionsFromItem(input))
                .criterion(RecipeProvider.hasItem(core),
                    RecipeProvider.conditionsFromItem(core))
                .criterion(RecipeProvider.hasItem(Items.STICK),
                    RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(output)));
    }
}
