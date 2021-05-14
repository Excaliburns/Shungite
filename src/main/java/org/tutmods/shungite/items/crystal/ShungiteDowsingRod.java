package org.tutmods.shungite.items.crystal;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeItem;
import net.minecraftforge.common.util.Constants;
import org.tutmods.shungite.util.WorldHelper;

import java.util.stream.Stream;

public class ShungiteDowsingRod extends Item implements IForgeItem {
    public ShungiteDowsingRod(Properties properties) { super(properties); }

    @Override
    public ActionResultType useOn(ItemUseContext itemUseContext) {
        final World world = itemUseContext.getLevel();

        final Direction lookingDirection;

        if (itemUseContext.getClickedFace() == Direction.DOWN || itemUseContext.getClickedFace() == Direction.UP) {
            lookingDirection = itemUseContext.getClickedFace();
        }
        else {
            lookingDirection = itemUseContext.getHorizontalDirection();
        }

        final AxisAlignedBB aabb = WorldHelper.getAABBInDirectionWithOffset(
                itemUseContext.getClickedPos(),
                lookingDirection,
                10,
                1,
                1
        );

        final Stream<BlockPos> blocksBetweenPlayerLookingAndDowsingEffect = BlockPos.betweenClosedStream(
                aabb
        );

        System.out.println(aabb);

        blocksBetweenPlayerLookingAndDowsingEffect.forEach( blockPos -> {
            world.setBlock(blockPos, Blocks.CYAN_WOOL.defaultBlockState(), ( Constants.BlockFlags.DEFAULT_AND_RERENDER ) );
        });

        return super.useOn(itemUseContext);
    }
}
