package moe.krp.shungite.items;

import moe.krp.shungite.util.ShungiteUtils;
import moe.krp.shungite.util.WorldHelper;
import moe.krp.shungite.setup.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.extensions.IForgeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShungiteDowsingRod extends Item implements IForgeItem {
    public ShungiteDowsingRod(Properties properties) { super(properties); }

    @Override
    public InteractionResult useOn(final UseOnContext itemUseContext) {
        final Level world = itemUseContext.getLevel();
        final Direction lookingDirection;

        if (itemUseContext.getPlayer() != null) {
            if (itemUseContext.getClickedFace() == Direction.DOWN || itemUseContext.getClickedFace() == Direction.UP) {
                lookingDirection = itemUseContext.getClickedFace();
            }
            else {
                lookingDirection = itemUseContext.getHorizontalDirection();
            }

            final int offsetX = 10;

            final AABB aabb = WorldHelper.getAABBInDirectionWithOffset(
                itemUseContext.getClickedPos(),
                lookingDirection,
                offsetX,
                1,
                1
            );
            final Stream<BlockPos> blocksBetweenPlayerLookingAndDowsingEffect = BlockPos.betweenClosedStream(aabb);

            final List<BlockPos> foundShungiteOre =  new ArrayList<>();

            blocksBetweenPlayerLookingAndDowsingEffect.forEach( blockPos -> {
                if (world.getBlockState(blockPos).getBlock() == ModBlocks.SHUNGITE_CRYSTAL_ORE.get()) {
                    foundShungiteOre.add(blockPos);
                }
            });

            if (foundShungiteOre.size() > 0) {
                final String formatted = ShungiteUtils.getTextComponent("info.shungite.dowsing_rod_ores_found", foundShungiteOre.size(), offsetX).getString();

                if (!itemUseContext.getLevel().isClientSide) {
                    itemUseContext.getPlayer().displayClientMessage(
                        Component.translatable(formatted),
                        false
                    );
                }

            }
            else {
                if (!itemUseContext.getLevel().isClientSide) {
                    itemUseContext.getPlayer().displayClientMessage(
                        Component.translatable(ShungiteUtils.getTextComponent("info.shungite.dowsing_rod_no_ores_found").getString()),
                        false
                    );
                }
            }
        }

        return super.useOn(itemUseContext);
    }
}
