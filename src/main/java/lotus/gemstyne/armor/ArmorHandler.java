package lotus.gemstyne.armor;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.armor.custom.IkariteElytra;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.util.Rarity;

public class ArmorHandler {
    private ArmorHandler() {}
    
    public static final ArmorSet ALDUS = new ArmorSet("aldus", GemstyneArmorMaterials.ALDUS, ItemHandler.ALDUS.ingot());
    public static final ArmorSet BRONZEMAIL = new ArmorSet("bronzemail", GemstyneArmorMaterials.BRONZEMAIL, ItemHandler.BRONZE.chain());
    public static final ArmorSet BRONZEPLATE = new ArmorSet("bronzeplate", GemstyneArmorMaterials.BRONZEPLATE, ItemHandler.BRONZE.ingot());
    public static final ArmorSet RENDFIRE = new ArmorSet("rendfire", GemstyneArmorMaterials.RENDFIRE, ItemHandler.FIRE_OPAL, settings -> settings.fireproof().rarity(Rarity.EPIC));
    public static final IkariteElytra IKARITE_ELYTRA = new IkariteElytra(new OwoItemSettings()
        .rarity(Rarity.RARE).group(GemstyneCreativeGroup.GEMSTYNE).tab(2).maxDamage(832));


    public static void registerArmorItems() {
        Gemstyne.LOGGER.info("Registering Armor Items...");
        GemstyneRegistry.registerItem("ikarite_elytra", IKARITE_ELYTRA);
    }
}
