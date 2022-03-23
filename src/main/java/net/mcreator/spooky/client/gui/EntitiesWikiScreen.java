
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

import net.mcreator.spooky.world.inventory.EntitiesWikiMenu;
import net.mcreator.spooky.procedures.SandgoblinNotKilledProcedure;
import net.mcreator.spooky.procedures.SandgoblinKilledProcedure;
import net.mcreator.spooky.procedures.OstrichNotKilledProcedure;
import net.mcreator.spooky.procedures.OstrichKilledProcedure;
import net.mcreator.spooky.procedures.NaturalEssenceNotKilledProcedure;
import net.mcreator.spooky.procedures.NaturalEssenceKilledProcedure;
import net.mcreator.spooky.procedures.GoatNotKilledProcedure;
import net.mcreator.spooky.procedures.GoatKilledProcedure;
import net.mcreator.spooky.procedures.BoarNotKilledProcedure;
import net.mcreator.spooky.procedures.BoarKilledProcedure;
import net.mcreator.spooky.procedures.AnimeCowNotKilledProcedure;
import net.mcreator.spooky.procedures.AnimeCowKilledProcedure;
import net.mcreator.spooky.procedures.AngryChickenNotKilledProcedure;
import net.mcreator.spooky.procedures.AngryChickenKilledProcedure;
import net.mcreator.spooky.network.EntitiesWikiButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class EntitiesWikiScreen extends AbstractContainerScreen<EntitiesWikiMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public EntitiesWikiScreen(EntitiesWikiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 435;
		this.imageHeight = 230;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/entities_wiki.png");

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
		this.blit(ms, this.leftPos + 73, this.topPos + 21, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/druiddust.png"));
		this.blit(ms, this.leftPos + 172, this.topPos + 21, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "Entities", 172, 3, -13421773);
		this.font.draw(poseStack, "Plains = PL", 1, 3, -12829636);
		this.font.draw(poseStack, "PL", 10, 39, -12829636);
		this.font.draw(poseStack, "Forest = FO", 1, 12, -12829636);
		this.font.draw(poseStack, "Hot Places = HP", 253, 3, -12829636);
		this.font.draw(poseStack, "Cold Places = CP", 253, 12, -12829636);
		this.font.draw(poseStack, "Water = WA", 352, 3, -12829636);
		this.font.draw(poseStack, "PL", 10, 66, -12829636);
		this.font.draw(poseStack, "FO", 10, 93, -12829636);
		this.font.draw(poseStack, "HP", 10, 120, -12829636);
		this.font.draw(poseStack, "HP", 10, 174, -12829636);
		this.font.draw(poseStack, "WA", 10, 147, -12829636);
		if (AngryChickenNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 37, 39, -12829636);
		if (AnimeCowNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 37, 66, -12829636);
		if (OstrichNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 37, 174, -12829636);
		if (BoarNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 37, 93, -12829636);
		if (SandgoblinNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 37, 120, -12829636);
		if (NaturalEssenceNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 37, 147, -12829636);
		if (GoatNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 163, 39, -12829636);
		this.font.draw(poseStack, "PL", 145, 39, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 28, this.topPos + 39, 93, 20, new TextComponent("Angry Chicken"), e -> {
			if (AngryChickenKilledProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EntitiesWikiButtonMessage(0, x, y, z));
				EntitiesWikiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (AngryChickenKilledProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 28, this.topPos + 66, 72, 20, new TextComponent("Anime Cow"), e -> {
			if (AnimeCowKilledProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EntitiesWikiButtonMessage(1, x, y, z));
				EntitiesWikiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (AnimeCowKilledProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 28, this.topPos + 174, 61, 20, new TextComponent("Ostrich"), e -> {
			if (OstrichKilledProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EntitiesWikiButtonMessage(2, x, y, z));
				EntitiesWikiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (OstrichKilledProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 28, this.topPos + 93, 46, 20, new TextComponent("Boar"), e -> {
			if (BoarKilledProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EntitiesWikiButtonMessage(3, x, y, z));
				EntitiesWikiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (BoarKilledProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 28, this.topPos + 120, 87, 20, new TextComponent("Sand  Goblin"), e -> {
			if (SandgoblinKilledProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EntitiesWikiButtonMessage(4, x, y, z));
				EntitiesWikiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SandgoblinKilledProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 28, this.topPos + 147, 103, 20, new TextComponent("Natural Essence"), e -> {
			if (NaturalEssenceKilledProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EntitiesWikiButtonMessage(5, x, y, z));
				EntitiesWikiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (NaturalEssenceKilledProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 163, this.topPos + 39, 46, 20, new TextComponent("Goat"), e -> {
			if (GoatKilledProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new EntitiesWikiButtonMessage(6, x, y, z));
				EntitiesWikiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (GoatKilledProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
