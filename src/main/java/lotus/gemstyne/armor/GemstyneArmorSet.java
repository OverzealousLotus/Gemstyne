package lotus.gemstyne.armor;

import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * {@link GemstyneArmorSet} is a class to simplify the registration process of Armor Sets.
 * Usually, you would have to create pieces of armor separately, but this is done at once.
 */
public final class GemstyneArmorSet {
    public final ArmorItem HELMET;
    public final ArmorItem CHESTPLATE;
    public final ArmorItem LEGGINGS;
    public final ArmorItem BOOTS;
    public final Item SOURCE;


    /**
     * Constructor of {@link GemstyneArmorSet}
     * Assigns each Armor piece a value, then registers them in Minecraft. They can be accessed using
     * <code>setName.type</code>
     * @param settings Settings assigned to set.
     * @param setName Name of Armor set.
     * @param material Material of set.
     */
    public GemstyneArmorSet(FabricItemSettings settings, String setName, ArmorMaterial material, Item source) {
        this.HELMET = assignArmor(settings, material, ArmorItem.Type.HELMET);
        this.CHESTPLATE = assignArmor(settings, material, ArmorItem.Type.CHESTPLATE);
        this.LEGGINGS = assignArmor(settings, material, ArmorItem.Type.LEGGINGS);
        this.BOOTS = assignArmor(settings, material, ArmorItem.Type.BOOTS);
        this.SOURCE = source;
        this.registerArmorSet(setName);
    }

    /**
     *
     * @param settings Settings assigned to set.
     * @param material Material of set.
     * @param type Type of armor piece being created.
     * @return Returns an Armor item with all of the above as its parameters.
     */
    private static ArmorItem assignArmor(FabricItemSettings settings, ArmorMaterial material, ArmorItem.Type type) {
        return new ArmorItem(material, type, settings);
    }

    /**
     * <code>registerArmorSet</code> is used to register the items at once when created.
     * It must be called at the end of the {@link GemstyneArmorSet} constructor.
     * @param setName The name of the Armor Set.
     */
    public void registerArmorSet(String setName) {
        Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, setName + "_helmet"), this.HELMET);
        Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, setName + "_chestplate"), this.CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, setName + "_leggings"), this.LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, setName + "_boots"), this.BOOTS);
    }
}
