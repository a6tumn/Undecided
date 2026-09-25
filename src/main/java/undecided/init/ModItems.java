package undecided.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import undecided.Undecided;
import undecided.item.WeakMagisteelIngotItem;

import java.util.function.Function;
import java.util.function.Supplier;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Undecided.MODID);

    public static final DeferredItem<Item> GELIN_CORE = register("gelin_core", Item::new, Item.Properties::new);
    public static final DeferredItem<Item> MAGISTEEL_CLUSTER = register("magisteel_cluster", Item::new, () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> WEAK_MAGISTEEL_INGOT = register("weak_magisteel_ingot", WeakMagisteelIngotItem::new, () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> REFINED_MAGISTEEL_INGOT = register("refined_magisteel_ingot", Item::new, () -> new Item.Properties().fireResistant());

    public static <T extends Item> DeferredItem<T> register(String name, Function<Item.Properties, T> item, Supplier<Item.Properties> properties) {
        return ITEMS.register(name, () -> item.apply(properties.get().setId(ResourceKey.create(Registries.ITEM, Undecided.id(name)))));
    }
}