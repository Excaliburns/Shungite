package moe.krp.shungite.setup;

import java.util.function.Supplier;
import moe.krp.shungite.ShungiteConstants;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

  //shungite.item.shungite.shungite
  public static final RegistryObject<Block> SHUNGITE_CRYSTAL_ORE = register("shungite_crystal_ore",
      () -> new Block(
          BlockBehaviour.Properties.of(Material.STONE)
              .strength(10.0F, 6.0F)
              .sound(SoundType.ANCIENT_DEBRIS)
      )
  );

  static void register() {}

  private static <T extends Block> RegistryObject<T> registerNoItem(
      final String name,
      final Supplier<T> block
  ) {
    return Registration.BLOCK_DEFERRED_REGISTER.register(name, block);
  }

  private static <T extends Block> RegistryObject<T> register(
      final String name,
      final Supplier<T> block
  ) {
    final RegistryObject<T> blockToRegister = registerNoItem(name, block);
    Registration.ITEM_DEFERRED_REGISTER.register(name, () ->
        new BlockItem(
            blockToRegister.get(),
            new Item.Properties().tab(ShungiteConstants.SHUNGITE_TAB)
        )
    );
    return blockToRegister;
  }
}
