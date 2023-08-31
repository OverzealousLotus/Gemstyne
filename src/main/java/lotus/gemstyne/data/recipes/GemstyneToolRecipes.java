package lotus.gemstyne.data.recipes;

import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import lotus.gemstyne.tool.GemstyneToolItems;
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
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.ALDUS.axe,
                GemstyneOreItems.ALDUS.ingot());
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.ALDUS.hoe,
                GemstyneOreItems.ALDUS.ingot());
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.ALDUS.pickaxe,
                GemstyneOreItems.ALDUS.ingot());
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.ALDUS.shovel,
                GemstyneOreItems.ALDUS.ingot());
        offerBasicToolRecipe(exporter, RecipeCategory.COMBAT, GemstyneToolItems.ALDUS.sword,
                GemstyneOreItems.ALDUS.ingot());

        // =====
        // <===== Bronze =====>
        // =====
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.BRONZE.axe,
                GemstyneOreItems.BRONZE.ingot());
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.BRONZE.hoe,
                GemstyneOreItems.BRONZE.ingot());
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.BRONZE.pickaxe,
                GemstyneOreItems.BRONZE.ingot());
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.BRONZE.shovel,
                GemstyneOreItems.BRONZE.ingot());
        offerBasicToolRecipe(exporter, RecipeCategory.COMBAT, GemstyneToolItems.BRONZE.sword,
                GemstyneOreItems.BRONZE.ingot());

        // =====
        // <===== Rendfire =====>
        // =====
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE.ingot(),
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.axe);
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE.ingot(),
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.hoe);
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE.ingot(),
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.pickaxe);
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE.ingot(),
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.shovel);
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE.ingot(),
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.sword);
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
            Item input,
            Item core,
            Item output) {
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
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
