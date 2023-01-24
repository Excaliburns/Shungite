package moe.krp.shungite.util.crystal;

import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.items.crystal.effects.ShungiteCrystalEffect;
import moe.krp.shungite.items.crystal.effects.ShungiteEffect;
import moe.krp.shungite.items.crystal.properties.ShungiteCrystalProperties;
import moe.krp.shungite.setup.ModItems;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static moe.krp.shungite.util.ShungiteUtils.getShungiteData;

public class CrystalUtils {
    public static ShungiteCrystalProperties getProperties(final ItemStack stack) {
        return ShungiteCrystalProperties.deserialize(getShungiteData(stack));
    }

    public static void putProperties (final ItemStack stack, final ShungiteCrystalProperties properties) {
        getShungiteData(stack).put(ShungiteConstants.SHUNGITE_PROPERTIES_TAG, ShungiteCrystalProperties.serialize(properties));
    }

    public static void putCompletedStats(final ItemStack stack, final List<ShungiteCrystalEffect> effects) {
        final ShungiteCrystalProperties properties = getProperties(stack);
        properties.setEffects(effects);

        putProperties(stack, properties);
    }

    public static void putStats(final ItemStack stack, final List<ShungiteEffect> effects) {
        final List<ShungiteCrystalEffect> effectList = new ArrayList<>();

        for (ShungiteEffect effect : effects) {
            effectList.add(new ShungiteCrystalEffect(effect));
        }

        putCompletedStats(stack, effectList);
    }

    public static ItemStack getShungiteItemStack(List<ShungiteCrystalEffect> stats, int maxPower, int currentPower) {
        final ItemStack stack = new ItemStack(ModItems.SHUNGITE.get());
        stack.setTag(getShungiteData(stack));
        final ShungiteCrystalProperties properties = new ShungiteCrystalProperties(stats, currentPower, maxPower, false);
        putProperties(stack, properties);
        return stack;
    }
}
