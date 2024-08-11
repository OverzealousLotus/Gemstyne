package lotus.gemstyne.tool;

import com.google.common.base.Suppliers;
import lotus.gemstyne.item.ItemHandler;
import lotus.gemstyne.util.GemstyneBlockTags;
import lotus.gemstyne.util.GemstyneMiningLevels;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum GemstyneToolMaterials implements ToolMaterial {
    // When creating new tool, these values are default, but can be added to.
    // If creating a new tool, and not wanting to add more of either, put 0.
    ALDUS(3,
        800,
        7.0f,
        2.0f,
        15, () -> Ingredient.ofItems(ItemHandler.ALDUS.ingot())),
    BRONZE(2,
        400,
        6.5f,
        2.0f,
        10, () -> Ingredient.ofItems(ItemHandler.BRONZE.ingot())),
    RENDFIRE(GemstyneMiningLevels.RENDFIRE,
        2500,
        9.0f,
        4.5f,
        20,()->Ingredient.ofItems(ItemHandler.FIRE_OPAL));


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    GemstyneToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return switch (this.miningLevel) {
            case 1 -> BlockTags.INCORRECT_FOR_STONE_TOOL;
            case 2 -> BlockTags.INCORRECT_FOR_IRON_TOOL;
            case 3 -> BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
            case 4 -> BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
            case 5 -> GemstyneBlockTags.INCORRECT_FOR_RENDFIRE_TOOL;
            default -> throw new IllegalStateException("Unexpected value: " + this.miningLevel);
        };
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
