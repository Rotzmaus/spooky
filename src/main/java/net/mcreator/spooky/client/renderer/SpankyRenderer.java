package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.ChickenModel;

import net.mcreator.spooky.entity.SpankyEntity;

public class SpankyRenderer extends MobRenderer<SpankyEntity, ChickenModel<SpankyEntity>> {
	public SpankyRenderer(EntityRendererProvider.Context context) {
		super(context, new ChickenModel(context.bakeLayer(ModelLayers.CHICKEN)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpankyEntity entity) {
		return new ResourceLocation("spooky:textures/spanky.png");
	}
}
