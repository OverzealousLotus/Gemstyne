package lotus.gemstyne.data.models;

import lotus.gemstyne.armor.ArmorHandler;
import lotus.gemstyne.tool.ToolHandler;
import net.minecraft.data.client.ItemModelGenerator;

public class GemstyneEquipmentModels {
    private GemstyneEquipmentModels() {}

    public static void generateEquipmentItemModels(ItemModelGenerator itemModelGenerator) {
        // ======
        // <===== Armor =====>
        // ======
        ArmorHandler.ALDUS.registerModels(itemModelGenerator);
        ArmorHandler.BRONZEMAIL.registerModels(itemModelGenerator);
        ArmorHandler.BRONZEPLATE.registerModels(itemModelGenerator);
        ArmorHandler.RENDFIRE.registerModels(itemModelGenerator);



        // ======
        // <===== Tools =====>
        // ======
        ToolHandler.ALDUS.registerToolModels(itemModelGenerator);
        ToolHandler.BRONZE.registerToolModels(itemModelGenerator);
        ToolHandler.MUTALIUM.registerToolModels(itemModelGenerator);
        ToolHandler.RENDFIRE.registerToolModels(itemModelGenerator);
    }
}
