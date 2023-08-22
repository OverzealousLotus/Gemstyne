package lotus.gemstyne;

import lotus.gemstyne.block.GemstyneBlockHandler;
import lotus.gemstyne.block.entity.GemstyneBlockEntities;
import lotus.gemstyne.event.UraniumBreakHandler;
import lotus.gemstyne.item.GemstyneItemHandler;
import lotus.gemstyne.util.GemstyneRegistries;
import lotus.gemstyne.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gemstyne implements ModInitializer {
	// Gemstyne Mod Id.
	public static final String MOD_ID = "gemstyne";

	// A simple way to log messages or events.
	public static final Logger LOGGER = LoggerFactory.getLogger("gemstyne");

	/** Make sure to dataGen each time new items, or ores are added, or if
	 * existing items/ores are modified in the files to see change.
	 * Everything must be done sequentially.
	 * If we try to generate ore that does not exist then mod dies. */
	@Override
	public void onInitialize() {
		// Step I | Dependencies
		Gemstyne.LOGGER.info("[[ Registering Dependencies for " + Gemstyne.MOD_ID + "! ]]");
		Overwatch.registerDependencies();
		Gemstyne.LOGGER.info("[[ Successfully registered Dependencies! ]]");

		// Step II | Essentials
		Gemstyne.LOGGER.info("[[ Registering Essentials for " + Gemstyne.MOD_ID + "! ]]");
		GemstyneItemHandler.registerGemstyneItems();
		GemstyneBlockHandler.registerGemstyneBlocks();
		GemstyneBlockEntities.registerBlockEntities();
        GemstyneRegistries.registerGemstyneMisc();
		Gemstyne.LOGGER.info("[[ Successfully registered Essentials! ]]");

		// Step III | World
		ModWorldGeneration.generateModWorldGen();

		// Step IV | Event Handlers
		AttackBlockCallback.EVENT.register(new UraniumBreakHandler());
	}
}