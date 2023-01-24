package moe.krp.shungite.setup;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.items.crystal.effects.ShungiteEffect;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryBuilder;

public class Registration {

  public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(
      ForgeRegistries.BLOCKS, ShungiteConstants.MOD_ID
  );
  public static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER = DeferredRegister.create(
      ForgeRegistries.ITEMS, ShungiteConstants.MOD_ID
  );
  public static final DeferredRegister<MobEffect> EFFECT_DEFERRED_REGISTER = DeferredRegister.create(
      ForgeRegistries.MOB_EFFECTS, ShungiteConstants.MOD_ID
  );
  public static final DeferredRegister<PlacedFeature> PLACED_FEATURE_DEFERRED_REGISTER = DeferredRegister.create(
      Registry.PLACED_FEATURE_REGISTRY, ShungiteConstants.MOD_ID
  );

  public static final DeferredRegister<ShungiteEffect> SHUNGITE_EFFECT_DEFERRED_REGISTER = DeferredRegister.create(
      new ResourceLocation(ShungiteConstants.MOD_ID, ShungiteConstants.SHUNGITE_EFFECT_REGISTRY_KEY), ShungiteConstants.MOD_ID
  );

  public static final DeferredRegister<LootItemFunctionType> LOOT_ITEM_FUNCTION_TYPE_DEFERRED_REGISTER = DeferredRegister.create(
      Registry.LOOT_FUNCTION_REGISTRY, ShungiteConstants.MOD_ID
  );

  public static void register() {
    final IEventBus EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    BLOCK_DEFERRED_REGISTER.register(EVENT_BUS);
    ITEM_DEFERRED_REGISTER.register(EVENT_BUS);
    EFFECT_DEFERRED_REGISTER.register(EVENT_BUS);
    PLACED_FEATURE_DEFERRED_REGISTER.register(EVENT_BUS);
    LOOT_ITEM_FUNCTION_TYPE_DEFERRED_REGISTER.register(EVENT_BUS);

    SHUNGITE_EFFECT_DEFERRED_REGISTER.makeRegistry(RegistryBuilder::new);
    SHUNGITE_EFFECT_DEFERRED_REGISTER.register(EVENT_BUS);

    ModItems.register();
    ModBlocks.register();
    ModEffects.register();
    ModShungiteEffects.register();
    ModPlacedFeatures.register();
    ModLootFunctions.register();
  }
}
