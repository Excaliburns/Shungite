package org.tutmods.shungite.items.crystal;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeItem;
import org.tutmods.shungite.items.crystal.effects.ShungiteCrystalEffect;
import org.tutmods.shungite.items.crystal.properties.ShungiteCrystalProperties;
import org.tutmods.shungite.setup.ModShungiteEffects;

import javax.annotation.Nonnull;
import java.util.Collections;
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
            final ShungiteCrystalProperties properties = getProperties(stack);

            if (player.isCrouching()) {
                properties.setActive(!properties.isActive());
            }

            // TODO: remove this
            if (properties.getMaxCrystalPower() > 0) {
                properties.setCurrentCrystalPower(properties.getMaxCrystalPower());
            }

            putProperties(stack, properties);
        }
        return super.use(world, player, hand);
    }

    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int itemSlot, final boolean isSelected) {
        final ShungiteCrystalProperties properties = getProperties(stack);
        final boolean crystalPowerMoreThanZero = properties.getCurrentCrystalPower() > 0;


        if (crystalPowerMoreThanZero && properties.isActive()) {
            properties.setCurrentCrystalPower(properties.getCurrentCrystalPower() - 1);

            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;

                final List<Pair<Effect, Integer>> effectsToApply = properties.getEffects()
                        .stream()
                        .map( stat -> new Pair<>(stat.getCrystalEffect().getMinecraftEffect(), stat.getLevel()))
                        .collect(Collectors.toList());

                // Effect -> Level of effect
                // Apply each for one second
                for (Pair<Effect, Integer> effect : effectsToApply) {
                    player.addEffect(new EffectInstance(effect.getFirst(), 20, effect.getSecond(), false, false));
                }
            }

            putProperties(stack, properties);
        }
    }

    @Override
    public void appendHoverText(final ItemStack stack, final World worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        final ShungiteCrystalProperties properties = getProperties(stack);

        tooltip.add(getTextComponent("info.shungite.shungiteCrystal").withStyle(TextFormatting.GRAY));

        tooltip.add(getTextComponent("info.shungite.energy")
                .append(": " + properties.getCurrentCrystalPower() + "/" + properties.getMaxCrystalPower())
                .withStyle(TextFormatting.BOLD).withStyle(TextFormatting.BLUE));

        tooltip.addAll(ShungiteCrystalEffect.listToString(properties.getEffects()));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean isFoil(final ItemStack stack) {
        return getProperties(stack).isActive();
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
        final ShungiteCrystalProperties properties = getProperties(stack);

        return MathHelper.clamp(1.0D - properties.getCurrentCrystalPower() / (double) properties.getMaxCrystalPower() , 0.0D, 1.0D);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return IForgeItem.super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
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
        putProperties(stack, new ShungiteCrystalProperties(
                Collections.singletonList(new ShungiteCrystalEffect(ModShungiteEffects.EFFECT_ABSORPTION.get())),
                2500,
                5000,
                false
        ));

        return stack;
    }
}
