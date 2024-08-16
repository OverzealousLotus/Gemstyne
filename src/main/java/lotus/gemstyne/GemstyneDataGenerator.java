package lotus.gemstyne;

import lotus.gemstyne.damage.GemstyneDamageTypes;
import lotus.gemstyne.data.*;
import lotus.gemstyne.data.GemstyneBlockTagGenerator;
import lotus.gemstyne.data.models.GemstyneModelProvider;
import lotus.gemstyne.data.recipes.GemstyneRecipeProvider;
import lotus.gemstyne.data.translations.GemstyneLangProvider;
import lotus.gemstyne.world.GemstyneConfiguredFeatures;
import lotus.gemstyne.world.GemstynePlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class GemstyneDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(GemstyneBlockTagGenerator::new);
		pack.addProvider(GemstyneLootProvider::new);
		pack.addProvider(GemstyneRecipeProvider::new);
		pack.addProvider(GemstyneModelProvider::new);
		pack.addProvider(GemstyneWorldGenerator::new);
		pack.addProvider(GemstyneLangProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, GemstyneConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, GemstynePlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.DAMAGE_TYPE, GemstyneDamageTypes::bootstrap);
	}
}
