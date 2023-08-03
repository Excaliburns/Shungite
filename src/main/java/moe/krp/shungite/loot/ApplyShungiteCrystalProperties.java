package moe.krp.shungite.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import moe.krp.shungite.items.crystal.ShungiteCrystal;
import moe.krp.shungite.items.crystal.properties.ShungiteCrystalProperties;
import moe.krp.shungite.setup.ModLootFunctions;
import moe.krp.shungite.util.ShungiteUtils;
import moe.krp.shungite.util.crystal.CrystalUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

public class ApplyShungiteCrystalProperties extends LootItemConditionalFunction {
  ApplyShungiteCrystalProperties(LootItemCondition[] conditions) { super(conditions); }

  public LootItemFunctionType getType() {
    return ModLootFunctions.SHUNGITE_CRYSTAL_LOOT_FUNCTION.get();
  }

  @Override
  protected ItemStack run(ItemStack itemStack, LootContext lootContext) {
    if (itemStack.getItem() instanceof ShungiteCrystal) {
      final ShungiteCrystalProperties properties = CrystalPropertyGenerator.getRandomNewCrystalProperties();
      itemStack.setTag(ShungiteUtils.getShungiteData(itemStack));
      CrystalUtils.putProperties(itemStack, properties);
    }

    return itemStack;
  }

  public static LootItemConditionalFunction.Builder<?> builder() {
    return simpleBuilder(ApplyShungiteCrystalProperties::new);
  }

  public static class Serializer extends LootItemConditionalFunction.Serializer<ApplyShungiteCrystalProperties> {
    public @NotNull ApplyShungiteCrystalProperties deserialize(
        @NotNull JsonObject jsonObject,
        @NotNull JsonDeserializationContext jsonDeserializationContext,
        LootItemCondition @NotNull[] iLootConditions
    ) {
      return new ApplyShungiteCrystalProperties(iLootConditions);
    }
  }
}
