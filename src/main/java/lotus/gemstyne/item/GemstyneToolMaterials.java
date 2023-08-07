package lotus.gemstyne.item;

import com.google.common.base.Suppliers;
// import net.fabricmc.yarn.constants.MiningLevels;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import lotus.gemstyne.util.GemstyneMiningLevels;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum GemstyneToolMaterials implements ToolMaterial {
    // When creating new tools, these values are default, but can be added to.
    // If creating a new tool, and not wanting to add more of either, put 0.
    ALDUS(MiningLevels.DIAMOND,
            800,
            7.0f,
            2.0f,
            15, () -> Ingredient.ofItems(GemstyneOreItems.ORE_ITEMS.aldusIngot())),
    BRONZE(MiningLevels.IRON,
            400,
            6.5f,
            2.0f,
            10, () -> Ingredient.ofItems(GemstyneOreItems.ORE_ITEMS.bronzeIngot())),
    RENDFIRE(GemstyneMiningLevels.RENDFIRE,
                     2500,
                     9.0f,
                     4.5f,
                     20,()->Ingredient.ofItems(GemstyneOreItems.ORE_ITEMS.fireOpal()));


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private GemstyneToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
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
    public int getMiningLevel() {
        return this.miningLevel;
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
