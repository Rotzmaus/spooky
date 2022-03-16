// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelSunflower<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "sunflower"), "main");
	private final ModelPart Head;
	private final ModelPart stengel;
	private final ModelPart Leave;
	private final ModelPart Leave2;

	public ModelSunflower(ModelPart root) {
		this.Head = root.getChild("Head");
		this.stengel = root.getChild("stengel");
		this.Leave = root.getChild("Leave");
		this.Leave2 = root.getChild("Leave2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 8)
						.addBox(-5.0F, -33.0F, -4.0F, 10.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(32, 36)
						.addBox(-3.0F, -31.0F, -2.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(32, 10)
						.addBox(-4.0F, -32.0F, -5.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 0)
						.addBox(-3.0F, -31.0F, -6.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 31)
						.addBox(-3.0F, -35.0F, -3.901F, 6.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.0F, -31.0F, -3.9F, 14.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition stengel = partdefinition.addOrReplaceChild("stengel",
				CubeListBuilder.create().texOffs(26, 2)
						.addBox(-3.0F, -2.0F, -2.8F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(42, 46)
						.addBox(-1.5F, -27.0F, 2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition RightLeave2_r1 = stengel.addOrReplaceChild("RightLeave2_r1",
				CubeListBuilder.create().texOffs(0, 21).addBox(0.5F, -5.0F, -2.7F, 2.0F, 5.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -25.0F, 5.0F, 2.7489F, 0.9599F, 0.6109F));

		PartDefinition LeftLeave2_r1 = stengel.addOrReplaceChild("LeftLeave2_r1",
				CubeListBuilder.create().texOffs(15, 22).addBox(-1.5F, -4.0F, -0.7F, 2.0F, 5.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, -25.0F, 5.0F, 2.2253F, -0.8727F, -0.6981F));

		PartDefinition RightLeave_r1 = stengel.addOrReplaceChild("RightLeave_r1",
				CubeListBuilder.create().texOffs(17, 52).addBox(-2.0F, -9.0F, -4.5F, 2.0F, 8.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -27.0F, 2.0F, 1.6581F, 1.789F, 0.0F));

		PartDefinition LeftLeave_r1 = stengel.addOrReplaceChild("LeftLeave_r1",
				CubeListBuilder.create().texOffs(0, 53).addBox(0.0F, -8.0F, -4.5F, 2.0F, 8.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -27.0F, 2.0F, 1.3526F, -1.789F, 0.0F));

		PartDefinition cube_r1 = stengel.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(34, 45).addBox(-1.0F, -3.0F, -1.5F, 2.0F, 5.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -27.0F, 2.0F, 1.3526F, 0.0F, 0.0F));

		PartDefinition cube_r2 = stengel.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(16, 36).addBox(-2.0F, -11.0F, 0.4F, 4.0F, 11.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Basestump_r1 = stengel
				.addOrReplaceChild("Basestump_r1",
						CubeListBuilder.create().texOffs(24, 22).addBox(-2.5F, -10.0F, -2.5F, 5.0F, 9.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Leave = partdefinition.addOrReplaceChild("Leave",
				CubeListBuilder.create().texOffs(0, 21)
						.addBox(-1.0F, 0.0F, 1.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(24, 45)
						.addBox(2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(44, 21)
						.addBox(-2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(7, 48)
						.addBox(-3.0F, 0.0F, 2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 47)
						.addBox(3.0F, 0.0F, 2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(16, 31)
						.addBox(0.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(23, 9)
						.addBox(0.0F, 0.0F, 10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(11.0F, 0.0F, 2.0F, -1.6581F, -2.8362F, 0.0F));

		PartDefinition Leave2 = partdefinition.addOrReplaceChild("Leave2",
				CubeListBuilder.create().texOffs(17, 12)
						.addBox(-2.0F, -1.0F, 2.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(44, 12)
						.addBox(1.0F, -1.0F, 2.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(42, 37)
						.addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(44, 30)
						.addBox(-4.0F, -1.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(39, 21)
						.addBox(2.0F, -1.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(23, 22)
						.addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 22)
						.addBox(-1.0F, -1.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.0F, 3.0F, 3.0F, -2.2253F, -0.2182F, -0.48F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		stengel.render(poseStack, buffer, packedLight, packedOverlay);
		Leave.render(poseStack, buffer, packedLight, packedOverlay);
		Leave2.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}