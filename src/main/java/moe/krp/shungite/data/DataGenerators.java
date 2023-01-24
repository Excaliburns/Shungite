package moe.krp.shungite.data;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.data.client.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ShungiteConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        final DataGenerator generators = event.getGenerator();
        final ExistingFileHelper helper = event.getExistingFileHelper();

        generators.addProvider(event.includeClient(), new ModBlockStateProvider(generators, helper));
        generators.addProvider(event.includeClient(), new ModItemModelProvider(generators, helper));
        generators.addProvider(event.includeClient(), new ModLootTableProvider(generators));
    }
}
