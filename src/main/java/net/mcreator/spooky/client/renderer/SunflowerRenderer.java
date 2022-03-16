package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.spooky.entity.SunflowerEntity;
import net.mcreator.spooky.client.model.ModelSunflower;

public class SunflowerRenderer extends MobRenderer<SunflowerEntity, ModelSunflower<SunflowerEntity>> {
	public SunflowerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSunflower(context.bakeLayer(ModelSunflower.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SunflowerEntity entity) {
		return new ResourceLocation("spooky:textures/sunflower.png");
	}
}
