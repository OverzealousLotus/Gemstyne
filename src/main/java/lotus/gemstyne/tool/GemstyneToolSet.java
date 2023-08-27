package lotus.gemstyne.tool;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.item.*;

public class GemstyneToolSet {
    public final AxeItem AXE;
    public final HoeItem HOE;
    public final PickaxeItem PICKAXE;
    public final ShovelItem SHOVEL;
    public final SwordItem SWORD;
    public final Item SOURCE;


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
        this.AXE = new AxeItem(material, attackDamage[0], attackSpeed[0], settings);
        this.HOE = new HoeItem(material, (int) attackDamage[1], attackSpeed[1], settings);
        this.PICKAXE = new PickaxeItem(material, (int) attackDamage[2], attackSpeed[2], settings);
        this.SHOVEL = new ShovelItem(material, attackDamage[3], attackSpeed[3], settings);
        this.SWORD = new SwordItem(material, (int) attackDamage[4], attackSpeed[4], settings);
        this.SOURCE = source;
        this.registerToolSet(setName);
    }

    /**
     * <code>registerToolSet</code> is used to register the items at once when created.
     * It must be called at the end of the {@link GemstyneToolSet} constructor.
     * @param setName The name of the Tool Set.
     */
    public void registerToolSet(String setName) {
        GemstyneRegistry.registerItem(setName + "_axe", this.AXE);
        GemstyneRegistry.registerItem(setName + "_hoe", this.HOE);
        GemstyneRegistry.registerItem(setName + "_pickaxe", this.PICKAXE);
        GemstyneRegistry.registerItem(setName + "_shovel", this.SHOVEL);
        GemstyneRegistry.registerItem(setName + "_sword", this.SWORD);
    }
}
