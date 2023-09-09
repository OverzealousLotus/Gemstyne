package lotus.gemstyne.world;

import lotus.gemstyne.block.GemstyneOreBlocks;
import lotus.gemstyne.util.GemstyneConstants;

public class GemstyneWorldHandler {
    private GemstyneWorldHandler() {}

    public static final  GemstyneOreModification ALDUS = new GemstyneOreModification(GemstyneOreBlocks.ALDUS).addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER).createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER);

    public static final  GemstyneOreModification CRIMONITE = new GemstyneOreModification(GemstyneOreBlocks.CRIMONITE).addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.LOWER).createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.UPPER);

    public static final GemstyneOreModification MOCHITE = new GemstyneOreModification(GemstyneOreBlocks.MOCHITE)
        .addStoneOre().addDeepslateOre().createKeyPair(GemstyneConstants.SMALL, GemstyneConstants.UPPER)
        .createKeyPair(GemstyneConstants.LARGE, GemstyneConstants.LOWER);

    public static final GemstyneOreModification MUTALIUM = new GemstyneOreModification(GemstyneOreBlocks.MUTALIUM)
        .addStoneOre().addDeepslateOre().addNetherOre().addEndOre().createKeyPair(GemstyneConstants.SMALL)
        .createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.NETHER).createKeyPair(GemstyneConstants.END);

    public static final GemstyneOreModification TIN = new GemstyneOreModification(GemstyneOreBlocks.TIN)
        .addStoneOre().addDeepslateOre().createKeyPair(GemstyneConstants.SMALL).createKeyPair(GemstyneConstants.LARGE);

    public static final GemstyneOreModification TORRIUM = new GemstyneOreModification(GemstyneOreBlocks.TORRIUM)
        .addStoneOre().addDeepslateOre().addNetherOre()
        .createKeyPair(GemstyneConstants.SMALL).createKeyPair(GemstyneConstants.LARGE).createKeyPair(GemstyneConstants.NETHER);

    public static final GemstyneOreModification URANIUM = new GemstyneOreModification(GemstyneOreBlocks.URANIUM)
        .addDeepslateOre().createKeyPair(GemstyneConstants.SMALL).createKeyPair(GemstyneConstants.LARGE);
}
