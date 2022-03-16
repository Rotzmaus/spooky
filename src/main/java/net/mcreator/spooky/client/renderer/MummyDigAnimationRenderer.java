package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SilverfishModel;

import net.mcreator.spooky.entity.MummyDigAnimationEntity;

public class MummyDigAnimationRenderer extends MobRenderer<MummyDigAnimationEntity, SilverfishModel<MummyDigAnimationEntity>> {
	public MummyDigAnimationRenderer(EntityRendererProvider.Context context) {
		super(context, new SilverfishModel(context.bakeLayer(ModelLayers.SILVERFISH)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MummyDigAnimationEntity entity) {
		return new ResourceLocation("spooky:textures/empty.png");
	}
}
