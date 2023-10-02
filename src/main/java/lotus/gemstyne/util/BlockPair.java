package lotus.gemstyne.util;

import net.minecraft.block.Block;

/**
 * Simple class to hold any block which extends {@link Block} and its ID.
 * @param <U> Any block which extends {@link Block}
 */
public class BlockPair {
    private final String blockID;
    private final Block block;

    public BlockPair(String blockID, Block block) {
        this.blockID = blockID;
        this.block = block;
    }

    /** Fetches the full name of the current block stored. */
    public String getBlockID() { return this.blockID; }
    /** Fetches the current block stored. */
    public Block getBlock() { return this.block; }
}
