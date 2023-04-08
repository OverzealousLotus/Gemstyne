package lotus.gemstyne;

import lotus.gemstyne.block.ModBlocks;
import lotus.gemstyne.block.ModFlammableBlockRegistry;
import lotus.gemstyne.event.UraniumBreakHandler;
import lotus.gemstyne.item.ModItemGroup;
import lotus.gemstyne.item.ModItems;
import lotus.gemstyne.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gemstyne implements ModInitializer {
	// My ModID
	public static final String MOD_ID = "gemstyne";

	// A simple way to log messages or events.
	public static final Logger LOGGER = LoggerFactory.getLogger("gemstyne");

	/** Make sure to dataGen each time new items, or ores are added, or if-
	 * -existing items/ores are modified in the files to see change.
	 * Everything must be done sequentially.
	 * If we try to generate ore that does not exist then mod dies. */
	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		// Set what blocks are flammable, or strippable.
		ModFlammableBlockRegistry.registerFlammableBlocks();
		StrippableBlockRegistry.register(ModBlocks.RED_MAPLE_LOG, ModBlocks.STRIPPED_RED_MAPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks.RED_MAPLE_WOOD, ModBlocks.STRIPPED_RED_MAPLE_WOOD);


		// Register event handlers.
		AttackBlockCallback.EVENT.register(new UraniumBreakHandler());
		// Usage of LOGGER
		LOGGER.info("Hello Fabric world!");
	}
}