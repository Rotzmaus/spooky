
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

import net.mcreator.spooky.world.inventory.WikipediaMenu;
import net.mcreator.spooky.network.WikipediaButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WikipediaScreen extends AbstractContainerScreen<WikipediaMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public WikipediaScreen(WikipediaMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/wikipedia.png");

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
		this.font.draw(poseStack, "Wiki", 78, 6, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 51, 67, 20, new TextComponent("Entities"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new WikipediaButtonMessage(0, x, y, z));
				WikipediaButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 96, this.topPos + 60, 56, 20, new TextComponent("Biomes"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new WikipediaButtonMessage(1, x, y, z));
				WikipediaButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 87, 108, 20, new TextComponent("Market (Press M-Key)"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new WikipediaButtonMessage(2, x, y, z));
				WikipediaButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 42, this.topPos + 114, 46, 20, new TextComponent("Dust"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 105, this.topPos + 132, 56, 20, new TextComponent("Bosses"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 141, 72, 20, new TextComponent("Abilities"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 87, this.topPos + 168, 82, 20, new TextComponent("Stat System"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 42, this.topPos + 24, 108, 20, new TextComponent("Mod Introduction"), e -> {
		}));
	}
}
