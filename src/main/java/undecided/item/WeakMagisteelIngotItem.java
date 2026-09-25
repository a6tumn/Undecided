package undecided.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.MoonPhase;
import net.minecraft.world.level.block.Blocks;
import undecided.init.ModItemsTwo;

public class WeakMagisteelIngotItem extends Item {
    public WeakMagisteelIngotItem(Properties properties) {
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

        entity.setItem(stack.transmuteCopy(ModItemsTwo.REFINED_MAGISTEEL_INGOT.get()));
        return true;
    }
}