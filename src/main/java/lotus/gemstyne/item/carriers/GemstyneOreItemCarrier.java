package lotus.gemstyne.item.carriers;

import net.minecraft.item.Item;

public record GemstyneOreItemCarrier(
        // ======
        // <===== Raw Ores =====>
        // ======
        Item rawAldus,
        Item rawCrimonite,
        Item rawMochite,
        Item rawTin,
        Item rawUranium,

        // ======
        // <===== Refined Ores =====>
        // ======
        Item aldusIngot,
        Item crimoniteChunk,
        Item crimoniteIngot,
        Item mochite,
        Item tinIngot,
        Item uraniumChunk,
        Item uraniumIngot,
        // ======
        // <===== Uncut Ores =====>
        // ======

        Item fireOpal,
        Item garnet,
        Item ikarite,
        Item morkite){ }
