package lotus.gemstyne.block;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.block.custom.AfflictiveBlock;
import lotus.gemstyne.block.custom.AfflictiveOre;
import lotus.gemstyne.util.GemstyneBlockTypes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

/**
 * Handler of Gemstyne's {@link Block} assignment and registration. Provides methods to other
 * classes to simplify the process of this. Various methods have different purposes.
 */
public final class GemstyneBlockHandler {
    // =====
    // <===== Assistive Methods =====>
    // =====

    /**
     * Assigns {@link Block} to statement.
     * @param settings {@link FabricBlockSettings}
     * @return Returns a new {@link Block}
     */
    public static Block assignBlock(FabricBlockSettings settings) {
        return new Block(settings);
    }

    /**
     * Assigns {@link AfflictiveBlock} to statement
     * @param settings {@link FabricBlockSettings}
     * @param effect {@link StatusEffect} of block
     * @param duration Duration of status effect.
     * @param type Type of block. See {@link GemstyneBlockTypes}
     * @return Returns new {@link AfflictiveBlock}
     */
    public static Block assignBlock(
            FabricBlockSettings settings, StatusEffect effect,
            int duration, GemstyneBlockTypes type
    ) {
        return new AfflictiveBlock(settings, effect, duration, type);
    }

    /**
     * {@link ExperienceDroppingBlock} Assignment Method, with Settings.
     * @param settings {@link FabricBlockSettings}
     * @param experience {@link UniformIntProvider} Range of experience dropped.
     * @return Returns a new {@link ExperienceDroppingBlock}
     */
    public static ExperienceDroppingBlock assignOreBlock(FabricBlockSettings settings, UniformIntProvider experience) {
        return new ExperienceDroppingBlock(settings, experience);
    }

    /**
     * {@link ExperienceDroppingBlock} Assignment Method Override.
     * @param settings {@link FabricBlockSettings}
     * @param effect {@link StatusEffect} for {@link AfflictiveBlock}
     * @param duration Duration of status effect.
     * @param type Type of block. See {@link GemstyneBlockTypes}
     * @param experience Experience drop range.
     * @return Returns new {@link AfflictiveOre}.
     */
    public static ExperienceDroppingBlock assignOreBlock(
            FabricBlockSettings settings, StatusEffect effect, int duration,
            GemstyneBlockTypes type, UniformIntProvider experience
    ) {
        return new AfflictiveOre(settings, effect, duration, type, experience);
    }

    /**
     * Registers a {@link Block} and its associated {@link BlockItem} into Minecraft.
     * @param name Name of {@link Block}
     * @param block The block itself.
     */
    public static void registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Registry.register(Registries.BLOCK, new Identifier(Gemstyne.MOD_ID, name), block);
    }

    /**
     * Assigns, and registers a {@link Block} into Minecraft,
     * @param name Name of the {@link Block}
     * @param block The block itself.
     * @return Returns the block specified.
     */
    public static Block assignAndRegisterBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Gemstyne.MOD_ID, name), block);
    }

    /**
     * Internal method to register a block's associated {@link BlockItem}.
     * @param name Name of the {@link BlockItem}
     * @param block {@link Block} associated with it.
     */
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Gemstyne.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerGemstyneBlocks() {
        Gemstyne.LOGGER.info("Registering blocks for " + Gemstyne.MOD_ID + "!");
        GemstyneOreBlocks.registerOreBlocks();
        GemstyneMineralBlocks.registerMineralBlocks();
        Gemstyne.LOGGER.info("Successfully registered blocks for " + Gemstyne.MOD_ID + "!");
    }
}
