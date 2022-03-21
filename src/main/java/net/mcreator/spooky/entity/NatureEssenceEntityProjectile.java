
package net.mcreator.spooky.entity;

import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.protocol.Packet;

import net.mcreator.spooky.init.SpookyModItems;
import net.mcreator.spooky.init.SpookyModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class NatureEssenceEntityProjectile extends AbstractArrow implements ItemSupplier {
	public NatureEssenceEntityProjectile(FMLPlayMessages.SpawnEntity packet, Level world) {
		super(SpookyModEntities.NATURE_ESSENCE_PROJECTILE, world);
	}

	public NatureEssenceEntityProjectile(EntityType<? extends NatureEssenceEntityProjectile> type, Level world) {
		super(type, world);
	}

	public NatureEssenceEntityProjectile(EntityType<? extends NatureEssenceEntityProjectile> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public NatureEssenceEntityProjectile(EntityType<? extends NatureEssenceEntityProjectile> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void doPostHurtEffects(LivingEntity livingEntity) {
		super.doPostHurtEffects(livingEntity);
		livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(SpookyModItems.NATURAL_ESSENCE_PROJECTILE);
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(SpookyModItems.NATURAL_ESSENCE_PROJECTILE);
	}
}
