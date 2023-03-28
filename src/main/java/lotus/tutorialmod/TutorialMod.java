package lotus.tutorialmod;

import lotus.tutorialmod.block.ModBlocks;
import lotus.tutorialmod.item.ModItemGroup;
import lotus.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

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
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		// Usage of LOGGER
		LOGGER.info("Hello Fabric world!");
	}
}