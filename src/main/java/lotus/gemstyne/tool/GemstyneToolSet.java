package lotus.gemstyne.tool;

import com.google.common.collect.ImmutableMap;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstynePairs;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GemstyneToolSet {
    @NotNull public final ImmutableMap<String, GemstynePairs.ToolPair> tools;
    public final Item source;
    public final String setName;


    /**
     * Constructor of {@link GemstyneToolSet}
     * Assigns each Tool piece a value, then registers them in Minecraft. They can be accessed using
     * <code>setName.type</code>
     * @param settings Settings assigned to set.
     * @param setName Name of Tool set.
     * @param material Material of set.
     */
    public GemstyneToolSet(
            OwoItemSettings settings,
            float[] attackDamage,
            float[] attackSpeed,
            String setName,
            ToolMaterial material,
            Item source) {
        settings.group(GemstyneCreativeGroup.GEMSTYNE).tab(2);
        this.source = source;
        this.setName = setName;
        this.tools = ImmutableMap.of(
            "axe", new GemstynePairs.ToolPair(setName + "_axe", new AxeItem(material, attackDamage[0], attackSpeed[0], settings)),
            "hoe", new GemstynePairs.ToolPair(setName + "_hoe", new HoeItem(material, (int) attackDamage[1], attackSpeed[1], settings)),
            "pickaxe", new GemstynePairs.ToolPair(setName + "_pickaxe", new PickaxeItem(material, (int) attackDamage[2], attackSpeed[2], settings)),
            "shovel", new GemstynePairs.ToolPair(setName + "_shovel", new ShovelItem(material, attackDamage[3], attackSpeed[3], settings)),
            "sword", new GemstynePairs.ToolPair(setName + "_sword", new SwordItem(material, (int) attackDamage[4], attackSpeed[4], settings))
        );
        this.registerToolSet(setName);
    }

    /**
     * Automatically registers models for all tools in the set.
     * @param itemModelGenerator {@link lotus.gemstyne.data.models.GemstyneEquipmentModels}
     */
    public void registerToolModels(ItemModelGenerator itemModelGenerator) {
        this.tools.values().forEach(toolPair -> itemModelGenerator.register(toolPair.tool(), Models.HANDHELD));
    }

    /**
     * Safely fetches an {@link ToolItem} from {@link GemstyneToolSet}. If the Tool is not present, then
     * an error message with hints is printed, then a {@link NullPointerException} is thrown.
     * @param toolName Name of target {@link ToolItem}
     * @return Returns {@link ToolItem} safely, or throws a {@link NullPointerException} instead of returning null.
     */
    private ToolItem safelyFetch(String toolName) {
        Optional<GemstynePairs.ToolPair> toolPair = Optional.ofNullable(this.tools.get(toolName));
        if(toolPair.isPresent()) {
            return toolPair.get().tool();
        } else if(Gemstyne.LOGGER.isErrorEnabled()) {
            Gemstyne.LOGGER.error(
                String.format("[[ ERROR: %s for set %s is null! %s %n %s %n %s", toolName, this.setName,
                    "Maybe the Tool is improperly initialized?",
                    "OR the ToolSet was called in an incompatible Method!",
                    "OTHERWISE the wrong getter was called!"));
        }
        throw new NullPointerException();
    }

    public ToolItem getAxe() { return safelyFetch("axe"); }
    public ToolItem getHoe() { return safelyFetch("hoe"); }
    public ToolItem getPickaxe() { return safelyFetch("pickaxe"); }
    public ToolItem getShovel() { return safelyFetch("shovel"); }
    public ToolItem getSword() { return safelyFetch("sword"); }
    @NotNull
    public ImmutableMap<String, GemstynePairs.ToolPair> getTools() { return this.tools; }

    /**
     * <code>registerToolSet</code> is used to register the items at once when created.
     * It must be called at the end of the {@link GemstyneToolSet} constructor.
     * @param setName The name of the Tool Set.
     */
    public void registerToolSet(String setName) {
        this.tools.forEach((needle, toolPair) -> GemstyneRegistry.registerItem(toolPair.toolID(), toolPair.tool()));
    }
}
