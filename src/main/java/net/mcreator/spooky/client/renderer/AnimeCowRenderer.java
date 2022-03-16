package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

import net.mcreator.spooky.entity.AnimeCowEntity;

public class AnimeCowRenderer extends MobRenderer<AnimeCowEntity, CowModel<AnimeCowEntity>> {
	public AnimeCowRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AnimeCowEntity entity) {
		return new ResourceLocation("spooky:textures/anime_cow.png");
	}
}
