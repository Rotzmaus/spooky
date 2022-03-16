
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spooky.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.spooky.client.model.Modelnewversionostrich;
import net.mcreator.spooky.client.model.Modelgorilla;
import net.mcreator.spooky.client.model.Modelcactus_small;
import net.mcreator.spooky.client.model.Modelbigheadedfish;
import net.mcreator.spooky.client.model.ModelSunflower;
import net.mcreator.spooky.client.model.ModelGoblin;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SpookyModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelnewversionostrich.LAYER_LOCATION, Modelnewversionostrich::createBodyLayer);
		event.registerLayerDefinition(ModelSunflower.LAYER_LOCATION, ModelSunflower::createBodyLayer);
		event.registerLayerDefinition(Modelgorilla.LAYER_LOCATION, Modelgorilla::createBodyLayer);
		event.registerLayerDefinition(ModelGoblin.LAYER_LOCATION, ModelGoblin::createBodyLayer);
		event.registerLayerDefinition(Modelcactus_small.LAYER_LOCATION, Modelcactus_small::createBodyLayer);
		event.registerLayerDefinition(Modelbigheadedfish.LAYER_LOCATION, Modelbigheadedfish::createBodyLayer);
	}
}
