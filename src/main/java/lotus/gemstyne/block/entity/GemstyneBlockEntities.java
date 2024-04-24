package lotus.gemstyne.block.entity;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class GemstyneBlockEntities {
    private GemstyneBlockEntities() {}
    
    public static BlockEntityType<RichOreBlockEntity> DEEP_ORE_BLOCK;
    public static final EntityType<ThermoTntEntity> THERMO_TNT_ENTITY = EntityType.Builder.<ThermoTntEntity>create(
        ThermoTntEntity::new, SpawnGroup.MISC).makeFireImmune().setDimensions(1, 1).build();

    /// Registers all Block Entities for Gemstyne
    public static void registerBlockEntities() {
        DEEP_ORE_BLOCK = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            GemstyneRegistry.id("deep_ore_block"),
                BlockEntityType.Builder.create(RichOreBlockEntity::new,
                        BlockHandler.NEFARIUM_ORE).build(null));

        Gemstyne.LOGGER.info("Registering Block Entities...");
    }

    /// Registers all Entity Types for Gemstyne.
    public static void registerEntityTypes() {
        Registry.register(Registries.ENTITY_TYPE, GemstyneRegistry.id("thermo_tnt"), THERMO_TNT_ENTITY);
        Gemstyne.LOGGER.info("Registering Entity Types...");
    }
    public static void registerGemstyneEntities() {
        registerBlockEntities();
        registerEntityTypes();
    }
}
