package org.tutmods.shungite.items.crystal;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import org.tutmods.shungite.items.crystal.stats.Stat;

import java.util.ArrayList;
import java.util.List;

import static org.tutmods.shungite.ShungiteConstants.*;
import static org.tutmods.shungite.util.ShungiteUtils.getTextComponent;

public class ShungiteCrystalStats {
    private Stat stat;
    private int level;

    public ShungiteCrystalStats(final Stat stat){
        this.stat = stat;
        this.level = 0; // Effects index from 0
    }

    public ShungiteCrystalStats(final Stat stat, final int level){
        this.stat = stat;
        this.level = level;
    }

    public static CompoundNBT serialize(final ShungiteCrystalStats crystalStats) {
        CompoundNBT tag = new CompoundNBT();

        CompoundNBT statTag = new CompoundNBT();
        statTag.putString(SHUNGITE_STAT_TAG, crystalStats.stat.getName());
        statTag.putInt(SHUNGITE_STAT_LEVEL_TAG, crystalStats.level);

        tag.put(SHUNGITE_CRYSTAL_STATS_TAG, statTag);

        return tag;
    }

    public static ShungiteCrystalStats deserialize(final CompoundNBT tag) {
        final CompoundNBT statTag = tag.getCompound(SHUNGITE_CRYSTAL_STATS_TAG);
        final Stat tagStat = Stat.getStat(statTag.getString(SHUNGITE_STAT_TAG));
        final int level = statTag.getInt(SHUNGITE_STAT_LEVEL_TAG);

        return new ShungiteCrystalStats(tagStat, level);
    }

    public static List<ITextComponent> listToString(final List<ShungiteCrystalStats> stats) {
        final List<ITextComponent> textComponents = new ArrayList<>();

        textComponents.add(
                getTextComponent("info.shungite.stats")
                .append(":")
                .withStyle(TextFormatting.BOLD)
                .withStyle(TextFormatting.UNDERLINE)
                .append(new StringTextComponent(""))
        );

        for (ShungiteCrystalStats s : stats) {
            final IFormattableTextComponent statComponent = new StringTextComponent(s.stat.getReadableName().getString());
            statComponent.withStyle(TextFormatting.RESET);
            statComponent.withStyle(s.stat.getColor());
            statComponent.append(" ").append(Integer.toString(s.level + 1));
            statComponent.append(" (").append(Integer.toString(s.stat.getPointValue() * (s.level + 1))).append(")");

            textComponents.add(statComponent);
        }

        return textComponents;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
