package moe.krp.shungite.setup;

import moe.krp.shungite.loot.ApplyShungiteCrystalProperties;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.registries.RegistryObject;

public class ModLootFunctions {
  public static final RegistryObject<LootItemFunctionType> SHUNGITE_CRYSTAL_LOOT_FUNCTION = Registration.LOOT_ITEM_FUNCTION_TYPE_DEFERRED_REGISTER.register(
      "shungite_random_crystal",
      () -> new LootItemFunctionType(new ApplyShungiteCrystalProperties.Serializer())
  );
  static void register() {}
}
