package lotus.gemstyne.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

/**
 * <h2>GemstyneIntricateItemSet</h2>
 * A <code>GemstyneIntricateItemSet</code> provides an additional <code>chunk</code> variant, requiring
 * two steps of refinement before being able to use a material to its full potential.
 */
public final class GemstyneIntricateItemSet {
    public final Item RAW;
    public final Item CHUNK;
    public final Item NUGGET;
    public final Item INGOT;

    public GemstyneIntricateItemSet(FabricItemSettings settings, String setName) {
        this.RAW = GemstyneItemHandler.assignItem(settings);
        this.CHUNK = GemstyneItemHandler.assignItem(settings);
        this.NUGGET = GemstyneItemHandler.assignItem(settings);
        this.INGOT = GemstyneItemHandler.assignItem(settings);

        GemstyneItemHandler.registerItem(this.RAW, "raw_" + setName);
        GemstyneItemHandler.registerItem(this.CHUNK, setName + "_chunk");
        GemstyneItemHandler.registerItem(this.NUGGET, setName + "_nugget");
        GemstyneItemHandler.registerItem(this.INGOT, setName + "_ingot");
    }
}
