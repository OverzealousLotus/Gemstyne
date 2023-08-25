package lotus.gemstyne.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

/**
 * <h2>GemstyneItemSet</h2>
 * A simple class, providing a compact way of creating a set of basic items for Gemstyne.
 */
public final class GemstyneItemSet {
    public Item RAW;
    public Item NUGGET;
    public Item LUMP;
    public Item INGOT;
    public Item CHAIN;

    private FabricItemSettings currentSettings = new FabricItemSettings();
    private final String SET_NAME;

    /**
     * Generic Item set creation. This contains only a Raw, Nugget, and Ingot variant. All three
     * are presumed to be present.
     * @param setName Name of set
     */
    public GemstyneItemSet(String setName) {
        this.SET_NAME = setName;
    }

    public GemstyneItemSet addFood(FoodComponent nutrients) {
        this.currentSettings = this.currentSettings.food(nutrients);

        return this;
    }

    public GemstyneItemSet createRaw() {
        this.RAW = GemstyneItemHandler.assignItem(this.currentSettings);
        GemstyneItemHandler.registerItem(this.RAW, "raw_" + this.SET_NAME);

        return this;
    }

    public GemstyneItemSet createNugget() {
        this.NUGGET = GemstyneItemHandler.assignItem(this.currentSettings);
        GemstyneItemHandler.registerItem(this.NUGGET, this.SET_NAME + "_nugget");

        return this;
    }

    public GemstyneItemSet createLump() {
        this.LUMP = GemstyneItemHandler.assignItem(this.currentSettings);
        GemstyneItemHandler.registerItem(this.LUMP, this.SET_NAME + "_chunk");

        return this;
    }

    public GemstyneItemSet createIngot() {
        this.INGOT = GemstyneItemHandler.assignItem(this.currentSettings);
        GemstyneItemHandler.registerItem(this.INGOT, this.SET_NAME + "_ingot");

        return this;
    }

    public GemstyneItemSet createChain() {
        this.CHAIN = GemstyneItemHandler.assignItem(this.currentSettings);
        GemstyneItemHandler.registerItem(this.CHAIN, this.SET_NAME + "_chain");

        return this;
    }

    public GemstyneItemSet createDefaultItemSet() {
        return this.createRaw()
                .createNugget()
                .createIngot();
    }
}
