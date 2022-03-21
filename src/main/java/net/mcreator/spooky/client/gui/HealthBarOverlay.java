
package net.mcreator.spooky.client.gui;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.spooky.procedures.Frame9Procedure;
import net.mcreator.spooky.procedures.Frame8Procedure;
import net.mcreator.spooky.procedures.Frame7Procedure;
import net.mcreator.spooky.procedures.Frame6Procedure;
import net.mcreator.spooky.procedures.Frame5Procedure;
import net.mcreator.spooky.procedures.Frame4Procedure;
import net.mcreator.spooky.procedures.Frame3Procedure;
import net.mcreator.spooky.procedures.Frame2Procedure;
import net.mcreator.spooky.procedures.Frame20Procedure;
import net.mcreator.spooky.procedures.Frame1Procedure;
import net.mcreator.spooky.procedures.Frame19Procedure;
import net.mcreator.spooky.procedures.Frame18Procedure;
import net.mcreator.spooky.procedures.Frame17Procedure;
import net.mcreator.spooky.procedures.Frame16Procedure;
import net.mcreator.spooky.procedures.Frame15Procedure;
import net.mcreator.spooky.procedures.Frame14Procedure;
import net.mcreator.spooky.procedures.Frame13Procedure;
import net.mcreator.spooky.procedures.Frame12Procedure;
import net.mcreator.spooky.procedures.Frame11Procedure;
import net.mcreator.spooky.procedures.Frame10Procedure;
import net.mcreator.spooky.procedures.Expframe9Procedure;
import net.mcreator.spooky.procedures.Expframe8Procedure;
import net.mcreator.spooky.procedures.Expframe7Procedure;
import net.mcreator.spooky.procedures.Expframe6Procedure;
import net.mcreator.spooky.procedures.Expframe5Procedure;
import net.mcreator.spooky.procedures.Expframe4Procedure;
import net.mcreator.spooky.procedures.Expframe3Procedure;
import net.mcreator.spooky.procedures.Expframe2Procedure;
import net.mcreator.spooky.procedures.Expframe20Procedure;
import net.mcreator.spooky.procedures.Expframe1Procedure;
import net.mcreator.spooky.procedures.Expframe19Procedure;
import net.mcreator.spooky.procedures.Expframe18Procedure;
import net.mcreator.spooky.procedures.Expframe17Procedure;
import net.mcreator.spooky.procedures.Expframe16Procedure;
import net.mcreator.spooky.procedures.Expframe15Procedure;
import net.mcreator.spooky.procedures.Expframe14Procedure;
import net.mcreator.spooky.procedures.Expframe13Procedure;
import net.mcreator.spooky.procedures.Expframe12Procedure;
import net.mcreator.spooky.procedures.Expframe11Procedure;
import net.mcreator.spooky.procedures.Expframe10Procedure;
import net.mcreator.spooky.network.SpookyModVariables;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class HealthBarOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.level;
				_x = entity.getX();
				_y = entity.getY();
				_z = entity.getZ();
			}
			Level world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (true) {
				if (Frame1Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame1.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame2Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame2.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame3Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame3.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame4Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame4.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame5Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame5.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame6Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame6.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame7Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame7.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame8Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame8.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame9Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame9.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame10Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame10.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame11Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame11.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame12Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame12.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame13Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame13.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame14Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame14.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame15Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame15.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame16Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame16.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame17Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame17.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame18Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame18.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame19Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame19.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Frame20Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/frame20.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -91, posY + 51, 0, 0, 64, 16, 64, 16);
				}
				if (Expframe1Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe1.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe2Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe2.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe3Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe3.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe4Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe4.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe5Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe5.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe6Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe6.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe7Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe7.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe8Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe8.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe9Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe9.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe10Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe10.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe11Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe11.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe12Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe12.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe13Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe13.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe14Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe14.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe15Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe15.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe16Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe16.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe17Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe17.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe18Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe18.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe19Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe19.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				if (Expframe20Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("spooky:textures/expframe20.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -28, posY + 60, 0, 0, 32, 8, 32, 8);
				}
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SpookyModVariables.PlayerVariables())).playerEXP) + "",
						posX + 5, posY + 60, -16777216);
				Minecraft
						.getInstance().font
								.draw(event.getMatrixStack(),
										"" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new SpookyModVariables.PlayerVariables())).playerEXPneeded) + "",
										posX + 42, posY + 59, -16777216);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), "/", posX + 35, posY + 60, -16777216);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SpookyModVariables.PlayerVariables())).playerLevel) + "",
						posX + -7, posY + 47, -13312);
				Minecraft.getInstance().font
						.draw(event.getMatrixStack(),
								"" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPointsMax) + "",
								posX + -59, posY + 56, -16777216);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), "/", posX + -65, posY + 56, -16777216);
				Minecraft.getInstance().font
						.draw(event.getMatrixStack(),
								"" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SpookyModVariables.PlayerVariables())).effectiveHealthPoints) + "",
								posX + -88, posY + 55, -16777216);
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
