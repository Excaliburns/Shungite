package moe.krp.shungite.data.client;

import moe.krp.shungite.ShungiteConstants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(final DataGenerator generator, final ExistingFileHelper helper) {
        super(generator, ShungiteConstants.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("shungite_crystal_ore", modLoc("block/shungite_crystal_ore"));

        final ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        buildItem(itemGenerated, "shungite");
        buildItem(itemGenerated, "dowsing_rod");
    }

    private void buildItem(final ModelFile itemGenerated, final String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
