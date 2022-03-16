package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import net.mcreator.spooky.entity.MummyEntity;

public class MummyRenderer extends MobRenderer<MummyEntity, VillagerModel<MummyEntity>> {
	public MummyRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MummyEntity entity) {
		return new ResourceLocation("spooky:textures/mummy.png");
	}
}
