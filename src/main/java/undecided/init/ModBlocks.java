package undecided.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import undecided.Undecided;

import java.util.function.Function;

///NOTE: Since I'm the first one to do blocks that means that this code is likely bad as I'm heavily referencing a youtube tutorial (since my understanding has been broken after 1.21.1) and vanilla. If you want to change / fix anything, feel free.
public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Undecided.MODID);

    public static final DeferredBlock<Block> HYDROLITH_BRICKS = registerBlock("hydrolith_bricks",
            properties -> new Block(properties.strength(4f)
                    .mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));

    public static final DeferredBlock<Block> HYDROLITH_MOSAIC = registerBlock("hydrolith_mosaic",
            properties -> new Block(properties.strength(4f)
                    .mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));

    public static final DeferredBlock<Block> CHISELED_HYDROLITH_BRICKS = registerBlock("chiseled_hydrolith_bricks",
            properties -> new Block(properties.strength(4f)
                    .mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}