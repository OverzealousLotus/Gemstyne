package lotus.gemstyne.fluid;

import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GemstyneFluids {
    public static FlowableFluid STILL_LIQUID_MORKITE;
    public static FlowableFluid FLOWING_LIQUID_MORKITE;
    public static Block LIQUID_MORKITE_BLOCK;


    public static void register() {

        STILL_LIQUID_MORKITE = Registry.register(Registries.FLUID,
                new Identifier(Gemstyne.MOD_ID, "liquid_morkite"), new LiquidMorkite.Still());
        FLOWING_LIQUID_MORKITE = Registry.register(Registries.FLUID,
                new Identifier(Gemstyne.MOD_ID, "flowing_liquid_morkite"), new LiquidMorkite.Flowing());

        LIQUID_MORKITE_BLOCK = Registry.register(Registries.BLOCK,
                new Identifier(Gemstyne.MOD_ID, "liquid_morkite_block"),
                new FluidBlock(GemstyneFluids.STILL_LIQUID_MORKITE, FabricBlockSettings.copyOf(Blocks.LAVA)));

    }
}
