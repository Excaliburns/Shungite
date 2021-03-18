package org.tutmods.shungite.setup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import org.tutmods.shungite.ShungiteConstants;

public class ModTags {
    public static final class Blocks {
        //forge and mod tags here

        private static ITag.INamedTag<Block> forge(final String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(final String path) {
            return BlockTags.bind(new ResourceLocation(ShungiteConstants.MOD_ID, path).toString());
        }
    }

    public static final class Items {
        private static ITag.INamedTag<Item> forge(final String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(final String path) {
            return ItemTags.bind(new ResourceLocation(ShungiteConstants.MOD_ID, path).toString());
        }
    }
}
