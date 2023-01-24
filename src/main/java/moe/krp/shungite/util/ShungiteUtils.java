package moe.krp.shungite.util;

import javax.annotation.Nonnull;
import moe.krp.shungite.ShungiteConstants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;

public class ShungiteUtils {
    public static MutableComponent getTextComponent(final String key) {
        return Component.translatable(key);
    }

    public static MutableComponent getTextComponent(final String key, Object... args) {
        return Component.translatable(key, args);
    }

    public static CompoundTag getShungiteData(final ItemStack stack) {
        if (!stack.isEmpty()) {
            if (stack.getTag() != null) {
                return getShungiteCompound(stack);
            }
        }
        return genNewShungiteNbt();
    }


    public static CompoundTag getShungiteCompound(@Nonnull ItemStack nbtContainer) {
        if (nbtContainer.getTag() == null) return genNewShungiteNbt();

        return nbtContainer.getTag().getCompound(ShungiteConstants.MOD_ID);
    }

    private static CompoundTag genNewShungiteNbt() {
        final CompoundTag newNbt = new CompoundTag();
        newNbt.put(ShungiteConstants.MOD_ID, new CompoundTag());

        return newNbt;
    }
}
