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
public class ModelGoblin<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("spooky", "model_goblin"), "main");
	public final ModelPart Head;
	public final ModelPart body;
	public final ModelPart leftleg;
	public final ModelPart rightleg;
	public final ModelPart lefthand;
	public final ModelPart righthand;

	public ModelGoblin(ModelPart root) {
		this.Head = root.getChild("Head");
		this.body = root.getChild("body");
		this.leftleg = root.getChild("leftleg");
		this.rightleg = root.getChild("rightleg");
		this.lefthand = root.getChild("lefthand");
		this.righthand = root.getChild("righthand");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(24, 21).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(24, 16)
						.addBox(-3.0F, -5.0F, -6.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0873F, 0.0436F, 0.1309F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(40, 61).addBox(-7.0F, -28.5F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 62)
						.mirror().addBox(-8.0F, -28.5F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(54, 60).mirror()
						.addBox(-6.0F, -28.5F, -7.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-9.895F, 21.0172F, 8.6583F, 0.1745F, 0.2182F, 0.48F));
		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(48, 62).addBox(7.0F, -29.5F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 61)
						.mirror().addBox(6.0F, -29.5F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(54, 60)
						.addBox(2.0F, -29.5F, -7.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.3164F, 21.9081F, 8.8278F, 0.1745F, -0.2182F, -0.48F));
		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 27).addBox(-2.99F, -0.2F, -7.0F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(29, 8).addBox(-3.0F, -2.0F, -7.0F, 7.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 2.0F, 0.0436F, 0.0873F, 0.0F));
		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 13).addBox(-5.0F, 0.0F, -4.0F, 9.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -19.0F, 0.0F, 0.0873F, 0.0873F, 0.0F));
		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -21.0F, 0.0F, 0.1745F, 0.1309F, 0.0436F));
		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(44, 46).mirror()
				.addBox(-5.7F, 11.0F, -4.8F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 11.0F, 0.0F));
		PartDefinition cube_r7 = leftleg.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 55).addBox(-5.0F, -1.2F, -4.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.3491F, 0.0873F, 0.0F));
		PartDefinition cube_r8 = leftleg
				.addOrReplaceChild(
						"cube_r8", CubeListBuilder.create().texOffs(20, 53).mirror()
								.addBox(-5.0F, -1.0F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
						PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.3927F, 0.1745F, 0.0436F));
		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg",
				CubeListBuilder.create().texOffs(44, 46).addBox(0.7F, 11.0F, -4.8F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 11.0F, 0.0F));
		PartDefinition cube_r9 = rightleg
				.addOrReplaceChild(
						"cube_r9", CubeListBuilder.create().texOffs(0, 55).mirror()
								.addBox(1.0F, -1.2F, -4.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
						PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.3491F, -0.0873F, 0.0F));
		PartDefinition cube_r10 = rightleg.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(20, 53).addBox(0.0F, -1.0F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.3927F, -0.1309F, 0.0F));
		PartDefinition lefthand = partdefinition.addOrReplaceChild("lefthand", CubeListBuilder.create(), PartPose.offset(4.0F, 3.0F, -3.0F));
		PartDefinition cube_r11 = lefthand.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(12, 35).addBox(-2.0F, -1.8F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, 7.0F, 0.0F, 1.309F, 0.3491F, 0.1309F));
		PartDefinition cube_r12 = lefthand.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(27, 0).addBox(-2.0F, -0.8F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, 7.0F, 0.0F, 0.829F, -0.4363F, 0.1309F));
		PartDefinition cube_r13 = lefthand
				.addOrReplaceChild(
						"cube_r13", CubeListBuilder.create().texOffs(45, 29).mirror()
								.addBox(1.0F, -1.0F, -3.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
						PartPose.offsetAndRotation(5.0F, 2.0F, 3.0F, 0.0873F, 0.3491F, 1.309F));
		PartDefinition cube_r14 = lefthand.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(16, 40).addBox(-1.4F, -2.5F, -4.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 3.0F, -0.0436F, -0.1309F, 0.7854F));
		PartDefinition righthand = partdefinition.addOrReplaceChild("righthand", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, -3.0F));
		PartDefinition cube_r15 = righthand.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(52, 15).addBox(0.0F, -2.0F, 0.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(47, 0)
						.addBox(0.0F, 2.0F, 1.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(53, 0)
						.addBox(0.0F, 2.0F, 2.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(60, 10)
						.addBox(0.0F, 2.0F, 3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(60, 0).addBox(0.0F, 2.0F, 4.0F, 1.0F, 3.0F,
								1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, 9.0F, -1.0F, -1.7453F, 0.0F, 0.0F));
		PartDefinition cube_r16 = righthand
				.addOrReplaceChild(
						"cube_r16", CubeListBuilder.create().texOffs(12, 35).mirror()
								.addBox(1.0F, -0.8F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
						PartPose.offsetAndRotation(-6.0F, 8.0F, 0.0F, 1.309F, 0.3491F, -0.2618F));
		PartDefinition cube_r17 = righthand
				.addOrReplaceChild(
						"cube_r17", CubeListBuilder.create().texOffs(27, 0).mirror()
								.addBox(-1.0F, 0.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
						PartPose.offsetAndRotation(-6.0F, 8.0F, 0.0F, 1.1781F, 1.3526F, 0.2182F));
		PartDefinition cube_r18 = righthand.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(45, 29).addBox(-6.0F, -1.0F, -3.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 3.0F, 3.0F, 0.0873F, -0.3491F, -1.309F));
		PartDefinition cube_r19 = righthand
				.addOrReplaceChild(
						"cube_r19", CubeListBuilder.create().texOffs(16, 40).mirror()
								.addBox(-4.6F, -3.5F, -4.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
						PartPose.offsetAndRotation(0.0F, 1.0F, 3.0F, 0.0436F, 0.1309F, -0.7854F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		leftleg.render(poseStack, buffer, packedLight, packedOverlay);
		rightleg.render(poseStack, buffer, packedLight, packedOverlay);
		lefthand.render(poseStack, buffer, packedLight, packedOverlay);
		righthand.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.lefthand.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightleg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftleg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.righthand.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
