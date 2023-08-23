package lotus.gemstyne.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

/**
 * <h2>GemstyneFlexibleItemSet</h2>
 * <code>GemstyneFlexibleItemSet</code> provides an additional "chain" variant. This class should only
 * be used when a set of Items is able to create Chainmail armor.
 */
public class GemstyneFlexibleItemSet {
    public final Item RAW;
    public final Item NUGGET;
    public final Item CHAIN;
    public final Item INGOT;

    public GemstyneFlexibleItemSet(FabricItemSettings settings, String setName) {
        this.RAW = GemstyneItemHandler.assignItem(settings);
        this.NUGGET = GemstyneItemHandler.assignItem(settings);
        this.CHAIN = GemstyneItemHandler.assignItem(settings);
        this.INGOT = GemstyneItemHandler.assignItem(settings);

        GemstyneItemHandler.registerItem(this.RAW, "raw_" + setName);
        GemstyneItemHandler.registerItem(this.NUGGET, setName + "_nugget");
        GemstyneItemHandler.registerItem(this.CHAIN, setName + "_chain");
        GemstyneItemHandler.registerItem(this.INGOT, setName + "_ingot");
    }
}
