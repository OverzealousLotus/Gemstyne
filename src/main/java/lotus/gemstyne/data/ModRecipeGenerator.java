package lotus.gemstyne.data;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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
                ModItems.MOCHITE, RecipeCategory.DECORATIONS, GemstyneOreBlocks.MOCHITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.RAW_MOCHITE, RecipeCategory.DECORATIONS, GemstyneOreBlocks.RAW_MOCHITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.URANIUM_INGOT, RecipeCategory.DECORATIONS, GemstyneOreBlocks.URANIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                ModItems.RAW_URANIUM, RecipeCategory.DECORATIONS, GemstyneOreBlocks.RAW_URANIUM_BLOCK);

        // =====
        // <===== Shapeless =====>
        // =====

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RENDFIRE_HELMET)
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .input('C', ModItems.CRIMONITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RENDFIRE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RENDFIRE_CHESTPLATE)
                .pattern("C C")
                .pattern("CFC")
                .pattern("CCC")
                .input('C', ModItems.CRIMONITE_INGOT)
                .input('F', ModItems.FIRE_OPAL)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FIRE_OPAL),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FIRE_OPAL))
                .criterion(FabricRecipeProvider.hasItem(ModItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RENDFIRE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RENDFIRE_LEGGINGS)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .input('C',ModItems.CRIMONITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RENDFIRE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RENDFIRE_BOOTS)
                .pattern("   ")
                .pattern("C C")
                .pattern("C C")
                .input('C',ModItems.CRIMONITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.CRIMONITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CRIMONITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RENDFIRE_BOOTS)));
    }
}
