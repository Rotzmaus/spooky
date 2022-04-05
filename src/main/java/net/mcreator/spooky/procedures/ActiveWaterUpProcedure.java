package net.mcreator.spooky.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class ActiveWaterUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).ActiveWaterLevel + 1;
			entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ActiveWaterLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
