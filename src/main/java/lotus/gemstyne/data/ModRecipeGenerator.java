package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.GemstyneOreItems;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
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
        offerSmelting(exporter, List.of(GemstyneOreItems.RAW_MOCHITE), RecipeCategory.MISC,
                GemstyneOreItems.MOCHITE, 0.5f, 200, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.RAW_MOCHITE), RecipeCategory.MISC,
                GemstyneOreItems.MOCHITE, 0.5f, 100, "gemstyne");

        offerSmelting(exporter, List.of(GemstyneOreItems.RAW_URANIUM), RecipeCategory.MISC,
                GemstyneOreItems.URANIUM_CHUNK, 1.0f, 300, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.RAW_URANIUM), RecipeCategory.MISC,
                GemstyneOreItems.URANIUM_CHUNK, 1.0f, 150, "gemstyne");

        offerSmelting(exporter, List.of(GemstyneOreItems.RAW_CRIMONITE), RecipeCategory.MISC,
                GemstyneOreItems.CRIMONITE_CHUNK, 1.0f, 350, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.RAW_CRIMONITE), RecipeCategory.MISC,
                GemstyneOreItems.CRIMONITE_CHUNK, 1.0f, 175, "gemstyne");

        // =====
        // <===== Reversible =====>
        // =====
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.MOCHITE, RecipeCategory.DECORATIONS, GemstyneOreBlocks.MOCHITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.RAW_MOCHITE, RecipeCategory.DECORATIONS, GemstyneOreBlocks.RAW_MOCHITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreBlocks.URANIUM_BLOCK, RecipeCategory.DECORATIONS, GemstyneOreItems.URANIUM_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                GemstyneOreItems.RAW_URANIUM, RecipeCategory.DECORATIONS, GemstyneOreBlocks.RAW_URANIUM_BLOCK);

        // =====
        // <===== Ingots =====>
        // =====
        offerBasicIngotRecipe(exporter, RecipeCategory.MISC,
                GemstyneOreItems.URANIUM_CHUNK, GemstyneOreItems.URANIUM_INGOT, GemstyneOreItems.URANIUM_CHUNK);
        offerBasicIngotRecipe(exporter, RecipeCategory.MISC,
                GemstyneOreItems.CRIMONITE_CHUNK, GemstyneOreItems.CRIMONITE_INGOT, GemstyneOreItems.CRIMONITE_CHUNK);

        // =====
        // <===== Shapeless =====>
        // =====

        // =====
        // <===== Shaped =====>
        // =====

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
                .input('O', GemstyneOreItems.IKARITE)
                .input('I', ModItems.IMBUED_ROD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.IMBUED_ROD),
                        FabricRecipeProvider.conditionsFromItem(ModItems.IMBUED_ROD))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.IKARITE),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.IKARITE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.IMBUED_FEATHER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RENDFIRE_HELMET)
                .pattern("CCC")
                .pattern("C C")
                .input('C', GemstyneOreItems.CRIMONITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RENDFIRE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RENDFIRE_CHESTPLATE)
                .pattern("C C")
                .pattern("CFC")
                .pattern("CCC")
                .input('C', GemstyneOreItems.CRIMONITE_INGOT)
                .input('F', GemstyneOreItems.FIRE_OPAL)
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.FIRE_OPAL),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.FIRE_OPAL))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RENDFIRE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RENDFIRE_LEGGINGS)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .input('C', GemstyneOreItems.CRIMONITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RENDFIRE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RENDFIRE_BOOTS)
                .pattern("C C")
                .pattern("C C")
                .input('C', GemstyneOreItems.CRIMONITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RENDFIRE_BOOTS)));
    }
    private static void offerBasicIngotRecipe(
            Consumer<RecipeJsonProvider> exporter, RecipeCategory category, Item input, Item output, Item name) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("CC")
                .pattern("CC")
                .input('C', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(name)));
    }
}
