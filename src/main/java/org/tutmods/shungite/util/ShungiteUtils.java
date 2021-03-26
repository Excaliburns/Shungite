package org.tutmods.shungite.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.tutmods.shungite.Shungite;
import org.tutmods.shungite.ShungiteConstants;

import javax.annotation.Nonnull;

public class ShungiteUtils {
    public static IFormattableTextComponent getTextComponent(final String key) {
        return new TranslationTextComponent(key);
    }

    public static CompoundNBT getShungiteData(final ItemStack stack) {
        if (!stack.isEmpty()) {
            if (stack.getTag() != null) {
                return getShungiteCompound(stack);
            }
        }
        return genNewShungiteNbt();
    }


    public static CompoundNBT getShungiteCompound(@Nonnull ItemStack nbtContainer) {
        if (nbtContainer.getTag() == null) return genNewShungiteNbt();

        return nbtContainer.getTag().getCompound(ShungiteConstants.MOD_ID);
    }

    private static CompoundNBT genNewShungiteNbt() {
        final CompoundNBT newNbt = new CompoundNBT();
        newNbt.put(ShungiteConstants.MOD_ID, new CompoundNBT());

        return newNbt;
    }
}
