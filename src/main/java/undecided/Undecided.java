package undecided;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import undecided.init.ModCreativeModeTabs;
import undecided.init.ModDataComponentTypes;
import undecided.init.ModItems;

@Mod(Undecided.MODID)
public class Undecided {
    public static final String MODID = "undecided";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }

    public Undecided(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModDataComponentTypes.DATA_COMPONENT_TYPES.register(modEventBus);
    }
}
