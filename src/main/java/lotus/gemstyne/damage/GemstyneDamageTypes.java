package lotus.gemstyne.damage;

import lotus.gemstyne.util.GemstyneRegistry;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.*;

public class GemstyneDamageTypes implements DamageTypes {
    private GemstyneDamageTypes() {}

    public static final RegistryKey<DamageType> RADIATION = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, GemstyneRegistry.id("radiation"));

    public static void bootstrap(Registerable<DamageType> context) {
        context.register(RADIATION, new DamageType("radiation", 0.1f));
    }
}
