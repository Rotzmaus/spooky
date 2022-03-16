
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

import net.mcreator.spooky.world.inventory.SandgoblinWikiMenu;
import net.mcreator.spooky.network.SandgoblinWikiButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SandgoblinWikiScreen extends AbstractContainerScreen<SandgoblinWikiMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public SandgoblinWikiScreen(SandgoblinWikiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 135;
		this.imageHeight = 180;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/sandgoblin_wiki.png");

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
		this.blit(ms, this.leftPos + 28, this.topPos + 137, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "Sand Goblin", 37, 6, -12829636);
		this.font.draw(poseStack, "A Dirty Goblin which-", 8, 25, -12829636);
		this.font.draw(poseStack, "health:", 8, 93, -12829636);
		this.font.draw(poseStack, "Armor:", 9, 105, -12829636);
		this.font.draw(poseStack, "Regen Level:", 9, 118, -12829636);
		this.font.draw(poseStack, "1.2", 9, 143, -12829636);
		this.font.draw(poseStack, "Spawns in Hot places", 4, 65, -12829636);
		this.font.draw(poseStack, "/Kill", 48, 142, -12829636);
		this.font.draw(poseStack, "null", 73, 118, -12829636);
		this.font.draw(poseStack, "20", 43, 106, -12829636);
		this.font.draw(poseStack, "50", 44, 92, -12829636);
		this.font.draw(poseStack, "spawns at night.", 7, 38, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 78, this.topPos + 155, 46, 20, new TextComponent("Back"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new SandgoblinWikiButtonMessage(0, x, y, z));
				SandgoblinWikiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
