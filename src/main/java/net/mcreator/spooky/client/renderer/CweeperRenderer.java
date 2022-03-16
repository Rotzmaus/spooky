package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

import net.mcreator.spooky.entity.CweeperEntity;

public class CweeperRenderer extends MobRenderer<CweeperEntity, CreeperModel<CweeperEntity>> {
	public CweeperRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CweeperEntity entity) {
		return new ResourceLocation("spooky:textures/creepy.png");
	}
}
