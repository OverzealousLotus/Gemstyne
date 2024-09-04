package lotus.gemstyne.damage;

import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.*;

public class GemstyneDamageTypes {
    private GemstyneDamageTypes() {}

    public static final RegistryKey<DamageType> RADIATION = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, GemstyneRegistry.id("radiation"));
}
