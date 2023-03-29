package lotus.tutorialmod.data;

import lotus.tutorialmod.block.ModBlocks;
import lotus.tutorialmod.item.ModItems;
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
        offerSmelting(exporter, List.of(ModItems.RAW_MOCHITE), RecipeCategory.MISC,
                ModItems.MOCHITE, 0.5f, 200, "gemstyne");
        offerBlasting(exporter, List.of(ModItems.RAW_MOCHITE), RecipeCategory.MISC,
                ModItems.MOCHITE, 0.5f, 100, "gemstyne");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.MOCHITE, RecipeCategory.DECORATIONS, ModBlocks.MOCHITE_BLOCK);

        // Just an example. Not final.
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_MOCHITE)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('M', ModItems.MOCHITE)
                .criterion(FabricRecipeProvider.hasItem(Items.STONE),
                        FabricRecipeProvider.conditionsFromItem(Items.STONE))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MOCHITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MOCHITE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RAW_MOCHITE)));
    }
}
