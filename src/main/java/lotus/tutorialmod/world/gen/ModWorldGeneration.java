package lotus.tutorialmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        // Make sure to call generateOres() *before* generateTrees()
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
    }
}
