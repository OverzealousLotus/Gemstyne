package lotus.gemstyne.tool;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

/**
 * Gemstyne's tool-item holder. A record is used to auto-generate getters.
 */
public final class GemstyneToolItems {
    // =====
    // <=====| Damage & Speed |=====>
    // =====
    private static final float[] ALDUS_DAMAGE = {6.0f, -2.0f, 1.0f, 1.5f, 4.0f};
    private static final float[] BRONZE_DAMAGE = {6.0f, -2.0f, 1, 1.5f, 3.0f};
    private static final float[] RENDFIRE_DAMAGE = {5.0f, -4.0f, 1.0f, 1.5f, 4.0f};

    private static final float[] ALDUS_SPEED = {-3.0f, -0.5f, -2.7f, -3.0f, -2.4f};
    private static final float[] BRONZE_SPEED = {-3.1f, -0.5f, -2.7f, -2.8f, -2.4f};
    private static final float[] RENDFIRE_SPEED = {-3.0f, 0.0f, -2.8f, -3.0f, -2.4f};

    public static final GemstyneToolSet ALDUS = new GemstyneToolSet(new FabricItemSettings(),
            ALDUS_DAMAGE, ALDUS_SPEED, "aldus", GemstyneToolMaterials.ALDUS, GemstyneOreItems.ALDUS.INGOT);
    public static final GemstyneToolSet BRONZE = new GemstyneToolSet(new FabricItemSettings(),
            BRONZE_DAMAGE, BRONZE_SPEED, "bronze", GemstyneToolMaterials.BRONZE, GemstyneOreItems.BRONZE.INGOT);
    public static final GemstyneToolSet RENDFIRE = new GemstyneToolSet(new FabricItemSettings(),
            RENDFIRE_DAMAGE, RENDFIRE_SPEED, "rendfire", GemstyneToolMaterials.RENDFIRE, GemstyneOreItems.FIRE_OPAL);


    public static void registerToolItems() { Gemstyne.LOGGER.info("Registering Tool Items..."); }
}
