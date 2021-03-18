package org.tutmods.shungite.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> SHUNGITE_CRYSTAL = register("shungite_crystal", () ->
            new Block(
                    AbstractBlock.Properties.of(Material.GLASS)
                                            .strength(3, 10)
                                            .harvestLevel(2)
                                            .sound(SoundType.ANCIENT_DEBRIS)));
    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCK_DEFERRED_REGISTER.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        final RegistryObject<T> blockToRegister = registerNoItem(name, block);
        Registration.ITEM_DEFERRED_REGISTER.register(name, () ->
                new BlockItem(blockToRegister.get(), new Item.Properties().tab(ItemGroup.TAB_MISC))
        );
        return blockToRegister;
    }
}
