package org.tutmods.shungite.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.extensions.IForgeItem;

import static org.tutmods.shungite.ShungiteConstants.*;
import static org.tutmods.shungite.util.ShungiteUtils.getCompountNBT;

public interface IShungiteCrystalItem extends IForgeItem {

    default void putActive(final ItemStack stack, final boolean active) {
        getCompountNBT(stack).putBoolean(SHUNGITE_ACTIVE, active);
    }

    default void flipActive(final ItemStack stack) {
        getCompountNBT(stack).putBoolean(SHUNGITE_ACTIVE, !getActive(stack));
    }

    default void putMaxCrystalPower(final ItemStack stack, final int maxPower) {
        getCompountNBT(stack).putInt(SHUNGITE_ENERGY_TAG, maxPower);
    }

    default void putCurrentCrystalPower(final ItemStack stack, final int currentPower) {
        getCompountNBT(stack).putInt(SHUNGITE_CURRENT_ENERGY_TAG, currentPower);
    }

    default int getMaxCrystalPower(final ItemStack stack) {
        return getCompountNBT(stack).getInt(SHUNGITE_ENERGY_TAG);
    }

    default int getCurrentCrystalPower(final ItemStack stack) {
        return getCompountNBT(stack).getInt(SHUNGITE_CURRENT_ENERGY_TAG);
    }

    default boolean getActive(final ItemStack stack) {
        return getCompountNBT(stack).getBoolean(SHUNGITE_ACTIVE);
    }

}
