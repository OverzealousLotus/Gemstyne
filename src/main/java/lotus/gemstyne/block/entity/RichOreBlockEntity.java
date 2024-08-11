package lotus.gemstyne.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RichOreBlockEntity extends BlockEntity {
    public final PropertyDelegate propertyDelegate;
    private int currentStates;
    private int isNew = 1;
    public RichOreBlockEntity(BlockPos pos, BlockState state) {
        super(GemstyneBlockEntities.DEEP_ORE_BLOCK, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> RichOreBlockEntity.this.currentStates;
                    case 1 -> RichOreBlockEntity.this.isNew;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                if (index == 0) {
                    RichOreBlockEntity.this.currentStates = value;
                } else {
                    RichOreBlockEntity.this.isNew = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    public final boolean isNew() { return this.isNew == 1; }

    public final void aged() {
        this.isNew = 0;
    }

    public final int getCurrentStates() {
        return this.currentStates;
    }

    public final void setCurrentStates(int currentStates, World world, BlockPos position, BlockState state) {
        this.currentStates = currentStates;
        markDirty(world, position, state); // Automatically syncs when method is called.
    }

    /**
     * Each time {@code markDirty()} is called, {@code writeNbt()} will be called to save the modification, which
     * will later be read by {@code readNbt()} when a world is reloaded. This prevents the block's values from
     * being reset each time the world is reloaded.
     * @param nbt {@link NbtCompound}
     */
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("rich_ore.currentStates", this.currentStates);
        nbt.putInt("rich_ore.isNew", this.isNew);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        this.currentStates = nbt.getInt("rich_ore.currentStates");
        this.isNew = nbt.getInt("rich_ore.isNew");
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, RichOreBlockEntity entity) {
        // Currently, this method is here only for overriding purposes.
    }
}
