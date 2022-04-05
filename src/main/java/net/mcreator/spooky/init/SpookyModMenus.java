
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spooky.init;

import net.minecraftforge.fmllegacy.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.spooky.world.inventory.WikipediaMenu;
import net.mcreator.spooky.world.inventory.WaterSpawnomaticMenu;
import net.mcreator.spooky.world.inventory.SandgoblinWikiMenu;
import net.mcreator.spooky.world.inventory.PlainsSpawnomaticMenu;
import net.mcreator.spooky.world.inventory.PinguWikiMenu;
import net.mcreator.spooky.world.inventory.OstrichWikiMenu;
import net.mcreator.spooky.world.inventory.NatureEssenceWikiMenu;
import net.mcreator.spooky.world.inventory.MarketMenu;
import net.mcreator.spooky.world.inventory.HotPlacesSpawnomaticMenu;
import net.mcreator.spooky.world.inventory.GoatWikiMenu;
import net.mcreator.spooky.world.inventory.ForestSpawnomaticMenu;
import net.mcreator.spooky.world.inventory.EquipmentTabMenu;
import net.mcreator.spooky.world.inventory.EntitiesWikiMenu;
import net.mcreator.spooky.world.inventory.ColdPlacesSpawnOMaticMenu;
import net.mcreator.spooky.world.inventory.BoarWikiMenu;
import net.mcreator.spooky.world.inventory.BiomesMenu;
import net.mcreator.spooky.world.inventory.AugmentEquipMenu;
import net.mcreator.spooky.world.inventory.AnimeCowWikiMenu;
import net.mcreator.spooky.world.inventory.AngryChickenWikiMenu;
import net.mcreator.spooky.world.inventory.AltarGUIMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpookyModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<WikipediaMenu> WIKIPEDIA = register("wikipedia", (id, inv, extraData) -> new WikipediaMenu(id, inv, extraData));
	public static final MenuType<EntitiesWikiMenu> ENTITIES_WIKI = register("entities_wiki",
			(id, inv, extraData) -> new EntitiesWikiMenu(id, inv, extraData));
	public static final MenuType<AngryChickenWikiMenu> ANGRY_CHICKEN_WIKI = register("angry_chicken_wiki",
			(id, inv, extraData) -> new AngryChickenWikiMenu(id, inv, extraData));
	public static final MenuType<AnimeCowWikiMenu> ANIME_COW_WIKI = register("anime_cow_wiki",
			(id, inv, extraData) -> new AnimeCowWikiMenu(id, inv, extraData));
	public static final MenuType<MarketMenu> MARKET = register("market", (id, inv, extraData) -> new MarketMenu(id, inv, extraData));
	public static final MenuType<EquipmentTabMenu> EQUIPMENT_TAB = register("equipment_tab",
			(id, inv, extraData) -> new EquipmentTabMenu(id, inv, extraData));
	public static final MenuType<AugmentEquipMenu> AUGMENT_EQUIP = register("augment_equip",
			(id, inv, extraData) -> new AugmentEquipMenu(id, inv, extraData));
	public static final MenuType<OstrichWikiMenu> OSTRICH_WIKI = register("ostrich_wiki",
			(id, inv, extraData) -> new OstrichWikiMenu(id, inv, extraData));
	public static final MenuType<BoarWikiMenu> BOAR_WIKI = register("boar_wiki", (id, inv, extraData) -> new BoarWikiMenu(id, inv, extraData));
	public static final MenuType<SandgoblinWikiMenu> SANDGOBLIN_WIKI = register("sandgoblin_wiki",
			(id, inv, extraData) -> new SandgoblinWikiMenu(id, inv, extraData));
	public static final MenuType<PlainsSpawnomaticMenu> PLAINS_SPAWNOMATIC = register("plains_spawnomatic",
			(id, inv, extraData) -> new PlainsSpawnomaticMenu(id, inv, extraData));
	public static final MenuType<HotPlacesSpawnomaticMenu> HOT_PLACES_SPAWNOMATIC = register("hot_places_spawnomatic",
			(id, inv, extraData) -> new HotPlacesSpawnomaticMenu(id, inv, extraData));
	public static final MenuType<NatureEssenceWikiMenu> NATURE_ESSENCE_WIKI = register("nature_essence_wiki",
			(id, inv, extraData) -> new NatureEssenceWikiMenu(id, inv, extraData));
	public static final MenuType<GoatWikiMenu> GOAT_WIKI = register("goat_wiki", (id, inv, extraData) -> new GoatWikiMenu(id, inv, extraData));
	public static final MenuType<AltarGUIMenu> ALTAR_GUI = register("altar_gui", (id, inv, extraData) -> new AltarGUIMenu(id, inv, extraData));
	public static final MenuType<WaterSpawnomaticMenu> WATER_SPAWNOMATIC = register("water_spawnomatic",
			(id, inv, extraData) -> new WaterSpawnomaticMenu(id, inv, extraData));
	public static final MenuType<ForestSpawnomaticMenu> FOREST_SPAWNOMATIC = register("forest_spawnomatic",
			(id, inv, extraData) -> new ForestSpawnomaticMenu(id, inv, extraData));
	public static final MenuType<ColdPlacesSpawnOMaticMenu> COLD_PLACES_SPAWN_O_MATIC = register("cold_places_spawn_o_matic",
			(id, inv, extraData) -> new ColdPlacesSpawnOMaticMenu(id, inv, extraData));
	public static final MenuType<BiomesMenu> BIOMES = register("biomes", (id, inv, extraData) -> new BiomesMenu(id, inv, extraData));
	public static final MenuType<PinguWikiMenu> PINGU_WIKI = register("pingu_wiki", (id, inv, extraData) -> new PinguWikiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
