package org.tutmods.shungite.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.items.crystal.ShungiteCrystal;
import org.tutmods.shungite.items.crystal.ShungiteCrystalStats;
import org.tutmods.shungite.items.crystal.stats.Stat;
import org.tutmods.shungite.util.crystal.CrystalUtils;

import java.util.Arrays;

import static org.tutmods.shungite.util.ShungiteUtils.getShungiteData;

public class ShungiteGroup extends ItemGroup {
    public ShungiteGroup() {
        super(ShungiteConstants.MOD_ID);
    }

    @Override
    public ItemStack makeIcon() {
        return ModItems.SHUNGITE.get().getDefaultInstance();
    }

    @Override
    public void fillItemList(final NonNullList<ItemStack> stack) {
        stack.add(ModItems.SHUNGITE.get().getDefaultInstance());

        stack.add(
                CrystalUtils.getShungiteItemStack(
                        Arrays.asList(
                                new ShungiteCrystalStats(Stat.AQUA_AFFINITY, 0), new ShungiteCrystalStats(Stat.DIG_SPEED, 0)
                        ),
                        5000,
                        5000
                )
        );

        stack.add(
                CrystalUtils.getShungiteItemStack(
                        Arrays.asList(
                                new ShungiteCrystalStats(Stat.ABSORPTION, 1), new ShungiteCrystalStats(Stat.SPEED, 0)
                        ),
                        5000,
                        5000
                )
        );

        stack.add(
                CrystalUtils.getShungiteItemStack(
                        Arrays.asList(
                                new ShungiteCrystalStats(Stat.FIRE_RESISTANCE, 0), new ShungiteCrystalStats(Stat.DIG_SPEED, 0)
                        ),
                        5000,
                        5000
                )
        );

        stack.add(
                CrystalUtils.getShungiteItemStack(
                        Arrays.asList(
                                new ShungiteCrystalStats(Stat.REGENERATION, 0), new ShungiteCrystalStats(Stat.DAMAGE_RESISTANCE, 1), new ShungiteCrystalStats(Stat.ABSORPTION, 0)
                        ),
                        5000,
                        5000
                )
        );
    }
}
