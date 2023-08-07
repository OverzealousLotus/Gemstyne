package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public final class GemstyneBlocks {
    // =====
    // <===== Assistive Methods =====>
    // =====
    public static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Gemstyne.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        Gemstyne.LOGGER.info("Registering blocks for " + Gemstyne.MOD_ID + "!");
        GemstyneOreBlocks.registerOreBlocks();
        GemstyneMineralBlocks.registerMineralBlocks();
        GemstyneDecorBlocks.registerDecorBlocks();
        Gemstyne.LOGGER.info("Successfully registered blocks for " + Gemstyne.MOD_ID + "!");
    }
}
