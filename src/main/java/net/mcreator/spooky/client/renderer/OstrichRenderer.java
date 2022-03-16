package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.spooky.entity.OstrichEntity;
import net.mcreator.spooky.client.model.Modelnewversionostrich;

public class OstrichRenderer extends MobRenderer<OstrichEntity, Modelnewversionostrich<OstrichEntity>> {
	public OstrichRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnewversionostrich(context.bakeLayer(Modelnewversionostrich.LAYER_LOCATION)), 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(OstrichEntity entity) {
		return new ResourceLocation("spooky:textures/ostrich.png");
	}
}
