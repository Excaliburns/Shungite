package moe.krp.shungite.items.crystal.effects;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.exceptions.ShungiteEffectNotFoundException;
import moe.krp.shungite.setup.Registration;
import moe.krp.shungite.util.ShungiteUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShungiteCrystalEffect {

    private final ShungiteEffect crystalEffect;
    private final int level;

    public ShungiteCrystalEffect(final ShungiteEffect crystalEffect) {
        this.crystalEffect = crystalEffect;
        this.level = 0; // Effects index from 0
    }

    public ShungiteCrystalEffect(final ShungiteEffect crystalEffect, final int level) {
        this.crystalEffect = crystalEffect;
        this.level = level;
    }

    public int getPointValue() {
        return this.level + 1 + crystalEffect.getPointValue();
    }

    public static CompoundTag serialize(final ShungiteCrystalEffect crystalStats) {
        CompoundTag tag = new CompoundTag();

        CompoundTag statTag = new CompoundTag();
        statTag.putString(ShungiteConstants.SHUNGITE_STAT_TAG, crystalStats.getCrystalEffect().getName());
        statTag.putInt(ShungiteConstants.SHUNGITE_STAT_LEVEL_TAG, crystalStats.level);

        tag.put(ShungiteConstants.SHUNGITE_CRYSTAL_STATS_TAG, statTag);

        return tag;
    }

    public static ShungiteCrystalEffect deserialize(final CompoundTag tag) {
        final CompoundTag statTag = tag.getCompound(ShungiteConstants.SHUNGITE_CRYSTAL_STATS_TAG);
        final String tagString = statTag.getString(ShungiteConstants.SHUNGITE_STAT_TAG);
        final ShungiteEffect tagStat = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER
                .getEntries()
                .stream()
                .filter(any -> Objects.equals(any.get().getName(), tagString))
                .findFirst()
                .orElseThrow(() -> new ShungiteEffectNotFoundException("Invalid ShungiteEffect deserialized from NBT."))
                .get();
        final int level = statTag.getInt(ShungiteConstants.SHUNGITE_STAT_LEVEL_TAG);

        return new ShungiteCrystalEffect(tagStat, level);
    }

    public static List<MutableComponent> listToString(final List<ShungiteCrystalEffect> stats) {
        final List<MutableComponent> textComponents = new ArrayList<>();

        textComponents.add(ShungiteUtils.getTextComponent("info.shungite.stats").append(":").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.UNDERLINE));

        for (ShungiteCrystalEffect s : stats) {
            final MutableComponent statComponent = Component.literal(s.getCrystalEffect().getMobEffect().getDisplayName().getString());
            statComponent.withStyle(ChatFormatting.RESET);
            statComponent.withStyle(s.crystalEffect.getColor());
            statComponent.append(" ").append(Integer.toString(s.level + 1)).append(" ");
            statComponent.append("(").append(Integer.toString(s.crystalEffect.getPointValue() * (s.level + 1))).append(")");

            textComponents.add(statComponent);
        }

        return textComponents;
    }

    public ShungiteEffect getCrystalEffect() {
        return crystalEffect;
    }

    public int getLevel() {
        return level;
    }
}
