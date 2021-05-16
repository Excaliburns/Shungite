package org.tutmods.shungite.setup;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import org.tutmods.shungite.effects.FiveGAura;
import org.tutmods.shungite.effects.Hydrated;

public class ModEffects {
    public static final RegistryObject<Effect> HYDRATED = Registration.EFFECT_DEFERRED_REGISTER.register("hydrated",
            () -> new Hydrated(EffectType.BENEFICIAL, 2039587));

    public static final RegistryObject<Effect> FIVE_G_AURA = Registration.EFFECT_DEFERRED_REGISTER.register( "5g_aura",
            () -> new FiveGAura(EffectType.BENEFICIAL, 2039587));
    
    static void register() {}
}
