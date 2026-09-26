package undecided.component;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import undecided.Undecided;
import undecided.init.ModDataComponentTypes;

import java.util.function.Consumer;

public record MagisteelIngotTooltipComponent() implements TooltipProvider {
    public static final MagisteelIngotTooltipComponent INSTANCE = new MagisteelIngotTooltipComponent();

    @Override
    public void addToTooltip(Item.TooltipContext tooltipContext, Consumer<Component> consumer, TooltipFlag tooltipFlag, DataComponentGetter dataComponentGetter) {
        var refined = dataComponentGetter.get(ModDataComponentTypes.MAGISTEEL_REFINED.get());
        if (Boolean.TRUE.equals(refined)) {
            consumer.accept(Component.translatable("item." + Undecided.MODID + ".magisteel_ingot.refined").withStyle(ChatFormatting.DARK_PURPLE));
        }
    }
}
