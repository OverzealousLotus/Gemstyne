package lotus.gemstyne.world;

import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.util.GemstyneConstants;
import lotus.gemstyne.world.util.OreModification;

/**
 * Contains keys for world generation using {@link OreModification}
 */
public final class WorldHandler {
    private WorldHandler() {}

    public static final OreModification AETHERIUM = new OreModification(BlockHandler.AETHERIUM).addDeepslateOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.LOWER);

    public static final OreModification ALDUS = new OreModification(BlockHandler.ALDUS).addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER).createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER);

    public static final OreModification BUBBLEGEM = new OreModification(BlockHandler.BUBBLEGEM)
        .addStoneOre().addDeepslateOre().createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER)
        .createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER);

    public static final OreModification BLAZITE = new OreModification(BlockHandler.BLAZITE).addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER).createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER);

    public static final OreModification CRIMONITE = new OreModification(BlockHandler.CRIMONITE).addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.LOWER).createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.UPPER);

    public static final OreModification ENDER_PEARL = new OreModification(BlockHandler.ENDER_PEARL)
        .addStoneOre().addDeepslateOre().addNetherOre().addEndOre().createKeyPair(GemstyneConstants.SMALL)
        .createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.NETHER).createKeyPair(GemstyneConstants.END);

    public static final OreModification MOCHITE = new OreModification(BlockHandler.MOCHITE)
        .addStoneOre().addRichStoneOre().addDeepslateOre().addRichDeepslateOre().addRawOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER).createKeyPair(GemstyneConstants.RICH)
        .createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER).createKeyPair(GemstyneConstants.RAW);

    public static final OreModification MUTALIUM = new OreModification(BlockHandler.MUTALIUM)
        .addStoneOre().addDeepslateOre().addNetherOre().addEndOre().createKeyPair(GemstyneConstants.SMALL)
        .createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.NETHER).createKeyPair(GemstyneConstants.END);

    public static final OreModification MORKITE = new OreModification(BlockHandler.MORKITE)
        .addDeepslateOre().addRawOre().createKeyPair(GemstyneConstants.EXPOSED)
        .createKeyPair(GemstyneConstants.BURIED).createKeyPair(GemstyneConstants.RAW);

    public static final OreModification TIN = new OreModification(BlockHandler.TIN)
        .addStoneOre().addDeepslateOre().addRawOre().createKeyPair(GemstyneConstants.SMALL)
        .createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.RAW);

    public static final OreModification TORRIUM = new OreModification(BlockHandler.TORRIUM)
        .addStoneOre().addDeepslateOre().addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL).createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.NETHER);

    public static final OreModification URANIUM = new OreModification(BlockHandler.URANIUM)
        .addDeepslateOre().addRawOre().createKeyPair(GemstyneConstants.SMALL)
        .createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.RAW);
}
