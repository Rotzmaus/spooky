package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.spooky.entity.SandgoblinEntity;
import net.mcreator.spooky.client.model.ModelGoblin;

public class SandgoblinRenderer extends MobRenderer<SandgoblinEntity, ModelGoblin<SandgoblinEntity>> {
	public SandgoblinRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGoblin(context.bakeLayer(ModelGoblin.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SandgoblinEntity entity) {
		return new ResourceLocation("spooky:textures/sandgoblin.png");
	}
}
