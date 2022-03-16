package net.mcreator.spooky.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.spooky.init.SpookyModEntities;
import net.mcreator.spooky.entity.BoarEntity;

public class SpawnBoarProcedure {
	public static void execute(LevelAccessor world, double x, double z) {
		double RandomX1 = 0;
		double RandomZ1 = 0;
		double RandomX2 = 0;
		double RandomZ2 = 0;
		double RandomX3 = 0;
		double RandomZ3 = 0;
		RandomX1 = x + (Math.random() - 0.5) * 70;
		RandomX2 = x + (Math.random() - 0.5) * 70;
		RandomX3 = x + (Math.random() - 0.5) * 70;
		RandomZ1 = z + (Math.random() - 0.5) * 70;
		RandomZ2 = z + (Math.random() - 0.5) * 70;
		RandomZ3 = z + (Math.random() - 0.5) * 70;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
			entityToSpawn.moveTo(RandomX1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX1, (int) RandomZ1) + 1), RandomZ1,
					world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
			entityToSpawn.moveTo(RandomX2, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX2, (int) RandomZ1) + 1), RandomZ1,
					world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
			entityToSpawn.moveTo(RandomX1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX1, (int) RandomZ2) + 1), RandomZ2,
					world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
			entityToSpawn.moveTo(RandomX2, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX2, (int) RandomZ2) + 1), RandomZ2,
					world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		if (Math.random() >= 0.6) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
				entityToSpawn.moveTo(RandomX1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX1, (int) RandomZ3) + 1),
						RandomZ3, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
				entityToSpawn.moveTo(RandomX2, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX2, (int) RandomZ3) + 1),
						RandomZ3, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
				entityToSpawn.moveTo(RandomX3, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX3, (int) RandomZ1) + 1),
						RandomZ1, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
				entityToSpawn.moveTo(RandomX3, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX3, (int) RandomZ2) + 1),
						RandomZ2, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
				entityToSpawn.moveTo(RandomX3, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX3, (int) RandomZ3) + 1),
						RandomZ3, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
			if (Math.random() >= 0.7) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
					entityToSpawn.moveTo(RandomX1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX1, (int) RandomZ1) + 1),
							RandomZ1, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
					entityToSpawn.moveTo(RandomX2, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX2, (int) RandomZ1) + 1),
							RandomZ1, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
					entityToSpawn.moveTo(RandomX1, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX1, (int) RandomZ2) + 1),
							RandomZ2, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new BoarEntity(SpookyModEntities.BOAR, _level);
					entityToSpawn.moveTo(RandomX2, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) RandomX2, (int) RandomZ2) + 1),
							RandomZ2, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
