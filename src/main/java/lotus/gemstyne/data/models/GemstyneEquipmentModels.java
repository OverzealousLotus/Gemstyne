package lotus.gemstyne.data.models;

import lotus.gemstyne.armor.ArmorHandler;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.tool.ToolHandler;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class GemstyneEquipmentModels {
    private GemstyneEquipmentModels() {}

    public static void generateEquipmentItemModels(ItemModelGenerator itemModelGenerator) {
        // ======
        // <===== Armor =====>
        // ======
        itemModelGenerator.register(ArmorHandler.IKARITE_ELYTRA, Models.GENERATED);
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

        itemModelGenerator.register(ItemHandler.URANIUM_ARROW, Models.GENERATED);
    }
}
