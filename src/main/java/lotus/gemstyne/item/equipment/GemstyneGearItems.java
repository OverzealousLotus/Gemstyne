package lotus.gemstyne.item.equipment;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.custom.ImbuedFeatherItem;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.item.Item;

public class GemstyneGearItems {
    private static final Item IMBUED_FEATHER = GemstyneRegistry.designateItem("imbued_feather",
            new ImbuedFeatherItem(new OwoItemSettings().maxCount(1).maxDamage(20)
                    .group(GemstyneCreativeGroup.GEMSTYNE))
    );

    public static Item getImbuedFeather() {
        return IMBUED_FEATHER;
    }

    public static void registerGearItems() {
        Gemstyne.LOGGER.info("Registering Gear Items..."); }
}
