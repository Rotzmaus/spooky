package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.spooky.entity.GorilaEntity;
import net.mcreator.spooky.client.model.Modelgorilla;

public class GorilaRenderer extends MobRenderer<GorilaEntity, Modelgorilla<GorilaEntity>> {
	public GorilaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgorilla(context.bakeLayer(Modelgorilla.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GorilaEntity entity) {
		return new ResourceLocation("spooky:textures/gorilla.png");
	}
}
