package org.tutmods.shungite.data.client;

import com.google.gson.JsonElement;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.data.DataGenerators;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(final DataGenerator generator, final ExistingFileHelper helper) {
        super(generator, ShungiteConstants.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("shungite_crystal", modLoc("block/shungite_crystal"));

        final ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        buildItem(itemGenerated, "shungite");
        buildItem(itemGenerated, "dowsing_rod");
    }

    private void buildItem(final ModelFile itemGenerated, final String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
