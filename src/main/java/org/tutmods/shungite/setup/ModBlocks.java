package org.tutmods.shungite.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import org.tutmods.shungite.ShungiteConstants;

import java.util.function.Supplier;

public class ModBlocks {
    //shungite.item.shungite.shungite
    public static final RegistryObject<Block> SHUNGITE_CRYSTAL = register("shungite_crystal_ore", () ->
            new Block(
                    AbstractBlock.Properties.of(Material.STONE)
                                            .harvestLevel(2)
                                            .sound(SoundType.ANCIENT_DEBRIS)));
    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(final String name, final Supplier<T> block) {
        return Registration.BLOCK_DEFERRED_REGISTER.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<T> block) {
        final RegistryObject<T> blockToRegister = registerNoItem(name, block);
        Registration.ITEM_DEFERRED_REGISTER.register(name, () ->
                new BlockItem(blockToRegister.get(), new Item.Properties().tab(ShungiteConstants.SHUNGITE_GROUP))
        );
        return blockToRegister;
    }
}
