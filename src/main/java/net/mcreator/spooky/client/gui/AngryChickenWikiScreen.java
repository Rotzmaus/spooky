
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

import net.mcreator.spooky.world.inventory.AngryChickenWikiMenu;
import net.mcreator.spooky.network.AngryChickenWikiButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AngryChickenWikiScreen extends AbstractContainerScreen<AngryChickenWikiMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AngryChickenWikiScreen(AngryChickenWikiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 122;
		this.imageHeight = 159;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/angry_chicken_wiki.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/angry_chicken.png"));
		this.blit(ms, this.leftPos + 52, this.topPos + 16, 0, 0, 64, 32, 64, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/bronzedust.png"));
		this.blit(ms, this.leftPos + 27, this.topPos + 106, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "Angry Chicken:", 24, 3, -12829636);
		this.font.draw(poseStack, "Texture:", 6, 21, -12829636);
		this.font.draw(poseStack, "health:", 6, 57, -12829636);
		this.font.draw(poseStack, "Armor:", 6, 75, -12829636);
		this.font.draw(poseStack, "Regen Level:", 6, 93, -12829636);
		this.font.draw(poseStack, "0.15", 6, 111, -12829636);
		this.font.draw(poseStack, "Plains Biome", 6, 39, -12829636);
		this.font.draw(poseStack, "/Kill", 42, 111, -12829636);
		this.font.draw(poseStack, "1", 69, 93, -12829636);
		this.font.draw(poseStack, "0", 42, 75, -12829636);
		this.font.draw(poseStack, "10", 42, 57, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 62, this.topPos + 128, 46, 20, new TextComponent("Back"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new AngryChickenWikiButtonMessage(0, x, y, z));
				AngryChickenWikiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
