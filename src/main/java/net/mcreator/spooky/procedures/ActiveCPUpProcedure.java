package net.mcreator.spooky.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class ActiveCPUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).ActiveCPLevel + 1;
			entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ActiveCPLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
