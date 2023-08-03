package moe.krp.shungite.loot;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import moe.krp.shungite.items.crystal.effects.ShungiteCrystalEffect;
import moe.krp.shungite.items.crystal.effects.ShungiteEffect;
import moe.krp.shungite.items.crystal.properties.ShungiteCrystalProperties;
import moe.krp.shungite.setup.Registration;
import net.minecraftforge.registries.RegistryObject;

public class CrystalPropertyGenerator {
    private static final List<ShungiteEffect> shungiteEffects = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER
            .getEntries().stream().map(RegistryObject::get).toList();

    private static final int MAX_POINT_VALUE = 20;
    private static final int MAX_POWER_VALUE = 50000;

    public static ShungiteCrystalProperties getRandomNewCrystalProperties() {
        return getRandomNewCrystalProperties(1, 1);
    }

    public static ShungiteCrystalProperties getRandomNewCrystalProperties(
            final int fortuneLevel,
            final int dimensionModifier
    ) {
        final Random rand = new Random();
        final int randomCrystalMaxPoints = MAX_POINT_VALUE * fortuneLevel * dimensionModifier;

        final int maxPowerMod = (25 - (fortuneLevel * 3)) - (dimensionModifier * 3);

        final double maxPowerMin = (double) MAX_POWER_VALUE / maxPowerMod;
        final double maxPowerMax = (double) MAX_POWER_VALUE / Math.max(maxPowerMod - 10, 1);

        final int randomMaxPower =  (int) (maxPowerMin + (maxPowerMax - maxPowerMin) * rand.nextDouble());

        int starting = 0;
        final HashMap<ShungiteEffect, Integer> effectListAndCount = new HashMap<>();
        while (starting < randomCrystalMaxPoints) {
            final int remainingPoints = randomCrystalMaxPoints - starting;

            final List<ShungiteEffect> possibleNextEffect = shungiteEffects
                    .stream()
                    .filter(each -> each.getPointValue() <= remainingPoints)
                    .toList();

            if (!possibleNextEffect.isEmpty()) {
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


        return new ShungiteCrystalProperties(crystalEffectList, randomMaxPower, randomMaxPower);
    }
}
