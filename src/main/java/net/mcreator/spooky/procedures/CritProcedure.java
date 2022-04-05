package net.mcreator.spooky.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.spooky.network.SpookyModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CritProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			execute(event, entity, event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double CritValue = 0;
		if (sourceentity instanceof Player) {
			if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
					.getDamageValue() > ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY))
							.getDamageValue()) {
				CritValue = ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue()
						* (sourceentity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SpookyModVariables.PlayerVariables())).CritDamageMulitplyer;
			} else {
				CritValue = ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).getDamageValue()
						* (sourceentity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SpookyModVariables.PlayerVariables())).CritDamageMulitplyer;
			}
			if ((sourceentity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SpookyModVariables.PlayerVariables())).CritChance >= Math.random()
					&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - CritValue > 15
					&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - CritValue > 15) {
				entity.hurt(DamageSource.GENERIC, (float) CritValue);
			}
		}
	}
}
