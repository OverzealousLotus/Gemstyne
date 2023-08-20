package lotus.gemstyne.block.entity;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.GemstyneOreBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GemstyneBlockEntities {
    public static BlockEntityType<RichOreBlockEntity> DEEP_ORE_BLOCK;

    public static void registerBlockEntities() {
        DEEP_ORE_BLOCK = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Gemstyne.MOD_ID, "deep_ore_block"),
                FabricBlockEntityTypeBuilder.create(RichOreBlockEntity::new,
                        GemstyneOreBlocks.NEFARIUM_ORE).build(null));
        Gemstyne.LOGGER.info("Registering Block Entities...");
    }
}
