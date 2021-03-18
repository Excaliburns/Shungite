package org.tutmods.shungite.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.data.client.ModBlockStateProvider;
import org.tutmods.shungite.data.client.ModItemModelProvider;

@Mod.EventBusSubscriber(modid = ShungiteConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        final DataGenerator generators = event.getGenerator();
        final ExistingFileHelper helper = event.getExistingFileHelper();

        generators.addProvider(new ModBlockStateProvider(generators, helper));
        generators.addProvider(new ModItemModelProvider(generators, helper));
    }
}
