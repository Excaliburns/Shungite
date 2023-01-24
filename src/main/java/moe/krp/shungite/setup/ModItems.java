package moe.krp.shungite.setup;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.items.ShungiteDowsingRod;
import moe.krp.shungite.items.crystal.ShungiteCrystal;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
  public static final RegistryObject<Item> SHUNGITE = Registration.ITEM_DEFERRED_REGISTER.register(
      "shungite",
      () -> new ShungiteCrystal(
          new Item.Properties().tab(ShungiteConstants.SHUNGITE_TAB)
      )
  );

  public static final RegistryObject<Item> DOWSING_ROD = Registration.ITEM_DEFERRED_REGISTER.register(
      "dowsing_rod",
      () -> new ShungiteDowsingRod(
          new Item.Properties().tab(ShungiteConstants.SHUNGITE_TAB)
      )
  );

  static void register() {
  }
}
