package net.mcreator.spooky.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.init.SpookyModEntities;
import net.mcreator.spooky.entity.MummyEntity;

public class AltarRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (SpookyModVariables.WorldVariables.get(world).SummoningPower > 49) {
			if (SpookyModVariables.WorldVariables.get(world).SummoningPower <= 99) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new MummyEntity(SpookyModEntities.MUMMY, _level);
							entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()),
										MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 50);
				SpookyModVariables.WorldVariables.get(world).SummoningPower = SpookyModVariables.WorldVariables.get(world).SummoningPower - 50;
				SpookyModVariables.WorldVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("spooky", "sand_arena"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos((int) (x - 16), (int) (y - 1), (int) (z - 16)),
								new BlockPos((int) (x - 16), (int) (y - 1), (int) (z - 16)),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else {
				SpookyModVariables.WorldVariables.get(world).SummoningPower = 99;
				SpookyModVariables.WorldVariables.get(world).syncData(world);
			}
		}
	}
}
