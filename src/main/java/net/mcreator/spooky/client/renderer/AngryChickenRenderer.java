package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.ChickenModel;

import net.mcreator.spooky.entity.AngryChickenEntity;

public class AngryChickenRenderer extends MobRenderer<AngryChickenEntity, ChickenModel<AngryChickenEntity>> {
	public AngryChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new ChickenModel(context.bakeLayer(ModelLayers.CHICKEN)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AngryChickenEntity entity) {
		return new ResourceLocation("spooky:textures/angry_chicken.png");
	}
}
