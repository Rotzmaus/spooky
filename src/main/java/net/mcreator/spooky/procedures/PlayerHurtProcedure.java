package net.mcreator.spooky.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.init.SpookyModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerHurtProcedure {
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
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(SpookyModMobEffects.PLAYER) : false) {
			if ((sourceentity.getDisplayName().getString()).equals("Chicken") || (sourceentity.getDisplayName().getString()).equals("Angry Chicken")
					|| (sourceentity.getDisplayName().getString()).equals("spanky")
					|| (sourceentity.getDisplayName().getString()).equals("Nature Essence")
					|| (sourceentity.getDisplayName().getString()).equals("ostrich") || (sourceentity.getDisplayName().getString()).equals("Boar")) {
				{
					double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPoints - 1;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.effectiveHealthPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2, (false), (false)));
			} else if ((sourceentity.getDisplayName().getString()).equals("Mummy") || (sourceentity.getDisplayName().getString()).equals("cweepy")
					|| (sourceentity.getDisplayName().getString()).equals("kawaii cow")) {
				{
					double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPoints - 2;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.effectiveHealthPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2, (false), (false)));
			} else if ((sourceentity.getDisplayName().getString()).equals("Goat")
					|| (sourceentity.getDisplayName().getString()).equals("Sandy Goblin")
					|| (sourceentity.getDisplayName().getString()).equals("Sandy Goblin")
					|| (sourceentity.getDisplayName().getString()).equals("Sunflower")) {
				{
					double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPoints - 3;
					entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.effectiveHealthPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2, (false), (false)));
			}
		}
	}
}
