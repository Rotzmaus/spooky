package net.mcreator.spooky.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.init.SpookyModItems;

public class CheckChestplateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double HelmetCalc = 0;
		double ChestplateCalcOn = 0;
		double LegginsCalcOn = 0;
		double BootsCalcOn = 0;
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).Chestplate) {
			if (!(entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).ChestplateMathOn) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.getItem() == SpookyModItems.BRONZE_SET_CHESTPLATE) {
					BronzeSetChesplateProcedure.execute(entity);
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.getItem() == SpookyModItems.BRONZE_SET_AUG_CHESTPLATE) {
					AugBronzeSetChesplateProcedure.execute(entity);
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.getItem() == SpookyModItems.DRUID_SET_CHESTPLATE) {
					DruidSetChestplateProcedure.execute(entity);
				}
			}
		} else {
			if (!(entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).ChestplateMathOff) {
				{
					double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPointsMax
							/ (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SpookyModVariables.PlayerVariables())).ChestplateCalcOff;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.effectiveHealthPointsMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPoints
							/ (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SpookyModVariables.PlayerVariables())).ChestplateCalcOff;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.effectiveHealthPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = true;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChestplateMathOff = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = false;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChestplateMathOn = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
