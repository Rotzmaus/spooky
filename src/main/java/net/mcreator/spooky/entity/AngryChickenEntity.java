
package net.mcreator.spooky.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;
import net.minecraftforge.common.DungeonHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.spooky.procedures.AngryChickenParticleSpawningConditionProcedure;
import net.mcreator.spooky.procedures.AngryChickenEntityIsHurtProcedure;
import net.mcreator.spooky.procedures.AngryChickenDiesProcedure;
import net.mcreator.spooky.init.SpookyModEntities;

public class AngryChickenEntity extends Monster {
	public AngryChickenEntity(FMLPlayMessages.SpawnEntity packet, Level world) {
		this(SpookyModEntities.ANGRY_CHICKEN, world);
	}

	public AngryChickenEntity(EntityType<AngryChickenEntity> type, Level world) {
		super(type, world);
		xpReward = 1;
		setNoAi(false);
		setCustomName(new TextComponent("Chicken"));
		setCustomNameVisible(true);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.4, false));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.6));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers(this.getClass()));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level;
		Entity sourceentity = source.getEntity();

		AngryChickenEntityIsHurtProcedure.execute(entity);
		if (source.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (source.getMsgId().equals("trident"))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity sourceentity = source.getEntity();
		Entity entity = this;
		Level world = this.level;

		AngryChickenDiesProcedure.execute(world, sourceentity);
	}

	public void aiStep() {
		super.aiStep();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level;
		if (AngryChickenParticleSpawningConditionProcedure.execute(entity))
			for (int l = 0; l < 1; ++l) {
				double x0 = x + 0.5 + (random.nextFloat() - 0.5) * 1.000000001490116D;
				double y0 = y + 1.2 + (random.nextFloat() - 0.5) * 1.000000001490116D;
				double z0 = z + 0.5 + (random.nextFloat() - 0.5) * 1.000000001490116D;
				world.addParticle(ParticleTypes.WHITE_ASH, x0, y0, z0, 0, 0, 0);
			}
	}

	public static void init() {
		DungeonHooks.addDungeonMob(SpookyModEntities.ANGRY_CHICKEN, 180);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
		return builder;
	}
}
