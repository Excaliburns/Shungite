package moe.krp.shungite.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import moe.krp.shungite.loot.ApplyShungiteCrystalProperties;
import moe.krp.shungite.setup.ModBlocks;
import moe.krp.shungite.setup.Registration;
import moe.krp.shungite.setup.ModItems;
import net.minecraft.data.DataGenerator;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(Pair.of(ModBlockLootTables::new, LootContextParamSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationtracker) {
        map.forEach((one, two) -> LootTables.validate(validationtracker, one, two));
    }

    public static class ModBlockLootTables extends BlockLoot {
        @Override
        protected void addTables() {
            this.add(ModBlocks.SHUNGITE_CRYSTAL_ORE.get(), (block) ->
                    LootTable.lootTable()
                             .withPool(
                                     LootPool.lootPool()
                                             .setRolls(UniformGenerator.between(2F, 5F))
                                             .add(LootItem.lootTableItem(ModItems.SHUNGITE.get()))
                                             .apply(ApplyExplosionDecay.explosionDecay())
                                             .apply(ApplyShungiteCrystalProperties.builder())
                             )
            );
            this.add(ModBlocks.DEEPSLATE_SHUNGITE_CRYSTAL_ORE.get(), (block) ->
                    LootTable.lootTable()
                             .withPool(
                                     LootPool.lootPool()
                                             .setRolls(UniformGenerator.between(2F, 5F))
                                             .add(LootItem.lootTableItem(ModItems.SHUNGITE.get()))
                                             .apply(ApplyExplosionDecay.explosionDecay())
                                             .apply(ApplyShungiteCrystalProperties.builder())
                             )
            );
            this.add(ModBlocks.NETHERRACK_SHUNGITE_CRYSTAL_ORE.get(), (block) ->
                    LootTable.lootTable()
                             .withPool(
                                     LootPool.lootPool()
                                             .setRolls(UniformGenerator.between(3F, 7F))
                                             .add(LootItem.lootTableItem(ModItems.SHUNGITE.get()))
                                             .apply(ApplyExplosionDecay.explosionDecay())
                                             .apply(ApplyShungiteCrystalProperties.builder())
                             )
            );
            this.add(ModBlocks.END_SHUNGITE_CRYSTAL_ORE.get(), (block) ->
                    LootTable.lootTable()
                             .withPool(
                                     LootPool.lootPool()
                                             .setRolls(UniformGenerator.between(1F, 2F))
                                             .add(LootItem.lootTableItem(ModItems.SHUNGITE.get()))
                                             .apply(ApplyExplosionDecay.explosionDecay())
                                             .apply(ApplyShungiteCrystalProperties.builder())
                             )
            );
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return Registration.BLOCK_DEFERRED_REGISTER.getEntries().stream().map(RegistryObject::get).toList();
        }
    }
}
