
package net.mcreator.spooky.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.spooky.world.inventory.AugmentEquipMenu;
import net.mcreator.spooky.network.AugmentEquipButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AugmentEquipScreen extends AbstractContainerScreen<AugmentEquipMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AugmentEquipScreen(AugmentEquipMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 435;
		this.imageHeight = 242;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/augment_equip.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzesword.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 9, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/feather.png"));
		this.blit(ms, this.leftPos + 55, this.topPos + 9, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/chickenknife.png"));
		this.blit(ms, this.leftPos + 82, this.topPos + 9, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/augmentbronzechestplate.png"));
		this.blit(ms, this.leftPos + 82, this.topPos + 45, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzeset_body.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 54, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/plus.png"));
		this.blit(ms, this.leftPos + 27, this.topPos + 60, 0, 0, 8, 8, 8, 8);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/plus.png"));
		this.blit(ms, this.leftPos + 34, this.topPos + 31, 0, 0, 8, 8, 8, 8);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/plus.png"));
		this.blit(ms, this.leftPos + 28, this.topPos + 13, 0, 0, 8, 8, 8, 8);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/cuteleather.png"));
		this.blit(ms, this.leftPos + 55, this.topPos + 54, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/plus.png"));
		this.blit(ms, this.leftPos + 32, this.topPos + 77, 0, 0, 8, 8, 8, 8);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzeset_boots.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 99, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/plus.png"));
		this.blit(ms, this.leftPos + 28, this.topPos + 104, 0, 0, 8, 8, 8, 8);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/plus.png"));
		this.blit(ms, this.leftPos + 32, this.topPos + 121, 0, 0, 8, 8, 8, 8);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/ostrichfeather.png"));
		this.blit(ms, this.leftPos + 55, this.topPos + 99, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/augmentedbronzeboots.png"));
		this.blit(ms, this.leftPos + 82, this.topPos + 99, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzeset_head.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 144, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/plus.png"));
		this.blit(ms, this.leftPos + 29, this.topPos + 148, 0, 0, 8, 8, 8, 8);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/plus.png"));
		this.blit(ms, this.leftPos + 32, this.topPos + 167, 0, 0, 8, 8, 8, 8);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/boarfang.png"));
		this.blit(ms, this.leftPos + 54, this.topPos + 142, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/augbronzeset_head.png"));
		this.blit(ms, this.leftPos + 82, this.topPos + 144, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Augment Bronze Set", 176, 5, -12829636);
		this.font.draw(poseStack, "20x", 37, 14, -12829636);
		this.font.draw(poseStack, "=", 73, 14, -12829636);
		this.font.draw(poseStack, "=", 70, 29, -12829636);
		this.font.draw(poseStack, "20x", 37, 58, -12829636);
		this.font.draw(poseStack, "=", 75, 58, -12829636);
		this.font.draw(poseStack, "=", 70, 75, -12829636);
		this.font.draw(poseStack, "20x", 38, 104, -12829636);
		this.font.draw(poseStack, "=", 73, 104, -12829636);
		this.font.draw(poseStack, "=", 70, 120, -12829636);
		this.font.draw(poseStack, "20x", 40, 148, -12829636);
		this.font.draw(poseStack, "=", 72, 148, -12829636);
		this.font.draw(poseStack, "=", 70, 165, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 298, this.topPos + 206, 30, 20, new TextComponent(">"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 187, this.topPos + 130, 61, 20, new TextComponent("Augment"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new AugmentEquipButtonMessage(1, x, y, z));
				AugmentEquipButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
