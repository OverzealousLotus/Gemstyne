package lotus.gemstyne.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

import java.util.HashSet;
import java.util.Set;

/**
 * Appends tooltips to items without overriding the <code>appendToolTip</code> method.
 */
public class GemstyneToolTipFactory {
    private final String tooltip;
    private final Set<Item> items;


    public GemstyneToolTipFactory(String translationKey) {
        this.tooltip = "tooltips.gemstyne." + translationKey;
        this.items = new HashSet<>();
    }

    public Set<Item> getItems() {
        return this.items;
    }

    public String getTooltipKey() {
        return this.tooltip;
    }

    /**
     * Adds a {@link lotus.gemstyne.armor.GemstyneArmorSet} to the set of items.
     * @param armorSet {@link lotus.gemstyne.armor.GemstyneArmorSet}
     * @param style {@link Style}
     */
    public void addArmorSet(Set<ArmorItem> armorSet, Style style) {
        armorSet.forEach(piece -> {
            items.add(piece);
            if(isClient()) addToolTip(piece, style);
        });
    }

    /**
     * Adds a {@link lotus.gemstyne.tool.GemstyneToolSet} to the set of items.
     * @param toolSet {@link lotus.gemstyne.tool.GemstyneToolSet}
     * @param style {@link Style}
     */
    public void addToolSet(Set<ToolItem> toolSet, Style style) {
        toolSet.forEach(tool -> {
            items.add(tool);
            if(isClient()) addToolTip(tool, style);
        });
    }

    /**
     * Appends a tooltip to a single {@link Item}
     * @param item {@link Item}
     * @param style {@link Style}
     */
    public void addItem(Item item, Style style) {
        if(isClient()) addToolTip(item, style);
    }

    @Environment(EnvType.CLIENT)
    public void addToolTip(Item item, Style textStyle) {
        ItemTooltipCallback.EVENT.register(((stack, context, lines) -> {
            MutableText text = Text.literal("");
            if (stack.isOf(item)) {
                text.append(Text.translatable(tooltip));
                text.setStyle(textStyle);
                if (lines.size() > 2) {
                    var enchantCount = stack.getEnchantments().size();
                    lines.add(enchantCount + 1, text);
                } else lines.add(text);
            }
        }));
    }

    private static boolean isClient() {
        return FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT);
    }
}
