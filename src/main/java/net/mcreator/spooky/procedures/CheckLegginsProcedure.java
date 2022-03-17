package net.mcreator.spooky.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.init.SpookyModItems;

public class CheckLegginsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double HelmetCalc = 0;
		double ChestplateCalcOn = 0;
		double LegginsCalcOn = 0;
		double BootsCalcOn = 0;
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SpookyModVariables.PlayerVariables())).Leggins) {
			if (!(entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).LegginsMathOn) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
						.getItem() == SpookyModItems.BRONZE_SET_LEGGINGS) {
					BronzeSetLegginsProcedure.execute(entity);
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
						.getItem() == SpookyModItems.DRUID_SET_LEGGINGS) {
					DruidSetLegginsProcedure.execute(entity);
				}
			}
		} else {
			if (!(entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).LegginsMathOff) {
				{
					double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPointsMax
							/ (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SpookyModVariables.PlayerVariables())).LegginsCalcOff;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.effectiveHealthPointsMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPoints
							/ (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SpookyModVariables.PlayerVariables())).LegginsCalcOff;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.effectiveHealthPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = true;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.LegginsMathOff = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = false;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.LegginsMathOn = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
