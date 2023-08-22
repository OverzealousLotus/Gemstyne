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
                        entries.add(GemstyneArmorItems.ALDUS.HELMET);
                        entries.add(GemstyneArmorItems.ALDUS.CHESTPLATE);
                        entries.add(GemstyneArmorItems.ALDUS.LEGGINGS);
                        entries.add(GemstyneArmorItems.ALDUS.BOOTS);

                        entries.add(GemstyneArmorItems.BRONZEMAIL.HELMET);
                        entries.add(GemstyneArmorItems.BRONZEMAIL.CHESTPLATE);
                        entries.add(GemstyneArmorItems.BRONZEMAIL.LEGGINGS);
                        entries.add(GemstyneArmorItems.BRONZEMAIL.BOOTS);

                        entries.add(GemstyneArmorItems.BRONZEPLATE.HELMET);
                        entries.add(GemstyneArmorItems.BRONZEPLATE.CHESTPLATE);
                        entries.add(GemstyneArmorItems.BRONZEPLATE.LEGGINGS);
                        entries.add(GemstyneArmorItems.BRONZEPLATE.BOOTS);

                        entries.add(GemstyneArmorItems.RENDFIRE.HELMET);
                        entries.add(GemstyneArmorItems.RENDFIRE.CHESTPLATE);
                        entries.add(GemstyneArmorItems.RENDFIRE.LEGGINGS);
                        entries.add(GemstyneArmorItems.RENDFIRE.BOOTS);
                        // =====
                        // <=====| Tools |=====>
                        // =====
                        entries.add(GemstyneToolItems.ALDUS.AXE);
                        entries.add(GemstyneToolItems.ALDUS.HOE);
                        entries.add(GemstyneToolItems.ALDUS.PICKAXE);
                        entries.add(GemstyneToolItems.ALDUS.SHOVEL);
                        entries.add(GemstyneToolItems.ALDUS.SWORD);

                        entries.add(GemstyneToolItems.BRONZE.AXE);
                        entries.add(GemstyneToolItems.BRONZE.HOE);
                        entries.add(GemstyneToolItems.BRONZE.PICKAXE);
                        entries.add(GemstyneToolItems.BRONZE.SHOVEL);
                        entries.add(GemstyneToolItems.BRONZE.SWORD);

                        entries.add(GemstyneToolItems.RENDFIRE.AXE);
                        entries.add(GemstyneToolItems.RENDFIRE.HOE);
                        entries.add(GemstyneToolItems.RENDFIRE.PICKAXE);
                        entries.add(GemstyneToolItems.RENDFIRE.SHOVEL);
                        entries.add(GemstyneToolItems.RENDFIRE.SWORD);

                        // =====
                        // <=====| Gear |=====>
                        // =====
                        entries.add(GemstyneGearItems.getImbuedFeather());
                        entries.add(GemstyneFluids.LIQUID_MORKITE_BUCKET);


                        entries.add(GemstyneCraftingItems.getImbuedRod());
                    }).build());
    public static void registerItemGroups() {
        Gemstyne.LOGGER.info("Registering Item Group(s)...");
    }


}
