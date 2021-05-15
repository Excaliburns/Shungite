package org.tutmods.shungite.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.setup.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(final DataGenerator gen, final ExistingFileHelper exFileHelper) {
        super(gen, ShungiteConstants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.SHUNGITE_CRYSTAL_ORE.get());
    }
}
