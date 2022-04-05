
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

import net.mcreator.spooky.world.inventory.ForestSpawnomaticMenu;
import net.mcreator.spooky.procedures.ActiveForestCanGoBiggerProcedure;
import net.mcreator.spooky.procedures.ActiveForestBiggerZeroProcedure;
import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.network.ForestSpawnomaticButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ForestSpawnomaticScreen extends AbstractContainerScreen<ForestSpawnomaticMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ForestSpawnomaticScreen(ForestSpawnomaticMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/forest_spawnomatic.png");

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
				.orElse(new SpookyModVariables.PlayerVariables())).ActiveForestLevel) + "", 186, 8, -16751104);
		this.font.draw(poseStack, "Active Forest Level:", 79, 8, -12829636);
		this.font.draw(poseStack, "Forest EXP:", 4, 124, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ForestEXP) + "", 64, 124, -16751104);
		this.font.draw(poseStack, "/", 92, 124, -16751104);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ForestEXPNeeded) + "", 97, 125, -16751104);
		this.font.draw(poseStack, "Forest Lvl:", 5, 141, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ForestLevel) + "", 64, 138, -16751104);
		this.font.draw(poseStack, "EXP", 85, 156, -16751104);
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
		this.addRenderableWidget(new Button(this.leftPos + 2, this.topPos + 176, 129, 20, new TextComponent("Convert Forest Drops"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new ForestSpawnomaticButtonMessage(0, x, y, z));
				ForestSpawnomaticButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 45, this.topPos + 7, 30, 20, new TextComponent("<"), e -> {
			if (ActiveForestBiggerZeroProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new ForestSpawnomaticButtonMessage(1, x, y, z));
				ForestSpawnomaticButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ActiveForestBiggerZeroProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 242, this.topPos + 6, 30, 20, new TextComponent(">"), e -> {
			if (ActiveForestCanGoBiggerProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new ForestSpawnomaticButtonMessage(2, x, y, z));
				ForestSpawnomaticButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ActiveForestCanGoBiggerProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
