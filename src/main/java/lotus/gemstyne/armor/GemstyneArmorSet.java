package lotus.gemstyne.armor;

import com.google.common.collect.ImmutableSet;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;

import java.util.List;
import java.util.Set;

/**
 * {@link GemstyneArmorSet} is a class to simplify the registration process of Armor Sets.
 * Usually, you would have to create pieces of armor separately, but this is done at once.
 */
public final class GemstyneArmorSet {
    public final ArmorItem helmet;
    public final ArmorItem chestplate;
    public final ArmorItem leggings;
    public final ArmorItem boots;
    public final Item source;
    private final ImmutableSet<ArmorItem> armorSet;


    /**
     * Constructor of {@link GemstyneArmorSet}
     * Assigns each Armor piece a value, then registers them in Minecraft. They can be accessed using
     * <code>setName.type</code>
     * @param settings Settings assigned to set.
     * @param setName Name of Armor set.
     * @param material Material of set.
     */
    public GemstyneArmorSet(OwoItemSettings settings, String setName, ArmorMaterial material, Item source) {
        this.helmet = assignArmor(settings, material, ArmorItem.Type.HELMET);
        this.chestplate = assignArmor(settings, material, ArmorItem.Type.CHESTPLATE);
        this.leggings = assignArmor(settings, material, ArmorItem.Type.LEGGINGS);
        this.boots = assignArmor(settings, material, ArmorItem.Type.BOOTS);
        this.source = source;
        this.armorSet = ImmutableSet.of(this.helmet, this.chestplate, this.leggings, this.boots);
        this.registerArmorSet(setName);
    }

    /**
     *
     * @param settings Settings assigned to set.
     * @param material Material of set.
     * @param type Type of armor piece being created.
     * @return Returns an Armor item with all of the above as its parameters.
     */
    private static ArmorItem assignArmor(OwoItemSettings settings, ArmorMaterial material, ArmorItem.Type type) {
        return new ArmorItem(material, type, settings.group(GemstyneCreativeGroup.GEMSTYNE).tab(2));
    }

    public Set<ArmorItem> getArmorSet() {
        return Set.copyOf(this.armorSet);
    }

    public List<ItemConvertible> getArmorList() {
        return List.copyOf(this.armorSet);
    }
    
    /**
     * <code>registerArmorSet</code> is used to register the items at once when created.
     * It must be called at the end of the {@link GemstyneArmorSet} constructor.
     * @param setName The name of the Armor Set.
     */
    public void registerArmorSet(String setName) {
        GemstyneRegistry.registerItem(setName + "_helmet", this.helmet);
        GemstyneRegistry.registerItem(setName + "_chestplate", this.chestplate);
        GemstyneRegistry.registerItem(setName + "_leggings", this.leggings);
        GemstyneRegistry.registerItem(setName + "_boots", this.boots);
    }
}
