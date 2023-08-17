package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.equipment.GemstyneArmorItems;
import lotus.gemstyne.item.equipment.GemstyneCraftingItems;
import lotus.gemstyne.item.equipment.GemstyneGearItems;
import lotus.gemstyne.item.equipment.GemstyneToolItems;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GemstyneItemGroup {
    public static final ItemGroup GEMSTYNE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Gemstyne.MOD_ID, "gemstyne"),
            FabricItemGroup.builder().displayName(Text.translatable("Gemstyne"))
                    .icon(() -> new ItemStack(GemstyneOreItems.MOCHITE)).entries((displayContext, entries) -> {
                        // =====
                        // <=====| Overworld Ores |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.DEEPSLATE_MORKITE_ORE);
                        entries.add(GemstyneOreBlocks.MORKITE_BLOCK);

                        entries.add(GemstyneOreBlocks.MOCHITE_ORE);
                        entries.add(GemstyneOreBlocks.DEEPSLATE_MOCHITE_ORE);
                        entries.add(GemstyneOreBlocks.RAW_MOCHITE_BLOCK);

                        entries.add(GemstyneOreBlocks.TIN_ORE);
                        entries.add(GemstyneOreBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(GemstyneOreBlocks.RAW_TIN_BLOCK);

                        entries.add(GemstyneOreBlocks.DEEPSLATE_URANIUM_ORE);
                        entries.add(GemstyneOreBlocks.RAW_URANIUM_BLOCK);

                        // =====
                        // <=====| Nether Ores |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.NETHER_ALDUS_ORE);
                        entries.add(GemstyneOreBlocks.RAW_ALDUS_BLOCK);

                        entries.add(GemstyneOreBlocks.NETHER_CRIMONITE_ORE);
                        entries.add(GemstyneOreBlocks.RAW_CRIMONITE_BLOCK);
                        // =====
                        // <=====| End Ores |=====>
                        // =====

                        // =====
                        // <=====| Geodes |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.GARNET_CLUSTER);
                        entries.add(GemstyneOreBlocks.LARGE_GARNET_BUD);
                        entries.add(GemstyneOreBlocks.MEDIUM_GARNET_BUD);
                        entries.add(GemstyneOreBlocks.SMALL_GARNET_BUD);
                        entries.add(GemstyneOreBlocks.BUDDING_GARNET);
                        entries.add(GemstyneOreBlocks.GARNET_BLOCK);
                        entries.add(GemstyneOreItems.GARNET);

                        entries.add(GemstyneOreBlocks.IKARITE_CLUSTER);
                        entries.add(GemstyneOreBlocks.LARGE_IKARITE_BUD);
                        entries.add(GemstyneOreBlocks.MEDIUM_IKARITE_BUD);
                        entries.add(GemstyneOreBlocks.SMALL_IKARITE_BUD);
                        entries.add(GemstyneOreBlocks.BUDDING_IKARITE);
                        entries.add(GemstyneOreBlocks.IKARITE_BLOCK);
                        entries.add(GemstyneOreItems.IKARITE);

                        // =====
                        // <=====| Minerals |=====>
                        // =====
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.gabbro());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.halite());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.pumice());

                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedAndesite());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedDiorite());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compactDirt());
                        entries.add(GemstyneMineralBlocks.MINERAL_BLOCKS.compressedGranite());

                        // =====
                        // <=====| Overworld Harvested Ore |=====>
                        // =====
                        entries.add(GemstyneOreItems.FIRE_OPAL);

                        entries.add(GemstyneOreItems.MORKITE);

                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock());
                        entries.add(GemstyneOreItems.RAW_MOCHITE);
                        entries.add(GemstyneOreItems.MOCHITE);

                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.tinBlock());
                        entries.add(GemstyneOreItems.RAW_TIN);
                        entries.add(GemstyneOreItems.TIN_INGOT);

                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock());
                        entries.add(GemstyneOreItems.RAW_URANIUM);
                        entries.add(GemstyneOreItems.URANIUM_CHUNK);
                        entries.add(GemstyneOreItems.URANIUM_INGOT);

                        // =====
                        // <=====| Nether Harvested Ore |=====>
                        // =====
                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock());
                        entries.add(GemstyneOreItems.RAW_ALDUS);
                        entries.add(GemstyneOreItems.ALDUS_INGOT);

                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock());
                        entries.add(GemstyneOreItems.RAW_CRIMONITE);
                        entries.add(GemstyneOreItems.CRIMONITE_CHUNK);
                        entries.add(GemstyneOreItems.CRIMONITE_INGOT);

                        // =====
                        // <=====| End Harvested Ore |=====>
                        // =====

                        // =====
                        // <=====| Alloys |=====>
                        // =====
                        entries.add(GemstyneOreItems.BRONZE_INGOT);
                        entries.add(GemstyneOreItems.BRONZE_NUGGET);
                        entries.add(GemstyneOreItems.BRONZE_RING);

                        // =====
                        // <=====| Armors |=====>
                        // =====
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.aldusHelmet());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.aldusChestplate());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.aldusLeggings());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.aldusBoots());

                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailHelmet());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailChestplate());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailLeggings());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.bronzeMailBoots());

                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateHelmet());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateChestplate());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateLeggings());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.bronzePlateBoots());

                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.rendfireHelmet());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.rendfireChestplate());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.rendfireLeggings());
                        entries.add(GemstyneArmorItems.ARMOR_ITEMS.rendfireBoots());
                        // =====
                        // <=====| Tools |=====>
                        // =====
                        entries.add(GemstyneToolItems.TOOL_ITEMS.aldusAxe());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.aldusHoe());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.aldusPickaxe());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.aldusShovel());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.aldusSword());

                        entries.add(GemstyneToolItems.TOOL_ITEMS.bronzeAxe());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.bronzeHoe());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.bronzePickaxe());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.bronzeShovel());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.bronzeSword());

                        entries.add(GemstyneToolItems.TOOL_ITEMS.rendfireAxe());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.rendfireHoe());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.rendfirePickaxe());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.rendfireShovel());
                        entries.add(GemstyneToolItems.TOOL_ITEMS.rendfireSword());

                        // =====
                        // <=====| Gear |=====>
                        // =====
                        entries.add(GemstyneGearItems.getImbuedFeather());
                        entries.add(GemstyneFluids.LIQUID_MORKITE_BUCKET);


                        entries.add(GemstyneCraftingItems.getImbuedRod());
                    }).build());
    public static void registerItemGroups() {

    }


}
