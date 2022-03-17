
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spooky.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.spooky.item.SteelDustItem;
import net.mcreator.spooky.item.SpawnOMaticItem;
import net.mcreator.spooky.item.PlateDustItem;
import net.mcreator.spooky.item.OstrichFeatherItem;
import net.mcreator.spooky.item.IronDustItem;
import net.mcreator.spooky.item.InfernoDustItem;
import net.mcreator.spooky.item.IceDustItem;
import net.mcreator.spooky.item.HolySteelDustItem;
import net.mcreator.spooky.item.DruidSetItem;
import net.mcreator.spooky.item.DruidDustItem;
import net.mcreator.spooky.item.DarkIronDustItem;
import net.mcreator.spooky.item.DamascusDustItem;
import net.mcreator.spooky.item.CuteLeatherItem;
import net.mcreator.spooky.item.ChickenKnifeItem;
import net.mcreator.spooky.item.BronzeSwordItem;
import net.mcreator.spooky.item.BronzeShovelItem;
import net.mcreator.spooky.item.BronzeSetItem;
import net.mcreator.spooky.item.BronzeSetAugItem;
import net.mcreator.spooky.item.BronzePickaxeItem;
import net.mcreator.spooky.item.BronzeHoeItem;
import net.mcreator.spooky.item.BronzeDustItem;
import net.mcreator.spooky.item.BronzeAxeItem;
import net.mcreator.spooky.item.BoarFangItem;
import net.mcreator.spooky.item.AngryFeatherItem;
import net.mcreator.spooky.item.AngelicDustItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpookyModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item SPANKY = register(new SpawnEggItem(SpookyModEntities.SPANKY, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
			.setRegistryName("spanky_spawn_egg"));
	public static final Item OSTRICH = register(
			new SpawnEggItem(SpookyModEntities.OSTRICH, -13421773, -10066330, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("ostrich_spawn_egg"));
	public static final Item SANDGOBLIN = register(
			new SpawnEggItem(SpookyModEntities.SANDGOBLIN, -13312, -6724096, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("sandgoblin_spawn_egg"));
	public static final Item MUMMY = register(
			new SpawnEggItem(SpookyModEntities.MUMMY, -103, -3368704, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("mummy_spawn_egg"));
	public static final Item CACTUS = register(
			new SpawnEggItem(SpookyModEntities.CACTUS, -13395712, -3342592, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("cactus_spawn_egg"));
	public static final Item CWEEPER = register(
			new SpawnEggItem(SpookyModEntities.CWEEPER, -16777216, -16751104, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("cweeper_spawn_egg"));
	public static final Item ANGRY_CHICKEN = register(
			new SpawnEggItem(SpookyModEntities.ANGRY_CHICKEN, -3355444, -39322, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("angry_chicken_spawn_egg"));
	public static final Item MUMMY_DIG_ANIMATION = register(
			new SpawnEggItem(SpookyModEntities.MUMMY_DIG_ANIMATION, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("mummy_dig_animation_spawn_egg"));
	public static final Item ANIME_COW = register(
			new SpawnEggItem(SpookyModEntities.ANIME_COW, -13434880, -26164, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("anime_cow_spawn_egg"));
	public static final Item GOAT = register(
			new SpawnEggItem(SpookyModEntities.GOAT, -3355444, -1, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("goat_spawn_egg"));
	public static final Item BOAR = register(
			new SpawnEggItem(SpookyModEntities.BOAR, -39373, -3381760, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("boar_spawn_egg"));
	public static final Item GORILA = register(
			new SpawnEggItem(SpookyModEntities.GORILA, -13421773, -6750106, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("gorila_spawn_egg"));
	public static final Item SUNFLOWER = register(
			new SpawnEggItem(SpookyModEntities.SUNFLOWER, -16738048, -3355648, new Item.Properties().tab(SpookyModTabs.TAB_ENTITIES))
					.setRegistryName("sunflower_spawn_egg"));
	public static final Item ANGRY_FEATHER = register(new AngryFeatherItem());
	public static final Item CUTE_LEATHER = register(new CuteLeatherItem());
	public static final Item BRONZE_DUST = register(new BronzeDustItem());
	public static final Item DRUID_DUST = register(new DruidDustItem());
	public static final Item INFERNO_DUST = register(new InfernoDustItem());
	public static final Item DAMASCUS_DUST = register(new DamascusDustItem());
	public static final Item IRON_DUST = register(new IronDustItem());
	public static final Item STEEL_DUST = register(new SteelDustItem());
	public static final Item ANGELIC_DUST = register(new AngelicDustItem());
	public static final Item HOLY_STEEL_DUST = register(new HolySteelDustItem());
	public static final Item DARK_IRON_DUST = register(new DarkIronDustItem());
	public static final Item PLATE_DUST = register(new PlateDustItem());
	public static final Item ICE_DUST = register(new IceDustItem());
	public static final Item BRONZE_SWORD = register(new BronzeSwordItem());
	public static final Item BRONZE_SET_HELMET = register(new BronzeSetItem.Helmet());
	public static final Item BRONZE_SET_CHESTPLATE = register(new BronzeSetItem.Chestplate());
	public static final Item BRONZE_SET_LEGGINGS = register(new BronzeSetItem.Leggings());
	public static final Item BRONZE_SET_BOOTS = register(new BronzeSetItem.Boots());
	public static final Item CHICKEN_KNIFE = register(new ChickenKnifeItem());
	public static final Item BRONZE_SET_AUG_HELMET = register(new BronzeSetAugItem.Helmet());
	public static final Item BRONZE_SET_AUG_CHESTPLATE = register(new BronzeSetAugItem.Chestplate());
	public static final Item BRONZE_SET_AUG_BOOTS = register(new BronzeSetAugItem.Boots());
	public static final Item OSTRICH_FEATHER = register(new OstrichFeatherItem());
	public static final Item BOAR_FANG = register(new BoarFangItem());
	public static final Item FISH = register(
			new SpawnEggItem(SpookyModEntities.FISH, -26215, -3355444, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("fish_spawn_egg"));
	public static final Item SPAWN_O_MATIC = register(new SpawnOMaticItem());
	public static final Item BRONZE_PICKAXE = register(new BronzePickaxeItem());
	public static final Item BRONZE_AXE = register(new BronzeAxeItem());
	public static final Item BRONZE_SHOVEL = register(new BronzeShovelItem());
	public static final Item BRONZE_HOE = register(new BronzeHoeItem());
	public static final Item DRUID_SET_HELMET = register(new DruidSetItem.Helmet());
	public static final Item DRUID_SET_CHESTPLATE = register(new DruidSetItem.Chestplate());
	public static final Item DRUID_SET_LEGGINGS = register(new DruidSetItem.Leggings());
	public static final Item DRUID_SET_BOOTS = register(new DruidSetItem.Boots());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
