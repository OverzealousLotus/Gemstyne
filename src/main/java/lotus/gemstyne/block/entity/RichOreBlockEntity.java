package lotus.gemstyne.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RichOreBlockEntity extends BlockEntity {
    public final PropertyDelegate propertyDelegate;
    private int currentStates;
    private boolean isNew = true;
    public RichOreBlockEntity(BlockPos pos, BlockState state) {
        super(GemstyneBlockEntities.DEEP_ORE_BLOCK, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                if (index == 0) {
                    return RichOreBlockEntity.this.currentStates;
                }
                return 0;
            }

            @Override
            public void set(int index, int value) {
                if (index == 0) {
                    RichOreBlockEntity.this.currentStates = value;
                }
            }

            @Override
            public int size() {
                return 1;
            }
        };
    }

    public final boolean isNew() {
        return isNew;
    }

    public final void setNewness(boolean age) {
        isNew = age;
    }

    public final int getCurrentStates() {
        return this.currentStates;
    }

    public final void setCurrentStates(int currentStates) {
        this.currentStates = currentStates;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("deep_ore_block.currentStates", currentStates);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        currentStates = nbt.getInt("deep_ore_block.currentStates");
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, RichOreBlockEntity entity) {
        // Currently, this method is here only for overriding purposes.
    }
}
