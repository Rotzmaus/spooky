package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.spooky.entity.CactusEntity;
import net.mcreator.spooky.client.model.Modelcactus_small;

public class CactusRenderer extends MobRenderer<CactusEntity, Modelcactus_small<CactusEntity>> {
	public CactusRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcactus_small(context.bakeLayer(Modelcactus_small.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CactusEntity entity) {
		return new ResourceLocation("spooky:textures/cactus_model.png");
	}
}
