package org.tutmods.shungite.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import org.tutmods.shungite.loot.ShungiteCrystalPropertiesLoot;
import org.tutmods.shungite.setup.ModBlocks;
import org.tutmods.shungite.setup.ModItems;
import org.tutmods.shungite.setup.Registration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach( (one, two) -> LootTableManager.validate(validationtracker, one, two));
    }

   public static class ModBlockLootTables extends BlockLootTables {
       @Override
       protected void addTables() {
           this.add(ModBlocks.SHUNGITE_CRYSTAL_ORE.get(), (block) ->
                   LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                              .setRolls(RandomValueRange.between(2F, 5F))
                                              .add(ItemLootEntry.lootTableItem(ModItems.SHUNGITE.get())
                                                                .apply(ExplosionDecay.explosionDecay())
                                                                .apply(ShungiteCrystalPropertiesLoot.builder()))
                           ));
       }

       @Override
       protected Iterable<Block> getKnownBlocks() {
           return Registration.BLOCK_DEFERRED_REGISTER.getEntries()
                   .stream().map(RegistryObject::get).collect(Collectors.toList());
       }
   }
}
