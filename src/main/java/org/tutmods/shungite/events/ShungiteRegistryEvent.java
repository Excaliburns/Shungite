package org.tutmods.shungite.events;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryBuilder;
import org.tutmods.shungite.Shungite;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.items.crystal.effects.ShungiteEffect;

@Mod.EventBusSubscriber(modid = ShungiteConstants.MOD_ID)
public class ShungiteRegistryEvent {
    @SubscribeEvent
    public static void createCustomRegistries(final RegistryEvent.NewRegistry event) {
        Shungite.LOGGER.info("Adding Shungite Effect Registry");
        //dark magic
        new RegistryBuilder<ShungiteEffect>()
                .allowModification()
                .create();
    }
}
