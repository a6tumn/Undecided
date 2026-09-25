package undecided.datagen.assets;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import undecided.Undecided;
import undecided.init.ModItems;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output) {
        super(output, Undecided.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(ModItems.GELIN_CORE, "Gelin Core");
        this.addItem(ModItems.MAGISTEEL_CLUSTER, "Magisteel Cluster");
        this.addItem(ModItems.WEAK_MAGISTEEL_INGOT, "Weak Magisteel Ingot");
        this.addItem(ModItems.REFINED_MAGISTEEL_INGOT, "Refined Magisteel Ingot");
    }
}
