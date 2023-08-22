package lotus.gemstyne.data.recipes;

import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import lotus.gemstyne.item.equipment.GemstyneToolItems;
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
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.ALDUS.AXE,
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.ALDUS.HOE,
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.ALDUS.PICKAXE,
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.ALDUS.SHOVEL,
                GemstyneOreItems.ALDUS_INGOT);
        offerBasicToolRecipe(exporter, RecipeCategory.COMBAT, GemstyneToolItems.ALDUS.SWORD,
                GemstyneOreItems.ALDUS_INGOT);

        // =====
        // <===== Bronze =====>
        // =====
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.BRONZE.AXE,
                GemstyneOreItems.BRONZE_INGOT);
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.BRONZE.HOE,
                GemstyneOreItems.BRONZE_INGOT);
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.BRONZE.PICKAXE,
                GemstyneOreItems.BRONZE_INGOT);
        offerBasicToolRecipe(exporter, RecipeCategory.TOOLS, GemstyneToolItems.BRONZE.SHOVEL,
                GemstyneOreItems.BRONZE_INGOT);
        offerBasicToolRecipe(exporter, RecipeCategory.COMBAT, GemstyneToolItems.BRONZE.SWORD,
                GemstyneOreItems.BRONZE_INGOT);

        // =====
        // <===== Rendfire =====>
        // =====
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE_INGOT,
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.AXE);
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE_INGOT,
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.HOE);
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE_INGOT,
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.PICKAXE);
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE_INGOT,
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.SHOVEL);
        offerCoreToolRecipe(exporter, GemstyneOreItems.CRIMONITE_INGOT,
                GemstyneOreItems.FIRE_OPAL, GemstyneToolItems.RENDFIRE.SWORD);
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
