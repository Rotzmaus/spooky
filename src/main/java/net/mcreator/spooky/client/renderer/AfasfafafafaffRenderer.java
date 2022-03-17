package net.mcreator.spooky.client.renderer;

public class AfasfafafafaffRenderer extends MobRenderer<AfasfafafafaffEntity, ChickenModel<AfasfafafafaffEntity>> {

	public AfasfafafafaffRenderer(EntityRendererProvider.Context context) {
		super(context, new ChickenModel(context.bakeLayer(ModelLayers.CHICKEN)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(AfasfafafafaffEntity entity) {
		return new ResourceLocation("spooky:textures/angelicdust.png");
	}

}
