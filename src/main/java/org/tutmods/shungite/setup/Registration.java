package org.tutmods.shungite.setup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.tutmods.shungite.ShungiteConstants;

public class Registration {
    public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, ShungiteConstants.MOD_ID);
    public static final DeferredRegister<Item>  ITEM_DEFERRED_REGISTER  = DeferredRegister.create(ForgeRegistries.ITEMS , ShungiteConstants.MOD_ID);

    public static void register() {
        final IEventBus EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCK_DEFERRED_REGISTER.register(EVENT_BUS);
        ITEM_DEFERRED_REGISTER.register(EVENT_BUS);

        ModItems.register();
        ModBlocks.register();
    }
}
