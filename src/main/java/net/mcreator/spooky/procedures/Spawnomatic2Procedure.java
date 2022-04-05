package net.mcreator.spooky.procedures;

import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.spooky.world.inventory.WaterSpawnomaticMenu;
import net.mcreator.spooky.world.inventory.ColdPlacesSpawnOMaticMenu;

import io.netty.buffer.Unpooled;

public class Spawnomatic2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new ResourceLocation("ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("river").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("deep_warm_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("lukewarm_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("deep_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("deep_cold_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("deep_lukewarm_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("cold_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("warm_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())) {
			if (entity instanceof Player _player)
				_player.closeContainer();
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
						if (entity instanceof ServerPlayer _ent) {
							BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
							NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return new TextComponent("WaterSpawnomatic");
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new WaterSpawnomaticMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 2);
		} else if (new ResourceLocation("deep_frozen_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("frozen_ocean").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("frozen_river").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("giant_spruce_taiga").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("giant_spruce_taiga_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("giant_tree_taiga").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("giant_tree_taiga_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("ice_spikes").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("mountain_edge").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("mountains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_beach").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_mountains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_taiga").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_taiga_hills").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_taiga_mountains").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())
				|| new ResourceLocation("snowy_tundra").equals(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName())) {
			if (entity instanceof Player _player)
				_player.closeContainer();
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
						if (entity instanceof ServerPlayer _ent) {
							BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
							NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return new TextComponent("ColdPlacesSpawnOMatic");
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new ColdPlacesSpawnOMaticMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 2);
		}
	}
}
