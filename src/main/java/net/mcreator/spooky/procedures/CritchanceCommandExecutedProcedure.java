package net.mcreator.spooky.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class CritchanceCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0.3;
			entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CritChance = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
