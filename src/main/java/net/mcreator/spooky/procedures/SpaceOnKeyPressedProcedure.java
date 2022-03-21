package net.mcreator.spooky.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class SpaceOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).DoublejumpReady && !entity.isOnGround()) {
			if (entity.getDeltaMovement().y() > 0) {
				entity.setDeltaMovement((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 0.4), (entity.getDeltaMovement().z()));
				{
					boolean _setval = false;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DoublejumpReady = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (entity.getDeltaMovement().y() < 0) {
				entity.setDeltaMovement((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() / 4 + 0.5), (entity.getDeltaMovement().z()));
				{
					boolean _setval = false;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DoublejumpReady = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
