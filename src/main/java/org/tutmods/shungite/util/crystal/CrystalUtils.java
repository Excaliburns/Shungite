package org.tutmods.shungite.util.crystal;

import net.minecraft.item.ItemStack;
import org.tutmods.shungite.items.crystal.effects.ShungiteCrystalEffect;
import org.tutmods.shungite.items.crystal.effects.ShungiteEffect;
import org.tutmods.shungite.items.crystal.properties.ShungiteCrystalProperties;
import org.tutmods.shungite.setup.ModItems;

import java.util.ArrayList;
import java.util.List;

import static org.tutmods.shungite.ShungiteConstants.*;
import static org.tutmods.shungite.ShungiteConstants.SHUNGITE_STATS_TAG;
import static org.tutmods.shungite.util.ShungiteUtils.getShungiteData;

public class CrystalUtils {
    public static ShungiteCrystalProperties getProperties(final ItemStack stack) {
        return ShungiteCrystalProperties.deserialize(getShungiteData(stack));
    }

    public static void putProperties (final ItemStack stack, final ShungiteCrystalProperties properties) {
        getShungiteData(stack).put(SHUNGITE_PROPERTIES_TAG, ShungiteCrystalProperties.serialize(properties));
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
