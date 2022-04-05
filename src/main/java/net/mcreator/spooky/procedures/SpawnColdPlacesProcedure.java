package net.mcreator.spooky.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class SpawnColdPlacesProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		double randomNumber = 0;
		randomNumber = Math.random();
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActiveCPLevel <= 1) {
			if (randomNumber <= 0.8) {
				SpawnPinguProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.9) {
				SpawnPinguProcedure.execute(world, x, z);
			} else if (randomNumber > 0.9) {
				SpawnPinguProcedure.execute(world, x, z);
			}
		} else if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActiveCPLevel <= 3) {
			if (randomNumber <= 0.7) {
				SpawnPinguProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.8) {
				SpawnPinguProcedure.execute(world, x, z);
			} else if (randomNumber > 0.8) {
				SpawnPinguProcedure.execute(world, x, z);
			}
		} else if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActiveCPLevel <= 5) {
			if (randomNumber <= 0.6) {
				SpawnPinguProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.75) {
				SpawnPinguProcedure.execute(world, x, z);
			} else if (randomNumber > 0.75) {
				SpawnPinguProcedure.execute(world, x, z);
			}
		} else {
			if (randomNumber <= 0.5) {
				SpawnPinguProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.6) {
				SpawnPinguProcedure.execute(world, x, z);
			} else if (randomNumber > 0.6) {
				SpawnPinguProcedure.execute(world, x, z);
			}
		}
	}
}
