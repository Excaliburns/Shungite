package moe.krp.shungite.setup;

import java.util.function.Supplier;
import moe.krp.shungite.ShungiteConstants;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

  //shungite.item.shungite.shungite
  public static final RegistryObject<Block> SHUNGITE_CRYSTAL_ORE = register("shungite_crystal_ore",
      () -> new Block(
              BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)
      )
  );
  public static final RegistryObject<Block> DEEPSLATE_SHUNGITE_CRYSTAL_ORE = register("deepslate_shungite_crystal_ore",
          () -> new Block(
                  BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.DEEPSLATE)
          )
  );
  public static final RegistryObject<Block> NETHERRACK_SHUNGITE_CRYSTAL_ORE = register("netherrack_shungite_crystal_ore",
          () -> new Block(
                  BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHERRACK)
          )
  );
  public static final RegistryObject<Block> END_SHUNGITE_CRYSTAL_ORE = register("end_shungite_crystal_ore",
          () -> new Block(
                  BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.STONE)
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
