package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneDecorBlocks;
import lotus.gemstyne.block.GemstyneMineralBlocks;
import lotus.gemstyne.block.GemstyneOreBlocks;
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
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.gemstyne"))
                    .icon(() -> new ItemStack(GemstyneOreBlocks.ORE_BLOCKS.mochiteOre())).entries((displayContext, entries) -> {
                        // =====
                        // <=====| Overworld Ores |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMorkiteOre());
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.morkiteBlock());

                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.mochiteOre());
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.deepslateMochiteOre());
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.rawMochiteBlock());

                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.tinOre());
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.deepslateTinOre());
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.rawTinBlock());

                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.deepslateUraniumOre());
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.rawUraniumBlock());

                        // =====
                        // <=====| Nether Ores |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.netherAldusOre());
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.rawAldusBlock());

                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.netherCrimoniteOre());
                        entries.add(GemstyneOreBlocks.ORE_BLOCKS.rawCrimoniteBlock());
                        // =====
                        // <=====| End Ores |=====>
                        // =====

                        // =====
                        // <=====| Geodes |=====>
                        // =====
                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.garnetBlock());
                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.buddingGarnet());
                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.smallGarnetBud());
                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.mediumGarnetBud());
                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.largeGarnetBud());
                        entries.add(GemstyneOreItems.ORE_ITEMS.garnet());

                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.ikariteBlock());
                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.buddingIkarite());
                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.smallIkariteBud());
                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.mediumIkariteBud());
                        entries.add(GemstyneOreBlocks.GEODE_BLOCKS.largeIkariteBud());
                        entries.add(GemstyneOreItems.ORE_ITEMS.ikarite());

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
                        entries.add(GemstyneOreItems.ORE_ITEMS.fireOpal());

                        entries.add(GemstyneOreItems.ORE_ITEMS.morkite());

                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.mochiteBlock());
                        entries.add(GemstyneOreItems.ORE_ITEMS.rawMochite());
                        entries.add(GemstyneOreItems.ORE_ITEMS.mochite());

                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.tinBlock());
                        entries.add(GemstyneOreItems.ORE_ITEMS.rawTin());
                        entries.add(GemstyneOreItems.ORE_ITEMS.tinIngot());

                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.uraniumBlock());
                        entries.add(GemstyneOreItems.ORE_ITEMS.rawUranium());
                        entries.add(GemstyneOreItems.ORE_ITEMS.uraniumChunk());
                        entries.add(GemstyneOreItems.ORE_ITEMS.uraniumIngot());

                        // =====
                        // <=====| Nether Harvested Ore |=====>
                        // =====
                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.aldusBlock());
                        entries.add(GemstyneOreItems.ORE_ITEMS.rawAldus());
                        entries.add(GemstyneOreItems.ORE_ITEMS.aldusIngot());

                        entries.add(GemstyneDecorBlocks.DECOR_BLOCKS.crimoniteBlock());
                        entries.add(GemstyneOreItems.ORE_ITEMS.rawCrimonite());
                        entries.add(GemstyneOreItems.ORE_ITEMS.crimoniteChunk());
                        entries.add(GemstyneOreItems.ORE_ITEMS.crimoniteIngot());

                        // =====
                        // <=====| End Harvested Ore |=====>
                        // =====

                        // =====
                        // <=====| Alloys |=====>
                        // =====
                        entries.add(GemstyneOreItems.ORE_ITEMS.bronzeIngot());
                        entries.add(GemstyneOreItems.ORE_ITEMS.bronzeNugget());
                        entries.add(GemstyneOreItems.ORE_ITEMS.bronzeRing());

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
                        entries.add(GemstyneGearItems.getLiquidMorkiteBucket());


                        entries.add(GemstyneCraftingItems.getImbuedRod());
                    }).build());
    public static void registerItemGroups() {

    }


}
