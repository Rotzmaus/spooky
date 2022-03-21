
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spooky.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.spooky.client.renderer.SunflowerRenderer;
import net.mcreator.spooky.client.renderer.SpankyRenderer;
import net.mcreator.spooky.client.renderer.SandgoblinRenderer;
import net.mcreator.spooky.client.renderer.OstrichRenderer;
import net.mcreator.spooky.client.renderer.NatureEssenceRenderer;
import net.mcreator.spooky.client.renderer.MummyRenderer;
import net.mcreator.spooky.client.renderer.MummyDigAnimationRenderer;
import net.mcreator.spooky.client.renderer.GorilaRenderer;
import net.mcreator.spooky.client.renderer.GoatRenderer;
import net.mcreator.spooky.client.renderer.FishRenderer;
import net.mcreator.spooky.client.renderer.CweeperRenderer;
import net.mcreator.spooky.client.renderer.CactusRenderer;
import net.mcreator.spooky.client.renderer.BoarRenderer;
import net.mcreator.spooky.client.renderer.AnimeCowRenderer;
import net.mcreator.spooky.client.renderer.AngryChickenRenderer;
import net.mcreator.spooky.client.renderer.AmongusRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SpookyModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SpookyModEntities.SPANKY, SpankyRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.OSTRICH, OstrichRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.SANDGOBLIN, SandgoblinRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.MUMMY, MummyRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.CACTUS, CactusRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.CWEEPER, CweeperRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.ANGRY_CHICKEN, AngryChickenRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.MUMMY_DIG_ANIMATION, MummyDigAnimationRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.ANIME_COW, AnimeCowRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.GOAT, GoatRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.BOAR, BoarRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.GORILA, GorilaRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.SUNFLOWER, SunflowerRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.SUNFLOWER_PROJECTILE, ThrownItemRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.FISH, FishRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.AMONGUS, AmongusRenderer::new);
		event.registerEntityRenderer(SpookyModEntities.NATURE_ESSENCE, NatureEssenceRenderer::new);
	}
}
