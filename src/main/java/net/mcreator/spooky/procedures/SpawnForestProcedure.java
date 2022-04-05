package net.mcreator.spooky.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class SpawnForestProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		double randomNumber = 0;
		randomNumber = Math.random();
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActiveForestLevel <= 1) {
			if (randomNumber <= 0.8) {
				SpawnBoarProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.9) {
				SpawnGorillaProcedure.execute(world, x, z);
			} else if (randomNumber > 0.9) {
				SpawnGorillaProcedure.execute(world, x, z);
			}
		} else if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActiveForestLevel <= 3) {
			if (randomNumber <= 0.7) {
				SpawnBoarProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.8) {
				SpawnGorillaProcedure.execute(world, x, z);
			} else if (randomNumber > 0.8) {
				SpawnGorillaProcedure.execute(world, x, z);
			}
		} else if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActiveForestLevel <= 5) {
			if (randomNumber <= 0.6) {
				SpawnBoarProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.75) {
				SpawnGorillaProcedure.execute(world, x, z);
			} else if (randomNumber > 0.75) {
				SpawnGorillaProcedure.execute(world, x, z);
			}
		} else {
			if (randomNumber <= 0.5) {
				SpawnBoarProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.6) {
				SpawnGorillaProcedure.execute(world, x, z);
			} else if (randomNumber > 0.6) {
				SpawnGorillaProcedure.execute(world, x, z);
			}
		}
	}
}
