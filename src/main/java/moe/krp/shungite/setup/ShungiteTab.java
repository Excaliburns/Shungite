package moe.krp.shungite.setup;

import moe.krp.shungite.ShungiteConstants;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ShungiteTab extends CreativeModeTab {

  public ShungiteTab() {
    super(ShungiteConstants.MOD_ID);
  }

  @Override
  public ItemStack makeIcon() {
    return ModItems.SHUNGITE.get().getDefaultInstance();
  }

  @Override
  public void fillItemList(final NonNullList<ItemStack> stack) {
    stack.add(ModItems.SHUNGITE.get().getDefaultInstance());
    stack.add(ModItems.DOWSING_ROD.get().getDefaultInstance());
  }
}
