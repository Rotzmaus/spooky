package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.spooky.entity.AmongusEntity;
import net.mcreator.spooky.client.model.Modelamogus;

public class AmongusRenderer extends MobRenderer<AmongusEntity, Modelamogus<AmongusEntity>> {
	public AmongusRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamogus(context.bakeLayer(Modelamogus.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(AmongusEntity entity) {
		return new ResourceLocation("spooky:textures/red.png");
	}
}
