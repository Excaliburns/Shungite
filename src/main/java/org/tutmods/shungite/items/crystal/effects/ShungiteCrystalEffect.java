package org.tutmods.shungite.items.crystal.effects;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.tutmods.shungite.ShungiteConstants.*;
import static org.tutmods.shungite.util.ShungiteUtils.getTextComponent;

@Getter @Setter
public class ShungiteCrystalEffect {
    private ShungiteEffect crystalEffect;
    private int level;

    public ShungiteCrystalEffect(final ShungiteEffect crystalEffect){
        this.crystalEffect = crystalEffect;
        this.level = 0; // Effects index from 0
    }

    public ShungiteCrystalEffect(final ShungiteEffect crystalEffect, final int level){
        this.crystalEffect = crystalEffect;
        this.level = level;
    }

    public int getPointValue() {
        return this.level + 1 + crystalEffect.getPointValue();
    }

    public static CompoundNBT serialize(final ShungiteCrystalEffect crystalStats) {
        CompoundNBT tag = new CompoundNBT();

        CompoundNBT statTag = new CompoundNBT();
        statTag.putString(SHUNGITE_STAT_TAG, crystalStats.getCrystalEffect().getName());
        statTag.putInt(SHUNGITE_STAT_LEVEL_TAG, crystalStats.level);

        tag.put(SHUNGITE_CRYSTAL_STATS_TAG, statTag);

        return tag;
    }

    public static ShungiteCrystalEffect deserialize(final CompoundNBT tag) {
        final CompoundNBT statTag = tag.getCompound(SHUNGITE_CRYSTAL_STATS_TAG);
        final ShungiteEffect tagStat = GameRegistry.findRegistry(ShungiteEffect.class).getValue(new ResourceLocation(MOD_ID, statTag.getString(SHUNGITE_STAT_TAG)));
        final int level = statTag.getInt(SHUNGITE_STAT_LEVEL_TAG);

        return new ShungiteCrystalEffect(tagStat, level);
    }

    public static List<ITextComponent> listToString(final List<ShungiteCrystalEffect> stats) {
        final List<ITextComponent> textComponents = new ArrayList<>();

        textComponents.add(
                getTextComponent("info.shungite.stats")
                .append(":")
                .withStyle(TextFormatting.BOLD)
                .withStyle(TextFormatting.UNDERLINE)
                .append(new StringTextComponent(""))
        );

        for (ShungiteCrystalEffect s : stats) {
            final IFormattableTextComponent statComponent = new StringTextComponent(s.getCrystalEffect().getMinecraftEffect().getDisplayName().getString());
            statComponent.withStyle(TextFormatting.RESET);
            statComponent.withStyle(s.crystalEffect.getColor());
            statComponent.append(" ").append(Integer.toString(s.level + 1));
            statComponent.append(" (").append(Integer.toString(s.crystalEffect.getPointValue() * (s.level + 1))).append(")");

            textComponents.add(statComponent);
        }

        return textComponents;
    }
}
