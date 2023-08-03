package moe.krp.shungite.setup;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.items.crystal.effects.ShungiteEffect;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class ModShungiteEffects {
    public static final RegistryObject<ShungiteEffect> EFFECT_ABSORPTION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_ABSORPTION, () -> new ShungiteEffect(
                    MobEffects.ABSORPTION.getDisplayName().getString(),
                    MobEffects.ABSORPTION,
                    10,
                    5,
                    ChatFormatting.GOLD,
                    ShungiteEffect.ShungiteEffectType.POSITIVE_PLUS
            )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_REGENERATION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_REGENERATION, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_REGENERATION,
                    MobEffects.REGENERATION,
                    20,
                    3,
                    ChatFormatting.LIGHT_PURPLE,
                    ShungiteEffect.ShungiteEffectType.POSITIVE
            )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_RESISTANCE = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_DAMAGE_RESISTANCE, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_DAMAGE_RESISTANCE,
                    MobEffects.DAMAGE_RESISTANCE,
                    10,
                    2,
                    ChatFormatting.WHITE,
                    ShungiteEffect.ShungiteEffectType.NEUTRAL
            )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_FIRE_RESIST = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_FIRE_RESISTANCE, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_FIRE_RESISTANCE,
                    MobEffects.FIRE_RESISTANCE,
                    15,
                    1,
                    ChatFormatting.RED,
                    ShungiteEffect.ShungiteEffectType.POSITIVE
            )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_WATER_BREATHING = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_WATER_BREATHING, () ->
                    new ShungiteEffect(
                            ShungiteConstants.SHUNGITE_WATER_BREATHING,
                            MobEffects.WATER_BREATHING,
                            15,
                            1,
                            ChatFormatting.AQUA,
                            ShungiteEffect.ShungiteEffectType.POSITIVE
                    )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_JUMP = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_JUMP, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_JUMP,
                    MobEffects.JUMP,
                    5,
                    3,
                    ChatFormatting.GREEN,
                    ShungiteEffect.ShungiteEffectType.NEUTRAL
            )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_SPEED = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_SPEED, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_SPEED,
                    MobEffects.MOVEMENT_SPEED,
                    10,
                    3,
                    ChatFormatting.BLUE,
                    ShungiteEffect.ShungiteEffectType.POSITIVE
            )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_HASTE = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_DIG_SPEED, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_DIG_SPEED,
                    MobEffects.DIG_SPEED,
                    25,
                    2,
                    ChatFormatting.GOLD,
                    ShungiteEffect.ShungiteEffectType.POSITIVE
            )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_DEXTEROUS = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_DEXTEROUS, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_DEXTEROUS,
                    ModEffects.DEXTEROUS.get(),
                    15,
                    1,
                    ChatFormatting.AQUA,
                    ShungiteEffect.ShungiteEffectType.POSITIVE
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_SLOWNESS = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_SLOWNESS, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_SLOWNESS,
                    MobEffects.MOVEMENT_SLOWDOWN,
                    2,
                    5,
                    ChatFormatting.GRAY,
                    ShungiteEffect.ShungiteEffectType.NEGATIVE
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_MINING_FATIGUE = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_MINING_FATIGUE, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_MINING_FATIGUE,
                    MobEffects.DIG_SLOWDOWN,
                    2,
                    5,
                    ChatFormatting.GRAY,
                    ShungiteEffect.ShungiteEffectType.NEGATIVE
            )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_STRENGTH = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_STRENGTH, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_STRENGTH,
                    MobEffects.DAMAGE_BOOST,
                    20,
                    3,
                    ChatFormatting.GRAY,
                    ShungiteEffect.ShungiteEffectType.POSITIVE_PLUS
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_NAUSEA = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_NAUSEA, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_NAUSEA,
                    MobEffects.CONFUSION,
                    1,
                    1,
                    ChatFormatting.GRAY,
                    ShungiteEffect.ShungiteEffectType.NEGATIVE_PLUS
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_INVISIBILITY = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_INVISIBILITY, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_INVISIBILITY,
                    MobEffects.INVISIBILITY,
                    20,
                    1,
                    ChatFormatting.GRAY,
                    ShungiteEffect.ShungiteEffectType.POSITIVE_PLUS
            )
    );
    public static final RegistryObject<ShungiteEffect> EFFECT_BLINDNESS = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_BLINDNESS, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_BLINDNESS,
                    MobEffects.BLINDNESS,
                    1,
                    1,
                    ChatFormatting.GRAY,
                    ShungiteEffect.ShungiteEffectType.NEGATIVE_PLUS
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_NIGHT_VISION = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_NIGHT_VISION, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_NIGHT_VISION,
                    MobEffects.NIGHT_VISION,
                    15,
                    1,
                    ChatFormatting.GRAY,
                    ShungiteEffect.ShungiteEffectType.POSITIVE
            )
    );

    public static final RegistryObject<ShungiteEffect> EFFECT_HUNGER = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.register(
            ShungiteConstants.SHUNGITE_HUNGER, () -> new ShungiteEffect(
                    ShungiteConstants.SHUNGITE_HUNGER,
                    MobEffects.HUNGER,
                    5,
                    2,
                    ChatFormatting.RED,
                    ShungiteEffect.ShungiteEffectType.NEGATIVE
            )
    );
    static void register() {
    }
}
