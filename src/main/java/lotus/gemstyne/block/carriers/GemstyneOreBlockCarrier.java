package lotus.gemstyne.block.carriers;

import net.minecraft.block.Block;

public record GemstyneOreBlockCarrier(
        // =====
        // <===== Overworld Ores =====>
        // =====
        Block compressedGraniteFireOpalOre,

        Block mochiteOre,
        Block deepslateMochiteOre,

        Block deepslateMorkiteOre,

        Block tinOre,
        Block deepslateTinOre,

        Block deepslateUraniumOre,

        // =====
        // <===== Nether Ores =====>
        // =====
        Block netherAldusOre,

        Block netherCrimoniteOre,

        // =====
        // <===== Ore Extensions =====>
        // =====
        Block compressedGraniteCoalOre,

        // =====
        // <===== Concentrated Ores =====>
        // =====
        Block rawAldusBlock,
        Block rawCrimoniteBlock,
        Block rawMochiteBlock,
        Block morkiteBlock,
        Block rawTinBlock,
        Block rawUraniumBlock
) {
}
