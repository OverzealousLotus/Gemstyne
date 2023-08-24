package lotus.gemstyne.data.recipes;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class GemstyneRecipeProvider extends FabricRecipeProvider {
    public GemstyneRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // =====
        // <===== Smelting/Blasting =====>
        // =====

        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.RAW_MOCHITE),
                GemstyneOreItems.MOCHITE, 200, 100, 0.5f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.URANIUM.RAW),
                GemstyneOreItems.URANIUM.CHUNK, 300, 150, 1.0f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.CRIMONITE.RAW),
                GemstyneOreItems.CRIMONITE.CHUNK, 350, 175, 1.0f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.ALDUS.RAW),
                GemstyneOreItems.ALDUS.INGOT, 200, 100, 1.0f);

        offerSmelting(exporter, List.of(GemstyneArmorItems.BRONZEPLATE.HELMET), RecipeCategory.MISC,
                GemstyneOreItems.BRONZE.NUGGET, 1.0f, 350, "gemstyne");
        offerSmelting(exporter, List.of(GemstyneArmorItems.BRONZEPLATE.CHESTPLATE), RecipeCategory.MISC,
                GemstyneOreItems.BRONZE.NUGGET, 1.0f, 350, "gemstyne");
        offerSmelting(exporter, List.of(GemstyneArmorItems.BRONZEPLATE.LEGGINGS), RecipeCategory.MISC,
                GemstyneOreItems.BRONZE.NUGGET, 1.0f, 350, "gemstyne");
        offerSmelting(exporter, List.of(GemstyneArmorItems.BRONZEPLATE.BOOTS), RecipeCategory.MISC,
                GemstyneOreItems.BRONZE.NUGGET, 1.0f, 350, "gemstyne");

        // =====
        // <===== Reversible =====>
        // =====
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.MOCHITE, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.MOCHITE.pureBlock);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.RAW_MOCHITE, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.MOCHITE.rawBlock);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreBlocks.URANIUM.pureBlock, RecipeCategory.DECORATIONS,
                GemstyneOreItems.URANIUM.INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                GemstyneOreItems.URANIUM.RAW, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.URANIUM.rawBlock);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.FIRE_OPAL, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.FIRE_OPAL_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.CRIMONITE.INGOT, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.CRIMONITE.pureBlock);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.CRIMONITE.RAW, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.CRIMONITE.rawBlock);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ALDUS.INGOT, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.ALDUS.pureBlock);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ALDUS.RAW, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.ALDUS.rawBlock);

        // =====
        // <===== Ingots =====>
        // =====
        offerReversibleNuggetRecipe(exporter,
                GemstyneOreItems.BRONZE.INGOT, GemstyneOreItems.BRONZE.NUGGET,
                "bronze_ingot_to_nugget", "bronze_nugget_to_ingot");

        offerBasicIngotRecipe(exporter, GemstyneOreItems.URANIUM.CHUNK,
                GemstyneOreItems.URANIUM.INGOT, "uranium_chunk_to_ingot");
        offerBasicIngotRecipe(exporter, GemstyneOreItems.CRIMONITE.CHUNK,
                GemstyneOreItems.CRIMONITE.INGOT, "crimonite_chunk_to_ingot");

        offerAlloyIngotRecipe(exporter, Items.COPPER_INGOT, GemstyneOreItems.TIN.INGOT,
                GemstyneOreItems.BRONZE.INGOT, "bronze_ingot");

        // =====
        // <===== Shapeless =====>
        // =====

        // =====
        // <===== Shaped =====>
        // =====
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GemstyneOreItems.BRONZE.CHAIN)
                .pattern(" N ")
                .pattern("N N")
                .pattern(" N ")
                .input('N', GemstyneOreItems.BRONZE.NUGGET)
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.BRONZE.NUGGET),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.BRONZE.NUGGET))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(GemstyneOreItems.BRONZE.CHAIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GemstyneCraftingItems.getImbuedRod())
                .pattern(" Q ")
                .pattern("QBQ")
                .pattern(" Q ")
                .input('Q', Items.QUARTZ)
                .input('B', Items.BLAZE_ROD)
                .criterion(FabricRecipeProvider.hasItem(Items.QUARTZ),
                        FabricRecipeProvider.conditionsFromItem(Items.QUARTZ))
                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_ROD),
                        FabricRecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(GemstyneCraftingItems.getImbuedRod())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GemstyneGearItems.getImbuedFeather())
                .pattern(" O ")
                .pattern("OIO")
                .pattern("IO ")
                .input('O', GemstyneOreItems.IKARITE)
                .input('I', GemstyneCraftingItems.getImbuedRod())
                .criterion(FabricRecipeProvider.hasItem(GemstyneCraftingItems.getImbuedRod()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneCraftingItems.getImbuedRod()))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.IKARITE),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.IKARITE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(GemstyneGearItems.getImbuedFeather())));


        GemstyneArmorRecipes.generateArmorRecipes(exporter);
        GemstyneToolRecipes.generateToolRecipes(exporter);
    }

    private static void offerCompleteSmelting(
            Consumer<RecipeJsonProvider> exporter,
            List<ItemConvertible> inputs,
            Item output,
            int smeltingTime,
            int blastingTime,
            float experience
    ) {
        offerSmelting(exporter, inputs, RecipeCategory.MISC, output, experience, smeltingTime, "gemstyne");
        offerBlasting(exporter, inputs, RecipeCategory.MISC, output, experience, blastingTime, "gemstyne");
    }

    private static void offerBasicIngotRecipe(
            Consumer<RecipeJsonProvider> exporter, Item input, Item output, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("CC")
                .pattern("CC")
                .input('C', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(name));
    }

    private static void offerAlloyIngotRecipe(
            Consumer<RecipeJsonProvider> exporter, Item ingot_one, Item ingot_two, Item output, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("AB")
                .input('A', ingot_one)
                .input('B', ingot_two)
                .criterion(FabricRecipeProvider.hasItem(ingot_one),
                        FabricRecipeProvider.conditionsFromItem(ingot_one))
                .criterion(FabricRecipeProvider.hasItem(ingot_two),
                        FabricRecipeProvider.conditionsFromItem(ingot_two))
                .offerTo(exporter, new Identifier(name));
    }

    private static void offerReversibleNuggetRecipe(
            Consumer<RecipeJsonProvider> exporter, Item ingot, Item nugget, String ingot_name, String nugget_name) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, nugget, 9)
                .input(ingot)
                .criterion(FabricRecipeProvider.hasItem(ingot),
                        FabricRecipeProvider.conditionsFromItem(ingot))
                .offerTo(exporter, new Identifier(nugget_name));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ingot)
                .input(nugget, 9)
                .criterion(FabricRecipeProvider.hasItem(nugget),
                        FabricRecipeProvider.conditionsFromItem(nugget))
                .offerTo(exporter, new Identifier(ingot_name));
    }
}
