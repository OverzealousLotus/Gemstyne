package lotus.gemstyne.fluid;
import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GemstyneFluids {
    public static final FlowableFluid STILL_LIQUID_MORKITE = Registry.register(Registries.FLUID,
            new Identifier(Gemstyne.MOD_ID, "liquid_morkite"), new LiquidMorkite.Still());
    public static final FlowableFluid FLOWING_LIQUID_MORKITE = Registry.register(Registries.FLUID,
            new Identifier(Gemstyne.MOD_ID, "flowing_liquid_morkite"), new LiquidMorkite.Flowing());

    public static final Block LIQUID_MORKITE_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Gemstyne.MOD_ID,
            "liquid_morkite_block"), new FluidBlock(GemstyneFluids.STILL_LIQUID_MORKITE, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));
    public static final Item LIQUID_MORKITE_BUCKET = Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID,
            "liquid_morkite_bucket"), new BucketItem(GemstyneFluids.STILL_LIQUID_MORKITE,
            new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static void registerFluids() {
        Gemstyne.LOGGER.info("Registering Fluid for " + Gemstyne.MOD_ID);
    }
}
