package net.mcreator.spooky.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class Frame18Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPoints
				/ (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPointsMax >= 0.85
				&& (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPoints
						/ (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPointsMax < 0.9;
	}
}
