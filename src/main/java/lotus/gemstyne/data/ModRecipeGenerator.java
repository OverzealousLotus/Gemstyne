package lotus.gemstyne.data;

import lotus.gemstyne.block.ModBlocks;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // =====
        // <===== Smelting/Blasting =====>
        // =====
        offerSmelting(exporter, List.of(ModItems.RAW_MOCHITE), RecipeCategory.MISC,
                ModItems.MOCHITE, 0.5f, 200, "gemstyne");
        offerBlasting(exporter, List.of(ModItems.RAW_MOCHITE), RecipeCategory.MISC,
                ModItems.MOCHITE, 0.5f, 100, "gemstyne");

        offerSmelting(exporter, List.of(ModItems.RAW_URANIUM), RecipeCategory.MISC,
                ModItems.URANIUM_CHUNK, 1.0f, 300, "gemstyne");

        offerBlasting(exporter, List.of(ModItems.RAW_URANIUM), RecipeCategory.MISC,
                ModItems.URANIUM_CHUNK, 1.0f, 150, "gemstyne");

        // =====
        // <===== Reversible =====>
        // =====
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.MOCHITE, RecipeCategory.DECORATIONS, ModBlocks.MOCHITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.RAW_MOCHITE, RecipeCategory.DECORATIONS, ModBlocks.RAW_MOCHITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.URANIUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.URANIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                ModItems.RAW_URANIUM, RecipeCategory.DECORATIONS, ModBlocks.RAW_URANIUM_BLOCK);

        // =====
        // <===== Shapeless =====>
        // =====
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RED_MAPLE_PLANKS, 4)
                .input(ModBlocks.RED_MAPLE_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.RED_MAPLE_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.RED_MAPLE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.RED_MAPLE_PLANKS)));

        // =====
        // <===== Shaped =====>
        // =====
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.URANIUM_INGOT)
                .pattern("UU")
                .pattern("UU")
                .input('U', ModItems.URANIUM_CHUNK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.URANIUM_CHUNK),
                        FabricRecipeProvider.conditionsFromItem(ModItems.URANIUM_CHUNK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.URANIUM_CHUNK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IMBUED_ROD)
                .pattern(" Q ")
                .pattern("QBQ")
                .pattern(" Q ")
                .input('Q', Items.QUARTZ)
                .input('B', Items.BLAZE_ROD)
                .criterion(FabricRecipeProvider.hasItem(Items.QUARTZ),
                        FabricRecipeProvider.conditionsFromItem(Items.QUARTZ))
                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_ROD),
                        FabricRecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.IMBUED_ROD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IMBUED_FEATHER)
                .pattern(" O ")
                .pattern("OIO")
                .pattern("IO ")
                .input('O', ModItems.RAW_IKARITE)
                .input('I', ModItems.IMBUED_ROD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.IMBUED_ROD),
                        FabricRecipeProvider.conditionsFromItem(ModItems.IMBUED_ROD))
                .criterion(FabricRecipeProvider.hasItem(ModItems.RAW_IKARITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RAW_IKARITE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.IMBUED_FEATHER)));
    }
}
