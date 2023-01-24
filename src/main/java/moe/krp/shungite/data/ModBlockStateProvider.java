package moe.krp.shungite.data;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(final DataGenerator gen, final ExistingFileHelper exFileHelper) {
        super(gen, ShungiteConstants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.SHUNGITE_CRYSTAL_ORE.get());
    }
}
