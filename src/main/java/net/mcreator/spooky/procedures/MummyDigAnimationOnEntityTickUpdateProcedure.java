package net.mcreator.spooky.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.spooky.init.SpookyModParticles;

public class MummyDigAnimationOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(SpookyModParticles.SAND_DIG, x, y, z, 12, 0.2, 1.5, 0.2, 0.4);
	}
}
