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
public class Modelgorilla<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("spooky", "modelgorilla"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart dick;
	public final ModelPart leftleg;
	public final ModelPart rightleg;
	public final ModelPart leftarm;
	public final ModelPart rightarm;

	public Modelgorilla(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.dick = root.getChild("dick");
		this.leftleg = root.getChild("leftleg");
		this.rightleg = root.getChild("rightleg");
		this.leftarm = root.getChild("leftarm");
		this.rightarm = root.getChild("rightarm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(13, 50).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 7)
						.addBox(-4.0F, -6.0F, -6.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(53, 2)
						.addBox(-4.0F, -6.5F, -7.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 2)
						.addBox(1.0F, -6.5F, -7.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 50)
						.addBox(-8.0F, -7.5F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 50).addBox(4.0F, -7.5F, -3.0F, 4.0F,
								5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 7.0F, -11.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition rightcheek_r1 = body.addOrReplaceChild("rightcheek_r1",
				CubeListBuilder.create().texOffs(46, 44).addBox(0.1F, -2.0F, -2.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -14.0F, 12.0F, -0.2182F, 0.1309F, 0.0F));
		PartDefinition leftcheek_r1 = body.addOrReplaceChild("leftcheek_r1",
				CubeListBuilder.create().texOffs(46, 44).addBox(-6.1F, -2.0F, -2.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -14.0F, 12.0F, -0.2182F, -0.1745F, 0.0F));
		PartDefinition outer_r1 = body.addOrReplaceChild("outer_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -16.0F, 11.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, -14.0F, 10.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.309F, 0.0F, 0.0F));
		PartDefinition dick = partdefinition.addOrReplaceChild("dick",
				CubeListBuilder.create().texOffs(0, 60).addBox(-2.0F, -8.0F, 3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = dick.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 48).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -10.0F, 4.0F, -1.4399F, 0.0F, 0.0F));
		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg",
				CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.0F, -3.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.0F, 10.0F, -6.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.0F, 11.0F, -8.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, 10.0F, -8.0F, 2.0F,
								2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 12.0F, 7.0F, 0.0F, -0.1745F, 0.0F));
		PartDefinition cube_r2 = leftleg.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 6.0F, -2.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r3 = leftleg.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 5.0F, 1.0F, -0.5672F, 0.0F, 0.0F));
		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -3.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, 9.0F, -6.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(2.0F, 9.0F, -8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.0F, 10.0F, -8.0F, 3.0F, 1.0F,
								2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 13.0F, 7.0F, 0.0F, 0.1309F, 0.0F));
		PartDefinition cube_r4 = rightleg.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, 5.0F, -2.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r5 = rightleg.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -2.0F, -3.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, 4.0F, 1.0F, -0.5672F, 0.0F, 0.0F));
		PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create(),
				PartPose.offsetAndRotation(5.0F, 5.0F, -8.0F, -0.0436F, 0.0436F, 0.0F));
		PartDefinition unterarm_r1 = leftarm.addOrReplaceChild("unterarm_r1",
				CubeListBuilder.create().texOffs(20, 37).addBox(-0.3F, 9.25F, 4.0F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, -0.48F, 0.0436F, 0.0349F));
		PartDefinition oberarm_r1 = leftarm.addOrReplaceChild("oberarm_r1",
				CubeListBuilder.create().texOffs(28, 0).addBox(-0.3F, 4.0F, -5.0F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 0.3491F, 0.0436F, 0.0436F));
		PartDefinition schulter_r1 = leftarm.addOrReplaceChild("schulter_r1",
				CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -1.5F, -5.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 0.2182F, 0.0873F, 0.0F));
		PartDefinition hand = leftarm.addOrReplaceChild("hand",
				CubeListBuilder.create().texOffs(37, 31).addBox(-1.3F, 18.0F, -6.5F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(38, 39)
						.addBox(-1.3F, 19.0F, -9.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(43, 0)
						.addBox(-0.3F, 19.0F, -8.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -1.0F, 1.0F));
		PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create(), PartPose.offset(-5.0F, 6.0F, -8.0F));
		PartDefinition unterarm_r2 = rightarm.addOrReplaceChild("unterarm_r2",
				CubeListBuilder.create().texOffs(23, 23).addBox(-5.4F, 9.25F, 4.0F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.48F, 0.0436F, -0.0524F));
		PartDefinition oberarm_r2 = rightarm.addOrReplaceChild("oberarm_r2",
				CubeListBuilder.create().texOffs(0, 28).addBox(-5.3F, 4.0F, -5.0F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, 0.3491F, -0.0436F, -0.0436F));
		PartDefinition schulter_r2 = rightarm.addOrReplaceChild("schulter_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -1.5F, -5.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, 0.2182F, -0.0873F, 0.0F));
		PartDefinition hand2 = rightarm.addOrReplaceChild("hand2",
				CubeListBuilder.create().texOffs(28, 14).addBox(-14.3F, 18.0F, -6.5F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(38, 22)
						.addBox(-14.3F, 19.0F, -9.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 42)
						.addBox(-13.3F, 19.0F, -8.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(10.0F, -2.0F, 1.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		dick.render(poseStack, buffer, packedLight, packedOverlay);
		leftleg.render(poseStack, buffer, packedLight, packedOverlay);
		rightleg.render(poseStack, buffer, packedLight, packedOverlay);
		leftarm.render(poseStack, buffer, packedLight, packedOverlay);
		rightarm.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.dick.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.dick.xRot = headPitch / (180F / (float) Math.PI);
		this.rightleg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftleg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
