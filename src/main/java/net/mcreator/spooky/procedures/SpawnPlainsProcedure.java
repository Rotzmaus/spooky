package net.mcreator.spooky.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class SpawnPlainsProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		double randomNumber = 0;
		randomNumber = Math.random();
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActivePlainsLevel < 1) {
			if (randomNumber <= 0.7) {
				SpawnAngryChickenProcedure.execute(world, x, z);
			} else {
				SpawnAnimeCowProcedure.execute(world, x, z);
			}
		} else if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActivePlainsLevel < 2) {
			if (randomNumber <= 0.55) {
				SpawnAngryChickenProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.95) {
				CheckcustomhealthProcedure.execute(entity);
			} else {
				SpawnGoatProcedure.execute(world, x, z);
			}
		} else if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActivePlainsLevel < 3) {
			if (randomNumber <= 0.4) {
				SpawnAngryChickenProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.85) {
				SpawnAnimeCowProcedure.execute(world, x, z);
			} else if (randomNumber > 0.75) {
				SpawnGoatProcedure.execute(world, x, z);
			}
		} else {
			if (randomNumber <= 0.25) {
				SpawnAngryChickenProcedure.execute(world, x, z);
			} else if (randomNumber <= 0.6) {
				SpawnAnimeCowProcedure.execute(world, x, z);
			} else if (randomNumber > 0.6) {
				SpawnGoatProcedure.execute(world, x, z);
			}
		}
	}
}
