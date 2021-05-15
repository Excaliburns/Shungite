package org.tutmods.shungite.world;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import org.tutmods.shungite.setup.ModBlocks;

public class ShungiteOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event){
        generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                        ModBlocks.SHUNGITE_CRYSTAL_ORE.get().defaultBlockState(), 4, 0, 10, 2);
    }
    private static void generateOre(final BiomeGenerationSettingsBuilder settings, final RuleTest fillerType, final BlockState state,
                                    final int veinSize, final int minHeight, final int maxHeight, final int amount) {
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreFeatureConfig(fillerType, state, veinSize))
                        .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                        .squared().count(amount));
    }

}
