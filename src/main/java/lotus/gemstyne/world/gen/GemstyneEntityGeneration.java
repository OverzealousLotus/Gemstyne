package lotus.gemstyne.world.gen;

import lotus.gemstyne.entity.EntityHandler;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;

public class GemstyneEntityGeneration {
    private GemstyneEntityGeneration() {}

    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER,
            EntityHandler.AETHER_ZOMBIE, 35, 1, 3);

        SpawnRestriction.register(EntityHandler.AETHER_ZOMBIE, SpawnRestriction.Location.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark); // A Zombie is a hostile entity, so we use this class.
    }
}
