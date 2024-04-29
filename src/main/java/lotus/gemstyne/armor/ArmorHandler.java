package lotus.gemstyne.armor;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.util.Rarity;

public class ArmorHandler {
    private ArmorHandler() {}
    
    public static final GemstyneArmorSet ALDUS = new GemstyneArmorSet(new OwoItemSettings(),
            "aldus", GemstyneArmorMaterials.ALDUS, ItemHandler.ALDUS.ingot());
    public static final GemstyneArmorSet BRONZEMAIL = new GemstyneArmorSet(new OwoItemSettings(),
            "bronzemail", GemstyneArmorMaterials.BRONZEMAIL, ItemHandler.BRONZE.chain());
    public static final GemstyneArmorSet BRONZEPLATE = new GemstyneArmorSet(new OwoItemSettings(),
            "bronzeplate", GemstyneArmorMaterials.BRONZEPLATE, ItemHandler.BRONZE.ingot());
    public static final GemstyneArmorSet RENDFIRE = new GemstyneArmorSet(new OwoItemSettings().fireproof().rarity(Rarity.EPIC),
            "rendfire", GemstyneArmorMaterials.RENDFIRE, ItemHandler.FIRE_OPAL);
    public static final IkariteElytra IKARITE_ELYTRA = new IkariteElytra(new OwoItemSettings()
        .rarity(Rarity.RARE).group(GemstyneCreativeGroup.GEMSTYNE).tab(2).maxDamage(832));


    public static void registerArmorItems() {
        Gemstyne.LOGGER.info("Registering Armor Items...");
        GemstyneRegistry.registerItem("ikarite_elytra", IKARITE_ELYTRA);
    }
}
