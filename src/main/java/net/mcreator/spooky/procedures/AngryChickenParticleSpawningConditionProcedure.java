package net.mcreator.spooky.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.init.SpookyModMobEffects;

public class AngryChickenParticleSpawningConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(SpookyModMobEffects.ENTITY_TICK) : false;
	}
}
