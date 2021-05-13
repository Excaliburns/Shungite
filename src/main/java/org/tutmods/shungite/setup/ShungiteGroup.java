package org.tutmods.shungite.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.tutmods.shungite.ShungiteConstants;

public class ShungiteGroup extends ItemGroup {
    public ShungiteGroup() {
        super(ShungiteConstants.MOD_ID);
    }

    @Override
    public ItemStack makeIcon() {
        return ModItems.SHUNGITE.get().getDefaultInstance();
    }

    @Override
    public void fillItemList(final NonNullList<ItemStack> stack) {
        stack.add(ModItems.SHUNGITE.get().getDefaultInstance());
        stack.add(ModItems.SHUNGITE_DOWSING_ROD.get().getDefaultInstance());
    }
}
