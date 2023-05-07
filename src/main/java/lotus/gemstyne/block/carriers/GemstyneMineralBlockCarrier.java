package lotus.gemstyne.block.carriers;

import net.minecraft.block.Block;

public record GemstyneMineralBlockCarrier(
        Block compressedAndesite,
        Block compressedDiorite,
        Block compressedGranite,

        Block compactDirt,

        Block gabbro,
        Block halite,
        Block pumice
) {
}
