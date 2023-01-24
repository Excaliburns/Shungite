package moe.krp.shungite.data;

import moe.krp.shungite.ShungiteConstants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(final DataGenerator generator, final ExistingFileHelper existingFileHelper) {
        super(generator, ShungiteConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        // Add tags
    }
}
