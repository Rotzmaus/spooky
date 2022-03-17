
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spooky.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.spooky.entity.SunflowerEntityProjectile;
import net.mcreator.spooky.entity.SunflowerEntity;
import net.mcreator.spooky.entity.SpankyEntity;
import net.mcreator.spooky.entity.SandgoblinEntity;
import net.mcreator.spooky.entity.OstrichEntity;
import net.mcreator.spooky.entity.MummyEntity;
import net.mcreator.spooky.entity.MummyDigAnimationEntity;
import net.mcreator.spooky.entity.HuiiiEntity;
import net.mcreator.spooky.entity.GorilaEntity;
import net.mcreator.spooky.entity.GoatEntity;
import net.mcreator.spooky.entity.FishEntity;
import net.mcreator.spooky.entity.CweeperEntity;
import net.mcreator.spooky.entity.CactusEntity;
import net.mcreator.spooky.entity.BoarEntity;
import net.mcreator.spooky.entity.AnimeCowEntity;
import net.mcreator.spooky.entity.AngryChickenEntity;
import net.mcreator.spooky.entity.AfasfafafafaffEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpookyModEntities {
	private static final List<EntityType<?>> REGISTRY = new ArrayList<>();
	public static final EntityType<SpankyEntity> SPANKY = register("spanky",
			EntityType.Builder.<SpankyEntity>of(SpankyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(SpankyEntity::new).sized(0.4f, 0.7f));
	public static final EntityType<OstrichEntity> OSTRICH = register("ostrich",
			EntityType.Builder.<OstrichEntity>of(OstrichEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(OstrichEntity::new).sized(1f, 1.5999999999999999f));
	public static final EntityType<SandgoblinEntity> SANDGOBLIN = register("sandgoblin",
			EntityType.Builder.<SandgoblinEntity>of(SandgoblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SandgoblinEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<MummyEntity> MUMMY = register("mummy",
			EntityType.Builder.<MummyEntity>of(MummyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(MummyEntity::new).fireImmune().sized(0.6f, 1.95f));
	public static final EntityType<CactusEntity> CACTUS = register("cactus",
			EntityType.Builder.<CactusEntity>of(CactusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(CactusEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<CweeperEntity> CWEEPER = register("cweeper",
			EntityType.Builder.<CweeperEntity>of(CweeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(CweeperEntity::new).sized(0.6f, 1.7f));
	public static final EntityType<AngryChickenEntity> ANGRY_CHICKEN = register("angry_chicken",
			EntityType.Builder.<AngryChickenEntity>of(AngryChickenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AngryChickenEntity::new).sized(0.4f, 0.7f));
	public static final EntityType<MummyDigAnimationEntity> MUMMY_DIG_ANIMATION = register("mummy_dig_animation",
			EntityType.Builder.<MummyDigAnimationEntity>of(MummyDigAnimationEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(MummyDigAnimationEntity::new).fireImmune().sized(0.5f, 0.5f));
	public static final EntityType<AnimeCowEntity> ANIME_COW = register("anime_cow",
			EntityType.Builder.<AnimeCowEntity>of(AnimeCowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(AnimeCowEntity::new).fireImmune().sized(0.9f, 1.4f));
	public static final EntityType<GoatEntity> GOAT = register("goat",
			EntityType.Builder.<GoatEntity>of(GoatEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(GoatEntity::new).fireImmune().sized(0.9f, 1.4f));
	public static final EntityType<BoarEntity> BOAR = register("boar",
			EntityType.Builder.<BoarEntity>of(BoarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(BoarEntity::new).fireImmune().sized(0.9f, 0.9f));
	public static final EntityType<GorilaEntity> GORILA = register("gorila",
			EntityType.Builder.<GorilaEntity>of(GorilaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(GorilaEntity::new).fireImmune().sized(1.2000000000000002f, 1.8f));
	public static final EntityType<SunflowerEntity> SUNFLOWER = register("sunflower",
			EntityType.Builder.<SunflowerEntity>of(SunflowerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SunflowerEntity::new).fireImmune().sized(0.7f, 2.5f));
	public static final EntityType<SunflowerEntityProjectile> SUNFLOWER_PROJECTILE = register("entitybulletsunflower",
			EntityType.Builder.<SunflowerEntityProjectile>of(SunflowerEntityProjectile::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(SunflowerEntityProjectile::new).sized(0.5f, 0.5f));
	public static final EntityType<FishEntity> FISH = register("fish",
			EntityType.Builder.<FishEntity>of(FishEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(FishEntity::new).fireImmune().sized(1f, 1f));
	public static final EntityType<HuiiiEntity> HUIII = register("huiii",
			EntityType.Builder.<HuiiiEntity>of(HuiiiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(HuiiiEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<AfasfafafafaffEntity> AFASFAFAFAFAFF = register("afasfafafafaff",
			EntityType.Builder.<AfasfafafafaffEntity>of(AfasfafafafaffEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AfasfafafafaffEntity::new).sized(0.4f, 0.7f));

	private static <T extends Entity> EntityType<T> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		EntityType<T> entityType = (EntityType<T>) entityTypeBuilder.build(registryname).setRegistryName(registryname);
		REGISTRY.add(entityType);
		return entityType;
	}

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new EntityType[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SpankyEntity.init();
			OstrichEntity.init();
			SandgoblinEntity.init();
			MummyEntity.init();
			CactusEntity.init();
			CweeperEntity.init();
			AngryChickenEntity.init();
			MummyDigAnimationEntity.init();
			AnimeCowEntity.init();
			GoatEntity.init();
			BoarEntity.init();
			GorilaEntity.init();
			SunflowerEntity.init();
			FishEntity.init();
			HuiiiEntity.init();
			AfasfafafafaffEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SPANKY, SpankyEntity.createAttributes().build());
		event.put(OSTRICH, OstrichEntity.createAttributes().build());
		event.put(SANDGOBLIN, SandgoblinEntity.createAttributes().build());
		event.put(MUMMY, MummyEntity.createAttributes().build());
		event.put(CACTUS, CactusEntity.createAttributes().build());
		event.put(CWEEPER, CweeperEntity.createAttributes().build());
		event.put(ANGRY_CHICKEN, AngryChickenEntity.createAttributes().build());
		event.put(MUMMY_DIG_ANIMATION, MummyDigAnimationEntity.createAttributes().build());
		event.put(ANIME_COW, AnimeCowEntity.createAttributes().build());
		event.put(GOAT, GoatEntity.createAttributes().build());
		event.put(BOAR, BoarEntity.createAttributes().build());
		event.put(GORILA, GorilaEntity.createAttributes().build());
		event.put(SUNFLOWER, SunflowerEntity.createAttributes().build());
		event.put(FISH, FishEntity.createAttributes().build());
		event.put(HUIII, HuiiiEntity.createAttributes().build());
		event.put(AFASFAFAFAFAFF, AfasfafafafaffEntity.createAttributes().build());
	}
}
