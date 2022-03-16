package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.spooky.entity.FishEntity;
import net.mcreator.spooky.client.model.Modelbigheadedfish;

public class FishRenderer extends MobRenderer<FishEntity, Modelbigheadedfish<FishEntity>> {
	public FishRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbigheadedfish(context.bakeLayer(Modelbigheadedfish.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(FishEntity entity) {
		return new ResourceLocation("spooky:textures/bigheadedfish.png");
	}
}
