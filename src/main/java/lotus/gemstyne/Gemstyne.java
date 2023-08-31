package lotus.gemstyne;

import lotus.gemstyne.event.UraniumBreakHandler;
import lotus.gemstyne.util.GemstyneToolTips;
import lotus.gemstyne.world.gen.GemstyneWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gemstyne implements ModInitializer {
	// Gemstyne Mod Id.
	public static final String MOD_ID = "gemstyne";

	// A simple way to log messages or events.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/** <p>Make sure to dataGen each time new items, ores, or blocks are modified/added.</p>
	 * <p>Everything must be done sequentially.</p>
	 * <p>If you try to generate Ore that does not exist, Minecraft will crash.</p> */
	@Override
	public void onInitialize() {
		// Step I | Dependencies
		Gemstyne.LOGGER.info("[[ Registering Dependencies for " + Gemstyne.MOD_ID + "! ]]");
		Overwatch.registerDependencies();
		Gemstyne.LOGGER.info("[[ Successfully registered Dependencies! ]]");

		// Step II | Essentials
		Gemstyne.LOGGER.info("[[ Registering Essentials for " + Gemstyne.MOD_ID + "! ]]");
		Overwatch.registerEssentials();
		GemstyneToolTips.registerToolTips();
		Gemstyne.LOGGER.info("[[ Successfully registered Essentials! ]]");

		// Step III | World
		Gemstyne.LOGGER.info("[[ Registering World Configuration for " + Gemstyne.MOD_ID + "! ]]");
		GemstyneWorldGeneration.generateModWorldGen();
		Gemstyne.LOGGER.info("[[ Successfully registered World Configuration!");

		// Step IV | Event Handlers
		Gemstyne.LOGGER.info("[[ Registering Event Handlers for " + Gemstyne.MOD_ID + "! ]]");
		AttackBlockCallback.EVENT.register(new UraniumBreakHandler());
		Gemstyne.LOGGER.info("[[ Successfully registered Event Handlers!");
	}
}