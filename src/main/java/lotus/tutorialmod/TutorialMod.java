package lotus.tutorialmod;

import lotus.tutorialmod.block.ModBlocks;
import lotus.tutorialmod.block.ModFlammableBlockRegistry;
import lotus.tutorialmod.event.UraniumBreakHandler;
import lotus.tutorialmod.item.ModItemGroup;
import lotus.tutorialmod.item.ModItems;
import lotus.tutorialmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	// My ModID
	public static final String MOD_ID = "tutorialmod";

	// A simple way to log messages or events.
	public static final Logger LOGGER = LoggerFactory.getLogger("tutorialmod");

	// Initialization method.
	@Override
	public void onInitialize() {
		// Make sure to dataGen each time new items, or ores are added, or if-
		// -existing items/ores are modified in the files to see change.
		// Everything must be done sequentially.
		// If we try to generate ore that does not exist then mod dies.
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