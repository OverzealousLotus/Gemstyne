package lotus.gemstyne.world;

import lotus.gemstyne.block.GemstyneOreBlocks;

public class GemstyneWorldHandler {
    private GemstyneWorldHandler() {}

    public static final GemstyneOreModification TORRIUM = new GemstyneOreModification("torrium", GemstyneOreBlocks.TORRIUM)
        .addStoneOre().addDeepslateOre().createKeyPair("small", "small").createKeyPair("large", "large");
}
