package org.tutmods.shungite.items.crystal.stats;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import org.tutmods.shungite.ShungiteConstants;

import java.util.HashMap;
import java.util.List;

public enum Stat {
    ABSORPTION (Effects.ABSORPTION, Effects.ABSORPTION.getDisplayName(), 5),
    SPEED (Effects.MOVEMENT_SPEED, Effects.MOVEMENT_SPEED.getDisplayName(), 2),
    DIG_SPEED (Effects.DIG_SPEED, Effects.MOVEMENT_SPEED.getDisplayName(), 1);

    private Effect effect;
    private ITextComponent name;
    private int pointValue;

    private static HashMap<String, Stat> mappings;

    Stat(final Effect effect, final ITextComponent name, final int pointValue) {
        this.effect = effect;
        this.name = name;
        this.pointValue = pointValue;

        getMappings().put(name.getString(), this);
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


    public static CompoundNBT serialize(final Stat stat) {
        CompoundNBT tag = new CompoundNBT();

        tag.putString(ShungiteConstants.SHUNGITE_STAT_TAG, stat.name.getString());

        return tag;
    }

    public static Stat deserialize(final CompoundNBT tag) {
        return mappings.get(tag.getString(ShungiteConstants.SHUNGITE_STAT_TAG));
    }

    public static String listToString(final List<Stat> stats) {
        final StringBuilder builder = new StringBuilder();
        for (Stat s : stats) {
            builder.append("Name: ").append(s.name.getString());
            builder.append("\n");
            builder.append("Points: ").append(s.pointValue);
            builder.append("\n");
        }

        return builder.toString();
    }
}
