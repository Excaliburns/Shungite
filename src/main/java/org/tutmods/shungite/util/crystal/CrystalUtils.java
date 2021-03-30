package org.tutmods.shungite.util.crystal;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;
import org.tutmods.shungite.items.crystal.effects.ShungiteCrystalEffects;
import org.tutmods.shungite.items.crystal.effects.ShungiteEffect;
import org.tutmods.shungite.setup.ModItems;

import java.util.ArrayList;
import java.util.List;

import static org.tutmods.shungite.ShungiteConstants.*;
import static org.tutmods.shungite.ShungiteConstants.SHUNGITE_STATS_TAG;
import static org.tutmods.shungite.util.ShungiteUtils.getShungiteData;

public class CrystalUtils {
    public static boolean getActive(final ItemStack stack) {
        return getShungiteData(stack).getBoolean(SHUNGITE_ACTIVE);
    }

    public static void putActive(final ItemStack stack, final boolean active) { getShungiteData(stack).putBoolean(SHUNGITE_ACTIVE, active); }

    public static void flipActive(final ItemStack stack) { getShungiteData(stack).putBoolean(SHUNGITE_ACTIVE, !getActive(stack)); }

    public static int getMaxCrystalPower(final ItemStack stack) {
        return getShungiteData(stack).getInt(SHUNGITE_ENERGY_TAG);
    }

    public static void putMaxCrystalPower(final ItemStack stack, final int maxPower) { getShungiteData(stack).putInt(SHUNGITE_ENERGY_TAG, maxPower); }

    public static void putCurrentCrystalPower(final ItemStack stack, final int currentPower) { getShungiteData(stack).putInt(SHUNGITE_CURRENT_ENERGY_TAG, currentPower); }

    public static int getCurrentCrystalPower(final ItemStack stack) { return getShungiteData(stack).getInt(SHUNGITE_CURRENT_ENERGY_TAG); }

    public static List<ShungiteCrystalEffects> getStats(final ItemStack stack) {
        final CompoundNBT stackTag = getShungiteData(stack);

        if (stackTag == null) { return new ArrayList<>(); }

        final ListNBT statList = stackTag.getList(SHUNGITE_STATS_TAG, Constants.NBT.TAG_COMPOUND);

        final List<ShungiteCrystalEffects> stats = new ArrayList<>();
        for (int i = 0; i < statList.size(); i++) {
            final ShungiteCrystalEffects stat = ShungiteCrystalEffects.deserialize(statList.getCompound(i));

            stats.add(stat);
        }

        return stats;
    }

    public static void putCompletedStats(final ItemStack stack, final List<ShungiteCrystalEffects> stats) {
        final ListNBT list = new ListNBT();

        for (ShungiteCrystalEffects stat : stats) {
            list.add(ShungiteCrystalEffects.serialize(stat));
        }

        getShungiteData(stack).put(SHUNGITE_STATS_TAG, list);
    }

    public static void putStats(final ItemStack stack, final List<ShungiteEffect> effects) {
        final ListNBT list = new ListNBT();

        for (ShungiteEffect effect : effects) {
            list.add(ShungiteCrystalEffects.serialize(new ShungiteCrystalEffects(effect)));
        }

        getShungiteData(stack).put(SHUNGITE_STATS_TAG, list);
    }

    public static ItemStack getShungiteItemStack(List<ShungiteCrystalEffects> stats, int maxPower, int currentPower) {
        final ItemStack stack = new ItemStack(ModItems.SHUNGITE.get());
        stack.setTag(getShungiteData(stack));
        putMaxCrystalPower(stack, maxPower);
        putCurrentCrystalPower(stack, currentPower);
        putCompletedStats(stack, stats);

        return stack;
    }
}
