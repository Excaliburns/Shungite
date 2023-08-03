package moe.krp.shungite.setup;

import moe.krp.shungite.effects.Dexterous;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

  public static final RegistryObject<MobEffect> DEXTEROUS = Registration.EFFECT_DEFERRED_REGISTER.register(
      "dexterous",
      () -> new Dexterous(MobEffectCategory.BENEFICIAL, 2039587)
  );

  static void register() {}
}
