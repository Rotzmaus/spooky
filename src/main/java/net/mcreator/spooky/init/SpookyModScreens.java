
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spooky.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.spooky.client.gui.WikipediaScreen;
import net.mcreator.spooky.client.gui.SandgoblinWikiScreen;
import net.mcreator.spooky.client.gui.PlainsSpawnomaticScreen;
import net.mcreator.spooky.client.gui.OstrichWikiScreen;
import net.mcreator.spooky.client.gui.NatureEssenceWikiScreen;
import net.mcreator.spooky.client.gui.MarketScreen;
import net.mcreator.spooky.client.gui.HotPlacesSpawnomaticScreen;
import net.mcreator.spooky.client.gui.GoatWikiScreen;
import net.mcreator.spooky.client.gui.EquipmentTabScreen;
import net.mcreator.spooky.client.gui.EntitiesWikiScreen;
import net.mcreator.spooky.client.gui.BoarWikiScreen;
import net.mcreator.spooky.client.gui.AugmentEquipScreen;
import net.mcreator.spooky.client.gui.AnimeCowWikiScreen;
import net.mcreator.spooky.client.gui.AngryChickenWikiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SpookyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SpookyModMenus.WIKIPEDIA, WikipediaScreen::new);
			MenuScreens.register(SpookyModMenus.ENTITIES_WIKI, EntitiesWikiScreen::new);
			MenuScreens.register(SpookyModMenus.ANGRY_CHICKEN_WIKI, AngryChickenWikiScreen::new);
			MenuScreens.register(SpookyModMenus.ANIME_COW_WIKI, AnimeCowWikiScreen::new);
			MenuScreens.register(SpookyModMenus.MARKET, MarketScreen::new);
			MenuScreens.register(SpookyModMenus.EQUIPMENT_TAB, EquipmentTabScreen::new);
			MenuScreens.register(SpookyModMenus.AUGMENT_EQUIP, AugmentEquipScreen::new);
			MenuScreens.register(SpookyModMenus.OSTRICH_WIKI, OstrichWikiScreen::new);
			MenuScreens.register(SpookyModMenus.BOAR_WIKI, BoarWikiScreen::new);
			MenuScreens.register(SpookyModMenus.SANDGOBLIN_WIKI, SandgoblinWikiScreen::new);
			MenuScreens.register(SpookyModMenus.PLAINS_SPAWNOMATIC, PlainsSpawnomaticScreen::new);
			MenuScreens.register(SpookyModMenus.HOT_PLACES_SPAWNOMATIC, HotPlacesSpawnomaticScreen::new);
			MenuScreens.register(SpookyModMenus.NATURE_ESSENCE_WIKI, NatureEssenceWikiScreen::new);
			MenuScreens.register(SpookyModMenus.GOAT_WIKI, GoatWikiScreen::new);
		});
	}
}
