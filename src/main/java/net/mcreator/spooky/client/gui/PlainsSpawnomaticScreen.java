
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

import net.mcreator.spooky.world.inventory.PlainsSpawnomaticMenu;
import net.mcreator.spooky.procedures.GoatNotKilledProcedure;
import net.mcreator.spooky.procedures.GoatKilledProcedure;
import net.mcreator.spooky.procedures.AnimeCowNotKilledProcedure;
import net.mcreator.spooky.procedures.AnimeCowKilledProcedure;
import net.mcreator.spooky.procedures.AngryChickenNotKilledProcedure;
import net.mcreator.spooky.procedures.AngryChickenKilledProcedure;
import net.mcreator.spooky.procedures.ActivePlainsLevel2Procedure;
import net.mcreator.spooky.procedures.ActivePlainsLevel1Procedure;
import net.mcreator.spooky.procedures.ActivePlainsLevel0Procedure;
import net.mcreator.spooky.procedures.ActivePlainsCanGoBiggerProcedure;
import net.mcreator.spooky.procedures.ActivePlainsBiggerThanZeroProcedure;
import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.network.PlainsSpawnomaticButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PlainsSpawnomaticScreen extends AbstractContainerScreen<PlainsSpawnomaticMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PlainsSpawnomaticScreen(PlainsSpawnomaticMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/plains_spawnomatic.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/arrow.png"));
		this.blit(ms, this.leftPos + 43, this.topPos + 153, 0, 0, 38, 16, 38, 16);

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
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ActivePlainsLevel) + "", 186, 8, -16724992);
		this.font.draw(poseStack, "Active Plains Level:", 79, 8, -12829636);
		this.font.draw(poseStack, "Plains EXP:", 4, 124, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).PlainsEXP) + "", 64, 124, -16724992);
		this.font.draw(poseStack, "/", 92, 124, -16724992);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).PlainsEXPNeeded) + "", 97, 125, -16738048);
		this.font.draw(poseStack, "Plains Lvl:", 4, 137, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).PlainsLevel) + "", 64, 138, -16724992);
		this.font.draw(poseStack, "EXP", 85, 156, -16724992);
		if (AngryChickenKilledProcedure.execute(entity))
			this.font.draw(poseStack, "Angry Chicken", 32, 33, -12829636);
		if (AngryChickenNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 32, 33, -12829636);
		if (ActivePlainsLevel0Procedure.execute(entity))
			this.font.draw(poseStack, "70%", 14, 33, -12829636);
		if (AnimeCowKilledProcedure.execute(entity))
			this.font.draw(poseStack, "Anime Cow", 32, 51, -12829636);
		if (AnimeCowNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 32, 51, -12829636);
		if (ActivePlainsLevel0Procedure.execute(entity))
			this.font.draw(poseStack, "30%", 14, 51, -12829636);
		if (ActivePlainsLevel1Procedure.execute(entity))
			this.font.draw(poseStack, "55%", 14, 33, -12829636);
		if (ActivePlainsLevel1Procedure.execute(entity))
			this.font.draw(poseStack, "40%", 14, 51, -12829636);
		if (ActivePlainsLevel1Procedure.execute(entity))
			this.font.draw(poseStack, "5%", 14, 69, -12829636);
		if (ActivePlainsLevel2Procedure.execute(entity))
			this.font.draw(poseStack, "40%", 14, 33, -12829636);
		if (ActivePlainsLevel2Procedure.execute(entity))
			this.font.draw(poseStack, "45%", 14, 51, -12829636);
		if (ActivePlainsLevel2Procedure.execute(entity))
			this.font.draw(poseStack, "15%", 14, 69, -12829636);
		if (GoatNotKilledProcedure.execute(entity))
			this.font.draw(poseStack, "???", 32, 69, -12829636);
		if (GoatKilledProcedure.execute(entity))
			this.font.draw(poseStack, "Goat", 32, 69, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 2, this.topPos + 176, 129, 20, new TextComponent("Convert Plains Drops"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new PlainsSpawnomaticButtonMessage(0, x, y, z));
				PlainsSpawnomaticButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 45, this.topPos + 7, 30, 20, new TextComponent("<"), e -> {
			if (ActivePlainsBiggerThanZeroProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new PlainsSpawnomaticButtonMessage(1, x, y, z));
				PlainsSpawnomaticButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ActivePlainsBiggerThanZeroProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 242, this.topPos + 6, 30, 20, new TextComponent(">"), e -> {
			if (ActivePlainsCanGoBiggerProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new PlainsSpawnomaticButtonMessage(2, x, y, z));
				PlainsSpawnomaticButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ActivePlainsCanGoBiggerProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
