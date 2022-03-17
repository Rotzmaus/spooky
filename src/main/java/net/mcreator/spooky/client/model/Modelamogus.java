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
public class Modelamogus<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("spooky", "modelamogus"), "main");
	public final ModelPart bbb;
	public final ModelPart aaa;
	public final ModelPart bb_main;

	public Modelamogus(ModelPart root) {
		this.bbb = root.getChild("bbb");
		this.aaa = root.getChild("aaa");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bbb = partdefinition.addOrReplaceChild("bbb",
				CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, 19.0F, 0.5F));
		PartDefinition aaa = partdefinition.addOrReplaceChild("aaa",
				CubeListBuilder.create().texOffs(18, 17).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 19.0F, 0.5F));
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -17.0F, -2.0F, 12.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(16, 27)
						.addBox(-4.0F, -16.0F, -3.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 27)
						.addBox(-3.0F, -13.0F, 3.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		bbb.render(poseStack, buffer, packedLight, packedOverlay);
		aaa.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.aaa.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.bbb.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
