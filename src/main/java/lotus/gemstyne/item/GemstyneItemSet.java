package lotus.gemstyne.item;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <h2>GemstyneItemSet</h2>
 * A flexible way of creating a basic set of Items for Gemstyne.
 */
public final class GemstyneItemSet {
    /** <code>itemVariants</code> itself cannot be null, but its members can be. Refer to <code>safeFetch</code>*/
    @NotNull public Map<String, Item> itemVariants = new LinkedHashMap<>();

    private FabricItemSettings currentSettings = new OwoItemSettings().group(GemstyneCreativeGroup.GEMSTYNE);
    private final String SET_NAME;

    /**
     * Its constructor only requires the name of the set to get started.
     * @param setName Name of set
     */
    public GemstyneItemSet(String setName) {
        this.SET_NAME = setName;
    }

    public GemstyneItemSet addFood(FoodComponent nutrients) {
        this.currentSettings = this.currentSettings.food(nutrients);

        return this;
    }

    public String setName() {
        return this.SET_NAME;
    }

    public Item raw() {
        return safeFetch("raw");
    }
    public Item chunk() {
        return safeFetch("chunk");
    }
    public Item nugget() {
        return safeFetch("nugget");
    }
    public Item ingot() {
        return safeFetch("ingot");
    }
    public Item chain() {
        return safeFetch("chain");
    }
    public Item crystal() {
        return safeFetch(this.SET_NAME);
    }

    /**
     * Safely fetches an {@link Item} from {@link GemstyneItemSet}. If the Item is not present, then
     * an error message with hints is printed, then a {@link NullPointerException} is thrown.
     * @param itemName Name of target {@link Item}
     * @return Returns {@link Item} safely, or throws a {@link NullPointerException} instead of returning null.
     */
    private Item safeFetch(String itemName) {
        Optional<Item> item = Optional.ofNullable(this.itemVariants.get(itemName));
        if(item.isPresent()) {
            return this.itemVariants.get(itemName);
        } else {
            Gemstyne.LOGGER.error("[[ ERROR: " + itemName + " for set " + this.SET_NAME + " is null!" +
                    " Maybe the Item is improperly initialized?" +
                    " OR the ItemSet was called in an incompatible Method!" +
                    " OTHERWISE the wrong getter was called!");
        }
        throw new NullPointerException();
    }

    /**
     * Creates an {@link Item} variant, and stores it into <strong>this.itemVariants</strong>.
     * @param type {@link Item} type.
     * @return Returns instance of self.
     */
    public GemstyneItemSet createItemVariant(String type) {
        this.itemVariants.put(type, new Item(this.currentSettings));
        GemstyneRegistry.registerItem(this.SET_NAME + "_" + type, this.itemVariants.get(type));

        return this;
    }

    /**
     * Creates a raw {@link Item}.
     * @return Returns instance of self.
     */
    public GemstyneItemSet createRaw() {
        this.itemVariants.put("raw", new Item(this.currentSettings));
        GemstyneRegistry.registerItem("raw_" + this.SET_NAME, this.raw());

        return this;
    }

    /**
     * Creates a Singleton {@link Item}. Think Mochite, or Ikarite. They aren't ingots.
     * @return Returns instance of self.
     */
    public GemstyneItemSet createCrystal() {
        this.itemVariants.put(this.SET_NAME, new Item(this.currentSettings));
        GemstyneRegistry.registerItem(this.SET_NAME, this.crystal());

        return this;
    }

    public GemstyneItemSet createDefaultItemSet(boolean isAlloy) {
        if (!isAlloy) this.createRaw();
        return this.createItemVariant("nugget")
                .createItemVariant("ingot");
    }
}
