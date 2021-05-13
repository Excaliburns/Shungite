package org.tutmods.shungite.util;

import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class WorldHelper {
    public static AxisAlignedBB getAABBInDirectionWithOffset(BlockPos pos, Direction direction, int offsetX, int offsetY, int offsetZ) {
        switch (direction) {
            case EAST:
                return new AxisAlignedBB(pos.getX() - offsetX, pos.getY() - offsetY, pos.getZ() - offsetZ, pos.getX(), pos.getY() + offsetY, pos.getZ() + offsetZ);
            case WEST:
                return new AxisAlignedBB(pos.getX(), pos.getY() - offsetY, pos.getZ() - offsetZ, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ);
            case UP:
                return new AxisAlignedBB(pos.getX() - offsetX, pos.getY() - offsetY, pos.getZ() - offsetZ, pos.getX() + offsetX, pos.getY(), pos.getZ() + offsetZ);
            case DOWN:
                return new AxisAlignedBB(pos.getX() - offsetX, pos.getY(), pos.getZ() - offsetZ, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ);
            case SOUTH:
                return new AxisAlignedBB(pos.getX() - offsetX, pos.getY() - offsetY, pos.getZ() - offsetZ, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ());
            case NORTH:
                return new AxisAlignedBB(pos.getX() - offsetX, pos.getY() - offsetY, pos.getZ(), pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ);
            default:
                return new AxisAlignedBB(0, 0, 0, 0, 0, 0);
        }
    }

    public static AxisAlignedBB getAABBInDirectionWithOffset(BlockPos pos, Direction direction, int offset) {
        return getAABBInDirectionWithOffset(pos, direction, offset, offset, offset);
    }
}
