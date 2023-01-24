package moe.krp.shungite.setup;

import moe.krp.shungite.effects.Hydrated;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

  public static final RegistryObject<MobEffect> HYDRATED = Registration.EFFECT_DEFERRED_REGISTER.register(
      "hydrated",
      () -> new Hydrated(MobEffectCategory.BENEFICIAL, 2039587)
  );

  static void register() {}
}
