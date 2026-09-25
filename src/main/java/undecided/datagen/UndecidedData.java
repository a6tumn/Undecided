package undecided.datagen;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import undecided.Undecided;
import undecided.datagen.assets.ModelGenerator;

@EventBusSubscriber(modid = Undecided.MODID)
public final class UndecidedData {
    private UndecidedData() {
    }

    @SubscribeEvent
    public static void gather(GatherDataEvent.Client event) {
        event.createProvider(ModelGenerator::new);
    }
}