
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spooky.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpookyModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("spooky", "goblinhurt"), new SoundEvent(new ResourceLocation("spooky", "goblinhurt")));
		REGISTRY.put(new ResourceLocation("spooky", "goblindies"), new SoundEvent(new ResourceLocation("spooky", "goblindies")));
		REGISTRY.put(new ResourceLocation("spooky", "sao_death"), new SoundEvent(new ResourceLocation("spooky", "sao_death")));
		REGISTRY.put(new ResourceLocation("spooky", "sao_bossfight"), new SoundEvent(new ResourceLocation("spooky", "sao_bossfight")));
		REGISTRY.put(new ResourceLocation("spooky", "sao_first_town"), new SoundEvent(new ResourceLocation("spooky", "sao_first_town")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
