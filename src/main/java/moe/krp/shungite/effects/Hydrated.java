package moe.krp.shungite.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.common.extensions.IForgeMobEffect;

public class Hydrated extends MobEffect implements IForgeMobEffect {

  public Hydrated(MobEffectCategory p_19451_, int p_19452_) {
    super(p_19451_, p_19452_);
  }

  @Override
  public int getColor() {
    return 12116457;
  }
}

