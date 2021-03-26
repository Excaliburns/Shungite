package org.tutmods.shungite.items.crystal.stats;

import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.setup.ModEffects;

import java.util.HashMap;

/**
 * Stats are currently hardcoded into the mod and then retrieved through the map below.
 * Ideally we'd want to have some ForgeRegistry where you can register new effects and do it that way?
 * Something like that I guess.
 */
public enum Stat {
    ABSORPTION         (Effects.ABSORPTION,                  ShungiteConstants.SHUNGITE_ABSORPTION,    5, TextFormatting.GOLD,      Effects.ABSORPTION.getDisplayName()),
    REGENERATION       (Effects.REGENERATION,                ShungiteConstants.REGENERATION,           3, TextFormatting.RED,       Effects.REGENERATION.getDisplayName()),
    DAMAGE_RESISTANCE  (Effects.DAMAGE_RESISTANCE,           ShungiteConstants.DAMAGE_RESISTANCE,      4, TextFormatting.DARK_AQUA, Effects.DAMAGE_RESISTANCE.getDisplayName()),
    FIRE_RESISTANCE    (Effects.FIRE_RESISTANCE,             ShungiteConstants.FIRE_RESISTANCE,       10, TextFormatting.DARK_AQUA, Effects.FIRE_RESISTANCE.getDisplayName()),
    WATER_BREATHING    (Effects.WATER_BREATHING,             ShungiteConstants.WATER_BREATHING,        8, TextFormatting.DARK_AQUA, Effects.WATER_BREATHING.getDisplayName()),
    JUMP               (Effects.JUMP,                        ShungiteConstants.JUMP,                   8, TextFormatting.GREEN,     Effects.JUMP.getDisplayName()),
    SPEED              (Effects.MOVEMENT_SPEED,              ShungiteConstants.SHUNGITE_SPEED,         2, TextFormatting.AQUA,      Effects.MOVEMENT_SPEED.getDisplayName()),
    DIG_SPEED          (Effects.DIG_SPEED,                   ShungiteConstants.SHUNGITE_DIG_SPEED,     1, TextFormatting.WHITE,     Effects.DIG_SPEED.getDisplayName()),
    AQUA_AFFINITY      (ModEffects.SHUNGITTE_FLUIDITY.get(), ShungiteConstants.SHUNGITE_AQUA_AFFINITY, 1, TextFormatting.AQUA,      new TranslationTextComponent(ShungiteConstants.SHUNGITE_AQUA_AFFINITY_NAME));

    private Effect effect;
    private String name;
    private int pointValue;
    private TextFormatting color;
    private ITextComponent readableName;

    private static HashMap<String, Stat> mappings;

    Stat(final Effect effect, final String name, final int pointValue, final TextFormatting color, final ITextComponent readableName) {
        this.effect = effect;
        this.name = name;
        this.pointValue = pointValue;
        this.color = color;
        this.readableName = readableName;

        getMappings().put(name, this);
    }

    private static HashMap<String, Stat> getMappings() {
        if (mappings == null) {
            synchronized (Stat.class) {
                if (mappings == null) {
                    mappings = new HashMap<>();
                }
            }
        }
        return mappings;
    }

    public static Stat getStat(final String statString) {
        return mappings.get(statString);
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public TextFormatting getColor() {
        return color;
    }

    public void setColor(TextFormatting color) {
        this.color = color;
    }

    public ITextComponent getReadableName() {
        return readableName;
    }

    public void setReadableName(ITextComponent readableName) {
        this.readableName = readableName;
    }
}
