package net.mcreator.spooky.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.spooky.init.SpookyModMobEffects;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class AdventureBlockRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player
						&& !(entityiterator instanceof LivingEntity _livEnt ? _livEnt.hasEffect(SpookyModMobEffects.ADVENTURE) : false)) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(SpookyModMobEffects.ADVENTURE, 500, 1, (false), (false)));
				}
			}
		}
		if (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.IRON_DOOR
				&& (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.IRON_DOOR
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.IRON_DOOR
				&& (world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.IRON_DOOR
				&& (world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.SMALL_AMETHYST_BUD)) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("spooky", "trap"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos((int) (x - 0.5), (int) y, (int) (z - 0.5)),
							new BlockPos((int) (x - 0.5), (int) y, (int) (z - 0.5)),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}
