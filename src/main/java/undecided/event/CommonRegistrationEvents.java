package undecided.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterTooltipAppendersEvent;
import undecided.Undecided;
import undecided.init.ModDataComponentTypes;

@EventBusSubscriber(modid = Undecided.MODID)
public class CommonRegistrationEvents {

    @SubscribeEvent
    public static void registerTooltipAppenders(RegisterTooltipAppendersEvent event) {
        event.registerComponentAppenderAfterAll(
                ModDataComponentTypes.MAGISTEEL_INGOT_TOOLTIP.get(),
                (stack, context, display, _, tooltipFlag, builder) -> stack.addToTooltip(ModDataComponentTypes.MAGISTEEL_INGOT_TOOLTIP.get(), context, display, builder, tooltipFlag)
        );
    }
}