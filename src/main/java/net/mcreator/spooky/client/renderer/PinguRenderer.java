package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.spooky.entity.PinguEntity;
import net.mcreator.spooky.client.model.Modelpingu;

public class PinguRenderer extends MobRenderer<PinguEntity, Modelpingu<PinguEntity>> {
	public PinguRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpingu(context.bakeLayer(Modelpingu.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(PinguEntity entity) {
		return new ResourceLocation("spooky:textures/pingu.png");
	}
}
