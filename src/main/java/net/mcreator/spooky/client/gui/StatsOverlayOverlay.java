
package net.mcreator.spooky.client.gui;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.spooky.procedures.StatsOverlayDisplayOverlayIngameProcedure;
import net.mcreator.spooky.network.SpookyModVariables;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class StatsOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
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
			if (StatsOverlayDisplayOverlayIngameProcedure.execute(entity)) {
				Minecraft
						.getInstance().font
								.draw(event.getMatrixStack(),
										"" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new SpookyModVariables.PlayerVariables())).HotPlacesExp) + "",
										posX + -198, posY + -22, -13261);
				Minecraft
						.getInstance().font
								.draw(event.getMatrixStack(),
										"" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new SpookyModVariables.PlayerVariables())).playerEXPneeded) + "",
										posX + -171, posY + -22, -13261);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), "/", posX + -180, posY + -22, -13261);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), "Hot Places:", posX + -198, posY + -31, -13312);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), "Plains:", posX + -198, posY + -58, -13382656);
				Minecraft
						.getInstance().font
								.draw(event.getMatrixStack(),
										"" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new SpookyModVariables.PlayerVariables())).PlainsEXP) + "",
										posX + -198, posY + -49, -13382656);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), "/", posX + -171, posY + -49, -13382656);
				Minecraft
						.getInstance().font
								.draw(event.getMatrixStack(),
										"" + (int) ((entity.getCapability(SpookyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new SpookyModVariables.PlayerVariables())).PlainsEXPNeeded) + "",
										posX + -162, posY + -49, -16724992);
			}
		}
	}
}
