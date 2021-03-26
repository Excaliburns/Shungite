package org.tutmods.shungite;

import net.minecraft.item.ItemGroup;
import org.tutmods.shungite.setup.ShungiteGroup;

public class ShungiteConstants {
    public static final String MOD_ID = "shungite";
    public static final String MOD_NAME = "Shungite";
    public static final ItemGroup SHUNGITE_GROUP = new ShungiteGroup();

    public static final String SHUNGITE_ENERGY_TAG = "MaxEnergy";
    public static final String SHUNGITE_CURRENT_ENERGY_TAG = "CurrentEnergy";
    public static final String SHUNGITE_ACTIVE = "IsActive";

    public static final String SHUNGITE_STATS_TAG = "Stats";
    public static final String SHUNGITE_CRYSTAL_STATS_TAG = "CrystalStats";
    public static final String SHUNGITE_STAT_TAG = "Stat";
    public static final String SHUNGITE_STAT_LEVEL_TAG = "StatLevel";

    public static final String SHUNGITE_ABSORPTION = "Absorption";
    public static final String SHUNGITE_SPEED = "Speed";
    public static final String SHUNGITE_DIG_SPEED = "DigSpeed";
}
