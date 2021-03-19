package org.tutmods.shungite.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.tutmods.shungite.Shungite;
import org.tutmods.shungite.ShungiteConstants;

public class ShungiteUtils {
    public static IFormattableTextComponent getTextComponent(final String key) {
        return new TranslationTextComponent(key);
    }

    public static CompoundNBT getCompountNBT(final ItemStack stack) {
        CompoundNBT nbt = stack.getTag();
        return nbt == null ? new CompoundNBT() : nbt;
    }
}
