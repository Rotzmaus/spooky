
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

import net.mcreator.spooky.world.inventory.MarketMenu;
import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.network.MarketButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MarketScreen extends AbstractContainerScreen<MarketMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MarketScreen(MarketMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 180;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/market.png");

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
		this.blit(ms, this.leftPos + 0, this.topPos + 97, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/druiddust.png"));
		this.blit(ms, this.leftPos + 8, this.topPos + 97, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/infernodust.png"));
		this.blit(ms, this.leftPos + 17, this.topPos + 97, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/damascusdust.png"));
		this.blit(ms, this.leftPos + 26, this.topPos + 97, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/holysteeldust.png"));
		this.blit(ms, this.leftPos + 134, this.topPos + 97, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/darkirondust.png"));
		this.blit(ms, this.leftPos + 152, this.topPos + 97, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/platedust.png"));
		this.blit(ms, this.leftPos + 143, this.topPos + 97, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/angelicdust.png"));
		this.blit(ms, this.leftPos + 161, this.topPos + 97, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "Market", 44, 7, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).Money) + "", 137, 8, -16750849);
		this.font.draw(poseStack, "Money:", 107, 7, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 35, this.topPos + 25, 103, 20, new TextComponent("Craft Equipment"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new MarketButtonMessage(0, x, y, z));
				MarketButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 35, this.topPos + 97, 102, 20, new TextComponent("Sell Dust"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 35, this.topPos + 133, 103, 20, new TextComponent("Buy Stuff"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 35, this.topPos + 61, 103, 20, new TextComponent("Augment Equipment"), e -> {
		}));
	}
}
