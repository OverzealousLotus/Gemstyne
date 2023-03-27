package lotus.tutorialmod;

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

		// Usage of LOGGER
		LOGGER.info("Hello Fabric world!");
	}
}