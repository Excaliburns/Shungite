package moe.krp.shungite.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.common.extensions.IForgeMobEffect;

public class Dexterous extends MobEffect implements IForgeMobEffect {

  public Dexterous(MobEffectCategory category, int color) {
    super(category, color);
  }

  @Override
  public int getColor() {
    return 12116457;
  }
}

