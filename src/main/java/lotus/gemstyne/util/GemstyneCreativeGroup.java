package lotus.gemstyne.util;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.armor.ArmorHandler;
import lotus.gemstyne.block.BlockHandler;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.item.ItemHandler;
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
        () -> Icon.of(ItemHandler.MOCHITE.crystal())).initializer(group -> {
            group.addTab(Icon.of(ItemHandler.BUBBLEGEM), "items", TagKey.of(RegistryKeys.ITEM, GemstyneRegistry.id("item_tab")), true);
            group.addTab(Icon.of(BlockHandler.MOCHITE.pureBlock()), "blocks", TagKey.of(RegistryKeys.ITEM, GemstyneRegistry.id("block_tab")), false);
            group.addTab(Icon.of(ArmorHandler.RENDFIRE.chestplate), "equipment", TagKey.of(RegistryKeys.ITEM, GemstyneRegistry.id("equipment_tab")), false);
    }).build();

    public static void registerGroups() {
        Gemstyne.LOGGER.info("Registering Gemstyne Group(s)...");
        GEMSTYNE.initialize();
        Gemstyne.LOGGER.info("Successfully registered Gemstyne Group(s)!");
    }


}
