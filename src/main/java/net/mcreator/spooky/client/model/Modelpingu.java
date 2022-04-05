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
public class Modelpingu<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("spooky", "modelpingu"), "main");
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart leftwing;
	public final ModelPart rightwing;
	public final ModelPart stubbylegs;
	public final ModelPart rightlegs;

	public Modelpingu(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.leftwing = root.getChild("leftwing");
		this.rightwing = root.getChild("rightwing");
		this.stubbylegs = root.getChild("stubbylegs");
		this.rightlegs = root.getChild("rightlegs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -3.0F, 8.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition beak_r1 = head.addOrReplaceChild("beak_r1",
				CubeListBuilder.create().texOffs(28, 7).addBox(-1.0F, -11.0F, 3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.0F, -15.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 3).addBox(-2.0F, -14.0F, 4.0F, 2.0F, 2.0F,
								1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(24, 12).addBox(-2.0F, -14.0F, 0.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));
		PartDefinition leftwing = partdefinition.addOrReplaceChild("leftwing", CubeListBuilder.create(), PartPose.offset(5.0F, 14.0F, 0.0F));
		PartDefinition leftwing_r1 = leftwing.addOrReplaceChild("leftwing_r1",
				CubeListBuilder.create().texOffs(0, 16).addBox(-6.0F, -11.0F, -2.0F, 2.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 10.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition rightwing = partdefinition.addOrReplaceChild("rightwing", CubeListBuilder.create(), PartPose.offset(-5.0F, 14.0F, 0.0F));
		PartDefinition rightwing_r1 = rightwing.addOrReplaceChild("rightwing_r1",
				CubeListBuilder.create().texOffs(12, 16).addBox(4.0F, -11.0F, -2.0F, 2.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 10.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition stubbylegs = partdefinition.addOrReplaceChild("stubbylegs", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition leftleg_r1 = stubbylegs.addOrReplaceChild("leftleg_r1",
				CubeListBuilder.create().texOffs(24, 21).addBox(-3.0F, -4.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition rightlegs = partdefinition.addOrReplaceChild("rightlegs", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition rightleg_r1 = rightlegs.addOrReplaceChild("rightleg_r1",
				CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, -4.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
		leftwing.render(poseStack, buffer, packedLight, packedOverlay);
		rightwing.render(poseStack, buffer, packedLight, packedOverlay);
		stubbylegs.render(poseStack, buffer, packedLight, packedOverlay);
		rightlegs.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightlegs.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.stubbylegs.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leftwing.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.rightwing.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
