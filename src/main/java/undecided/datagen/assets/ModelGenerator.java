package undecided.datagen.assets;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import undecided.Undecided;
import undecided.init.ModItemsTwo;

public class ModelGenerator extends ModelProvider {
    public ModelGenerator(PackOutput output) {
        super(output, Undecided.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItemsTwo.GELIN_CORE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsTwo.MAGISTEEL_CLUSTER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsTwo.WEAK_MAGISTEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsTwo.REFINED_MAGISTEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
    }
}