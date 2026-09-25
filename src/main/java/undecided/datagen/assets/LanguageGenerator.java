package undecided.datagen.assets;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import undecided.Undecided;
import undecided.init.ModItemsTwo;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output) {
        super(output, Undecided.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(ModItemsTwo.GELIN_CORE, "Gelin Core");
        this.addItem(ModItemsTwo.MAGISTEEL_CLUSTER, "Magisteel Cluster");
        this.addItem(ModItemsTwo.WEAK_MAGISTEEL_INGOT, "Weak Magisteel Ingot");
        this.addItem(ModItemsTwo.REFINED_MAGISTEEL_INGOT, "Refined Magisteel Ingot");
    }
}
