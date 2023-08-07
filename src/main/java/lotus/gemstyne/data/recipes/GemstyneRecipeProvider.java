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

        offerSmelting(exporter, List.of(GemstyneOreItems.ORE_ITEMS.rawMochite()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.mochite(), 0.5f, 200, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.ORE_ITEMS.rawMochite()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.mochite(), 0.5f, 100, "gemstyne");

        offerSmelting(exporter, List.of(GemstyneOreItems.ORE_ITEMS.rawUranium()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.uraniumChunk(), 1.0f, 300, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.ORE_ITEMS.rawUranium()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.uraniumChunk(), 1.0f, 150, "gemstyne");

        offerSmelting(exporter, List.of(GemstyneOreItems.ORE_ITEMS.rawCrimonite()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.crimoniteChunk(), 1.0f, 350, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.ORE_ITEMS.rawCrimonite()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.crimoniteChunk(), 1.0f, 175, "gemstyne");

        offerSmelting(exporter, List.of(GemstyneOreItems.ORE_ITEMS.rawAldus()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.aldusIngot(), 1.0f, 200, "gemstyne");
        offerBlasting(exporter, List.of(GemstyneOreItems.ORE_ITEMS.rawAldus()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.aldusIngot(), 1.0f, 100, "gemstyne");

        offerSmelting(exporter, List.of(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateHelmet()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.bronzeNugget(), 1.0f, 350, "gemstyne");
        offerSmelting(exporter, List.of(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateChestplate()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.bronzeNugget(), 1.0f, 350, "gemstyne");
        offerSmelting(exporter, List.of(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateLeggings()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.bronzeNugget(), 1.0f, 350, "gemstyne");
        offerSmelting(exporter, List.of(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateBoots()), RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.bronzeNugget(), 1.0f, 350, "gemstyne");

        // =====
        // <===== Reversible =====>
        // =====
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ORE_ITEMS.mochite(), RecipeCategory.DECORATIONS,
                GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ORE_ITEMS.rawMochite(), RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.ORE_BLOCKS.rawMochiteBlock());

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock(), RecipeCategory.DECORATIONS,
                GemstyneOreItems.ORE_ITEMS.uraniumIngot());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.rawUranium(), RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.ORE_BLOCKS.rawUraniumBlock());

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ORE_ITEMS.fireOpal(), RecipeCategory.DECORATIONS,
                GemstyneDecorBlocks.DECOR_BLOCKS.fireOpalBlock());

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ORE_ITEMS.crimoniteIngot(), RecipeCategory.DECORATIONS,
                GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ORE_ITEMS.rawCrimonite(), RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.ORE_BLOCKS.rawCrimoniteBlock());

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ORE_ITEMS.aldusIngot(), RecipeCategory.DECORATIONS,
                GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                GemstyneOreItems.ORE_ITEMS.rawAldus(), RecipeCategory.DECORATIONS,
                GemstyneOreBlocks.ORE_BLOCKS.rawAldusBlock());

        // =====
        // <===== Ingots =====>
        // =====
        offerBasicIngotRecipe(exporter, RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.uraniumChunk(), GemstyneOreItems.ORE_ITEMS.uraniumIngot(), GemstyneOreItems.ORE_ITEMS.uraniumChunk());
        offerBasicIngotRecipe(exporter, RecipeCategory.MISC,
                GemstyneOreItems.ORE_ITEMS.crimoniteChunk(), GemstyneOreItems.ORE_ITEMS.crimoniteIngot(), GemstyneOreItems.ORE_ITEMS.crimoniteChunk());

        offerAlloyIngotRecipe(exporter, RecipeCategory.MISC, Items.COPPER_INGOT, GemstyneOreItems.ORE_ITEMS.tinIngot(),
                GemstyneOreItems.ORE_ITEMS.bronzeIngot(), GemstyneOreItems.ORE_ITEMS.bronzeIngot());

        // =====
        // <===== Shapeless =====>
        // =====

        // =====
        // <===== Shaped =====>
        // =====
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GemstyneGearItems.IMBUED_FEATHER)
                .pattern(" O ")
                .pattern("OIO")
                .pattern("IO ")
                .input('O', GemstyneOreItems.ORE_ITEMS.ikarite())
                .input('I', GemstyneCraftingItems.getImbuedRod())
                .criterion(FabricRecipeProvider.hasItem(GemstyneCraftingItems.getImbuedRod()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneCraftingItems.getImbuedRod()))
                .criterion(FabricRecipeProvider.hasItem(GemstyneOreItems.ORE_ITEMS.ikarite()),
                        FabricRecipeProvider.conditionsFromItem(GemstyneOreItems.ORE_ITEMS.ikarite()))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(GemstyneGearItems.IMBUED_FEATHER)));


        GemstyneArmorRecipes.generateArmorRecipes(exporter);
        GemstyneToolRecipes.generateToolRecipes(exporter);
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

    private static void offerAlloyIngotRecipe(
            Consumer<RecipeJsonProvider> exporter, RecipeCategory category, Item ingot_one, Item ingot_two, Item output, Item name) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("AB")
                .input('A', ingot_one)
                .input('B', ingot_two)
                .criterion(FabricRecipeProvider.hasItem(ingot_one),
                        FabricRecipeProvider.conditionsFromItem(ingot_one))
                .criterion(FabricRecipeProvider.hasItem(ingot_two),
                        FabricRecipeProvider.conditionsFromItem(ingot_two))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(name)));
    }
}
