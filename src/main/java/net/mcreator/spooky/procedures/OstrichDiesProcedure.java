package net.mcreator.spooky.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class OstrichDiesProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		{
			double _setval = (sourceentity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).playerEXP + 20;
			sourceentity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.playerEXP = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		{
			double _setval = (sourceentity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).HotPlacesExp + 6;
			sourceentity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HotPlacesExp = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		{
			boolean _setval = true;
			sourceentity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.OstrichKilled = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		CheckLevelUpProcedure.execute(world, sourceentity);
		CheckLevelUpHotPlacesProcedure.execute(world, sourceentity);
	}
}
