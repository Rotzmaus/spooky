package net.mcreator.spooky.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.spooky.entity.NatureEssenceEntity;
import net.mcreator.spooky.client.model.Modelnatureessence;

public class NatureEssenceRenderer extends MobRenderer<NatureEssenceEntity, Modelnatureessence<NatureEssenceEntity>> {
	public NatureEssenceRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnatureessence(context.bakeLayer(Modelnatureessence.LAYER_LOCATION)), 0.4f);
		this.addLayer(new EyesLayer<NatureEssenceEntity, Modelnatureessence<NatureEssenceEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("spooky:textures/natureessence.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(NatureEssenceEntity entity) {
		return new ResourceLocation("spooky:textures/natureessence.png");
	}
}
