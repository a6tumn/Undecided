package undecided.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.MoonPhase;
import net.minecraft.world.level.block.Blocks;
import undecided.init.ModDataComponentTypes;

public class MagisteelIngotItem extends Item {
    public MagisteelIngotItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if (!(entity.level() instanceof ServerLevel serverLevel)) {
            return false;
        }

        if (!serverLevel.getBlockState(entity.blockPosition()).is(Blocks.SOUL_FIRE)) {
            return false;
        }

        if (serverLevel.getServer().overworld().environmentAttributes().getValue(EnvironmentAttributes.MOON_PHASE, BlockPos.ZERO) != MoonPhase.FULL_MOON) {
            return false;
        }

        if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.MAGISTEEL_REFINED.get()))) {
            return false;
        }

        ItemStack refined = stack.copy();
        refined.set(ModDataComponentTypes.MAGISTEEL_REFINED.get(), true);
        entity.setItem(refined);
        return true;
    }
}