package lotus.gemstyne.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

/**
 * <h2>GemstyneItemSet</h2>
 * A simple class, providing a compact way of creating a set of basic items for Gemstyne.
 * For further extensions, see {@link GemstyneFlexibleItemSet} or {@link GemstyneIntricateItemSet}
 */
public final class GemstyneItemSet {
    public final Item RAW;
    public final Item NUGGET;
    public final Item INGOT;

    /**
     * Generic Item set creation. This contains only a Raw, Nugget, and Ingot variant. All three
     * are presumed to be present.
     * @param settings {@link FabricItemSettings} for set
     * @param setName Name of set
     */
    public GemstyneItemSet(FabricItemSettings settings, String setName) {
        this.RAW = GemstyneItemHandler.assignItem(settings);
        this.NUGGET = GemstyneItemHandler.assignItem(settings);
        this.INGOT = GemstyneItemHandler.assignItem(settings);

        GemstyneItemHandler.registerItem(this.RAW, "raw_" + setName);
        GemstyneItemHandler.registerItem(this.NUGGET, setName + "_nugget");
        GemstyneItemHandler.registerItem(this.INGOT, setName + "_ingot");
    }
}
