package org.tutmods.shungite.loot;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraftforge.fml.RegistryObject;
import org.tutmods.shungite.items.crystal.effects.ShungiteCrystalEffect;
import org.tutmods.shungite.items.crystal.effects.ShungiteEffect;
import org.tutmods.shungite.items.crystal.properties.ShungiteCrystalProperties;
import org.tutmods.shungite.setup.Registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class CrystalPropertyGenerator {
    private static final List<ShungiteEffect> shungiteEffects = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER
            .getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());

    private static final int MAX_POINT_VALUE = 60;
    private static final int MAX_POWER_VALUE = 50000;

    /**
     * Get some random effects when the block is broken, if they have fortune make the effects better?
     */
    public static ShungiteCrystalProperties getRandomNewCrystalProperties() {
        final Random rand = new Random();

        final int randomCrystalMaxPoints = (int) (MAX_POINT_VALUE * .3); // 18

        final double maxPowerMin = (double) MAX_POWER_VALUE / 25; // 2000
        final double maxPowerMax = (double) MAX_POWER_VALUE / 15; // 3333

        final int randomMaxPower =  (int) (maxPowerMin + (maxPowerMax - maxPowerMin) * rand.nextDouble()); // 2000 - 3333

        final double currentPowerMin = 500;
        final double currentPowerMax = randomMaxPower * .90; // 3000

        final int randomCurrentPower = (int) (currentPowerMin + (currentPowerMax - currentPowerMin) * rand.nextDouble()); // 500 - 3000

        int starting = 0;
        final HashMap<ShungiteEffect, Integer> effectListAndCount = new HashMap<>();
        while (starting < randomCrystalMaxPoints) {
            final int remainingPoints = randomCrystalMaxPoints - starting;

            final List<ShungiteEffect> possibleNextEffect = shungiteEffects
                    .stream()
                    .filter(each -> each.getPointValue() <= remainingPoints)
                    .collect(Collectors.toList());

            if (possibleNextEffect.size() > 0) {
                final int randomEffectIdx = rand.nextInt(possibleNextEffect.size());
                final ShungiteEffect newEffect = possibleNextEffect.get(randomEffectIdx);

                if (starting + newEffect.getPointValue() <= randomCrystalMaxPoints) {
                    effectListAndCount.put(newEffect, effectListAndCount.getOrDefault(newEffect, -1) + 1);
                    starting += newEffect.getPointValue();
                }
            }
            else {
                break;
            }
        }

        List<ShungiteCrystalEffect> crystalEffectList = effectListAndCount
                .entrySet()
                .stream()
                .map( (entry) -> new ShungiteCrystalEffect(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());


        return new ShungiteCrystalProperties(crystalEffectList, randomCurrentPower, randomMaxPower);
    }
}
