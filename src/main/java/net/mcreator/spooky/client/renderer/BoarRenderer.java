package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;

import net.mcreator.spooky.entity.BoarEntity;

public class BoarRenderer extends MobRenderer<BoarEntity, PigModel<BoarEntity>> {
	public BoarRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel(context.bakeLayer(ModelLayers.PIG)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BoarEntity entity) {
		return new ResourceLocation("spooky:textures/angry_pig.png");
	}
}
