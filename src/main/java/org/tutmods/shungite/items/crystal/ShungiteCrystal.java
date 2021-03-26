package org.tutmods.shungite.items.crystal;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeItem;
import org.tutmods.shungite.items.crystal.stats.Stat;
import org.tutmods.shungite.setup.ModItems;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.tutmods.shungite.util.ShungiteUtils.getShungiteData;
import static org.tutmods.shungite.util.ShungiteUtils.getTextComponent;
import static org.tutmods.shungite.util.crystal.CrystalUtils.*;


public class ShungiteCrystal extends Item implements IForgeItem {
    public ShungiteCrystal(final Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            final ItemStack stack = player.getItemInHand(Hand.MAIN_HAND);
            if (stack.getItem() instanceof ShungiteCrystal) {
                if (player.isCrouching()) {
                    flipActive(stack);
                }
            }

            if (getMaxCrystalPower(stack) > 0) {
                putCurrentCrystalPower(stack, getMaxCrystalPower(stack));
            }
        }
        return super.use(world, player, hand);
    }

    @Override
    public void inventoryTick(final ItemStack itemStack, final World world, final Entity entity, final int itemSlot, final boolean isSelected) {
        final int crystalPower = getCurrentCrystalPower(itemStack);
        final boolean isActive = getActive(itemStack);

        if (crystalPower > 0 && isActive) {
            putCurrentCrystalPower(itemStack, crystalPower - 1);
        }

        if (entity instanceof PlayerEntity && crystalPower > 0 && isActive) {
            PlayerEntity player = (PlayerEntity) entity;

            final List<Pair<Effect, Integer>> effectsToApply = getStats(itemStack)
                    .stream()
                    .map( stat -> new Pair<>(stat.getStat().getEffect(), stat.getLevel()))
                    .collect(Collectors.toList());

            for (Pair<Effect, Integer> effect : effectsToApply) {
                player.addEffect(new EffectInstance(effect.getFirst(), 20, effect.getSecond(), false, false));
            }
        }
    }

    @Override
    public void appendHoverText(final ItemStack stack, final World worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        tooltip.add(getTextComponent("info.shungite.shungiteCrystal").withStyle(TextFormatting.GRAY));

        tooltip.add(getTextComponent("info.shungite.energy")
                .append(": " + getCurrentCrystalPower(stack) + "/" + getMaxCrystalPower(stack))
                .withStyle(TextFormatting.BOLD).withStyle(TextFormatting.BLUE));

        tooltip.addAll(ShungiteCrystalStats.listToString(getStats(stack)));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean isFoil(final ItemStack stack) {
        return getActive(stack);
    }

    //region Durability Display
    @Override
    public boolean showDurabilityBar(final ItemStack stack) {
        return true;
    }

    @Override
    public int getRGBDurabilityForDisplay(final ItemStack stack) {
        return 0x3a506b;
    }

    @Override
    public double getDurabilityForDisplay(final ItemStack stack) {
        return MathHelper.clamp(1.0D - getCurrentCrystalPower(stack) / (double) 5000, 0.0D, 1.0D);
    }

    @Override
    public boolean canContinueUsing(ItemStack oldStack, ItemStack newStack) {
        return true;
    }
    //endregion

    @Nonnull
    @Override
    public ItemStack getDefaultInstance() {
        final ItemStack stack = new ItemStack(this);
        stack.setTag(getShungiteData(stack));
        putMaxCrystalPower(stack, 5000);
        putCurrentCrystalPower(stack, 2500);
        putStats(stack, Arrays.asList(Stat.SPEED, Stat.ABSORPTION, Stat.AQUA_AFFINITY));

        return stack;
    }
}
