package net.mcreator.spooky.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GetBiomeTwoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new ResourceLocation("ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("river").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("deep_warm_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("lukewarm_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("deep_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("deep_cold_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("deep_lukewarm_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("cold_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("warm_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())) {
			SpawnWaterProcedure.execute(world, x, z, entity);
		} else if (new ResourceLocation("deep_frozen_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("frozen_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("frozen_river").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("giant_spruce_taiga").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("giant_spruce_taiga_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("giant_tree_taiga").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("giant_tree_taiga_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("ice_spikes").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("mountain_edge").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("mountains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_beach").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_mountains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_taiga").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_taiga_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_taiga_mountains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_tundra").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())) {
			SpawnColdPlacesProcedure.execute(world, x, z, entity);
		}
	}
}
