package org.tutmods.shungite.events;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.setup.ModEffects;

@Mod.EventBusSubscriber(modid = ShungiteConstants.MOD_ID)
public class BreakEvent {
    @SubscribeEvent
    public static void breakFaster( final PlayerEvent.BreakSpeed event ) {
        final PlayerEntity player = event.getPlayer();

        // duplicate aqua affinity logic
        // If they don't have aqua affinity but they do have the effect, give them a boost :)
        if (player.isEyeInFluid(FluidTags.WATER) && !EnchantmentHelper.hasAquaAffinity(player) && player.hasEffect(ModEffects.SHUNGITTE_FLUIDITY.get())) {
            float f1 = event.getOriginalSpeed();
            event.setNewSpeed(f1 * 5.0F);
        }
    }
}
