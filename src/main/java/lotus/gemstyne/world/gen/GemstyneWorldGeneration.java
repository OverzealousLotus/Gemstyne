package lotus.gemstyne.world.gen;

public class GemstyneWorldGeneration {
    private GemstyneWorldGeneration() {}

    public static void generateModWorldGen() {
        // Make sure to call generateOres() *before* generateTrees()
        GemstyneOreGeneration.generateOres();
        GemstyneEntityGeneration.addSpawns();
    }
}
