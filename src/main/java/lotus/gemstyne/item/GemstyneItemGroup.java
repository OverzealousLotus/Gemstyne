package lotus.gemstyne.item;

import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static lotus.gemstyne.Gemstyne.MOD_ID;

public class GemstyneItemGroup {

    public static RegistryKey<ItemGroup> GEMSTYNE = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "mochite"));

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, GEMSTYNE, FabricItemGroup.builder()
                .displayName(Text.translatable("itemgroup.gemstyne"))
                .icon(() -> new ItemStack(GemstyneOreItems.ORE_ITEMS.mochite())).build());
    }
}
