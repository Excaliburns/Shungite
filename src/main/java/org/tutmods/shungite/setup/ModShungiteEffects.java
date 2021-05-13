package org.tutmods.shungite.setup;

import net.minecraft.potion.Effects;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.items.crystal.effects.CustomShungiteEffect;
import org.tutmods.shungite.items.crystal.effects.ShungiteEffect;

public class ModShungiteEffects {
    public static final RegistryObject<ShungiteEffect> EFFECT_ABSORPTION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_ABSORPTION, () ->
            new ShungiteEffect(
                    Effects.ABSORPTION,
                    ShungiteConstants.SHUNGITE_ABSORPTION,
                    5,
                    TextFormatting.GOLD
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_REGENERATION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_REGENERATION, () ->
            new ShungiteEffect(
                    Effects.REGENERATION,
                    ShungiteConstants.SHUNGITE_ABSORPTION,
                    3,
                    TextFormatting.RED
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_DAMAGE_RESISTANCE = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_DAMAGE_RESISTANCE, () ->
            new ShungiteEffect(
                    Effects.DAMAGE_RESISTANCE,
                    ShungiteConstants.SHUNGITE_DAMAGE_RESISTANCE,
                    4,
                    TextFormatting.DARK_AQUA
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_FIRE_RESISTANCE = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_FIRE_RESISTANCE, () ->
            new ShungiteEffect(
                    Effects.FIRE_RESISTANCE,
                    ShungiteConstants.SHUNGITE_FIRE_RESISTANCE,
                    10,
                    TextFormatting.DARK_AQUA
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_WATER_BREATHING = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_WATER_BREATHING, () ->
            new ShungiteEffect(
                    Effects.WATER_BREATHING,
                    ShungiteConstants.SHUNGITE_WATER_BREATHING,
                    8,
                    TextFormatting.AQUA
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_JUMP = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_JUMP, () ->
            new ShungiteEffect(
                    Effects.JUMP,
                    ShungiteConstants.SHUNGITE_JUMP,
                    8,
                    TextFormatting.GREEN
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_SPEED = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_SPEED, () ->
            new ShungiteEffect(
                    Effects.MOVEMENT_SPEED,
                    ShungiteConstants.SHUNGITE_SPEED,
                    2,
                    TextFormatting.GREEN
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_DIG_SPEED = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_DIG_SPEED, () ->
            new ShungiteEffect(
                    Effects.DIG_SPEED,
                    ShungiteConstants.SHUNGITE_DIG_SPEED,
                    1,
                    TextFormatting.WHITE
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_AQUA_AFFINITY = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_AQUA_AFFINITY, () ->
            new CustomShungiteEffect(
                    ModEffects.SHUNGITE_FLUIDITY.get(),
                    ShungiteConstants.SHUNGITE_AQUA_AFFINITY,
                    1,
                    TextFormatting.AQUA,
                    ModEffects.SHUNGITE_FLUIDITY.get().getDisplayName().getString()
            )
    );

    static void register() {}
}
