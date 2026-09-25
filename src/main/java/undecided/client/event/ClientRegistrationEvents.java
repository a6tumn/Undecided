package undecided.client.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterConditionalItemModelPropertyEvent;
import undecided.Undecided;
import undecided.client.model.property.RefinedModelProperty;

@EventBusSubscriber(modid = Undecided.MODID, value = Dist.CLIENT)
public class ClientRegistrationEvents {

    @SubscribeEvent
    public static void registerConditionalItemModelProperties(RegisterConditionalItemModelPropertyEvent event) {
        event.register(Undecided.id("refined"), RefinedModelProperty.MAP_CODEC);
    }
}