package org.tutmods.shungite.loot;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.tutmods.shungite.items.crystal.effects.ShungiteCrystalEffect;
import org.tutmods.shungite.items.crystal.effects.ShungiteEffect;
import org.tutmods.shungite.items.crystal.properties.ShungiteCrystalProperties;
import org.tutmods.shungite.setup.ModEffects;
import org.tutmods.shungite.setup.ModShungiteEffects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CrystalPropertyGenerator {
    private static final List<ShungiteEffect> shungiteEffects = ImmutableList.of(
            ModShungiteEffects.EFFECT_ABSORPTION.get(),
            ModShungiteEffects.EFFECT_DAMAGE_RESISTANCE.get(),
            ModShungiteEffects.EFFECT_REGENERATION.get(),
            ModShungiteEffects.EFFECT_FIRE_RESISTANCE.get(),
            ModShungiteEffects.EFFECT_WATER_BREATHING.get(),
            ModShungiteEffects.EFFECT_JUMP.get(),
            ModShungiteEffects.EFFECT_SPEED.get(),
            ModShungiteEffects.EFFECT_DIG_SPEED.get(),
            ModShungiteEffects.EFFECT_AQUA_AFFINITY.get()
    );

    private static final int MAX_POINT_VALUE = 50;
    private static final int MAX_POWER_VALUE = 50000;

    /**
     * Get some random effects when the block is broken, if they have fortune make the effects better?
     */
    public static ShungiteCrystalProperties getRandomNewCrystalProperties() {
        final Random rand = new Random();
        final int baseRandomMaxPointValue = MAX_POINT_VALUE / 3;
        final int baseRandomMaxPower = MAX_POWER_VALUE / rand.nextInt(MAX_POWER_VALUE / 4 - MAX_POWER_VALUE / 8) + MAX_POWER_VALUE / 8;
        final int baseRandomCurrentPower = (int) (baseRandomMaxPower * .5 * rand.nextDouble());

        int starting = 0;
        double baseRandomMaxPointValueLimit = baseRandomMaxPointValue * .75;
        final List<ShungiteCrystalEffect> effectList = new ArrayList<>();
        while (starting < baseRandomMaxPointValueLimit) {
            final int remainingPoints = (int) baseRandomMaxPointValueLimit - starting;

            final List<ShungiteEffect> possibleNextEffect = shungiteEffects
                    .stream()
                    .filter(each -> each.getPointValue() <= remainingPoints)
                    .collect(Collectors.toList());

            if (possibleNextEffect.size() > 0) {
                final int randomEffectIdx = rand.nextInt(shungiteEffects.size());
                final ShungiteCrystalEffect newEffect = new ShungiteCrystalEffect(shungiteEffects.get(randomEffectIdx));

                if (starting + newEffect.getPointValue() < baseRandomMaxPointValue) {
                    starting += newEffect.getPointValue();
                    effectList.add(newEffect);
                }
            }
            else {
                break;
            }
        }


        return new ShungiteCrystalProperties(effectList, baseRandomCurrentPower, baseRandomMaxPower);
    }
}
