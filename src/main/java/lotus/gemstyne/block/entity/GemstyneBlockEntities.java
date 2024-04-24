package lotus.gemstyne.block.entity;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.BlockHandler;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GemstyneBlockEntities {
    private GemstyneBlockEntities() {}
    
    public static BlockEntityType<RichOreBlockEntity> DEEP_ORE_BLOCK;

    public static void registerBlockEntities() {
        DEEP_ORE_BLOCK = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Gemstyne.MOD_ID, "deep_ore_block"),
                BlockEntityType.Builder.create(RichOreBlockEntity::new,
                        BlockHandler.NEFARIUM_ORE).build(null));
        Gemstyne.LOGGER.info("Registering Block Entities...");
    }
}
