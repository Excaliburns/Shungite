package org.tutmods.shungite.items.crystal.stats;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import org.tutmods.shungite.ShungiteConstants;

import java.util.HashMap;
import java.util.List;

public enum Stat {
    ABSORPTION (Effects.ABSORPTION, ShungiteConstants.SHUNGITE_ABSORPTION, 5, TextFormatting.GOLD),
    SPEED (Effects.MOVEMENT_SPEED, ShungiteConstants.SHUNGITE_SPEED, 2, TextFormatting.AQUA),
    DIG_SPEED (Effects.DIG_SPEED, ShungiteConstants.SHUNGITE_DIG_SPEED, 1, TextFormatting.WHITE);

    private Effect effect;
    private String name;
    private int pointValue;
    private TextFormatting color;

    private static HashMap<String, Stat> mappings;

    Stat(final Effect effect, final String name, final int pointValue, final TextFormatting color) {
        this.effect = effect;
        this.name = name;
        this.pointValue = pointValue;
        this.color = color;

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
}
