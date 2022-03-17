package net.mcreator.spooky.procedures;

import net.minecraftforge.eventbus.api.Event;

public class AmongusRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (itemstack.getItem() == Items.PUFFERFISH && (itemstack.getDisplayName().getString()).equals("Puffi")) {
			if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
				_toTame.tame(_owner);
		}
		if (itemstack.getItem() == Items.COCOA_BEANS && (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt
				? _tamIsTamedBy.isOwnedBy(_livEnt)
				: false)) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.COCOA_BEANS);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 5));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HEART, x, y, z, 9, 1, 1, 1, 0.5);
		}
	}
}
