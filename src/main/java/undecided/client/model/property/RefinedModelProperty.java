package undecided.client.model.property;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;
import undecided.init.ModDataComponentTypes;

public record RefinedModelProperty() implements ConditionalItemModelProperty {
    public static final MapCodec<RefinedModelProperty> MAP_CODEC = MapCodec.unit(RefinedModelProperty::new);

    @Override
    public MapCodec<? extends ConditionalItemModelProperty> type() {
        return MAP_CODEC;
    }

    @Override
    public boolean get(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i, ItemDisplayContext itemDisplayContext) {
        return itemStack.getOrDefault(ModDataComponentTypes.MAGISTEEL_REFINED.get(), false);
    }
}
