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
                    10,
                    5,
                    TextFormatting.GOLD
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_REGENERATION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_REGENERATION, () ->
            new ShungiteEffect(
                    Effects.REGENERATION,
                    ShungiteConstants.SHUNGITE_REGENERATION,
                    10,
                    5,
                    TextFormatting.RED
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_DAMAGE_RESISTANCE = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_DAMAGE_RESISTANCE, () ->
            new ShungiteEffect(
                    Effects.DAMAGE_RESISTANCE,
                    ShungiteConstants.SHUNGITE_DAMAGE_RESISTANCE,
                    15,
                    3,
                    TextFormatting.DARK_AQUA
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_FIRE_RESISTANCE = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_FIRE_RESISTANCE, () ->
            new ShungiteEffect(
                    Effects.FIRE_RESISTANCE,
                    ShungiteConstants.SHUNGITE_FIRE_RESISTANCE,
                    10,
                    1,
                    TextFormatting.DARK_RED
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_WATER_BREATHING = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_WATER_BREATHING, () ->
            new ShungiteEffect(
                    Effects.WATER_BREATHING,
                    ShungiteConstants.SHUNGITE_WATER_BREATHING,
                    8,
                    1,
                    TextFormatting.AQUA
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_JUMP = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_JUMP, () ->
            new ShungiteEffect(
                    Effects.JUMP,
                    ShungiteConstants.SHUNGITE_JUMP,
                    8,
                    5,
                    TextFormatting.GREEN
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_SPEED = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_SPEED, () ->
            new ShungiteEffect(
                    Effects.MOVEMENT_SPEED,
                    ShungiteConstants.SHUNGITE_SPEED,
                    10,
                    4,
                    TextFormatting.AQUA
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_DIG_SPEED = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_DIG_SPEED, () ->
            new ShungiteEffect(
                    Effects.DIG_SPEED,
                    ShungiteConstants.SHUNGITE_DIG_SPEED,
                    15,
                    3,
                    TextFormatting.YELLOW
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_AQUA_AFFINITY = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_HYDRATED, () ->
            new CustomShungiteEffect(
                    ModEffects.HYDRATED.get(),
                    ShungiteConstants.SHUNGITE_HYDRATED,
                    15,
                    1,
                    TextFormatting.AQUA,
                    ModEffects.HYDRATED.get().getDisplayName().getString()
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_5G_AURA = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(ShungiteConstants.SHUNGITE_5G_AURA, () ->
            new CustomShungiteEffect(
                    ModEffects.FIVE_G_AURA.get(),
                    ShungiteConstants.SHUNGITE_5G_AURA,
                    4,
                    10,
                    TextFormatting.DARK_RED,
                    ModEffects.HYDRATED.get().getDisplayName().getString()
            )
    );

    static void register() {}
}
