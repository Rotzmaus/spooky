
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spooky.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class SpookyModTabs {
	public static CreativeModeTab TAB_ENTITIES;
	public static CreativeModeTab TAB_MOD_ITEMS;

	public static void load() {
		TAB_ENTITIES = new CreativeModeTab("tabentities") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.FOX_SPAWN_EGG);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_MOD_ITEMS = new CreativeModeTab("tabmod_items") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.FEATHER);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
