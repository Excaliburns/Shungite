package org.tutmods.shungite.items.crystal;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeItem;
import org.tutmods.shungite.setup.ModBlocks;
import org.tutmods.shungite.util.ShungiteUtils;
import org.tutmods.shungite.util.WorldHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShungiteDowsingRod extends Item implements IForgeItem {
    public ShungiteDowsingRod(Properties properties) { super(properties); }

    // When we use this item on a block, get an AABB forward based on the block face clicked / player position.
    // TODO: Empower this item in order to increase the range at which you can find crystals, maybe through some sort of infusion mechanic
    @Override
    public ActionResultType useOn(ItemUseContext itemUseContext) {
        final World world = itemUseContext.getLevel();
        final Direction lookingDirection;

        if (itemUseContext.getPlayer() != null) {
            if (itemUseContext.getClickedFace() == Direction.DOWN || itemUseContext.getClickedFace() == Direction.UP) {
                lookingDirection = itemUseContext.getClickedFace();
            }
            else {
                lookingDirection = itemUseContext.getHorizontalDirection();
            }

            final int offsetX = 10;

            final AxisAlignedBB aabb = WorldHelper.getAABBInDirectionWithOffset(
                    itemUseContext.getClickedPos(),
                    lookingDirection,
                    offsetX,
                    1,
                    1
            );
            final Stream<BlockPos> blocksBetweenPlayerLookingAndDowsingEffect = BlockPos.betweenClosedStream(aabb);

            final List<BlockPos> foundShungiteOre =  new ArrayList<>();

            blocksBetweenPlayerLookingAndDowsingEffect.forEach( blockPos -> {
                if (world.getBlockState(blockPos).getBlock() == ModBlocks.SHUNGITE_CRYSTAL.get()) {
                    foundShungiteOre.add(blockPos);
                }
            });

            if (foundShungiteOre.size() > 0) {
                final String formatted = ShungiteUtils.getTextComponent("info.shungite.dowsing_rod_ores_found", foundShungiteOre.size(), offsetX).getString();

                if (!itemUseContext.getLevel().isClientSide) {
                    itemUseContext.getPlayer().displayClientMessage(new TranslationTextComponent(formatted), false);
                }

            }
            else {
                if (!itemUseContext.getLevel().isClientSide) {
                    itemUseContext.getPlayer().displayClientMessage(
                            new TranslationTextComponent(
                                ShungiteUtils.getTextComponent("info.shungite.dowsing_rod_no_ores_found").getString()
                            ), false);
                }
            }
        }

        return super.useOn(itemUseContext);
    }
}
