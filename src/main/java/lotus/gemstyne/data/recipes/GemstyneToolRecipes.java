package lotus.gemstyne.data.recipes;

import lotus.gemstyne.item.GemstyneOreItems;
import lotus.gemstyne.item.GemstyneToolItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

abstract class GemstyneToolRecipes extends FabricRecipeProvider {
    public GemstyneToolRecipes(FabricDataOutput output) {
        super(output);
    }


    protected static void generateToolRecipes(Consumer<RecipeJsonProvider> exporter) {
        // =====
        // <===== Aldus =====>
        // =====
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.getAldusAxe(),
                GemstyneOreItems.getAldusIngot());
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.getAldusHoe(),
                GemstyneOreItems.getAldusIngot());
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.getAldusPickaxe(),
                GemstyneOreItems.getAldusIngot());
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.getAldusShovel(),
                GemstyneOreItems.getAldusIngot());
        offerBasicToolRecipe(exporter, RecipeCategory.COMBAT, GemstyneToolItems.getAldusSword(),
                GemstyneOreItems.getAldusIngot());

        // =====
        // <===== Rendfire =====>
        // =====
        offerCoreToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneOreItems.getCrimoniteIngot(),
                GemstyneOreItems.getFireOpal(), GemstyneToolItems.getRendfireAxe());
        offerCoreToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneOreItems.getCrimoniteIngot(),
                GemstyneOreItems.getFireOpal(), GemstyneToolItems.getRendfireHoe());
        offerCoreToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneOreItems.getCrimoniteIngot(),
                GemstyneOreItems.getFireOpal(), GemstyneToolItems.getRendfirePickaxe());
        offerCoreToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneOreItems.getCrimoniteIngot(),
                GemstyneOreItems.getFireOpal(), GemstyneToolItems.getRendfireShovel());
        offerCoreToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneOreItems.getCrimoniteIngot(),
                GemstyneOreItems.getFireOpal(), GemstyneToolItems.getRendfireSword());
    }


    private static void offerBasicToolRecipe(
            Consumer<RecipeJsonProvider> exporter,
            RecipeCategory category, Item output,
            Item input) {
        String pattern_1;
        String pattern_2;
        String pattern_3;

        if (output instanceof AxeItem) {
            pattern_1 = "II";
            pattern_2 = "SI";
            pattern_3 = "S ";
        } else if (output instanceof HoeItem) {
            pattern_1 = "II";
            pattern_2 = "S ";
            pattern_3 = "S ";
        } else if (output instanceof PickaxeItem) {
            pattern_1 = "III";
            pattern_2 = " S ";
            pattern_3 = " S ";
        } else if (output instanceof ShovelItem) {
            pattern_1 = "I";
            pattern_2 = "S";
            pattern_3 = "S";
        } else {
            pattern_1 = "I";
            pattern_2 = "I";
            pattern_3 = "S";
        }

        ShapedRecipeJsonBuilder.create(category, output)
                .pattern(pattern_1)
                .pattern(pattern_2)
                .pattern(pattern_3)
                .input('I', input)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }


    private static void offerCoreToolRecipe(
            Consumer<RecipeJsonProvider> exporter,
            RecipeCategory category, Item input, Item core, Item output) {
        String pattern_1;
        String pattern_2;
        String pattern_3;

        if (output instanceof AxeItem) {
            pattern_1 = "OI";
            pattern_2 = "SI";
            pattern_3 = "S ";
        } else if (output instanceof HoeItem) {
            pattern_1 = "OI";
            pattern_2 = "S ";
            pattern_3 = "S ";
        } else if (output instanceof PickaxeItem) {
            pattern_1 = "IOI";
            pattern_2 = " S ";
            pattern_3 = " S ";
        } else if (output instanceof ShovelItem) {
            pattern_1 = "IO";
            pattern_2 = "S ";
            pattern_3 = "S ";
        } else {
            pattern_1 = "I ";
            pattern_2 = "IO";
            pattern_3 = "S ";
        }

        ShapedRecipeJsonBuilder.create(category, output)
                .pattern(pattern_1)
                .pattern(pattern_2)
                .pattern(pattern_3)
                .input('I', input)
                .input('O', core)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .criterion(FabricRecipeProvider.hasItem(core),
                        FabricRecipeProvider.conditionsFromItem(core))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }
}
