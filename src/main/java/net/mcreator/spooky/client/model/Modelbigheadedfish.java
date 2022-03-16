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
public class Modelbigheadedfish<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("spooky", "modelbigheadedfish"), "main");
	public final ModelPart Front;
	public final ModelPart Mid;
	public final ModelPart back;

	public Modelbigheadedfish(ModelPart root) {
		this.Front = root.getChild("Front");
		this.Mid = root.getChild("Mid");
		this.back = root.getChild("back");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Front = partdefinition.addOrReplaceChild("Front",
				CubeListBuilder.create().texOffs(26, 10).addBox(-1.0F, -1.25F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 9)
						.addBox(-2.0F, -2.75F, -6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(30, 12)
						.addBox(0.5F, -1.75F, -6.25F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(30, 7)
						.addBox(-1.5F, -1.75F, -6.25F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 11)
						.addBox(-1.25F, 0.25F, -6.25F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(-1.25F, 1.05F, -6.25F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.0F, 1.0F));
		PartDefinition Mid = partdefinition
				.addOrReplaceChild("Mid",
						CubeListBuilder.create().texOffs(0, 15).addBox(-1.25F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
								.texOffs(0, 25).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 22.0F, 3.0F));
		PartDefinition back = partdefinition.addOrReplaceChild("back",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(26, 0)
						.addBox(-0.75F, -1.5F, 3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 0)
						.addBox(0.25F, -1.0F, 5.0F, -1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.0F, 6.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		Front.render(poseStack, buffer, packedLight, packedOverlay);
		Mid.render(poseStack, buffer, packedLight, packedOverlay);
		back.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Front.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Front.xRot = headPitch / (180F / (float) Math.PI);
		this.back.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
