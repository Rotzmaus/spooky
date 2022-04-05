
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

import net.mcreator.spooky.world.inventory.ColdPlacesSpawnOMaticMenu;
import net.mcreator.spooky.procedures.ActiveCPCanGoBiggerProcedure;
import net.mcreator.spooky.procedures.ActiveCPBiggerZeroProcedure;
import net.mcreator.spooky.network.SpookyModVariables;
import net.mcreator.spooky.network.ColdPlacesSpawnOMaticButtonMessage;
import net.mcreator.spooky.SpookyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ColdPlacesSpawnOMaticScreen extends AbstractContainerScreen<ColdPlacesSpawnOMaticMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ColdPlacesSpawnOMaticScreen(ColdPlacesSpawnOMaticMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("spooky:textures/cold_places_spawn_o_matic.png");

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
				.orElse(new SpookyModVariables.PlayerVariables())).ActiveCPLevel) + "", 210, 7, -16724788);
		this.font.draw(poseStack, "Active Cold Places Level:", 77, 6, -12829636);
		this.font.draw(poseStack, "Cold Places Exp:", 5, 123, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ColdPLacesEXP) + "", 90, 123, -16724788);
		this.font.draw(poseStack, "/", 104, 123, -16724788);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ColdPlacesEXPNeeded) + "", 109, 123, -16724788);
		this.font.draw(poseStack, "Cold Places Lvl:", 5, 141, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SpookyModVariables.PlayerVariables())).ColdPLacesLevel) + "", 90, 141, -16724788);
		this.font.draw(poseStack, "EXP", 85, 156, -16724788);
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
		this.addRenderableWidget(new Button(this.leftPos + 2, this.topPos + 176, 129, 20, new TextComponent("Convert ClodPlaces Drops"), e -> {
			if (true) {
				SpookyMod.PACKET_HANDLER.sendToServer(new ColdPlacesSpawnOMaticButtonMessage(0, x, y, z));
				ColdPlacesSpawnOMaticButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 45, this.topPos + 7, 30, 20, new TextComponent("<"), e -> {
			if (ActiveCPBiggerZeroProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new ColdPlacesSpawnOMaticButtonMessage(1, x, y, z));
				ColdPlacesSpawnOMaticButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ActiveCPBiggerZeroProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 242, this.topPos + 6, 30, 20, new TextComponent(">"), e -> {
			if (ActiveCPCanGoBiggerProcedure.execute(entity)) {
				SpookyMod.PACKET_HANDLER.sendToServer(new ColdPlacesSpawnOMaticButtonMessage(2, x, y, z));
				ColdPlacesSpawnOMaticButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ActiveCPCanGoBiggerProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
