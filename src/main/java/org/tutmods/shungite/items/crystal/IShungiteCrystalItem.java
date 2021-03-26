package org.tutmods.shungite.items.crystal;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.stats.Stats;
import net.minecraftforge.common.extensions.IForgeItem;
import net.minecraftforge.common.util.Constants;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.items.crystal.stats.Stat;

import java.util.ArrayList;
import java.util.List;

import static org.tutmods.shungite.ShungiteConstants.*;
import static org.tutmods.shungite.util.ShungiteUtils.getShungiteData;

public interface IShungiteCrystalItem extends IForgeItem {

    default boolean getActive(final ItemStack stack) {
        return getShungiteData(stack).getBoolean(SHUNGITE_ACTIVE);
    }

    default void putActive(final ItemStack stack, final boolean active) { getShungiteData(stack).putBoolean(SHUNGITE_ACTIVE, active); }

    default void flipActive(final ItemStack stack) { getShungiteData(stack).putBoolean(SHUNGITE_ACTIVE, !getActive(stack)); }

    default int getMaxCrystalPower(final ItemStack stack) {
        return getShungiteData(stack).getInt(SHUNGITE_ENERGY_TAG);
    }

    default void putMaxCrystalPower(final ItemStack stack, final int maxPower) { getShungiteData(stack).putInt(SHUNGITE_ENERGY_TAG, maxPower); }

    default void putCurrentCrystalPower(final ItemStack stack, final int currentPower) { getShungiteData(stack).putInt(SHUNGITE_CURRENT_ENERGY_TAG, currentPower); }

    default int getCurrentCrystalPower(final ItemStack stack) { return getShungiteData(stack).getInt(SHUNGITE_CURRENT_ENERGY_TAG); }

    default List<Stat> getStats(final ItemStack stack) {
        final CompoundNBT stackTag = getShungiteData(stack);

        if (stackTag == null) { return new ArrayList<>(); }

        final ListNBT statList = stackTag.getList(SHUNGITE_STATS_TAG, Constants.NBT.TAG_COMPOUND);

        final List<Stat> stats = new ArrayList<>();
        for (int i = 0; i < statList.size(); i++) {
            final Stat stat = Stat.deserialize(statList.getCompound(i));

            if (stat != null) { stats.add(stat); }
        }

        return stats;
    }

    default void putStats(final ItemStack stack, final List<Stat> stats) {
        final ListNBT list = new ListNBT();

        for (Stat stat : stats) {
            list.add(Stat.serialize(stat));
        }

        getShungiteData(stack).put(SHUNGITE_STATS_TAG, list);
    }

}
