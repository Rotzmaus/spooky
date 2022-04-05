package net.mcreator.spooky.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.spooky.network.SpookyModVariables;

import java.util.function.Supplier;
import java.util.Map;

public class ConvertWaterDropsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ItemMultiplier = 0;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getItem() == Blocks.GRANITE_SLAB.asItem()) {
			ItemMultiplier = 5;
		} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.MAGMA_BLOCK.asItem()) {
			ItemMultiplier = 15;
		} else {
			ItemMultiplier = 0;
		}
		if (ItemMultiplier != 0) {
			{
				double _setval = (entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SpookyModVariables.PlayerVariables())).WaterExp + new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get()instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(0) * ItemMultiplier;
				entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.WaterExp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			CLUWaterNotSourceEntityProcedure.execute(world, entity);
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get()instanceof Map _slots) {
				((Slot) _slots.get(0)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
