package net.mcreator.spooky.client.model;

import net.minecraft.world.entity.Entity;
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
public class Modelnatureessence<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("spooky", "modelnatureessence"), "main");
	public final ModelPart Head;
	public final ModelPart body;
	public final ModelPart layer;

	public Modelnatureessence(ModelPart root) {
		this.Head = root.getChild("Head");
		this.body = root.getChild("body");
		this.layer = root.getChild("layer");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(44, 48).addBox(-5.0F, -8.0F, -4.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.0F, -5.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 86)
						.addBox(-3.0F, -6.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 3.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(66, 14).addBox(-3.0F, -21.0F, -2.0F, 5.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(49, 0)
						.addBox(-6.0F, -21.0F, -3.0F, 11.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(37, 66)
						.addBox(-4.0F, -14.0F, -3.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition layer = partdefinition.addOrReplaceChild(
				"layer", CubeListBuilder.create().texOffs(0, 48).addBox(-6.0F, -14.0F, -5.0F, 11.0F, 14.0F, 11.0F, new CubeDeformation(0.0F))
						.texOffs(0, 0).addBox(-8.0F, -31.0F, -8.0F, 16.0F, 31.0F, 17.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		layer.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}
