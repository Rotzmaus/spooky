package net.mcreator.spooky.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GetBiomeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new ResourceLocation("badlands").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("badlands_plateau").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("desert").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("desert_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("desert_lakes").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("savanna").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("savanna_plateau").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("shattered_savanna").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("shattered_savanna_plateau").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("wooded_badlands_plateau").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("wooded_badlands_plateau")
						.equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())) {
			SpawnHotPlacewsProcedure.execute(world, x, z, entity);
		} else if (new ResourceLocation("flower_forest").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("plains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("stone_shore").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("sunflower_plains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("swamp").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("swamp_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())) {
			SpawnPlainsProcedure.execute(world, x, z, entity);
		} else if (new ResourceLocation("bamboo_jungle").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("bamboo_jungle_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("birch_forest").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("birch_forest_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("dark_forest").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("dark_forest_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("forest").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("wooded_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("jungle").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("jungle_edge").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("jungle_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("modified_jungle").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("modified_jungle_edge").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("taiga").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("taiga_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("taiga_mountains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("tall_birch_forest").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("tall_birch_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("wooded_mountains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())) {
			SpawnForestProcedure.execute(world, x, z, entity);
		} else {
			GetBiomeTwoProcedure.execute(world, x, y, z, entity);
		}
	}
}
