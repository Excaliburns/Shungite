package org.tutmods.shungite.setup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryBuilder;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.items.crystal.effects.ShungiteEffect;

public class Registration {
    public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, ShungiteConstants.MOD_ID);
    public static final DeferredRegister<Item>  ITEM_DEFERRED_REGISTER  = DeferredRegister.create(ForgeRegistries.ITEMS , ShungiteConstants.MOD_ID);
    public static final DeferredRegister<Effect> EFFECT_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.POTIONS, ShungiteConstants.MOD_ID);
    public static final DeferredRegister<ShungiteEffect> SHUNGITE_EFFECT_DEFERRED_REGISTER = DeferredRegister.create(ShungiteEffect.class, ShungiteConstants.MOD_ID);

    public static void register() {
        final IEventBus EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCK_DEFERRED_REGISTER.register(EVENT_BUS);
        ITEM_DEFERRED_REGISTER.register(EVENT_BUS);
        EFFECT_DEFERRED_REGISTER.register(EVENT_BUS);

        SHUNGITE_EFFECT_DEFERRED_REGISTER.makeRegistry(ShungiteConstants.MOD_ID, RegistryBuilder::new);
        SHUNGITE_EFFECT_DEFERRED_REGISTER.register(EVENT_BUS);

        ModItems.register();
        ModBlocks.register();
        ModEffects.register();
        ModShungiteEffects.register();
    }
}
