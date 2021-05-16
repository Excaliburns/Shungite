package org.tutmods.shungite.effects;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.common.extensions.IForgeEffect;

public class Hydrated extends Effect implements IForgeEffect{

    public Hydrated(EffectType p_i50391_1_, int p_i50391_2_) {
        super(p_i50391_1_, p_i50391_2_);
    }

    @Override
    public int getColor() {
        return 12116457;
    }
}
