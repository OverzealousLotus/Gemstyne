package lotus.gemstyne.fluid;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Overwatch;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class FluidHandler {
    private FluidHandler() {}
    
    public static final FlowableFluid STILL_LIQUID_MORKITE = Registry.register(Registries.FLUID,
        GemstyneRegistry.id("liquid_morkite"), new LiquidMorkite.Still());
    public static final FlowableFluid FLOWING_LIQUID_MORKITE = Registry.register(Registries.FLUID,
        GemstyneRegistry.id("flowing_liquid_morkite"), new LiquidMorkite.Flowing());

    public static final Block LIQUID_MORKITE_BLOCK = Registry.register(Registries.BLOCK, GemstyneRegistry.id("liquid_morkite_block"),
        new FluidBlock(FluidHandler.STILL_LIQUID_MORKITE, AbstractBlock.Settings.copy(Blocks.WATER)
            .replaceable().liquid()));
    public static final Item LIQUID_MORKITE_BUCKET = GemstyneRegistry.designateItem("liquid_morkite_bucket",
        new BucketItem(FluidHandler.STILL_LIQUID_MORKITE,
            new OwoItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(GemstyneCreativeGroup.GEMSTYNE)));

    public static void registerFluids() {
        Overwatch.info("Registering Fluids...");
        Overwatch.info("Successfully registered Fluids!");
    }
}
