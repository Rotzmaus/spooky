
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

import net.mcreator.spooky.world.inventory.EquipmentTabMenu;
import net.mcreator.spooky.network.EquipmentTabButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class EquipmentTabScreen extends AbstractContainerScreen<EquipmentTabMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public EquipmentTabScreen(EquipmentTabMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 427;
		this.imageHeight = 243;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/equipment_tab.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzedust.png"));
		this.blit(ms, this.leftPos + 33, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzesword.png"));
		this.blit(ms, this.leftPos + 33, this.topPos + 27, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/druiddust.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/infernodust.png"));
		this.blit(ms, this.leftPos + 87, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/damascusdust.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/irondust.png"));
		this.blit(ms, this.leftPos + 141, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/steeldust.png"));
		this.blit(ms, this.leftPos + 168, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/angelicdust.png"));
		this.blit(ms, this.leftPos + 195, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/holysteeldust.png"));
		this.blit(ms, this.leftPos + 222, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/darkirondust.png"));
		this.blit(ms, this.leftPos + 249, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/platedust.png"));
		this.blit(ms, this.leftPos + 276, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/icedust.png"));
		this.blit(ms, this.leftPos + 303, this.topPos + 0, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzeset_head.png"));
		this.blit(ms, this.leftPos + 33, this.topPos + 54, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzeset_body.png"));
		this.blit(ms, this.leftPos + 33, this.topPos + 81, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzeset_leggings.png"));
		this.blit(ms, this.leftPos + 33, this.topPos + 108, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzeset_boots.png"));
		this.blit(ms, this.leftPos + 33, this.topPos + 135, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "24", 6, 84, -12829636);
		this.font.draw(poseStack, "18", 6, 111, -12829636);
		this.font.draw(poseStack, "12", 6, 56, -12829636);
		this.font.draw(poseStack, "10", 6, 137, -12829636);
		this.font.draw(poseStack, "32", 7, 30, -12829636);
		this.font.draw(poseStack, "Press to Buy", 357, 6, -12829636);
		this.font.draw(poseStack, "Input Dust Here!", 293, 163, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 357, this.topPos + 54, 61, 20, new TextComponent("Helmet"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EquipmentTabButtonMessage(0, x, y, z));
				EquipmentTabButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 357, this.topPos + 27, 61, 20, new TextComponent("Sword"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EquipmentTabButtonMessage(1, x, y, z));
				EquipmentTabButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 357, this.topPos + 81, 61, 20, new TextComponent("Chestplate"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EquipmentTabButtonMessage(2, x, y, z));
				EquipmentTabButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 357, this.topPos + 108, 61, 20, new TextComponent("Leggins"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EquipmentTabButtonMessage(3, x, y, z));
				EquipmentTabButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 357, this.topPos + 135, 61, 20, new TextComponent("Boots"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EquipmentTabButtonMessage(4, x, y, z));
				EquipmentTabButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
