package org.tutmods.shungite.items.crystal;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeItem;
import org.tutmods.shungite.util.WorldHelper;

import java.util.stream.Stream;

public class ShungiteDowsingRod extends Item implements IForgeItem {
    public ShungiteDowsingRod(Properties properties) { super(properties); }

    @Override
    public ActionResultType useOn(ItemUseContext itemUseContext) {
        final World world = itemUseContext.getLevel();

        // Upgradable? (Depth is upgraded by material EE2-esque)
        // On right click, get 3 x 3 x 25 deep
        if (!world.isClientSide() && itemUseContext.getPlayer() != null) {
            final Stream<BlockPos> blocksBetweenPlayerLookingAndDowsingEffect = BlockPos.betweenClosedStream(
                    WorldHelper.getAABBInDirectionWithOffset(
                            itemUseContext.getClickedPos(),
                            itemUseContext.getClickedFace(),
                            0,
                            1,
                            1
                    )
            );

            blocksBetweenPlayerLookingAndDowsingEffect.forEach( blockPos -> {
                world.setBlockAndUpdate(blockPos, Blocks.CYAN_WOOL.defaultBlockState());
            });
        }

        return super.useOn(itemUseContext);
    }
}
