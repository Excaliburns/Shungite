package moe.krp.shungite.events;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.setup.ModEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ShungiteConstants.MOD_ID)
public class BreakEvent {

  @SubscribeEvent
  public static void breakFaster(final PlayerEvent.BreakSpeed event) {
    final Player player = event.getEntity();

    // duplicate aqua affinity logic
    // If they don't have aqua affinity but they do have the effect, give them a boost :)
    if (
            player.isInFluidType()
            && !EnchantmentHelper.hasAquaAffinity(player)
            && player.hasEffect(ModEffects.HYDRATED.get())
    ) {
      float f1 = event.getOriginalSpeed();
      event.setNewSpeed(f1 * 5.0F);
    }
  }
}
