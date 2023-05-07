package lotus.gemstyne.item.equipment;

import lotus.gemstyne.item.GemstyneItemHandler;
import lotus.gemstyne.item.custom.ImbuedFeatherItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class GemstyneGearItems {
    public static final Item IMBUED_FEATHER = GemstyneItemHandler.registerItem("imbued_feather",
            new ImbuedFeatherItem(new FabricItemSettings().maxCount(1).maxDamage(20)));
}
