package moe.krp.shungite.items.crystal;

import static moe.krp.shungite.loot.CrystalPropertyGenerator.getRandomNewCrystalProperties;
import static moe.krp.shungite.util.ShungiteUtils.getTextComponent;
import static net.minecraft.util.Mth.clamp;

import com.mojang.datafixers.util.Pair;
import java.util.List;
import moe.krp.shungite.items.crystal.effects.ShungiteCrystalEffect;
import moe.krp.shungite.setup.ModShungiteEffects;
import moe.krp.shungite.util.ShungiteUtils;
import moe.krp.shungite.util.crystal.CrystalUtils;
import moe.krp.shungite.items.crystal.properties.ShungiteCrystalProperties;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeItem;

import javax.annotation.Nonnull;
import java.util.Collections;
import org.jetbrains.annotations.Nullable;


public class ShungiteCrystal extends Item implements IForgeItem {
    public ShungiteCrystal(final Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(
        Level level,
        Player player,
        InteractionHand useHand
    ) {
        if (!level.isClientSide) {
            final ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
            final ShungiteCrystalProperties properties = CrystalUtils.getProperties(stack);

            if (player.isCrouching()) {
                properties.setActive(!properties.isActive());
            }

            CrystalUtils.putProperties(stack, properties);
        }
        return super.use(level, player, useHand);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId,
        boolean pIsSelected) {
        final ShungiteCrystalProperties properties = CrystalUtils.getProperties(stack);
        final boolean crystalPowerMoreThanZero = properties.getCurrentCrystalPower() > 0;

        if (crystalPowerMoreThanZero && properties.isActive()) {
            properties.setCurrentCrystalPower(properties.getCurrentCrystalPower() - 1);

            if (entity instanceof Player) {
                Player player = (Player) entity;

                final List<Pair<MobEffect, Integer>> effectsToApply = properties.getEffects()
                    .stream()
                    .map( stat -> new Pair<>(stat.getCrystalEffect().getMobEffect(), stat.getLevel()))
                    .toList();

                // Effect -> Level of effect
                // Apply each for one second
                for (Pair<MobEffect, Integer> effect : effectsToApply) {
                    player.addEffect(new MobEffectInstance(effect.getFirst(), 20, effect.getSecond(), false, false));
                }
            }
        }
        else if (!crystalPowerMoreThanZero && properties.isActive()) {
            properties.setActive(false);
        }

        CrystalUtils.putProperties(stack, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
        List<Component> tooltip, TooltipFlag isAdvanced) {
        final ShungiteCrystalProperties properties = CrystalUtils.getProperties(stack);

        tooltip.add(ShungiteUtils.getTextComponent("info.shungite.shungiteCrystal").withStyle(ChatFormatting.GRAY));

        tooltip.add(ShungiteUtils.getTextComponent("info.shungite.energy")
            .append(": " + properties.getCurrentCrystalPower() + "/" + properties.getMaxCrystalPower())
            .withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.BLUE));

        tooltip.addAll(ShungiteCrystalEffect.listToString(properties.getEffects()));

        super.appendHoverText(stack, level, tooltip, isAdvanced);
    }

    @Override
    public boolean isFoil(final ItemStack stack) {
        return CrystalUtils.getProperties(stack).isActive();
    }

    @Override
    public int getBarColor(final ItemStack stack) {
        return 0x3a506b;
    }

    @Override
    public int getBarWidth(final ItemStack stack) {
        final ShungiteCrystalProperties properties = CrystalUtils.getProperties(stack);
        double barFilledPercent = 1.0 - properties.getCurrentCrystalPower() / (double) properties.getMaxCrystalPower();

        return clamp((int) Math.ceil(13D * barFilledPercent), 0, 13);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
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
        stack.setTag(ShungiteUtils.getShungiteData(stack));
        CrystalUtils.putProperties(stack, getRandomNewCrystalProperties(1, 1));

        return stack;
    }
}
