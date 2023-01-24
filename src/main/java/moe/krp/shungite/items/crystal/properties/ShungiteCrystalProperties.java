package moe.krp.shungite.items.crystal.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import moe.krp.shungite.ShungiteConstants;
import moe.krp.shungite.items.crystal.effects.ShungiteCrystalEffect;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

import java.util.ArrayList;
import java.util.List;

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

    public static ShungiteCrystalProperties deserialize(final CompoundTag tag) {
        final CompoundTag propertiesTag = tag.getCompound(ShungiteConstants.SHUNGITE_PROPERTIES_TAG);

        // region Stats
        final ListTag statList = propertiesTag.getList(ShungiteConstants.SHUNGITE_STATS_TAG, Tag.TAG_COMPOUND);

        final List<ShungiteCrystalEffect> stats = new ArrayList<>();
        for (int i = 0; i < statList.size(); i++) {
            final ShungiteCrystalEffect stat = ShungiteCrystalEffect.deserialize(statList.getCompound(i));

            stats.add(stat);
        }
        // endregion

        // region currentCrystalPower
        final int currentPower = propertiesTag.getInt(ShungiteConstants.SHUNGITE_CURRENT_ENERGY_TAG);
        // endregion

        // region maxCrystalPower
        final int maxPower = propertiesTag.getInt(ShungiteConstants.SHUNGITE_MAX_ENERGY_TAG);
        // endregion

        // region active
        final boolean active = propertiesTag.getBoolean(ShungiteConstants.SHUNGITE_ACTIVE);
        // endregion

        return new ShungiteCrystalProperties(stats, currentPower, maxPower, active);
    }

    public static CompoundTag serialize(final ShungiteCrystalProperties crystalProperties) {
        final CompoundTag tag = new CompoundTag();

        // region Stats
        final ListTag statsTag = new ListTag();
        for (ShungiteCrystalEffect effect : crystalProperties.effects) {
            final CompoundTag statTag = ShungiteCrystalEffect.serialize(effect);
            statsTag.add(statTag);
        }
        // endregion

        // region everything else
        tag.put(ShungiteConstants.SHUNGITE_STATS_TAG, statsTag);
        tag.putInt(ShungiteConstants.SHUNGITE_CURRENT_ENERGY_TAG, crystalProperties.currentCrystalPower);
        tag.putInt(ShungiteConstants.SHUNGITE_MAX_ENERGY_TAG, crystalProperties.maxCrystalPower);
        tag.putBoolean(ShungiteConstants.SHUNGITE_ACTIVE, crystalProperties.active);
        // endregion

        return tag;
    }
}
