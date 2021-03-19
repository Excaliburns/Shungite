package org.tutmods.shungite.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.arguments.NBTTagArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.util.ShungiteUtils;

import java.util.List;

import static org.tutmods.shungite.util.ShungiteUtils.getCompountNBT;
import static org.tutmods.shungite.util.ShungiteUtils.getTextComponent;

public class Shungite extends Item implements IShungiteCrystalItem {
    public Shungite(final Properties properties) {
        super(properties);
    }

    public Shungite(final Properties properties, final int maxCrystalPower, final int crystalPower) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            final ItemStack stack = player.getItemInHand(Hand.MAIN_HAND);
            if (stack.getItem() instanceof Shungite) {
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

            // Effect, Duration (tick), Strength
            player.addEffect(new EffectInstance(Effects.ABSORPTION, 20, 2));
        }
    }

    @Override
    public boolean showDurabilityBar(final ItemStack stack) {
        return true;
    }

    @Override
    public int getRGBDurabilityForDisplay(final ItemStack stack) {
        return 0x4c4c4c;
    }

    @Override
    public double getDurabilityForDisplay(final ItemStack stack) {
        return MathHelper.clamp(1.0D - getCurrentCrystalPower(stack) / (double) 5000, 0.0D, 1.0D);
    }

    @Override
    public void appendHoverText(final ItemStack stack, final World worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        tooltip.add(getTextComponent("info.shungite.shungiteCrystal").withStyle(TextFormatting.AQUA));

        tooltip.add(getTextComponent("info.shungite.energy")
                .append(": " + getCurrentCrystalPower(stack) + "/" + getMaxCrystalPower(stack))
                .withStyle(TextFormatting.BOLD).withStyle(TextFormatting.BLUE));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean canContinueUsing(ItemStack oldStack, ItemStack newStack) {
        return true;
    }

    @Override
    public boolean isFoil(final ItemStack stack) {
        return getActive(stack);
    }

    @Override
    public ItemStack getDefaultInstance() {
        final ItemStack stack = new ItemStack(this);
        stack.setTag(getCompountNBT(stack));
        putMaxCrystalPower(stack, 5000);
        putCurrentCrystalPower(stack, 2500);

        return stack;
    }
}
