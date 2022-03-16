package net.mcreator.spooky.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class SpawnHotPlacewsProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		double randomNumber = 0;
		randomNumber = Math.random();
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).HotPlacesLevel <= 1) {
			if (randomNumber <= 0.8) {
				SpawnHotPlacesProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.9) {
				SpawnCreepyProcedure.execute(world, x, z);
			} else if (randomNumber > 0.9) {
				SpawnCactusSmallProcedure.execute(world, x, z);
			}
		} else if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).HotPlacesLevel <= 3) {
			if (randomNumber <= 0.7) {
				SpawnHotPlacesProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.85) {
				SpawnCreepyProcedure.execute(world, x, z);
			} else if (randomNumber > 0.85) {
				SpawnCactusSmallProcedure.execute(world, x, z);
			}
		} else if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).HotPlacesLevel <= 5) {
			if (randomNumber <= 0.5) {
				SpawnHotPlacesProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.8) {
				SpawnCreepyProcedure.execute(world, x, z);
			} else if (randomNumber > 0.8) {
				SpawnCactusSmallProcedure.execute(world, x, z);
			}
		} else {
			if (randomNumber <= 0.4) {
				SpawnHotPlacesProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.8) {
				SpawnCreepyProcedure.execute(world, x, z);
			} else if (randomNumber > 0.8) {
				SpawnCactusSmallProcedure.execute(world, x, z);
			}
		}
	}
}
