package org.tutmods.shungite.setup;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import org.tutmods.shungite.effects.Fluidity;

public class ModEffects {
    public static final RegistryObject<Effect> SHUNGITTE_FLUIDITY = Registration.EFFECT_DEFERRED_REGISTER.register("shungite_fluidity",
            () -> new Fluidity(EffectType.BENEFICIAL, 2039587));
    
    static void register() {}
}
