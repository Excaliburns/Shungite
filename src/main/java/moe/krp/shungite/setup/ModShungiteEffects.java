package moe.krp.shungite.setup;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.items.crystal.effects.ShungiteEffect;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class ModShungiteEffects {
    public static final RegistryObject<ShungiteEffect> EFFECT_ABSORPTION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_ABSORPTION, () -> new ShungiteEffect(ShungiteConstants.SHUNGITE_ABSORPTION, MobEffects.ABSORPTION, 10, 5, ChatFormatting.GOLD)
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_REGENERATION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_REGENERATION, () -> new ShungiteEffect(ShungiteConstants.SHUNGITE_REGENERATION, MobEffects.REGENERATION, 25, 3, ChatFormatting.LIGHT_PURPLE)
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_RESISTANCE = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_DAMAGE_RESISTANCE, () -> new ShungiteEffect(ShungiteConstants.SHUNGITE_DAMAGE_RESISTANCE, MobEffects.DAMAGE_RESISTANCE, 10, 2, ChatFormatting.GRAY)
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_FIRE_RESIST = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_FIRE_RESISTANCE, () -> new ShungiteEffect(ShungiteConstants.SHUNGITE_FIRE_RESISTANCE, MobEffects.FIRE_RESISTANCE, 5, 1, ChatFormatting.RED)
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_WATER_BREATHING = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_WATER_BREATHING, () -> new ShungiteEffect(ShungiteConstants.SHUNGITE_WATER_BREATHING, MobEffects.WATER_BREATHING, 10, 1, ChatFormatting.AQUA)
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_JUMP = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_JUMP, () -> new ShungiteEffect(ShungiteConstants.SHUNGITE_JUMP, MobEffects.JUMP, 5, 2, ChatFormatting.GREEN)
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_SPEED = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_SPEED, () -> new ShungiteEffect(ShungiteConstants.SHUNGITE_SPEED, MobEffects.MOVEMENT_SPEED, 10, 3, ChatFormatting.BLUE)
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_HASTE = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_DIG_SPEED, () -> new ShungiteEffect(ShungiteConstants.SHUNGITE_DIG_SPEED, MobEffects.DIG_SPEED, 15, 2, ChatFormatting.GOLD)
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_DEXTEROUS = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_DEXTEROUS, () -> new ShungiteEffect(ShungiteConstants.SHUNGITE_DEXTEROUS, ModEffects.DEXTEROUS.get(), 10, 1, ChatFormatting.AQUA)
    );

    static void register() {
    }
}
