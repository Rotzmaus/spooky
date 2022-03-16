package net.mcreator.spooky.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelnewversionostrich<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("spooky", "modelnewversionostrich"), "main");
	public final ModelPart body2;
	public final ModelPart leftfoot2;
	public final ModelPart rightfoot2;
	public final ModelPart head2;

	public Modelnewversionostrich(ModelPart root) {
		this.body2 = root.getChild("body2");
		this.leftfoot2 = root.getChild("leftfoot2");
		this.rightfoot2 = root.getChild("rightfoot2");
		this.head2 = root.getChild("head2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body2 = partdefinition.addOrReplaceChild(
				"body2", CubeListBuilder.create().texOffs(66, 0).addBox(-7.5F, -22.0F, -8.0F, 15.0F, 9.0F, 16.0F, new CubeDeformation(0.0F))
						.texOffs(78, 47).addBox(-6.5F, -24.0F, -6.0F, 13.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition leftfoot2 = partdefinition.addOrReplaceChild("leftfoot2", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition leftfoot_r1 = leftfoot2.addOrReplaceChild("leftfoot_r1",
				CubeListBuilder.create().texOffs(0, 111).addBox(1.01F, -15.0F, -5.01F, 1.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(112, 125)
						.addBox(-5.0F, -1.0F, -5.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r1 = leftfoot2.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(112, 125).addBox(-3.0F, -0.99F, -4.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -1.0472F, 0.0F));
		PartDefinition cube_r2 = leftfoot2.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(112, 125).addBox(-7.0F, -1.01F, -5.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -2.0944F, 0.0F));
		PartDefinition rightfoot2 = partdefinition.addOrReplaceChild("rightfoot2", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition rightfoot_r1 = rightfoot2.addOrReplaceChild("rightfoot_r1",
				CubeListBuilder.create().texOffs(0, 111).addBox(1.01F, -15.0F, 3.01F, 1.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(112, 125)
						.addBox(-5.0F, -1.01F, 3.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r3 = rightfoot2.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(112, 125).addBox(-3.0F, -1.001F, 2.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -2.0944F, 0.0F));
		PartDefinition cube_r4 = rightfoot2.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(112, 125).addBox(-7.0F, -1.0F, 3.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -1.0472F, 0.0F));
		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -6.0F));
		PartDefinition lowerbear_r1 = head2.addOrReplaceChild("lowerbear_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.5F, -5.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.5F, -3.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition upper_r1 = head2.addOrReplaceChild("upper_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.5F, -5.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.5F, -3.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition righteye_r1 = head2.addOrReplaceChild("righteye_r1",
				CubeListBuilder.create().texOffs(24, 36).addBox(-7.0F, 23.0F, -8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 30)
						.addBox(-7.0F, 23.0F, -4.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 21.0F, 1.0F, 3.1416F, -1.5708F, 0.0F));
		PartDefinition head_r1 = head2.addOrReplaceChild("head_r1",
				CubeListBuilder.create().texOffs(51, 61).addBox(-6.0F, -3.0F, 2.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -2.0F, 1.0F, 0.0F, -1.5708F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		body2.render(poseStack, buffer, packedLight, packedOverlay);
		leftfoot2.render(poseStack, buffer, packedLight, packedOverlay);
		rightfoot2.render(poseStack, buffer, packedLight, packedOverlay);
		head2.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightfoot2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftfoot2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.head2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head2.xRot = headPitch / (180F / (float) Math.PI);
	}
}
