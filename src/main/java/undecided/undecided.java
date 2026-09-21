package com.example.examplemod;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(undecided.MODID)
public class undecided {
    public static final String MODID = "undecided";
    public static final Logger LOGGER = LogUtils.getLogger();

    public undecided(IEventBus modEventBus, ModContainer modContainer) {
    }
}
