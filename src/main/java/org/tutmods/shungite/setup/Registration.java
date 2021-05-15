package org.tutmods.shungite.setup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootFunction;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.functions.LootFunctionManager;
import net.minecraft.potion.Effect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryBuilder;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.loot.ShungiteCrystalPropertiesLoot;
import org.tutmods.shungite.world.ShungiteOreGeneration;
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

        //Ore generation
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ShungiteOreGeneration::generateOres);

        SHUNGITE_EFFECT_DEFERRED_REGISTER.makeRegistry(ShungiteConstants.MOD_ID, RegistryBuilder::new);
        SHUNGITE_EFFECT_DEFERRED_REGISTER.register(EVENT_BUS);

        ModItems.register();
        ModBlocks.register();
        ModEffects.register();
        ModShungiteEffects.register();

        ShungiteCrystalPropertiesLoot.Functions.ShungiteCrystalsLoot = registerFunction(
                new ShungiteCrystalPropertiesLoot.Serializer(),
                new ResourceLocation(ShungiteConstants.MOD_ID, "shungite_random_crystal")
        );
    }

    private static <T extends LootFunction> LootFunctionType registerFunction(LootFunction.Serializer<T> serializer, ResourceLocation key) {
        return LootFunctionManager.register(key.toString(), serializer);
    }
}
