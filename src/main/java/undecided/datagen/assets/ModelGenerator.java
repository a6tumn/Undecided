package undecided.datagen.assets;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import undecided.Undecided;
import undecided.client.model.property.RefinedModelProperty;
import undecided.init.ModBlocks;
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

        itemModels.itemModelOutput.accept(ModBlocks.CHISELED_HYDROLITH_BRICKS.asItem(), ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(ModBlocks.CHISELED_HYDROLITH_BRICKS.get())));
        itemModels.itemModelOutput.accept(ModBlocks.HYDROLITH_BRICKS.asItem(), ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(ModBlocks.HYDROLITH_BRICKS.get(), "0")));
        itemModels.itemModelOutput.accept(ModBlocks.HYDROLITH_MOSAIC.asItem(), ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(ModBlocks.HYDROLITH_MOSAIC.get(), "0")));
        blockModels.createTrivialCube(ModBlocks.CHISELED_HYDROLITH_BRICKS.get());
        weightedBlock(blockModels, ModBlocks.HYDROLITH_BRICKS.get(), 1, 1, 1, 1);
        weightedBlock(blockModels, ModBlocks.HYDROLITH_MOSAIC.get(), 6, 2, 2, 2, 2, 1);

    }

    private void weightedBlock(BlockModelGenerators blockModels, Block block, int... weights) {
        for (int i = 0; i < weights.length; i++) {
            ModelTemplates.CUBE_ALL.create(
                    ModelLocationUtils.getModelLocation(block, String.valueOf(i)),
                    TextureMapping.cube(new Material(Undecided.id("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + i))),
                    blockModels.modelOutput
            );
        }

        WeightedList.Builder<Variant> variants = WeightedList.builder();
        for (int i = 0; i < weights.length; i++) {
            variants.add(new Variant(ModelLocationUtils.getModelLocation(block, String.valueOf(i))), weights[i]);
        }

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, new MultiVariant(variants.build())));
    }
}