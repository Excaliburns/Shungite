package org.tutmods.shungite.setup;

import net.minecraft.potion.Effects;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.items.crystal.effects.ShungiteEffect;

public class ModShungiteEffects {
    public static final RegistryObject<ShungiteEffect> EFFECT_ABSORPTION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register("shungite_absorption", () ->
            new ShungiteEffect(
                    Effects.ABSORPTION,
                    ShungiteConstants.SHUNGITE_ABSORPTION,
                    5,
                    TextFormatting.GOLD,
                    Effects.ABSORPTION.getDisplayName()
            )
    );

    static void register() {}
}
