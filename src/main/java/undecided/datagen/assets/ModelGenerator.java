package undecided.datagen.assets;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import undecided.Undecided;
import undecided.client.model.property.RefinedModelProperty;
import undecided.init.ModItems;

public class ModelGenerator extends ModelProvider {
    public ModelGenerator(PackOutput output) {
        super(output, Undecided.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.GELIN_CORE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.MAGISTEEL_CLUSTER.get(), ModelTemplates.FLAT_ITEM);
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(ModItems.MAGISTEEL_INGOT.get()), TextureMapping.layer0(ModItems.MAGISTEEL_INGOT.get()), itemModels.modelOutput);
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(ModItems.MAGISTEEL_INGOT.get(), "_refined"), TextureMapping.layer0(new Material(Undecided.id("item/magisteel_ingot_refined"))), itemModels.modelOutput);
        itemModels.itemModelOutput.accept(
            ModItems.MAGISTEEL_INGOT.get(),
            ItemModelUtils.conditional(
                new RefinedModelProperty(),
                ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(ModItems.MAGISTEEL_INGOT.get(), "_refined")),
                ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(ModItems.MAGISTEEL_INGOT.get()))
            )
        );
    }
}