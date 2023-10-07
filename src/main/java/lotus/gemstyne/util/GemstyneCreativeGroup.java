package lotus.gemstyne.util;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.armor.GemstyneArmorItems;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

/**
 * Gemstyne's Creative Group is created using <a href="https://docs.wispforest.io/owo/item-groups">Owolib</a>.
 * Internally, both BlockItems and Items use {@link OwoItemSettings} ands its
 * {@link OwoItemSettings#group()} method. In this class, the {@link OwoItemGroup} is defined,
 * then used in various other locations, primarily {@link GemstyneRegistry}.
 */
public class GemstyneCreativeGroup {
    private GemstyneCreativeGroup() {}

    public static final OwoItemGroup GEMSTYNE = OwoItemGroup.builder(GemstyneRegistry.id("main"),
        () -> Icon.of(GemstyneOreItems.MOCHITE.crystal())).initializer(group -> {
            group.addTab(Icon.of(GemstyneOreItems.BUBBLEGEM), "items", TagKey.of(RegistryKeys.ITEM, GemstyneRegistry.id("item_tab")), false);
            group.addTab(Icon.of(GemstyneOreBlocks.MOCHITE.deepslateOre()), "ore", TagKey.of(RegistryKeys.ITEM, GemstyneRegistry.id("ore_tab")), false);
            group.addTab(Icon.of(GemstyneOreItems.CRIMONITE.raw()), "metals", TagKey.of(RegistryKeys.ITEM, GemstyneRegistry.id("metals_tab")), false);
            group.addTab(Icon.of(GemstyneOreItems.FIRE_OPAL), "gems", TagKey.of(RegistryKeys.ITEM, GemstyneRegistry.id("gems_tab")), false);
            group.addTab(Icon.of(GemstyneArmorItems.RENDFIRE.chestplate), "equipment", TagKey.of(RegistryKeys.ITEM, GemstyneRegistry.id("equipment_tab")), false);
    }).build();

    public static void registerGroups() {
        Gemstyne.LOGGER.info("Registering Gemstyne Group(s)...");
        GEMSTYNE.initialize();
        Gemstyne.LOGGER.info("Successfully registered Gemstyne Group(s)!");
    }


}
