package net.mcreator.spooky.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.spooky.init.SpookyModMobEffects;

public class AngryChickenEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setCustomName(new TextComponent("Angry Chicken"));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(SpookyModMobEffects.ENTITY_TICK, 300, 1, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0, (false), (false)));
	}
}
