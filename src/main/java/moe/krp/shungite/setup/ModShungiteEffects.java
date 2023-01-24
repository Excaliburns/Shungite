package moe.krp.shungite.setup;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.items.crystal.effects.ShungiteEffect;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.registries.RegistryObject;

public class ModShungiteEffects {
  public static final RegistryObject<ShungiteEffect> EFFECT_ABSORPTION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
      ShungiteConstants.SHUNGITE_ABSORPTION, () ->
      new ShungiteEffect(
          ShungiteConstants.SHUNGITE_ABSORPTION,
          MobEffects.ABSORPTION,
          10,
          5,
          ChatFormatting.GOLD
      )
  );

  static void register() {}
}
