package net.mcreator.spooky.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class ActiveForestLevel6Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActiveForestLevel < 7
				&& (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SpookyModVariables.PlayerVariables())).ActiveForestLevel > 5;
	}
}
