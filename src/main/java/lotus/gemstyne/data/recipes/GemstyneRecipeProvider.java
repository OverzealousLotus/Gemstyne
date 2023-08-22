package lotus.gemstyne.data.recipes;

import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.equipment.GemstyneArmorItems;
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
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.RAW_URANIUM),
                GemstyneOreItems.URANIUM_CHUNK, 300, 150, 1.0f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.RAW_CRIMONITE),
                GemstyneOreItems.CRIMONITE_CHUNK, 350, 175, 1.0f);
        offerCompleteSmelting(exporter, List.of(GemstyneOreItems.RAW_ALDUS),
                GemstyneOreItems.ALDUS_INGOT, 200, 100, 1.0f);

        offerSmelting(exporter, List.of(GemstyneArmorItems.BRONZEPLATE.HELMET), RecipeCategory.MISC,
                GemstyneOreItems.BRONZE_NUGGET, 1.0f, 350, "gemstyne");
        offerSmelting(exporter, List.of(GemstyneArmorItems.BRONZEPLATE.CHESTPLATE), RecipeCategory.MISC,
                GemstyneOreItems.BRONZE_NUGGET, 1.0f, 350, "gemstyne");
        offerSmelting(exporter, List.of(GemstyneArmorItems.BRONZEPLATE.LEGGINGS), RecipeCategory.MISC,
                GemstyneOreItems.BRONZE_NUGGET, 1.0f, 350, "gemstyne");
        offerSmelting(exporter, List.of(GemstyneArmorItems.BRONZEPLATE.BOOTS), RecipeCategory.MISC,
                GemstyneOreItems.BRONZE_NUGGET, 1.0f, 350, "gemstyne");

        // =====
        // <===== Reversible =====>
        // =====
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.MOCHITE, RecipeCategory.DECORATIONS,
                GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.RAW_MOCHITE, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.RAW_MOCHITE_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock(), RecipeCategory.DECORATIONS,
                GemstyneOreItems.URANIUM_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                GemstyneOreItems.RAW_URANIUM, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.RAW_URANIUM_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.FIRE_OPAL, RecipeCategory.DECORATIONS,
                GemstyneDecorBlocks.DECOR_BLOCKS.fireOpalBlock());

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.CRIMONITE_INGOT, RecipeCategory.DECORATIONS,
                GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.RAW_CRIMONITE, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.RAW_CRIMONITE_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ALDUS_INGOT, RecipeCategory.DECORATIONS,
                GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.RAW_ALDUS, RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.RAW_ALDUS_BLOCK);

        // =====
        // <===== Ingots =====>
        // =====
        offerReversibleNuggetRecipe(exporter,
                GemstyneOreItems.BRONZE_INGOT, GemstyneOreItems.BRONZE_NUGGET,
                "bronze_ingot_to_nugget", "bronze_nugget_to_ingot");

        offerBasicIngotRecipe(exporter, GemstyneOreItems.URANIUM_CHUNK,
                GemstyneOreItems.URANIUM_INGOT, "uranium_chunk_to_ingot");
        offerBasicIngotRecipe(exporter, GemstyneOreItems.CRIMONITE_CHUNK,
                GemstyneOreItems.CRIMONITE_INGOT, "crimonite_chunk_to_ingot");

        offerAlloyIngotRecipe(exporter, Items.COPPER_INGOT, GemstyneOreItems.TIN_INGOT,
                GemstyneOreItems.BRONZE_INGOT, "bronze_ingot");

        // =====
        // <===== Shapeless =====>
        // =====

        // =====
        // <===== Shaped =====>
        // =====
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GemstyneOreItems.BRONZE_RING)
                .pattern(" N ")
                .pattern("N N")
                .pattern(" N ")
                .input('N', GemstyneOreItems.BRONZE_NUGGET)
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.BRONZE_NUGGET),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.BRONZE_NUGGET))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(GemstyneOreItems.BRONZE_RING)));

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
