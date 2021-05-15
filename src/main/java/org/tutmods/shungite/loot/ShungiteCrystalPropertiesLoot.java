package org.tutmods.shungite.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootFunction;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.conditions.ILootCondition;
import org.tutmods.shungite.items.crystal.ShungiteCrystal;
import org.tutmods.shungite.items.crystal.properties.ShungiteCrystalProperties;
import org.tutmods.shungite.util.crystal.CrystalUtils;

import static org.tutmods.shungite.util.ShungiteUtils.getShungiteData;

public class ShungiteCrystalPropertiesLoot extends LootFunction {
    protected ShungiteCrystalPropertiesLoot(ILootCondition[] conditions) {
        super(conditions);
    }

    @Override
    protected ItemStack run(ItemStack stack, LootContext lootContext) {
        if (stack.getItem() instanceof ShungiteCrystal) {
            final ShungiteCrystalProperties properties = CrystalPropertyGenerator.getRandomNewCrystalProperties();
            stack.setTag(getShungiteData(stack));
            CrystalUtils.putProperties(stack, properties);
        }

        return stack;
    }

    public static LootFunction.Builder<?> builder() {
        return simpleBuilder(ShungiteCrystalPropertiesLoot::new);
    }

    @Override
    public LootFunctionType getType() {
        return Functions.ShungiteCrystalsLoot;
    }

    public static class Functions {
        public static LootFunctionType ShungiteCrystalsLoot;
    }

    public static class Serializer extends LootFunction.Serializer<ShungiteCrystalPropertiesLoot> {
        @Override
        public ShungiteCrystalPropertiesLoot deserialize(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext, ILootCondition[] iLootConditions) {
            return new ShungiteCrystalPropertiesLoot(iLootConditions);
        }
    }
}
