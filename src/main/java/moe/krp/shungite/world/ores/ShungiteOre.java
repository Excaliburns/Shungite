package moe.krp.shungite.world.ores;

import java.util.List;
import moe.krp.shungite.world.filters.DimensionBiomeFilter;
import moe.krp.shungite.setup.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ShungiteOre {
  public static final int OVERWORLD_VEINSIZE = 5;
  public static final int OVERWORLD_AMOUNT = 3;
  public static final int DEEPSLATE_VEINSIZE = 5;
  public static final int DEEPSLATE_AMOUNT = 3;
  public static final int NETHER_VEINSIZE = 5;
  public static final int NETHER_AMOUNT = 3;
  public static final int END_VEINSIZE = 10;
  public static final int END_AMOUNT = 6;

  public static PlacedFeature createOverworldOregen() {
    OreConfiguration config = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SHUNGITE_CRYSTAL_ORE.get().defaultBlockState(), 5);
    return createPlacedFeature(
        new ConfiguredFeature<>(Feature.ORE, config),
        CountPlacement.of(3),
        InSquarePlacement.spread(),
        new DimensionBiomeFilter(key -> !Level.END.equals(key)),
        HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(90))
    );
  }

  private static <C extends FeatureConfiguration, F extends Feature<C>> PlacedFeature createPlacedFeature(ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
    return new PlacedFeature(Holder.hackyErase(Holder.direct(feature)), List.copyOf(List.of(placementModifiers)));
  }
}
