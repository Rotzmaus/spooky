package net.mcreator.spooky.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.init.SpookyModMobEffects;

public class BronzeSwordRightClickedInAirProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack pickaxe = ItemStack.EMPTY;
		double EnchtSize = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		boolean canDash = false;
		if ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SpookyModVariables.PlayerVariables())).CanLeap) {
			entity.setDeltaMovement((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.6), 0.7,
					(Math.cos(Math.toRadians(entity.getYRot())) * 1.6));
			{
				boolean _setval = false;
				entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CanLeap = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
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
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(SpookyModMobEffects.AIRBORN, 500, 1, (false), (false)));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 2);
		}
	}
}
