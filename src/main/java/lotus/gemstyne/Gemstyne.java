package lotus.gemstyne;

import lotus.gemstyne.config.GemstyneConfig;
import lotus.gemstyne.entity.EntityHandler;
import lotus.gemstyne.entity.custom.AetherZombie;
import lotus.gemstyne.event.UraniumBreakHandler;
import lotus.gemstyne.world.gen.GemstyneWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gemstyne implements ModInitializer {
	// Gemstyne Mod Id.
	public static final String MOD_ID = "gemstyne";

	// A simple way to log messages or events.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final GemstyneConfig CONFIG = GemstyneConfig.createAndLoad();

	/** <p>Make sure to dataGen each time new items, ores, or blocks are modified/added.</p>
	 * <p>Everything must be done sequentially.</p>
	 * <p>If you try to generate Ore that does not exist, Minecraft will crash.</p> */
	@Override
	public void onInitialize() {
		Overwatch.modObserver();

		// ///// Step I | Dependencies /////
		Overwatch.registerDependencies();

		// Step II | Essentials
		Overwatch.registerEssentials();
		FabricDefaultAttributeRegistry.register(EntityHandler.AETHER_ZOMBIE, AetherZombie.createAetherZombieAttributes());

		// Step III | World
		Overwatch.info("~> Registering World Configuration...");
		GemstyneWorldGeneration.generateModWorldGen();
		Overwatch.info("~> Successfully registered World Configuration!");

		// Step IV | Event Handlers
		Overwatch.info("~> Registering Event Handlers...");
		AttackBlockCallback.EVENT.register(new UraniumBreakHandler());
		Overwatch.info("~> Successfully registered Event Handlers!");

		Overwatch.info("~> Initialization complete. <~");
	}
}