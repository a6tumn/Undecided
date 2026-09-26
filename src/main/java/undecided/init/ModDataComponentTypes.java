package undecided.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredRegister;
import undecided.Undecided;
import undecided.component.MagisteelIngotTooltipComponent;

import java.util.function.Supplier;

public final class ModDataComponentTypes {
    public static final DeferredRegister.DataComponents DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Undecided.MODID);

    public static final Supplier<DataComponentType<Boolean>> MAGISTEEL_REFINED = DATA_COMPONENT_TYPES.registerComponentType("magisteel_refined", b -> b.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding());
    public static final Supplier<DataComponentType<MagisteelIngotTooltipComponent>> MAGISTEEL_INGOT_TOOLTIP = DATA_COMPONENT_TYPES.registerComponentType("magisteel_ingot_tooltip", b -> b.persistent(MapCodec.unitCodec(MagisteelIngotTooltipComponent.INSTANCE)).networkSynchronized(StreamCodec.unit(MagisteelIngotTooltipComponent.INSTANCE)).cacheEncoding());
}