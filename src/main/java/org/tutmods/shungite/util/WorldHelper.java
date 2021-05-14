package org.tutmods.shungite.util;

import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class WorldHelper {
    /**
     * Helper function that gets a bounding box forward from a given position.
     * @param pos Originating position of bounding box, assumed to be the center
     * @param direction Direction the bounding box should go
     * @param offsetX Assumed to be the direction away / towards from the player
     * @param offsetY Assumed to be the direction up / down from the player
     * @param offsetZ Assumed to be the direction left / right of the player
     * @return new AABB with given offsets in a given direction
     */
    public static AxisAlignedBB getAABBInDirectionWithOffset(BlockPos pos, Direction direction, int offsetX, int offsetY, int offsetZ) {
        switch (direction) {
            case UP:
                return new AxisAlignedBB(pos.getX() - offsetZ, pos.getY(), pos.getZ() - offsetY, pos.getX() + offsetZ, pos.getY() - offsetX, pos.getZ() + offsetY);
            case DOWN:
                return new AxisAlignedBB(pos.getX() - offsetZ, pos.getY(), pos.getZ() - offsetY, pos.getX() + offsetZ, pos.getY() + offsetX, pos.getZ() + offsetY);
            case EAST:
                return new AxisAlignedBB(pos.getX(), pos.getY() - offsetY, pos.getZ() - offsetZ, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ);
            case WEST:
                return new AxisAlignedBB(pos.getX() - offsetX, pos.getY() - offsetY, pos.getZ() - offsetZ, pos.getX(), pos.getY() + offsetY, pos.getZ() + offsetZ);
            case NORTH:
                return new AxisAlignedBB(pos.getX() - offsetZ, pos.getY() - offsetY, pos.getZ() - offsetX, pos.getX() + offsetZ, pos.getY() + offsetY, pos.getZ());
            case SOUTH:
                return new AxisAlignedBB(pos.getX() - offsetZ, pos.getY() - offsetY, pos.getZ(), pos.getX() + offsetZ, pos.getY() + offsetY, pos.getZ() + offsetX);
            default:
                return new AxisAlignedBB(0, 0, 0, 0, 0, 0);
        }
    }

    public static AxisAlignedBB getAABBInDirectionWithOffset(BlockPos pos, Direction direction, int offset) {
        return getAABBInDirectionWithOffset(pos, direction, offset, offset, offset);
    }
}
