package lotus.gemstyne.item;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Overwatch;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstynePairs.ItemPair;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <h2>GemstyneItemSet</h2>
 * A flexible way of creating a basic set of Items for Gemstyne.
 */
public final class ItemSet {
    @NotNull public Map<String, ItemPair> itemVariants;
    @NotNull private final String setName;

    /**
     * Its constructor only requires the name of the set to get started.
     * @param setName Name of set
     */
    private ItemSet(@NotNull String setName, @NotNull Map<String, ItemPair> itemVariants) {
        this.setName = setName;
        this.itemVariants = itemVariants;
    }

    public void generateModels(ItemModelGenerator itemModelGenerator) {
        this.itemVariants.values().forEach(itemIdPair -> itemModelGenerator.register(itemIdPair.item(), Models.GENERATED));
    }

    /**
     * Safely fetches an {@link Item} from {@link ItemSet}. If the Item is not present, then
     * an error message with hints is printed, then a {@link NullPointerException} is thrown.
     * @param itemName Name of target {@link Item}
     * @return Returns {@link Item} safely, or throws a {@link NullPointerException} instead of returning null.
     */
    @NotNull
    private Item fetch(String itemName) {
        Optional<Item> item = Optional.ofNullable(this.itemVariants.get(itemName).item());
        if(item.isPresent()) {
            return this.itemVariants.get(itemName).item();
        } else {
            Overwatch.error(String.format("[[ ERROR: %s for set %s is null! %s %n %s %n %s", itemName, this.setName,
                "Maybe the Item is improperly initialized?",
                "OR the ItemSet was called in an incompatible Method!",
                "OTHERWISE the wrong getter was called!"));
        }
        throw new NullPointerException();
    }

    public @NotNull String getSetName() { return this.setName; }
    public @NotNull Item raw() { return fetch("raw"); }
    public @NotNull Item chunk() { return fetch("chunk");}
    public @NotNull Item nugget() { return fetch("nugget"); }
    public @NotNull Item ingot() { return fetch("ingot"); }
    public @NotNull Item chain() { return fetch("chain"); }
    public @NotNull Item crystal() { return fetch("singleton"); }
    public @NotNull Map<String, ItemPair> getItemMap() { return this.itemVariants; }

    public static class Builder {
        @NotNull
        private final Map<String, ItemPair> itemVariants = new LinkedHashMap<>();

        private Item.Settings currentSettings = new OwoItemSettings().group(GemstyneCreativeGroup.GEMSTYNE);
        private final String setName;

        private Builder(@NotNull String setName) { this.setName = setName; }

        public static Builder start(String setName) { return new Builder(setName); }

        public Builder addFood(FoodComponent nutrients) {
            this.currentSettings = this.currentSettings.food(nutrients);

            return this;
        }

        /**
         * Creates an {@link Item} variant, and stores it into <strong>this.itemVariants</strong>.
         * @param type {@link Item} type.
         * @return Returns instance of self.
         */
        public Builder createItemVariant(String type) {
            this.itemVariants.put(type, new ItemPair(this.setName + "_" + type, new Item(this.currentSettings)));

            return this;
        }

        /**
         * Creates a raw {@link Item}.
         * @return Returns instance of self.
         */
        public Builder createRaw() {
            this.itemVariants.put("raw", new ItemPair("raw_" + this.setName, new Item(this.currentSettings)));
            return this;
        }

        /**
         * Creates a Singleton {@link Item}. Think Mochite, or Ikarite. They aren't ingots.
         * @return Returns instance of self.
         */
        public Builder createCrystal() {
            this.itemVariants.put("singleton", new ItemPair(this.setName, new Item(this.currentSettings)));
            return this;
        }

        public ItemSet createDefaultItemSet(boolean isAlloy) {
            if (!isAlloy) this.createRaw();
            return this.createItemVariant("nugget")
                .createItemVariant("ingot")
                .end();
        }

        public ItemSet end() {
            this.itemVariants.values().forEach(itemIdPair -> GemstyneRegistry.registerItem(itemIdPair.itemID(), itemIdPair.item()));
            return new ItemSet(this.setName, this.itemVariants);
        }
    }
}
