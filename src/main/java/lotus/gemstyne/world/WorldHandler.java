package lotus.gemstyne.world;

import lotus.gemstyne.block.BlockHandler;
import lotus.gemstyne.util.GemstyneConstants;

/**
 * Contains keys for world generation using {@link GemstyneOreModification}
 */
public final class WorldHandler {
    private WorldHandler() {}

    public static final GemstyneOreModification AETHERIUM = new GemstyneOreModification(BlockHandler.AETHERIUM).addDeepslateOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.LOWER);

    public static final GemstyneOreModification ALDUS = new GemstyneOreModification(BlockHandler.ALDUS).addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER).createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER);

    public static final GemstyneOreModification BUBBLEGEM = new GemstyneOreModification(BlockHandler.BUBBLEGEM)
        .addStoneOre().addDeepslateOre().createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER)
        .createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER);

    public static final GemstyneOreModification BLAZITE = new GemstyneOreModification(BlockHandler.BLAZITE).addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER).createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER);

    public static final GemstyneOreModification CRIMONITE = new GemstyneOreModification(BlockHandler.CRIMONITE).addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.LOWER).createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.UPPER);

    public static final GemstyneOreModification ENDER_PEARL = new GemstyneOreModification(BlockHandler.ENDER_PEARL)
        .addStoneOre().addDeepslateOre().addNetherOre().addEndOre().createKeyPair(GemstyneConstants.SMALL)
        .createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.NETHER).createKeyPair(GemstyneConstants.END);

    public static final GemstyneOreModification MOCHITE = new GemstyneOreModification(BlockHandler.MOCHITE)
        .addStoneOre().addRichStoneOre().addDeepslateOre().addRichDeepslateOre().addRawOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER).createKeyPair(GemstyneConstants.RICH)
        .createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER).createKeyPair(GemstyneConstants.RAW);

    public static final GemstyneOreModification MUTALIUM = new GemstyneOreModification(BlockHandler.MUTALIUM)
        .addStoneOre().addDeepslateOre().addNetherOre().addEndOre().createKeyPair(GemstyneConstants.SMALL)
        .createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.NETHER).createKeyPair(GemstyneConstants.END);

    public static final GemstyneOreModification MORKITE = new GemstyneOreModification(BlockHandler.MORKITE)
        .addDeepslateOre().addRawOre().createKeyPair(GemstyneConstants.EXPOSED)
        .createKeyPair(GemstyneConstants.BURIED).createKeyPair(GemstyneConstants.RAW);

    public static final GemstyneOreModification TIN = new GemstyneOreModification(BlockHandler.TIN)
        .addStoneOre().addDeepslateOre().addRawOre().createKeyPair(GemstyneConstants.SMALL)
        .createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.RAW);

    public static final GemstyneOreModification TORRIUM = new GemstyneOreModification(BlockHandler.TORRIUM)
        .addStoneOre().addDeepslateOre().addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL).createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.NETHER);

    public static final GemstyneOreModification URANIUM = new GemstyneOreModification(BlockHandler.URANIUM)
        .addDeepslateOre().addRawOre().createKeyPair(GemstyneConstants.SMALL)
        .createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.RAW);
}
