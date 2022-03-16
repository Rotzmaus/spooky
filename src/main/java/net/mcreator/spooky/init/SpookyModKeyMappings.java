
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spooky.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fmlclient.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.spooky.network.WikiMessage;
import net.mcreator.spooky.network.SpaceMessage;
import net.mcreator.spooky.network.MMessage;
import net.mcreator.spooky.network.BMessage;
import net.mcreator.spooky.SpookyMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SpookyModKeyMappings {
	public static final KeyMapping WIKI = new KeyMapping("key.spooky.wiki", GLFW.GLFW_KEY_I, "key.categories.misc");
	public static final KeyMapping M = new KeyMapping("key.spooky.m", GLFW.GLFW_KEY_M, "key.categories.misc");
	public static final KeyMapping B = new KeyMapping("key.spooky.b", GLFW.GLFW_KEY_B, "key.categories.gameplay");
	public static final KeyMapping SPACE = new KeyMapping("key.spooky.space", GLFW.GLFW_KEY_SPACE, "key.categories.misc");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(WIKI);
		ClientRegistry.registerKeyBinding(M);
		ClientRegistry.registerKeyBinding(B);
		ClientRegistry.registerKeyBinding(SPACE);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == WIKI.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						SpookyMod.PACKET_HANDLER.sendToServer(new WikiMessage(0, 0));
						WikiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == M.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						SpookyMod.PACKET_HANDLER.sendToServer(new MMessage(0, 0));
						MMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == B.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						SpookyMod.PACKET_HANDLER.sendToServer(new BMessage(0, 0));
						BMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == SPACE.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						SpookyMod.PACKET_HANDLER.sendToServer(new SpaceMessage(0, 0));
						SpaceMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
