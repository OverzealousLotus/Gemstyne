package lotus.gemstyne.tool;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.item.*;

public class GemstyneToolSet {
    public final AxeItem axe;
    public final HoeItem hoe;
    public final PickaxeItem pickaxe;
    public final ShovelItem shovel;
    public final SwordItem sword;
    public final Item source;


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
        settings.group(GemstyneCreativeGroup.GEMSTYNE);
        this.axe = new AxeItem(material, attackDamage[0], attackSpeed[0], settings);
        this.hoe = new HoeItem(material, (int) attackDamage[1], attackSpeed[1], settings);
        this.pickaxe = new PickaxeItem(material, (int) attackDamage[2], attackSpeed[2], settings);
        this.shovel = new ShovelItem(material, attackDamage[3], attackSpeed[3], settings);
        this.sword = new SwordItem(material, (int) attackDamage[4], attackSpeed[4], settings);
        this.source = source;
        this.registerToolSet(setName);
    }

    /**
     * <code>registerToolSet</code> is used to register the items at once when created.
     * It must be called at the end of the {@link GemstyneToolSet} constructor.
     * @param setName The name of the Tool Set.
     */
    public void registerToolSet(String setName) {
        GemstyneRegistry.registerItem(setName + "_axe", this.axe);
        GemstyneRegistry.registerItem(setName + "_hoe", this.hoe);
        GemstyneRegistry.registerItem(setName + "_pickaxe", this.pickaxe);
        GemstyneRegistry.registerItem(setName + "_shovel", this.shovel);
        GemstyneRegistry.registerItem(setName + "_sword", this.sword);
    }
}
