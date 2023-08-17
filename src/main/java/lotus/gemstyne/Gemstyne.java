package lotus.gemstyne;

import lotus.gemstyne.block.GemstyneBlocks;
import lotus.gemstyne.effect.GemstyneEffects;
import lotus.gemstyne.event.UraniumBreakHandler;
import lotus.gemstyne.fluid.GemstyneFluids;
import lotus.gemstyne.item.GemstyneItemGroup;
import lotus.gemstyne.item.GemstyneItemHandler;
import lotus.gemstyne.util.GemstyneRegistries;
import lotus.gemstyne.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
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
		// Step I | Dependencies
		GemstyneFluids.registerFluids();
		GemstyneItemGroup.registerItemGroups();

		// Step II | Essentials
		GemstyneItemHandler.registerModItems();
		GemstyneBlocks.registerModBlocks();
        GemstyneRegistries.registerModStuff();

		// Step III | World
		ModWorldGeneration.generateModWorldGen();
		GemstyneEffects.RegisterEffects();

		// Step IV | Event Handlers
		AttackBlockCallback.EVENT.register(new UraniumBreakHandler());
	}
}