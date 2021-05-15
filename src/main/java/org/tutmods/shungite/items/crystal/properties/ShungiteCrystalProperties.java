package org.tutmods.shungite.items.crystal.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;
import org.tutmods.shungite.items.crystal.effects.ShungiteCrystalEffect;

import java.util.ArrayList;
import java.util.List;

import static org.tutmods.shungite.ShungiteConstants.*;

@AllArgsConstructor
@Data
public class ShungiteCrystalProperties {
    private List<ShungiteCrystalEffect> effects;
    private int currentCrystalPower;
    private int maxCrystalPower;
    private boolean active;

    public ShungiteCrystalProperties(final List<ShungiteCrystalEffect> effects, final int currentCrystalPower, final int maxCrystalPower) {
        this.effects = effects;
        this.currentCrystalPower = currentCrystalPower;
        this.maxCrystalPower = maxCrystalPower;
        this.active = false;
    }

    public static ShungiteCrystalProperties deserialize(final CompoundNBT tag) {
        final CompoundNBT propertiesTag = tag.getCompound(SHUNGITE_PROPERTIES_TAG);

        // region Stats
        final ListNBT statList = propertiesTag.getList(SHUNGITE_STATS_TAG, Constants.NBT.TAG_COMPOUND);

        final List<ShungiteCrystalEffect> stats = new ArrayList<>();
        for (int i = 0; i < statList.size(); i++) {
            final ShungiteCrystalEffect stat = ShungiteCrystalEffect.deserialize(statList.getCompound(i));

            stats.add(stat);
        }
        // endregion

        // region currentCrystalPower
        final int currentPower = propertiesTag.getInt(SHUNGITE_CURRENT_ENERGY_TAG);
        // endregion

        // region maxCrystalPower
        final int maxPower = propertiesTag.getInt(SHUNGITE_MAX_ENERGY_TAG);
        // endregion

        // region active
        final boolean active = propertiesTag.getBoolean(SHUNGITE_ACTIVE);
        // endregion

        return new ShungiteCrystalProperties(stats, currentPower, maxPower, active);
    }

    public static CompoundNBT serialize(final ShungiteCrystalProperties crystalProperties) {
        final CompoundNBT tag = new CompoundNBT();

        // region Stats
        final ListNBT statsTag = new ListNBT();
        for (ShungiteCrystalEffect effect : crystalProperties.effects) {
            final CompoundNBT statTag = ShungiteCrystalEffect.serialize(effect);
            statsTag.add(statTag);
        }
        // endregion

        // region everything else
        tag.put(SHUNGITE_STATS_TAG, statsTag);
        tag.putInt(SHUNGITE_CURRENT_ENERGY_TAG, crystalProperties.currentCrystalPower);
        tag.putInt(SHUNGITE_MAX_ENERGY_TAG, crystalProperties.maxCrystalPower);
        tag.putBoolean(SHUNGITE_ACTIVE, crystalProperties.active);
        // endregion

        return tag;
    }
}
