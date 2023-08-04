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
    private static final List<ShungiteEffect> positiveEffects = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.getEntries().stream().map(RegistryObject::get).filter((it) -> ShungiteEffect.ShungiteEffectType.positiveTypes().contains(it.getType())).toList();
    private static final List<ShungiteEffect> negativeEffects = Registration.SHUNGITE_EFFECT_DEFERRED_REGISTER.getEntries().stream().map(RegistryObject::get).filter((it) -> ShungiteEffect.ShungiteEffectType.negativeTypes().contains(it.getType())).toList();
    private static final int MAX_POINT_VALUE = 20;
    private static final int MAX_POWER_VALUE = 50000;

    public static ShungiteCrystalProperties getRandomNewCrystalProperties() {
        return getRandomNewCrystalProperties(1, 1);
    }

    /**
     * Generate a random crystal using the fortune level of the tool used and the dimension the ore
     * was broken in.
     *
     * @param fortuneLevel
     * @param dimensionModifier
     * @return
     */
    public static ShungiteCrystalProperties getRandomNewCrystalProperties(final int fortuneLevel, final int dimensionModifier) {
        final Random rand = new Random();
        final double weight = Math.ceil((double) (dimensionModifier * fortuneLevel + 1) / 2);
        final int randomCrystalMaxPoints = MAX_POINT_VALUE * (int) weight;

        final int maxPowerMod = (25 - ((fortuneLevel + 1) * 3)) - (dimensionModifier * 3);

        final double maxPowerMin = (double) MAX_POWER_VALUE / maxPowerMod;
        final double maxPowerMax = (double) MAX_POWER_VALUE / Math.max(maxPowerMod - 10, 1);

        final int randomMaxPower = (int) (maxPowerMin + (maxPowerMax - maxPowerMin) * rand.nextDouble());

        double negativeModifier = 1 - (.5 / weight);
        int currentCrystalPoints = 0;
        final HashMap<ShungiteEffect, Integer> effectListAndCount = new HashMap<>();
        while (currentCrystalPoints < randomCrystalMaxPoints) {
            // Each iteration, pick positive or negative. Use the weight to decide! if weight is 1, 50% chance.
            // Then, use the weight again to pick if it's a really good positive effect or really bad negative effect.
            final boolean positiveEffect = (rand.nextDouble(1) < negativeModifier);
            final boolean bonus = (rand.nextDouble(1) < negativeModifier);

            List<ShungiteEffect> possibleNextEffects;
            if (positiveEffect && bonus) {
                possibleNextEffects = positiveEffects.stream()
                        .filter(it -> it.getType().equals(ShungiteEffect.ShungiteEffectType.POSITIVE_PLUS))
                        .toList();
            }
            else if (positiveEffect) {
                possibleNextEffects = positiveEffects;
            }
            else if (bonus) {
                possibleNextEffects = negativeEffects.stream()
                        .filter(it -> it.getType().equals(ShungiteEffect.ShungiteEffectType.NEGATIVE_PLUS))
                        .toList();
            }
            else {
                possibleNextEffects = negativeEffects;
            }

            final int remainingPoints = randomCrystalMaxPoints - currentCrystalPoints;

            final List<ShungiteEffect> possibleNextEffect = possibleNextEffects
                    .stream().filter(each -> each.getPointValue() <= remainingPoints).toList();

            if (!possibleNextEffect.isEmpty()) {
                final int randomEffectIdx = rand.nextInt(possibleNextEffect.size());
                final ShungiteEffect newEffect = possibleNextEffect.get(randomEffectIdx);

                if (currentCrystalPoints + newEffect.getPointValue() <= randomCrystalMaxPoints) {
                    effectListAndCount.put(newEffect, effectListAndCount.getOrDefault(newEffect, -1) + 1);
                    currentCrystalPoints += newEffect.getPointValue();
                }
            }
            else {
                break;
            }
        }

        List<ShungiteCrystalEffect> crystalEffectList = effectListAndCount.entrySet().stream().map((entry) -> new ShungiteCrystalEffect(entry.getKey(), entry.getValue())).collect(Collectors.toList());


        return new ShungiteCrystalProperties(crystalEffectList, randomMaxPower, randomMaxPower);
    }
}
