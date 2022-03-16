
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

import net.mcreator.spooky.world.inventory.OstrichWikiMenu;
import net.mcreator.spooky.network.OstrichWikiButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class OstrichWikiScreen extends AbstractContainerScreen<OstrichWikiMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public OstrichWikiScreen(OstrichWikiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 125;
		this.imageHeight = 180;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/ostrich_wiki.png");

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
		this.blit(ms, this.leftPos + 31, this.topPos + 133, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/druiddust.png"));
		this.blit(ms, this.leftPos + 31, this.topPos + 147, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "Ostrich", 37, 5, -12829636);
		this.font.draw(poseStack, "A Birdlike creature-", 4, 22, -12829636);
		this.font.draw(poseStack, "health:", 3, 93, -12829636);
		this.font.draw(poseStack, "Armor:", 4, 105, -12829636);
		this.font.draw(poseStack, "Regen Level:", 4, 118, -12829636);
		this.font.draw(poseStack, "0.35", 5, 139, -12829636);
		this.font.draw(poseStack, "Spawns in Hot Places", 3, 76, -12829636);
		this.font.draw(poseStack, "/Kill", 49, 145, -12829636);
		this.font.draw(poseStack, "1", 68, 118, -12829636);
		this.font.draw(poseStack, "15", 38, 106, -12829636);
		this.font.draw(poseStack, "50", 40, 93, -12829636);
		this.font.draw(poseStack, "with grey feathers-", 4, 34, -12829636);
		this.font.draw(poseStack, "and a yellow beak.", 4, 46, -12829636);
		this.font.draw(poseStack, "0.105", 5, 153, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 73, this.topPos + 155, 46, 20, new TextComponent("Back"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new OstrichWikiButtonMessage(0, x, y, z));
				OstrichWikiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
