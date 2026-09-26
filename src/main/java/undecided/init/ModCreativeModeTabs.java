package undecided.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;
import undecided.Undecided;

import java.util.function.Supplier;

public final class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Undecided.MODID);

    public static final Supplier<CreativeModeTab> ITEMS = CREATIVE_MODE_TABS.register("items", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup." + Undecided.MODID + ".items"))
        .icon(() -> new ItemStack(ModItems.MAGISTEEL_CLUSTER.get()))
        .displayItems((_, output) -> {
            output.accept(ModItems.GELIN_CORE);
            output.accept(ModItems.MAGISTEEL_CLUSTER);
            output.accept(ModItems.MAGISTEEL_INGOT);
        })
        .build()
    );

    public static final Supplier<CreativeModeTab> BLOCKS = CREATIVE_MODE_TABS.register("blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Undecided.MODID + ".blocks"))
            .icon(() -> new ItemStack(ModBlocks.CHISELED_HYDROLITH_BRICKS.get()))
            .displayItems((_, output) -> {
                output.accept(ModBlocks.HYDROLITH_BRICKS);
                output.accept(ModBlocks.HYDROLITH_MOSAIC);
                output.accept(ModBlocks.CHISELED_HYDROLITH_BRICKS);
            })
            .build()
    );
}