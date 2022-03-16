package net.mcreator.spooky.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.spooky.init.SpookyModMobEffects;
import net.mcreator.spooky.init.SpookyModEntities;
import net.mcreator.spooky.entity.MummyDigAnimationEntity;

public class MummyEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double X = 0;
		double Z = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(SpookyModMobEffects.MUMMY_TICKS) : false) == false) {
			X = x + (Math.random() - 0.5) * 7;
			Z = z + (Math.random() - 0.5) * 7;
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(SpookyModMobEffects.MUMMY_TICKS, 100, 1, (false), (false)));
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MummyDigAnimationEntity(SpookyModEntities.MUMMY_DIG_ANIMATION, _level);
				entityToSpawn.moveTo(X, y, Z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}
}
