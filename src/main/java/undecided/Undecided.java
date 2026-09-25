package undecided;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(Undecided.MODID)
public class Undecided {
    public static final String MODID = "undecided";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Undecided(IEventBus modEventBus, ModContainer modContainer) {
    }
}
