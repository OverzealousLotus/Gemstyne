package lotus.gemstyne.armor;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * {@link ArmorSet} is a class to simplify the registration process of Armor Sets.
 * Usually, you would have to create pieces of armor separately, but this is done at once.
 */
public final class ArmorSet {
    private final String setName;
    public final ArmorItem helmet;
    public final ArmorItem chestplate;
    public final ArmorItem leggings;
    public final ArmorItem boots;
    public final Item source;
    private final ImmutableSet<ArmorItem> armorSet;
    private final ImmutableMap<String, ArmorItem> armorMap;


    public ArmorSet(String setName, ArmorMaterial material, Item source) {
        this(setName, material, source, settings -> {
        });
    }

    public ArmorSet(String setName, ArmorMaterial material, Item source, Consumer<OwoItemSettings> settingsProcessor) {
        this.helmet = baseArmorItem(material, ArmorItem.Type.HELMET, settingsProcessor);
        this.chestplate = baseArmorItem(material, ArmorItem.Type.CHESTPLATE, settingsProcessor);
        this.leggings = baseArmorItem(material, ArmorItem.Type.LEGGINGS, settingsProcessor);
        this.boots = baseArmorItem(material, ArmorItem.Type.BOOTS, settingsProcessor);
        this.armorSet = ImmutableSet.of(this.helmet, this.chestplate, this.leggings, this.boots);
        this.armorMap = ImmutableMap.of(
            "helmet", this.helmet,
            "chestplate", this.chestplate,
            "leggings", this.leggings,
            "boots", this.boots
        );
        this.setName = setName;
        this.source = source;
        registerArmorSet(this.setName);
    }

    public ArmorItem baseArmorItem(ArmorMaterial material, ArmorItem.Type slot, Consumer<OwoItemSettings> settingsProcessor) {
        final var settings = new OwoItemSettings()
            .group(GemstyneCreativeGroup.GEMSTYNE)
            .tab(2);
        settingsProcessor.accept(settings);
        return this.makeItem(material, slot, settings);
    }

    /**
     * Automatically registers models for all armor in the set.
     * @param itemModelGenerator {@link lotus.gemstyne.data.models.GemstyneEquipmentModels}
     */
    public void registerModels(ItemModelGenerator itemModelGenerator) {
        this.armorSet.forEach(itemModelGenerator::registerArmor);
    }

    public Set<ArmorItem> getArmorSet() {
        return Set.copyOf(this.armorSet);
    }

    public List<ItemConvertible> getArmorList() {
        return List.copyOf(this.armorSet);
    }
    public ImmutableMap<String, ArmorItem> getArmorMap() { return this.armorMap; }
    public String getSetName() { return this.setName; }
    
    /**
     * <code>registerArmorSet</code> is used to register the items at once when created.
     * It must be called at the end of the {@link ArmorSet} constructor.
     * @param setName The name of the Armor Set.
     */
    public void registerArmorSet(String setName) {
        GemstyneRegistry.registerItem(setName + "_helmet", this.helmet);
        GemstyneRegistry.registerItem(setName + "_chestplate", this.chestplate);
        GemstyneRegistry.registerItem(setName + "_leggings", this.leggings);
        GemstyneRegistry.registerItem(setName + "_boots", this.boots);
    }

    public static RegistryEntry<ArmorMaterial> getEntry(ArmorMaterial material) {
        return Registries.ARMOR_MATERIAL.getEntry(material);
    }

    private ArmorItem makeItem(ArmorMaterial material, ArmorItem.Type slot, OwoItemSettings settings) {
        return new ArmorItem(RegistryEntry.of(material), slot, settings);
    }
}
