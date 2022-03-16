package net.mcreator.spooky.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.init.SpookyModItems;

public class CheckHelmetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double HelmetCalc = 0;
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SpookyModVariables.PlayerVariables())).Helmet) {
			if (!(entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).HelmetMatch) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
						.getItem() == SpookyModItems.BRONZE_SET_HELMET) {
					BronzeSetHelmetProcedure.execute(entity);
				}
			}
		} else {
			if (!(entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).HelmetMathOff) {
				{
					double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPointsMax
							/ (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SpookyModVariables.PlayerVariables())).HelmetCalcOff;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.effectiveHealthPointsMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPoints
							/ (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SpookyModVariables.PlayerVariables())).HelmetCalcOff;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.effectiveHealthPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = true;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HelmetMathOff = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = false;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HelmetMatch = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
