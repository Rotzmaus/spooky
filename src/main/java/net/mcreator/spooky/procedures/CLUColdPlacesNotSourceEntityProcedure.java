package net.mcreator.spooky.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.network.SpookyModVariables;

public class CLUColdPlacesNotSourceEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ColdPLacesEXP >= (entity
						.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SpookyModVariables.PlayerVariables())).ColdPlacesEXPNeeded) {
			{
				double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SpookyModVariables.PlayerVariables())).ColdPLacesLevel + 1;
				entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ColdPLacesLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SpookyModVariables.PlayerVariables())).ColdPLacesEXP
						- (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SpookyModVariables.PlayerVariables())).ColdPlacesEXPNeeded;
				entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SafeHotPlacesExp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			ColdPlacesRTLUNotSourceEntityProcedure.execute(entity);
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
					{
						double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SpookyModVariables.PlayerVariables())).SafeHotPlacesExp;
						entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ColdPLacesEXP = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 3);
		}
	}
}
