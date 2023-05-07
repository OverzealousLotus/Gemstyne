package lotus.gemstyne.item;

import lotus.gemstyne.Gemstyne;
import lotus.gemstyne.item.spelunking.GemstyneOreItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GemstyneItemGroup {

    public static ItemGroup GEMSTYNE;

    public static void registerItemGroups() {
        GEMSTYNE = FabricItemGroup.builder(new Identifier(Gemstyne.MOD_ID, "mochite"))
                .displayName(Text.translatable("itemgroup.gemstyne"))
                .icon(() -> new ItemStack(GemstyneOreItems.ORE_ITEMS.mochite())).build();
    }
}
