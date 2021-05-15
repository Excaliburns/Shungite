package org.tutmods.shungite.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.data.DataGenerators;
import org.tutmods.shungite.setup.ModTags;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(final DataGenerator generator, final ExistingFileHelper existingFileHelper) {
        super(generator, ShungiteConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        // Add tags
    }
}
