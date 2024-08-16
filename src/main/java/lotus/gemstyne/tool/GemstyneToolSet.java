package lotus.gemstyne.tool;

import com.google.common.collect.ImmutableMap;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.util.GemstyneCreativeGroup;
import lotus.gemstyne.util.GemstynePairs;
import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GemstyneToolSet {
    @NotNull public final ImmutableMap<String, GemstynePairs.ToolPair> tools;
    public final Item source;
    public final String setName;

    private static final float BASE_SHOVEL_SPEED = -3.0F;
    private static final float BASE_PICKAXE_SPEED = -2.8F;
    private static final float BASE_SWORD_SPEED = -2.4F;

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
            "axe", new GemstynePairs.ToolPair(setName + "_axe", this.makeAxe(material, (int) attackDamage[0], attackSpeed[0], settings)),
            "hoe", new GemstynePairs.ToolPair(setName + "_hoe", this.makeHoe(material, (int) attackDamage[1], attackSpeed[1], settings)),
            "pickaxe", new GemstynePairs.ToolPair(setName + "_pickaxe", this.makePickaxe(material, (int) attackDamage[2], BASE_PICKAXE_SPEED, settings)),
            "shovel", new GemstynePairs.ToolPair(setName + "_shovel", this.makeShovel(material, (int) attackDamage[3], BASE_SHOVEL_SPEED, settings)),
            "sword", new GemstynePairs.ToolPair(setName + "_sword", this.makeSword(material, (int) attackDamage[4], BASE_SWORD_SPEED, settings))
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
    public ImmutableMap<String, GemstynePairs.ToolPair> getToolMap() { return this.tools; }
    public String getSetName() { return this.setName; }

    /**
     * <code>registerToolSet</code> is used to register the items at once when created.
     * It must be called at the end of the {@link GemstyneToolSet} constructor.
     * @param setName The name of the Tool Set.
     */
    public void registerToolSet(String setName) {
        this.tools.forEach((needle, toolPair) -> GemstyneRegistry.registerItem(toolPair.toolID(), toolPair.tool()));
    }

    /**
     * Uses {@link SwordItem} attribute calculations.
     */
    protected SwordItem makeSword(ToolMaterial material, int damage, float speed, OwoItemSettings settings) {
        return new SwordItem(material, settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS,
            SwordItem.createAttributeModifiers(material, damage, speed)));
    }

    /**
     * Uses {@link MiningToolItem} attribute calculations.
     */
    protected AxeItem makeAxe(ToolMaterial material, int damage, float speed, OwoItemSettings settings) {
        return new AxeItem(material, settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS,
            MiningToolItem.createAttributeModifiers(material, damage, speed)));
    }

    protected PickaxeItem makePickaxe(ToolMaterial material, int damage, float speed, OwoItemSettings settings) {
        return new PickaxeItem(material, settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS,
            MiningToolItem.createAttributeModifiers(material, damage, speed)));
    }

    protected ShovelItem makeShovel(ToolMaterial material, int damage, float speed, OwoItemSettings settings) {
        return new ShovelItem(material, settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS,
            MiningToolItem.createAttributeModifiers(material, damage, speed)));
    }

    protected HoeItem makeHoe(ToolMaterial material, int damage, float speed, OwoItemSettings settings) {
        return new HoeItem(material, settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS,
            MiningToolItem.createAttributeModifiers(material, damage, speed)));
    }

    public static AttributeModifiersComponent createAttributeModifiers(double damage, float speed) {
        if (speed < 0.0f) {
            speed = 0;
        }
        return AttributeModifiersComponent.builder()
            .add(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, damage, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
            )
            .add(
                EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, -4.0 + speed, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
            )
            .build();
    }

    public static AttributeModifiersComponent createAttributeModifiers(ToolMaterial material, double damage, float speed) {
        if (speed < 0.0f) {
            speed = 0;
        }
        return AttributeModifiersComponent.builder()
            .add(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, material.getAttackDamage() + damage, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
            )
            .add(
                EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, -4.0 + speed, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
            )
            .build();
    }
}
