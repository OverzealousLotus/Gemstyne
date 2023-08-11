package lotus.gemstyne.item.equipment;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.GemstyneItemHandler;
import lotus.gemstyne.item.custom.ImbuedFeatherItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class GemstyneGearItems {
    private static final Item IMBUED_FEATHER = GemstyneItemHandler.registerItem("imbued_feather",
            new ImbuedFeatherItem(new FabricItemSettings().maxCount(1).maxDamage(20)));

    private static final Item LIQUID_MORKITE_BUCKET = GemstyneItemHandler.registerItem("liquid_morkite_bucket",
            new BucketItem(GemstyneFluids.STILL_LIQUID_MORKITE,
                    new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static Item getImbuedFeather() {
        return IMBUED_FEATHER;
    }
    public static Item getLiquidMorkiteBucket() { return LIQUID_MORKITE_BUCKET; }

    public static void registerGearItems() {
        Gemstyne.LOGGER.info("Registering Gear Items..."); }
}
