package moe.krp.shungite.world.filters;

import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class DimensionBiomeFilter extends PlacementFilter {

  private final Predicate<ResourceKey<Level>> levelTest;

  public DimensionBiomeFilter(Predicate<ResourceKey<Level>> levelTest) {
    this.levelTest = levelTest;
  }

  @Override
  protected boolean shouldPlace(PlacementContext pContext, RandomSource pRandom, BlockPos pPos) {
    if (levelTest.test(pContext.getLevel().getLevel().dimension())) {
      PlacedFeature feature = pContext.topFeature().orElseThrow(() -> new IllegalStateException("Tried to biome check an unregistered feature"));
      Holder<Biome> biome = pContext.getLevel().getBiome(pPos);
      return biome.value().getGenerationSettings().hasFeature(feature);
    }

    return false;
  }

  @Override
  public PlacementModifierType<?> type() {
    return PlacementModifierType.BIOME_FILTER;
  }
}
