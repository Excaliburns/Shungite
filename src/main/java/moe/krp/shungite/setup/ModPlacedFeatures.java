package moe.krp.shungite.setup;

import moe.krp.shungite.world.ores.ShungiteOre;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
  public static final RegistryObject<PlacedFeature> SHUNGITE_ORE_PLACED_FEATURE = Registration.PLACED_FEATURE_DEFERRED_REGISTER.register(
      "overworld_shungite_crystal_ore",
      ShungiteOre::createOverworldOregen
  );

  static void register() {}
}
